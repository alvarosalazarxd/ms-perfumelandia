package com.envios.ms_envios.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.envios.ms_envios.model.Envio;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnvioRepository extends JpaRepository<Envio, Long> {

    // Buscar por código de seguimiento
    Optional<Envio> findByCodigoSeguimiento(String codigoSeguimiento);

    // Buscar envíos por estado
    List<Envio> findByEstado(String estado);

    // Buscar envíos por transportista
    List<Envio> findByTransportistaIgnoreCase(String transportista);

    // Buscar envíos por pedido
    List<Envio> findByPedidoId(Long pedidoId);

    // Buscar por dirección que contenga texto
    List<Envio> findByDireccionContainingIgnoreCase(String direccion);

    // Verificar si existe código de seguimiento
    boolean existsByCodigoSeguimiento(String codigoSeguimiento);
}
