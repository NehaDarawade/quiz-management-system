package com.example.quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quizapp.entity.StudentAnswer;

public interface StudentAnswerRepository extends JpaRepository<StudentAnswer, Long> {

}