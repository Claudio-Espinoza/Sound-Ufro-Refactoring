package com.practica.Soundufroback.config.security.Controller;

import com.practica.Soundufroback.config.security.config.jwt.AuthenticationService;
import com.practica.Soundufroback.config.security.config.jwt.payload.request.LoginRequest;
import com.practica.Soundufroback.config.security.config.jwt.payload.request.RegisterRequest;
import com.practica.Soundufroback.config.security.config.jwt.payload.response.JwtResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService jwtService;

    @PostMapping("login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(jwtService.login(request));
    }

    @PostMapping("register")
    public ResponseEntity<JwtResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(jwtService.register(request));
    }
}
