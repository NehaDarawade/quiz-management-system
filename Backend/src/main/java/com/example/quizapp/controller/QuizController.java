package com.example.quizapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.quizapp.entity.Quiz;
import com.example.quizapp.service.QuizService;

@RestController
@RequestMapping("/api/quizzes")
@CrossOrigin(origins = "http://localhost:3000")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    // Create Quiz
    @PostMapping
    public Quiz createQuiz(@RequestBody Quiz quiz) {
        return quizService.createQuiz(quiz);
    }

    // Get All Quizzes
    @GetMapping
    public List<Quiz> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }

    // Get Quiz By Id
    @GetMapping("/{id}")
    public Quiz getQuizById(@PathVariable Long id) {
        return quizService.getQuizById(id);
    }

    // Update Quiz
    @PutMapping("/{id}")
    public Quiz updateQuiz(@PathVariable Long id,
                           @RequestBody Quiz quiz) {
        return quizService.updateQuiz(id, quiz);
    }

    // Delete Quiz
    @DeleteMapping("/{id}")
    public String deleteQuiz(@PathVariable Long id) {
        return quizService.deleteQuiz(id);
    }
}