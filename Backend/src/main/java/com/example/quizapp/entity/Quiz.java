package com.example.quizapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="quizzes")
public class Quiz {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long id;
	

	private String title;
	private String description;

    private String category;

    private Integer totalMarks;

    private Integer duration;
    
    
    public Quiz() {
		super();
	}


	public Quiz(Long id, String title, String description, String category, Integer totalMarks, Integer duration) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.category = category;
		this.totalMarks = totalMarks;
		this.duration = duration;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public Integer getTotalMarks() {
		return totalMarks;
	}


	public void setTotalMarks(Integer totalMarks) {
		this.totalMarks = totalMarks;
	}


	public Integer getDuration() {
		return duration;
	}


	public void setDuration(Integer duration) {
		this.duration = duration;
	}
    
    
    
}
