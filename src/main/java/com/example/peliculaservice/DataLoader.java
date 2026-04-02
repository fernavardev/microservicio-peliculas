package com.example.peliculaservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.peliculaservice.model.Pelicula;
import com.example.peliculaservice.repository.PeliculaRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final PeliculaRepository peliculaRepository;

    public DataLoader(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (peliculaRepository.count() == 0) {
            peliculaRepository.save(new Pelicula(
                    "Inception",
                    2010,
                    "Christopher Nolan",
                    "Ciencia ficción",
                    "Un ladrón especializado en robar secretos a través de los sueños recibe una misión de implantar una idea."
            ));

            peliculaRepository.save(new Pelicula(
                    "Interstellar",
                    2014,
                    "Christopher Nolan",
                    "Ciencia ficción",
                    "Un grupo de astronautas viaja por el espacio en busca de un nuevo hogar para la humanidad."
            ));

            peliculaRepository.save(new Pelicula(
                    "The Godfather",
                    1972,
                    "Francis Ford Coppola",
                    "Drama",
                    "La historia de la familia Corleone y su poder dentro del crimen organizado."
            ));

            peliculaRepository.save(new Pelicula(
                    "Parasite",
                    2019,
                    "Bong Joon-ho",
                    "Thriller",
                    "Dos familias de clases sociales opuestas terminan relacionadas de forma inesperada."
            ));

            peliculaRepository.save(new Pelicula(
                    "Whiplash",
                    2014,
                    "Damien Chazelle",
                    "Drama",
                    "Un joven baterista enfrenta el duro entrenamiento de un profesor extremadamente exigente."
            ));
        }
    }
}