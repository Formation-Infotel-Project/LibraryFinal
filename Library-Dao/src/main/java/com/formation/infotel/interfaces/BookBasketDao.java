package com.formation.infotel.interfaces;

import java.util.Date;
import java.util.List;

import com.formation.infotel.entity.BookBasket;

public interface BookBasketDao {

	void createbasket(BookBasket bookBasket);
	
	BookBasket getBasketById(int basketId);
	
	BookBasket getBasketDelivary(Date deliveryDate);
	
	List<BookBasket> getBook();
	
}
