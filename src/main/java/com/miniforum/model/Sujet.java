package com.miniforum.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Sujet { 
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	private byte intensite;
	@OneToMany
	private List <Message> message = new ArrayList<Message>();
	@ManyToOne
	private Utilisateur utilisateur;
	
	
	public Sujet() {
	}


	public Sujet(int id, byte intensite, Utilisateur utilisateur) {
		this.id = id;
		this.intensite = intensite;
		this.utilisateur = utilisateur;
	}


	@Override
	public String toString() {
		return "Sujet [id=" + id + ", intensite=" + intensite + ", message=" + message + ", utilisateur=" + utilisateur
				+ "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public byte getIntensite() {
		return intensite;
	}


	public void setIntensite(byte intensite) {
		this.intensite = intensite;
	}


	public List<Message> getMessage() {
		return message;
	}


	public void setMessage(List<Message> message) {
		this.message = message;
	}


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
}
