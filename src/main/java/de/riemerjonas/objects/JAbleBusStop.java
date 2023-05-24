package de.riemerjonas.objects;

public class JAbleBusStop {

    private double latitude;
    private double longitude;
    private String name;
    private boolean isAttraction;


    public JAbleBusStop(BusStop busStop){
        this.latitude = busStop.getLatitude();
        this.longitude = busStop.getLongitude();
        this.name = busStop.getName();
        this.isAttraction = busStop.isAttraction();
    }

    public JAbleBusStop(String name, double latitude, double longitude){
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.isAttraction = false;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAttraction() {
        return isAttraction;
    }

    public void setAttraction(boolean attraction) {
        isAttraction = attraction;
    }
}
