package com.practica.Soundufroback.config.security.config.jwt;

import com.practica.Soundufroback.config.security.config.jwt.payload.request.LoginRequest;
import com.practica.Soundufroback.config.security.config.jwt.payload.request.RegisterRequest;
import com.practica.Soundufroback.config.security.config.jwt.payload.response.JwtResponse;
import com.practica.Soundufroback.config.security.model.ImplementUserDetailService;
import com.practica.Soundufroback.dto.UserSecurityDto;
import com.practica.Soundufroback.model.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserService userService;
    private final ImplementUserDetailService implementUserDetailService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public JwtResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));

        UserDetails user = implementUserDetailService.loadUserByUsername(request.getUserName());

        String token = jwtService.getToken(user);
        return JwtResponse.builder()
                .token(token)
                .build();
    }

    public JwtResponse register(RegisterRequest request) {
        UserSecurityDto user = UserSecurityDto.builder()
                .nickname(request.getNickname())
                .password(passwordEncoder.encode(request.getPassword()))
                .correo(request.getCorreo())
                .role(request.getRole())
                .build();

        userService.saveUser(user);
        UserDetails userDetails = implementUserDetailService.loadUserByUsername(user.getNickname());

        return JwtResponse.builder()
                .token(jwtService.getToken(userDetails))
                .build();
    }

}
