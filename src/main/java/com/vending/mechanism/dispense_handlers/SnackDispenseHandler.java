package com.vending.mechanism.dispense_handlers;

import com.vending.snacks.Snack;
import com.vending.snacks.SnackName;

public interface SnackDispenseHandler {
    void setNextHandler(SnackDispenseHandler handler);
    Snack handleEvent(Snack snack);
}
