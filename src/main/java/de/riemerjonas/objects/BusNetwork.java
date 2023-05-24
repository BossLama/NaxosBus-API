package de.riemerjonas.objects;

import java.util.ArrayList;
import java.util.HashMap;

public class BusNetwork {

    public static HashMap<String, BusStop> stops = new HashMap<>();


    public static void registerStop(BusStop busStop){
        if(stops.containsKey(busStop.getName())) return;
        stops.put(busStop.getName(), busStop);
        //System.out.println(busStop.getName() + " - registered (" + stops.size() + ")");
    }

    public static BusStop getBusStop(String name){
        return stops.get(name);
    }


}
