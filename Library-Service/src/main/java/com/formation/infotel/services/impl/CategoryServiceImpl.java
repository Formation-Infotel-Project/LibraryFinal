package com.formation.infotel.services.impl;

import java.util.List;
import java.util.Set;

import com.formation.infotel.interfaces.Dao;
import org.springframework.beans.factory.annotation.Autowired;

import com.formation.infotel.entity.Book;
import com.formation.infotel.entity.Category;
import com.formation.infotel.interfaces.CategoryDao;
import com.formation.infotel.services.interfaces.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private Dao dao;

	@Override
	public void insertCategory(Category category) {
		dao.save(category);
	}

	@Override
	public void deleteCategory(Category category) {
		dao.delete(category);
	}

	@Override
	public void updateCategory(Category category) {
		dao.saveOrUpdate(category);
	}

	@Override
	public Category getCategory(int categoryId) {
		return dao.get(Category.class, categoryId);
	}

	@Override
	public List<Category> getAllCategories() {
		return dao.getAll(Category.class);
	}

	/* retourne la liste de tous les livre pas cat�gorie*/
	@Override
	public List<Category> getAllBookByCategory(String categoryname) {
		categoryname="Manga d'Action"; /*uniquement pour le teste ne reste pas dans la version final*/
		
		List<Category> AllBook = null;
		 AllBook = categoryDao.getAllBookByCategory(categoryname);
		 
		if( AllBook.isEmpty()) {
			System.out.println("no book found");
		}
		else {
			System.out.println(AllBook);
			}
		return AllBook; 
		}

	/* retourne un objet catalogue contenant tout les p�riodique*/
	@Override
	public Set<Book> getCategoriesPeriodique(String categoryName) {
		Category Periodique = categoryDao.getCategoriesPeriodique(categoryName);
		Set<Book> list = null;
		 list = Periodique.getBooks();
		if( list.isEmpty()) {
			System.out.println("no book found");
		}
		else {
			System.out.println(list);
		}
	
		return list;
	}

	@Override
	public Category getCategoryByName(String name) {
		return categoryDao.getCategoryByName(name);
	}
}

	


