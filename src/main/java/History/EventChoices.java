package History;

import java.util.ArrayList;

public class EventChoices {

    private String name;
    private ArrayList<FactionsEffects> factionEffects;
    private ArrayList<ResourcesEffects> resourcesEffects;

    public EventChoices(String name, ArrayList<FactionsEffects> factionEffects, ArrayList<ResourcesEffects> resourcesEffects){
        this.name = name;
        this.factionEffects = factionEffects;
        this.resourcesEffects = resourcesEffects;
    }
}
