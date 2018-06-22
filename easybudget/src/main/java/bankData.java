/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author John
 */
public class bankData {
    
    //data fields for amount of money in savings account, and checking account.
    //data fields for amounts for withdrawal, deposit, and transfer
    private int savingsAmount , checkingAmount , withdrawAmount , depositAmount, 
            transferAmount;
    
    //data fields that determine if transfer, withdrawal, or deposit will be made
    private boolean transfer = false;
    private boolean withdraw = false;
    private boolean deposit = false;
    
    //default contrstructor
    bankData()
    {
        this(0,0);
    }
    
    //constructor that sets savings and checking amount
    bankData(int amountSavings, int amountChecking)
    {
        savingsAmount = amountSavings;
        checkingAmount = amountChecking;
    }
    
    //mutator methods below
    //*Note: set methods for transfer, withdrawal, and deposit rely on their 
    //individual boolean answers
    public void setSavings(int amountSavings)
    {
        savingsAmount = amountSavings;
    }
    
    public void setChecking(int amountChecking)
    {
        checkingAmount = amountChecking;
    }
    
    public void setWithdraw(int amountWithdraw)
    {
        if(withdraw = false)
        {
            withdrawAmount = 0;
        }
        else
            withdrawAmount = amountWithdraw;
    }
    
    public void setDeposit(int amountDeposit)
    {
        if(deposit = false)
        {
            depositAmount = 0;
        }
        else
            depositAmount = amountDeposit;
    }
    
    public void setTransfer(int amountTransfer)
    {
        if(transfer = false)
        {
            transferAmount = 0;
        }
        else
            transferAmount = amountTransfer;
            
    }
    
    //retreival methods
    public int getSavings()
    {
        return this.savingsAmount;
    }
    
    public int getChecking()
    {
        return this.checkingAmount;
    }
    
    public int getWithdraw()
    {
        return this.withdrawAmount;
    }
    
    public int getDeposit()
    {
        return this.depositAmount;
    }
    
    public int getTransfer()
    {
        return this.transferAmount;
    }
    
    //mutator methods for withdraw, deposit, and transfer booleans
    public void toWithdraw(boolean answer)
    {
        withdraw = answer;
    }
    
    public void toDeposit(boolean answer)
    {
        deposit = answer;
    }
    
    public void toTransfer(boolean answer)
    {
        transfer = answer;
    }
    
    //method that displays the data of the bankData object
    public void displayData()
    {
        System.out.println("Savings amount: "+this.getSavings());
        System.out.println("Checking amount: "+this.getChecking());
        
        if(withdraw = true)
        
            System.out.println("You withdrew: "+this.getWithdraw());
        
        else
            System.out.println("You did not make a withdrawal");
        
        if(deposit = true)
            System.out.println("You deposited: "+this.getDeposit());
        else
            System.out.println("You did not make a deposit");
        
        if(transfer = true)
            System.out.println("You transferred: "+this.getTransfer());
        else
            System.out.println("You did not make a transfer");
    }
}
