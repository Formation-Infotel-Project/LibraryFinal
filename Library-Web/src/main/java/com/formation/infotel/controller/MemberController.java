package com.formation.infotel.controller;

import com.formation.infotel.controller.dto.MemberDto;
import com.formation.infotel.entity.Member;
import com.formation.infotel.services.interfaces.LibraryService;
import com.formation.infotel.services.interfaces.MemberService;
import com.formation.infotel.services.interfaces.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MemberController {

    @Autowired
    MemberService memberService;
    @Autowired
    LibraryService libraryService;
    @Autowired
    RegistrationService registrationService;

    @PutMapping(value = "/member/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addMember(@RequestBody MemberDto memberDto) {

        Member member = new Member(memberDto.getMemberLastName(), memberDto.getEmail(), memberDto.getPassword(), memberDto.getAddress(),
                memberDto.getCity(), memberDto.getPostalCode(), memberDto.getAccess(), memberDto.getPhone(), memberDto.getFirstName());

        memberService.insertMember(member);
    }

    @PostMapping(value = "member/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateMember(@RequestBody MemberDto memberDto, @PathVariable(value="id") int id){

        Member member = memberService.getMember(id);
        member.setMemberLastName(memberDto.getMemberLastName());
        member.setEmail(memberDto.getEmail());
        member.setPassword(memberDto.getPassword());
        member.setAddress(memberDto.getAddress());
        member.setCity(memberDto.getCity());
        member.setPostalCode(memberDto.getPostalCode());
        member.setAccess(memberDto.getAccess());
        member.setPhone(memberDto.getPhone());
        member.setFirstName(memberDto.getFirstName());

        memberService.updateMember(member);
    }

    @DeleteMapping("member/delete/{id}")
    public void deleteMember(@PathVariable(value = "id") int id){

        Member member = memberService.getMember(id);

        memberService.deleteMember(member);
    }

    @RequestMapping("member/get/{id}")
    public MemberDto getMember(@PathVariable(value = "id") int id){

        Member member = memberService.getMember(id);
        MemberDto viewMember = new MemberDto(member.getMemberLastName(), member.getFirstName(), member.getEmail(),
                member.getPassword(), member.getAddress(), member.getCity(), member.getPostalCode(), member.getPhone(), member.getAccess());
        return viewMember;
    }

    @RequestMapping("member/get")
    public List<MemberDto> getMembers(){

        List<MemberDto> viewMembers = new ArrayList<>();
        List<Member> members = memberService.getAllMembers();
        members.forEach(m -> viewMembers.add(new MemberDto(m.getMemberLastName(), m.getFirstName(), m.getEmail(),
                m.getPassword(), m.getAddress(), m.getCity(), m.getPostalCode(), m.getPhone(), m.getAccess())));
        return viewMembers;
    }
}