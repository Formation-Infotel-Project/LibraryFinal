package com.formation.infotel.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Editor {
 
	@Id
	@GeneratedValue
	private int editorId;
	private String name;
	private String editorAddress;
	
	@OneToMany(mappedBy = "editor")
	private List<Book> books;

	public Editor(String name, String editorAddress) {
		this.name = name;
		this.editorAddress = editorAddress;
	}
	
	public Editor() {

	}

	public int getEditorId() {
		return editorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEditorAddress() {
		return editorAddress;
	}

	public void setEditorAddress(String editorAddress) {
		this.editorAddress = editorAddress;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
