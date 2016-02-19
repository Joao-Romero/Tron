package org.academiadecodigo.joaoromero.cars;

/**
 * Created by João Romero on 03/02/16.
 */
public enum CarType {
    RENAULT("R"),
    LAMBORGHINI("L");

    private String symbol;

    CarType(String symbol){
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
