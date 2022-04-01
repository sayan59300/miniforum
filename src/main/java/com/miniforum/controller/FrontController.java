package com.miniforum.controller;

import com.miniforum.dao.InscriptionRepository;
import com.miniforum.dao.UtilisateurRepository;
import com.miniforum.model.Inscription;
import com.miniforum.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;
import java.util.Date;

@Controller
public class FrontController {
    @Autowired
    UtilisateurRepository utilisateurRepository;
    @Autowired
    InscriptionRepository inscriptionRepository;

    /**
     * Crée l'administrateur si il n'est pas dans la base de donnée
     */
    @PostConstruct
    public void setup() {
        Utilisateur utilisateur = new Utilisateur();
        Utilisateur admin = utilisateurRepository.findByPseudo("admin");
        Inscription inscription = new Inscription();
        if (admin == null) {
            utilisateur.setPseudo("admin");
            utilisateur.setProfession("administrateur");
            utilisateur.setAge(40);
            utilisateur.setHobby("aucun");
            utilisateur.setPassword("admin");
            utilisateur.setNom("BUFFART");
            utilisateur.setPrenom("Nicolas");
            utilisateur.setRole("ADMIN");
            utilisateurRepository.save(utilisateur);
            Utilisateur newAdmin = utilisateurRepository.findByPseudo("admin");
            inscription.setUtilisateur(newAdmin);
            inscription.setDate_demande(new Date());
            inscription.setDate_activation(new Date());
            inscriptionRepository.save(inscription);
            newAdmin.setInscription(inscription);
            utilisateurRepository.save(newAdmin);
        }
    }

    @GetMapping(value = {"/index", "/"})
    public String getIndex() {
        return "index";
    }

    @GetMapping("/newSubjectAccess")
    public String getSubjectAccess() {
        return "nouveauSujet";
    }

    @GetMapping("/general")
    public String paramsPage() {
        return "general";
    }

}
