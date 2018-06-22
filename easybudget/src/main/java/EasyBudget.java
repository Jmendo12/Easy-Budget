/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.util.Stack;

/**
 * @author John
 */

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

            return toLowerCase.equals("checking");
        }
        

}
