package de.riemerjonas.input.commands;

import de.riemerjonas.BootLoader;
import de.riemerjonas.api.APIServer;
import de.riemerjonas.objects.NaxosData;
import de.riemerjonas.other.SystemMessage;

public class RestartCommand extends Command{
    @Override
    public void execute(String[] args) {
        new Thread(){
            @Override
            public void run() {
                try {
                    BootLoader.apiServer.getServer().stop(0);
                    SystemMessage.sendWarning("Server stopped. No requests possible for next 5sec");
                    Thread.sleep(2000);
                    SystemMessage.sendSuccess("Restarting system...");
                    Thread.sleep(3000);
                    NaxosData.loadAllStops();
                    NaxosData.initConnections();
                    BootLoader.apiServer = new APIServer(BootLoader.PORT);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }.start();
    }

    @Override
    public String getDescription() {
        return "Restarts api-server";
    }
}
