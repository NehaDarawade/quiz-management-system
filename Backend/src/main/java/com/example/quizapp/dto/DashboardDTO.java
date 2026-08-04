package com.example.quizapp.dto;



public class DashboardDTO {

    private long totalQuizzes;
    private long totalQuestions;
    private long totalStudents;
    private long totalAttempts;

    public DashboardDTO() {
    }

    public DashboardDTO(long totalQuizzes, long totalQuestions,
                        long totalStudents, long totalAttempts) {
        this.totalQuizzes = totalQuizzes;
        this.totalQuestions = totalQuestions;
        this.totalStudents = totalStudents;
        this.totalAttempts = totalAttempts;
    }

    public long getTotalQuizzes() {
        return totalQuizzes;
    }

    public void setTotalQuizzes(long totalQuizzes) {
        this.totalQuizzes = totalQuizzes;
    }

    public long getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(long totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public long getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(long totalStudents) {
        this.totalStudents = totalStudents;
    }

    public long getTotalAttempts() {
        return totalAttempts;
    }

    public void setTotalAttempts(long totalAttempts) {
        this.totalAttempts = totalAttempts;
    }
}