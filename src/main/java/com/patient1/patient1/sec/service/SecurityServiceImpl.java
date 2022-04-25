package com.patient1.patient1.sec.service;

import com.patient1.patient1.sec.entities.AppRole;
import com.patient1.patient1.sec.entities.AppUser;
import com.patient1.patient1.sec.repositories.AppRoleRepository;
import com.patient1.patient1.sec.repositories.AppUserRepository;
import groovy.util.logging.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SecurityServiceImpl implements SecurityService {
   private AppUserRepository appUserRepository;
   private AppRoleRepository appRoleRepository;

    public SecurityServiceImpl(AppUserRepository appUserRepository, AppRoleRepository appRoleRepository) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
    }

    @Override
    public AppUser saveNewUser(String username, String password, String rePassword) {
        return null;
    }

    @Override
    public AppRole saveNewRole(String roleName, String description) {
        return null;
    }

    @Override
    public void addRoleToUser(String username, String roleName) {

    }

    @Override
    public AppUser loadUserByUserName(String username) {
        return null;
    }
}
