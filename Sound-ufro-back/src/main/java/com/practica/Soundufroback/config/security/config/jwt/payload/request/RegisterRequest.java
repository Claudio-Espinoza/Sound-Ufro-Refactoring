package com.practica.Soundufroback.config.security.config.jwt.payload.request;

import com.practica.Soundufroback.model.Role;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {
    private String nickname;
    private String password;
    private String correo;
    private Role role;
}
