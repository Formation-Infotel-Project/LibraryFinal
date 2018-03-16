package com.formation.infotel.controller;

import com.formation.infotel.controller.dto.AuthorDto;
import com.formation.infotel.entity.Author;
import com.formation.infotel.entity.Book;
import com.formation.infotel.services.interfaces.AuthorService;
import com.formation.infotel.services.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    AuthorService authorService;
    @Autowired
    BookService bookService;

    @PutMapping(value = "author/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addAuthor(@RequestBody AuthorDto authorDto){

        Author author = new Author(authorDto.getAuthorLastName(), authorDto.getFirstName());
        List<Book> books = new ArrayList<>();
        for(int i=0;i<authorDto.getBooksId().size();i++){
            books.add(bookService.getBookById(authorDto.getBooksId().get(i)));
        }
        author.setBooks(books);

        authorService.insertAuthor(author);
    }

    @PostMapping(value = "author/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateAuthor(@RequestBody AuthorDto authorDto, @PathVariable(value="id") int id){

        Author author = authorService.getAuthor(id);
        author.setAuthorLastName(authorDto.getAuthorLastName());
        author.setFirstName(authorDto.getFirstName());
        List<Book> books = new ArrayList<>();
        for(int i=0;i<authorDto.getBooksId().size();i++){
            books.add(bookService.getBookById(authorDto.getBooksId().get(i)));
        }
        author.setBooks(books);

        authorService.updateAuthor(author);
    }

    @DeleteMapping(value = "author/delete/{id}")
    public void deleteAuthor(@PathVariable(value="id") int id){

        Author author = authorService.getAuthor(id);

        authorService.deleteAuthor(author);
    }

    @RequestMapping("author/get/{id}")
    public AuthorDto getAuthor(@PathVariable(value="id") int id){
        Author author = authorService.getAuthor(id);
        List<Integer> booksId = new ArrayList<>();
        author.getBooks().forEach(b -> {
            booksId.add(b.getIsbn());
        });
        AuthorDto viewAuthor = new AuthorDto(author.getAuthorLastName(), author.getFirstName(), booksId);
        return viewAuthor;
    }

    @RequestMapping("author/get")
    public List<AuthorDto> getAuthors(){
        List<AuthorDto> viewAuthors = new ArrayList<>();
        List<Author> authors = authorService.getAllAuthors();
        List<Integer> booksId = new ArrayList<>();
        authors.forEach(a -> {
            a.getBooks().forEach(b -> booksId.add(b.getIsbn()));
            viewAuthors.add(new AuthorDto(a.getAuthorLastName(), a.getFirstName(), booksId));
        });
        return viewAuthors;
    }
}
