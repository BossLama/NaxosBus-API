package de.riemerjonas.objects;

import de.riemerjonas.other.SystemMessage;

import java.util.*;

public class BusStop {

    private String name;
    private double latitude;
    private double longitude;

    private boolean isAttraction;

    private ArrayList<RouteConnection> connections;

    public BusStop(String name, double latitude, double longitude){
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.connections = new ArrayList<>();
        this.isAttraction = false;

        BusNetwork.registerStop(this);
    }

    public BusStop(String name, double latitude, double longitude, boolean isAttraction){
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.connections = new ArrayList<>();
        this.isAttraction = isAttraction;

        BusNetwork.registerStop(this);
    }

    public void setConnections(ArrayList<RouteConnection> connections){
        this.connections = connections;
    }

    public ArrayList<RouteConnection> getConnections(){
        return this.connections;
    }

    public void addConnection(RouteConnection connection){
        this.connections.add(connection);
    }

    public void createConnection(int line, double distance, BusStop destination){
        this.connections.add(new RouteConnection(line, distance, destination));
        BusNetwork.getBusStop(destination.getName()).createOneWayConnection(line, distance, this);
    }

    public void createOneWayConnection(int line, double distance, BusStop destination){
        this.connections.add(new RouteConnection(line, distance, destination));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public ArrayList<RouteConnection> findShortestPath(BusStop destination) {
        Map<BusStop, Double> distances = new HashMap<>();
        Map<BusStop, BusStop> previousStops = new HashMap<>();
        Set<BusStop> visitedStops = new HashSet<>();

        PriorityQueue<BusStop> queue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        distances.put(this, 0.0);
        queue.add(this);

        while (!queue.isEmpty()) {
            BusStop currentStop = queue.poll();

            if (currentStop.equals(destination)) {
                return buildPath(previousStops, destination);
            }

            visitedStops.add(currentStop);

            for (RouteConnection connection : currentStop.getConnections()) {
                BusStop neighborStop = connection.getBusStop();
                if (visitedStops.contains(neighborStop)) {
                    continue;
                }

                double totalDistance = distances.get(currentStop) + connection.getDistance();

                if (totalDistance < distances.getOrDefault(neighborStop, Double.MAX_VALUE)) {
                    distances.put(neighborStop, totalDistance);
                    previousStops.put(neighborStop, currentStop);
                    queue.remove(neighborStop);
                    queue.add(neighborStop);
                }
            }
        }

        return null; // No path found
    }

    private ArrayList<RouteConnection> buildPath(Map<BusStop, BusStop> previousStops, BusStop destination) {
        ArrayList<RouteConnection> path = new ArrayList<>();
        BusStop currentStop = destination;
        while (currentStop != null) {
            BusStop previousStop = previousStops.get(currentStop);
            if (previousStop != null) {
                for (RouteConnection connection : previousStop.getConnections()) {
                    if (connection.getBusStop().equals(currentStop)) {
                        path.add(0, connection);
                        break;
                    }
                }
            }
            currentStop = previousStop;
        }

        return path;
    }

    public RouteConnection getConnectionTo(BusStop busStop, int line){
        RouteConnection found = null;
        for(RouteConnection connection : connections){
            if(connection.getBusStop().getName().equals(busStop.getName())){
                if(found == null){
                    found = connection;
                }else if(connection.getLineID() == line){
                    found = connection;
                }
            }
        }

        return found;
    }

    public boolean isAttraction() {
        return isAttraction;
    }

    public void setAttraction(boolean attraction) {
        isAttraction = attraction;
    }
}
