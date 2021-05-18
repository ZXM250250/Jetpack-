package com.dongnaoedu.paging.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

/**
 * @author ningchuanqi
 * @version V1.0
 */
@Entity(tableName = "movie")
public class Movie {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "no",typeAffinity = ColumnInfo.INTEGER)
    public int NO;
    @ColumnInfo(name = "id",typeAffinity = ColumnInfo.INTEGER)
    public int id;
    @ColumnInfo(name = "title",typeAffinity = ColumnInfo.TEXT)
    public String title;
    @ColumnInfo(name = "rate",typeAffinity = ColumnInfo.TEXT)
    public String rate;
    @ColumnInfo(name = "cover",typeAffinity = ColumnInfo.TEXT)
    public String cover;


    @Override
    public String toString() {
        return "Movie{" +
                "NO=" + NO +
                ", id=" + id +
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
        return NO == movie.NO &&
                id == movie.id &&
                title.equals(movie.title) &&
                rate.equals(movie.rate) &&
                cover.equals(movie.cover);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NO, id, title, rate, cover);
    }
}
