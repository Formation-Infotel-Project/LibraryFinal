package com.formation.infotel.services.impl;

import com.formation.infotel.entity.BookShelf;
import com.formation.infotel.interfaces.Dao;
import com.formation.infotel.services.interfaces.BookShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookShelfServiceImpl implements BookShelfService {

    @Autowired
    private Dao dao;

    @Override
    public void insertBookShelf(BookShelf bookShelf) {
        dao.save(bookShelf);
    }

    @Override
    public void deleteBookShelf(BookShelf bookShelf) {
        dao.delete(bookShelf);
    }

    @Override
    public void updateBookShelf(BookShelf bookShelf) {
        dao.saveOrUpdate(bookShelf);
    }

    @Override
    public BookShelf getBookShelf(int bookShelfId) {
        return dao.get(BookShelf.class, bookShelfId);
    }

    @Override
    public List<BookShelf> getAllBookShelfs() {
        return dao.getAll(BookShelf.class);
    }
}
