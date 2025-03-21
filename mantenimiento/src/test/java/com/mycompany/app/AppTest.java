package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testMainOutput() {
        // Capture the output of the main method
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the main method
        App.main(new String[]{});

        // Verify the output
        String output = outputStream.toString().trim();
        assertEquals("Hello World!", output);
    }
}