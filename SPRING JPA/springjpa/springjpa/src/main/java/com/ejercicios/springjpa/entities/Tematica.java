package com.ejercicios.springjpa.entities;

import jakarta.persistence.*;
/**
 * Clase que representa la entidad Tematica en la base de datos.
 */
@Entity(name="Tematica") // Indica que esta clase es una entidad JPA con el nombre "Tematica"
@Table(name="tematica") // Especifica el nombre de la tabla en la base de datos
public class Tematica {
    @Id // Indica que este atributo es la clave primaria de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Especifica la estrategia de generación de valores para la clave primaria
    @Column(
            name="idTematica",
            updatable = false
    )
    private  int idTematica; // Identificador único de la temática

    @Column(
            name="nombre",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String nombre; // Nombre de la temática

    /**
     * Constructor por defecto de la clase Tematica.
     */
    public Tematica() {
    }

    /**
     * Constructor de la clase Tematica.
     *
     * @param nombre Nombre de la temática.
     */
    public Tematica(String nombre) {
        this.nombre = nombre;
    }

    // Métodos getter y setter para los atributos de la clase Tematica


    public int getIdTematica() {
        return idTematica;
    }

    public void setIdTematica(int idTematica) {
        this.idTematica = idTematica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Tematica{" +
                "id=" + idTematica +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
