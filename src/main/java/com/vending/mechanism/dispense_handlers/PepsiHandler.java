package com.vending.mechanism.dispense_handlers;

import com.vending.snacks.Snack;
import com.vending.snacks.SnackName;

public class PepsiHandler extends BaseHandler {
    public PepsiHandler(){
        super();
        snackName = "Pepsi";
    }

    @Override
    public Snack handleEvent(Snack snack){
        if(!snack.getSnackName().equals(SnackName.PEPSI)) {
            if(nextHandler == null)
                return null;
            return nextHandler.handleEvent(snack);
        }

        if(checkQuantity(snack))
            return snack;

        return null;
    }
}
