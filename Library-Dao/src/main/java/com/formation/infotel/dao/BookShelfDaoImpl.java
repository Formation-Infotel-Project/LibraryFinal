package com.formation.infotel.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.infotel.entity.BookShelf;
import com.formation.infotel.entity.BookShelf;
import com.formation.infotel.interfaces.BookShelfDao;

@Repository
@Transactional
public class BookShelfDaoImpl implements BookShelfDao{

	
	@Autowired
	 private SessionFactory sessionFactory;

	@Override
	public void insertBookShelf(BookShelf bookShelf) {
		 sessionFactory.getCurrentSession().save(bookShelf);
		
	}

	@Override
	public BookShelf getBookShelfById(int bookShelfId) {
		return  sessionFactory.getCurrentSession().get(BookShelf.class,bookShelfId);
		
	}

	@Override
	public BookShelf getBookShelf(String bookShelfName) {
	    Query<BookShelf> query = sessionFactory.getCurrentSession().createQuery(String.format("FROM BookShelf where  bookShelfName = : bookShelfName"));
		query.setParameter(" bookShelfName",  bookShelfName);
		return (BookShelf) query.list().get(0);
	}

	@Override
	public List<BookShelf> getBookShelfs() {
		List<BookShelf> bookShelves = sessionFactory.getCurrentSession().createQuery(String.format("FROM BookShelf as bookShelves")).list();
		return bookShelves;
	}
}
