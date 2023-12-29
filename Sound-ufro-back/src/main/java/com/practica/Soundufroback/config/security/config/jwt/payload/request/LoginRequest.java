package com.practica.Soundufroback.config.security.config.jwt.payload.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRequest {
    private String userName;
    private String password;
}
