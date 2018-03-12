package com.formation.infotel.controller;

import com.formation.infotel.entity.*;
import com.formation.infotel.services.interfaces.LibraryService;
import com.formation.infotel.services.interfaces.MemberRoleService;
import com.formation.infotel.services.interfaces.MemberService;
import com.formation.infotel.services.interfaces.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

@Controller
@WebServlet(urlPatterns = "/Register")
public class RegisterController extends HttpServlet {

    MemberService memberService;
    LibraryService libraryService;
    MemberRoleService memberRoleService;
    RegistrationService registrationService;

    public RegisterController() {

    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        Member member = new Member();
        member.setMemberLastName(request.getParameter("name"));
        member.setFirstName(request.getParameter("firstName"));
        member.setEmail(request.getParameter("email"));
        member.setPassword(request.getParameter("password"));
        member.setAddress(request.getParameter("address"));
        member.setCity(request.getParameter("city"));
        member.setPostalCode(request.getParameter("postalCode"));
        member.setPhone(request.getParameter("phone"));
        member.setAccess(1);

        Library lib = libraryService.getLibraryById(1);

        Calendar currenttime = Calendar.getInstance();
        Date today = new Date((currenttime.getTime()).getTime());

        MemberRole role = new MemberRole("");
        switch (request.getParameter("role")){
            case "Admin":
                role = memberRoleService.getMemberRoleById(12);
                break;
            case "User":
                role = memberRoleService.getMemberRoleById(11);
                break;
        }

        member.setMemberRole(role);

        Registration reg = new Registration(member, lib, today);

        memberService.insertMember(member);
        registrationService.insertRegistration(reg);

        RequestDispatcher disp = request.getRequestDispatcher("/memberList");
        disp.forward(request, response);
    }

}