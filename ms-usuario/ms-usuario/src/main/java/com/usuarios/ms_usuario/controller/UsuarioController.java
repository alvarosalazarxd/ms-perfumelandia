package com.usuarios.ms_usuario.controller;



import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.usuarios.ms_usuario.dto.UsuarioRequestDTO;
import com.usuarios.ms_usuario.dto.UsuarioResponseDTO;
import com.usuarios.ms_usuario.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")

@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO>
    crearUsuario(

            @Valid
            @RequestBody
            UsuarioRequestDTO requestDTO) {

        return ResponseEntity.status(
                HttpStatus.CREATED)

                .body(
                        usuarioService
                                .crearUsuario(requestDTO)
                );
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>>
    obtenerTodos() {

        return ResponseEntity.ok(
                usuarioService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO>
    obtenerPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                usuarioService.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO>
    actualizarUsuario(
            @PathVariable Long id,

            @Valid
            @RequestBody
            UsuarioRequestDTO requestDTO) {

        return ResponseEntity.ok(
                usuarioService.actualizarUsuario(
                        id,
                        requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>
    eliminarUsuario(
            @PathVariable Long id) {

        usuarioService.eliminarUsuario(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/correo/{correo}")
    public ResponseEntity<UsuarioResponseDTO>
    buscarPorCorreo(
            @PathVariable String correo) {

        return ResponseEntity.ok(
                usuarioService.buscarPorCorreo(
                        correo));
    }

    @GetMapping("/rol/{rol}")
    public ResponseEntity<List<UsuarioResponseDTO>>
    buscarPorRol(
            @PathVariable String rol) {

        return ResponseEntity.ok(
                usuarioService.buscarPorRol(
                        rol));
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<UsuarioResponseDTO>>
    buscarPorNombre(
            @PathVariable String nombre) {

        return ResponseEntity.ok(
                usuarioService.buscarPorNombre(
                        nombre));
    }
}
