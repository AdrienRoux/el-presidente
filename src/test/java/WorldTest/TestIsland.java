package WorldTest;

import Factions.Factions;
import History.Scenario;
import Resources.*;
import World.Island;
import junit.framework.TestCase;

import java.lang.reflect.Array;


public class TestIsland extends TestCase{

    public Island island;
    
    public void setUp()
    {
        Treasury treasury = new Treasury(20000);
        Agriculture agriculture = new Agriculture(50);
        Industry industry = new Industry(50);
        Attic attic = new Attic(500);
        Scenario scenario = new Scenario("akha","akkhhhaaaaaa", null);
        Factions[] factions = new Factions[3];
        Factions faction1 = new Factions("facion 1", 60,50);
        Factions faction2 = new Factions("facion 2", 65,50);
        Factions faction3 = new Factions("facion 3", 70,50);
        factions[0] = faction1;
        factions[1] = faction2;
        factions[2] = faction3;
        Market market = new Market(8);

        island = new Island("ile",factions,agriculture,industry,treasury,scenario,attic,market);
    }


    public void testGetGlobalPopulation()
    {
         assertEquals(150, island.getGlobalPopulation());
    }

    public void testDecreaseSatisfactionOnDeath()
    {
        island.decreaseSatisfactionOnDeath(island.getFactions());
        assertEquals(58,island.getFactions()[0].getSatisfaction());
        assertEquals(63,island.getFactions()[1].getSatisfaction());
        assertEquals(68,island.getFactions()[2].getSatisfaction());
    }

    public void testKillPeople()
    {
        island.killPeople(10,island.getFactions());
        assertEquals(40,island.getFactions()[0].getSatisfaction());
        assertEquals(45,island.getFactions()[1].getSatisfaction());
        assertEquals(50,island.getFactions()[2].getSatisfaction());
        assertEquals(140, island.getGlobalPopulation());
    }

    public void testFeedPopulation()
    {
        island.feedPopulation();
        assertEquals(140, island.getGlobalPopulation());
        assertEquals(4,island.getTreasury().getFunds());
        assertEquals(2, island.getAttic().getAllFoodStocked());
    }

    public void testOfferBribe()
    {
        island.offerBribe();
    }
}
