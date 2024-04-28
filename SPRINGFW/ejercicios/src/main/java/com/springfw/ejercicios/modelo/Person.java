package com.springfw.ejercicios.modelo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class Person {
    @Size(min=9, message = "The DNI must have 8 digits and one letter")
    private String dni;

    @NotNull(message = "Name cannot be null")
    @Size(min=2, message = "min 2 characters")
    private String name;
    @NotNull(message = "First Surname cannot be null")
    @Size(min=2, message = "min 2 characters")
    private String firstSurname;
    @NotNull(message = "Second Surname cannot be null")
    @Size(min=2, message = "min 2 characters")
    private String secondSurname;
    private String fullname;
    @NotNull(message = "birthday cannot be null")
    private LocalDate birthdate;
    @NotNull(message = "Sex cannot be null")
    @Size(min=2, message = "min 2 characters")
    private String sex;

    //CONSTRUCTOR POR DEFECTO
    public Person() {

    }
    //CONSTRUCTOR PARA EJERCICIO 1 Y 2
    public Person(String name, String firstSurname, String secondSurname, LocalDate birthdate, String sex) {
        this.name = name;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        this.birthdate = birthdate;
        this.sex = sex;
        this.fullname = this.getName()+" "+this.getFirstSurname()+" "+this.getSecondSurname();
    }

    //CONSTRUCTOR PARA EJERCICIO 3
    public Person(String dni, String name, String firstSurname, String secondSurname, LocalDate birthdate, String sex) {
        this.dni = dni;
        this.name = name;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        this.birthdate = birthdate;
        this.sex = sex;
        this.fullname = this.getName()+" "+this.getFirstSurname()+" "+this.getSecondSurname();
    }

    //GETTERS & SETTERS
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public void setFirstSurname(String firstSurname) {
        this.firstSurname = firstSurname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname() {//Se construye con una cadena y los datos del nombre y los apellidos

        this.fullname = this.getName()+" "+this.getFirstSurname()+" "+this.getSecondSurname();
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person:\n\"{" +
                "\n DNI:'" + dni + '\'' +
                "\n name:'" + name + '\'' +
                "\n firstSurname:'" + firstSurname + '\'' +
                "\n secondSurname:'" + secondSurname + '\'' +
                "\nfullname:'" + fullname + '\'' +
                "\n birthdate:" + birthdate +
                "\n sex:'" + sex + '\'' +
                '}';
    }
}
