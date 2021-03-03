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

        // split la fonction - inverser la responsabiliter avec un boolean dans l'island sur la qtt de nourriture
        int globalPopulation = 0;
        for(int i = 0; i < factions.length; i++)
        {
            globalPopulation = globalPopulation + factions[i].getPopulation();
        }
        int neededFood = globalPopulation * 4;
        int globalFood = getAllFoodStocked();

        if(neededFood < globalFood)
        {
            consumeFood(neededFood);
            updateDurationFood();
        }
        else
        {
            // display pas assez de nourriture go acheter
        }
    }

    public void consumeFood(int neededFood)
    {
        while (neededFood > 0 )
        {
            int stock = this.foodStocked.get(0).getFoodQuantity();
            if (stock > neededFood)
            {
                neededFood = 0;
                this.foodStocked.get(0).setFoodQuantity(stock-neededFood);
            }
            else if (stock <= neededFood)
            {
                neededFood = neededFood - stock;
                this.foodStocked.remove(0);
            }
        }
    }

    public void updateDurationFood()
    {
        for (int i = 0 ; i < this.foodStocked.size() ; i++)
        {
            this.foodStocked.get(i).addYear();
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
