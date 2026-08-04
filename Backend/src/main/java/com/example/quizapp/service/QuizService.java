package com.example.quizapp.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.example.quizapp.entity.Quiz;
import com.example.quizapp.repository.QuizRepository;

@Service
public class QuizService {

    private final QuizRepository quizRepository;

    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    // Create Quiz
    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    // Get All Quizzes
    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    // Get Quiz By Id
    public Quiz getQuizById(Long id) {
        return quizRepository.findById(id).orElse(null);
    }

    // Update Quiz
    public Quiz updateQuiz(Long id, Quiz quiz) {

        Quiz existingQuiz = quizRepository.findById(id).orElse(null);

        if (existingQuiz != null) {

            existingQuiz.setTitle(quiz.getTitle());
            existingQuiz.setDescription(quiz.getDescription());
            existingQuiz.setCategory(quiz.getCategory());
            existingQuiz.setTotalMarks(quiz.getTotalMarks());
            existingQuiz.setDuration(quiz.getDuration());

            return quizRepository.save(existingQuiz);
        }

        return null;
    }

    // Delete Quiz
    public String deleteQuiz(Long id) {

        if (quizRepository.existsById(id)) {
            quizRepository.deleteById(id);
            return "Quiz Deleted Successfully";
        }

        return "Quiz Not Found";
    }
}
