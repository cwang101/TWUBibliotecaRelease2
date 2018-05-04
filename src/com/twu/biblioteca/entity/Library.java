package com.twu.biblioteca.entity;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Library {
    long id;

    List<Account> accounts=new ArrayList<>();

    List<Article> articles=new ArrayList<>();

    public Library(long id) {
        this.id=id;
    }

    public Library(long id, List<Account> accounts, List<Article> articles) {
        this.id = id;
        this.accounts = accounts;
        this.articles = articles;
    }

    public List<Article> getBooksAvailable() {
        return articles.stream().filter(article -> article instanceof Book).collect(Collectors.toList());
    }


   public List<Article> getMoviesAvailable(){
       return articles.stream().filter(article -> article instanceof Movie).collect(Collectors.toList());

   }
   public Book checkOutBook(Account account,String bookName){
       Optional<Article> book= articles.stream().filter(article -> (article instanceof Book) &&(((Book) article).getName().equals(bookName))).findFirst();
       articles.removeIf(article -> (article instanceof Book) &&(((Book) article).getName().equals(bookName)));
       if(book.isPresent()){
           Book target=(Book) book.get();
           account.addPossession(target);
           return target;
       }
       return null;
   }

    public boolean giveBackBook(Account account,String bookName) {
        articles.addAll(account.getPossessions().stream().filter(article -> (article instanceof Book) &&(((Book) article).getName().equals(bookName))).collect(Collectors.toList()));
        return  account.getPossessions().removeIf(article -> (article instanceof Movie) &&(((Book) article).getName().equals(bookName)));
    }

    public Account login(String username,String password){
        Optional<Account> user= accounts.stream().filter(account -> account.userName.equals(username)&&account.password.equals(password)).findFirst();
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }

    public Movie checkOutMovie(Account account, String movieName) {
        Optional<Article> movie= articles.stream().filter(article -> (article instanceof Movie) &&(((Movie) article).getName().equals(movieName))).findFirst();
        articles.removeIf(article -> (article instanceof Movie) &&(((Movie) article).getName().equals(movieName)));
        if(movie.isPresent()){
            Movie target=(Movie) movie.get();
            account.addPossession(target);
            return target;
        }
        return null;
    }


    public boolean giveBackMovie(Account account,String movieName){
        articles.addAll(account.getPossessions().stream().filter(article -> (article instanceof Movie) &&(((Movie) article).getName().equals(movieName))).collect(Collectors.toList()));
        return  account.getPossessions().removeIf(article -> (article instanceof Movie) &&(((Movie) article).getName().equals(movieName)));
    }
}
