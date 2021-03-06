package WorldTest;

import Factions.Factions;
import History.Scenario;
import Resources.*;
import World.Island;
import junit.framework.TestCase;

import java.lang.reflect.Array;


public class TestIsland extends TestCase{


    public void setUp()
    {
        Treasury treasury = new Treasury(500);
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

        Island island = new Island("ile",factions,agriculture,industry,treasury,scenario,attic,market);
    }


    public void test()
    {

    }
}
