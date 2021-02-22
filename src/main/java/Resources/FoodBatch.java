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
}
