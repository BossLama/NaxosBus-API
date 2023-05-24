package de.riemerjonas.api.handlers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import de.riemerjonas.api.APIServer;
import de.riemerjonas.api.key.ApiKey;
import de.riemerjonas.api.key.KeyManager;
import de.riemerjonas.api.reponse.ErrorResponse;
import de.riemerjonas.objects.BusNetwork;
import de.riemerjonas.objects.BusStop;
import de.riemerjonas.objects.JsonAbleRouteConnection;
import de.riemerjonas.objects.RouteConnection;
import de.riemerjonas.other.SystemMessage;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;

public class RouteRequestHandler implements HttpHandler {

    private Gson gson = new Gson();
    private String response = "";

    @Override
    public void handle(HttpExchange t) throws IOException {

        response = handleRequest(t.getRequestURI().toString());

        t.sendResponseHeaders(200, response.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    public String handleRequest(String path){
        if(!path.contains("?")) return "{\"errorMessage\":\"Request in valid\"}";;

        path = path.replace("/api/route?", "");
        path = path.replace("%20", " ");
        path = path.replace("&amp", "&");

        String destination = "";
        String depature = "";
        String apiKey = "";

        String[] stationsParameters =  path.split("&");
        for(String parameter : stationsParameters){
            String stationType = parameter.split("=")[0];
            String stationName = parameter.split("=")[1];

            if(stationType.equalsIgnoreCase("destination")) destination = stationName;
            if(stationType.equalsIgnoreCase("depature")) depature = stationName;
            if(stationType.equalsIgnoreCase("key")) apiKey = stationName;
        }



        if(!KeyManager.isValid(apiKey)){
            SystemMessage.sendError("Unauthorized access to API -> Access denied");
            return "{\"errorMessage\":\"Invalid API-KEY\"}";
        }
        if(destination.isEmpty()) return new ErrorResponse("Attribute destination is missing").getResponse();
        if(depature.isEmpty()) return new ErrorResponse("Attribute depature is missing").getResponse();

        if(BusNetwork.getBusStop(depature) == null) return "{\"errorMessage\":\"Unknown depature\"}";
        if(BusNetwork.getBusStop(destination) == null) return "{\"errorMessage\":\"Unknown destination\"}";

        APIServer.logHandler.createEntry(new Date(), depature, destination, KeyManager.getApiKeyByKey(apiKey));

        BusStop depatureStop = BusNetwork.getBusStop(depature);
        BusStop destinationStop = BusNetwork.getBusStop(destination);

        ArrayList<RouteConnection> route = depatureStop.findShortestPath(destinationStop);

        if(route == null || route.size() == 0){
            return "{\"errorMessage\":\"No connection between stops\"}";
        }

        return new GsonBuilder().create().toJson(routeToJSONAble(route));
    }


    public ArrayList<JsonAbleRouteConnection> routeToJSONAble(ArrayList<RouteConnection> route){

        ArrayList<JsonAbleRouteConnection> jsonArray = new ArrayList<>();
        for(RouteConnection connection : route){
            jsonArray.add(new JsonAbleRouteConnection(connection.getLineID(), connection.getDistance(), connection.getBusStop()));
        }

        return jsonArray;
    }

}
