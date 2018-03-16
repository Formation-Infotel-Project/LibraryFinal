package com.formation.infotel.services.interfaces;

import java.util.List;
import java.util.Set;

import com.formation.infotel.entity.Book;
import com.formation.infotel.entity.Category;

public interface CategoryService {

	void insertCategory(Category category);

	void deleteCategory(Category category);

	void updateCategory(Category category);

	Category getCategory(int categoryId);

	List<Category> getAllCategories();

	List<Category> getAllBookByCategory(String categoryname);
	
	Set<Book> getCategoriesPeriodique(String categoryName);

	Category getCategoryByName(String name);
}
