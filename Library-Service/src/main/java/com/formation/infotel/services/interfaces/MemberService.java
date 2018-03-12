package com.formation.infotel.services.interfaces;

import com.formation.infotel.entity.Member;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface MemberService {

    void insertMember(Member member);

    void updateMember(Member member, int memberId);

    void deleteMember(Member member);

    UserDetails loadUserByUsername(String email);

    Member getMemberById(int memberId);

    List<Member> getAllMembers();
}
