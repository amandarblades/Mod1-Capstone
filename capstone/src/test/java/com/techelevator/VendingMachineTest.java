package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class VendingMachineTest {
    VendingMachine vm = new VendingMachine();

    @Test
    public void list_size(){
        vm.importProducts();
        Assert.assertEquals(16, vm.importProducts().size());

        Assert.assertEquals(false, vm.importProducts().isEmpty());

    }
}
