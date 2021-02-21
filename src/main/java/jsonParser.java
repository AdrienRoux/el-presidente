import Factions.Factions;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;


public class jsonParser {

    public void displayJson() {
        String json = getContentStringFromResource("Json/attackOnTitans.json");

        JSONObject obj = new JSONObject(json);

        JSONArray key = obj.names();
        System.out.println(key);
        JSONArray keyb = obj.getJSONArray("events");
        System.out.println(keyb.length());
    }

    public static String getContentStringFromResource(String fileName) {
        return new BufferedReader(
                new InputStreamReader(Main.class.getResourceAsStream(fileName), StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));
    }

     public Factions[] initFactionsFromFile(String file) {
         String json = getContentStringFromResource(file);
         JSONObject obj = new JSONObject(json);

         JSONObject factionsData = obj.getJSONObject("gameStartParameters").getJSONObject("NORMAL").getJSONObject("factions");
         List<Factions> factionsList = new ArrayList<Factions>();

         factionsData.keySet().forEach(factionName -> {
             String name = null;
             int satisfaction = 0;
             int population = 0;

             JSONObject factionProperties = factionsData.getJSONObject(factionName);

             for (int i = 0; i < factionProperties.keySet().toArray().length; i++){
                 Object key = factionProperties.keySet().toArray()[i];
                 Object value = factionProperties.get(key.toString());
                 if (key.equals("name")) {
                     name = value.toString();
                 }
                 if (key.equals("satisfactionPercentage")) {
                     satisfaction = Integer.parseInt(value.toString());
                 }
                 if (key.equals("numberOfPartisans")) {
                     population = Integer.parseInt(value.toString());
                 }
             }

             factionsList.add(new Factions(name, satisfaction, population));
         });

         return factionsList.toArray(new Factions[0]);
     }
}
