package com.vending.snacks;

import java.util.ArrayList;

public class SnackStock {
    private static SnackStock _instance;
    private final ArrayList<Snack> _snacks;
    private SnackName _chosen;

    private SnackStock(){
        _snacks = new ArrayList<>();
    }

    public static SnackStock getInstance(){
        if(_instance == null){
            _instance = new SnackStock();
            _instance.restockAll();
        }
        return _instance;
    }

    public void restockAll(){
        _instance.addSnack(new Snack(SnackName.COKE, 3.99, 5));
        _instance.addSnack(new Snack(SnackName.PEPSI, 3.50, 5));
        _instance.addSnack(new Snack(SnackName.CHEETOS, 2.79, 10));
        _instance.addSnack(new Snack(SnackName.DORITOS, 3.20, 10));
        _instance.addSnack(new Snack(SnackName.KITKAT, 2.57, 20));
        _instance.addSnack(new Snack(SnackName.SNICKERS, 2.33, 20));
    }

    public void addSnack(Snack snack){
        _snacks.add(snack);
    }

    public void setTarget(SnackName chosen) {
        this._chosen = chosen;
    }

    public SnackName getChosenSnackName(){
        return _chosen;
    }

    public Snack getTargetSnack() {
        for (Snack snack : _snacks)
            if (snack.getSnackName().equals(_chosen))
                return snack;
        return new Snack(SnackName.NONE, 0, 0);
    }
}
