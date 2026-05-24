package com.example.ms_favorito.service;

import com.example.ms_favorito.dto.FavoritoDTO;

import java.util.List;

public interface FavoritoService {

    FavoritoDTO guardarFavorito(
            FavoritoDTO favoritoDTO);

    FavoritoDTO buscarPorId(Long id);

    List<FavoritoDTO> listarFavoritos();

    void eliminarFavorito(Long id);
}