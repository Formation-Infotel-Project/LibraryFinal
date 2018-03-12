package com.formation.infotel.interfaces;

import com.formation.infotel.entity.Member;
import java.util.List;

public interface MemberDao {

    void insertMember(Member member);

    void updateMember(Member member, int memberId);

    void deleteMember(Member member);

    /*boolean checkLogin(String login, String pass);*/

    Member getMemberById(int memberId);

    Member getMemberByEmail(String email);

    List<Member> getAllMembers();
}
