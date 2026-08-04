package com.example.quizapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.quizapp.entity.Student;
import com.example.quizapp.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Create Student
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // Get All Students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get Student By Id
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    // Update Student
    public Student updateStudent(Long id, Student student) {

        Student existingStudent = studentRepository.findById(id).orElse(null);

        if (existingStudent != null) {

            existingStudent.setName(student.getName());
            existingStudent.setEmail(student.getEmail());
            existingStudent.setPassword(student.getPassword());
            existingStudent.setPhone(student.getPhone());

            return studentRepository.save(existingStudent);
        }

        return null;
    }

    // Delete Student
    public String deleteStudent(Long id) {

        if (studentRepository.existsById(id)) {

            studentRepository.deleteById(id);

            return "Student Deleted Successfully";
        }

        return "Student Not Found";
    }
}