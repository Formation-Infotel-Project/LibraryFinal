package com.formation.infotel.interfaces;

import com.formation.infotel.entity.Book;

import java.util.List;

public interface BookDao {

    void insertBook(Book book);

    Book getBookById(int bookId);

    Book getBook(String bookname);
    
    Book getBookByDescrition(String description);

    Book getBookByName(String bookName);
    
    List<Book> getBooks();
}
