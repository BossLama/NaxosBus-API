package de.riemerjonas.api.log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import de.riemerjonas.api.key.ApiKey;
import de.riemerjonas.other.SystemMessage;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class LogHandler {

    private File logFile;
    private ArrayList<RouteEntry> entries;

    public LogHandler(){
        logFile = new File("log.json");
        entries = new ArrayList<>();

        loadEntries();
    }

    private void createLog(){
        try {
            if(!logFile.exists()) return;
            logFile.createNewFile();
        }catch (Exception e){
            SystemMessage.sendError("Error while creating log-File!");
        }
    }

    public void loadEntries(){
        createLog();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(logFile));
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
                    RouteEntry entry = new RouteEntry(new Gson().fromJson(object.get("requestDate"), Date.class), object.get("depature").getAsString(), object.get("destination").getAsString(),
                            new Gson().fromJson(object.get("apiKey"), ApiKey.class));
                    entries.add(entry);
                }
            }else{
                entries = new ArrayList<>();
            }

        }catch (Exception e){
            entries = new ArrayList<>();
            SystemMessage.sendError("Error while loading api-key File! " + e.getMessage());
        }
    }

    public void save(){
        createLog();
        try {
            PrintWriter out = new PrintWriter(logFile);
            out.println(new Gson().toJson(entries));
            out.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void addEntry(RouteEntry entry){
        this.entries.add(entry);
        save();
    }

    public void createEntry(Date date, String depature, String destination, ApiKey key){
        this.entries.add(new RouteEntry(date, depature, destination, key));
        save();
    }

    public ArrayList<RouteEntry> getEntries(){
        return this.entries;
    }

}
