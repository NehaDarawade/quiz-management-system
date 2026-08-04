

//After successful login, backend returns:
//
//{
//  "token":"eyJhbGciOiJIUzI1NiJ9...",
//  "message":"Login Successful"
//}
//
//Need a class for this response.
//
//Responsibility
//Send JWT token to frontend


package com.example.quizapp.dto;




public class AuthResponse {

    private String token;
    private String message;

    public AuthResponse() {
    }

    public AuthResponse(String token, String message) {
        this.token = token;
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}