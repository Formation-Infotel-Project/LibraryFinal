package com.formation.infotel.services.impl;

import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.infotel.interfaces.Dao;
import com.formation.infotel.entity.Author;
import com.formation.infotel.entity.Book;
import com.formation.infotel.interfaces.AuthorDao;
import com.formation.infotel.services.interfaces.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorDao authorDao;
	@Autowired
	private Dao dao;

	@Override
	public void insertAuthor(Author author) {
		dao.save(author);
	}

	@Override
	public void deleteAuthor(Author author) {
		dao.delete(author);
	}

	@Override
	public void updateAuthor(Author author) {
		dao.saveOrUpdate(author);
	}

	@Override
	public Author getAuthor(int authorId) {
		return dao.get(Author.class, authorId);
	}

	@Override
	public List<Author> getAllAuthors() {
		return dao.getAll(Author.class);
	}

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

	@Override
	public Author getAuthorByName(String name) {
		return authorDao.getAuthorByName(name);
	}
}
