package com.vending.mechanism.dispense_handlers;

import java.util.ArrayList;

public class InitializeHandlers {
    private static InitializeHandlers _instance = null;
    private static final ArrayList<SnackDispenseHandler> _handlers = new ArrayList<>();
    private static SnackDispenseHandler _handler;

    private InitializeHandlers() {

    }

    public static InitializeHandlers getInstance() {
        if (_instance == null) {
            _instance = new InitializeHandlers();
            _handlers.add(new CheetosHandler());
            _handlers.add(new CokeHandler());
            _handlers.add(new DoritosHandler());
            _handlers.add(new KitKatHandler());
            _handlers.add(new PepsiHandler());
            _handlers.add(new SnickersHandler());

            _handler = _handlers.removeFirst();
            linkChain(_handler);
        }
        return _instance;
    }

    // Recursively set the next handler and complete the Chain of Command
    private static void linkChain(SnackDispenseHandler handler){
        if(!_handlers.isEmpty()) {
            SnackDispenseHandler nextHandler = _handlers.removeFirst();
            handler.setNextHandler(nextHandler);
            linkChain(nextHandler);
        }
    }

    public SnackDispenseHandler getHandler(){
        return _handler;
    }
}
