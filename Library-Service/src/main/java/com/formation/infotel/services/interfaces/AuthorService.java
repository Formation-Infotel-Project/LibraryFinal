package com.formation.infotel.services.interfaces;

import java.util.List;

import com.formation.infotel.entity.Author;
import com.formation.infotel.entity.Book;

public interface AuthorService {

	List<Book> getListBookByNameAuthor(String nameAuteur);
}
