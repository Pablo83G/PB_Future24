package com.ejercicios.springjpa.entities;

import jakarta.persistence.*;

import java.time.Year;

/**
 * Clase que representa la entidad Libro en la base de datos.
 */
@Entity(name="Libro") // Indica que esta clase es una entidad JPA con el nombre "Libro"
@Table(name="libro") // Especifica el nombre de la tabla en la base de datos
public class Libro {
    @Id // Indica que este atributo es la clave primaria de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Especifica la estrategia de generación de valores para la clave primaria
    @Column(
            name="idLibro",
            updatable = false
    )
    private  int idLibro; // Identificador único del libro

    @Column(
            name="ISBN",
            nullable = false,
            columnDefinition = "TEXT",
            unique = true
    )
    private String ISBN; // ISBN del libro

    @Column(
            name="titulo",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String Titulo; // Título del libro

    @Column(
            name="anioPublicacion",
            nullable = false,
            columnDefinition = "YEAR"
    )
    private Year fechaPublicacion; // Año de publicación del libro

    @ManyToOne // Relación many-to-one con la entidad Autor
    @JoinColumn(name="idAutor") // Columna en la tabla de libros que referencia al autor
    private Autor autor; // Autor del libro

    @ManyToOne // Relación many-to-one con la entidad Editorial
    @JoinColumn(name="idEditorial") // Columna en la tabla de libros que referencia a la editorial
    private Editorial editorial; // Editorial del libro

    @ManyToOne // Relación many-to-one con la entidad Tematica
    @JoinColumn(name="idTematica") // Columna en la tabla de libros que referencia a la temática
    private Tematica tematica; // Temática del libro

    /**
     * Constructor por defecto de la clase Libro.
     */
    public Libro() {
    }

    /**
     * Constructor de la clase Libro.
     *
     * @param ISBN ISBN del libro.
     * @param titulo Título del libro.
     * @param fechaPublicacion Año de publicación del libro.
     * @param autor Autor del libro.
     * @param editorial Editorial del libro.
     * @param tematica Temática del libro.
     */
    public Libro(String ISBN, String titulo, Year fechaPublicacion, Autor autor, Editorial editorial, Tematica tematica) {
        this.ISBN = ISBN;
        this.Titulo = titulo;
        this.fechaPublicacion = fechaPublicacion;
        this.autor = autor;
        this.editorial = editorial;
        this.tematica = tematica;
    }

    // Métodos getter y setter para los atributos de la clase Libro

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public Year getAnioPublicacion() {
        return fechaPublicacion;
    }

    public void setAnioPublicacion(Year anioPublicacion) {
        fechaPublicacion = anioPublicacion;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public Tematica getTematica() {
        return tematica;
    }

    public void setTematica(Tematica tematica) {
        this.tematica = tematica;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "idLibro=" + idLibro +
                ", ISBN='" + ISBN + '\'' +
                ", Titulo='" + Titulo + '\'' +
                ", AnioPublicacion=" + fechaPublicacion +
                ", autor=" + autor +
                ", editorial=" + editorial +
                ", tematica=" + tematica +
                '}';
    }
}

