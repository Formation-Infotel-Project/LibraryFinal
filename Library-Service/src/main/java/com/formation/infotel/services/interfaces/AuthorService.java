package com.formation.infotel.services.interfaces;

import java.util.List;

import com.formation.infotel.entity.Author;
import com.formation.infotel.entity.Book;

public interface AuthorService {

	void insertAuthor(Author author);

	void deleteAuthor(Author author);

	void updateAuthor(Author author);

	Author getAuthor(int authorId);

	List<Author> getAllAuthors();

	List<Book> getListBookByNameAuthor(String nameAuteur);

	Author getAuthorByName(String name);
}
