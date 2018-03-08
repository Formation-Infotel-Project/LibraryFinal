package com.formation.infotel.services.interfaces;

import com.formation.infotel.entity.Member;

import java.util.List;

public interface MemberService {

    void insertMember(Member member);

    void updateMember(Member member, int memberId);

    void deleteMember(Member member);

    boolean checkLogin(String login, String pass);

    Member getMemberById(int memberId);

    List<Member> getAllMembers();
}
