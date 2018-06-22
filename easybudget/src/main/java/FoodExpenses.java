/*This class is used to track all food related expenses*/
public class FoodExpenses implements Expenses{

    private int amount;
    private boolean payed;

    public FoodExpenses(int amount) {
        this.amount = amount;
        this.payed = false;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    public void setAmount(int cash) {
        amount = cash;
    }

    public int getAmount() {
        return amount;
    }
}
