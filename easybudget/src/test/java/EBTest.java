/*
    Class for testing all logical classes and their functions contained in main source package
    Tested interfaces: Expenses
    Tested classes: Wallet, BankAccount, Debt, FoodExpenses, RecreationExpenses, BudgetManager, EasyBudget
    NOTE: Excludes IDE Generated methods (Setters, Getters, toStrings, equals, and hashCodes)
 */
public class EBTest {


    private boolean testWalletRemoval(int transactionAmount, Wallet wallet){
        int expectedValue = wallet.getinHandCash() - transactionAmount;
        wallet.removeFunds(transactionAmount);
        return expectedValue == wallet.getinHandCash();
    }

    private boolean testWalletAdd(int transactionAmount, Wallet wallet){
        int expectedValue = wallet.getinHandCash() + transactionAmount;
        wallet.addFunds(transactionAmount);
        return expectedValue == wallet.getinHandCash();
    }

    private boolean testWalletEmptyness(int walletAmount, Wallet wallet){
        wallet.setinHandCash(walletAmount);
        return wallet.isEmpty();
    }

    private boolean testCheckingDeposit(int transactionAmount, BankAccount account){
        int expectedValue = account.getCheckingAmount() + transactionAmount;
        account.checkingDeposit(transactionAmount);
        return expectedValue == account.getCheckingAmount();
    }

    private boolean testSavingDeposit(int transactionAmount, BankAccount account){
        int expectedValue = account.getSavingsAmount() + transactionAmount;
        account.savingsDeposit(transactionAmount);
        return expectedValue == account.getSavingsAmount();
    }

    private boolean testCheckingWithdrawal(int transactionAmount, BankAccount account){
        int expectedValue = account.getCheckingAmount() - transactionAmount;
        account.checkingWithdrawal(transactionAmount);
        return expectedValue == account.getCheckingAmount();
    }

    private boolean testSavingsWithdrawal(int transactionAmount, BankAccount account){
        int expectedValue = account.getSavingsAmount() - transactionAmount;
        account.savingsWithdrawal(transactionAmount);
        return expectedValue == account.getSavingsAmount();
    }

    private boolean testCheckingEmptyness(int checkingAmount, BankAccount account){
        account.setCheckingAmount(checkingAmount);
        return account.isCheckingEmpty();
    }

    private boolean testSavingEmptyness(int savingAmount, BankAccount account){
        account.setSavingsAmount(savingAmount);
        return account.isSavingsEmpty();
    }

    private boolean testWalletCalculate(int expectedValue, BudgetManager testBudget){
        int calculatedValue = testBudget.calculateWalletMax();
        return expectedValue == calculatedValue;
    }

    private boolean testExpensesCalculate(int expectedValue, BudgetManager testBudget){
        int calculatedValue = testBudget.calculateExpenses();
        return expectedValue == calculatedValue;
    }

    private boolean testTotalAssetsCalculate(int expectedValue, BudgetManager testBudget){
        int calculatedValue = testBudget.calculateTotalAssets();
        return expectedValue == calculatedValue;
    }

    private boolean testUsableAssetsCalculate(int expectedValue, BudgetManager testBudget){
        int calculatedValue = testBudget.calculateUsableAssets();
        return expectedValue == calculatedValue;
    }

    private boolean testPayExpenses(int expectedValue, BudgetManager testBudget){
        int expenses = testBudget.calculateExpenses();
        int assets = testBudget.calculateTotalAssets();
        int calculatedValue = testBudget.calculateDifference( expenses, assets);
        return expectedValue == calculatedValue;
    }

