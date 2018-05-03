package com.twu.biblioteca;

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
                .mapToObj(index->(index+1)+"|"+books.get(index).getName()+"|"+books.get(index).getAuthor()+"|"+books.get(index).publishedYear+"\n")
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
        List<Book> books= Arrays.asList(new Book(1,"One Hundred Years of Solitude","Gabriel Garcia Marquez","2000-08"),
                new Book(1,"The City in History","Lewis Mumford","2005-02"),
                new Book(1,"The Death and Life of Great American Cities","Jacobs Jane","2005-05"));

      Library  library=new Library(1,books);
        ConsoleMessagePrinter printer=  new ConsoleMessagePrinter();
        //printer.printBookList(library);
        printer.showMenu(new Menu(Arrays.asList("List Books")));
    }
}
