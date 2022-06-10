package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class ProductsTest {

    Products pTest = new Products("name", 2.0, "A3", "itemMessage");

    @Test
    public void test_constructor(){
        Assert.assertEquals("name", pTest.getName());
        double price = pTest.getPrice();
       Assert.assertEquals("A3", pTest.getVendingLocation());
      // Assert.assertEquals(2, pTest.getPrice());

    }

    @Test
    public void test_quantityUpdater(){

    }

}
