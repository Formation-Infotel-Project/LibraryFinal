package com.formation.infotel.dao;

import com.formation.infotel.entity.Category;
import com.formation.infotel.interfaces.CategoryDao;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//import org.hibernate.Query;

import java.util.List;



@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private SessionFactory sessionFactory;
    
    
    @Override
    public void insertCategory(Category category) {
        sessionFactory.getCurrentSession().save(category);
    }

    @Override
    public Category getCategoryById(int categoryId) {
        return (Category) sessionFactory.getCurrentSession().get(Category.class, categoryId);
    }
    /*cette methode retourne la liste des livres pour une catégorie donneé*/
    @Override
    public List<Category> getAllBookByCategory(String categoryname) {
        Query<Category> query = sessionFactory.getCurrentSession().createQuery(String.format("FROM Category where name = :categoryname"));
        query.setParameter("categoryname", categoryname);
        return  query.list();
    }

    @Override
    public List<Category> getCategories() {
        List<Category> categories = sessionFactory.getCurrentSession().createQuery(String.format("FROM Category as category")).list();
        return categories;
    }

	@Override
	public Category getCategoriesPeriodique(String categoryName) {
		/*String categoryname = "Periodique";
		 Query<Category> query = sessionFactory.getCurrentSession().createQuery("FROM Category where name = :categoryname");
	        query.setParameter("categoryname", categoryname);
	        return (Category) query.list().get(0);*/
		return (Category) sessionFactory.getCurrentSession().get(Category.class, categoryName);
	}
}
