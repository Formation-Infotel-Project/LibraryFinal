package com.formation.infotel.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MemberRole {

    @Id
    @GeneratedValue
    private int roleId;

    @Column(name = "Name")
    private String name;

    @ManyToMany(mappedBy = "memberRoles")
    private List<Member> members = new ArrayList<>();

    public MemberRole(String name) {
        this.name = name;
    }

    public int getRoleId() {
        return roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMember() {
        return members;
    }

    public void setMember(List<Member> members) {
        this.members = members;
    }
}
