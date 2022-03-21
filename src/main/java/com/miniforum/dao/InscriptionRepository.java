package com.spring.afpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.afpa.model.Inscription;

public interface InscriptionRepository extends JpaRepository<Inscription, Integer>{

	
}
