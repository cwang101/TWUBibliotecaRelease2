package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {
    long id;

    List<Book> books=new ArrayList<>();

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

}
