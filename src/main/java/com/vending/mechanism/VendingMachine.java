package com.vending.mechanism;

import com.vending.mechanism.states.StateOfVendingMachine;
import com.vending.snacks.SnackStock;

public class VendingMachine {
    private static VendingMachine _instance;
    private SnackStock _stock;
    private StateOfVendingMachine _state;
    private double _credits;

    private VendingMachine() {}

    public static VendingMachine getInstance() {
        if(_instance == null) {
            _instance = new VendingMachine();
            _instance._stock = SnackStock.getInstance();
        }
        return _instance;
    }

    public void setCredits(double credits){
        this._credits = credits;
    }

    public double getCredits(){
        return _credits;
    }

    public void setState(StateOfVendingMachine state){
        this._state = state;
    }

    public void request(){
        _state.handleRequest();
    }
}
