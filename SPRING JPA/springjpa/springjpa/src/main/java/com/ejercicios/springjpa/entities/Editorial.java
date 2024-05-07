package com.ejercicios.springjpa.entities;

import jakarta.persistence.*;
/**
 * Clase que representa la entidad Editorial en la base de datos.
 */
@Entity(name="Editorial") // Indica que esta clase es una entidad JPA con el nombre "Editorial"
@Table(name="editorial") // Especifica el nombre de la tabla en la base de datos
public class Editorial {
    @Id // Indica que este atributo es la clave primaria de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Especifica la estrategia de generación de valores para la clave primaria
    @Column(
            name="idEditorial",
            updatable = false
    )
    private  int idEditorial; // Identificador único de la editorial

    @Column(
            name="nombre",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String nombre; // Nombre de la editorial

    @Column(
            name="razonSocial",
            columnDefinition = "TEXT"
    )
    private String razonSocial; // Razón social de la editorial

    /**
     * Constructor por defecto de la clase Editorial.
     */
    public Editorial() {
    }

    /**
     * Constructor de la clase Editorial.
     *
     * @param nombre Nombre de la editorial.
     * @param razonSocial Razón social de la editorial.
     */
    public Editorial(String nombre, String razonSocial) {
        this.nombre = nombre;
        this.razonSocial = razonSocial;
    }

    // Métodos getter y setter para los atributos de la clase Editorial

    public int getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(int idEditorial) {
        this.idEditorial = idEditorial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    @Override
    public String toString() {
        return "Editorial{" +
                "id=" + idEditorial +
                ", nombre='" + nombre + '\'' +
                ", razonSocial='" + razonSocial + '\'' +
                '}';
    }
}
