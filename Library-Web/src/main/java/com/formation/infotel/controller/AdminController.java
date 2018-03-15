package com.formation.infotel.controller;

import com.formation.infotel.entity.*;
import com.formation.infotel.services.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
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

    @RequestMapping("/administration")
    public String administration(){
        return "admin/administration";
    }

    @RequestMapping("/addUser")
    public String addMember(){
        return "admin/addMember";
    }

    @RequestMapping("/editMember")
    public String editMember(Model model, HttpServletRequest request) {

        Member member = memberService.getMember(Integer.parseInt(request.getParameter("id")));
        model.addAttribute("member", member);
        return "admin/editMember";
    }

    @RequestMapping("/addBook")
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
