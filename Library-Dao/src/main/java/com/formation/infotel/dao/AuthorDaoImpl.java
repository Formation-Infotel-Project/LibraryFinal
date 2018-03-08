package com.formation.infotel.dao;

import com.formation.infotel.entity.Author;
import com.formation.infotel.interfaces.AuthorDao;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class AuthorDaoImpl implements AuthorDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void insertAuthor(Author author) {
        sessionFactory.getCurrentSession().save(author);
    }

    @Override
    public Author getAuthorById(int authorId) {
        return (Author) sessionFactory.getCurrentSession().get(Author.class, authorId);
    }

    @Override
    public Author getAuthor(String authorname) {
        Query<Author> query = sessionFactory.getCurrentSession().createQuery(String.format("FROM Author where authorLastName = :authorname"));
        query.setParameter("authorname", authorname);
        return (Author) query.list().get(0);
    }

    @Override
    public List<Author> getAuthors() {
        List<Author> authors = sessionFactory.getCurrentSession().createQuery(String.format("FROM Author as authors")).list();
        return authors;
    }
    
    /**
     * cette méthode retourne soit zero auteur si le nom pas en base
     * soit un auteur s'il est seul
     * soit plusisurs si plusisurs portent le meme nom
     */

	@Override
	public List<Author> getBookByAuthor(String authorLastName) {
		@SuppressWarnings("unchecked")

		Query<Author> query = sessionFactory.getCurrentSession().createQuery(String.format("FROM Author where authorLastName = :authorLastName"));
        query.setParameter("authorLastName", authorLastName);
        return  query.list();
	}
}
