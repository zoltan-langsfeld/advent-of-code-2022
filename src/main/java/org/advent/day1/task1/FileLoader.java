package org.advent.day1.task1;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileLoader {
    private static final Logger logger = LogManager.getLogger(FileLoader.class);

    public static String loadFile(String fileName) {
        try (FileInputStream inputStream = new FileInputStream(fileName)) {
            return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        } catch (IOException e) {
            logger.error("An exception occurred while loading the file", e);
        }
        return "";
    }
}