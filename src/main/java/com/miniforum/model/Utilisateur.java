package com.miniforum.model;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private int age;
    private String profession;
    private String hobby;
    private String pseudo;
    private String password;
    private String role = "VISITEUR";

    @OneToOne
    private Inscription inscription;

    @OneToMany
    private List<Message> message = new ArrayList<Message>();

    public Utilisateur() {
    }

    public Utilisateur(int id, String nom, String prenom, int age, String profession, String hobby, String pseudo,
                       String password) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.profession = profession;
        this.hobby = hobby;
        this.pseudo = pseudo;
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String type_utilisateur) {
        this.role = type_utilisateur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    public Inscription getInscription() {
        return inscription;
    }

    public void setInscription(Inscription inscription) {
        this.inscription = inscription;
    }

    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }


}
