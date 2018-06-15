/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package easybudget;
import java.io.*;
import java.util.*;
/**
 *
 * @author John
 */
import java.util.*;

public class EasyBudget {

    /**
     * @param args the command line arguments
     */
    private bankData myBank;
    private spendingData myWallet;
    
    private  static File toWrite = new File("PersonalBudget.txt");
    
    private static Stack<EasyBudget> currentweeksBudget = new Stack();
    private static Stack<EasyBudget> lastweeksBudget = new Stack();
    
    EasyBudget()
    {
        myBank = new bankData();
        myWallet = new spendingData();
        
    }
    
        static boolean toRun(int input){
            return input == 1;
        }
        
        static void promptUser(int key){
        switch (key) {
            case 0:
                System.out.print("Please enter a cash value for the amount "
                        +  "in your savings account: ");
                break;
            case 1:
                System.out.print("Please enter a cash value for "
                        + "your checking account: ");
                break;
            case 2:
                System.out.print("Please enter a cash value for "
                        + "how much you would like to withdraw this week: ");
                break;
            case 3:
                System.out.print("Please enter a cash value for "
                        + "how much you would like to deposit this week: ");
                break;
            case 4:
                System.out.print("Please enter a cash value for "
                        + "how much you would like to transfer this week: ");
                break;
            default:
                System.out.println("That code is not recognized");
                break;
        }
                
        }
        
        static boolean checkChecking(String answer){
            String userAnswer = answer;
        String toLowerCase = userAnswer.toLowerCase();
            
            if(toLowerCase.equals("checking")){
                return true;
            }
            else
                return false;
        }
        
    
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        Scanner userInput = new Scanner(System.in);
        FileWriter writeFile = null;
        
        
        try{
            writeFile = new FileWriter(toWrite);
            //writeFile()
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        catch(Exception e){
            System.out.println("Something went wrong, aborting");
            return;
        }
        
        int userAnswer = 0;
        
        System.out.println("Hello, welcome to EasyBudget! ");
        System.out.print("Press 0 to exit, or 1 to create a "
                + "budget for this week! : ");
        userAnswer = userInput.nextInt();
        
        boolean run = toRun(userAnswer);
        
        if(run == true)
        {
            EasyBudget weeksBudget = new EasyBudget();
            currentweeksBudget.push(weeksBudget);
            
            promptUser(0);
            int savings = userInput.nextInt();
            weeksBudget.myBank.setSavings(savings);
            
            promptUser(1);
            int checking = userInput.nextInt();
            weeksBudget.myBank.setChecking(checking); 
            
            promptUser(2);
            int withdrawal = userInput.nextInt();
            weeksBudget.myBank.setWithdraw(withdrawal);
            weeksBudget.myWallet.setWalletAmount(withdrawal);
            
            if(withdrawal != 0)
            {
                System.out.print("Did you withdraw from checking or savings?: ");
                String userWithdrawal = userInput.next();
                
                boolean fromChecking = checkChecking(userWithdrawal);
                
                if(fromChecking == true){
                    weeksBudget.myBank.setChecking(weeksBudget.myBank.getChecking() 
                            - withdrawal);
                }
                
                else if(fromChecking == false){
                    weeksBudget.myBank.setSavings(weeksBudget.myBank.getSavings()
                            - withdrawal);
                }
            }
            
            promptUser(3);
            int deposit = userInput.nextInt();
            weeksBudget.myBank.setWithdraw(deposit);
            
            if(deposit != 0)
            {
                System.out.print("Did you deposit from checking or savings?: ");
                String userDeposit = userInput.next();
                
                boolean fromChecking = checkChecking(userDeposit);
                
                if(fromChecking == true){
                    weeksBudget.myBank.setChecking(weeksBudget.myBank.getChecking() 
                            + deposit);
                }
                
                else if(fromChecking == false){
                    weeksBudget.myBank.setSavings(weeksBudget.myBank.getSavings()
                            + deposit);
                }
            }
            
            promptUser(4);
            int transfer = userInput.nextInt();
            weeksBudget.myBank.setWithdraw(deposit);
            
            if(transfer != 0)
            {
                System.out.print("Is this transfer from savings to "
                        + "checking or vice versa? Type checking if the funds"
                        + " are transferred to checking, or savings to "
                        + "transfer funds to savings: ");
                String userTransfer = userInput.next();
                
                boolean fromChecking = checkChecking(userTransfer);
                
                if(fromChecking == true)
                {
                    weeksBudget.myBank.setChecking(weeksBudget.myBank.getChecking() 
                            + transfer);
                    weeksBudget.myBank.setSavings(weeksBudget.myBank.
                            getSavings() - transfer);
                }
                else if(fromChecking == false)
                {    
                    weeksBudget.myBank.setSavings(weeksBudget.myBank.getSavings()
                            + transfer);
                    weeksBudget.myBank.setChecking(weeksBudget.myBank.
                            getChecking() - transfer);
                }    
            }
            
            String weeksWallet = "This week you have " +  
                    weeksBudget.myWallet.getWallet() + " in your wallet \n";
            String checkingValue = "This week you have " + 
                    weeksBudget.myBank.getChecking() + " in your "
                    + "checking account \n";
            
            writeFile.write(weeksWallet + "\n");
            writeFile.write(checkingValue + "\n");
            writeFile.close();
        }
    }
    
    
}
