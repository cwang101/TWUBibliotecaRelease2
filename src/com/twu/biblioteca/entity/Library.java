package com.twu.biblioteca.entity;

import com.twu.biblioteca.entity.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Library {
    long id;

    List<Book> books=new ArrayList<>();

    List<Book> unavailable=new ArrayList<>();

    List<Account> accounts=new ArrayList<>();
    public Library(long id) {
        this.id=id;
    }

    public Library(long id,List<Book> books) {
        this(id);
        this.books = books;
    }

    public void addAccouts(List<Account> accounts){
        this.accounts.addAll(accounts);
    }



    public List<Book> getBooks() {
        return books;
    }

    public List<Book> getUnavailable() {
        return unavailable;
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

    public Account login(String username,String password){
        Optional<Account> user= accounts.stream().filter(account -> account.userName.equals(username)&&account.password.equals(password)).findFirst();
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }

}
