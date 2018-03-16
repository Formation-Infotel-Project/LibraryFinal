package com.formation.infotel.services.interfaces;

import com.formation.infotel.entity.BookShelf;

import java.util.List;

public interface BookShelfService {

    void insertBookShelf(BookShelf bookShelf);

    void deleteBookShelf(BookShelf bookShelf);

    void updateBookShelf(BookShelf bookShelf);

    BookShelf getBookShelf(int bookShelfId);

    List<BookShelf> getAllBookShelfs();
}
