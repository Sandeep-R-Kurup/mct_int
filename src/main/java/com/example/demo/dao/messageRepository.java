package com.example.demo.dao;

import com.example.demo.model.message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface messageRepository extends JpaRepository<message,Integer> {

}
