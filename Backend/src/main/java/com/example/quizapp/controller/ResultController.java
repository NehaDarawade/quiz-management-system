package com.example.quizapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.quizapp.dto.SubmitQuizDTO;
import com.example.quizapp.entity.Result;
import com.example.quizapp.service.ResultService;

@RestController
@RequestMapping("/api/results")
@CrossOrigin(origins = "http://localhost:3000")
public class ResultController {

    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    // Create Result
    @PostMapping
    public Result createResult(@RequestBody Result result) {
        return resultService.createResult(result);
    }

    // Get All Results
    @GetMapping
    public List<Result> getAllResults() {
        return resultService.getAllResults();
    }

    // Get Result By Id
    @GetMapping("/{id}")
    public Result getResultById(@PathVariable Long id) {
        return resultService.getResultById(id);
    }

    // Update Result
    @PutMapping("/{id}")
    public Result updateResult(@PathVariable Long id,
                               @RequestBody Result result) {
        return resultService.updateResult(id, result);
    }

    // Delete Result
    @DeleteMapping("/{id}")
    public String deleteResult(@PathVariable Long id) {
        return resultService.deleteResult(id);
    }

    // Submit Quiz
    @PostMapping("/submit")
    public Result submitQuiz(@RequestBody SubmitQuizDTO submitQuizDTO) {
        return resultService.submitQuiz(submitQuizDTO);
    }
}