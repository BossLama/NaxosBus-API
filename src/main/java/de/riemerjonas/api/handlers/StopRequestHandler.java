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
import de.riemerjonas.objects.JAbleBusStop;
import de.riemerjonas.objects.RouteConnection;
import de.riemerjonas.other.SystemMessage;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class StopRequestHandler implements HttpHandler {

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
        if(!path.contains("?")) return "{\"errorMessage\":\"Request is invalid\"}";;

        path = path.replace("/api/stops?", "");
        path = path.replace("%20", " ");

        String apiKey = "";

        String[] stationsParameters =  path.split("&");
        for(String parameter : stationsParameters){
            String stationType = parameter.split("=")[0];
            String stationName = parameter.split("=")[1];

            if(stationType.equalsIgnoreCase("key")) apiKey = stationName;
        }


        if(!KeyManager.isValid(apiKey)){
            SystemMessage.sendError("Unauthorized access to API -> Access denied");
            return "{\"errorMessage\":\"Invalid API-KEY\"}";
        }

        return new Gson().toJson(getAllStops());
    }


    public ArrayList<JAbleBusStop> getAllStops(){
        ArrayList<JAbleBusStop> jAbleBusStops = new ArrayList<>();
        BusNetwork.stops.forEach((s, busStop) -> {
            jAbleBusStops.add(new JAbleBusStop(busStop));
        });

        return jAbleBusStops;
    }
}
