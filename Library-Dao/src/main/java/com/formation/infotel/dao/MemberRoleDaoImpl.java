package com.formation.infotel.dao;

import com.formation.infotel.entity.MemberRole;
import com.formation.infotel.interfaces.MemberRoleDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class MemberRoleDaoImpl implements MemberRoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void insertMemberRole(MemberRole memberRole) {
        sessionFactory.getCurrentSession().save(memberRole);
    }

    @Override
    public MemberRole getMemberRoleById(int memberRoleId) {
        return null;
    }

    @Override
    public MemberRole getMemberRole(String memberRoleName) {
        return null;
    }

    @Override
    public List<MemberRole> getMemberRoles() {
        return null;
    }
}
