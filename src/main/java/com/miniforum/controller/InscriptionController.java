package com.miniforum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.miniforum.dao;

@Controller
public class InscriptionController {
	
	// Securisation du repository utilisateur
	
	private final UtilisateurRepository utilisateurRepository;
	
	@Autowired
    public InscriptionController(UtilisateurRepository utilisateurRepository) {
    	
        this.utilisateurRepository = utilisateurRepository;
	
    }
	
//	Affichage de la page d'inscription.
	
	@GetMapping(value = "/inscription" )
	public String showRegister(Model model) {
		model.addAttribute("utilisateurForm", new Utilisateur())
		return "inscription";
		
	}
	
// Gestion de l'inscription d'un utilisateur.
	
	@PostMapping(value="/inscription")
	public String register(@ModelAttribute("utilisateurForm") Utilisateur utilisateur, Model model) {
		
		System.out.println("===DEBUG=== Entrée dans la route POST de la page d'inscription ===DEBUG===");
		
		//	Retourne un message d'erreur si un des champs requis n'est pas complété.
		
		if(utilisateur.getNom().length() == 0 || utilisateur.getPrenom().length() == 0 || utilisateur.getAge().length() == 0 || 
				utilisateur.getJob().length() == 0 || utilisateur.getHobbys().length() == 0 || utilisateur.getPseudo().length() == 0 ||
				utilisateur.getEmail().length() == 0 || utilisateur.getPassword().length() == 0 || utilisateur.getPassword2().length() == 0) {
			
			System.out.println("===DEBUG=== Entrée dans condition 1 ===DEBUG===");
			
			String errormessage = "Veuillez remplir tout les champs !";
			model.addAttribute("message", errormessage);
			return "inscription";
			
		}
		
		// Verification que le pseudo ne dépasse pas 15 caractères.
		
		if(utilisateur.getPseudo().length() > 15) {
			
			System.out.println("===DEBUG=== Entrée dans condition 2 ===DEBUG===");
			
			String errormessage = "Votre pseudo ne doit pas dépasser 15 caractères !";
			model.addAttribute("message", errormessage);
			return "inscription";
			
		}
		
		// Vérification que les deux mot de passes fournis par l'utilisateur correspondent entre eux.
		
		if(!utilisateur.getPassword().equals(utilisateur.getPassword2())) {
			
			System.out.println("===DEBUG=== Entrée dans condition 3 ===DEBUG===");
			
			String errormessage = "Les mots de passes ne correspondent pas !";
			model.addAttribute("message", errormessage);
			return "inscription";
			
		}
		
		// Si tout les champs sont ok alors création de l'utilisateur et insertion en base de données.
		
		utilisateurRepository.save(utilisateur);
		
		// Renvoie l'utilisateur sur la page d'inscription avec un message de confirmation.
		
		String confirmation = "Votre inscription a bien été prise en compte !";
		model.addAttribute("confirmation", confirmation);
		return "inscription";
		
	}

}