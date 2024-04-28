package com.ejercicios.springjpa.repositories;

import com.ejercicios.springjpa.entities.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Repositorio para la entidad Autor.
 */
@Repository // Indica que esta interfaz es un componente de repositorio de Spring
public interface AutorRepository extends JpaRepository<Autor, Integer> {

}
