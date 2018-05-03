package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class ConsoleMessagePrinterTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    ConsoleMessagePrinter printer=new ConsoleMessagePrinter();
    Menu menu;
    Library library;

    public ConsoleMessagePrinterTest() {
        List<Book> books= Arrays.asList(new Book(1,"One Hundred Years of Solitude","Gabriel Garcia Marquez","2000-08"),
                new Book(1,"The City in History","Lewis Mumford","2005-02"),
                new Book(1,"The Death and Life of Great American Cities","Jacobs Jane","2005-05"));

        library=new Library(1,books);

        menu=new Menu(Arrays.asList("List Books","Quit"));
    }

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }
    private String systemOut() {
        return outContent.toString();
    }
    @Test
    public void should_print_write_welcome_message() {
        printer.printWelcomeMessage();
        assertTrue(systemOut().endsWith("Welcome to the Library!\r\n"));

    }

    @Test
    public void should_print_book_list() {
        String expectedOut="Books available:\n" +
                "No.|name|author|published year\n" +
                "================================================\n" +
                "1|One Hundred Years of Solitude|Gabriel Garcia Marquez|2000-08\n" +
                "2|The City in History|Lewis Mumford|2005-02\n" +
                "3|The Death and Life of Great American Cities|Jacobs Jane|2005-05\n" +
                "================================================\n";
        printer.printBookList(library);
        assertTrue(systemOut().endsWith(expectedOut));
    }

    @Test
    public void show_menu_test() {
        String expectedOut="Please choose the menu item first:\n" +
                "1. List Books\n";
        printer.showMenu(menu);
        assertTrue(systemOut().endsWith(expectedOut));
    }

    @Test
    public void should_warn_when_choose_invalid_menu_item() {
        String expectedOut="Select a valid option!";
        assertFalse(printer.chooseMenuItem(menu,3));
        assertTrue(systemOut().endsWith(expectedOut));
    }
}
