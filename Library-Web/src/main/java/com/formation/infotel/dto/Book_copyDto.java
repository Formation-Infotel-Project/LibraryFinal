package com.formation.infotel.dto;

import java.util.ArrayList;
import java.util.List;

import com.formation.infotel.entity.Book;
import com.formation.infotel.entity.BookBasket;
import com.formation.infotel.entity.BookShelf;

public class Book_copyDto {

    private int book_copyId;
    private String book_copyTitle;
    

    private int Isbn;;

    private  int bookShelfId;

    private List<Integer> bookBasketsId;

	public int getBook_copyId() {
		return book_copyId;
	}

	public String getBook_copyTitle() {
		return book_copyTitle;
	}

	public void setBook_copyTitle(String book_copyTitle) {
		this.book_copyTitle = book_copyTitle;
	}

	public int getIsbn() {
		return Isbn;
	}

	public void setIsbn(int isbn) {
		Isbn = isbn;
	}

	public int getBookShelfId() {
		return bookShelfId;
	}

	public void setBookShelfId(int bookShelfId) {
		this.bookShelfId = bookShelfId;
	}

	public List<Integer> getBookBasketsId() {
		return bookBasketsId;
	}

	public void setBookBasketsId(List<Integer> bookBasketsId) {
		this.bookBasketsId = bookBasketsId;
	}

	public Book_copyDto(int book_copyId, String book_copyTitle, int isbn, int bookShelfId,
			List<Integer> bookBasketsId) {
		this.book_copyId = book_copyId;
		this.book_copyTitle = book_copyTitle;
		Isbn = isbn;
		this.bookShelfId = bookShelfId;
		this.bookBasketsId = bookBasketsId;
	}
	
    
    
}
