package com.practica.Soundufroback.model.user;

import com.practica.Soundufroback.model.Role;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Entity
@Getter
@Setter
@Table(name = "usuario")
// La diferencia entre @AllArgsConstructor y @RequiredArgsConstructor es que el segundo
// es necesario del atributo final.
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
    @Id
    @Column(name = "nombre_id")
    private String nickname;

    @Column(name = "contraseña", nullable = false)
    private String password;

    @Column(name = "correo", length = 150)
    private String correo;

    @Enumerated(EnumType.STRING)
    private Role role;
}
