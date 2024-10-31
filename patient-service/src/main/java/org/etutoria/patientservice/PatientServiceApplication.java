package org.etutoria.patientservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.etutoria.patientservice.entities.Dossier;
import org.etutoria.patientservice.entities.Patient;
import org.etutoria.patientservice.entities.TypeFiche;
import org.etutoria.patientservice.repositories.DossierDao;
import org.etutoria.patientservice.repositories.PatientDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Clinic  Application REST API Documentation",
                description = "REST APIs for Clinic Application",
                version = "v1",
                contact = @Contact(
                        name = "Ousmane MBACKE Dev JAVA & Flutter",
                        email = "usmanembacke@gmail.com",
                        url = "https://www.alazharkeurmadaro.org"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.alazharkeurmadaro.org"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "AlAzhar App REST API Documentation",
                url = "https://www.alazharkeurmadaro.org"
        )
)
public class PatientServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(PatientDao patientDao, DossierDao dossierDao) {
        return args -> {
            // Create patients
            String[] patientFirstNames = {"John", "Jane", "Michael", "Emily", "David"};
            String[] patientLastNames = {"Smith", "Johnson", "Williams", "Brown", "Jones"};
            String[] patientAddresses = {"123 Elm St", "456 Oak St", "789 Pine St", "101 Maple St", "202 Birch St"};
            String[] patientGenres = {"Male", "Female", "Male", "Female", "Male"};

            for (int i = 0; i < 5; i++) {
                Patient patient = new Patient();
                patient.setFirstName(patientFirstNames[i]);
                patient.setLastName(patientLastNames[i]);
                patient.setDateNaissance("1990-01-01");
                patient.setAddress(patientAddresses[i]);
                patient.setGenre(patientGenres[i]);
                patientDao.save(patient);  // Save patient first to generate the ID
            }

            // Create dossiers and assign them to patients
            for (Patient patient : patientDao.findAll()) {
                Dossier dossier = new Dossier();
                dossier.setTypeFiche(TypeFiche.DOSSIER_MEDICALE);
                dossier.setPatient(patient);  // Associate patient with the dossier
                dossierDao.save(dossier);  // Save the dossier
                // Add dossier to the patient's dossier set
                patient.getDossiers().add(dossier);
                patientDao.save(patient);  // Save the patient again with the updated dossier set
            }
        };
    }
}
