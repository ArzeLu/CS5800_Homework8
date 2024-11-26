package com.vending.mechanism.states;

public class IdleState extends StateOfVendingMachine{
    @Override
    public void handleRequest(){
        System.out.println("Welcome to CS5800 Homework #8");
    }
}
