package com.formation.infotel.services.interfaces;

import com.formation.infotel.entity.Book_copy;

import java.util.List;

public interface BookCopyService {

    void insertBookCopy(Book_copy bookCopy);

    void deleteBookCopy(Book_copy bookCopy);

    void updateBookCopy(Book_copy bookCopy);

    Book_copy getBookCopy(int bookCopyId);

    List<Book_copy> getAll();
}
