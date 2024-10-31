package org.etutoria.facture;

import org.etutoria.facture.entities.Facture;
import org.etutoria.facture.repositories.FactureDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class FactureApplication {

    public static void main(String[] args) {
        SpringApplication.run(FactureApplication.class, args);
    }
    @Bean
    CommandLineRunner initDatabase(
            FactureDao factureDao) {
        return args -> {
            // Create factures
            for (int i = 0; i < 5; i++) {
                Facture facture = new Facture();
                facture.setMontant(100.0 * (i + 1));
                facture.setDateEmission(LocalDateTime.now().plusDays(i));
                factureDao.save(facture);
            }
        };

    }
}
