package com.formation.infotel.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

import com.formation.infotel.entity.Catalog;
import com.formation.infotel.interfaces.CatalogDao;

@Repository
@Transactional
public class CatalogDaoImpl implements CatalogDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Catalog getCatalogByName(String catalogName) {
		Query<Catalog> query = sessionFactory.getCurrentSession().createQuery(String.format("FROM Catalog where name = :catalogName"));
		query.setParameter("catalogName", catalogName);
		return (Catalog) query.list().get(0);
	}
}
