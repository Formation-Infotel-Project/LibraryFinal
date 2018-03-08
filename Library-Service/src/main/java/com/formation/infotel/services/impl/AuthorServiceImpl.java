package com.formation.infotel.services.impl;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.infotel.entity.Author;
import com.formation.infotel.entity.Book;
import com.formation.infotel.interfaces.AuthorDao;
import com.formation.infotel.services.interfaces.AuthorService;

@Transactional
@Repository
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorDao authorDao;

	@Override
	public List<Book> getListBookByNameAuthor(String nameAuteur) {

		List<Author> listAuthorByName = null;

		List<Book> listBookByNameAuteur = null;

		listAuthorByName = authorDao.getBookByAuthor(nameAuteur);
		if (listAuthorByName.isEmpty()) {
			System.out.println("no boo");

		}

		if (listAuthorByName.size() > 0) {

			for (Iterator<Author> iterator = listAuthorByName.iterator(); iterator.hasNext();) {
				Author author = (Author) iterator.next();
				listBookByNameAuteur = author.getBooks();

			}
		}
		
		listBookByNameAuteur.sort((p1, p2) -> p1.getBookTitle().compareTo(p2.getBookTitle()));
		System.out.println(listBookByNameAuteur);
		return listBookByNameAuteur;
	}

}
