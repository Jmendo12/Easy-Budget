/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author John
 * This class manages the user's budget via calculations based off the bank
 * account. It determines how much the user should have in their wallet,
 * how much is needed for necessities, and how much can be spent on recreation 
 */
public class BudgetManager {
    
    private ArrayList<Expenses> userExpenses;
    private BankAccount userAccount;
    private Wallet userWallet;
    
    private int necessityFunds;
    private int recreationFunds;
    //Determines max amount a user should have in their wallet - 2% of
    // checking balance.
    private final double WALLET_FACTOR = .02;

    public BudgetManager(BankAccount userAccount, Wallet userWallet) {
        this.userExpenses = new ArrayList<Expenses>();
        this.userAccount = userAccount;
        this.userWallet = userWallet;
    }

    public BankAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(BankAccount userAccount) {
        this.userAccount = userAccount;
    }

    public Wallet getUserWallet() {
        return userWallet;
    }

    public void setUserWallet(Wallet userWallet) {
        this.userWallet = userWallet;
    }

    public int getNecessityFunds() {
        return necessityFunds;
    }

    public void setNecessityFunds(int necessityFunds) {
        this.necessityFunds = necessityFunds;
    }

    public int getRecreationFunds() {
        return recreationFunds;
    }

    public void setRecreationFunds(int recreationFunds) {
        this.recreationFunds = recreationFunds;
    }

    public void addExpense(Expenses expense){
        this.userExpenses.add(expense);
    }

    public int calculateExpenses(){
        int sum = 0;
        for(int i = 0; i < userExpenses.size(); i++){
            Expenses expense = userExpenses.get(i);
            sum += expense.getAmount();
        }
        return sum;
    }

    //This method determines a maximum amount of cash a user should have in their wallet depending on their bank account
    public int calculateWalletMax(){
        int walletMax = (int) (this.WALLET_FACTOR * this.userAccount.getCheckingAmount());
        return  walletMax;
    }
    //This method calculates a user's total cash including their savings account
    public int calculateTotalAssets(){
        int sum = this.userWallet.getinHandCash() + this.userAccount.getCheckingAmount() +
                this.userAccount.getSavingsAmount();
        return sum;
    }
    //This method calculates a user's usable cash, which is their assets not including their savings account
    public int calculateUsableAssets(){
        int sum = this.userWallet.getinHandCash() + this.userAccount.getCheckingAmount();
        return sum;
    }
    //Calculates whether the user does or does not have enough cash to pay their expenses
    public int calculateDifference(int expenses, int assets){
        int sum = expenses - assets;
        return sum;
    }
}
