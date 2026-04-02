package com.example.peliculaservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.peliculaservice.model.Pelicula;
import com.example.peliculaservice.service.PeliculaService;

@RestController
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping("/peliculas")
    public List<Pelicula> obtenerPeliculas() {
        return peliculaService.getAllPeliculas();
    }

    @GetMapping("/peliculas/{id}")
    public Optional<Pelicula> obtenerPeliculaPorId(@PathVariable Long id) {
        return peliculaService.getPeliculaById(id);
    }
}