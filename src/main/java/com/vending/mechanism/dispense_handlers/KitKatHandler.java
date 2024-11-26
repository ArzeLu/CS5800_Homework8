package com.vending.mechanism.dispense_handlers;

import com.vending.snacks.Snack;
import com.vending.snacks.SnackName;

public class KitKatHandler extends BaseHandler {
    public KitKatHandler(){
        super();
        snackName = "KitKat";
    }

    @Override
    public Snack handleEvent(Snack snack){
        if(!snack.getSnackName().equals(SnackName.KITKAT)) {
            if(nextHandler == null)
                return null;
            return nextHandler.handleEvent(snack);
        }

        if(checkQuantity(snack))
            return snack;

        return null;
    }
}
