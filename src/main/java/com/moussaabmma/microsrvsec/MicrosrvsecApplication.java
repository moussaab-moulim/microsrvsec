package com.moussaabmma.microsrvsec;

import com.moussaabmma.microsrvsec.entities.AppRole;
import com.moussaabmma.microsrvsec.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.stream.Stream;

@SpringBootApplication
public class MicrosrvsecApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicrosrvsecApplication.class, args);

    }
    @Bean
    CommandLineRunner start(AccountService accountService){
        return  args -> {
            accountService.save(new AppRole(null,"USER"));
            accountService.save(new AppRole(null,"ADMIN"));
            Stream.of("user1","user2","user3","admin").forEach(un->{
                accountService.saveUser(un,"1234","1234");

            });
            accountService.addRoleToUser("admin","ADMIN");
        };
    }
    @Bean
    BCryptPasswordEncoder getBCPE(){
        return new BCryptPasswordEncoder();
    }

}