    public static void main(String [] args) {
        EBTest test = new EBTest();

        //For testing Wallet and BankAccount methods
        int walletAmount, walletAddAmount, walletRemoveAmount;
        boolean walletCheck;
        int checkingAmount, checkingDepositAmount, checkingWithdrawAmount;
        int savingsAmount, savingsDepositAmount, savingsWithdrawAmount;
        boolean accountCheck;

        /*
            Test Wallet removal, add, and empty function
         */
        walletAmount = 20;
        walletAddAmount = 5;
        walletRemoveAmount = 5;
        walletCheck = false;
        Wallet testWallet = new Wallet(walletAmount);

        walletCheck = test.testWalletRemoval(walletRemoveAmount, testWallet);
        System.out.println("Wallet removal is working as intended: " + walletCheck);
        walletCheck = false;

        walletCheck = test.testWalletAdd(walletAddAmount, testWallet);
        System.out.println("Wallet add is working as intended: " + walletCheck);
        walletCheck = false;

        walletCheck = test.testWalletEmptyness(walletAmount, testWallet);
        System.out.println("Wallet empty check working as intended for a non-empty wallet: " + !walletCheck);
        walletCheck = false;

        walletCheck = test.testWalletEmptyness(0, testWallet);
        System.out.println("Wallet empty check working as intended for an empty wallet: " + walletCheck);
        walletCheck = false;

        /*
            Test deposit, withdrawal, and empty methods for BankAccount checking and savings fields
         */
        checkingAmount = 20;
        savingsAmount = 20;
        checkingDepositAmount = 10;
        savingsDepositAmount = 10;
        savingsWithdrawAmount = 10;
        checkingWithdrawAmount = 10;
        accountCheck = false;
        BankAccount testAccount = new BankAccount("John", savingsAmount, checkingAmount);

        accountCheck = test.testCheckingDeposit(checkingDepositAmount, testAccount);
        System.out.println("Checking deposit working as intended: " + accountCheck);
        accountCheck = false;

        accountCheck = test.testSavingDeposit(savingsDepositAmount, testAccount);
        System.out.println("Saving deposit working as intended: " + accountCheck);
        accountCheck = false;

        accountCheck = test.testCheckingWithdrawal(checkingWithdrawAmount, testAccount);
        System.out.println("Checking withdraw working as intended: " + accountCheck);
        accountCheck = false;

        accountCheck = test.testSavingsWithdrawal(savingsWithdrawAmount, testAccount);
        System.out.println("Saving withdraw working as intended: " + accountCheck);
        accountCheck = false;

        accountCheck = test.testCheckingEmptyness(checkingAmount, testAccount);
        System.out.println("Test for an empty checking account working as intended for a non-empty checking" +
                "account: " + !accountCheck);
        accountCheck = false;

        accountCheck = test.testCheckingEmptyness(0, testAccount);
        System.out.println("Test for an empty checking account working as intended for an empty checking" +
                "account: " + accountCheck);
        accountCheck = false;

        accountCheck = test.testSavingEmptyness(savingsAmount, testAccount);
        System.out.println("Test for an empty saving account working as intended for a non-empty saving account: " +
                !accountCheck);
        accountCheck = false;

        accountCheck = test.testSavingEmptyness(0, testAccount);
        System.out.println("Test for an empty saving account working as intended for an empty saving account: " +
                accountCheck);
        accountCheck = false;

        /*
            Test EasyBudget methods - serves as an indirect test for the logic used in BudgetManager methods
         */
        BudgetManager testManager = new BudgetManager( testAccount, testWallet );
        Expenses testExpense1 = new FoodExpenses(10);
        Expenses testExpense2 = new RecreationExpenses(10);
        testManager.addExpense(testExpense1);
        testManager.addExpense(testExpense2);
        boolean budgetCheck = false;

        //  Initialize expected integer values
        int expectedWalletAmount = (int) BudgetManager.WALLET_FACTOR * testAccount.getCheckingAmount();
        int expectedUsableAssets = testAccount.getCheckingAmount() + testWallet.getinHandCash();
        int expectedTotalAssets = testAccount.getCheckingAmount() + testAccount.getSavingsAmount();
                testWallet.getinHandCash();
        int expectedExpenses = testExpense1.getAmount() + testExpense2.getAmount();
        int expectedDifference = expectedTotalAssets - expectedExpenses;

        budgetCheck = test.testWalletCalculate( expectedWalletAmount, testManager);
        System.out.println("Test for calculating amount for wallet working as intended: " + budgetCheck);
        budgetCheck = false;

        budgetCheck = test.testExpensesCalculate( expectedExpenses, testManager);
        System.out.println("Test for calculating amount of expenses working as intended: " + budgetCheck);
        budgetCheck = false;

        budgetCheck = test.testTotalAssetsCalculate( expectedTotalAssets, testManager);
        System.out.println("Test for calculating total amount of assets working as intended: " + budgetCheck);
        budgetCheck = false;

        budgetCheck = test.testUsableAssetsCalculate( expectedUsableAssets, testManager);
        System.out.println("Test for calculating usable amount of assets working as intended: " + budgetCheck);
        budgetCheck = false;

        budgetCheck = test.testPayExpenses( expectedDifference, testManager);
        System.out.println("Test for calculating expenses payment working as intended: " + budgetCheck);
    }
}
