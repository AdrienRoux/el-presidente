package ResourcesTest;

import Factions.Factions;
import Resources.Agriculture;
import Resources.Attic;
import Resources.Industry;
import Resources.Treasury;
import junit.framework.TestCase;
import org.junit.Test;

public class TestTreasury extends TestCase
{
    Treasury treasury;
    Industry industry;

    public void setUp()
    {
        industry = new Industry(50);
        treasury = new Treasury(500);
    }

    public void testAnnualYield()
    {
        treasury.annualYield(industry);
        assertEquals(1000, treasury.getFunds());
    }

    public void testBuyFood()
    {
        treasury.buyFood(8,50);
        assertEquals(100, treasury.getFunds());
    }


}
