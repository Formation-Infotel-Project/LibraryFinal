package com.formation.infotel.controller.servlet;

import com.formation.infotel.services.interfaces.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@WebServlet(urlPatterns = "/loginCheck")
public class LoginCheck extends HttpServlet{

    @Autowired
    MemberService memberService;

    public LoginCheck() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher disp = null;

        boolean success = memberService.checkLogin(request.getParameter("login"), request.getParameter("pass"));
        if(success){
            disp = request.getRequestDispatcher("/Library-Web");
        }else{
            disp = request.getRequestDispatcher("/Library-Web/loginFailed");
        }
        disp.forward(request, response);
    }
}
