<<<<<<< HEAD
package com.ejercicios.springjpa.controller;


import com.ejercicios.springjpa.entities.Tematica;
import com.ejercicios.springjpa.services.TematicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar operaciones relacionadas con las temáticas.
 */
@RestController
@RequestMapping("/tematica")
public class TematicaControlador {
    @Autowired
    private TematicaService tematicaService; // Servicio para la lógica relacionada con las temáticas

    /**
     * Método para obtener todas las temáticas.
     *
     * @return ResponseEntity con la lista de temáticas si se obtienen correctamente, o un ResponseEntity con un mensaje de error en caso de fallo.
     */
    @GetMapping("/all")
    public ResponseEntity<?> obtenerTematicas() {
        try {
            return ResponseEntity.ok(tematicaService.obtenerTematicas());
        } catch (Exception ex) {
            return handleException(ex);
        }
    }

    /**
     * Método para insertar una nueva temática.
     *
     * @param tematica La temática a insertar.
     * @return ResponseEntity con la nueva temática si se inserta correctamente, o un ResponseEntity con un mensaje de error en caso de fallo.
     */
    @PostMapping("/add")
    public ResponseEntity<?> insertarTematica(@RequestBody Tematica tematica){
        try {
            return ResponseEntity.ok(tematicaService.insertarTematica(tematica));
        } catch (Exception ex) {
            return handleException(ex);
        }
    }

    /**
     * Método para obtener una temática por su ID.
     *
     * @param id El ID de la temática a buscar.
     * @return ResponseEntity con la temática encontrada si existe, o un ResponseEntity con estado NOT_FOUND si no se encuentra la temática, o un ResponseEntity con un mensaje de error en caso de fallo.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerTematicaPorId(@PathVariable int id) {
        try {
            Tematica tematica = tematicaService.buscarTematicaPorId(id);
            return (tematica != null) ? ResponseEntity.ok(tematica) :  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tematica no encontrada");
        } catch (Exception ex) {
            return handleException(ex);
        }
    }

    /**
     * Método para eliminar una temática por su ID.
     *
     * @param id El ID de la temática a eliminar.
     * @return ResponseEntity con estado OK si se elimina correctamente, o un ResponseEntity con estado NOT_FOUND si no se encuentra la temática, o un ResponseEntity con un mensaje de error en caso de fallo.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTematica(@PathVariable int id) {
        try {
            Tematica tematica = tematicaService.buscarTematicaPorId(id);
            if (tematica != null) {
                tematicaService.eliminarTematica(id);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tematica no encontrada");
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


import com.ejercicios.springjpa.entities.Tematica;
import com.ejercicios.springjpa.services.TematicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar operaciones relacionadas con las temáticas.
 */
@RestController
@RequestMapping("/tematica")
public class TematicaControlador {
    @Autowired
    private TematicaService tematicaService; // Servicio para la lógica relacionada con las temáticas

    /**
     * Método para obtener todas las temáticas.
     *
     * @return ResponseEntity con la lista de temáticas si se obtienen correctamente, o un ResponseEntity con un mensaje de error en caso de fallo.
     */
    @GetMapping("/all")
    public ResponseEntity<?> obtenerTematicas() {
        try {
            return ResponseEntity.ok(tematicaService.obtenerTematicas());
        } catch (Exception ex) {
            return handleException(ex);
        }
    }

    /**
     * Método para insertar una nueva temática.
     *
     * @param tematica La temática a insertar.
     * @return ResponseEntity con la nueva temática si se inserta correctamente, o un ResponseEntity con un mensaje de error en caso de fallo.
     */
    @PostMapping("/add")
    public ResponseEntity<?> insertarTematica(@RequestBody Tematica tematica){
        try {
            return ResponseEntity.ok(tematicaService.insertarTematica(tematica));
        } catch (Exception ex) {
            return handleException(ex);
        }
    }

    /**
     * Método para obtener una temática por su ID.
     *
     * @param id El ID de la temática a buscar.
     * @return ResponseEntity con la temática encontrada si existe, o un ResponseEntity con estado NOT_FOUND si no se encuentra la temática, o un ResponseEntity con un mensaje de error en caso de fallo.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerTematicaPorId(@PathVariable int id) {
        try {
            Tematica tematica = tematicaService.buscarTematicaPorId(id);
            return (tematica != null) ? ResponseEntity.ok(tematica) :  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tematica no encontrada");
        } catch (Exception ex) {
            return handleException(ex);
        }
    }

    /**
     * Método para eliminar una temática por su ID.
     *
     * @param id El ID de la temática a eliminar.
     * @return ResponseEntity con estado OK si se elimina correctamente, o un ResponseEntity con estado NOT_FOUND si no se encuentra la temática, o un ResponseEntity con un mensaje de error en caso de fallo.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTematica(@PathVariable int id) {
        try {
            Tematica tematica = tematicaService.buscarTematicaPorId(id);
            if (tematica != null) {
                tematicaService.eliminarTematica(id);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tematica no encontrada");
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
