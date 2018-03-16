package com.formation.infotel.services.interfaces;

import com.formation.infotel.entity.BookBasket;

import java.util.List;

public interface BookBasketService {

    void insertBookBasket(BookBasket bookBasket);

    void deleteBookBasket(BookBasket bookBasket);

    void updateBookBasket(BookBasket bookBasket);

    BookBasket getBookBasket(int bookBasketId);

    List<BookBasket> getAllBookBaskets();
}
