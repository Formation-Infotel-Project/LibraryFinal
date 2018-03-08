package com.formation.infotel.services.impl;

import com.formation.infotel.entity.Member;
import com.formation.infotel.interfaces.MemberDao;
import com.formation.infotel.services.interfaces.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberDao memberDao;

    @Override
    public void insertMember(Member member) {
        memberDao.insertMember(member);
    }

    @Override
    public void updateMember(Member member, int memberId) {
        memberDao.updateMember(member, memberId);
    }

    @Override
    public void deleteMember(Member member) {
        memberDao.deleteMember(member);
    }

    @Override
    public boolean checkLogin(String login, String pass) {
        return memberDao.checkLogin(login, pass);
    }

    @Override
    public Member getMemberById(int memberId) {
        return memberDao.getMemberById(memberId);
    }

    @Override
    public List<Member> getAllMembers() {
        return memberDao.getAllMembers();
    }
}
