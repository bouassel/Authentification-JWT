package com.example.authentificationsystemjwt.Controller;

import com.example.authentificationsystemjwt.entities.CustomUserDetailsService;
import com.example.authentificationsystemjwt.entities.JwtUtil;
import com.example.authentificationsystemjwt.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    public AuthenticationController(AuthenticationManager authenticationManager,
                                    CustomUserDetailsService userDetailsService,
                                    JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody Map<String, String> loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.get("username"),
                        loginRequest.get("password")
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user = (User) userDetailsService.loadUserByUsername(loginRequest.get("username"));
        String token = jwtUtil.generateToken(user);

        return ResponseEntity.ok(token);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@RequestBody Map<String, String> signUpRequest) {
        // Extract username and password from the map
        String username = signUpRequest.get("username");
        String password = signUpRequest.get("password");

        // Validate and save user to the database

        return ResponseEntity.ok("User registered successfully");
    }
}
