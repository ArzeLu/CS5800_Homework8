package com.vending.mechanism.states;

import com.vending.mechanism.VendingMachine;
import com.vending.snacks.Snack;
import com.vending.snacks.SnackStock;

import java.util.Scanner;

public class PendingCreditsState extends StateOfVendingMachine{
    private final Scanner _scanner;
    private final VendingMachine _vendingMachine;
    private final SnackStock _stock;
    private double _credits;

    public PendingCreditsState(){
        _scanner = new Scanner(System.in);
        _vendingMachine = VendingMachine.getInstance();
        _stock = SnackStock.getInstance();
    }

    @Override
    public void handleRequest(){
        insertMoney();
    }

    private void insertMoney() {
        System.out.println("Remaining credits: " + _credits);
        System.out.print("Insert credits: ");

        _credits = _vendingMachine.getCredits();
        _credits += _scanner.nextDouble();
        System.out.println();
        Snack targetSnack = _stock.getTargetSnack();

        while(_credits < targetSnack.getPrice()){
            System.out.print("""
                    Insufficient funds
                    Insert more credits:\s""");

            _credits += _scanner.nextDouble();
        }

        _vendingMachine.setCredits(_credits);
    }
}
