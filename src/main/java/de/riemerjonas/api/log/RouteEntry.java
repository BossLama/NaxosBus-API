package de.riemerjonas.api.log;

import com.google.gson.Gson;
import de.riemerjonas.api.key.ApiKey;

import java.util.Date;

public class RouteEntry {

    private Date requestDate;
    private String depature;
    private String destination;

    private ApiKey apiKey;

    public RouteEntry(Date requestDate, String depature, String destination, ApiKey apiKey){
        this.requestDate = requestDate;
        this.depature = depature;
        this.destination = destination;
        this.apiKey = apiKey;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public String getDepature() {
        return depature;
    }

    public String getDestination() {
        return destination;
    }

    public ApiKey getApiKey() {
        return apiKey;
    }

    public String toJSON(){
        return new Gson().toJson(this);
    }
}
