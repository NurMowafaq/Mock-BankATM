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
    private double bankCredit = 1000000;
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
    public void withDraw() {
        
        if (beanAccount.getBalance() == 0) {
            System.err.println("Your balance is zero!");
        } 
        //check the entered value if it's grather than 500;
        double amount = getAmountForWithdraw();
        
        if (amount > bankCredit && amount > beanAccount.getBalance()) {
            System.err.println("You cannot withdraw this ammount!");
        } 
        else {

            beanAccount.setBalance(beanAccount.getBalance() - amount);

        }
        
        getTotalBalance();
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
