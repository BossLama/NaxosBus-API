package de.riemerjonas.objects;

public class RouteConnection {

    public int lineID;
    public double distance;
    public BusStop busStop;

    public RouteConnection(Integer line, double distanceKM, BusStop destination){
        this.lineID = line;
        this.distance = distanceKM;
        this.busStop = destination;
    }

    public int getLineID() {
        return lineID;
    }

    public void setLineID(int lineID) {
        this.lineID = lineID;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public BusStop getBusStop() {
        return busStop;
    }

    public void setBusStop(BusStop busStop) {
        this.busStop = busStop;
    }
}
