package World;

import Factions.Factions;
import History.Scenario;
import Resources.Agriculture;
import Resources.Industry;
import Resources.Treasury;

public class Island {

    private String name;
    private Factions[] factions;
    private Agriculture agriculture;
    private Industry industry;
    private Treasury treasury;
    private Scenario scenario;

    public Island(String name, Factions[] factions, Agriculture agriculture, Industry industry, Treasury treasury, Scenario scenario) {
        this.name = name;
        this.factions = factions;
        this.agriculture = agriculture;
        this.industry = industry;
        this.treasury = treasury;
        this.scenario = scenario;
    }

    public String getName() {
        return name;
    }

    public Factions[] getFactions() {
        return factions;
    }

    public Agriculture getAgriculture() {
        return agriculture;
    }

    public Industry getIndustry() {
        return industry;
    }

    public Treasury getTreasury() {
        return treasury;
    }

    public Scenario getScenario() {
        return scenario;
    }
}
