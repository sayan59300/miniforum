package com.miniforum.controller;

import com.miniforum.dao.UtilisateurRepository;
import com.miniforum.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InscriptionController {

    // Securisation du repository utilisateur

    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public InscriptionController(UtilisateurRepository utilisateurRepository) {

        this.utilisateurRepository = utilisateurRepository;

    }

//	Affichage de la page d'inscription.

    @GetMapping(value = "/inscription")
    public String showRegister() {

        return "inscription";

    }

// Gestion de l'inscription d'un utilisateur.

    @PostMapping(value = "/inscription")
    public String register(
            @RequestParam(value = "nom") String nom,
            @RequestParam(value = "prenom") String prenom,
            @RequestParam(value = "age") String age,
            @RequestParam(value = "job") String job,
            @RequestParam(value = "hobbys") String hobbys,
            @RequestParam(value = "pseudo") String pseudo,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String mdp,
            @RequestParam(value = "password2") String mdp2,
            Model model
    ) {

        System.out.println("===DEBUG=== Entrée dans la route POST de la page d'inscription ===DEBUG===");

        //	Retourne un message d'erreur si un des champs requis n'est pas complété.

        if (nom.length() == 0 || prenom.length() == 0 || age.length() == 0 ||
                job.length() == 0 || hobbys.length() == 0 || pseudo.length() == 0 ||
                email.length() == 0 || mdp.length() == 0 || mdp2.length() == 0) {

            System.out.println("===DEBUG=== Entrée dans condition 1 ===DEBUG===");

            String errormessage = "Veuillez remplir tout les champs !";
            model.addAttribute("message", errormessage);
            return "inscription";

        }

        // Verification que le pseudo ne dépasse pas 15 caractères.

        if (pseudo.length() > 15) {

            System.out.println("===DEBUG=== Entrée dans condition 2 ===DEBUG===");

            String errormessage = "Votre pseudo ne doit pas dépasser 15 caractères !";
            model.addAttribute("message", errormessage);
            return "inscription";


        }

        // Vérification que les deux mot de passes fournis par l'utilisateur correspondent entre eux.

        if (!mdp.equals(mdp2)) {

            System.out.println("===DEBUG=== Entrée dans condition 3 ===DEBUG===");

            String errormessage = "Les mots de passes ne correspondent pas !";
            model.addAttribute("message", errormessage);
            return "inscription";


        }

        // Si tout les champs sont ok alors création de l'utilisateur et insertion en base de données.

        Utilisateur utilisateur = new Utilisateur();

        utilisateur.setNom(nom);
        utilisateur.setPrenom(prenom);
        utilisateur.setAge(Integer.parseInt(age));
        utilisateur.setProfession(job);
        utilisateur.setHobby(hobbys);
        utilisateur.setPseudo(pseudo);
        utilisateur.setPassword(mdp);

        utilisateurRepository.save(utilisateur);

        // Renvoie l'utilisateur sur la page d'inscription avec un message de confirmation.

        String confirmation = "Votre inscription a bien été prise en compte !";
        model.addAttribute("confirmation", confirmation);
        return "inscription";

    }

}