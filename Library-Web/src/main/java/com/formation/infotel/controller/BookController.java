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

	@RequestMapping("/books")
	public String list(Model model) {
		try {
			List<Book> books = bookService.getBooks();
			model.addAttribute("books", books);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return "bookList";
	}

	@PutMapping(value = "/book/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void bookAdd(@RequestBody BookDto bookDto) {
		try {
			Book book = new Book(bookDto.getBookTitle(), bookDto.getDescription(), bookDto.getPrice(),
					bookDto.getPubDate(), bookDto.isPopular(), bookDto.getImagePath());

			book.setCategory(categoryService.getCategory(bookDto.getCategoryId()));
			book.setEditor(editorService.getEditor(bookDto.getEditorId()));
			List<Author> authors = new ArrayList<>();
			for (int i = 0; i < bookDto.getAuthorsId().size(); i++) {
				authors.add(authorService.getAuthor(bookDto.getAuthorsId().get(i)));
			}
			book.setAuthors(authors);

			bookService.insertBook(book);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@PostMapping(value = "book/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateBook(@RequestBody BookDto bookDto, @PathVariable(value = "id") int id) {
		try {
			Book book = bookService.getBookById(id);
			book.setBookTitle(bookDto.getBookTitle());
			book.setBookDescription(bookDto.getDescription());
			book.setBookPrice(bookDto.getPrice());
			book.setPublicationDate(bookDto.getPubDate());
			book.setPopularBook(bookDto.isPopular());
			book.setImagePath(bookDto.getImagePath());
			book.setEditor(editorService.getEditor(bookDto.getEditorId()));
			book.setCategory(categoryService.getCategory(bookDto.getCategoryId()));
			List<Author> authors = new ArrayList<>();
			for (int i = 0; i < bookDto.getAuthorsId().size(); i++) {
				authors.add(authorService.getAuthor(bookDto.getAuthorsId().get(i)));
			}
			book.setAuthors(authors);

			bookService.updateBook(book);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@DeleteMapping(value = "book/delete/{id}")
	public void deleteBook(@PathVariable(value = "id") int id) {
		try {
			Book book = bookService.getBookById(id);

			bookService.deleteBook(book);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@RequestMapping("book/get/{id}")
	public BookDto getBook(@PathVariable(value = "id") int id) {

		BookDto viewBook = null;
		try {
			Book book = bookService.getBookById(id);
			List<Integer> authorsId = new ArrayList<>();
			book.getAuthors().forEach(a -> authorsId.add(a.getAuthorId()));
			viewBook = new BookDto(book.getBookTitle(), book.getBookDescription(), book.getBookPrice(), authorsId,
					book.getCategory().getCategoryId(), book.getEditor().getEditorId(), book.getPublicationDate(),
					book.isPopularBook(), book.getImagePath());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return viewBook;
	}

	@RequestMapping("book/get")
	public List<BookDto> getBooks() {
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return viewBooks;
	}
}
