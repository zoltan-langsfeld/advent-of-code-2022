package org.advent.day1.task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileLoaderTest {

    @Test
    void shouldLoadString() {
        // when
        String fileContent = FileLoader.loadFile("src/test/resources/test_input.txt");

        // then
        assertEquals("hello world!", fileContent);
    }

    @Test
    void shouldLoadEmptyStringIfErrorOccurs() {
        // when
        String fileContent = FileLoader.loadFile("xfwbx");


        // then
        assertEquals("", fileContent);
    }
}