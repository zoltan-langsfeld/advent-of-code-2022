package org.advent.solver.day5;

import java.util.*;
import java.util.regex.Pattern;

public class InputParser {

    private final String rawInput;
    private Ship ship;
    private List<Command> commands;


    public InputParser(String input) {
        this.rawInput = input;
    }

    public InputParser parse() {
        final var splitInput = rawInput.split("\n\n");

        final var shipStr = splitInput[0];
        final var commandsStr = splitInput[1];

        this.ship = parseInputToShip(shipStr);
        this.commands = parseInputToCommands(commandsStr);

        return this;
    }

    private Ship parseInputToShip(String shipStr) {
        var lines = new ArrayList<>(Arrays.asList(shipStr.split("\n")));
        final var lastLine = lines.get(lines.size() - 1);

        final var noStacks = Arrays.stream(lastLine
                        .split(" "))
                .filter(str -> !str.equals(""))
                .mapToInt(Integer::valueOf)
                .max().orElse(0);

        lines.remove(lines.size() - 1);

        return mapLinesToShip(lines, noStacks);
    }

    private Ship mapLinesToShip(List<String> lines, int noStacks) {
        final List<Stack<Character>> stacks = new ArrayList<>();

        for (int i = 0; i < noStacks; i++) {
            stacks.add(new Stack<>());
        }

        // Reverse the list in order to have the correct order in the stack at the end
        Collections.reverse(lines);

        for (String line : lines) {
            final var charArray = line.toCharArray();
            var noColumn = -1;
            for (int index = 0; index < charArray.length; index++) {
                if (index % 4 == 0) {
                    noColumn++;
                }
                final var currentChar = charArray[index];

                final var pattern = Pattern.compile("\\[|]|\s");
                final var isCurrentCharCrate = !pattern.matcher(String.valueOf(currentChar)).find();

                if (isCurrentCharCrate) {
                    stacks.get(noColumn).push(currentChar);
                }
            }
        }

        return new Ship(stacks);
    }

    private List<Command> parseInputToCommands(String commandsStr) {
        final var lines = commandsStr.split("\n");

        return Arrays.stream(lines).map(
                line -> {
                    final var splitLine = line.replaceAll("move |from |to ", "").split(" ");

                    return new Command(Integer.parseInt(splitLine[0]), Integer.parseInt(splitLine[1]) - 1, Integer.parseInt(splitLine[2]) - 1);
                }
        ).toList();
    }

    public Ship getShip() {
        return ship;
    }

    public List<Command> getCommands() {
        return commands;
    }
}
