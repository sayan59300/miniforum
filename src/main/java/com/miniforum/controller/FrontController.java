package com.miniforum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontController {
    /*@Autowired
    UtilisateurRepository utilisateurRepository;*/

    @GetMapping(value = {"/index", "/"})
    public String getIndex() {
        /*Utilisateur utilisateur = new Utilisateur();
        Utilisateur admin = utilisateurRepository.findByPseudo("admin");
        if (admin == null) {
            utilisateur.setPseudo("admin");
            utilisateur.setProfession("administrateur");
            utilisateur.setAge(40);
            utilisateur.setHobby("aucun");
            utilisateur.setPassword(new BCryptPasswordEncoder().encode("admin"));
            utilisateur.setNom("BUFFART");
            utilisateur.setPrenom("Nicolas");
            utilisateur.setType_utilisateur("ADMIN");
            utilisateurRepository.save(utilisateur);
        }*/
        return "index";
    }

    @GetMapping("/newSubjectAccess")
    public String getSubjectAccess() {
        return "newSubject";
    }

    @GetMapping("/general")
    public String paramsPage() {
        return "general";
    }

}
