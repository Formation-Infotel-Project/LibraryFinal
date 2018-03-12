package com.formation.infotel.interfaces;

import com.formation.infotel.entity.Book;
import com.formation.infotel.entity.Category;

import java.util.List;

public interface CategoryDao {

    void insertCategory(Category category);

    Category getCategoryById(int categoryId);

    List<Category>  getAllBookByCategory(String categoryname);
    
    Category getCategoriesPeriodique(String name);

    List<Category> getCategories();
}
