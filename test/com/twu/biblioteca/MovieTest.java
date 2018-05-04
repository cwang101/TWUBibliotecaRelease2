package com.twu.biblioteca;

import com.twu.biblioteca.entity.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
public class MovieTest {


    Library library;

    public MovieTest() {
        List<Article> articles= Arrays.asList(new Book("One Hundred Years of Solitude","Gabriel Garcia Marquez","2000-08"),
                new Book("The City in History","Lewis Mumford","2005-02"),
                new Book("The Death and Life of Great American Cities","Jacobs Jane","2005-05"),
                new Movie("The Great Gatsby ","2013","Baz Luhrmann",8),
                new Movie("The Shawshank Redemption","1994","Frank Darabont",9),
                new Movie("Predestination","2014","Peter Spierig",9));
        List<Account> accounts=Arrays.asList(new Account("123-4322","123","Jim","Jim@hotmail","NewYork","911"),
                new Account("211-4356","123","Sam","Sam@hotmail","NewYork","911"));
        library=new Library(1,new ArrayList<>(accounts),new ArrayList<>(articles));

    }
    @Test
    public void should_return_null_when_movie_checked_out_is_not_available() {
        Account accounts=library.login("123-4322","123");
        Movie movie=library.checkOutMovie(accounts,"Transformers");
        assertNull(movie);
    }

    @Test
    public void should_return_movie_when_movie_checked_out_is_not_available() {
        Account accounts=library.login("123-4322","123");
        Movie expectMovie=new Movie("The Shawshank Redemption","1994","Frank Darabont",9);
        List<Article> expectArticles=Arrays.asList(
                new Movie("The Great Gatsby ","2013","Baz Luhrmann",8),
                new Movie("Predestination","2014","Peter Spierig",9));

        List<Article> expectUnavailable=Arrays.asList(expectMovie);
        Movie movie=library.checkOutMovie(accounts,"The Shawshank Redemption");

        assertEquals(movie,expectMovie);
        assertEquals(library.getMoviesAvailable(),expectArticles);
        assertEquals(accounts.getPossessions(),expectUnavailable);
    }
}
