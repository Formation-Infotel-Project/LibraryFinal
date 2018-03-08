package com.formation.infotel.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.infotel.interfaces.BorrowDao;
import com.formation.infotel.entity.BookBasket;
import com.formation.infotel.entity.Borrow;
import com.formation.infotel.entity.Borrow;;

@Repository
@Transactional
public class BorrowDaoImpl implements BorrowDao{

    @Autowired
    private SessionFactory sessionFactory;

	@Override
	public void createBorrow(Borrow borrow) {
		 sessionFactory.getCurrentSession().save(borrow);
	
	}

	@Override
	public  Borrow getBorrowById(int borrowId) {
		 return  sessionFactory.getCurrentSession().get(Borrow.class,  borrowId);
	}

	@Override
	public  Borrow getBorrow(String BorrowId) {
		 Query<Borrow> query = sessionFactory.getCurrentSession().createQuery(String.format("FROM Borrow where borrowId = :BorrowId"));
	        query.setParameter("BorrowId", BorrowId);
	        return (Borrow) query.list().get(0);
	}

	@Override
	public List<Borrow> Borrow() {
		List<Borrow> borrows = sessionFactory.getCurrentSession().createQuery(String.format("FROM Borrow as borrow")).list();
		return borrows;
	}

	

	
	
}
