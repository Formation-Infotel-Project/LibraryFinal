package com.formation.infotel.services.impl;

import com.formation.infotel.entity.Member;
import com.formation.infotel.interfaces.Dao;
import com.formation.infotel.interfaces.MemberDao;
import com.formation.infotel.services.interfaces.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;
    @Autowired
    private Dao dao;

    @Override
    public void insertMember(Member member) {
        dao.save(member);
    }

    @Override
    public void deleteMember(Member member) {
        dao.delete(member);
    }

    @Override
    public void updateMember(Member member) {
        dao.saveOrUpdate(member);
    }

    @Override
    public Member getMember(int memberId) {
        return dao.get(Member.class, memberId);
    }

    @Override
    public List<Member> getAllMembers() {
        return dao.getAll(Member.class);
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
