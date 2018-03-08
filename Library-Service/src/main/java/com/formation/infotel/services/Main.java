package com.formation.infotel.services;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.formation.infotel.config.SpringConfig;
import com.formation.infotel.entity.Book;
import com.formation.infotel.services.interfaces.AuthorService;
import com.formation.infotel.services.interfaces.BookService;
import com.formation.infotel.services.interfaces.CategoryService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        
        AuthorService authorServ = (AuthorService) ctx.getBean("authorServiceImpl");
        CategoryService  catServ = (CategoryService) ctx.getBean("categoryServiceImpl");
        BookService  bookServ = (BookService) ctx.getBean("bookServiceImp");
        
        List<Book> bb = authorServ.getListBookByNameAuthor("Yoshihiro");
        System.out.println( bb.size());
        for (Iterator<Book> iterator = bb.iterator(); iterator.hasNext();) {
			Book boos = (Book) iterator.next();
			System.out.println( boos.getBookTitle());

		}
        
        System.out.println( catServ.getAllBookByCategory("trans"));
        
       // System.out.println(catServ.getCategoriesPeriodique("Action"));
        
       // bookServ.getBookByName("Nanatsu no taizai"); good
	}

}
