package Resources;

public class FoodBatch {

    private int foodQuantity;
    private int lifeTime;

    public FoodBatch(int foodQuantity, int lifeTime) {
        this.foodQuantity = foodQuantity;
        this.lifeTime = lifeTime;
    }

    public int getFoodQuantity() {
        return foodQuantity;
    }

    public int getLifeTime() {
        return lifeTime;
    }

    public void setFoodQuantity(int foodQuantity) {
        this.foodQuantity = foodQuantity;
    }

    public void setLifeTime(int lifeTime) {
        this.lifeTime = lifeTime;
    }

    public void addYear()
    {
        this.lifeTime ++;
    }
}
