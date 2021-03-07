package History;

import World.Island;

import java.util.ArrayList;

public class EventChoices {

    private String name;
    private ArrayList<FactionsEffects> factionEffects;
    private ArrayList<ResourcesEffects> resourcesEffects;
    private Events relatedEvent; 

    public EventChoices(String name, ArrayList<FactionsEffects> factionEffects, ArrayList<ResourcesEffects> resourcesEffects){
        this.name = name;
        this.factionEffects = factionEffects;
        this.resourcesEffects = resourcesEffects;
        
    }
    
    public void launchEffect()
    {
        factionEffects.forEach(FactionsEffects::launchEffect);
        resourcesEffects.forEach(ResourcesEffects::launchEffect);
    }

    public String getName() {
        return name;
    }
}
