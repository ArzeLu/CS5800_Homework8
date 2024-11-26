package com.vending.mechanism.states;

import com.vending.mechanism.dispense_handlers.InitializeHandlers;
import com.vending.mechanism.dispense_handlers.SnackDispenseHandler;
import com.vending.snacks.SnackStock;

public class DispensingState extends StateOfVendingMachine{
    private final SnackStock _stock;

    public DispensingState(){
        _stock = SnackStock.getInstance();
    }

    @Override
    public void handleRequest(){
        dispenseSnack();
    }

    private void dispenseSnack(){
        SnackDispenseHandler handler = InitializeHandlers.getInstance().getHandler();
        if(handler.handleEvent(_stock.getTargetSnack()) == null){
            System.out.println("Sorry, please try again.");
            System.out.println("There was an error with the selection process");
        }
    }
}
