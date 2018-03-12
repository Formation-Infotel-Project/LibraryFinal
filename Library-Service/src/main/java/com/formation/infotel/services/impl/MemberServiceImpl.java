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
public class MemberServiceImpl implements MemberService, UserDetailsService{

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

    @Transactional(readOnly=true)
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberDao.getMemberByEmail(email);
        User.UserBuilder builder = null;
        if(member != null) {
            builder = User.withUsername(email);
            builder.disabled(false);
            builder.password(member.getPassword());
            String[] authorities = member.getMemberRoles().stream().map(a -> a.getName()).toArray(String[]::new);

            builder.authorities(authorities);
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
        return builder.build();
    }
}
