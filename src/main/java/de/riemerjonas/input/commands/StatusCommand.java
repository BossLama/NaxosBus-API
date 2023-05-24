package de.riemerjonas.input.commands;

import de.riemerjonas.BootLoader;
import de.riemerjonas.other.SystemMessage;

public class StatusCommand extends Command{
    @Override
    public void execute(String[] args) {

        if(BootLoader.apiServer == null){
            SystemMessage.sendCommandInfo("Server is not initialized");
        }else if(BootLoader.apiServer.getServer() == null){
            SystemMessage.sendCommandInfo("Server is not running!");
        }else {
            SystemMessage.sendCommandInfo("Server is running!");
        }

    }
}
