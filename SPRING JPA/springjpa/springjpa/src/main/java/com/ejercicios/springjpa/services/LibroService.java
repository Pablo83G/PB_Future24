package com.ejercicios.springjpa.services;


import com.ejercicios.springjpa.entities.Libro;
import com.ejercicios.springjpa.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;
import java.util.Optional;

/**
 * Clase de servicio para manejar operaciones relacionadas con libros.
 */
@Service // Indica que esta clase es un servicio de Spring
public class LibroService {

    @Autowired // Inyección de dependencia de LibroRepository en LibroService
    LibroRepository libroRepository;

    /**
     * Constructor por defecto de la clase LibroService.
     */
    public LibroService(){
        // Constructor por defecto
    }

    /**
     * Inserta un nuevo libro en la base de datos.
     *
     * @param libro El libro a insertar.
     * @return El libro insertado.
     */
    public Libro insertarLibro(Libro libro){
        return libroRepository.save(libro);
    }

    /**
     * Obtiene todos los libros de la base de datos.
     *
     * @return Una lista de todos los libros.
     */
    public List<Libro> obtenerLibros(){
        return libroRepository.findAll();
    }

    /**
     * Elimina un libro de la base de datos por su ID.
     *
     * @param id El ID del libro a eliminar.
     */
    public void eliminarLibro(int id){
        libroRepository.deleteById(id);
    }

    /**
     * Busca un libro en la base de datos por su ID.
     *
     * @param id El ID del libro a buscar.
     * @return El libro encontrado, o null si no se encuentra.
     */
    public Libro buscarLibroPorId(int id){
        Optional<Libro> optionalLibro = libroRepository.findById(id);
        return optionalLibro.orElse(null);
    }

    /**
     * Metodo de busqueda de libros publicados a partir de año realizada con anotacion @Query
     * @param year
     * @return Una lista de todos los libros que hayan sido publicados a partir de 2001
     */
    public List<Libro>getBooksAfterYearQuery(Year year){
        return libroRepository.findByfechaPublicacionAfter(year);
    }

    /**Metodo de busqueda de libros publicados a partir de año realizada con la creacion de querys por el metodo de nombres
     * @param year
     * @return
     */
    public List<Libro> getBooksAfterYearMethodNames(Year year){
        return libroRepository.findByfechaPublicacionGreaterThan(year);
    }


    /** Metodo de busqueda de libros publicados en el año dado
     * @param year año de publicacion a buscar
     * @return lista de libros publicados en ese año
     */
    public List<Libro>getBooksByYear(Year year){
        return libroRepository.findByfechaPublicacion(year);
    }

    /**Metodo de busqueda de libros por ISBN
     * @param ISBN
     * @return libro que coincida con el ISBN dado
     */
    public Libro getBookByISBN(String ISBN){
        return libroRepository.findByISBN(ISBN);
    }

    /**
     * Metodo que devuelve los libros que sean de la editorial dada
     * @param nombreEditorial
     * @return
     */
    public List<Libro> findByEditorial(String nombreEditorial){
        return libroRepository.findByEditorial(nombreEditorial);
    }

    /**
     * Mostrar los libros de la editorial dada y publicados en el año dado
     * @param nombreEditorial
     * @param fechaPublicacion
     * @return
     */
   public List<Libro> findLibrosPorEditorialYFechaPublicacion( String nombreEditorial, Year fechaPublicacion){
        return libroRepository.findLibrosPorEditorialYFechaPublicacion(nombreEditorial,fechaPublicacion);
   }


}

