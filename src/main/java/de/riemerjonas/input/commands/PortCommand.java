package de.riemerjonas.input.commands;

import de.riemerjonas.BootLoader;
import de.riemerjonas.other.SystemMessage;

public class PortCommand extends Command{
    @Override
    public void execute(String[] args) {
        SystemMessage.sendCommandInfo("API-Server is running on port " + BootLoader.PORT);
    }

    @Override
    public String getDescription() {
        return "Return current port of server";
    }
}
