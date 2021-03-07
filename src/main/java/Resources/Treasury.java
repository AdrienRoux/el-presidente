package Resources;

public class Treasury {

    private int funds;

    public Treasury(int funds){
        this.funds = funds;
    }

    public int getFunds() {
        return funds;
    }

    public void annualYield(Industry industry)
    {
        this.funds = this.funds + industry.getPercentage()*10;
    }

    public void buyFood(int price, int quantity)
    {
        this.funds = this.funds - (price*quantity);
    }
}
