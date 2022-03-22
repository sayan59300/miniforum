package com.miniforum.controller;

import java.text.DateFormat;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

import com.miniforum.dao.MessageRepository;
import com.miniforum.model.Message;

@Controller
public class ForumController {

	@Autowired
    private MessageRepository messageRepository;
	
	//Methode pour aller sur la page d'ajout de message 
    @GetMapping(value = "/ajoutMessage")
    public String AjoutMessage() {

        return "AjoutMessage";

    }
    
    //Methode qui permet de valider l'ajout de message
    @PostMapping(value = "/ajoutMessage")
    public ModelAndView AjoutProduit(@RequestParam(value = "titre") String titre, @RequestParam(value = "contenu") String contenu) {
        
    	Date maintenant = new Date();   
    	String date = "";
    	DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT);
    	date = shortDateFormat.format(maintenant);
    	
    	Message message = new Message(titre,date,contenu);
    	 messageRepository.save(message);
        
    	 ArrayList <Message> messages =(ArrayList<Message>) messageRepository.findAll();    	 
    	 
        ModelAndView mv = new ModelAndView();
        mv.addObject("messages", messages);
        mv.setViewName("ListeMessage");       
        
        return mv;
    }
    
    //Methode qui permet d'aller sur la page des differents message
    @GetMapping(value = "/listeMessage")
    public ModelAndView ListeMessage() {
    	ArrayList <Message> messages =(ArrayList<Message>) messageRepository.findAll();
    	
    	ModelAndView mv = new ModelAndView();
    	mv.addObject("messages", messages);
        mv.setViewName("ListeMessage");
        return mv;

    }
    
    //Methode qui permet de voir un message
    @PostMapping(value = "/voirMessage")
    public ModelAndView AjoutProduit(@RequestParam(value = "id") Long id) {
            	  	 
    	Message message = messageRepository.getById(id);
    	
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", message);
        mv.setViewName("VoirMessage");       
        
        return mv;
    }
    
    //Methode qui permet d'aller sur la page de modification de message  
    @GetMapping(value = "/modifierMessage")
    public ModelAndView ModifierMessage(@RequestParam(value = "id") Long id) {
            	  	 
    	
    	Message message = messageRepository.getById(id);    	
    	
    	    	
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", message);
        mv.setViewName("ModifierMessage");        
        return mv;
    }
    
    //Methode qui permet de modifier le message
    @PostMapping(value = "/modifierMessage")
    public ModelAndView ModifierMessage(@RequestParam(value = "id") Long id,@RequestParam(value = "titre") String titre, @RequestParam(value = "contenu") String contenu) {
            	  	 
    	Message message = messageRepository.getById(id);
    	Date maintenant = new Date();   
    	String date = "";
    	DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT);
    	date = shortDateFormat.format(maintenant);
    	
    	message.setDate(date);
    	message.setTitre(titre);
    	message.setContenu(contenu);
    	messageRepository.save(message);
    	
    	ArrayList <Message> messages =(ArrayList<Message>) messageRepository.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("messages", messages);
        mv.setViewName("ListeMessage");        
        return mv;
    }
   
    //Methode qui permet de supprimer le message
    @PostMapping(value = "/supprimerMessage")
    public ModelAndView SupprimerMessage(@RequestParam(value = "id") Long id) {
            	  	 
    	Message message = messageRepository.getById(id);    	
    	messageRepository.delete(message);
    	
    	ArrayList <Message> messages =(ArrayList<Message>) messageRepository.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("messages", messages);
        mv.setViewName("ListeMessage");        
        return mv;
    }
}
