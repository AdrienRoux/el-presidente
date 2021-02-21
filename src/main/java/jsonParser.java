import Factions.Factions;
import History.EventChoices;
import History.Events;
import History.Scenario;
import Resources.Agriculture;
import Resources.Industry;
import Resources.Treasury;
import World.World;
import com.sun.javafx.scene.control.behavior.TwoLevelFocusBehavior;
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

    JSONObject json;

    jsonParser(String fileName) {
        this.json = new JSONObject(getContentStringFromResource(fileName));
    }

    public World initWorldFromJsonData(String name){
        World world = new World();
        world.initIsland(
                name,
                initFactionsFromFile(),
                initAgriculture(),
                initIndustry(),
                initTreasury(),
                initScenario()

        );
        return world;
    }

    public void displayJson() {

        JSONArray key = json.names();
        System.out.println(key);
        JSONArray keyb = json.getJSONArray("events");
        System.out.println(keyb.length());
    }

    public static String getContentStringFromResource(String fileName) {
        return new BufferedReader(
                new InputStreamReader(Main.class.getResourceAsStream(fileName), StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));
    }

     private Factions[] initFactionsFromFile() {

         JSONObject factionsData = json.getJSONObject("gameStartParameters").getJSONObject("NORMAL").getJSONObject("factions");
         List<Factions> factionsList = new ArrayList<>();

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

     private Agriculture initAgriculture(){
        return new Agriculture(Integer.parseInt(json.getJSONObject("gameStartParameters").getJSONObject("NORMAL").get("agriculturePercentage").toString()));
     }

    private Industry initIndustry(){
        return new Industry(Integer.parseInt(json.getJSONObject("gameStartParameters").getJSONObject("NORMAL").get("industryPercentage").toString()));
    }

    private Treasury initTreasury(){
        return new Treasury(Integer.parseInt(json.getJSONObject("gameStartParameters").getJSONObject("NORMAL").get("treasury").toString()));
    }

    private Scenario initScenario(){
        return new Scenario(
                json.get("name").toString(),
                json.get("story").toString(),
                initEvents()
        );
    }

    private ArrayList<Events> initEvents(){
        ArrayList<Events> events = new ArrayList<>();

        JSONArray eventsData = json.getJSONArray("events");

        for (int x = 0; x < eventsData.length(); x++) {
            String name = null;
            JSONObject eventProperties = (JSONObject) eventsData.get(x);

            for (int i = 0; i < eventProperties.keySet().toArray().length; i++){

                Object key = eventProperties.keySet().toArray()[i];
                Object value = eventProperties.get(key.toString());

                if (key.equals("name")) {
                    name = value.toString();
                }
            }

            events.add(new Events(name, initChoices(eventProperties.getJSONArray("choices"))));
        }

        return events;
    }

    private ArrayList<EventChoices> initChoices(JSONArray choices){
        ArrayList<EventChoices> eventChoices = new ArrayList<>();

        for (int x = 0; x < choices.length(); x++) {
            String name = null;

            JSONObject choiceProperties = (JSONObject) choices.get(x);

            for (int i = 0; i < choiceProperties.keySet().toArray().length; i++){

                Object key = choiceProperties.keySet().toArray()[i];
                Object value = choiceProperties.get(key.toString());

                if (key.equals("choice")) {
                    name = value.toString();
                }
            }

            eventChoices.add(new EventChoices(name, new ArrayList<>(), new ArrayList<>()));
        }
        return eventChoices;
    }
}
