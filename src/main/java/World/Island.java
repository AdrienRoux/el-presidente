package World;

import Factions.Factions;
import History.Scenario;
import Resources.Agriculture;
import Resources.Attic;
import Resources.Industry;
import Resources.Treasury;

public class Island {

    private String name;
    private Factions[] factions;
    private Agriculture agriculture;
    private Industry industry;
    private Treasury treasury;
    private Scenario scenario;
    private Attic attic;

    public Island(String name, Factions[] factions, Agriculture agriculture, Industry industry, Treasury treasury, Scenario scenario, Attic attic) {
        this.name = name;
        this.factions = factions;
        this.agriculture = agriculture;
        this.industry = industry;
        this.treasury = treasury;
        this.scenario = scenario;
        this.attic = attic;
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

    public void feedPopulation()
    {
        boolean enougthFood = this.attic.isThereEnougthFood(this.factions);
        if (enougthFood)
        {
            this.attic.feedPopulation(getGlobalPopulation());
        }
        else
        {
            int peopleToKill = (getGlobalPopulation() - this.attic.getAllFoodStocked())/4;
            killPeople(peopleToKill, this.factions);
        }
    }

    public void killPeople(int peopleToKill, Factions[] factions)
    {
        for (int i = 0; i < peopleToKill/4 ; i++)
        {
            int random = (int) (0 + (Math.random() * (factions.length)));
            factions[random].killPeople();
            decreaseSatisfactionOnDeath(factions);
        }
    }

    public int getGlobalPopulation()
    {
        int globalPopulation = 0;

        for (Factions faction : factions) {
            globalPopulation = globalPopulation + faction.getPopulation();
        }
        return globalPopulation;
    }

    public void decreaseSatisfactionOnDeath(Factions[] factions)
    {
        for (Factions faction : factions) {
            faction.decreaseSatisfaction(2);
        }
    }
}
