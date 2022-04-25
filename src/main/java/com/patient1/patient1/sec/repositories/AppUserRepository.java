package com.patient1.patient1.sec.repositories;

import com.patient1.patient1.sec.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository  extends JpaRepository <AppUser,String>{
    AppUser findByUsername (String username);


}
