package com.formation.infotel.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book_copy {

    @Id
    @GeneratedValue
    private int book_copyId;
    private String book_copyTitle;

    @ManyToOne
    private Book book;

    @ManyToOne
    private BookShelf bookShelf;

    @ManyToMany(mappedBy = "book_copies")
    private List<BookBasket> bookBaskets = new ArrayList<>();

    public Book_copy() {
    }

    public Book_copy(String book_copyTitle, Book book, BookShelf bookShelf) {
        this.book_copyTitle = book_copyTitle;
        this.book = book;
        this.bookShelf = bookShelf;
    }

    public Book_copy(String book_copyTitle) {
        this.book_copyTitle = book_copyTitle;
    }

    public String getBook_copyTitle() {
        return book_copyTitle;
    }

    public void setBook_copyTitle(String book_copyTitle) {
        this.book_copyTitle = book_copyTitle;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
