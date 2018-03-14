package com.formation.infotel.interfaces;

import com.formation.infotel.entity.Member;
import java.util.List;

public interface MemberDao {

    void insertMember(Member member);

    void updateMember(Member member);

    void deleteMember(Member member);

    Member getMemberById(int memberId);

    boolean userExist(String login, String password);

    Member getMemberByEmail(String email);

    List<Member> getAllMembers();
}
