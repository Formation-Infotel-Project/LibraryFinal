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
	public 	Resultat addAuthor(@RequestBody AuthorDto authorDto) {
		Resultat resultat = new Resultat();

		try {
			Author author = new Author(authorDto.getAuthorLastName(), authorDto.getFirstName());
			List<Book> books = new ArrayList<>();
			for (int i = 0; i < authorDto.getBooksId().size(); i++) {
				books.add(bookService.getBookById(authorDto.getBooksId().get(i)));
			}
			author.setBooks(books);

			authorService.insertAuthor(author);
			resultat.setMessage(ControllerConstants.INSERT_SUCCESS);
			resultat.setSuccess(true);
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.INSERT_ERRORS);
			e.printStackTrace();
		}
		return resultat;

	}

	@PostMapping(value = "author/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Resultat updateAuthor(@RequestBody AuthorDto authorDto, @PathVariable(value = "id") int id) {
		Resultat resultat = new Resultat();

		try {
			Author author = authorService.getAuthor(id);
			author.setAuthorLastName(authorDto.getAuthorLastName());
			author.setFirstName(authorDto.getFirstName());
			List<Book> books = new ArrayList<>();
			for (int i = 0; i < authorDto.getBooksId().size(); i++) {
				books.add(bookService.getBookById(authorDto.getBooksId().get(i)));
			}
			author.setBooks(books);

			authorService.updateAuthor(author);
			resultat.setMessage(ControllerConstants.UPDATE_SUCCESS);
			resultat.setSuccess(true);
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.UPDATE_ERRORS);
			e.printStackTrace();
		}
		return resultat;

	}

	@DeleteMapping(value = "author/delete/{id}")
	public Resultat deleteAuthor(@PathVariable(value = "id") int id) {
		Resultat resultat = new Resultat();

		try {
			Author author = authorService.getAuthor(id);

			authorService.deleteAuthor(author);
			resultat.setMessage(ControllerConstants.DELETE_SUCCESS);
			resultat.setSuccess(true);
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.DELETE_ERRORS);
			e.printStackTrace();
		}
		
		return resultat;

	}

	@RequestMapping("author/get/{id}")
	public Resultat getAuthor(@PathVariable(value = "id") int id) {
		Resultat resultat = new Resultat();

		AuthorDto viewAuthor = null;
		try {
			Author author = authorService.getAuthor(id);
			List<Integer> booksId = new ArrayList<>();
			author.getBooks().forEach(b -> {
				booksId.add(b.getIsbn());
			});
			viewAuthor = new AuthorDto(author.getAuthorLastName(), author.getFirstName(), booksId);
			resultat.setMessage(ControllerConstants.RETRIVE_SUCCESS);
			resultat.setSuccess(true);
			resultat.setPayload(viewAuthor);
			
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.RETRIVE_ERRORS);
			e.printStackTrace();
		}
		return resultat;
	}

	@RequestMapping("author/get")
	public Resultat getAuthors() {
		Resultat resultat = new Resultat();

		List<AuthorDto> viewAuthors = new ArrayList<>();
		try {
			List<Author> authors = authorService.getAllAuthors();
			List<Integer> booksId = new ArrayList<>();
			authors.forEach(a -> {
				a.getBooks().forEach(b -> booksId.add(b.getIsbn()));
				viewAuthors.add(new AuthorDto(a.getAuthorLastName(), a.getFirstName(), booksId));
			});
			resultat.setMessage(ControllerConstants.RETRIVE_SUCCESS);
			resultat.setSuccess(true);
			resultat.setPayload(viewAuthors);
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.RETRIVE_ERRORS);
			e.printStackTrace();
		}
		return resultat;
	}
}
