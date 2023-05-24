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
        String busStopName = "";
        String searchTag = "";

        String[] stationsParameters =  path.split("&");
        for(String parameter : stationsParameters){
            String stationType = parameter.split("=")[0];
            String stationName = parameter.split("=")[1];

            if(stationType.equalsIgnoreCase("key")) apiKey = stationName;
            if(stationType.equalsIgnoreCase("search")) searchTag = stationName;
            if(stationType.equalsIgnoreCase("name")) busStopName = stationName;
        }

        if(!KeyManager.isValid(apiKey)){
            SystemMessage.sendError("Unauthorized access to API -> Access denied");
            return "{\"errorMessage\":\"Invalid API-KEY\"}";
        }

        if(!searchTag.isEmpty()){
            String[] searchParameter = searchTag.split("-");
            //WENN ZWEI PARAMETER
            if(searchParameter.length == 2){
                //FALLS MENGE = MULTI
                if(searchParameter[0].equalsIgnoreCase("MULTI")){
                    //WENN NAME GEGEBEN
                    if(!busStopName.isEmpty()) return new Gson().toJson(getMatchingStops(busStopName, searchParameter[1]));
                    //WENN KEIN NAME GEGEBEN
                    return "{\"errorMessage\":\"BusStop required!\"}";
                //FALLS MENGE != MULTI --> SINGLE
                }else{
                    //FALLS NAME GEGEBEN
                    if(!busStopName.isEmpty()) return new Gson().toJson(getMatchingBusStop(busStopName, searchParameter[1]));
                    //WENN NICHT GEGEBEN
                    return "{\"errorMessage\":\"BusStop required!\"}";
                }
            //WENN EIN ODER MEHR PARAMETER --> EIN PARAMETER
            }else {
                //FALLS NAME GEGEBEN
                if(!busStopName.isEmpty()) return new Gson().toJson(getMatchingBusStop(busStopName, searchParameter[0]));
                //WENN NICHT GEGEBEN
                return "{\"errorMessage\":\"BusStop required!\"}";
            }
        }else if(!busStopName.isEmpty()){
            return new Gson().toJson(getMatchingStops(busStopName, "ALL"));
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

    public ArrayList<JAbleBusStop> getMatchingStops(String name, String tag){
        ArrayList<JAbleBusStop> jAbleBusStops = new ArrayList<>();
        String tagType = tag;
        if(tagType == null) tagType = "ALL";
        tagType = tagType.toUpperCase();

        final String searchTag = tagType;

        BusNetwork.stops.forEach((s, busStop) -> {
            if(busStop.getName().toLowerCase().startsWith(name.toLowerCase())){
                switch (searchTag){
                    case "ATTRACTIONS":
                        if(busStop.isAttraction()) jAbleBusStops.add(new JAbleBusStop(busStop));
                        break;
                    case "ALL":
                    default:
                        jAbleBusStops.add(new JAbleBusStop(busStop));
                        break;

                }
            }
        });

        return jAbleBusStops;
    }

    public JAbleBusStop getMatchingBusStop(String name, String tag){

        String tagType = tag;
        if(tagType == null) tagType = "ALL";
        tagType = tagType.toUpperCase();
        final String searchTag = tagType;

        ArrayList<JAbleBusStop> busStops = new ArrayList<>();

        BusNetwork.stops.forEach((s, busStop) -> {
            if(busStop.getName().toLowerCase().equals(name.toLowerCase())){
                switch (searchTag){
                    case "ATTRACTIONS":
                        if(busStop.isAttraction()) busStops.add(new JAbleBusStop(busStop));
                        break;
                    case "ALL":
                    default:
                        busStops.add(new JAbleBusStop(busStop));
                        break;

                }
            }
        });
        if(busStops.size() > 0) return  busStops.get(0);
        return null;
    }
}
