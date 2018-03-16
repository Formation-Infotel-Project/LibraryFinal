package com.formation.infotel.controller;

import com.formation.infotel.controller.dto.CategoryDto;
import com.formation.infotel.entity.Book;
import com.formation.infotel.entity.Category;
import com.formation.infotel.services.interfaces.BookService;
import com.formation.infotel.services.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    BookService bookService;

    @PutMapping(value = "category/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addCategory(@RequestBody CategoryDto categoryDto){

        Category category = new Category(categoryDto.getName(), categoryDto.getDescription());
        Set<Book> books = new HashSet<>();
        for(int i=0;i<categoryDto.getBooksId().size();i++){
            books.add(bookService.getBookById(categoryDto.getBooksId().get(i)));
        }
        category.setBooks(books);

        categoryService.insertCategory(category);
    }

    @PostMapping(value = "category/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable(value="id") int id){

        Category category = categoryService.getCategory(id);
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        Set<Book> books = new HashSet<>();
        for(int i=0;i<categoryDto.getBooksId().size();i++){
            books.add(bookService.getBookById(categoryDto.getBooksId().get(i)));
        }
        category.setBooks(books);

        categoryService.updateCategory(category);
    }

    @DeleteMapping(value = "category/delete/{id}")
    public void deleteCategory(@PathVariable(value="id") int id){

        Category category = categoryService.getCategory(id);

        categoryService.deleteCategory(category);
    }

    @RequestMapping("category/get/{id}")
    public CategoryDto getCategory(@PathVariable(value="id") int id){
        Category category = categoryService.getCategory(id);
        List<Integer> booksId = new ArrayList<>();
        category.getBooks().forEach(b -> {
            booksId.add(b.getIsbn());
        });
        CategoryDto viewCategory = new CategoryDto(category.getName(), category.getDescription(), booksId);
        return viewCategory;
    }

    @RequestMapping("category/get")
    public List<CategoryDto> getCategories(){
        List<CategoryDto> viewCategories = new ArrayList<>();
        List<Category> categories = categoryService.getAllCategories();
        List<Integer> booksId = new ArrayList<>();
        categories.forEach(c -> {
            c.getBooks().forEach(b -> booksId.add(b.getIsbn()));
            viewCategories.add(new CategoryDto(c.getName(), c.getDescription(), booksId));
        });
        return viewCategories;
    }
}