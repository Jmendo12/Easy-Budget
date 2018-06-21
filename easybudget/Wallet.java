/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easybudget;

/**
 *
 * @author John
 * The wallet manages a user's on-hands funds.
 * The wallet has a total amount of cash that the user is carrying 
 * on their person
 */
public class Wallet {

    private int inHandCash;
    
    public Wallet(int totalCash){
        this.inHandCash = totalCash;
    }
    
    public int getinHandCash() {
        return inHandCash;
    }

    public void setinHandCash(int totalCash) {
        this.inHandCash = totalCash;
    }
    
    public void addFunds(int cash){
        inHandCash += cash;
    }
    
    public void removeFunds(int cash){
        //If the wallet is non-zero, remove cash amount from wallet.
        if(!this.isEmpty()){
            inHandCash -= cash;
            //If the value in the wallet is less than zero, set wallet value to
            //zero.
            if( inHandCash < 0){
                inHandCash = 0;
            }
        }
    }
    
    public boolean isEmpty(){
        if(inHandCash == 0)
            return true;
        return false;
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.inHandCash;
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
        final Wallet other = (Wallet) obj;
        if (this.inHandCash != other.inHandCash) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Wallet{" + "inHandCash=" + inHandCash + '}';
    }
}
