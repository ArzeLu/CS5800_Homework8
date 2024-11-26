package com.vending.mechanism.dispense_handlers;

import com.vending.snacks.Snack;
import com.vending.snacks.SnackName;

public class CheetosHandler extends BaseHandler{
    public CheetosHandler(){
        super();
        snackName = "Cheetos";
    }

    @Override
    public Snack handleEvent(Snack snack){
        if(!snack.getSnackName().equals(SnackName.CHEETOS)) {
            if(nextHandler == null)
                return null;
            return nextHandler.handleEvent(snack);
        }

        if(checkQuantity(snack))
            return snack;

        return null;
    }
}
