package com.example.quizapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.quizapp.dto.AnswerDTO;
import com.example.quizapp.dto.SubmitQuizDTO;
import com.example.quizapp.entity.Question;
import com.example.quizapp.entity.Quiz;
import com.example.quizapp.entity.Result;
import com.example.quizapp.entity.Student;
import com.example.quizapp.repository.QuestionRepository;
import com.example.quizapp.repository.QuizRepository;
import com.example.quizapp.repository.ResultRepository;
import com.example.quizapp.repository.StudentRepository;

@Service
public class ResultService {

    private final ResultRepository resultRepository;
    private final QuestionRepository questionRepository;
    private final StudentRepository studentRepository;
    private final QuizRepository quizRepository;

    public ResultService(ResultRepository resultRepository,
                         QuestionRepository questionRepository,
                         StudentRepository studentRepository,
                         QuizRepository quizRepository) {

        this.resultRepository = resultRepository;
        this.questionRepository = questionRepository;
        this.studentRepository = studentRepository;
        this.quizRepository = quizRepository;
    }

    // Create Result
    public Result createResult(Result result) {
        return resultRepository.save(result);
    }

    // Get All Results
    public List<Result> getAllResults() {
        return resultRepository.findAll();
    }

    // Get Result By Id
    public Result getResultById(Long id) {
        return resultRepository.findById(id).orElse(null);
    }

    // Update Result
    public Result updateResult(Long id, Result result) {

        Result existingResult = resultRepository.findById(id).orElse(null);

        if (existingResult != null) {

            existingResult.setScore(result.getScore());
            existingResult.setTotalMarks(result.getTotalMarks());
            existingResult.setStudent(result.getStudent());
            existingResult.setQuiz(result.getQuiz());

            return resultRepository.save(existingResult);
        }

        return null;
    }

    // Delete Result
    public String deleteResult(Long id) {

        if (resultRepository.existsById(id)) {

            resultRepository.deleteById(id);

            return "Result Deleted Successfully";
        }

        return "Result Not Found";
    }

    // Submit Quiz and Calculate Score
    public Result submitQuiz(SubmitQuizDTO submitQuizDTO) {

        List<Question> questions =
                questionRepository.findByQuizId(submitQuizDTO.getQuizId());

        int score = 0;
        int totalMarks = 0;

        for (Question question : questions) {

            totalMarks += question.getMarks();

            for (AnswerDTO answer : submitQuizDTO.getAnswers()) {

                if (question.getId().equals(answer.getQuestionId())
                        && question.getCorrectAnswer().equals(answer.getSelectedAnswer())) {

                    score += question.getMarks();
                }
            }
        }

        Student student =
                studentRepository.findById(submitQuizDTO.getStudentId()).orElse(null);

        Quiz quiz =
                quizRepository.findById(submitQuizDTO.getQuizId()).orElse(null);

        Result result = new Result();

        result.setScore(score);
        result.setTotalMarks(totalMarks);
        result.setStudent(student);
        result.setQuiz(quiz);

        return resultRepository.save(result);
    }
}