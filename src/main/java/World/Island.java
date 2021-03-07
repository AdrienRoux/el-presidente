package World;

import Factions.Factions;
import History.Scenario;
import Resources.*;

import java.util.Scanner;

public class Island {

    private String name;
    private Factions[] factions;
    private Agriculture agriculture;
    private Industry industry;
    private Treasury treasury;
    private Scenario scenario;
    private Attic attic;
    private Market market;

    public Island(String name, Factions[] factions, Agriculture agriculture, Industry industry, Treasury treasury, Scenario scenario, Attic attic, Market market) {
        this.name = name;
        this.factions = factions;
        this.agriculture = agriculture;
        this.industry = industry;
        this.treasury = treasury;
        this.scenario = scenario;
        this.attic = attic;
        this.market = market;
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

    public Attic getAttic()
    {
        return attic;
    }

    public void feedPopulation()
    {
        boolean enoughFood = this.attic.isThereEnougthFood(this.factions);
        if (enoughFood)
        {
            this.attic.feedPopulation(getGlobalPopulation());
        }
        else
        {
            System.out.println("Vous n'avez pas assez de nourriture pour nourrire tout la population faite un choix : ");
            System.out.println("1. Laisser la population mourir de faim !");
            System.out.println("2. Acheter de la nourriture !");
            int peopleToKill = getGlobalPopulation() - (this.attic.getAllFoodStocked() / 4);
            Scanner sc = new Scanner(System.in);
            if (sc.nextInt() == 1)
            {
                killPeople(peopleToKill, this.factions);
                this.attic.feedPopulation(getGlobalPopulation());
            }
            else if (sc.nextInt() == 2)
            {
                int left = this.market.sellFood(peopleToKill*4,this.treasury,this.attic);
                if (left != 0)
                {
                    killPeople(left, this.factions);
                }
                System.out.println(getGlobalPopulation());
                this.attic.feedPopulation(getGlobalPopulation());
            }
        }
    }

    public void killPeople(int peopleToKill, Factions[] factions)
    {
        for (int i = 0; i < peopleToKill ; i++)
        {
            int random = (int) (0 + (Math.random() * (factions.length)));
            factions[random].killPeople();
            decreaseSatisfactionOnDeath(factions);
        }
    }

    public void newPeople(int peopleToAdd)
    {
        Factions[] factions = getFactions();
        for (int i = 0; i < peopleToAdd ; i++)
        {
            int random = (int) (0 + (Math.random() * (factions.length)));
            factions[random].newPeople();
            decreaseSatisfactionOnDeath(factions);
        }
    }

    public void newBirth()
    {
        if (this.agriculture.getPercentage()*40 > getGlobalPopulation()*4)
        {
            int random = (int) (1 + (Math.random() * 10));
            int nbBirth = getGlobalPopulation() * (random/100);
            newPeople(nbBirth);
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

    public void offerBribe()
    {
        System.out.println("Voulez vous payer un pot de vin ? : ");
        int i = 0;
        for (; i < this.factions.length; i++)
        {
            if ( this.factions[i].getSatisfaction() + 10 > 100) {}
            else if ( (this.factions[i].getPopulation() * this.market.getBribePrice()) > this.treasury.getFunds() ) {}
            else
            {
                System.out.println(i +". " + this.factions[i].getName() + " : " +
                        this.factions[i].getPopulation()*this.market.getBribePrice() +
                        "$");
            }
        }

        System.out.println(i +". Non ");

        Scanner sc = new Scanner(System.in);
        int response = sc.nextInt();
        if (response != i)
        {
            this.market.bribe(this.treasury, this.factions[response], this.factions);
            offerBribe();
        }
    }

    public boolean rebellion()
    {
        int total = 0;
        for (Factions faction : this.factions) {
            total = faction.getSatisfaction() * faction.getPopulation();
        }
        total = total / this.getGlobalPopulation();

        return total <= 10;
    }

    public boolean endYear(){
        treasury.annualYield(industry);
        attic.annualYield(agriculture);

        offerBribe();
        feedPopulation();

        attic.updateDurationFood();

        newBirth();

        return rebellion();
    }
}
