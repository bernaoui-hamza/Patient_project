package com.patient1.patient1.sec.service;

import com.patient1.patient1.sec.entities.AppRole;
import com.patient1.patient1.sec.entities.AppUser;

public interface SecurityService {
    AppUser saveNewUser(String username, String password, String rePassword);

    AppRole saveNewRole(String roleName, String description);

    void addRoleToUser(String username, String roleName);

    void removeRoleToUser(String username, String roleName);

    AppUser loadUserByUserName(String username);
}
