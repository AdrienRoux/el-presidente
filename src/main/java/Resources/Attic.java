package Resources;

import Factions.Factions;

import java.util.ArrayList;

public class Attic {

    private ArrayList<FoodBatch> foodStocked;

    public Attic(int quantity){
        this.foodStocked = new ArrayList<>();
        this.addBatch(quantity);
    }

    public ArrayList<FoodBatch> getFoodStocked()
    {
        return foodStocked;
    }

    public int getListSize()
    {
        return this.foodStocked.size();
    }

    public void annualYield(Agriculture agriculture)
    {
        int quantity = agriculture.getPercentage()*40;
        this.foodStocked.add(new FoodBatch(quantity,0 ));
    }

    public void addBatch(int quantity)
    {
        if (quantity > 0){
            this.foodStocked.add(new FoodBatch(quantity,0 ));
        }
    }

    public boolean isThereEnougthFood(Factions[] factions)
    {
        int globalPopulation = 0;
        for (Factions faction : factions) {
            globalPopulation = globalPopulation + faction.getPopulation();
        }
        int neededFood = globalPopulation * 4;
        int globalFood = getAllFoodStocked();

        if( neededFood <= globalFood)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void feedPopulation(int globalPopulation)
    {
        int neededFood = globalPopulation * 4;

        consumeFood(neededFood);
        updateDurationFood();
    }

    public void consumeFood(int neededFood)
    {
        while (neededFood > 0 )
        {
            int stock = this.foodStocked.get(0).getFoodQuantity();
            if (stock > neededFood)
            {
                this.foodStocked.get(0).setFoodQuantity(stock-neededFood);
                neededFood = 0;
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
        for (FoodBatch foodBatch : this.foodStocked)
        {
            foodBatch.addYear();
        }
    }

    public int getAllFoodStocked()
    {
        int globalFood = 0;

        for (FoodBatch foodBatch : this.foodStocked)
        {
            globalFood = globalFood + foodBatch.getFoodQuantity();
        }

        return globalFood;
    }

}
