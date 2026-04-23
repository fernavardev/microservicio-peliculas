package com.example.peliculaservice.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.Optional;

import com.example.peliculaservice.model.Pelicula;
import com.example.peliculaservice.service.PeliculaService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(PeliculaController.class)
class PeliculaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PeliculaService peliculaService;

    @Autowired
    private ObjectMapper objectMapper;

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
    void testObtenerPeliculas() throws Exception {
        when(peliculaService.getAllPeliculas()).thenReturn(Arrays.asList(pelicula));

        mockMvc.perform(get("/peliculas"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(Arrays.asList(pelicula))));
    }

    @Test
    void testObtenerPeliculaPorId() throws Exception {
        when(peliculaService.getPeliculaById(1L)).thenReturn(Optional.of(pelicula));

        mockMvc.perform(get("/peliculas/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(pelicula)));
    }

    @Test
    void testCrearPelicula() throws Exception {
        when(peliculaService.createPelicula(any(Pelicula.class))).thenReturn(pelicula);

        mockMvc.perform(post("/peliculas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(pelicula)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(pelicula)));
    }

    @Test
    void testActualizarPelicula() throws Exception {
        when(peliculaService.updatePelicula(eq(1L), any(Pelicula.class))).thenReturn(pelicula);

        mockMvc.perform(put("/peliculas/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(pelicula)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(pelicula)));
    }

    @Test
    void testEliminarPelicula() throws Exception {
        mockMvc.perform(delete("/peliculas/1"))
                .andExpect(status().isOk());

        verify(peliculaService).deletePelicula(1L);
    }
}