package com.ejercicios.springjpa.services;


import com.ejercicios.springjpa.entities.Editorial;
import com.ejercicios.springjpa.repositories.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Clase de servicio para manejar operaciones relacionadas con editoriales.
 */
@Service // Indica que esta clase es un servicio de Spring
public class EditorialService {
    @Autowired // Inyección de dependencia de EditorialRepository en EditorialService
    private EditorialRepository editorialRepository; // Repositorio para la entidad Editorial

    /**
     * Constructor por defecto de la clase EditorialService.
     */
    public EditorialService() {
        // Constructor por defecto
    }

    /**
     * Inserta una nueva editorial en la base de datos.
     *
     * @param editorial La editorial a insertar.
     * @return La editorial insertada.
     */
    public Editorial insertarEditorial(Editorial editorial){
        return editorialRepository.save(editorial);
    }

    /**
     * Obtiene todas las editoriales de la base de datos.
     *
     * @return Una lista de todas las editoriales.
     */
    public List<Editorial> obtenerEditoriales(){
        return editorialRepository.findAll();
    }

    /**
     * Elimina una editorial de la base de datos por su ID.
     *
     * @param id El ID de la editorial a eliminar.
     */
    public void eliminarEditorial(int id){
        editorialRepository.deleteById(id);
    }

    /**
     * Busca una editorial en la base de datos por su ID.
     *
     * @param id El ID de la editorial a buscar.
     * @return La editorial encontrada, o null si no se encuentra.
     */
    public Editorial buscarEditorialPorId(int id){
        Optional<Editorial> optionalEditorial = editorialRepository.findById(id);
        return optionalEditorial.orElse(null);
    }
}


