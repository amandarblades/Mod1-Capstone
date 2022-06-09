package com.techelevator;

public class Change extends Money {
    int dollars;
    int quarters;
    int dimes;
    int nickels;

    double currentBalance = getBalance();
    boolean isCurrentBalance = currentBalance >=100? true: false;

    int i = 1;

    while(i < 6){
        System.out.println("Hello World");
        i++;
    }

    while (currentBalance > 99) {
        dollars++;
        currentBalance -=100;
    }




} /** End of Class **/
