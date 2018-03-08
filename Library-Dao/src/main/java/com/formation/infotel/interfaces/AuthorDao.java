package com.formation.infotel.interfaces;

import com.formation.infotel.entity.Author;

import java.util.List;

public interface AuthorDao {

    void insertAuthor(Author author);

    Author getAuthorById(int authorId);

    Author getAuthor(String authorname);

    List<Author> getBookByAuthor(String authorId);
    
    List<Author> getAuthors();
}
