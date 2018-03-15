package com.formation.infotel.controller;

import com.formation.infotel.entity.*;
import com.formation.infotel.services.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Calendar;
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
    @Autowired
    CatalogService catalogService;

    @RequestMapping("/books")
    public String list(Model model){

        List<Book> books = bookService.getBooks();
        model.addAttribute("books", books);

        return "bookList";
    }

    @RequestMapping("/bookAdd")
    public void bookAdd(HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException, ServletException, NullPointerException {

        Book book = new Book();
        book.setBookTitle(request.getParameter("bookTitle"));
        book.setBookDescription(request.getParameter("description"));
        /*book.setBookPrice(Float.parseFloat(request.getParameter("price")));*/
        book.setBookPrice(7);

        /*SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date parsed = format.parse(request.getParameter("pubDate"));
        java.sql.Date sqlDate = new java.sql.Date(parsed.getTime());*/
        Calendar currenttime = Calendar.getInstance();
        java.sql.Date today = new java.sql.Date((currenttime.getTime()).getTime());
        book.setPublicationDate(today);

        switch(request.getParameter("popular")){
            case "Oui":
                book.setPopularBook(true);
                break;
            case "Non":
                book.setPopularBook(false);
                break;
        }

        Category category = categoryService.getCategoryByName(request.getParameter("category"));
        Editor editor = editorService.getEditorByName(request.getParameter("editor"));
        Author author = authorService.getAuthorByName(request.getParameter("author"));
        Catalog catalog = catalogService.getCatalogByName(request.getParameter("catalog"));

        Part filePart = request.getPart(request.getParameter("imagePath")); // Retrieves <input type="file" name="file">
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        InputStream input = filePart.getInputStream();

        File uploads = new File("src/main/webapp/resources/images");
        File file = new File(uploads, fileName);
        Files.copy(input, file.toPath());

        bookService.insertBook(book);

        response.sendRedirect("bookList");
    }
}
