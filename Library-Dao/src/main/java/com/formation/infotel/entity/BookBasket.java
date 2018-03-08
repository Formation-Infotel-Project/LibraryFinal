package com.formation.infotel.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Book_Basket")
public class BookBasket {

	@Id
	@GeneratedValue
	private int boookBasketId;
	private String bookName;
	private Date creationDate;
	private Date deliveryDate;

	@OneToOne
	@JoinColumn(name = "Member_id")
	private Member member;

	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "BASKET_COPY",
		joinColumns = @JoinColumn(name = "BASKET_ID"),
		inverseJoinColumns = @JoinColumn(name = "COPY_ID"))
	private List<Book_copy> book_copies = new ArrayList<>();

	public BookBasket(String bookName, Date creationDate, Date deliveryDate, Member member,
			List<Book_copy> book_copies) {
		this.bookName = bookName;
		this.creationDate = creationDate;
		this.deliveryDate = deliveryDate;
		this.member = member;
		this.book_copies = book_copies;
	}

	public BookBasket(String bookName, Date creationDate, Date deliveryDate) {
		this.bookName = bookName;
		this.creationDate = creationDate;
		this.deliveryDate = deliveryDate;
	}

	public BookBasket() {
	
	}

	public Member getMember() {
			return member;
		}
	public void setMember(Member member) {
		this.member = member;
	}
	public List<Book_copy> getBook_copies() {
		return book_copies;
	}
	public void setBook_copies(List<Book_copy> book_copies) {
		this.book_copies = book_copies;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public int getBoookBasketId() {
			return boookBasketId;
		}
}
