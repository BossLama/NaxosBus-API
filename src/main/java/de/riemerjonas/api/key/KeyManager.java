package de.riemerjonas.api.key;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import de.riemerjonas.other.SystemMessage;

import java.io.*;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class KeyManager {

    private static ArrayList<ApiKey> apiKeys = new ArrayList<>();
    private static File keyStorage = new File("keyStorage.json");


    private static void initFile(){
        if(!keyStorage.exists()){
            try {
                keyStorage.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void loadKeys(){
        initFile();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(keyStorage));
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            String ls = System.getProperty("line.separator");
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }

            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            reader.close();

            String content = stringBuilder.toString();

            if(!content.isEmpty() && content != "" && content != " "){
                JsonArray array = new Gson().fromJson(content, JsonArray.class);

                for(int i = 0; i < array.size(); i++){
                    JsonObject object = array.get(i).getAsJsonObject();
                    ApiKey key = new ApiKey(object.get("name").getAsString(), object.get("key").getAsString());
                    apiKeys.add(key);
                }
            }else{
                apiKeys = new ArrayList<>();
            }

        }catch (Exception e){
            apiKeys = new ArrayList<>();
            SystemMessage.sendError("Error while loading api-key File! " + e.getMessage());
        }
    }

    public static void saveKeys(){
        initFile();
        try {
            PrintWriter out = new PrintWriter(keyStorage);
            out.println(new Gson().toJson(apiKeys));
            out.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static String generateKey(String name){
        String uuid = UUID.randomUUID().toString();
        apiKeys.add(new ApiKey(name, uuid));
        saveKeys();
        return uuid;
    }

    public static void deleteKey(String name){
        for(int i = 0; i < apiKeys.size(); i++){
            if(apiKeys.get(i).getName().equals(name)){
                apiKeys.remove(i);
                saveKeys();
                return;
            }
        }
        saveKeys();
    }

    public static ArrayList<ApiKey> getApiKeys(){
        return apiKeys;
    }

    public static boolean isValid(String key){
        for(ApiKey apiKey : apiKeys){
            if(apiKey.getKey().equals(key)) return true;
        }
        return false;
    }

    public static boolean existNamespace(String name){
        for(ApiKey apiKey : apiKeys){
            if(apiKey.getName().equals(name)) return true;
        }
        return false;
    }

    public static ApiKey getApiKey(String name){
        for(ApiKey apiKey : apiKeys){
            if(apiKey.getName().equals(name)) return apiKey;
        }
        return null;
    }

    public static ApiKey getApiKeyByKey(String key){
        for(ApiKey apiKey : apiKeys){
            if(apiKey.getKey().equals(key)) return apiKey;
        }
        return null;
    }
}
