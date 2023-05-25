package de.riemerjonas.input;

import de.riemerjonas.input.commands.Command;
import de.riemerjonas.other.SystemMessage;

import java.util.HashMap;
import java.util.Scanner;

public class InputHandler {

    private static HashMap<String, Command> commands = new HashMap<>();
    public InputHandler(){
        new Thread(){
            @Override
            public void run() {
                listen();
            }
        }.start();
    }

    public static void registerCommand(Command command, String cmd){
        commands.put(cmd, command);
    }

    public void listen(){
        SystemMessage.sendInformation("Input-Listener is enabled");
        Scanner scanner = new Scanner(System.in);

        while (true){
            String command = scanner.nextLine();
            String cmd = command.split(" ")[0];

            if(commands.containsKey(cmd)){
                commands.get(cmd).execute(command.split(" "));
            }else SystemMessage.sendWarning("Unknown command " + cmd);
        }
    }

    public static HashMap<String, Command> getCommands(){
        return commands;
    }
}
