package com.vending.snacks;

public class Snack {
    private final SnackName snackName;
    private final double price;
    private int quantity;

    public Snack(SnackName snackName, double price, int quantity) {
        this.snackName = snackName;
        this.price = price;
        this.quantity = quantity;
    }

    public SnackName getSnackName() {
        return snackName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void minusOne(){
        quantity -= 1;
    }
}