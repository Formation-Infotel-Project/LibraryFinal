package com.formation.infotel.services.impl;

import com.formation.infotel.entity.Book_copy;
import com.formation.infotel.interfaces.Dao;
import com.formation.infotel.services.interfaces.BookCopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCopyServiceImpl implements BookCopyService {

    @Autowired
    private Dao dao;

    @Override
    public void insertBookCopy(Book_copy bookCopy) {
        dao.save(bookCopy);
    }

    @Override
    public void deleteBookCopy(Book_copy bookCopy) {
        dao.delete(bookCopy);
    }

    @Override
    public void updateBookCopy(Book_copy bookCopy) {
        dao.saveOrUpdate(bookCopy);
    }

    @Override
    public Book_copy getBookCopy(int bookCopyId) {
        return dao.get(Book_copy.class, bookCopyId);
    }

    @Override
    public List<Book_copy> getAll() {
        return dao.getAll(Book_copy.class);
    }
}
