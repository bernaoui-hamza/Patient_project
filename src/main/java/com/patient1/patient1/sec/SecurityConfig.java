package com.patient1.patient1.sec;

import com.patient1.patient1.sec.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
   @Autowired
    private DataSource dataSource;
   @Autowired
   private UserDetailsServiceImpl userDetailsService;
   @Autowired
   private PasswordEncoder passwordEncoder;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

       /* PasswordEncoder passwordEncoder=passwordEncoder();
        String encodePWD=passwordEncoder.encode("1234");
        System.out.println(encodePWD);
        auth.inMemoryAuthentication()
                .withUser("user1").password(passwordEncoder.encode("2222")).roles("USER")
                .and().withUser("user2").password(encodePWD).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder.encode("3333")).roles("USER","ADMIN");

*/
       /*auth.jdbcAuthentication().dataSource(dataSource).
                usersByUsernameQuery("select username as principal,password as credentials,active from users where username=? ")
                .authoritiesByUsernameQuery("select username principal, role as role from user_role where username=? ")
                .rolePrefix("ROLE_")
                .passwordEncoder(passwordEncoder);
*/
       /* auth.userDetailsService(new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return null;
            }
        });*/
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
http.formLogin();
http.authorizeRequests().antMatchers("/").permitAll();
http.authorizeRequests().antMatchers("/admin/**").hasAuthority("ADMIN");

http.authorizeRequests().antMatchers("/user/**").permitAll();
http.authorizeRequests().antMatchers("/webjars/**").permitAll();
http.authorizeHttpRequests().anyRequest().authenticated();
http.exceptionHandling().accessDeniedPage("/403");
    }

}
