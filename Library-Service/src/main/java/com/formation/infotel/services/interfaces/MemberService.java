package com.formation.infotel.services.interfaces;

import com.formation.infotel.entity.Member;

import java.util.List;

public interface MemberService {

    void insertMember(Member member);

    void deleteMember(Member member);

    void updateMember(Member member);

    Member getMember(int memberId);

    List<Member> getAllMembers();

    boolean userExist(String login, String password);

    Member getMemberByEmail(String email);
}
