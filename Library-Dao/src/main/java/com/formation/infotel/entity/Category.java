package com.formation.infotel.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
	
	@Id
	@GeneratedValue
	private int categoryId;
	private String name;
	private String description;

	@ManyToMany(mappedBy = "categories")
	private List<Book> books = new ArrayList<>();
	
	public Category(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public Category() {

	}

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

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
