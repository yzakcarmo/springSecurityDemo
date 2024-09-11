package com.yzakcarmo.springsecuritydemo;

import com.yzakcarmo.springsecuritydemo.entities.User;
import com.yzakcarmo.springsecuritydemo.entities.enums.UserRole;
import com.yzakcarmo.springsecuritydemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DatabaseData implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args){

        User u1 = new User(null, "Teste", "teste@teste.com", 1122222222, "123", UserRole.DEFAULT);
        User u2 = new User(null,"Teste ADM", "testeadm@teste.com", 1122222222, "123", UserRole.ADMIN);
        userRepository.saveAll(Arrays.asList(u1,u2));
    }
}
