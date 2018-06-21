/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easybudget;

/**
 *
 * @author John
 */
public class spendingData {
    
    //data fields for the amount of cash in wallet, maximum spending amount, 
    // amount for food, clothes, recreation, and emergencies
    private int walletAmount , spendingCap , foodFunds , clothesFunds , 
            recreationFunds , emergencyFunds;
    
    //default constructor sets all data fields to zero
    spendingData()
    {
        this(0,0,0,0,0,0);
    }
    
    //this constructor sets all data fields to their input amount
    spendingData(int amountWallet , int capforSpending , int fundsforFood , 
            int fundsforClothes , int fundsforRecreation , int fundsforEmergency)
    {
        walletAmount = amountWallet;
        spendingCap = capforSpending;
        foodFunds = fundsforFood;
        clothesFunds = fundsforClothes;
        recreationFunds = fundsforRecreation;
        emergencyFunds = fundsforEmergency;
    }
    
    //mutator methods for the six data fields
    public void setWalletAmount(int amountWallet)
    {
        walletAmount = amountWallet;
    }
    
    public void setSpendingCap(int capSpending)
    {
        spendingCap = capSpending;
    }
    
    public void setFoodFund(int fundFood)
    {
        foodFunds = fundFood;
    }
    
    public void setClothesFunds(int fundClothes)
    {
        clothesFunds = fundClothes;
    }
    
    public void setRecFunds(int recFunds)
    {
        recreationFunds = recFunds;
    }
    
    public void setEMF(int emFunds)
    {
        emergencyFunds = emFunds;
    }
    
    //accessor methods for six data fields
    public int getWallet()
    {
        return this.walletAmount;
    }
    
    public int getSpendCap()
    {
        return this.spendingCap;
    }
    
    public int getFoodFund()
    {
        return this.foodFunds;
    }
    
    public int getClothesFunds()
    {
        return this.clothesFunds;
    }
    
    public int getRecFunds()
    {
        return this.recreationFunds;
    }
    
    public int getEMF()
    {
        return this.emergencyFunds;
    }
    
    //prints the data fields of a spendingData object
    public void displayStats()
    {
        System.out.println("Wallet amount: "+this.getWallet());
        System.out.println("Spending cap: "+this.spendingCap);
        System.out.println("Food budget: "+this.getFoodFund());
        System.out.println("Clothes budget: "+this.getClothesFunds());
        System.out.println("Recreation budget: "+this.getRecFunds());
        System.out.println("Emergency funds: "+this.emergencyFunds);
    }
    
    public static void main(String [] args)
    {
        spendingData myWallet = new spendingData(20,15,10,0,5,0);
        myWallet.displayStats();
    }
}
