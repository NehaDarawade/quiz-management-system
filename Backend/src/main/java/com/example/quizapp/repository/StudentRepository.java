package com.example.quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quizapp.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}