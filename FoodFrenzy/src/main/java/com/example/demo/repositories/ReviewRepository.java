package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
