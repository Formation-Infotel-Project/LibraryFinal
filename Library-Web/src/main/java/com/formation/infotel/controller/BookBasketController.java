package com.formation.infotel.controller;

import com.formation.infotel.controller.dto.BookBasketDto;
import com.formation.infotel.entity.BookBasket;
import com.formation.infotel.entity.Book_copy;
import com.formation.infotel.services.interfaces.BookBasketService;
import com.formation.infotel.services.interfaces.BookCopyService;
import com.formation.infotel.services.interfaces.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class BookBasketController {

	@Autowired
	private BookBasketService bookBasketService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private BookCopyService bookCopyService;

	@PutMapping(value = "bookBasket/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addBookBasket(@RequestBody BookBasketDto bookBasketDto) {
		try {
			BookBasket bookBasket = new BookBasket();
			bookBasket.setCreationDate(bookBasketDto.getCreationDate());
			bookBasket.setDeliveryDate(bookBasketDto.getDeliveryDate());
			bookBasket.setMember(memberService.getMember(bookBasketDto.getMemberId()));
			Set<Book_copy> books = new HashSet<>();
			for (int i = 0; i < bookBasketDto.getBook_copiesId().size(); i++) {
				books.add(bookCopyService.getBookCopy(bookBasketDto.getBook_copiesId().get(i)));
			}
			bookBasket.setBook_copies(books);

			bookBasketService.insertBookBasket(bookBasket);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@PostMapping(value = "bookBasket/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateBookBasket(@RequestBody BookBasketDto bookBasketDto, @PathVariable(value = "id") int id) {
		try {
			BookBasket bookBasket = bookBasketService.getBookBasket(id);
			bookBasket.setCreationDate(bookBasketDto.getCreationDate());
			bookBasket.setDeliveryDate(bookBasketDto.getDeliveryDate());
			bookBasket.setMember(memberService.getMember(bookBasketDto.getMemberId()));
			Set<Book_copy> books = new HashSet<>();
			for (int i = 0; i < bookBasketDto.getBook_copiesId().size(); i++) {
				books.add(bookCopyService.getBookCopy(bookBasketDto.getBook_copiesId().get(i)));
			}
			bookBasket.setBook_copies(books);

			bookBasketService.updateBookBasket(bookBasket);
		} catch (

		Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@DeleteMapping(value = "bookBasket/delete/{id}")
	public void deleteBookBasket(@PathVariable(value = "id") int id) {
		try {
			BookBasket bookBasket = bookBasketService.getBookBasket(id);

			bookBasketService.deleteBookBasket(bookBasket);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("bookBasket/get/{id}")
	public BookBasketDto getBookBasket(@PathVariable(value = "id") int id) {

		BookBasketDto viewBookBasket = null;

		try {
			BookBasket bookBasket = bookBasketService.getBookBasket(id);
			List<Integer> booksId = new ArrayList<>();
			bookBasket.getBook_copies().forEach(b -> {
				booksId.add(b.getBook_copyId());
			});
			viewBookBasket = new BookBasketDto(bookBasket.getCreationDate(), bookBasket.getDeliveryDate(),
					bookBasket.getMember().getMemberId(), booksId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return viewBookBasket;
	}

	@RequestMapping("bookBasket/get")
	public List<BookBasketDto> getBookBaskets() {
		List<BookBasketDto> viewBookBaskets = new ArrayList<>();
		
		try {
		List<BookBasket> bookBaskets = bookBasketService.getAllBookBaskets();
		List<Integer> booksId = new ArrayList<>();
		bookBaskets.forEach(bb -> {
			bb.getBook_copies().forEach(b -> booksId.add(b.getBook_copyId()));
			viewBookBaskets.add(new BookBasketDto(bb.getCreationDate(), bb.getDeliveryDate(),
					bb.getMember().getMemberId(), booksId));
		});} catch (Exception e) {
			e.printStackTrace();
		}
		return viewBookBaskets;
	}
}
