package com.formation.infotel.dto;

import java.util.List;

import com.formation.infotel.entity.Book;

public class AuthorDto {
	
	private long authorId;
	private String authorLastName;
	private String firstName;
	
	public AuthorDto(String authorLastName, String firstName, List<Book> books) {
		this.authorLastName = authorLastName;
		this.firstName = firstName;
		this.books = books;
	}

	public long getAuthorId() {
		return authorId;
	}

	private List<Book> books;
	
	
	public String getAuthorLastName() {
		return authorLastName;
	}

	public void setAuthorLastName(String authorLastName) {
		this.authorLastName = authorLastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	
	
	

}
