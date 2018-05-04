package com.twu.biblioteca.entity;

import java.util.Objects;

public class Movie extends Articles{
    String name;
    String year;
    String director;
    String rating;

    public Movie(String name, String year, String director, String rating) {
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

    public String getRating() {
        return rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(name, movie.name) &&
                Objects.equals(year, movie.year) &&
                Objects.equals(director, movie.director) &&
                Objects.equals(rating, movie.rating);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, year, director, rating);
    }
}
