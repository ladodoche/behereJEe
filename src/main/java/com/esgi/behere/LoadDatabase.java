package com.esgi.behere;

import com.esgi.behere.model.Beer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase() {
        return args -> {
            System.out.println("Start");
        };
    }
}