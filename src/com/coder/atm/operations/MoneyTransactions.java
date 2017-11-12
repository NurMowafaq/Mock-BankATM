/*
 * In this class we gonna define transaction methods.
 */
package com.coder.atm.operations;

import com.coder.atm.entity.AtmAccout;
import java.util.Scanner;

/**
 *
 * @author Coder ACJHP
 */
public class MoneyTransactions {

    private AtmAccout beanAccount;
    
    //Atm limitations & banknote counts
    private static final double ATM_CREDIT_LIMIT = 1000000;
    private static  int Count_OF_25K = 8;
    private static  int Count_OF_10K = 20;
    private static  int Count_OF_5K = 40;
    private static  int Count_OF_1K = 200;
    private static  int Count_OF_500 = 400;
    private int TFiveCount, TenKCount, FiveKCount, OneKCount, HalfKCount = 0;
    
    final static Scanner input = new Scanner(System.in);

    //inject account bean to Transaction class
    public MoneyTransactions(AtmAccout accountBean) {
        this.beanAccount = accountBean;
    }

    //add money to account balance
    public void addDeposite() {
        checkDeposite();
        getTotalBalance();
    }

    //get total money in the account
    public void getTotalBalance() {
        System.out.println("\nTotal money in your account : " + beanAccount.getBalance() + "IRQ DNR");
    }

    //withdrawal transaction operation.
    public synchronized void withDraw() {

        //check the entered value if it's grather than 500;
        double amount = getAmountForWithdraw();
        if (amount >= ATM_CREDIT_LIMIT) {
                System.err.println("You cannot withdraw this ammount!");
        }
        else if (amount <= beanAccount.getBalance()) {
 
                for (int counter = 0; counter <= 668; counter++) {

                        if (amount >= 25000 && Count_OF_25K != 0) {
                            amount = amount - 25000.0;
                            Count_OF_25K = Count_OF_25K - 1;
                            TFiveCount = TFiveCount + 1;
                        } else if (amount >= 10000 && Count_OF_10K != 0) {
                            amount = amount - 10000.0;
                            Count_OF_10K = Count_OF_10K - 1;
                            TenKCount = TenKCount + 1;
                        } else if (amount >= 5000 && Count_OF_5K != 0) {
                            amount = amount - 5000.0;
                            Count_OF_5K = Count_OF_5K - 1;
                            FiveKCount = FiveKCount + 1;
                        } else if (amount >= 1000 && Count_OF_1K != 0) {
                            amount = amount - 1000.0;
                            Count_OF_1K = Count_OF_1K - 1;
                            OneKCount = OneKCount + 1;
                        } else if (amount >= 500 && Count_OF_500 != 0) {
                            amount = amount - 500.0;
                            Count_OF_500 = Count_OF_500 - 1;
                            HalfKCount = HalfKCount + 1;
                        } else {
                            final double totalWithDrawenAmount = (TFiveCount * 25000 + TenKCount * 10000 + FiveKCount * 5000 + OneKCount * 1000 + HalfKCount * 500);
                            beanAccount.setBalance(beanAccount.getBalance() - totalWithDrawenAmount);
                            break;
                        }
                    }
                getTotalBalance();
                System.out.println("\nBank banknote status : ");
                System.out.println("Total " + Count_OF_25K + " banknote remaining from 25K's");
                System.out.println("Total " + Count_OF_10K + " banknote remaining from 10K's");
                System.out.println("Total " + Count_OF_5K + " banknote remaining from 5K's");
                System.out.println("Total " + Count_OF_1K + " banknote remaining from 1K's");
                System.out.println("Total " + Count_OF_500 + " banknote remaining from 500's");
                
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.err.println("Error : " + ex);
            }
          
        }
        else {
            System.err.println("You entered amount greater than you have in your account!");
        }
    }
    
    private void checkDeposite() {
        double deposite = 0.0;
        System.out.print("Enter the amount you want to deposit : ");
        final Scanner input = new Scanner(System.in);
        deposite = input.nextDouble();

        while (deposite == 0.0) {
            
            System.err.println("Deposite cannot be zero!");
            deposite = input.nextDouble();
            if (deposite != 0.0) {
                break;
            }
        }

        beanAccount.setBalance(beanAccount.getBalance() + deposite);

    }
    
    private static double getAmountForWithdraw() {
        double amount = 0.0;
        do {
            
            System.out.print("Enter your amount : ");
            amount = input.nextDouble();
            if (amount >= 500 && amount % 5 == 0) {
                break;
            }
            System.err.println("Minimum amount is 500 IRQ DNR !!");
        } while (true);
        return amount;
    }
    
    public static boolean askUserForContinue() {
        System.out.println("Do you want to continue ? yes(YES) or no(NO) = ");
        String answer = input.next();
        if(answer.equalsIgnoreCase("yes")) {
            return true;
        }
        return false;
    }
    
    public void showAccountDetail() {
        System.out.println(beanAccount.toString());
    }
}
