package org.advent.util;

import org.advent.day1.task1.DayOneTaskSolverA;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileLoader {
    private static final Logger logger = LogManager.getLogger(FileLoader.class);

    public static String loadFile(String fileName) {
        try {
            final var resource = FileLoader.class.getResource(fileName);
            final var path = Paths.get(resource.toURI());
            return Files.readString(path);
        } catch (Exception e) {
            logger.error("An exception has occurred while reading the file.", e);
        }
        return "";
    }
}