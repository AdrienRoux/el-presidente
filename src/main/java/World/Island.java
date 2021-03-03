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

    public static void killPeople(int peopleToKill, Factions[] factions)
    {
        for (int i = 0; i < peopleToKill/4 ; i++)
        {
            int random = (int) (0 + (Math.random() * (factions.length - 0)));
            factions[random].killPeople();
            Island.decreaseSatisfactionOnDeath(factions);
        }
    }

    public static void decreaseSatisfactionOnDeath(Factions[] factions)
    {
        for (int i = 0; i < factions.length ; i++)
        {
            factions[i].decreaseSatisfaction(2);
        }
    }
}
