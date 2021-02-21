package World;

import Factions.Factions;
import History.Scenario;
import Resources.Agriculture;
import Resources.Industry;
import Resources.Treasury;

public class World {

    private Island island;

    public void initIsland(String island, Factions[] factions, Agriculture agriculture, Industry industry, Treasury treasury, Scenario scenario)
    {
        this.island = new Island(island, factions, agriculture, industry, treasury, scenario);
    }

    public Island getIsland() {
        return island;
    }
}
