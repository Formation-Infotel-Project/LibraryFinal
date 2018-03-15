package com.formation.infotel.controller.dto;

import java.util.ArrayList;
import java.util.List;



import com.formation.infotel.entity.Book;

public class CategoryDto {
	
	private int categoryId;
	private String name;
	private String description;

	private List<Integer> books ;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Integer> getBooks() {
		return books;
	}

	public void setBooks(List<Integer> books) {
		this.books = books;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public CategoryDto(int categoryId, String name, String description, List<Integer> books) {

		this.categoryId = categoryId;
		this.name = name;
		this.description = description;
		this.books = books;
	}
	
	
	

}
