package com.example.schoolmanagerrest.app;

import com.example.schoolmanagerrest.app.repositories.SchoolUserRepository;
//import com.example.schoolmanagerrest.app.security.tut.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
@ComponentScan(value = { "com.example.schoolmanagerrest"})
@EntityScan(basePackages = "com.example.schoolmanagerrest.app.model.entity" )
@EnableJpaRepositories(value = "com.example.schoolmanagerrest.app.repositories")
public class SchoolManagerRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolManagerRestApplication.class, args);
    }

}

