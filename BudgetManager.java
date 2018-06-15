/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easybudget;

/**
 *
 * @author John
 * This class manages the user's budget via calculations based off the bank
 * account. It determines how much the user should have in their wallet,
 * how much is needed for necessities, and how much can be spent on recreation 
 */
public class BudgetManager {
    
    private BankAccount userAccount;
    private Wallet userWallet;
    
    private int necessityFunds;
    private int recreationFunds;
    //Determines max amount a user should have in their wallet - 2% of
    // checking balance.
    private final double WALLET_FACTOR = .02;
}
