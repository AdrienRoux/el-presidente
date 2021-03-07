package Resources;

import Factions.Factions;

public class Market {

    private int foodPrice;
    private int bribePrice;

    public Market(int price){
        this.foodPrice = price;
        this.bribePrice = 15;
    }

    public int getFoodPrice() {
        return foodPrice;
    }

    public int getBribePrice() {
        return bribePrice;
    }

    public int sellFood(int quantity, Treasury treasury, Attic attic)
    {
        int wallet = treasury.getFunds();
        int left = 0;
        if (quantity*8 > wallet)
        {
            left = (int)Math.ceil(quantity - treasury.getFunds()/this.foodPrice);
            quantity = quantity - left;
            left = (int)Math.ceil(left/4.0);
        }
        treasury.buyFood(this.foodPrice,quantity);
        attic.addBatch(quantity);

        return left;
    }

    public void bribe(Treasury treasury, Factions faction, Factions[] factions)
    {
        int peopleFaction = faction.getPopulation();
        int amount = peopleFaction * this.bribePrice;
        treasury.payBribe(amount);
        faction.setSatisfaction(faction.getSatisfaction() + 10);

        for ( int i = 0 ; i < factions.length; i++)
        {
            if (factions[i].getName().equals("NATIONALISTS"))
            {
                factions[i].decreaseSatisfaction(amount/10);
            }
        }

    }


}
