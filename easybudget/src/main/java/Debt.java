public class Debt implements Expenses {

    private int amount;
    private boolean payed;

    public Debt(int amount) {
        this.amount = amount;
        this.payed = false;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int cash) {
        this.amount = cash;
    }
}
