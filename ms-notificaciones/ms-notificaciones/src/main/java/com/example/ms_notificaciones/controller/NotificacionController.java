package com.example.ms_notificaciones.controller;

import com.example.ms_notificaciones.dto.NotificacionDTO;
import com.example.ms_notificaciones.service.NotificacionService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/notificaciones")
public class NotificacionController {

    private final NotificacionService
            service;

    @PostMapping
    public ResponseEntity<NotificacionDTO>
    crearNotificacion(
            @RequestBody
            NotificacionDTO dto) {

        log.info(
                "POST /api/notificaciones");

        return new ResponseEntity<>(
                service.crearNotificacion(dto),
                HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificacionDTO>
    buscarPorId(
            @PathVariable Long id) {

        log.info(
                "GET /api/notificaciones/{}",
                id);

        return ResponseEntity.ok(
                service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<NotificacionDTO>>
    listarTodas() {

        log.info(
                "GET /api/notificaciones");

        return ResponseEntity.ok(
                service.listarTodas());
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<NotificacionDTO>>
    buscarPorUsuario(
            @PathVariable Long usuarioId) {

        log.info(
                "GET /api/notificaciones/usuario/{}",
                usuarioId);

        return ResponseEntity.ok(
                service.buscarPorUsuario(
                        usuarioId));
    }

    @GetMapping("/estado/{leida}")
    public ResponseEntity<List<NotificacionDTO>>
    buscarPorEstado(
            @PathVariable Boolean leida) {

        log.info(
                "GET /api/notificaciones/estado/{}",
                leida);

        return ResponseEntity.ok(
                service.buscarPorEstado(
                        leida));
    }

    @PutMapping("/{id}/leida")
    public ResponseEntity<NotificacionDTO>
    marcarComoLeida(
            @PathVariable Long id) {

        log.info(
                "PUT /api/notificaciones/{}/leida",
                id);

        return ResponseEntity.ok(
                service.marcarComoLeida(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>
    eliminar(
            @PathVariable Long id) {

        log.info(
                "DELETE /api/notificaciones/{}",
                id);

        service.eliminar(id);

        return ResponseEntity
                .noContent()
                .build();
    }
}