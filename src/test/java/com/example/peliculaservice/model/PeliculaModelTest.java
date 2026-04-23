package com.example.peliculaservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PeliculaModelTest {

    @Test
    void testGettersAndSetters() {
        Pelicula pelicula = new Pelicula();

        pelicula.setId(1L);
        pelicula.setTitulo("Inception");
        pelicula.setAnio(2010);
        pelicula.setDirector("Christopher Nolan");
        pelicula.setGenero("Ciencia ficción");
        pelicula.setSinopsis("Un ladrón roba secretos a través de los sueños.");

        assertEquals(1L, pelicula.getId());
        assertEquals("Inception", pelicula.getTitulo());
        assertEquals(2010, pelicula.getAnio());
        assertEquals("Christopher Nolan", pelicula.getDirector());
        assertEquals("Ciencia ficción", pelicula.getGenero());
        assertEquals("Un ladrón roba secretos a través de los sueños.", pelicula.getSinopsis());
    }

    @Test
    void testConstructorConParametros() {
        Pelicula pelicula = new Pelicula(
                "Interestelar",
                2014,
                "Christopher Nolan",
                "Ciencia ficción",
                "Un grupo de astronautas viaja por un agujero de gusano."
        );

        assertEquals("Interestelar", pelicula.getTitulo());
        assertEquals(2014, pelicula.getAnio());
        assertEquals("Christopher Nolan", pelicula.getDirector());
        assertEquals("Ciencia ficción", pelicula.getGenero());
        assertEquals("Un grupo de astronautas viaja por un agujero de gusano.", pelicula.getSinopsis());
    }
}