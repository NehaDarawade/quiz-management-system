package com.example.quizapp.service;



import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.quizapp.dto.AuthResponse;
import com.example.quizapp.dto.LoginRequest;
import com.example.quizapp.dto.RegisterRequest;
import com.example.quizapp.entity.User;
import com.example.quizapp.repository.UserRepository;
import com.example.quizapp.security.CustomUserDetailsService;
import com.example.quizapp.security.JwtService;


@Service
public class AuthService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authenticationManager;
	private final JwtService jwtService;
	private final CustomUserDetailsService userDetailsService;

	public AuthService(UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager,
            JwtService jwtService,
            CustomUserDetailsService userDetailsService) {

this.userRepository = userRepository;
this.passwordEncoder = passwordEncoder;
this.authenticationManager = authenticationManager;
this.jwtService = jwtService;
this.userDetailsService = userDetailsService;
}

    public String register(RegisterRequest request) {

        // Check if email already exists
        if (userRepository.existsByEmail(request.getEmail())) {
            return "Email already exists";
        }

        // Create User object
        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());

        // Encrypt password
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        // Default role
        user.setRole("ROLE_USER");

        // Save user
        userRepository.save(user);

        return "Registration Successful";
    }
    
    public AuthResponse login(LoginRequest request) {

        // Authenticate email and password
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()));

        // Load user details
        var userDetails = userDetailsService.loadUserByUsername(request.getEmail());

        // Generate JWT
        String token = jwtService.generateToken(userDetails);

        return new AuthResponse(token, "Login Successful");
    }

}
