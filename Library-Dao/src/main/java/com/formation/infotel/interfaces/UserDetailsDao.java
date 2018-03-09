package com.formation.infotel.interfaces;

import com.formation.infotel.entity.Member;

public interface UserDetailsDao {
    Member findUserByUsername(String username);
}
