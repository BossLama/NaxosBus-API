package de.riemerjonas.api.reponse;

public class ErrorResponse extends Response{

    private String message;

    public ErrorResponse(String message){
        this.message = message;
    }

    @Override
    public String getResponse() {

        return "{" +
                "\"error\":true," +
                "\"errorMessage\":\""+ message +"\"" +
                "}";

    }
}
