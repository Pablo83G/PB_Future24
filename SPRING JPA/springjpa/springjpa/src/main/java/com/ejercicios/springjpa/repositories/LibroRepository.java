package com.ejercicios.springjpa.repositories;

import com.ejercicios.springjpa.entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Year;
import java.util.List;

/**
 * Repositorio para la entidad Libro.
 */
@Repository // Indica que esta interfaz es un componente de repositorio de Spring
public interface LibroRepository extends JpaRepository<Libro,Integer> {

    //Querys creadas por anotacion @Query
    @Query("SELECT l FROM Libro l WHERE l.fechaPublicacion > ?1")
    List<Libro> findByfechaPublicacionAfter(Year fechaPublicacion);

    //Mostrar los libros de la editorial RBA.
    @Query("SELECT l FROM Libro l JOIN l.editorial e WHERE e.nombre =?1")
    List<Libro> findByEditorial(String nombreEditorial);

    //Mostrar los libros de la editorial PLANETA publicados en 1986
    @Query("SELECT l FROM Libro l JOIN l.editorial e WHERE e.nombre = ?1 AND l.fechaPublicacion = ?2")
    List<Libro> findLibrosPorEditorialYFechaPublicacion( String nombreEditorial, Year fechaPublicacion);



    //Querys creadas por el method names
    // Mostrar los libros cuya fecha de publicación sea mayor que 01/12/2001.
    List<Libro> findByfechaPublicacionGreaterThan(Year year);

    //Mostrar el libro cuyo ISBN es el 87919878.
    Libro findByISBN(String ISBN);
    //Mostrar los libros publicados en el año 2001.
    List<Libro> findByfechaPublicacion(Year fechaPublicacion);

}
