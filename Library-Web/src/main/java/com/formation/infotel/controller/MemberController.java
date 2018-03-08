package com.formation.infotel.controller;

import com.formation.infotel.entity.Member;
import com.formation.infotel.services.interfaces.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MemberController {

    @Autowired
    MemberService memberService;

    @RequestMapping("/memberList")
    public String list(Model model){

        List<Member> members = memberService.getAllMembers();

        model.addAttribute("members", members);

        return "memberList";
    }
}