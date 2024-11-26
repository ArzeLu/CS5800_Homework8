package com.vending;

import com.vending.mechanism.VendingMachine;
import com.vending.mechanism.states.DispensingState;
import com.vending.mechanism.states.IdleState;
import com.vending.mechanism.states.PendingCreditsState;
import com.vending.mechanism.states.SelectionState;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = VendingMachine.getInstance();
        IdleState idleState = new IdleState();
        SelectionState selectionState = new SelectionState();
        PendingCreditsState pendingCreditsState = new PendingCreditsState();
        DispensingState dispensingState = new DispensingState();

        int choice = 0;
        Scanner scanner = new Scanner(System.in);

        while(choice == 0) {
            vendingMachine.setState(idleState);
            vendingMachine.request();

            vendingMachine.setState(selectionState);
            vendingMachine.request();

            vendingMachine.setState(pendingCreditsState);
            vendingMachine.request();

            vendingMachine.setState(dispensingState);
            vendingMachine.request();

            System.out.println("To make more purchase, please type 0");
            System.out.println("Otherwise, the transaction ends.");

            choice = scanner.nextInt();
        }

        System.out.println("Thank you for visiting CS5800 Homework8!\nCome again soon!");
        scanner.close();
    }
}