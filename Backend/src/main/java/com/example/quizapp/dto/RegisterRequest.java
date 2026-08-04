//
//When a user registers, the frontend sends:
//
//{
//  "name":"Neha",
//  "email":"neha@gmail.com",
//  "password":"1234"
//}
//
//We need a class to receive this data.
//
//public class RegisterRequest
//Responsibility
//Accept registration data from frontend
//Not related to database


package com.example.quizapp.dto;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


public class RegisterRequest {

    @NotBlank(message = "Name is required")
    private String name;

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Email(message = "Enter a valid email")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;
}