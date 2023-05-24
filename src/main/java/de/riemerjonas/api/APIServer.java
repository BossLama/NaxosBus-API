package de.riemerjonas.api;

import com.sun.net.httpserver.HttpServer;
import de.riemerjonas.api.handlers.RouteRequestHandler;
import de.riemerjonas.api.handlers.StopRequestHandler;
import de.riemerjonas.api.log.LogHandler;
import de.riemerjonas.other.SystemMessage;

import java.io.IOException;
import java.net.InetSocketAddress;

public class APIServer {

    private int port;
    public static String API_KEY = "J1u4AZoTTw56HZpklgfx";
    public static LogHandler logHandler = new LogHandler();
    private HttpServer server;
    public APIServer(int port){
        this.port = port;
        server = null;
        try {
            server = HttpServer.create(new InetSocketAddress(port), 0);
            SystemMessage.sendSuccess("Server is running on port " + port);
        } catch (IOException e) {
            SystemMessage.sendError(e.getMessage());
            SystemMessage.sendInformation("Server is shutting down...");
        }

        server.createContext("/api/route", new RouteRequestHandler());
        server.createContext("/api/stops", new StopRequestHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
    }

    public HttpServer getServer(){
        return server;
    }
}
