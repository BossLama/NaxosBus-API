package de.riemerjonas.input.commands;

import de.riemerjonas.other.SystemMessage;

public class ShutdownCommand extends Command{
    @Override
    public void execute(String[] args) {
        int seconds = 10;
        if(args.length > 1){
            String duration = args[1];
            try{
                seconds = Integer.parseInt(duration);
            }catch (Exception e){
                SystemMessage.sendError("Please enter seconds as second parameter!");
                return;
            }
        }
        SystemMessage.sendWarning("System will shut down in "+ seconds +" seconds");
        int finalSeconds = seconds;
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(finalSeconds * 1000);
                    SystemMessage.sendError("System is shutting down");
                    System.exit(0);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }.start();
    }


    @Override
    public String getDescription() {
        return "Shuts down the program";
    }
}
