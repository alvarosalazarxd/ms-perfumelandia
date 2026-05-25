package com.usuarios.ms_usuario.dto;

import jakarta.validation.constraints.*;

import lombok.Data;

@Data
public class UsuarioRequestDTO {

    @NotBlank
    private String nombre;

    @Email
    @NotBlank
    private String correo;

    @NotBlank
    private String password;

    private String rol;
}