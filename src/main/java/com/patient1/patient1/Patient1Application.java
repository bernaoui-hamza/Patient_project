package com.patient1.patient1;

import com.patient1.patient1.entities.Medecin;
import com.patient1.patient1.entities.Patient;
import com.patient1.patient1.repositories.MedicinRepository;
import com.patient1.patient1.repositories.PatientRepository;
import com.patient1.patient1.sec.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class Patient1Application {

    public static void main(String[] args) {

        SpringApplication.run(Patient1Application.class, args);
    }

//@Bean
    CommandLineRunner commandeMedecin(MedicinRepository medecinRepository) {
        return args -> {
           medecinRepository.save(
                    new Medecin(null, "Benjloun",new Date(),"orthophoniste","casablanca"));
            medecinRepository.save(
                    new Medecin(null, "hassan",new Date(),"pediatre","sale"));
            medecinRepository.save(
                    new Medecin(null, "Bernaoui",new Date(),"cardiologue","casablanca"));
            medecinRepository.save(
                    new Medecin(null, "bekkali",new Date(),"auphtalmologue","Rabat"));
            medecinRepository.findAll().forEach(m -> {
                System.out.println(m.getNomMedecin());
            });
        };
    }

    //@Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository) {
        return args -> {
            patientRepository.save(
                    new Patient(null, "hassan", new Date(), false, 111));
            patientRepository.save(
                    new Patient(null, "ali", new Date(), true, 654));
            patientRepository.save(
                    new Patient(null, "hamza", new Date(), false, 109));
            patientRepository.save(
                    new Patient(null, "yassine", new Date(), true, 999));
            patientRepository.save(
                    new Patient(null, "abdo", new Date(), false, 107));
            patientRepository.findAll().forEach(p -> {
                System.out.println(p.getNom());
            });
        };
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    //@Bean
    CommandLineRunner saveUsers(SecurityService securityService) {

        return args -> {

            securityService.saveNewUser("hamza", "1234", "1234");
            securityService.saveNewUser("yassmine", "1234", "1234");
            securityService.saveNewUser("hassan", "1234", "1234");

            securityService.saveNewRole("USER", "");
            securityService.saveNewRole("ADMIN", "");
            securityService.addRoleToUser("hamza", "ADMIN");
            securityService.addRoleToUser("yassmine", "USER");
            securityService.addRoleToUser("hassan", "USER");

        };
    }

}
