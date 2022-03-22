package com.miniforum.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Inscription {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	private Date date_demande;
	private Date date_activation;
	@OneToOne
	private Utilisateur utilisateur;
	
	public Inscription() {
	}
	
	public Inscription(int id, Date date_demande, Date date_activation,
			Utilisateur utilisateur) {
		this.id = id;
		this.date_demande = date_demande;
		this.date_activation = date_activation;
		this.utilisateur = utilisateur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate_demande() {
		return date_demande;
	}

	public void setDate_demande(Date date_demande) {
		this.date_demande = date_demande;
	}

	public Date getDate_activation() {
		return date_activation;
	}

	public void setDate_activation(Date date_activation) {
		this.date_activation = date_activation;
	}


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
  
	
   
	
	}
    
    
