package com.formation.infotel.services.interfaces;
import javax.transaction.Transactional;
import com.formation.infotel.entity.Book;
import java.util.List;
public interface BookService {
	
    void insertBook(Book book);

    void updateBook(Book book, int bookId);

    void deleteBook(Book book);

    Book getBookById(int bookId);

    List<Book> getBooks();
    
	String getBookByDescription(String description);
	
	Book getBookByName(String bookName);
}
