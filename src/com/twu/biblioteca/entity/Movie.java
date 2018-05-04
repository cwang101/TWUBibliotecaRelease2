package com.twu.biblioteca.entity;

import java.util.Objects;

public class Movie extends Article {
    String name;
    String year;
    String director;
    int rating;

    public Movie(String name, String year, String director, int rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return rating == movie.rating &&
                Objects.equals(name, movie.name) &&
                Objects.equals(year, movie.year) &&
                Objects.equals(director, movie.director);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, year, director, rating);
    }
}
