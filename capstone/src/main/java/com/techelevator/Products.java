package com.techelevator;

import java.text.NumberFormat;

public class Products {

    private String name;
    private double price;
    private int quantity;
    private String vendingLocation;
    private String message;
    private String itemType;
    NumberFormat currency = NumberFormat.getCurrencyInstance();

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

     public String getVendingLocation() {
        return vendingLocation;
    }


    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }


    public Products (String name, double price, String vendingLocation, String message){
        this.name = name;
        this.price = price;
        this.quantity = 5;
        this.vendingLocation = vendingLocation;
        this.message = message;
    }

    public void dispenseItem(double currentBalance){
        System.out.println(name + ": " + currency.format(price));
        System.out.println("Current Balance: " + currency.format(currentBalance));
        System.out.println(message);

    }

    public void updateItemQuantity(){
        quantity--;
    }


}/**End of class **/