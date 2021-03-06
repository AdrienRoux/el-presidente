package Resources;

import Factions.Factions;

import java.util.ArrayList;

public class Attic {

    private ArrayList<FoodBatch> foodStocked;

    public Attic(int quantity){
        this.addBatch(quantity);
    }

    public void annualYield(Agriculture agriculture)
    {
        int quantity = agriculture.getPercentage()*4000;
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

        return neededFood <= globalFood;
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
        for (FoodBatch foodBatch : this.foodStocked) {
            foodBatch.addYear();
        }
    }

    public int getAllFoodStocked()
    {
        int globalFood = 0;

        for (FoodBatch foodBatch : this.foodStocked) {
            globalFood = globalFood + foodBatch.getFoodQuantity();
        }

        return globalFood;
    }

}
