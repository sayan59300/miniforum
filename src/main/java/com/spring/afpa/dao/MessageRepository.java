package com.spring.afpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.spring.afpa.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
    
}