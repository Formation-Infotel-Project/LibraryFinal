package com.formation.infotel.interfaces;

import com.formation.infotel.entity.Book_copy;

import java.util.List;


public interface Book_copyDao {

    void insertBook_copy(Book_copy book_copy);

    Book_copyDao getBook_copyById(int book_copyId);

    Book_copyDao getBook_copy(String book_copyName);

    List<Book_copyDao> getBook_copy();
	
}
