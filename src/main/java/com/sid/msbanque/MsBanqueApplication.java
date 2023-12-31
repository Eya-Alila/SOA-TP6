package com.sid.msbanque;

import com.sid.msbanque.entities.Compte;
import com.sid.msbanque.entities.EtatCompte;
import com.sid.msbanque.entities.TypeCompte;
import com.sid.msbanque.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.Date;

@SpringBootApplication
public class MsBanqueApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsBanqueApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CompteRepository compteRepository){
        return args -> {
            compteRepository.save(new Compte(123,Math.random()*9000,new Date(), TypeCompte.EPARGNE, EtatCompte.ACTIVE));
            compteRepository.save(new Compte(123,Math.random()*9000,new Date(), TypeCompte.COURANT, EtatCompte.CREE));
            compteRepository.save(new Compte(123,Math.random()*9000,new Date(), TypeCompte.EPARGNE, EtatCompte.SUSPENDU));
            compteRepository.save(new Compte(123,Math.random()*9000,new Date(), TypeCompte.EPARGNE, EtatCompte.BLOQUE));
            compteRepository.findAll().forEach(c->{
                System.out.println(c.toString());
            });
        };
    }
}
