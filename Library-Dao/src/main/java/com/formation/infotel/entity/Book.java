package com.formation.infotel.entity;

import java.sql.Date;
import java.util.ArrayList;

import java.util.List;
import javax.persistence.*;


@Entity
public class Book {
	
	@Id
	@GeneratedValue
	private int Isbn;
	private String bookTitle;
	private String bookDescription;
	private float bookPrice;
	private Date publicationDate;
	private boolean popularBook;
	private String imagePath;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "BOOK_CATEG",
		joinColumns = @JoinColumn(name = "BOOK_ID"),
		inverseJoinColumns = @JoinColumn(name = "CATEG_ID"))
	private List<Category> categories = new ArrayList<>();

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name = "BOOK_AUTH",
			joinColumns = @JoinColumn(name = "BOOK_ID"),
			inverseJoinColumns = @JoinColumn(name = "AUTH_ID"))
	private List<Author> authors = new ArrayList<>();

	@ManyToOne
	private Editor editor;

	@ManyToOne
	private Catalog catalog;

	@OneToMany(mappedBy = "book")
	private List<Book_copy> book_copies;

	public Book() {

	}
	
	public Book(String bookTitle, String bookDescription, float bookPrice, Date publicationDate, boolean popularBook,
			String imagePath) {
		this.bookTitle = bookTitle;
		this.bookDescription = bookDescription;
		this.bookPrice = bookPrice;
		this.publicationDate = publicationDate;
		this.popularBook = popularBook;
		this.imagePath = imagePath;
	}

	public int getIsbn() {
		return Isbn;
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

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public Editor getEditor() {
		return editor;
	}

	public void setEditor(Editor editor) {
		this.editor = editor;
	}

	public Catalog getCatalog() {
		return catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	public List<Book_copy> getBook_copies() {
		return book_copies;
	}

	public void setBook_copies(List<Book_copy> book_copies) {
		this.book_copies = book_copies;
	}
}
