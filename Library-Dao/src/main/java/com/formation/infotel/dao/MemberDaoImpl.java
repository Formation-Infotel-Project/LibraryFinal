package com.formation.infotel.dao;

import com.formation.infotel.entity.Member;
import com.formation.infotel.interfaces.MemberDao;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class MemberDaoImpl implements MemberDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void insertMember(Member member) {
        sessionFactory.getCurrentSession().save(member);
    }

    @Override
    public void updateMember(Member member, int memberId) {
        Query query = sessionFactory.getCurrentSession().createQuery(String.format("update Member set " +
                "name = :memberName," +
                "email = :memberEmail," +
                "password = :memberPassword," +
                "address = :memberAddress," +
                "city = :memberCity " +
                "postalCode = :memberPostalCode " +
                "phone = :memberPhone " +
                "where memberId = :memberId"));
        query.setParameter("memberId", memberId);
        query.setParameter("memberName", member.getMemberLastName());
        query.setParameter("memberEmail", member.getEmail());
        query.setParameter("memberPassword", member.getPassword());
        query.setParameter("memberAddress", member.getAddress());
        query.setParameter("memberCity", member.getCity());
        query.setParameter("memberPostalCode", member.getPostalCode());
        query.setParameter("memberPhone", member.getPhone());
        query.executeUpdate();
    }

    @Override
    public void deleteMember(Member member) {

    }

    @Override
    public Member getMemberById(int memberId) {
        return (Member) sessionFactory.getCurrentSession().get(Member.class, memberId);
    }

    @Override
    public List<Member> getAllMembers() {
        List<Member> members = sessionFactory.getCurrentSession().createQuery(String.format("FROM Member as member")).list();
        return members;
    }

    @Override
    public Member getMemberByEmail(String email) {
        Member member = new Member();
        List<Member> members = sessionFactory.getCurrentSession().createQuery(String.format("From Member as m Where m.email= :email")).setParameter("email", email).list();
        if(members.size() == 1){
            member = members.get(0);
        }
        return member;
    }

    @Override
    public boolean userExist(String login, String password){
        boolean success = false;
        List<Member> members = sessionFactory.getCurrentSession().createQuery(String.format("FROM Member WHERE email= :login AND password= :password "))
                .setParameter("login", login)
                .setParameter("password", password)
                .list();
        if(members.size() == 1){
            success = true;
        }
        return success;
    }
}