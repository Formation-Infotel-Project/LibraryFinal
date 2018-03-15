package com.formation.infotel.controller;

import com.formation.infotel.entity.Library;
import com.formation.infotel.entity.Member;
import com.formation.infotel.entity.Registration;
import com.formation.infotel.services.interfaces.LibraryService;
import com.formation.infotel.services.interfaces.MemberService;
import com.formation.infotel.services.interfaces.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

@RestController
public class MemberController extends HttpServlet{

    @Autowired
    MemberService memberService;

    @Autowired
    LibraryService libraryService;

    @Autowired
    RegistrationService registrationService;

    @RequestMapping("/memberList")
    public String list(Model model){

        List<Member> members = memberService.getAllMembers();

        model.addAttribute("members", members);

        return "admin/memberList";
    }

    @RequestMapping("/deleteMember")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Member member = memberService.getMember(id);
        memberService.deleteMember(member);

        response.sendRedirect("memberList");
    }

    @RequestMapping("/register")
    public void register(HttpServletRequest request, HttpServletResponse response) throws IOException {

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

        List<Library> libs = libraryService.getAllLibraries();

        int size = libs.size();
        Random r = new Random();
        int rand = r.nextInt(size);
        Library lib = libs.get(rand);

        Calendar currenttime = Calendar.getInstance();
        Date today = new Date((currenttime.getTime()).getTime());

        Registration reg = new Registration(member, lib, today);

        memberService.insertMember(member);
        registrationService.insertRegistration(reg);

        response.sendRedirect("memberList");
    }

    @RequestMapping("/memberEdit")
    public void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Member member = memberService.getMember(Integer.parseInt(request.getParameter("id")));
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

        Registration reg = member.getRegistration();

        memberService.updateMember(member);
        registrationService.updateRegistration(reg);

        response.sendRedirect("memberList");
    }
}