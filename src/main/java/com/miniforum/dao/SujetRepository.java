package com.spring.afpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.afpa.model.Sujet;

public interface SujetRepository extends JpaRepository<Sujet, Integer> {
	
	

}
