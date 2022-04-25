package com.patient1.patient1.sec.repositories;

import com.patient1.patient1.sec.entities.AppRole;
import com.patient1.patient1.sec.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository <AppRole,Long>{
    AppUser findByRolename (String roleName);
    

}
