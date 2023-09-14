package com.example.rest_api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class  UserConfiguration {
    @Bean
    @Autowired
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT id,pw,active from accounts where id = ?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT id,role from roles where id = ?");
        return jdbcUserDetailsManager;
    }


//    @Bean
//    @Autowired
//    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource) {
//       return new JdbcUserDetailsManager(dataSource);
//    }


//    @Bean
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
//        UserDetails danh = User.withUsername("danh").password("{noop}123456").roles("ADMIN").build();
//        UserDetails cuong = User.withUsername("cuong").password("{noop}11304").roles("TEACHER").build();
//        return new InMemoryUserDetailsManager(danh,cuong);
//    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        HttpSecurity httpSecurity = http.authorizeHttpRequests(
                configurer -> configurer
                        .requestMatchers(HttpMethod.GET,"/api/students").hasAnyRole("TEACHER","ADMIN")
                        .requestMatchers(HttpMethod.GET,"/api/students/**").hasAnyRole("TEACHER","ADMIN")
                        .requestMatchers(HttpMethod.POST,"/api/students").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT,"/api/students/**").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"/api/students/**").hasAnyRole("ADMIN")
        );
        httpSecurity.httpBasic(Customizer.withDefaults());
        http.csrf(csrf->csrf.disable());
        return httpSecurity.build();
    }

}


