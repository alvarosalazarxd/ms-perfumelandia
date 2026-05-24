package com.usuarios.ms_usuario.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String correo;

    @Column(nullable = false)
    private String password;

    private String rol;

    private LocalDateTime fechaRegistro;

    @PrePersist
    public void prePersist() {

        this.fechaRegistro =
                LocalDateTime.now();

        if (this.rol == null) {

            this.rol = "CLIENTE";
        }
    }
}