package com.formation.infotel.controller.dto;

import java.util.List;

import javax.persistence.OneToMany;

import com.formation.infotel.entity.Book;

public class EditorDto {

	private String name;
	private String editorAddress;
	private List<Integer> booksId;

	public EditorDto() {
	}

	public EditorDto(String name, String editorAddress, List<Integer> booksId) {

		this.name = name;
		this.editorAddress = editorAddress;
		this.booksId = booksId;
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

	public List<Integer> getBooksId() {
		return booksId;
	}

	public void setBooksId(List<Integer> booksId) {
		this.booksId = booksId;
	}
}
