package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class MoneyTest {
    Money money = new Money();
    Log log = new Log();

    @Test
    public void return_correct_change() throws IOException {
        money.makeChange(8.80, log);

        Assert.assertEquals(0, money.getBalance(), 0.01);
    }

    @Test
    public void add_to_balance(){
        money.setBalance(7.20);
        money.increaseBalance(2.50);

        Assert.assertEquals(9.70, money.getBalance(), 0.01);

        money.setBalance(-1.25);
        money.increaseBalance(2.50);

        Assert.assertEquals(1.25, money.getBalance(), 0.01);


        money.setBalance(10.25);
        money.increaseBalance(-2.50);

        Assert.assertEquals(7.75, money.getBalance(), 0.01);

    }

    @Test
    public void deduct_from_balance(){
        money.setBalance(7.20);
        money.decreaseBalance(1.15);

        Assert.assertEquals(6.05, money.getBalance(), 0.01);

        money.setBalance(-7.20);
        money.decreaseBalance(1.15);

        Assert.assertEquals(-8.35, money.getBalance(), 0.01);

        money.setBalance(7.20);
        money.decreaseBalance(-1.15);

        Assert.assertEquals(8.35, money.getBalance(), 0.01);


    }


}
