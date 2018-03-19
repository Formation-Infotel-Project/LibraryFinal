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
    public void insertMember(Member member)  throws Exception{
        dao.save(member);
    }

    @Override
    public void deleteMember(Member member)  throws Exception{
        dao.delete(member);
    }

    @Override
    public void updateMember(Member member)  throws Exception{
        dao.saveOrUpdate(member);
    }

    @Override
    public Member getMember(int memberId)  throws Exception{
        return dao.get(Member.class, memberId);
    }

    @Override
    public List<Member> getAllMembers()  throws Exception{
        return dao.getAll(Member.class);
    }

    @Override
    public Member getMemberByEmail(String email) throws Exception {
        return memberDao.getMemberByEmail(email);
    }

    @Override
    public boolean userExist(String login, String password)  throws Exception{
        return memberDao.userExist(login, password);
    }
}
