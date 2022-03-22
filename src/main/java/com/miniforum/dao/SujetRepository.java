package com.miniforum.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniforum.model.Sujet;

public interface SujetRepository extends JpaRepository<Sujet, Integer> {
	
	

}
