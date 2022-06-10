package com.techelevator;

import com.techelevator.view.Menu;

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

                    if(productInfo[ITEM_TYPE].equals("Drink")){
                        double itemprice = Double.parseDouble(productInfo[ITEM_PRICE]);
                        products.add(new Beverage(productInfo[ITEM_NAME], itemprice, productInfo[ITEM_LOCATION]));

                    }else if(productInfo[ITEM_TYPE].equals("Candy")){
                        double itemprice = Double.parseDouble(productInfo[ITEM_PRICE]);
                        products.add(new Candy(productInfo[ITEM_NAME], itemprice, productInfo[ITEM_LOCATION]));

                    }else if(productInfo[ITEM_TYPE].equals("Chip")){
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
        public double feedMoney(double balance){
            double updatedBalance = balance;
            Scanner userInput = new Scanner(System.in);
            boolean keepAdding = true;
            do {
                System.out.println("How much money, in whole dollars, do you want to insert?");
                String addToBalance = userInput.nextLine();
                double moneyToAdd = Double.parseDouble(addToBalance);
                updatedBalance += moneyToAdd;
                System.out.println("Current Money Provided: $" + (updatedBalance - balance));
                System.out.println("Would you like to add more money? (y/n)");
                String continueAdding = userInput.nextLine();
                if(continueAdding.toLowerCase().equals("n")){
                    keepAdding = false;
                }


            } while(keepAdding);

            return updatedBalance;
        }

        public void purchaseProduct(Money balance, List<Products> products){
        Scanner userInput = new Scanner(System.in);
        boolean continuePurchasing = false;
            displayProducts(products);
            System.out.println("Which product would you like to purchase?");
            String purchase = userInput.nextLine();

            do {


                for (Products p : products) {
                    if (purchase.equals(p.getVendingLocation())) {
                        if (p.getQuantity() == 0) {
                            System.out.println("Item is Sold Out");
                        } else {
                            p.dispenseItem(balance.getBalance());
                            p.updateItemQuantity();
                            balance.decreaseBalance(p.getPrice());
                        }
                    } else {
                        System.out.println("The item does not exist");
                    }
                }
                System.out.println("Would you like to maka another purchase? (y/n)");
                String anotherPurchase = userInput.nextLine();
                if(anotherPurchase.toLowerCase().equals("n")){
                    continuePurchasing = false;
                }


            } while(continuePurchasing);


        }


}/** End of Class **/
















