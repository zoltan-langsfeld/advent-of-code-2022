package org.advent.solver.day5;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Stack;

public class Ship {

    private List<Stack<Character>> stacks;
    private final List<Stack<Character>> initialStacks;

    public Ship(List<Stack<Character>> stacks) {
        this.stacks = stacks;
        this.initialStacks = copyStacks(stacks);
    }

    public void resetState() {
        stacks = copyStacks(initialStacks);
    }

    private List<Stack<Character>> copyStacks(List<Stack<Character>> inputStacks) {
        return inputStacks.stream().map(stack -> {
            final var newStack = new Stack<Character>();
            newStack.addAll(stack);
            return newStack;
        }).toList();
    }

    public void executeCommandWithCrateMover9000(Command command) {
        for (int index = 1; index <= command.getAmount(); index++) {
            final var crateToMove = stacks.get(command.getSource()).pop();
            this.stacks.get(command.getDestination()).push(crateToMove);
        }
    }

    public void executeCommandWithCrateMover9001(Command command) {
        final var tempDeque = new ArrayDeque<Character>();
        for (int index = 1; index <= command.getAmount(); index++) {
            tempDeque.add(stacks.get(command.getSource()).pop());
        }

        while (tempDeque.size() > 0) {
            this.stacks.get(command.getDestination()).push(tempDeque.removeLast());
        }
    }

    public String getTopCreates() {
        return stacks.stream()
                .map(Stack::peek)
                .map(String::valueOf)
                .reduce("", String::concat);
    }
}
