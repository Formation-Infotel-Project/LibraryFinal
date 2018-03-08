package com.formation.infotel.interfaces;

import com.formation.infotel.entity.MemberRole;

import java.util.List;

public interface MemberRoleDao {

    void insertMemberRole(MemberRole memberRole);

    MemberRole getMemberRoleById(int memberRoleId);

    MemberRole getMemberRole(String memberRoleName);

    List<MemberRole> getMemberRoles();
}
