package org.advent.solver.day5;

import org.advent.util.FileLoader;

import java.util.List;

public class Day5TaskSolver {

    final Ship ship;
    final List<Command> commands;

    public Day5TaskSolver(String pathToInputData) {
        final var rawData = FileLoader.loadFile(pathToInputData);

        final var inputParser = new InputParser(rawData).parse();

        this.ship = inputParser.getShip();
        this.commands = inputParser.getCommands();
    }

    public String solveTaskA() {
        ship.resetState();
        commands.forEach(ship::executeCommandWithCrateMover9000);

        return ship.getTopCreates();
    }

    public String solveTaskB() {
        ship.resetState();
        commands.forEach(ship::executeCommandWithCrateMover9001);

        return ship.getTopCreates();
    }

}
