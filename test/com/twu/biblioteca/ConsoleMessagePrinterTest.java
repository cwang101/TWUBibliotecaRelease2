package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;


public class ConsoleMessagePrinterTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }
    private String systemOut() {
        return outContent.toString();
    }
    @Test
    public void should_print_write_welcome_message() {
        ConsoleMessagePrinter printer=new ConsoleMessagePrinter();

        printer.printWelcomeMessage();
        assertTrue(systemOut().endsWith("\n"));


    }
}
