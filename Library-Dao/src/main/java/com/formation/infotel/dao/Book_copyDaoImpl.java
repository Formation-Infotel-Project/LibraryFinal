package com.formation.infotel.dao;

import java.util.List;

import com.formation.infotel.entity.Book_copy;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.formation.infotel.interfaces.Book_copyDao;

@Repository
@Transactional
public class Book_copyDaoImpl implements Book_copyDao {

	
    @Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public void insertBook_copy(Book_copy book_copy) {
	
		 sessionFactory.getCurrentSession().save(book_copy);
	}

	@Override
	public Book_copyDao getBook_copyById(int book_copyId) {
		
		return sessionFactory.getCurrentSession().get(Book_copyDao.class,book_copyId);
	}

	@Override
	public Book_copyDao getBook_copy(String book_copyName) {
		Query<Book_copyDao> query = sessionFactory.getCurrentSession().createQuery(String.format("FROM Book_copy where book_copyTitle = :book_copyName"));
		query.setParameter("book_copyname", book_copyName);
		return (Book_copyDao) query.list().get(0);
	}

	@Override
	public List<Book_copyDao> getBook_copy() {
		List<Book_copyDao> bookCopies = sessionFactory.getCurrentSession().createQuery(String.format("FROM Book_copyDao as bookCopies")).list();
		return bookCopies;
	}
	
	

	

}
