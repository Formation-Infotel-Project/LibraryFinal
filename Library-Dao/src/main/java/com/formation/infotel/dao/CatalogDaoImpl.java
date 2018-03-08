package com.formation.infotel.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.formation.infotel.entity.Catalog;
import com.formation.infotel.entity.Catalog;
import com.formation.infotel.interfaces.CatalogDao;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class CatalogDaoImpl implements CatalogDao {

	
    @Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public void insertAuthor(Catalog catalog) {
		 sessionFactory.getCurrentSession().save(catalog);
	}

	@Override
	public Catalog getAuthorById(int catalogId) {
		return  sessionFactory.getCurrentSession().get(Catalog.class,  catalogId);
	}

	@Override
	public Catalog getAuthor(String catalogName) {
		  Query<Catalog> query = sessionFactory.getCurrentSession().createQuery(String.format("FROM Catalog where name = :catalogName"));
	        query.setParameter("catalogName", catalogName);
	        return (Catalog) query.list().get(0);
	}

	@Override
	public List<Catalog> getCatalog() {
		List<Catalog> catalogs = sessionFactory.getCurrentSession().createQuery(String.format("FROM Catalog as catalog")).list();
		return catalogs;
	}

}
