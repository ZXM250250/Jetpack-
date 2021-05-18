package com.dongnaoedu.paging.model;

import java.util.Objects;

/**
 * @author ningchuanqi
 * @version V1.0
 */
public class Movie {
    public int id;
    public String title;
    public String rate;
    public String cover;

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rate='" + rate + '\'' +
                ", cover='" + cover + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id &&
                title.equals(movie.title) &&
                rate.equals(movie.rate) &&
                cover.equals(movie.cover);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, rate, cover);
    }
}
