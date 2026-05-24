package com.usuarios.ms_usuario.exception;

public class ResourceNotFoundException
        extends RuntimeException {

    public ResourceNotFoundException(
            String mensaje) {

        super(mensaje);
    }
}
