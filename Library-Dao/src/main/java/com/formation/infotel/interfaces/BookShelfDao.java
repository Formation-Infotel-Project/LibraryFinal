package com.formation.infotel.interfaces;

import java.util.List;

import com.formation.infotel.entity.BookShelf;


public interface BookShelfDao {

    void insertBookShelf(BookShelf bookShelf);

    BookShelf getBookShelfById(int bookShelfId);

    BookShelf getBookShelf(String bookShelfName);

    List<BookShelf> getBookShelfs();
	
}
