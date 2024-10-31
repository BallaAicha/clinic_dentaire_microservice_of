package org.etutoria.soinsservice;

import org.etutoria.soinsservice.entities.Soins;
import org.etutoria.soinsservice.repositories.SoinsDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SoinsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoinsServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner initDatabase(SoinsDao soinsDao) {
        return args -> {
            String[] soinsDescriptions = {"Teeth Cleaning", "Cavity Filling", "Root Canal", "Teeth Whitening", "Braces Adjustment"};
            String[] soinsCodes = {"CLN001", "CAV002", "RTC003", "WHI004", "BRA005"};

            for (int i = 0; i < 5; i++) {
                Soins soins = new Soins();
                soins.setDescription(soinsDescriptions[i]);
                soins.setCode(soinsCodes[i]);
                soinsDao.save(soins);
            }


    };

}}
