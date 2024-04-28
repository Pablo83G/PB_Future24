package com.ejercicios.springjpa.controller;

import com.ejercicios.springjpa.entities.Libro;
import com.ejercicios.springjpa.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Year;
import java.util.List;
/**
 * Controlador REST para gestionar operaciones relacionadas con libros.
 */
@RestController // Indica que esta clase es un controlador REST
@RequestMapping("/libro") // Mapea todas las peticiones que comiencen con "/libro" a este controlador
public class LibroControlador {

    @Autowired // Inyección de dependencias
    private LibroService libroService; // Servicio para la lógica relacionada con los libros

    /**
     * Método para obtener todos los libros.
     *
     * @return ResponseEntity con la lista de libros si se obtienen correctamente, o un ResponseEntity con un mensaje de error en caso de fallo.
     */
    @GetMapping("/all")
    public ResponseEntity<?> obtenerLibros() {
        try {
            List<Libro> libros = libroService.obtenerLibros();
            return ResponseEntity.ok(libros);
        } catch (Exception ex) {
            return handleException(ex);
        }
    }

    /**
     * Método para insertar un nuevo libro.
     *
     * @param libro El libro a insertar.
     * @return ResponseEntity con el nuevo libro si se inserta correctamente, o un ResponseEntity con un mensaje de error en caso de fallo.
     */
    @PostMapping("/add")
    public ResponseEntity<?> insertarLibro(@RequestBody Libro libro){
        try {
            Libro nuevoLibro = libroService.insertarLibro(libro);
            return ResponseEntity.ok(nuevoLibro);
        } catch (Exception ex) {
            return handleException(ex);
        }
    }

    /**
     * Método para obtener un libro por su ID.
     *
     * @param id El ID del libro a buscar.
     * @return ResponseEntity con el libro encontrado si existe, o un ResponseEntity con estado NOT_FOUND si no se encuentra el libro, o un ResponseEntity con un mensaje de error en caso de fallo.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerLibroPorId(@PathVariable int id) {
        try {
            Libro libro = libroService.buscarLibroPorId(id);
            if (libro != null) {
                return ResponseEntity.ok(libro);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Libro no encontrado");
            }
        } catch (Exception ex) {
            return handleException(ex);
        }
    }

    /**
     * Método para eliminar un libro por su ID.
     *
     * @param id El ID del libro a eliminar.
     * @return ResponseEntity con estado OK si se elimina correctamente, o un ResponseEntity con estado NOT_FOUND si no se encuentra el libro, o un ResponseEntity con un mensaje de error en caso de fallo.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarLibro(@PathVariable int id) {
        try {
            Libro libro = libroService.buscarLibroPorId(id);
            if (libro != null) {
                libroService.eliminarLibro(id);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Libro no encontrado");
            }
        } catch (Exception ex) {
            return handleException(ex);
        }
    }

    /**
     *  Método para buscar los libros que han sido publicados a partir de un año con @ Query.
     * @param year año de publicación a partir del cual buscar
     * @return lista de libros publicados a partir del año dado.
     */
    @GetMapping("/publicados/despues/{year}")
    public ResponseEntity<?> getBooksAfterYearQuery(@PathVariable Year year) {
        try {
            List<Libro> libros = libroService.getBooksAfterYearQuery(year);
            return ResponseEntity.ok(libros);
        } catch (Exception ex) {
            return handleException(ex);
        }
    }

    /**
     *  Método para buscar los libros que han sido publicados a partir de un con Metodo de nombre.
     * @param year año de publicación a partir del cual buscar
     * @return lista de libros publicados a partir del año dado.
     */
   @GetMapping("/publicadosMethod/despues/{year}")
    public ResponseEntity<?> getBooksAfterYearMethod(@PathVariable Year year) {
        try {
            List<Libro> libros = libroService.getBooksAfterYearMethodNames(year);
            return ResponseEntity.ok(libros);
        } catch (Exception ex) {
            return handleException(ex);
        }
    }

    /**Método para buscar los libros que han sido publicados en un año en concreto .
     * @param year  año de publicación a buscar
     * @return  lista de libros publicados en el año dado.
     */
    @GetMapping("/publicados/{year}")
    public ResponseEntity<?> getBooksByYear(@PathVariable Year year) {
        try {
            List<Libro> libros = libroService.getBooksByYear(year);
            return ResponseEntity.ok(libros);
        } catch (Exception ex) {
            return handleException(ex);
        }
    }

    /**
     * Método para buscar un libro por su ISBN
     * @param ISBN
     * @return
     */
    @GetMapping("/ISBN/{ISBN}")
    public ResponseEntity<?> getBooksByISBN(@PathVariable String ISBN) {
        try {
            Libro libro = libroService.getBookByISBN(ISBN);
            return ResponseEntity.ok(libro);
        } catch (Exception ex) {
            return handleException(ex);
        }
    }

    /**
     * @param nombreEditorial
     * @return
     */
    @GetMapping("/editorial/{nombreEditorial}")
    public ResponseEntity<?> getBooksByEditorial(@PathVariable String nombreEditorial) {
        try {
            List<Libro> libros = libroService.findByEditorial(nombreEditorial);
            return ResponseEntity.ok(libros);
        } catch (Exception ex) {
            return handleException(ex);
        }
    }

    @GetMapping("/editorialYfecha")
    public ResponseEntity<?> getBooksByEditorialAndYear(
            @RequestParam("editorial") String nombreEditorial,
            @RequestParam("year") Year year) {
                try {
                    List<Libro> libros = libroService.findLibrosPorEditorialYFechaPublicacion(nombreEditorial, year);
                    return ResponseEntity.ok(libros);
                } catch (Exception ex) {
                    return handleException(ex);
                }
    }


    /**
     * Manejador de excepciones global.
     *
     * @param ex La excepción ocurrida.
     * @return ResponseEntity con un mensaje de error interno del servidor.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
    }
}



