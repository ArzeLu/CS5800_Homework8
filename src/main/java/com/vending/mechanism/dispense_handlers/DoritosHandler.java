package com.vending.mechanism.dispense_handlers;

import com.vending.snacks.Snack;
import com.vending.snacks.SnackName;

public class DoritosHandler extends BaseHandler{
    public DoritosHandler(){
        super();
        snackName = "Doritos";
    }

    @Override
    public Snack handleEvent(Snack snack){
        if(!snack.getSnackName().equals(SnackName.DORITOS)) {
            if(nextHandler == null)
                return null;
            return nextHandler.handleEvent(snack);
        }

        if(checkQuantity(snack))
            return snack;

        return null;
    }
}
