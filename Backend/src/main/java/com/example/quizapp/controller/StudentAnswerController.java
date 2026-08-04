package com.example.quizapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.quizapp.entity.StudentAnswer;
import com.example.quizapp.service.StudentAnswerService;

@RestController
@RequestMapping("/api/student-answers")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentAnswerController {

    private final StudentAnswerService studentAnswerService;

    public StudentAnswerController(StudentAnswerService studentAnswerService) {
        this.studentAnswerService = studentAnswerService;
    }

    // Create Student Answer
    @PostMapping
    public StudentAnswer createStudentAnswer(@RequestBody StudentAnswer studentAnswer) {
        return studentAnswerService.createStudentAnswer(studentAnswer);
    }

    // Get All Student Answers
    @GetMapping
    public List<StudentAnswer> getAllStudentAnswers() {
        return studentAnswerService.getAllStudentAnswers();
    }

    // Get Student Answer By Id
    @GetMapping("/{id}")
    public StudentAnswer getStudentAnswerById(@PathVariable Long id) {
        return studentAnswerService.getStudentAnswerById(id);
    }

    // Update Student Answer
    @PutMapping("/{id}")
    public StudentAnswer updateStudentAnswer(@PathVariable Long id,
                                             @RequestBody StudentAnswer studentAnswer) {
        return studentAnswerService.updateStudentAnswer(id, studentAnswer);
    }

    // Delete Student Answer
    @DeleteMapping("/{id}")
    public String deleteStudentAnswer(@PathVariable Long id) {
        return studentAnswerService.deleteStudentAnswer(id);
    }
}