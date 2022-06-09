package com.techelevator;

public class Products {

    private String name;
    private double price;
    private int quantity;
    private String vendingLocation;
    private String message;
    private String itemType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getVendingLocation() {
        return vendingLocation;
    }

    public void setVendingLocation(String vendingLocation) {
        this.vendingLocation = vendingLocation;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
        System.out.println(name + ": " + price);
        System.out.println("Current Balance: " + currentBalance);
        System.out.println(message);

    }

    public void updateItemQuantity(){
        quantity--;
    }

    public void invalidItem(){
        System.out.println("Item is not available");

    }



}/**End of class **/