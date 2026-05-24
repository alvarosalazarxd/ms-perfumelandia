package com.usuarios.ms_usuario.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usuarios.ms_usuario.model.Usuario;

import java.util.Optional;
import java.util.List;

@Repository
public interface UsuarioRepository
        extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByCorreo(
            String correo);

    List<Usuario> findByRol(
            String rol);

    List<Usuario> findByNombreContainingIgnoreCase(
            String nombre);
}
