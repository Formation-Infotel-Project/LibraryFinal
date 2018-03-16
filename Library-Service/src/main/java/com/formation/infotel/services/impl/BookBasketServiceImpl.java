package com.formation.infotel.services.impl;

import com.formation.infotel.entity.BookBasket;
import com.formation.infotel.interfaces.Dao;
import com.formation.infotel.services.interfaces.BookBasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookBasketServiceImpl implements BookBasketService {

    @Autowired
    private Dao dao;

    @Override
    public void insertBookBasket(BookBasket bookBasket) {
        dao.save(bookBasket);
    }

    @Override
    public void deleteBookBasket(BookBasket bookBasket) {
        dao.delete(bookBasket);
    }

    @Override
    public void updateBookBasket(BookBasket bookBasket) {
        dao.saveOrUpdate(bookBasket);
    }

    @Override
    public BookBasket getBookBasket(int bookBasketId) {
        return dao.get(BookBasket.class, bookBasketId);
    }

    @Override
    public List<BookBasket> getAllBookBaskets() {
        return dao.getAll(BookBasket.class);
    }
}
