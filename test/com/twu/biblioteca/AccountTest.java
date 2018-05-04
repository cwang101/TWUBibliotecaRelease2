package com.twu.biblioteca;

import com.twu.biblioteca.entity.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class AccountTest {

    Library library;

    public AccountTest() {
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
    public void should_return_null_when_username_does_not_exist() {
           Account account= library.login("111-111","123");
            assertNull(account);
    }

    @Test
    public void should_return_null_when_password_is_wrong() {
        Account account= library.login("211-4356","456");
        assertNull(account);
    }

    @Test
    public void should_return_Account_when_username_and_password_are_right() {
        Account expectOut=new Account("211-4356","123","Sam","Sam@hotmail","NewYork","911");
        Account account= library.login("211-4356","123");
        assertEquals(expectOut,account);
    }
}
