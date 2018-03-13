package com.formation.infotel.services.impl;

import com.formation.infotel.entity.Member;
import com.formation.infotel.interfaces.MemberDao;
import com.formation.infotel.services.interfaces.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

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
    public List<Member> getAllMembers() {
        return memberDao.getAllMembers();
    }

    @Override
    public Member getMemberById(int memberId) {
        Member member = memberDao.getMemberById(memberId);
        return member;
    }

    @Override
    public Member getMemberByEmail(String email) {
        return memberDao.getMemberByEmail(email);
    }

    @Override
    public boolean userExist(String login, String password) {
        return memberDao.userExist(login, password);
    }
}
