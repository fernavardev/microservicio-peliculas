package com.example.peliculaservice.service;

import java.util.List;
import java.util.Optional;

import com.example.peliculaservice.model.Pelicula;

public interface PeliculaService {

    List<Pelicula> getAllPeliculas();

    Optional<Pelicula> getPeliculaById(Long id);

    Pelicula createPelicula(Pelicula pelicula);

    Pelicula updatePelicula(Long id, Pelicula pelicula);

    void deletePelicula(Long id);
}