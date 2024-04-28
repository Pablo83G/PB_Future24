package com.ejercicios.springjpa.controller;


import com.ejercicios.springjpa.entities.Editorial;
import com.ejercicios.springjpa.services.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Controlador REST para gestionar operaciones relacionadas con las editoriales.
 */
@RestController // Anotación para indicar que esta clase es un controlador REST
@RequestMapping("/editorial") // Mapea todas las peticiones que comiencen con "/editorial" a este controlador
public class EditorialControlador {

    @Autowired // Anotación para la inyección de dependencias
    private EditorialService editorialService; // Servicio para la lógica relacionada con las editoriales

    /**
     * Método para obtener todos las editoriales.
     *
     * @return ResponseEntity con la lista de editoriales si se obtienen correctamente, o un ResponseEntity con un mensaje de error en caso de fallo.
     */
    @GetMapping("/all")
    public ResponseEntity<?> obtenerEditoriales() {
        try {
            List<Editorial> editoriales = editorialService.obtenerEditoriales();
            return ResponseEntity.ok(editoriales);
        } catch (Exception ex) {
            return handleException(ex);
        }
    }

    /**
     * Método para insertar un nueva Editorial.
     *
     * @param editorial La editorial a insertar.
     * @return ResponseEntity con la nueva editorial si se inserta correctamente, o un ResponseEntity con un mensaje de error en caso de fallo.
     */
    @PostMapping("/add")
    public ResponseEntity<?> insertarEditorial(@RequestBody Editorial editorial) {
        try {
            Editorial nuevaEditorial = editorialService.insertarEditorial(editorial);
            return ResponseEntity.ok(nuevaEditorial);
        } catch (Exception ex) {
            return handleException(ex);
        }
    }

    /**
     * Método para obtener una editorial por su ID.
     *
     * @param id El ID de la editorial a buscar.
     * @return ResponseEntity con el autor encontrado si existe, o un ResponseEntity con estado NOT_FOUND si no se encuentra la editorial, o un ResponseEntity con un mensaje de error en caso de fallo.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerEditorialPorId(@PathVariable int id) {
        try {
            Editorial editorial = editorialService.buscarEditorialPorId(id);
            if (editorial != null) {
                return ResponseEntity.ok(editorial);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Editorial no encontrada");
            }
        } catch (Exception ex) {
            return handleException(ex);
        }
    }

    /**
     * Método para eliminar una editorial por su ID.
     *
     * @param id El ID de la editorial a eliminar.
     * @return ResponseEntity con estado OK si se elimina correctamente, o un ResponseEntity con estado NOT_FOUND si no se encuentra la editorial, o un ResponseEntity con un mensaje de error en caso de fallo.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarEditorial(@PathVariable int id) {
        try {
            Editorial editorial = editorialService.buscarEditorialPorId(id);
            if (editorial != null) {
                editorialService.eliminarEditorial(id);
                return ResponseEntity.ok().body("Editorial borrada");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Editorial no encontrada");
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
