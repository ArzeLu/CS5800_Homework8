package com.vending.snacks;

import java.util.HashMap;

public enum SnackName {
    NONE(0),
    COKE(1),
    PEPSI(2),
    CHEETOS(3),
    DORITOS(4),
    KITKAT(5),
    SNICKERS(6),;

    private final static HashMap<Integer, SnackName> _snacks = new HashMap<>();
    private final int _number;

    static{
        SnackName[] values = SnackName.values();
        for(SnackName snack : values)
            _snacks.put(snack._number, snack);
    }

    SnackName(int number) {
        _number = number;
    }

    public static SnackName fromNumber(int number){
        return _snacks.get(number);
    }

    public int getSnackNumber(){
        return _number;
    }
}
