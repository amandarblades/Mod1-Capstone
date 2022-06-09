package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {
    public List <Products> importProducts() {

            final int ITEM_LOCATION = 0;
            final int ITEM_NAME = 1;
            final int ITEM_PRICE = 2;
            final int ITEM_TYPE = 3;

            List<Products> products = new ArrayList<>();
            File productFile = new File("vendingmachine.csv");
            String[] productInfo = new String[4];

            try (Scanner fileInput = new Scanner(productFile)){
                while(fileInput.hasNextLine()){
                 String productLine = fileInput.nextLine();
                    productInfo = productLine.split("\\|");

                    if(productInfo[ITEM_TYPE].equals("Beverage")){
                        double itemprice = Double.parseDouble(productInfo[ITEM_PRICE]);
                        products.add(new Beverage(productInfo[ITEM_NAME], itemprice, productInfo[ITEM_LOCATION]));

                    }else if(productInfo[ITEM_TYPE].equals("Candy")){
                        double itemprice = Double.parseDouble(productInfo[ITEM_PRICE]);
                        products.add(new Candy(productInfo[ITEM_NAME], itemprice, productInfo[ITEM_LOCATION]));

                    }else if(productInfo[ITEM_TYPE].equals("Chips")){
                        double itemprice = Double.parseDouble(productInfo[ITEM_PRICE]);
                        products.add(new Chips(productInfo[ITEM_NAME], itemprice, productInfo[ITEM_LOCATION]));

                    }else if(productInfo[ITEM_TYPE].equals("Gum")){
                        double itemprice = Double.parseDouble(productInfo[ITEM_PRICE]);
                        products.add(new Gum(productInfo[ITEM_NAME], itemprice, productInfo[ITEM_LOCATION]));

                    }
                }

            }catch(FileNotFoundException e){

                System.out.println("The file was not found.");
            }

          return products;
    }
        public void displayProducts(List<Products> products ) {
            for (Products p : products) {
                System.out.println(p.getVendingLocation() + ": " + p.getName() + " -- " + p.getQuantity());
            }
        }
       // public double feedMoney(double balance)


}/** End of Class **/
















