package com.vending.mechanism.states;

import com.vending.snacks.SnackName;
import com.vending.snacks.SnackStock;

import java.util.Scanner;

public class SelectionState extends StateOfVendingMachine{
    private final Scanner _scanner;
    private final SnackStock _stock;

    public SelectionState() {
        _scanner = new Scanner(System.in);
        _stock = SnackStock.getInstance();
    }

    @Override
    public void handleRequest() {
        selectSnack();
    }

    private void selectSnack(){
        // Making the print prompt a static string because I have to use so many handlers,
        // and they lose their purpose if I conveniently and wisely implement the strings
        // in the enum class.
        System.out.println("""
                Make a selection:
                1. Coke
                2. Pepsi
                3. Cheetos
                4. Doritos
                5. KitKat
                6. Snickers
                """);

        System.out.print("Selection: ");

        int userChoice = _scanner.nextInt();
        System.out.println();

        SnackName chosen = SnackName.fromNumber(userChoice);
        _stock.setTarget(chosen);
    }
}
