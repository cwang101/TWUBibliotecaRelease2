package com.twu.biblioteca;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Library;
import com.twu.biblioteca.entity.Menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ConsoleMessagePrinter {

    public void printWelcomeMessage() {
        System.out.println("Welcome to the Library!");
    }

    public void printBookList(Library library){
        System.out.print("Books available:\n"+
        "No.|name|author|published year\n"+
        "================================================\n");
        List<Book> books=library.getAllBooks();
        IntStream.range(0,books.size())
                .mapToObj(index->(index+1)+"|"+books.get(index).getName()+"|"+books.get(index).getAuthor()+"|"+books.get(index).getPublishedYear()+"\n")
                .forEach(System.out::print);

        System.out.print( "================================================\n");
    }

    public  void showMenu(Menu menu){
        System.out.print("Please choose the menu item first:\n");
        List<String> items=menu.getAllItems();
        IntStream.range(0,items.size())
                .mapToObj(index->(index+1)+". "+items.get(index)+"\n")
                .forEach(System.out::print);

    }


    public boolean chooseMenuItem(Menu menu,int itemNo){
        if(menu.isValidIndex(itemNo)) {
            return true;
        }
        System.out.print("Select a valid option!");
        return false;

    }
    public static void main(String[] args) {
        List<Book> books= Arrays.asList(new Book("One Hundred Years of Solitude","Gabriel Garcia Marquez","2000-08"),
                new Book("The City in History","Lewis Mumford","2005-02"),
                new Book("The Death and Life of Great American Cities","Jacobs Jane","2005-05"));

      Library  library=new Library(1,new ArrayList<>(books));
        ConsoleMessagePrinter printer=  new ConsoleMessagePrinter();
        //printer.printBookList(library);
       // printer.showMenu(new Menu(Arrays.asList("List Books")));
        printer.printCheckOutMessage(library,"The City in History");

    }

    public void printCheckOutMessage(Library library, String bookName) {
        if(library.checkOut(bookName)){
            System.out.print("Thank you! Enjoy the book\n");
            return;
        }
        System.out.print("That book is not available.\n");
    }

    public void printGiveBackMessage(Library library, String bookName){
        if(library.giveBack(bookName)){
            System.out.print("Thank you for returning the book.\n");
            return;
        }
        System.out.print("That is not a valid book to return.\n");
    }
}
