package com.miniforum.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniforum.model.Inscription;

public interface InscriptionRepository extends JpaRepository<Inscription, Integer>{

	
}
