package org.advent.solver.day7;

import org.advent.solver.day7.model.FileSystem;
import org.advent.util.FileLoader;

public class Day7TaskSolver {

    /* Plan
    1. Implement FileSystem
    2. Populate FileSystem with data
    3. Run the analysis on the FileSystem
     */

    private final FileSystem fileSystem;

    public Day7TaskSolver(String pathToInputData) {
        final var rawData = FileLoader.loadFile(pathToInputData).split("\n");
        this.fileSystem = new FileSystem(rawData);
    }

    public int solveA() {
        return fileSystem.getSumOfDirectories(100000);
    }

    public int solveB() {
        return fileSystem.getSizeOfDirectoryToBeDeleted(30000000);
    }

}
