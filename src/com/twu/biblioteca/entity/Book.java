package com.twu.biblioteca.entity;

import java.util.Objects;

public class Book extends Articles{
    String name;
    String author;
    String publishedYear;

    public Book( String name, String author, String publishedYear) {
        this.name = name;
        this.author = author;
        this.publishedYear = publishedYear;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(String publishedYear) {
        this.publishedYear = publishedYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name) &&
                Objects.equals(author, book.author) &&
                Objects.equals(publishedYear, book.publishedYear);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, author, publishedYear);
    }
}
