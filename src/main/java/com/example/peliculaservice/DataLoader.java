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

            peliculaRepository.save(new Pelicula(
                "The Dark Knight",
                2008,
                "Christopher Nolan",
                "Acción",
                "Batman enfrenta al Joker mientras Gotham cae en el caos."
            ));

             peliculaRepository.save(new Pelicula(
                "Pulp Fiction",
                1994,
                "Quentin Tarantino",
                "Crimen",
                "Historias entrelazadas del mundo criminal en Los Ángeles."
             ));

             peliculaRepository.save(new Pelicula(
                "Fight Club",
                1999,
                "David Fincher",
                "Drama",
                "Un hombre crea un club secreto de peleas que se convierte en algo mucho más grande."
             ));

             peliculaRepository.save(new Pelicula(
                "Forrest Gump",
                1994,
                "Robert Zemeckis",
                "Drama",
                "La vida de un hombre con discapacidad intelectual que presencia momentos clave de la historia."
             ));

             peliculaRepository.save(new Pelicula(
                "The Matrix",
                1999,
                "Lana y Lilly Wachowski",
                "Ciencia ficción",
                "Un hacker descubre la verdadera naturaleza de la realidad y su rol en la guerra contra las máquinas."
             ));
        }
    }
}