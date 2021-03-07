package JsonParser;

import Factions.Factions;
import History.*;
import Resources.*;
import World.World;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class InitWorld {

    JSONObject json;

    public InitWorld(JSONObject json){
        this.json = json;
    }

    public World initWorldFromJsonData(String name) {
        World world = new World();
        world.initIsland(
                name,
                initFactionsFromFile(),
                initAgriculture(),
                initIndustry(),
                initTreasury(),
                initScenario(),
                initAttic(),
                initMarket()
        );
        return world;
    }

    private Agriculture initAgriculture() {
        return new Agriculture(Integer.parseInt(json.getJSONObject("gameStartParameters").getJSONObject("NORMAL").get("agriculturePercentage").toString()));
    }

    private Industry initIndustry() {
        return new Industry(Integer.parseInt(json.getJSONObject("gameStartParameters").getJSONObject("NORMAL").get("industryPercentage").toString()));
    }

    private Treasury initTreasury() {
        return new Treasury(Integer.parseInt(json.getJSONObject("gameStartParameters").getJSONObject("NORMAL").get("treasury").toString()));
    }

    private Scenario initScenario() {
        return new Scenario(
                json.get("name").toString(),
                json.get("story").toString(),
                initEvents()
        );
    }

    private Attic initAttic() {
        return new Attic(
                Integer.parseInt(json.getJSONObject("gameStartParameters").getJSONObject("NORMAL").get("foodUnits").toString())
        );
    }

    private Market initMarket() {
        return new Market(8);
    }

    private Factions[] initFactionsFromFile() {

        JSONObject factionsData = json.getJSONObject("gameStartParameters").getJSONObject("NORMAL").getJSONObject("factions");
        List<Factions> factionsList = new ArrayList<>();

        factionsData.keySet().forEach(factionName -> {
            String name = null;
            int satisfaction = 0;
            int population = 0;

            JSONObject factionProperties = factionsData.getJSONObject(factionName);

            for (int i = 0; i < factionProperties.keySet().toArray().length; i++) {
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

    private ArrayList<Events> initEvents() {
        ArrayList<Events> events = new ArrayList<>();

        JSONArray eventsData = json.getJSONArray("events");

        for (int x = 0; x < eventsData.length(); x++) {
            String name = null;
            JSONObject eventProperties = (JSONObject) eventsData.get(x);

            for (int i = 0; i < eventProperties.keySet().size(); i++) {

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

    private ArrayList<EventChoices> initChoices(JSONArray choices) {
        ArrayList<EventChoices> eventChoices = new ArrayList<>();
        JSONObject factionsEffectsData = null;
        JSONObject resourcesEffectsData = null;

        for (int x = 0; x < choices.length(); x++) {
            String name = null;

            JSONObject choiceProperties = (JSONObject) choices.get(x);

            for (int i = 0; i < choiceProperties.keySet().toArray().length; i++) {

                Object key = choiceProperties.keySet().toArray()[i];
                Object value = choiceProperties.get(key.toString());

                if (key.equals("choice")) {
                    name = value.toString();
                }

                if (key.equals("effects")) {
                    JSONArray effects = choiceProperties.getJSONArray("effects");

                    for (int j = 0; j < effects.length(); j++) {
                        JSONObject effect = effects.getJSONObject(j);

                        for (int k = 0; k < effect.keySet().toArray().length; k++) {
                            if (effect.keySet().toArray()[k].equals("actionOnFaction")) {
                                factionsEffectsData = effect.getJSONObject("actionOnFaction");
                            }
                            if (effect.keySet().toArray()[k].equals("actionOnFactor")) {
                                resourcesEffectsData = effect.getJSONObject("actionOnFactor");
                            }
                        }
                    }
                }
            }

            eventChoices.add(new EventChoices(name, initFactionsEffects(factionsEffectsData), initResourcesEffects(resourcesEffectsData)));
        }
        return eventChoices;
    }


    private ArrayList<FactionsEffects> initFactionsEffects(JSONObject factionsEffectsData) {
        ArrayList<FactionsEffects> factionsEffects = new ArrayList<>();

        if (factionsEffectsData != null) {
            factionsEffectsData.keySet().forEach(key -> {
                FactionsEffects factionEffect = new FactionsEffects(key, Integer.parseInt(factionsEffectsData.get(key).toString()));
                factionsEffects.add(factionEffect);
            });
        }

        return factionsEffects;
    }

    private ArrayList<ResourcesEffects> initResourcesEffects(JSONObject resourcesEffectsData) {
        ArrayList<ResourcesEffects> resourcesEffects = new ArrayList<>();

        if (resourcesEffectsData != null) {
            resourcesEffectsData.keySet().forEach(key -> {
                ResourcesEffects resourcesEffect = new ResourcesEffects(key, Integer.parseInt(resourcesEffectsData.get(key).toString()));
                resourcesEffects.add(resourcesEffect);
            });
        }

        return resourcesEffects;
    }

}
