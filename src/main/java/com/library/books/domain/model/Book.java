package com.library.books.domain.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;

@Component
public class Book {

    private int id;
    private String title;
    private String author;
    private String genre;
    public static List<Book> books;

    static {
        bookRepository();
    }

    public Book() {

    }

    public Book(int id, String title, String author, String genre) {
        this.id = id;
       this.title = title;
       this.author = author;
       this.genre = genre;
    }

    public Book( String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    private static void bookRepository() {
        books = new ArrayList<>(asList(
                new Book(1,"Teste de titulo", "Teste de autor ", "Teste de genero"),
                new Book(2, "teste de titulo 2", "Teste de autor 2", "Teste de genero 2")));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public String getGenre(){
        return genre;
    }
    public void setGenre(String genre){
        this.genre = genre;
    }


}
