package com.formation.infotel.dto;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.formation.infotel.entity.Author;
import com.formation.infotel.interfaces.BookDao;



public class BookDto {

	
	@Autowired
	BookDao bookDao;
	
	public BookDto() {}
	
	public BookDto(BookDao bookDao, String bookTitle, String bookDescription, float bookPrice, Date publicationDate,
			int categoryId, int catalogId, long editorId, List<Author> authorId, boolean popularBook,
			String imagePath) {
		this.bookDao = bookDao;
		this.bookTitle = bookTitle;
		this.bookDescription = bookDescription;
		this.bookPrice = bookPrice;
		this.publicationDate = publicationDate;
		this.categoryId = categoryId;
		this.catalogId = catalogId;
		this.editorId = editorId;
		this.authorId = authorId;
		this.popularBook = popularBook;
		this.imagePath = imagePath;
	}

	private int Isbn;
	private String bookTitle;
	private String bookDescription;
	private float bookPrice;
	private Date publicationDate;
	
	private int categoryId;
	
	 private int catalogId;
	 
	 private long editorId;
	 
		private  List<Author> authorId;
	 
	 public int getCategoryId() {
		return categoryId;
	}



	public long getEditorId() {
		return editorId;
	}

	public void setEditorId(long editorId) {
		this.editorId = editorId;
	}

	public List<Author> getAuthorId() {
		return authorId;
	}



	
	public String getBookTitle() {
		return bookTitle;
	}


	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}


	public String getBookDescription() {
		return bookDescription;
	}


	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}


	public float getBookPrice() {
		return bookPrice;
	}


	public void setBookPrice(float bookPrice) {
		this.bookPrice = bookPrice;
	}


	public Date getPublicationDate() {
		return publicationDate;
	}


	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}


	public boolean isPopularBook() {
		return popularBook;
	}


	public void setPopularBook(boolean popularBook) {
		this.popularBook = popularBook;
	}


	public String getImagePath() {
		return imagePath;
	}


	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}


	public void setIsbn(int isbn) {
		Isbn = isbn;
	}


	private boolean popularBook;
	private String imagePath;
	
	
	
	public BookDto(String bookTitle,String imagePath) {
		this.bookTitle = bookTitle;
		this.imagePath = imagePath;
	}
	
}
