package com.formation.infotel.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Category {
	
	@Id
	@GeneratedValue
	private int categoryId;
	@Column(unique = true)
	private String name;
	private String description;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "category")
	private Set<Book> books = new HashSet<>();
	
	public Category(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public Category() {

	}

	public int getCategoryId() {
		return categoryId;
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

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
}
