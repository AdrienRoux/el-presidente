package History;

import Factions.Factions;
import World.*;

public class FactionsEffects {

    private String name;
    private int effect;

    public FactionsEffects(String name, int effect){
        this.name = name;
        this.effect = effect;
    }

    public void launchEffect()
    {
        Factions[] factions = World.island.getFactions();
        int set = 0;
        for (int i = 0; i < factions.length; i++)
        {
            if (factions[i].getName().equals( this.name))
            {
                set = factions[i].getSatisfaction();
                factions[i].setSatisfaction(set + effect);
                break;
            }
        }
    }
}
