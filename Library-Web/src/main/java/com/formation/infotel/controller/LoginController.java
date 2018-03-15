package com.formation.infotel.controller;

import com.formation.infotel.services.interfaces.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class LoginController extends HttpServlet {

    @Autowired
    MemberService memberService;

    @RequestMapping("/loginCheck")
    public String login(HttpServletRequest request){

        String pageToReturn = "";
        String login = request.getParameter("login");
        String password = request.getParameter("pass");
        boolean success = memberService.userExist(login, password);

        if(success){
            HttpSession session = request.getSession();
            int access = memberService.getMemberByEmail(login).getAccess();
            switch (access){
                case 1:
                    session.setAttribute("access", "admin");
                    break;
                case 2:
                    session.setAttribute("access", "user");
                    break;
            }
            session.setAttribute("name", login);
            pageToReturn = "index";
        }else{
            pageToReturn = "loginPages/login";
        }

        return pageToReturn;
    }
}
