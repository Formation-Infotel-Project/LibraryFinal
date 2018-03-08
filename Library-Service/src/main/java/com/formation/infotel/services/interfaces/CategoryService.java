package com.formation.infotel.services.interfaces;

import java.util.List;

import com.formation.infotel.entity.Book;
import com.formation.infotel.entity.Category;

public interface CategoryService {

	List<Category> getAllBookByCategory(String categoryname);
	
	public List<Book> getCategoriesPeriodique(String categoryName);
}
