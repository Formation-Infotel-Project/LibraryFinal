package com.formation.infotel.services.impl;

import com.formation.infotel.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDetailsDao userDetailsDao;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = userDetailsDao.findUserByUsername(username);
        User.UserBuilder builder = null;
        if(member != null){
            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.disabled(false);
            builder.password(member.getPassword());
            String[] memberRoles = member.getMemberRoles()
                    .stream().map(a -> a.getName()).toArray(String[]::new);
            builder.authorities(memberRoles);
        }else{
            throw new UsernameNotFoundException("User not found");
        }
        return builder.build();
    }
}
