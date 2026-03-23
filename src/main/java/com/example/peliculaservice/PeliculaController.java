package com.example.peliculaservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeliculaController {

    private List<Pelicula> peliculas = new ArrayList<>();

    public PeliculaController() {
        peliculas.add(new Pelicula(1, "Inception", 2010, "Christopher Nolan", "Ciencia ficción",
                "Un ladrón especializado en robar secretos a través de los sueños recibe una misión de implantar una idea."));

        peliculas.add(new Pelicula(2, "Interstellar", 2014, "Christopher Nolan", "Ciencia ficción",
                "Un grupo de astronautas viaja por el espacio en busca de un nuevo hogar para la humanidad."));

        peliculas.add(new Pelicula(3, "The Godfather", 1972, "Francis Ford Coppola", "Drama",
                "La historia de la familia Corleone y su poder dentro del crimen organizado."));

        peliculas.add(new Pelicula(4, "Parasite", 2019, "Bong Joon-ho", "Thriller",
                "Dos familias de clases sociales opuestas terminan relacionadas de forma inesperada."));

        peliculas.add(new Pelicula(5, "Whiplash", 2014, "Damien Chazelle", "Drama",
                "Un joven baterista enfrenta el duro entrenamiento de un profesor extremadamente exigente."));
    }

    @GetMapping("/peliculas")
    public List<Pelicula> obtenerPeliculas() {
        return peliculas;
    }

    @GetMapping("/peliculas/{id}")
    public Pelicula obtenerPeliculaPorId(@PathVariable int id) {
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getId() == id) {
                return pelicula;
            }
        }
        return null;
    }
}