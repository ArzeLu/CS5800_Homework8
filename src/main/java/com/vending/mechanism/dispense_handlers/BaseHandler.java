package com.vending.mechanism.dispense_handlers;

import com.vending.mechanism.VendingMachine;
import com.vending.snacks.Snack;

public abstract class BaseHandler implements SnackDispenseHandler{
    protected SnackDispenseHandler nextHandler = null;  // The last handler will not have a next, so initialize nextHandler as null for every one
    protected String snackName;
    private VendingMachine _vendingMachine;

    public BaseHandler(){
        _vendingMachine = VendingMachine.getInstance();
        snackName = "None";
    }

    public void setNextHandler(SnackDispenseHandler handler){
        nextHandler = handler;
    }

    public Snack handleEvent(Snack snack){
        return nextHandler.handleEvent(snack);
    }

    protected boolean checkQuantity(Snack snack){
        if(snack.getQuantity() > 0) {
            System.out.println("Dispensing " + snackName + "...");
            System.out.println("Enjoy your " + snackName + "!");

            double credits = _vendingMachine.getCredits();
            credits -= snack.getPrice();

            System.out.println("Remaining credits: " + credits + "\n");

            _vendingMachine.setCredits(credits);

            snack.minusOne();

            return true;
        }

        System.out.println("Sorry we're out of " + snackName);
        System.out.println("Please make another selection.");

        return false;
    }
}
