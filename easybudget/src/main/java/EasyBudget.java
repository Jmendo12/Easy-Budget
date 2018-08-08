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
import java.util.Scanner;


public class EasyBudget {

    //private Window window;
    private String userName;
    private BudgetManager userBudget;
    private int totalExpenses;
    private int totalAssets;
    private int usableAssets;
    private int expensePayDifference;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public void budgetAssets(){
        this.totalAssets = this.userBudget.calculateTotalAssets();
        this.usableAssets = this.userBudget.calculateUsableAssets();
    }

    public void budgetExpenses(){
        this.totalExpenses = this.userBudget.calculateExpenses();
    }

    public int budgetUserWallet(){
        int walletAmount = userBudget.calculateWalletMax();
        return walletAmount;
    }

    public void payExpenses(){
        int difference = userBudget.calculateDifference(this.totalExpenses, this.totalAssets);
        this.expensePayDifference = this.totalAssets - difference;
        this.totalAssets -= expensePayDifference;
        this.userBudget.setExpensesPaid();
    }

    public void init(Scanner sc){
        //Declare variables for object creation
        int checkingAmount, savingsAmount, walletAmount, debtAmount, foodExpenses, recreationExpenses;
        BankAccount userAcc;
        Wallet userWallet;
        Expenses userDebt, userFoodExpenses, userRecExpenses;
        BudgetManager userBudget;
        //Prompt user for values
        System.out.print("Hello, welcome to EasyBudget, please enter a username: ");
        this.userName = sc.nextLine();
        System.out.print("Please enter a cash value for the amount in your checking account: ");
        checkingAmount = sc.nextInt();
        System.out.print("Please enter a cash value for the amount in your savings account: ");
        savingsAmount = sc.nextInt();
        System.out.print("Please enter a cash value for the amount in your wallet: ");
        walletAmount = sc.nextInt();
        System.out.print("Please enter a cash value for any debt amount owed, if any: ");
        debtAmount = sc.nextInt();
        System.out.print("Please enter a cash value for any food expenses, if any: ");
        foodExpenses = sc.nextInt();
        System.out.print("Please enter a cash value for any recreational expenses, if any: ");
        recreationExpenses = sc.nextInt();
        //Create objects with user defined values & add expenses to the ArrayList
        userAcc = new BankAccount(this.userName, savingsAmount, checkingAmount);
        userWallet = new Wallet(walletAmount);
        userDebt = new Debt(debtAmount);
        userFoodExpenses = new FoodExpenses(foodExpenses);
        userRecExpenses = new RecreationExpenses(recreationExpenses);
        userBudget = new BudgetManager(userAcc, userWallet);
        userBudget.addExpense(userDebt);
        userBudget.addExpense(userFoodExpenses);
        userBudget.addExpense(userRecExpenses);
        //Set this object's userBudget
        this.userBudget = userBudget;
    }

    @Override
    public String toString() {
        return "EasyBudget{" +
                "userBudget=" + userBudget +
                ", totalExpenses=" + totalExpenses +
                ", totalAssets=" + totalAssets +
                ", usableAssets=" + usableAssets +
                "expensePayDifference=" + expensePayDifference +
                '}';
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        EasyBudget userEB = new EasyBudget();
        userEB.init(sc);
        userEB.budgetAssets();
        userEB.budgetExpenses();
        userEB.payExpenses();
        System.out.println(userEB.toString());
    }
}

