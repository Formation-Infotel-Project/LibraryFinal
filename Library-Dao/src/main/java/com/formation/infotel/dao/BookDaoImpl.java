package com.formation.infotel.dao;

import com.formation.infotel.entity.Book;
import com.formation.infotel.interfaces.BookDao;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class BookDaoImpl implements BookDao {

    @Autowired
    private SessionFactory sessionFactory;

	@Override
	public Book getBookByDescrition(String description) {
		 Query<Book> query = sessionFactory.getCurrentSession().createQuery(String.format("FROM Book where bookDescription LIKE :description"));
	        query.setParameter("description", description);
	        return (Book) query.list().get(0);
	}

	@Override
	public Book getBookByName(String bookName) {
		Query<Book> query = sessionFactory.getCurrentSession().createQuery(String.format("FROM Book where bookTitle = :bookName"));
        query.setParameter("bookName", bookName);
        return (Book) query.list().get(0);
	}

    @Override
    public List<Book> getRecommandedBooks() {
        List<Book> books = sessionFactory.getCurrentSession().createQuery(String.format("FROM Book where popularBook = 1")).list();
        return books;
    }
}
