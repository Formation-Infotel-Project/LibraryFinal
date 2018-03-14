package com.formation.infotel.services.interfaces;

import com.formation.infotel.entity.Member;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface MemberService {

    void insertMember(Member member);

    void updateMember(Member member);

    void deleteMember(Member member);

    boolean userExist(String login, String password);

    Member getMemberByEmail(String email);

    Member getMemberById(int memberId);

    List<Member> getAllMembers();
}
