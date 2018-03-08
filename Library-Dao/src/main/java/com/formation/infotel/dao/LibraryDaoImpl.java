package com.formation.infotel.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.formation.infotel.entity.Library;
import com.formation.infotel.interfaces.LibraryDao;

@Repository
@Transactional
public class LibraryDaoImpl implements LibraryDao{
	
	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public void insertLibrary(Library library) {
		 sessionFactory.getCurrentSession().save(library);
	}

	@Override
	public Library getLibraryById(int libraryId) {
		return  (Library) sessionFactory.getCurrentSession().get(Library.class,libraryId);
	}

	@Override
	public Library getLibrary(String libraryname) {
		   Query<Library> query = sessionFactory.getCurrentSession().createQuery(String.format("FROM Library where libraryCode = :libraryname"));
		   query.setParameter("libraryname", libraryname);
	       return (Library) query.list().get(0);
	}

	@Override
	public List<Library> getLibrary() {
		List<Library> libraries = sessionFactory.getCurrentSession().createQuery(String.format("FROM Library as library")).list();
		return libraries;
	}

}
