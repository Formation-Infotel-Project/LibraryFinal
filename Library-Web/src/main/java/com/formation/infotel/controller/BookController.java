package com.formation.infotel.controller;

import com.formation.infotel.entity.Book;
import com.formation.infotel.services.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping("/books")
    public String list(Model model){

        List<Book> books = bookService.getBooks();

        model.addAttribute("books", books);

        return "bookList";
    }
}
