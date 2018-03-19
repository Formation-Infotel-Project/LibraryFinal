package com.formation.infotel.controller;

import com.formation.infotel.controller.dto.BookCopyDto;
import com.formation.infotel.entity.BookBasket;
import com.formation.infotel.entity.Book_copy;
import com.formation.infotel.services.interfaces.BookBasketService;
import com.formation.infotel.services.interfaces.BookCopyService;
import com.formation.infotel.services.interfaces.BookService;
import com.formation.infotel.services.interfaces.BookShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class BookCopyController {

	@Autowired
	private BookCopyService bookCopyService;
	@Autowired
	private BookService bookService;
	@Autowired
	private BookShelfService bookShelfService;
	@Autowired
	private BookBasketService bookBasketService;

	@PutMapping(value = "bookCopy/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addBookCopy(@RequestBody BookCopyDto bookCopyDto) {
		try {
			Book_copy bookCopy = new Book_copy();
			bookCopy.setBook_copyTitle(bookCopyDto.getBook_copyTitle());
			bookCopy.setBook(bookService.getBookById(bookCopyDto.getBookIsbn()));
			bookCopy.setBookShelf(bookShelfService.getBookShelf(bookCopyDto.getBookShelfId()));
			Set<BookBasket> basket = new HashSet<>();
			for (int i = 0; i < bookCopyDto.getBookBasketsId().size(); i++) { // parcours de la liste des ID de
																				// bookbasket
				basket.add(bookBasketService.getBookBasket(bookCopyDto.getBookBasketsId().get(i)));
			}
			bookCopy.setBookBaskets(basket);

			bookCopyService.insertBookCopy(bookCopy);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@PostMapping(value = "bookCopy/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateBookCopy(@RequestBody BookCopyDto bookCopyDto, @PathVariable(value = "id") int id) {

		try {

			Book_copy bookCopy = bookCopyService.getBookCopy(id);
			bookCopy.setBook_copyTitle(bookCopyDto.getBook_copyTitle());
			bookCopy.setBook(bookService.getBookById(bookCopyDto.getBookIsbn()));
			bookCopy.setBookShelf(bookShelfService.getBookShelf(bookCopyDto.getBookShelfId()));
			Set<BookBasket> basket = new HashSet<>();
			for (int i = 0; i < bookCopyDto.getBookBasketsId().size(); i++) { // parcours de la liste des ID de
																				// bookbasket
				basket.add(bookBasketService.getBookBasket(bookCopyDto.getBookBasketsId().get(i)));
			}
			bookCopy.setBookBaskets(basket);

			bookCopyService.updateBookCopy(bookCopy);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@DeleteMapping(value = "bookCopy/delete/{id}")
	public void deleteBookCopy(@PathVariable(value = "id") int id) {
		try {
			Book_copy bookCopy = bookCopyService.getBookCopy(id);

			bookCopyService.deleteBookCopy(bookCopy);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("bookCopy/get/{id}")
	public BookCopyDto getBookCopy(@PathVariable(value = "id") int id) {
		BookCopyDto viewBookCopy = null;
		try {
			Book_copy bookCopy = bookCopyService.getBookCopy(id);
			List<Integer> basketsId = new ArrayList<>();
			bookCopy.getBookBaskets().forEach(bb -> basketsId.add(bb.getBoookBasketId()));
			viewBookCopy = new BookCopyDto(bookCopy.getBook_copyTitle(), bookCopy.getBook().getIsbn(),
					bookCopy.getBookShelf().getBookShelfId(), basketsId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return viewBookCopy;
	}

	@RequestMapping("bookCopy/get")
	public List<BookCopyDto> getBookCopies() {
		List<BookCopyDto> viewBookCopies = new ArrayList<>();
		try {
			List<Book_copy> bookCopies = bookCopyService.getAll();
			List<Integer> basketsId = new ArrayList<>();
			bookCopies.forEach(bb -> {
				bb.getBookBaskets().forEach(b -> basketsId.add(b.getBoookBasketId()));
				viewBookCopies.add(new BookCopyDto(bb.getBook_copyTitle(), bb.getBook().getIsbn(),
						bb.getBookShelf().getBookShelfId(), basketsId));
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return viewBookCopies;
	}
}
