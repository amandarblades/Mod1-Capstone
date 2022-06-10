package com.techelevator;

import java.io.IOException;
import java.text.NumberFormat;

public class Money {

    private static double balance;
    private int dollars;
    private int quarters;
    private int dimes;
    private int nickels;
    NumberFormat currency = NumberFormat.getCurrencyInstance();

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

   public void makeChange(double balance, Log vmLog) throws IOException {
        double previousBalance = balance;

       System.out.println("Returning Change of " + currency.format(balance));
       while (balance > .99) {
           dollars++;
           balance -= 1.00;
       }
       while (balance > .24) {
           quarters++;
           balance -= .25;
       }
       while (balance > .09) {
           dimes++;
           balance -= .10;
       }

       while (balance > .04) {
           nickels++;
           balance -= .05;
       }

       System.out.println(dollars + " dollars");
       System.out.println(quarters + " quarters");
       System.out.println(dimes + " dimes");
       System.out.println(nickels + " nickels");

       setBalance(0);
       vmLog.printToLog("GIVE CHANGE:", previousBalance, balance);
   }


}/** End of Class  **/
