package Resources;

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

    public void feedPopulation(){}

}
