package ResourcesTest;

import Factions.Factions;
import History.Scenario;
import Resources.*;
import World.Island;
import junit.framework.TestCase;

public class TestAttic extends TestCase
{
    private Attic attic;
    private Agriculture agriculture;
    private Factions[] factions;

    public void setUp()
    {
        factions = new Factions[3];
        Factions faction1 = new Factions("faction 1", 60,50);
        Factions faction2 = new Factions("faction 2", 65,50);
        Factions faction3 = new Factions("faction 3", 70,50);
        factions[0] = faction1;
        factions[1] = faction2;
        factions[2] = faction3;
        agriculture = new Agriculture(50);
        attic = new Attic(500);
        attic.addBatch(200);
    }

    public void testUpdateDurationFood()
    {
        attic.updateDurationFood();
        assertEquals(1, attic.getFoodStocked().get(0).getLifeTime());
        assertEquals(500, attic.getFoodStocked().get(0).getFoodQuantity());
        assertEquals(1, attic.getFoodStocked().get(1).getLifeTime());
        assertEquals(200, attic.getFoodStocked().get(1).getFoodQuantity());
    }

    public void testGetAllFoodStocked()
    {
        assertEquals(700, attic.getAllFoodStocked());
    }

    public void testConsumeFood()
    {
        attic.consumeFood(250);
        assertEquals(450, attic.getAllFoodStocked());
        attic.consumeFood(250);
        assertEquals(200, attic.getAllFoodStocked());
        assertEquals(1, attic.getListSize());
    }

    public void testAnnualYield()
    {
        attic.annualYield(agriculture);
        assertEquals(3, attic.getListSize());
        assertEquals(2700, attic.getAllFoodStocked());
    }

    public void testisThereEnougthFood()
    {
        assertTrue(attic.isThereEnougthFood(factions));
    }

    public void testFeedPopulation()
    {
        attic.feedPopulation(150);
        assertEquals(100, attic.getAllFoodStocked());
        assertEquals(1, attic.getListSize());
        assertEquals(1, attic.getFoodStocked().get(0).getLifeTime());
        assertEquals(100, attic.getFoodStocked().get(0).getFoodQuantity());
    }

}
