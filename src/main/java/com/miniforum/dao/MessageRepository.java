package com.miniforum.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.miniforum.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
    
}