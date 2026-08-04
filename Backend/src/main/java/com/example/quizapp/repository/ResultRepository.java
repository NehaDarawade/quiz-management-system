package com.example.quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quizapp.entity.Result;

public interface ResultRepository extends JpaRepository<Result, Long> {

}