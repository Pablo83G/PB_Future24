<<<<<<< HEAD
package com.ejercicios.springjpa.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
/**
 * Clase que representa la entidad Autor en la base de datos.
 */
@Entity(name="Autor") // Indica que esta clase es una entidad JPA con el nombre "Autor"
@Table(name="autor") // Especifica el nombre de la tabla en la base de datos
public class Autor {
    @Id // Indica que este atributo es la clave primaria de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Especifica la estrategia de generación de valores para la clave primaria
    @Column(
            name="idAutor",
            updatable = false
    )
    private  int idAutor; // Identificador único del autor

    @Column(
            name="nombre",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String nombre; // Nombre del autor

    @Column(
            name="apellidos",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String apellidos; // Apellidos del autor

    @Column(
            name="fecha_nac",
            columnDefinition = "DATE"
    )
    private LocalDate fecha_nac; // Fecha de nacimiento del autor

    /**
     * Constructor por defecto de la clase Autor.
     */
    public Autor() {

    }

    /**
     * Constructor de la clase Autor.
     *
     * @param nombre Nombre del autor.
     * @param apellidos Apellidos del autor.
     * @param fecha_nac Fecha de nacimiento del autor.
     */
    public Autor(String nombre, String apellidos, LocalDate fecha_nac) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_nac = fecha_nac;
    }

    // Métodos getter y setter para los atributos de la clase Autor

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(LocalDate fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + idAutor +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fecha_nac=" + fecha_nac +
                '}';
    }
}

=======
package com.ejercicios.springjpa.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
/**
 * Clase que representa la entidad Autor en la base de datos.
 */
@Entity(name="Autor") // Indica que esta clase es una entidad JPA con el nombre "Autor"
@Table(name="autor") // Especifica el nombre de la tabla en la base de datos
public class Autor {
    @Id // Indica que este atributo es la clave primaria de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Especifica la estrategia de generación de valores para la clave primaria
    @Column(
            name="idAutor",
            updatable = false
    )
    private  int idAutor; // Identificador único del autor

    @Column(
            name="nombre",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String nombre; // Nombre del autor

    @Column(
            name="apellidos",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String apellidos; // Apellidos del autor

    @Column(
            name="fecha_nac",
            columnDefinition = "DATE"
    )
    private LocalDate fecha_nac; // Fecha de nacimiento del autor

    /**
     * Constructor por defecto de la clase Autor.
     */
    public Autor() {

    }

    /**
     * Constructor de la clase Autor.
     *
     * @param nombre Nombre del autor.
     * @param apellidos Apellidos del autor.
     * @param fecha_nac Fecha de nacimiento del autor.
     */
    public Autor(String nombre, String apellidos, LocalDate fecha_nac) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_nac = fecha_nac;
    }

    // Métodos getter y setter para los atributos de la clase Autor

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(LocalDate fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + idAutor +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fecha_nac=" + fecha_nac +
                '}';
    }
}

>>>>>>> origin/main
