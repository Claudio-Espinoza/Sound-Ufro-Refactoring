package com.practica.Soundufroback.dto;

import com.practica.Soundufroback.model.Role;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserSecurityDto {
    private String nickname;
    private String password;
    private String correo;
    private Role role;
}
