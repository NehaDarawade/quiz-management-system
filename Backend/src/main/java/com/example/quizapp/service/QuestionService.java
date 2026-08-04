package com.example.quizapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.quizapp.entity.Question;
import com.example.quizapp.repository.QuestionRepository;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    // Create Question
    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    // Get All Questions
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    // Get Question By Id
    public Question getQuestionById(Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    // Get Questions By Quiz Id
    public List<Question> getQuestionsByQuizId(Long quizId) {
        return questionRepository.findByQuizId(quizId);
    }

    // Update Question
    public Question updateQuestion(Long id, Question question) {

        Question existingQuestion = questionRepository.findById(id).orElse(null);

        if (existingQuestion != null) {

            existingQuestion.setQuestionText(question.getQuestionText());
            existingQuestion.setOptionA(question.getOptionA());
            existingQuestion.setOptionB(question.getOptionB());
            existingQuestion.setOptionC(question.getOptionC());
            existingQuestion.setOptionD(question.getOptionD());
            existingQuestion.setCorrectAnswer(question.getCorrectAnswer());
            existingQuestion.setMarks(question.getMarks());
            existingQuestion.setQuiz(question.getQuiz());

            return questionRepository.save(existingQuestion);
        }

        return null;
    }

    // Delete Question
    public String deleteQuestion(Long id) {

        if (questionRepository.existsById(id)) {
            questionRepository.deleteById(id);
            return "Question Deleted Successfully";
        }

        return "Question Not Found";
    }
}