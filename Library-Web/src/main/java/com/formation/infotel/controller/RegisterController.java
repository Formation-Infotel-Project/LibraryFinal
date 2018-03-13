package com.formation.infotel.controller;

import com.formation.infotel.entity.*;
import com.formation.infotel.services.interfaces.LibraryService;
import com.formation.infotel.services.interfaces.MemberService;
import com.formation.infotel.services.interfaces.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

@Controller
public class RegisterController extends HttpServlet {

    @Autowired
    MemberService memberService;

    @Autowired
    LibraryService libraryService;

    @Autowired
    RegistrationService registrationService;

    @RequestMapping("/register")
    public String register(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Member member = new Member();
        member.setMemberLastName(request.getParameter("name"));
        member.setFirstName(request.getParameter("firstName"));
        member.setEmail(request.getParameter("email"));
        member.setPassword(request.getParameter("password"));
        member.setAddress(request.getParameter("address"));
        member.setCity(request.getParameter("city"));
        member.setPostalCode(request.getParameter("postalCode"));
        member.setPhone(request.getParameter("phone"));
        switch (request.getParameter("role")){
            case "Admin":
                member.setAccess(1);
                break;
            case "User":
                member.setAccess(2);
                break;
        }

        List<Library> libs = libraryService.getAllLibraries(); // Récupération de toutes les librairies

        int size = libs.size(); // Définition du nombre de librairie.
        Random r = new Random(); // Nouveau random
        int rand = r.nextInt(size); // Random entre 0 et nombre de librairie.
        Library lib = libs.get(rand); // Choix d'une librairie aléatoire.

        Calendar currenttime = Calendar.getInstance();
        Date today = new Date((currenttime.getTime()).getTime());

        Registration reg = new Registration(member, lib, today);

        memberService.insertMember(member);
        registrationService.insertRegistration(reg);

        response.sendRedirect("memberList");
        return "memberList";
    }
}