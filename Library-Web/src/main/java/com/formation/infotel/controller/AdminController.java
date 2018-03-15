package com.formation.infotel.controller;

import com.formation.infotel.entity.*;
import com.formation.infotel.services.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class AdminController extends HttpServlet{

    @Autowired
    MemberService memberService;
    @Autowired
    EditorService editorService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    CatalogService catalogService;
    @Autowired
    AuthorService authorService;

    @RequestMapping(value = "/administration")
    public String administration(){
        return "admin/administration";
    }

    @RequestMapping(value = "/addUser")
    public String addMember(){
        return "admin/addMember";
    }

    @RequestMapping(value = "/editMember", produces = "application/json")
    public String editMember(Model model, HttpServletRequest request) {

        Member member = memberService.getMember(Integer.parseInt(request.getParameter("id")));
        model.addAttribute("member", member);
        return "admin/editMember";
    }

    @RequestMapping(value = "/addBook", produces = "application/json")
    public String addBook(Model model, HttpServletRequest request){

        List<Editor> editors = editorService.getAllEditors();
        model.addAttribute("editors", editors);

        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);

        List<Catalog> catalogs = catalogService.getAllCatalogs();
        model.addAttribute("catalogs", catalogs);

        List<Author> authors = authorService.getAllAuthors();
        model.addAttribute("authors", authors);

        return "admin/addBook";
    }
}
