package com.formation.infotel.services.impl;

import com.formation.infotel.entity.MemberRole;
import com.formation.infotel.interfaces.MemberRoleDao;
import com.formation.infotel.services.interfaces.MemberRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberRoleServiceImpl implements MemberRoleService {

    @Autowired
    MemberRoleDao memberRoleDao;

    @Override
    public MemberRole getMemberRoleById(int memberRoleId) {
        return memberRoleDao.getMemberRoleById(memberRoleId);
    }
}
