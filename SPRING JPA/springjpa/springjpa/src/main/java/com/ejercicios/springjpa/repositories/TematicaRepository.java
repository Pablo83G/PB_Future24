package com.ejercicios.springjpa.repositories;

import com.ejercicios.springjpa.entities.Tematica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad Tematica.
 */
@Repository // Indica que esta interfaz es un componente de repositorio de Spring
public interface TematicaRepository extends JpaRepository<Tematica,Integer> {
}
