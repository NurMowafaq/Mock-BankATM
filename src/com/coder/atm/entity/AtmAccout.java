/*
 * This class will be Account object.
 */
package com.coder.atm.entity;

/**
 *
 * @author Coder ACJHP
 */
public class AtmAccout {
    
    private String Id;
    private String username;
    private String password;
    private double balance;

    public AtmAccout() {
    }

    public String getId() {
        return Id;
    }

    public void setId(String theId) {
        this.Id = theId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AtmAccout(String Id, String username, String password, double balance) {
        this.Id = Id;
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Id=" + Id + "\nUsername=" + username + "\nPassword=" + password + "\nBalance=" + balance;
    }

    
    
}
