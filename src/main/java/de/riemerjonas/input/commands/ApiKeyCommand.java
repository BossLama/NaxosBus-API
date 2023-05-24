package de.riemerjonas.input.commands;

import de.riemerjonas.api.APIServer;
import de.riemerjonas.api.key.ApiKey;
import de.riemerjonas.api.key.KeyManager;
import de.riemerjonas.other.SystemMessage;

import java.security.Key;

public class ApiKeyCommand extends Command{
    @Override
    public void execute(String[] args) {
        if(args.length > 1){

            if(args[1].equalsIgnoreCase("create")){
                if(args.length > 2){
                    if(KeyManager.existNamespace(args[2])){
                        SystemMessage.sendWarning("Key with name \"" + args[2] + "\" already exists!");
                        return;
                    }
                    String key = KeyManager.generateKey(args[2]);
                    SystemMessage.sendCommandInfo("New key has been created: " + key);
                }else SystemMessage.sendCommandInfo("Use " + args[0] + " create (name)");
            }else if(args[1].equalsIgnoreCase("delete")){
                if(args.length > 2){
                    KeyManager.deleteKey(args[2]);
                    SystemMessage.sendCommandInfo("Key has been deleted!");
                }else SystemMessage.sendCommandInfo("Use " + args[0] + " delete (name)");
            }else if(args[1].equalsIgnoreCase("get")){
                if(args.length > 2){
                    ApiKey key = KeyManager.getApiKey(args[2]);
                    if(key == null){
                        SystemMessage.sendWarning("Key with name \"" + args[2] + "\" does not exists!");
                    }else SystemMessage.sendCommandInfo("Key \"" + key.getName() + "\": " + key.getKey());
                    return;
                }
                SystemMessage.sendCommandInfo("All API keys:");
                for(ApiKey key : KeyManager.getApiKeys()){
                    System.out.println("- " + key.getKey() + " | " + key.getName());
                }
            }

        }else SystemMessage.sendCommandInfo("Use " + args[0] + " [create|delete|get]");
    }
}
