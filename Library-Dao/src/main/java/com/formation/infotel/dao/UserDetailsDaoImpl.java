package com.formation.infotel.dao;

import com.formation.infotel.entity.Member;
import com.formation.infotel.interfaces.UserDetailsDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDetailsDaoImpl implements UserDetailsDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Member findUserByUsername(String username) {
        return (Member) sessionFactory.getCurrentSession().createQuery(String.format("From Member as member WHERE member.email= :email")).setParameter("email", username);
    }
}
