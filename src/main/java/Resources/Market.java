package Resources;

public class Market {

    private int price;

    public void sellFood(int quantity, Treasury treasury, Attic attic)
    {
        treasury.buyFood(this.price,quantity);
        attic.addBatch(quantity);
    }
}
