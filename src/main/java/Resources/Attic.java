package Resources;

import Factions.Factions;

import java.util.ArrayList;

public class Attic {

    private ArrayList<FoodBatch> foodStocked;

    public void annualYield(Agriculture agriculture)
    {
        int quantity = agriculture.getPercentage()*4000;
        this.foodStocked.add(new FoodBatch(quantity,0 ));
    }

    public void addBatch(int quantity)
    {
        this.foodStocked.add(new FoodBatch(quantity,0 ));
    }

    public void feedPopulation(Factions[] factions)
    {
        int globalPopulation = 0;
        for(int i = 0; i < factions.length; i++)
        {
            globalPopulation = globalPopulation + factions[i].getPopulation();
        }
        int neededFood = globalPopulation*4;
        int globalFood = getAllFoodStocked();

        if(neededFood < globalFood)
        {

        }
        else
        {
            // display pas assez de bouf go acheter
        }
    }

    public void consumeFood(int neededFood)
    {
        int i = 0;
        while (neededFood > 0 )
        {
            int stock = this.foodStocked.get(i).getFoodQuantity();
            
        }
    }

    public int getAllFoodStocked()
    {
        int globalFood = 0;

        for (int i = 0; i<this.foodStocked.size(); i++)
        {
            globalFood = globalFood + foodStocked.get(i).getFoodQuantity();
        }

        return globalFood;
    }

}
