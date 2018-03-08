package com.formation.infotel.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MemberRole {

    @Id
    @GeneratedValue
    private int memberRoleId;
    private String memberRoleName;

    @OneToMany(mappedBy = "memberRole")
    private List<Member> members = new ArrayList<>();
}
