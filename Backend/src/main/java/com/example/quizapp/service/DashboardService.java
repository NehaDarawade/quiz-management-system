package com.example.quizapp.service;



import org.springframework.stereotype.Service;

import com.example.quizapp.dto.DashboardDTO;
import com.example.quizapp.repository.QuestionRepository;
import com.example.quizapp.repository.QuizRepository;
import com.example.quizapp.repository.ResultRepository;
import com.example.quizapp.repository.StudentRepository;

@Service
public class DashboardService {

    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;
    private final StudentRepository studentRepository;
    private final ResultRepository resultRepository;

    public DashboardService(QuizRepository quizRepository,
                            QuestionRepository questionRepository,
                            StudentRepository studentRepository,
                            ResultRepository resultRepository) {

        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
        this.studentRepository = studentRepository;
        this.resultRepository = resultRepository;
    }

    public DashboardDTO getDashboardData() {

        long totalQuizzes = quizRepository.count();
        long totalQuestions = questionRepository.count();
        long totalStudents = studentRepository.count();
        long totalAttempts = resultRepository.count();

        return new DashboardDTO(
                totalQuizzes,
                totalQuestions,
                totalStudents,
                totalAttempts
        );
    }
}
