package org.advent.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class FileLoader {
    private static final Logger logger = LogManager.getLogger(FileLoader.class);

    public static String loadFile(String fileName) {
        try {
            final var resource = FileLoader.class.getResource(fileName);
            final var path = Paths.get(Objects.requireNonNull(resource).toURI());
            return Files.readString(path);
        } catch (Exception e) {
            logger.error("An exception has occurred while reading the file.", e);
        }
        return "";
    }
}