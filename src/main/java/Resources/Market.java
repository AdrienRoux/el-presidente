package Resources;

public class Market {

    private int price;

    public Market(int price){
        this.price = price;
    }

    public int sellFood(int quantity, Treasury treasury, Attic attic)
    {
        int wallet = treasury.getFunds();
        int left = 0;
        if (quantity*8 > wallet)
        {
            left = (int)Math.ceil(quantity - treasury.getFunds()/8);
            quantity = quantity - left;
            left = (int)Math.ceil(left/4.0);
        }
        treasury.buyFood(this.price,quantity);
        attic.addBatch(quantity);

        return left;
    }
}
