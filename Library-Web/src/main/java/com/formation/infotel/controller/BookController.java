package com.formation.infotel.controller;

import com.formation.infotel.controller.dto.BookDto;
import com.formation.infotel.entity.*;
import com.formation.infotel.services.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController extends HttpServlet {

    @Autowired
    BookService bookService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    EditorService editorService;
    @Autowired
    AuthorService authorService;

    @RequestMapping("/books")
    public String list(Model model){

        List<Book> books = bookService.getBooks();
        model.addAttribute("books", books);

        return "bookList";
    }

    @PostMapping(value = "/book/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void bookAdd(@RequestBody BookDto bookDto) {

        Book book = new Book(bookDto.getBookTitle(), bookDto.getDescription(), bookDto.getPrice(), bookDto.getPubDate(), bookDto.isPopular(), bookDto.getImagePath());

        book.setCategory(categoryService.getCategory(bookDto.getCategoryId()));
        book.setEditor(editorService.getEditor(bookDto.getEditorId()));
        List<Author> authors = new ArrayList<>();
        for(int i=0;i<bookDto.getAuthorsId().size();i++){
            authors.add(authorService.getAuthor(i));
        }
        book.setAuthors(authors);

        bookService.insertBook(book);
    }

    /*@PostMapping(value = "/book/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void bookUpdate(@RequestBody BookDto bookDto) {



        bookService.updateBook(book);
    }*/

    @RequestMapping("book/get")
    public List<BookDto> getBooks(){
        List<BookDto> viewBooks = new ArrayList<>();
        List<Book> books = bookService.getBooks();
        List<Integer> authorsId = new ArrayList<>();
        books.forEach(b -> {
            b.getAuthors().forEach(a -> authorsId.add(a.getAuthorId()));
            viewBooks.add(new BookDto(b.getBookTitle(), b.getBookDescription(), b.getBookPrice(), authorsId, b.getCategory().getCategoryId(),
                    b.getEditor().getEditorId(), b.getPublicationDate(), b.isPopularBook(), b.getImagePath()));
        });
        return viewBooks;
    }
}
