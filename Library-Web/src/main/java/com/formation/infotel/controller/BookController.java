package com.formation.infotel.controller;

import com.formation.infotel.controller.dto.BookDto;
import com.formation.infotel.entity.*;
import com.formation.infotel.services.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

	@Autowired
	BookService bookService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	EditorService editorService;
	@Autowired
	AuthorService authorService;

//	@RequestMapping("/books")
//	public Resultat list(Model model) {
//		try {
//			List<Book> books = bookService.getBooks();
//			model.addAttribute("books", books);
//		} catch (Exception e) {
//
//			e.printStackTrace();
//		}
//
//		return "bookList";
//	}

	@PostMapping(value = "/book/add")
	public Resultat bookAdd(@RequestBody BookDto bookDto) {
		
		Resultat resultat = new Resultat();
		try {
			Book book = new Book(bookDto.getTitle(), bookDto.getDescription(), bookDto.getPrice(),
					bookDto.getPubDate(), bookDto.getPopular()/*, bookDto.getImagePath()*/, null);

			book.setCategory(categoryService.getCategory(bookDto.getCategoryId()));
			book.setEditor(editorService.getEditor(bookDto.getEditorId()));
			List<Author> authors = new ArrayList<>();
System.out.println(bookDto.getEditorId());
			for (int i = 0; i < bookDto.getAuthorsId().size(); i++) {
				authors.add(authorService.getAuthor(bookDto.getAuthorsId().get(i)));
			}
			book.setAuthors(authors);

			bookService.insertBook(book);
			resultat.setMessage(ControllerConstants.INSERT_SUCCESS);
			resultat.setSuccess(true);
		} catch (Exception e) {

			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.INSERT_ERRORS);
			e.printStackTrace();
		}
	
		return resultat;
		
	
		

	}

	@PostMapping(value = "book/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Resultat updateBook(@RequestBody BookDto bookDto, @PathVariable(value = "id") int id) {
		
		Resultat resultat = new Resultat();
		try {
			Book book = bookService.getBookById(id);
			book.setBookTitle(bookDto.getTitle());
			book.setBookDescription(bookDto.getDescription());
			book.setBookPrice(bookDto.getPrice());
			book.setPublicationDate(bookDto.getPubDate());
			book.setPopularBook(bookDto.getPopular());
			book.setImagePath(bookDto.getImagePath());
			book.setEditor(editorService.getEditor(bookDto.getEditorId()));
			book.setCategory(categoryService.getCategory(bookDto.getCategoryId()));
			List<Author> authors = new ArrayList<>();
			for (int i = 0; i < bookDto.getAuthorsId().size(); i++) {
				authors.add(authorService.getAuthor(bookDto.getAuthorsId().get(i)));
			}
			book.setAuthors(authors);

			bookService.updateBook(book);
			resultat.setMessage(ControllerConstants.UPDATE_SUCCESS);
			resultat.setSuccess(true);
		} catch (Exception e) {

			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.UPDATE_ERRORS);
			e.printStackTrace();
		}
		
		return resultat;
	}

	@DeleteMapping(value = "book/delete/{id}")
	public Resultat deleteBook(@PathVariable(value = "id") int id) {
		
		Resultat resultat = new Resultat();
		try {
			Book book = bookService.getBookById(id);

			bookService.deleteBook(book);
			resultat.setMessage(ControllerConstants.DELETE_SUCCESS);
			resultat.setSuccess(true);
		} catch (Exception e) {

			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.DELETE_ERRORS);
			e.printStackTrace();
		}
		return resultat;
	}

	@RequestMapping("book/get/{id}")
	public Resultat getBook(@PathVariable(value = "id") int id) {
		Resultat resultat = new Resultat();
		BookDto viewBook = null;
		try {
			Book book = bookService.getBookById(id);
			List<Integer> authorsId = new ArrayList<>();
			book.getAuthors().forEach(a -> authorsId.add(a.getAuthorId()));
			viewBook = new BookDto(book.getBookTitle(), book.getBookDescription(), book.getBookPrice(), authorsId,
					book.getCategory().getCategoryId(), book.getEditor().getEditorId(), book.getPublicationDate(),
					book.isPopularBook(), book.getImagePath());
			
			resultat.setMessage(ControllerConstants.RETRIVE_SUCCESS);
			resultat.setSuccess(true);
			resultat.setPayload(viewBook);
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.RETRIVE_ERRORS);
			e.printStackTrace();
		}
		return  resultat;
	
	}

	@RequestMapping("book/get")
	public Resultat getBooks() {
		
		Resultat resultat = new Resultat();
		List<BookDto> viewBooks = new ArrayList<>();
		try {
			List<Book> books = bookService.getBooks();
			List<Integer> authorsId = new ArrayList<>();
			books.forEach(b -> {
				b.getAuthors().forEach(a -> authorsId.add(a.getAuthorId()));
				viewBooks.add(new BookDto(b.getBookTitle(), b.getBookDescription(), b.getBookPrice(), authorsId,
						b.getCategory().getCategoryId(), b.getEditor().getEditorId(), b.getPublicationDate(),
						b.isPopularBook(), b.getImagePath()));
			});
			resultat.setMessage(ControllerConstants.RETRIVE_SUCCESS);
			resultat.setSuccess(true);
			resultat.setPayload(viewBooks);
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.RETRIVE_ERRORS);
			e.printStackTrace();
		}
		return  resultat;
	}
}
