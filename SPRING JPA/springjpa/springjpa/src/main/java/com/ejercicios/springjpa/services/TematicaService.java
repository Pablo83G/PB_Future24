package com.ejercicios.springjpa.services;

import com.ejercicios.springjpa.entities.Tematica;
import com.ejercicios.springjpa.repositories.TematicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Clase de servicio para manejar operaciones relacionadas con temáticas.
 */
@Service // Indica que esta clase es un servicio de Spring
public class TematicaService {
    @Autowired // Inyección de dependencia de TematicaRepository en TematicaService
    TematicaRepository tematicaRepository;

    /**
     * Constructor por defecto de la clase TematicaService.
     */
    public TematicaService(){
        // Constructor por defecto
    }

    /**
     * Inserta una nueva temática en la base de datos.
     *
     * @param tematica La temática a insertar.
     * @return La temática insertada.
     */
    public Tematica insertarTematica(Tematica tematica){
        return tematicaRepository.save(tematica);
    }

    /**
     * Obtiene todas las temáticas de la base de datos.
     *
     * @return Una lista de todas las temáticas.
     */
    public List<Tematica> obtenerTematicas(){
        return tematicaRepository.findAll();
    }

    /**
     * Elimina una temática de la base de datos por su ID.
     *
     * @param id El ID de la temática a eliminar.
     */
    public void eliminarTematica(int id){
        tematicaRepository.deleteById(id);
    }

    /**
     * Busca una temática en la base de datos por su ID.
     *
     * @param id El ID de la temática a buscar.
     * @return La temática encontrada, o null si no se encuentra.
     */
    public Tematica buscarTematicaPorId(int id){
        Optional<Tematica> optionalTematica = tematicaRepository.findById(id);
        return optionalTematica.orElse(null);
    }
}

