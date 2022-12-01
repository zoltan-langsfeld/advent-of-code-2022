package org.advent.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileLoaderTest {

    @Test
    void shouldLoadString() {
        // when
        String fileContent = FileLoader.loadFile("test_input.txt");

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