/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easybudget;

import java.util.Objects;

/**
 *
 * @author John
 * This class manages the values in the users bank account.
 * It stores the values of their checking and banking account, and 
 * stores a name for the account
 */
public class BankAccount {
    
    private final String ACCOUNT_NAME;
    private int savingsAmount;
    private int checkingAmount;
    
    public BankAccount(String name, int savingsAmount, int checkingAmount){
        ACCOUNT_NAME = name;
        this.savingsAmount = savingsAmount;
        this.checkingAmount = checkingAmount;
    }

    public int getSavingsAmount() {
        return savingsAmount;
    }

    public void setSavingsAmount(int savingsAmount) {
        this.savingsAmount = savingsAmount;
    }

    public int getCheckingAmount() {
        return checkingAmount;
    }

    public void setCheckingAmount(int checkingAmount) {
        this.checkingAmount = checkingAmount;
    }

    public String getACCOUNT_NAME() {
        return ACCOUNT_NAME;
    }
    
    public void checkingDeposit(int cash){
        checkingAmount += cash; 
    }
    
    public void savingsDeposit(int cash){
        savingsAmount += cash;
    }
    
    public void savingsWithdrawal(int cash){
        if(!this.isSavingsEmpty()){
            savingsAmount -= cash;
            
            if(savingsAmount < 0){
                savingsAmount = 0;
            }
        }
    }
    
    public void checkingWithdrawal(int cash){
        if(!this.isCheckingEmpty()){
            checkingAmount -= cash;
            
            if(checkingAmount < 0){
                checkingAmount = 0;
            }
        }
    }
    
    public boolean isSavingsEmpty(){
        if(savingsAmount == 0)
            return true;
        return false;
    }
    
    public boolean isCheckingEmpty(){
        if(checkingAmount == 0)
            return true;
        return false;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.ACCOUNT_NAME);
        hash = 17 * hash + this.savingsAmount;
        hash = 17 * hash + this.checkingAmount;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BankAccount other = (BankAccount) obj;
        if (this.savingsAmount != other.savingsAmount) {
            return false;
        }
        if (this.checkingAmount != other.checkingAmount) {
            return false;
        }
        if (!Objects.equals(this.ACCOUNT_NAME, other.ACCOUNT_NAME)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "BankAccount{" + "ACCOUNT_NAME=" + ACCOUNT_NAME + 
                ", savingsAmount=" + savingsAmount + ", checkingAmount=" + checkingAmount + '}';
    }
}
 