package com.formation.infotel.dto;

import java.util.Date;
import java.util.List;

import com.formation.infotel.entity.Book_copy;

public class BookBasketDto {
	
	private int boookBasketId;
	private String bookName;
	private Date creationDate;
	private Date deliveryDate;
	
	private int memberId;
	
	List<Book_copy> book_copiesId;

	public int getBoookBasketId() {
		return boookBasketId;
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

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public List<Book_copy> getBook_copiesId() {
		return book_copiesId;
	}

	public void setBook_copiesId(List<Book_copy> book_copiesId) {
		this.book_copiesId = book_copiesId;
	}

	public BookBasketDto(int boookBasketId, String bookName, Date creationDate, Date deliveryDate, int memberId,
			List<Book_copy> book_copiesId) {
		this.boookBasketId = boookBasketId;
		this.bookName = bookName;
		this.creationDate = creationDate;
		this.deliveryDate = deliveryDate;
		this.memberId = memberId;
		this.book_copiesId = book_copiesId;
	}

	
	
	

}
