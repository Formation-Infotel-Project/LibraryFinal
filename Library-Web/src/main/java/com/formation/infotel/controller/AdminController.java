package com.formation.infotel.controller;

import com.formation.infotel.entity.Member;
import com.formation.infotel.services.interfaces.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AdminController extends HttpServlet{

    @Autowired
    MemberService memberService;

    @RequestMapping("/administration")
    public String administration(){
        return "admin/administration";
    }

    @RequestMapping("/addUser")
    public String addMember(){
        return "admin/addMember";
    }

    @RequestMapping("/editMember")
    public String editMember(Model model, HttpServletRequest request, HttpServletResponse response) {

        Member member = memberService.getMemberById(Integer.parseInt(request.getParameter("id")));
        model.addAttribute("member", member);
        return "admin/editMember";
    }
}
