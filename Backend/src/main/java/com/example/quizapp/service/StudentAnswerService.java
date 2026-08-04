package com.example.quizapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.quizapp.entity.StudentAnswer;
import com.example.quizapp.repository.StudentAnswerRepository;

@Service
public class StudentAnswerService {

    private final StudentAnswerRepository studentAnswerRepository;

    public StudentAnswerService(StudentAnswerRepository studentAnswerRepository) {
        this.studentAnswerRepository = studentAnswerRepository;
    }

    // Create Student Answer
    public StudentAnswer createStudentAnswer(StudentAnswer studentAnswer) {
        return studentAnswerRepository.save(studentAnswer);
    }

    // Get All Student Answers
    public List<StudentAnswer> getAllStudentAnswers() {
        return studentAnswerRepository.findAll();
    }

    // Get Student Answer By Id
    public StudentAnswer getStudentAnswerById(Long id) {
        return studentAnswerRepository.findById(id).orElse(null);
    }

    // Update Student Answer
    public StudentAnswer updateStudentAnswer(Long id, StudentAnswer studentAnswer) {

        StudentAnswer existingAnswer = studentAnswerRepository.findById(id).orElse(null);

        if (existingAnswer != null) {

            existingAnswer.setSelectedAnswer(studentAnswer.getSelectedAnswer());
            existingAnswer.setStudent(studentAnswer.getStudent());
            existingAnswer.setQuestion(studentAnswer.getQuestion());

            return studentAnswerRepository.save(existingAnswer);
        }

        return null;
    }

    // Delete Student Answer
    public String deleteStudentAnswer(Long id) {

        if (studentAnswerRepository.existsById(id)) {

            studentAnswerRepository.deleteById(id);

            return "Student Answer Deleted Successfully";
        }

        return "Student Answer Not Found";
    }
}