package com.miniforum.controller;

import com.miniforum.dao.MessageRepository;
import com.miniforum.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class ForumController {

    @Autowired
    private MessageRepository messageRepository;

    //Methode pour aller sur la page d'ajout de message
    @GetMapping(value = "/ajoutmessage")
    public String ajoutMessage(Model model) {

        model.addAttribute("messageForm", new Message());
        return "ajoutMessage";

    }

    //Methode qui permet de valider l'ajout de message
    @PostMapping(value = "/ajoutmessage")
    public String ajoutMessage(Model model, @RequestParam(value = "titre") String titre, @RequestParam(value = "contenu") String contenu) {

        Date maintenant = new Date();
        String date = "";
        DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
        date = shortDateFormat.format(maintenant);

        Message message = new Message(titre, date, contenu);
        messageRepository.save(message);

        ArrayList<Message> messages = (ArrayList<Message>) messageRepository.findAll();

        model.addAttribute("messages", messages);
        return "listeMessage";
    }

    //Methode qui permet d'aller sur la page des differents message
    @GetMapping(value = "/listemessage")
    public String listeMessage(Model model) {
        ArrayList<Message> messages = (ArrayList<Message>) messageRepository.findAll();

        model.addAttribute("messages", messages);
        return "listeMessage";

    }

    //Methode qui permet de voir un message
    @PostMapping(value = "/voirmessage")
    public String voirMessage(Model model, @RequestParam(value = "id") Long id) {

        Message message = messageRepository.getById(id);

        model.addAttribute("message", message);

        return "voirMessage";
    }

    //Methode qui permet d'aller sur la page de modification de message  
    @GetMapping(value = "/modifiermessage")
    public String modifierMessage(Model model, @RequestParam(value = "id") Long id) {


        Message message = messageRepository.getById(id);
        model.addAttribute("messageForm", message);

        return "modifierMessage";
    }

    //Methode qui permet de modifier le message
    @PostMapping(value = "/modifiermessage")
    public String modifierMessage(Model model, @RequestParam(value = "id") Long id, @RequestParam(value = "titre") String titre, @RequestParam(value = "contenu") String contenu) {

        Message message = messageRepository.getById(id);
        Date maintenant = new Date();
        String date = "";
        DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
        date = shortDateFormat.format(maintenant);

        message.setDate(date);
        message.setTitre(titre);
        message.setContenu(contenu);
        messageRepository.save(message);

        ArrayList<Message> messages = (ArrayList<Message>) messageRepository.findAll();
        model.addAttribute("messages", messages);

        return "listeMessage";
    }

    //Methode qui permet de supprimer le message
    @PostMapping(value = "/supprimermessage")
    public String supprimerMessage(Model model, @RequestParam(value = "id") Long id) {

        Message message = messageRepository.getById(id);
        messageRepository.delete(message);

        ArrayList<Message> messages = (ArrayList<Message>) messageRepository.findAll();

        model.addAttribute("messages", messages);
        return "listeMessage";
    }
}
