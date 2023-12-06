package com.sid.msbanque.web;

import com.sid.msbanque.entities.Compte;
import java.util.List;
import com.sid.msbanque.repositories.CompteRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/banque")
public class CompteRestJaxRSAPI {
    //l'injection de CompteRepository dans CompteRestJaxRSAPI
    @Autowired
    private CompteRepository compteRepository;
    // Récupérer la liste des comptes bancaires au format JSON
    @Path("/comptes")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Compte> compteList(){
        return compteRepository.findAll();
    }
    // Récupérer un compte spécifique par son identifiant.
    @Path("/comptes/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Compte getOne(@PathParam(value = "id")long id){
        return compteRepository.findById(id).get();
    }
    // Créer un nouveau compte en utilisant les données fournies.
    @Path("/comptes")
    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Compte save(Compte compte){
        return compteRepository.save(compte);
    }
    // Mettre à jour un compte existant en utilisant les données fournies.
    @Path("/comptes/{id}")
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    public Compte update(Compte compte, @PathParam("id") Long id){
        compte.setId(id);
        return compteRepository.save(compte);
    }
    // Supprimer un compte en fonction de son identifiant.
    @Path("/comptes/{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public void  delete(@PathParam("id") Long id) {
        compteRepository.deleteById(id);
    }


}

