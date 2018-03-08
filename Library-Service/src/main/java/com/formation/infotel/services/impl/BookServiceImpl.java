package com.formation.infotel.services.impl;

import com.formation.infotel.entity.Book;
import com.formation.infotel.interfaces.BookDao;
import com.formation.infotel.services.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public void insertBook(Book book) {
        bookDao.insertBook(book);
    }

    @Override
    public void updateBook(Book book, int bookId) {
    }

    @Override
    public void deleteBook(Book book) {
    }

    @Override
    public Book getBookById(int bookId) {
        return bookDao.getBookById(bookId);
    }

    @Override
    public List<Book> getBooks() {
        return bookDao.getBooks();
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
}
