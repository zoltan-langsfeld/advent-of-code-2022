package org.advent.solver.day5;

public class Command {

    private int amount;
    private int source;
    private int destination;

    public Command(int amount, int source, int destination) {
        this.amount = amount;
        this.source = source;
        this.destination = destination;
    }

    public int getAmount() {
        return amount;
    }

    public int getSource() {
        return source;
    }

    public int getDestination() {
        return destination;
    }
}
