package com.example.ms_carrito.controller;

import com.example.ms_carrito.dto.CarritoRequestDTO;
import com.example.ms_carrito.dto.CarritoResponseDTO;
import com.example.ms_carrito.service.CarritoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carritos")
@RequiredArgsConstructor
@Slf4j

public class CarritoController {

    private final CarritoService carritoService;

    @PostMapping
    public ResponseEntity<CarritoResponseDTO>
    crearCarrito(
            @RequestBody
            CarritoRequestDTO requestDTO) {

        log.info(
                "POST /api/carritos - Crear carrito");

        CarritoResponseDTO carritoCreado =
                carritoService.crearCarrito(
                        requestDTO);

        return new ResponseEntity<>(
                carritoCreado,
                HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarritoResponseDTO>
    obtenerCarritoPorId(
            @PathVariable Long id) {

        log.info(
                "GET /api/carritos/{} - Obtener carrito",
                id);

        CarritoResponseDTO carrito =
                carritoService
                        .obtenerCarritoPorId(id);

        return ResponseEntity.ok(carrito);
    }

    @GetMapping
    public ResponseEntity<List<CarritoResponseDTO>>
    obtenerTodosLosCarritos() {

        log.info(
                "GET /api/carritos - Obtener todos los carritos");

        List<CarritoResponseDTO> carritos =
                carritoService
                        .obtenerTodosLosCarritos();

        return ResponseEntity.ok(carritos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarritoResponseDTO>
    actualizarCarrito(
            @PathVariable Long id,
            @RequestBody
            CarritoRequestDTO requestDTO) {

        log.info(
                "PUT /api/carritos/{} - Actualizar carrito",
                id);

        CarritoResponseDTO carritoActualizado =
                carritoService.actualizarCarrito(
                        id,
                        requestDTO);

        return ResponseEntity.ok(
                carritoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>
    eliminarCarrito(
            @PathVariable Long id) {

        log.info(
                "DELETE /api/carritos/{} - Eliminar carrito",
                id);

        carritoService.eliminarCarrito(id);

        return ResponseEntity
                .noContent()
                .build();
    }
}