package org.advent.solver.day7.model;

public class NodeFactory {

    public static Node createNode(String input) {
        final var splitInput = input.split(" ");

        if (splitInput[0].equals("dir")) {
            return new Directory(splitInput[1]);
        } else {
            return new File(Integer.parseInt(splitInput[0]), splitInput[1]);
        }
    }
}
