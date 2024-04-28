<<<<<<< HEAD
package com.ejercicios.springjpa.controller;

import com.ejercicios.springjpa.entities.Autor;
import com.ejercicios.springjpa.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar operaciones relacionadas con autores.
 */
@RestController // Anotación para indicar que esta clase es un controlador REST
@RequestMapping("/autor") // Mapea todas las peticiones que comiencen con "/autor" a este controlador
public class AutorControlador {

    @Autowired // Anotación para la inyección de dependencias
    private AutorService autorService; // Servicio para la lógica relacionada con los autores

    /**
     * Método para obtener todos los autores.
     *
     * @return ResponseEntity con la lista de autores si se obtienen correctamente, o un ResponseEntity con un mensaje de error en caso de fallo.
     */
    @GetMapping("/all")
    public ResponseEntity<?> obtenerAutores() {
        try {
            List<Autor> autores = autorService.obtenerAutores();
            return ResponseEntity.ok(autores);
        } catch (Exception ex) {
            return handleException(ex);
        }
    }

    /**
     * Método para insertar un nuevo autor.
     *
     * @param autor El autor a insertar.
     * @return ResponseEntity con el nuevo autor si se inserta correctamente, o un ResponseEntity con un mensaje de error en caso de fallo.
     */
    @PostMapping("/add")
    public ResponseEntity<?> insertarAutor(@RequestBody Autor autor) {
        try {
            Autor nuevoAutor = autorService.insertarAutor(autor);
            return ResponseEntity.ok(nuevoAutor);
        } catch (Exception ex) {
            return handleException(ex);
        }
    }

    /**
     * Método para obtener un autor por su ID.
     *
     * @param id El ID del autor a buscar.
     * @return ResponseEntity con el autor encontrado si existe, o un ResponseEntity con estado NOT_FOUND si no se encuentra el autor, o un ResponseEntity con un mensaje de error en caso de fallo.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerAutorPorId(@PathVariable int id) {
        try {
            Autor autor = autorService.buscarAutorPorId(id);
            if (autor != null) {
                return ResponseEntity.ok(autor);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Autor no encontrado");
            }
        } catch (Exception ex) {
            return handleException(ex);
        }
    }

    /**
     * Método para eliminar un autor por su ID.
     *
     * @param id El ID del autor a eliminar.
     * @return ResponseEntity con estado OK si se elimina correctamente, o un ResponseEntity con estado NOT_FOUND si no se encuentra el autor, o un ResponseEntity con un mensaje de error en caso de fallo.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarAutor(@PathVariable int id) {
        try {
            Autor autor = autorService.buscarAutorPorId(id);
            if (autor != null) {
                autorService.eliminarAutor(id);
                return ResponseEntity.ok().body("Autor borrado");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Autor no encontrado");
            }
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



=======
package com.ejercicios.springjpa.controller;

import com.ejercicios.springjpa.entities.Autor;
import com.ejercicios.springjpa.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar operaciones relacionadas con autores.
 */
@RestController // Anotación para indicar que esta clase es un controlador REST
@RequestMapping("/autor") // Mapea todas las peticiones que comiencen con "/autor" a este controlador
public class AutorControlador {

    @Autowired // Anotación para la inyección de dependencias
    private AutorService autorService; // Servicio para la lógica relacionada con los autores

    /**
     * Método para obtener todos los autores.
     *
     * @return ResponseEntity con la lista de autores si se obtienen correctamente, o un ResponseEntity con un mensaje de error en caso de fallo.
     */
    @GetMapping("/all")
    public ResponseEntity<?> obtenerAutores() {
        try {
            List<Autor> autores = autorService.obtenerAutores();
            return ResponseEntity.ok(autores);
        } catch (Exception ex) {
            return handleException(ex);
        }
    }

    /**
     * Método para insertar un nuevo autor.
     *
     * @param autor El autor a insertar.
     * @return ResponseEntity con el nuevo autor si se inserta correctamente, o un ResponseEntity con un mensaje de error en caso de fallo.
     */
    @PostMapping("/add")
    public ResponseEntity<?> insertarAutor(@RequestBody Autor autor) {
        try {
            Autor nuevoAutor = autorService.insertarAutor(autor);
            return ResponseEntity.ok(nuevoAutor);
        } catch (Exception ex) {
            return handleException(ex);
        }
    }

    /**
     * Método para obtener un autor por su ID.
     *
     * @param id El ID del autor a buscar.
     * @return ResponseEntity con el autor encontrado si existe, o un ResponseEntity con estado NOT_FOUND si no se encuentra el autor, o un ResponseEntity con un mensaje de error en caso de fallo.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerAutorPorId(@PathVariable int id) {
        try {
            Autor autor = autorService.buscarAutorPorId(id);
            if (autor != null) {
                return ResponseEntity.ok(autor);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Autor no encontrado");
            }
        } catch (Exception ex) {
            return handleException(ex);
        }
    }

    /**
     * Método para eliminar un autor por su ID.
     *
     * @param id El ID del autor a eliminar.
     * @return ResponseEntity con estado OK si se elimina correctamente, o un ResponseEntity con estado NOT_FOUND si no se encuentra el autor, o un ResponseEntity con un mensaje de error en caso de fallo.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarAutor(@PathVariable int id) {
        try {
            Autor autor = autorService.buscarAutorPorId(id);
            if (autor != null) {
                autorService.eliminarAutor(id);
                return ResponseEntity.ok().body("Autor borrado");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Autor no encontrado");
            }
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



>>>>>>> origin/main
