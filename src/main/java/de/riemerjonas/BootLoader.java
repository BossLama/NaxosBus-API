package de.riemerjonas;

import com.google.gson.Gson;
import de.riemerjonas.api.APIServer;
import de.riemerjonas.api.key.KeyManager;
import de.riemerjonas.input.InputHandler;
import de.riemerjonas.input.commands.*;
import de.riemerjonas.objects.*;
import de.riemerjonas.other.SystemMessage;

import java.util.ArrayList;
import java.util.List;

public class BootLoader {

    public static final String PREFIX = "Naxos Bus-API: ";
    public static final int PORT = 8321;
    public static APIServer apiServer;

    public static void main(String[] args){
        SystemMessage.sendSuccess("API-System started successfully");
        NaxosData.loadAllStops();
        NaxosData.initConnections();

        KeyManager.loadKeys();

        apiServer = new APIServer(PORT);

        InputHandler inputHandler = new InputHandler();

        InputHandler.registerCommand(new ShutdownCommand(), "shutdown");
        InputHandler.registerCommand(new PortCommand(), "port");
        InputHandler.registerCommand(new StatusCommand(), "state");
        InputHandler.registerCommand(new RestartCommand(), "restart");
        InputHandler.registerCommand(new ApiKeyCommand(), "apiKey");
        InputHandler.registerCommand(new ClearCommand(), "clear");
        InputHandler.registerCommand(new LogCommand(), "log");


        ArrayList<RouteConnection> connections = BusNetwork.getBusStop("Naxos Town / Port").findShortestPath(BusNetwork.getBusStop("Naxos Camping"));

        for(RouteConnection connection : connections){
            System.out.println(connection.getLineID() + " for " + connection.getDistance() + "min. --> " + connection.getBusStop().getName());
        }

    }

}
