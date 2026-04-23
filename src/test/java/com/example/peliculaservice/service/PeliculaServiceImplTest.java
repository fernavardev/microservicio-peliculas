package com.example.peliculaservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.peliculaservice.model.Pelicula;
import com.example.peliculaservice.repository.PeliculaRepository;

@ExtendWith(MockitoExtension.class)
class PeliculaServiceImplTest {

    @Mock
    private PeliculaRepository peliculaRepository;

    @InjectMocks
    private PeliculaServiceImpl peliculaService;

    private Pelicula pelicula;

    @BeforeEach
    void setUp() {
        pelicula = new Pelicula();
        pelicula.setId(1L);
        pelicula.setTitulo("Inception");
        pelicula.setAnio(2010);
        pelicula.setDirector("Christopher Nolan");
        pelicula.setGenero("Ciencia ficción");
        pelicula.setSinopsis("Un ladrón roba secretos a través de los sueños.");
    }

    @Test
    void testGetAllPeliculas() {
        List<Pelicula> peliculas = Arrays.asList(pelicula);

        when(peliculaRepository.findAll()).thenReturn(peliculas);

        List<Pelicula> resultado = peliculaService.getAllPeliculas();

        assertEquals(1, resultado.size());
        assertEquals("Inception", resultado.get(0).getTitulo());
        verify(peliculaRepository).findAll();
    }

    @Test
    void testGetPeliculaById() {
        when(peliculaRepository.findById(1L)).thenReturn(Optional.of(pelicula));

        Optional<Pelicula> resultado = peliculaService.getPeliculaById(1L);

        assertTrue(resultado.isPresent());
        assertEquals("Inception", resultado.get().getTitulo());
        verify(peliculaRepository).findById(1L);
    }

    @Test
    void testCreatePelicula() {
        when(peliculaRepository.save(pelicula)).thenReturn(pelicula);

        Pelicula resultado = peliculaService.createPelicula(pelicula);

        assertNotNull(resultado);
        assertEquals("Inception", resultado.getTitulo());
        verify(peliculaRepository).save(pelicula);
    }

    @Test
    void testUpdatePeliculaExists() {
        when(peliculaRepository.existsById(1L)).thenReturn(true);
        when(peliculaRepository.save(pelicula)).thenReturn(pelicula);

        Pelicula resultado = peliculaService.updatePelicula(1L, pelicula);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        assertEquals("Inception", resultado.getTitulo());
        verify(peliculaRepository).existsById(1L);
        verify(peliculaRepository).save(pelicula);
    }

    @Test
    void testUpdatePeliculaNotExists() {
        when(peliculaRepository.existsById(1L)).thenReturn(false);

        Pelicula resultado = peliculaService.updatePelicula(1L, pelicula);

        assertNull(resultado);
        verify(peliculaRepository).existsById(1L);
        verify(peliculaRepository, never()).save(any());
    }

    @Test
    void testDeletePelicula() {
        peliculaService.deletePelicula(1L);

        verify(peliculaRepository).deleteById(1L);
    }
}