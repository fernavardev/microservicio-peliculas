package com.example.peliculaservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.peliculaservice.model.Pelicula;
import com.example.peliculaservice.service.PeliculaService;

@RestController
@RequestMapping("/peliculas")
@CrossOrigin(origins = "*")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping
    public List<Pelicula> obtenerPeliculas() {
        return peliculaService.getAllPeliculas();
    }

    @GetMapping("/{id}")
    public Optional<Pelicula> obtenerPeliculaPorId(@PathVariable Long id) {
        return peliculaService.getPeliculaById(id);
    }

    @PostMapping
    public Pelicula crearPelicula(@RequestBody Pelicula pelicula) {
        return peliculaService.createPelicula(pelicula);
    }

    @PutMapping("/{id}")
    public Pelicula actualizarPelicula(@PathVariable Long id, @RequestBody Pelicula pelicula) {
        return peliculaService.updatePelicula(id, pelicula);
    }

    @DeleteMapping("/{id}")
    public void eliminarPelicula(@PathVariable Long id) {
        peliculaService.deletePelicula(id);
    }
}