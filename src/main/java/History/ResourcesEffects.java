package History;

import World.Island;

public class ResourcesEffects {

    private String name;
    private int effect;

    public ResourcesEffects(String name, int effect)
    {
        this.name = name;
        this.effect = effect;
    }

    public void launchEffect(Island island)
    {
        int set = 0;
        if (name.equals("INDUSTRY"))
        {
            set = island.getIndustry().getPercentage();
            island.getIndustry().setPercentage(set+effect);
        }
        else if (name.equals("TREASURY"))
        {
            set = island.getTreasury().getFunds();
            island.getTreasury().setFunds(set+effect);
        }
        else if (name.equals("AGRICULTURE"))
        {
            set = island.getAgriculture().getPercentage();
            island.getTreasury().setFunds(set+effect);
        }
    }
}
