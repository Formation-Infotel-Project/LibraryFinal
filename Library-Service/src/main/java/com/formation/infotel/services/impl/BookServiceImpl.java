package com.formation.infotel.services.impl;

import com.formation.infotel.entity.Book;
import com.formation.infotel.interfaces.BookDao;
import com.formation.infotel.interfaces.Dao;
import com.formation.infotel.services.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;
    @Autowired
    private Dao dao;

    @Override
    public void insertBook(Book book) {
        dao.save(Book.class);
    }

    @Override
    public void updateBook(Book book, int bookId) {
        dao.saveOrUpdate(Book.class);
    }

    @Override
    public void deleteBook(Book book) {
        dao.delete(Book.class);
    }

    @Override
    public Book getBookById(int bookId) {
        return dao.get(Book.class, bookId);
    }

    @Override
    public List<Book> getBooks() {
        return dao.getAll(Book.class);
    }

	@Override
	public String getBookByDescription(String description) {
		return null;
	}

    @Override
    public Book getBookByName(String bookName) {
        Book book=bookDao.getBookByName(bookName);
        System.out.println(book.getBookTitle());
        return book;
    }

    @Override
    public List<Book> getRecommandedBooks() {
        return bookDao.getRecommandedBooks();
    }
}
