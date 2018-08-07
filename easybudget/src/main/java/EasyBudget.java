/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author John
 * This class serves as the controller of the BudgetManager. It relays expenses
 * and assets to the output.
 */

public class EasyBudget {

    //private Window window;
    private BudgetManager userBudget;
    private int totalExpenses;
    private int totalAssets;
    
    EasyBudget(BudgetManager userBudget){
        //this.window = new Window();
        this.userBudget = userBudget;
        this.totalAssets = this.userBudget.calculateTotalAssets();
        this.totalExpenses = this.userBudget.calculateExpenses();
    }

    public BudgetManager getUserBudget() {
        return userBudget;
    }

    public void setUserBudget(BudgetManager userBudget) {
        this.userBudget = userBudget;
    }

    public int getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(int totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public int getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(int totalAssets) {
        this.totalAssets = totalAssets;
    }

    public int budgetUserWallet(){
        int walletAmount = userBudget.calculateWalletMax();
        return walletAmount;
    }

    public int budgetUserExpenses(){
        int totalExpenses = userBudget.calculateExpenses();
        return totalExpenses;
    }

    public int budgetTotalUserAssets(){
        int totalAssets = userBudget.calculateTotalAssets();
        return totalAssets;
    }

    public int budgetUsableAssets(){
        int usableAssets = userBudget.calculateUsableAssets();
        return usableAssets;
    }

    public int payExpenses(){
        int difference = userBudget.calculateDifference(this.totalExpenses, this.totalAssets);
        return difference;
    }

    @Override
    public String toString() {
        return "EasyBudget{" +
                "userBudget=" + userBudget +
                ", totalExpenses=" + totalExpenses +
                ", totalAssets=" + totalAssets +
                '}';
    }
}

