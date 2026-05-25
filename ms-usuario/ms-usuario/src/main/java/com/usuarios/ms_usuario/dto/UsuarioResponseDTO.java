package com.usuarios.ms_usuario.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UsuarioResponseDTO {

    private Long id;

    private String nombre;

    private String correo;

    private String rol;

    private LocalDateTime fechaRegistro;
}
