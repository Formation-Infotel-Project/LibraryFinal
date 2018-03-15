package com.formation.infotel.dto;

import java.util.List;

import javax.persistence.OneToMany;

import com.formation.infotel.entity.Book;

public class EditorDto {

	
	private long editorId;
	private String name;
	private String editorAddress;
	

	private List<Integer> booksId;


	public long getEditorId() {
		return editorId;
	}


	public void setEditorId(long editorId) {
		this.editorId = editorId;
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


	public EditorDto(long editorId, String name, String editorAddress, List<Integer> booksId) {

		this.editorId = editorId;
		this.name = name;
		this.editorAddress = editorAddress;
		this.booksId = booksId;
	}
	
	
	
}
