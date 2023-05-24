package de.riemerjonas.objects;

public class JsonAbleRouteConnection {

    public int lineID;
    public double distance;
    public JAbleBusStop busStop;

    public JsonAbleRouteConnection(Integer line, double distanceKM, BusStop destination){
        this.lineID = line;
        this.distance = distanceKM;
        this.busStop = new JAbleBusStop(destination);
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

    public JAbleBusStop getBusStop() {
        return busStop;
    }

    public void setBusStop(BusStop busStop) {
        this.busStop = new JAbleBusStop(busStop);
    }
}
