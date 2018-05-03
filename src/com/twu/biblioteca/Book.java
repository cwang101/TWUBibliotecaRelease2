package com.twu.biblioteca;

public class Book {
    long libraryId;
    String name;
    String author;
    String publishedYear;

    public Book(long libraryId, String name, String author, String publishedYear) {
        this.libraryId = libraryId;
        this.name = name;
        this.author = author;
        this.publishedYear = publishedYear;
    }

    public long getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(long libraryId) {
        this.libraryId = libraryId;
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
}
