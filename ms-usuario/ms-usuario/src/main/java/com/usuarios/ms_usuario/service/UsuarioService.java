package com.usuarios.ms_usuario.service;



import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usuarios.ms_usuario.dto.UsuarioRequestDTO;
import com.usuarios.ms_usuario.dto.UsuarioResponseDTO;
import com.usuarios.ms_usuario.exception.ResourceNotFoundException;
import com.usuarios.ms_usuario.model.Usuario;
import com.usuarios.ms_usuario.repository.UsuarioRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioResponseDTO crearUsuario(
            UsuarioRequestDTO requestDTO) {

        Usuario usuario = new Usuario();

        usuario.setNombre(
                requestDTO.getNombre());

        usuario.setCorreo(
                requestDTO.getCorreo());

        usuario.setPassword(
                requestDTO.getPassword());

        usuario.setRol(
                requestDTO.getRol());

        Usuario guardado =
                usuarioRepository.save(usuario);

        return convertirDTO(guardado);
    }

    @Transactional(readOnly = true)
    public List<UsuarioResponseDTO>
    obtenerTodos() {

        return usuarioRepository.findAll()
                .stream()
                .map(this::convertirDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    public UsuarioResponseDTO
    obtenerPorId(Long id) {

        Usuario usuario =
                usuarioRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Usuario no encontrado"));

        return convertirDTO(usuario);
    }

    public UsuarioResponseDTO actualizarUsuario(
            Long id,
            UsuarioRequestDTO requestDTO) {

        Usuario usuario =
                usuarioRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Usuario no encontrado"));

        usuario.setNombre(
                requestDTO.getNombre());

        usuario.setCorreo(
                requestDTO.getCorreo());

        usuario.setPassword(
                requestDTO.getPassword());

        usuario.setRol(
                requestDTO.getRol());

        Usuario actualizado =
                usuarioRepository.save(usuario);

        return convertirDTO(actualizado);
    }

    public void eliminarUsuario(Long id) {

        Usuario usuario =
                usuarioRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Usuario no encontrado"));

        usuarioRepository.delete(usuario);
    }

    @Transactional(readOnly = true)
    public UsuarioResponseDTO
    buscarPorCorreo(String correo) {

        Usuario usuario =
                usuarioRepository.findByCorreo(correo)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Usuario no encontrado"));

        return convertirDTO(usuario);
    }

    @Transactional(readOnly = true)
    public List<UsuarioResponseDTO>
    buscarPorRol(String rol) {

        return usuarioRepository.findByRol(rol)
                .stream()
                .map(this::convertirDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<UsuarioResponseDTO>
    buscarPorNombre(String nombre) {

        return usuarioRepository
                .findByNombreContainingIgnoreCase(
                        nombre)
                .stream()
                .map(this::convertirDTO)
                .toList();
    }

    private UsuarioResponseDTO convertirDTO(
            Usuario usuario) {

        UsuarioResponseDTO dto =
                new UsuarioResponseDTO();

        dto.setId(usuario.getId());

        dto.setNombre(usuario.getNombre());

        dto.setCorreo(usuario.getCorreo());

        dto.setRol(usuario.getRol());

        dto.setFechaRegistro(
                usuario.getFechaRegistro());

        return dto;
    }
}
