package com.vending.mechanism.dispense_handlers;

import com.vending.snacks.Snack;
import com.vending.snacks.SnackName;

public class CokeHandler extends BaseHandler {
    public CokeHandler(){
        super();
        snackName = "Coke";
    }

    @Override
    public Snack handleEvent(Snack snack){
        if(!snack.getSnackName().equals(SnackName.COKE)) {
            if(nextHandler == null)
                return null;
            return nextHandler.handleEvent(snack);
        }

        if(checkQuantity(snack))
            return snack;

        return null;
    }
}
