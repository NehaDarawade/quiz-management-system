//
//During login, user sends:
//
//{
//  "email":"neha@gmail.com",
//  "password":"1234"
//}
//
//We don't need name, role, or id.
//
//So we create:
//
//public class LoginRequest
//Responsibility
//Receive login credentials
package com.example.quizapp.dto;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {

    @Email(message = "Enter a valid email")
    @NotBlank(message = "Email is required")
    private String email;

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

	@NotBlank(message = "Password is required")
    private String password;
}
