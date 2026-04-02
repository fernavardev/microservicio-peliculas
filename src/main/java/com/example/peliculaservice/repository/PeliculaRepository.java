package com.example.peliculaservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.peliculaservice.model.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
}