package de.riemerjonas.input.commands;

import de.riemerjonas.api.APIServer;
import de.riemerjonas.api.log.LogHandler;
import de.riemerjonas.api.log.RouteEntry;

import java.text.SimpleDateFormat;

public class LogCommand extends Command{
    @Override
    public void execute(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy - hh:mm:ss ");
        System.out.println("[===================================== LOG BOOK =====================================]");
        for(RouteEntry entry : APIServer.logHandler.getEntries()){
            System.out.println("[" + format.format(entry.getRequestDate()) + "Uhr] via " + entry.getApiKey().getName() + ": " + entry.getDepature() + " --> " + entry.getDestination());
        }
        System.out.println("[===================================== === ==== =====================================]");
        System.out.println();
    }
}
