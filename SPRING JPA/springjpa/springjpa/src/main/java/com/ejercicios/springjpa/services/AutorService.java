package com.ejercicios.springjpa.services;

import com.ejercicios.springjpa.entities.Autor;
import com.ejercicios.springjpa.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {
    /**
     * Clase de servicio para manejar operaciones relacionadas con autores.
     */
    @Autowired // Inyección de dependencia de AutorRepository en AutorService
    private AutorRepository autorRepository; // Repositorio para la entidad Autor

    /**
     * Constructor por defecto de la clase AutorService.
     */
    public AutorService() {

    }

    /**
     * Inserta un nuevo autor en la base de datos.
     *
     * @param autor El autor a insertar.
     * @return El autor insertado.
     */
    public Autor insertarAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    /**
     * Obtiene todos los autores de la base de datos.
     *
     * @return Una lista de todos los autores.
     */
    public List<Autor> obtenerAutores() {
        return autorRepository.findAll();
    }

    /**
     * Elimina un autor de la base de datos por su ID.
     *
     * @param id El ID del autor a eliminar.
     */
    public void eliminarAutor(int id) {
        autorRepository.deleteById(id);
    }

    /**
     * Busca un autor en la base de datos por su ID.
     *
     * @param id El ID del autor a buscar.
     * @return El autor encontrado, o null si no se encuentra.
     */
    public Autor buscarAutorPorId(int id) {
        Optional<Autor> optionalAutor = autorRepository.findById(id);
        return optionalAutor.orElse(null);
    }

}
