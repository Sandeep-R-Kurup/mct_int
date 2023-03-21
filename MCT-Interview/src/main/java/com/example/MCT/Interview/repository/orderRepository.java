package com.example.MCT.Interview.repository;

import com.example.MCT.Interview.model.orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface orderRepository extends JpaRepository<orders,Integer> {
}
