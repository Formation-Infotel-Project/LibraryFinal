package com.formation.infotel.services.impl;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.infotel.entity.Book;
import com.formation.infotel.entity.Category;
import com.formation.infotel.interfaces.CategoryDao;
import com.formation.infotel.services.interfaces.CategoryService;


@Repository
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	
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
	public List<Book> getCategoriesPeriodique(String categoryName) {
	Category Periodique = categoryDao.getCategoriesPeriodique(categoryName);
	List<Book> List = null;
	 List = Periodique.getBooks();
	if( List.isEmpty()) {
		System.out.println("no book found");
	}
	else {
		System.out.println(List);
		}
	
	return List;
	}
			
	}
	


