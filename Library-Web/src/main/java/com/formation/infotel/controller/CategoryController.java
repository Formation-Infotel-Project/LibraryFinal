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
	public Resultat addCategory(@RequestBody CategoryDto categoryDto) {
		
		Resultat resultat = new Resultat();

		try {
			Category category = new Category(categoryDto.getName(), categoryDto.getDescription());
			Set<Book> books = new HashSet<>();
			for (int i = 0; i < categoryDto.getBooksId().size(); i++) {
				books.add(bookService.getBookById(categoryDto.getBooksId().get(i)));
			}
			category.setBooks(books);

			categoryService.insertCategory(category);
			resultat.setMessage(ControllerConstants.INSERT_SUCCESS);
			resultat.setSuccess(true);

		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.INSERT_ERRORS);
			e.printStackTrace();
		}
		
		return resultat;
	}

	@PostMapping(value = "category/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Resultat updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable(value = "id") int id) {
		Resultat resultat = new Resultat();

		try {
			Category category = categoryService.getCategory(id);
			category.setName(categoryDto.getName());
			category.setDescription(categoryDto.getDescription());
			Set<Book> books = new HashSet<>();
			for (int i = 0; i < categoryDto.getBooksId().size(); i++) {
				books.add(bookService.getBookById(categoryDto.getBooksId().get(i)));
			}
			category.setBooks(books);

			categoryService.updateCategory(category);
			resultat.setMessage(ControllerConstants.UPDATE_SUCCESS);
			resultat.setSuccess(true);
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.UPDATE_ERRORS);
			e.printStackTrace();
		}
		return resultat;
	}

	@DeleteMapping(value = "category/delete/{id}")
	public Resultat deleteCategory(@PathVariable(value = "id") int id) {
		
		Resultat resultat = new Resultat();

		try {
			Category category = categoryService.getCategory(id);

			categoryService.deleteCategory(category);
			resultat.setMessage(ControllerConstants.DELETE_SUCCESS);
			resultat.setSuccess(true);
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.DELETE_ERRORS);
			e.printStackTrace();
		}
		return resultat;
	}

	@RequestMapping("category/get/{id}")
	public Resultat getCategory(@PathVariable(value = "id") int id) {
		
		Resultat resultat = new Resultat();

		Category category;
		CategoryDto viewCategory = null;
		try {
			category = categoryService.getCategory(id);
		
		List<Integer> booksId = new ArrayList<>();
		category.getBooks().forEach(b -> {
			booksId.add(b.getIsbn());
		});
		resultat.setMessage(ControllerConstants.RETRIVE_SUCCESS);
		resultat.setSuccess(true);
		resultat.setPayload(viewCategory);
		 viewCategory = new CategoryDto(category.getName(), category.getDescription(), booksId);
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.RETRIVE_ERRORS);
			e.printStackTrace();
		}
		return resultat;
	}

	@RequestMapping("category/get")
	public Resultat getCategories() {
		List<CategoryDto> viewCategories = new ArrayList<>();
		Resultat resultat = new Resultat();

		List<Category> categories;
		try {
			categories = categoryService.getAllCategories();
		
		List<Integer> booksId = new ArrayList<>();
		categories.forEach(c -> {
			c.getBooks().forEach(b -> booksId.add(b.getIsbn()));
			viewCategories.add(new CategoryDto(c.getName(), c.getDescription(), booksId));
		});
		resultat.setMessage(ControllerConstants.RETRIVE_SUCCESS);
		resultat.setSuccess(true);
		resultat.setPayload(viewCategories);
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.RETRIVE_ERRORS);
			e.printStackTrace();
		}
		return resultat;
	}
}
