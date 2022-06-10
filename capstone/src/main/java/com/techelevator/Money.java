package com.techelevator;

public class Money {

    private static double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void decreaseBalance(double amount){
        balance -= amount;
    }

    public void increaseBalance(double amount){
        balance +=amount;
    }

    //Assuming we can use setBalance as our constructor


}/** End of Class  **/
