package History;

import World.*;

public class ResourcesEffects {

    private String name;
    private int effect;

    public ResourcesEffects(String name, int effect)
    {
        this.name = name;
        this.effect = effect;
    }

    public void launchEffect()
    {
        int set = 0;
        switch (name) {
            case "INDUSTRY":
                set = World.island.getIndustry().getPercentage();
                World.island.getIndustry().setPercentage(set + effect);
                break;
            case "TREASURY":
                set = World.island.getTreasury().getFunds();
                World.island.getTreasury().setFunds(set + effect);
                break;
            case "AGRICULTURE":
                set = World.island.getAgriculture().getPercentage();
                World.island.getTreasury().setFunds(set + effect);
                break;
        }
    }
}
