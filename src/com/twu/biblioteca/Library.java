package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    long id;

    List<Book> books=new ArrayList<>();

    List<Book> unavailable=new ArrayList<>();
    public Library(long id) {
        this.id=id;
    }

    public Library(long id,List<Book> books) {
        this(id);
        this.books = books;
    }

   public List<Book> getAllBooks(){
        List<Book> clone=new ArrayList<>();
        clone.addAll(this.books);
       return clone;
   }

   public boolean checkOut(String bookName){
       unavailable.addAll(books.stream().filter(book-> book.getName().equals(bookName)).collect(Collectors.toList())) ;

       return books.removeIf(book-> book.getName().equals(bookName));
   }

    public boolean giveBack(String bookName) {
        books.addAll(unavailable.stream().filter(book-> book.getName().equals(bookName)).collect(Collectors.toList())) ;
        return unavailable.removeIf(book-> book.getName().equals(bookName));
    }
}
