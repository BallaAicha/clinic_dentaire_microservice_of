package org.etutoria.equipement;

import org.etutoria.equipement.entities.Machine;
import org.etutoria.equipement.entities.Produit;
import org.etutoria.equipement.entities.Salle;
import org.etutoria.equipement.repositories.MachineDao;
import org.etutoria.equipement.repositories.ProduitDao;
import org.etutoria.equipement.repositories.SalleDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EquipementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EquipementApplication.class, args);
    }
    @Bean
    CommandLineRunner initDatabase(SalleDao salleDao,
                                   ProduitDao produitDao,
                                   MachineDao machineDao) {
        return args -> {
            // Create salles
            String[] salleNames = {"Consultation Room 1", "Consultation Room 2", "Surgery Room", "X-Ray Room", "Waiting Room"};
            for (int i = 0; i < 5; i++) {
                Salle salle = new Salle();
                salle.setNom(salleNames[i]);
                salleDao.save(salle);
            }
            // Create produits
            String[] produitNames = {"Toothpaste", "Mouthwash", "Dental Floss", "Toothbrush", "Whitening Strips"};
            String[] produitDescriptions = {"Fluoride toothpaste", "Antiseptic mouthwash", "Waxed dental floss", "Soft-bristle toothbrush", "Teeth whitening strips"};

            for (int i = 0; i < 5; i++) {
                Produit produit = new Produit();
                produit.setNom(produitNames[i]);
                produit.setDescription(produitDescriptions[i]);
                produitDao.save(produit);
            }

            // Create machines
            String[] machineNames = {"X-Ray Machine", "Ultrasonic Scaler", "Dental Chair", "Autoclave", "Intraoral Camera"};
            String[] machineDescriptions = {"High resolution X-Ray machine", "Ultrasonic scaler for cleaning", "Comfortable dental chair", "Sterilization autoclave", "High definition intraoral camera"};

            for (int i = 0; i < 5; i++) {
                Machine machine = new Machine();
                machine.setNom(machineNames[i]);
                machine.setDescription(machineDescriptions[i]);
                machineDao.save(machine);
            }
        };
    }

}
