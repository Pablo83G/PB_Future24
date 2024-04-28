<<<<<<< HEAD
package com.springfw.ejercicios.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class People {
    private ArrayList<Person> listaPersonas;

    public People() {
        this.listaPersonas = new ArrayList<>();
        //Inicializa los objetos personas y los añade a la lista
        listaPersonas.add(new Person("00000000A","Jennifer","Madrigal","Perez", LocalDate.of(1992,9,19), "Femenino"));
        listaPersonas.add(new Person("11111111A","Nerea","Lopez","Perez", LocalDate.of(1972,11,29), "Femenino"));
        listaPersonas.add(new Person("22222222A","Jose","Montero","Garcia", LocalDate.of(2002,8,15), "Masculino"));
        listaPersonas.add(new Person("33333333A","Lucinio","Picazo","Dominguez", LocalDate.of(1998,7,17), "Masculino"));
        listaPersonas.add(new Person("44444444A","Ardanaz","Saiz","Perez", LocalDate.of(1992,8,27), "Masculino"));
        listaPersonas.add(new Person("55555555A","Carmen","Sevilla","Garcia", LocalDate.of(1980,5,20), "Femenino"));
        listaPersonas.add(new Person("66666666A","Julian","Monsalvez","Lorente", LocalDate.of(1978,2,22), "Masculino"));
        listaPersonas.add(new Person("77777777A","Emilia","Iranzo","Cabrera", LocalDate.of(1982,3,31), "Femenino"));
        listaPersonas.add(new Person("88888888A","Pablo","Rodriguez","Martinez", LocalDate.of(1999,4,11), "Masculino"));
        listaPersonas.add(new Person("99999999A","Angela","Gonzalez","Pla", LocalDate.of(1992,10,11), "Femenino"));
    }

    public List<Person> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(ArrayList<Person> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }
    public void addPerson(Person person){
       this.listaPersonas.add(person);
    }

}
=======
package com.springfw.ejercicios.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class People {
    private ArrayList<Person> listaPersonas;

    public People() {
        this.listaPersonas = new ArrayList<>();
        //Inicializa los objetos personas y los añade a la lista
        listaPersonas.add(new Person("00000000A","Jennifer","Madrigal","Perez", LocalDate.of(1992,9,19), "Femenino"));
        listaPersonas.add(new Person("11111111A","Nerea","Lopez","Perez", LocalDate.of(1972,11,29), "Femenino"));
        listaPersonas.add(new Person("22222222A","Jose","Montero","Garcia", LocalDate.of(2002,8,15), "Masculino"));
        listaPersonas.add(new Person("33333333A","Lucinio","Picazo","Dominguez", LocalDate.of(1998,7,17), "Masculino"));
        listaPersonas.add(new Person("44444444A","Ardanaz","Saiz","Perez", LocalDate.of(1992,8,27), "Masculino"));
        listaPersonas.add(new Person("55555555A","Carmen","Sevilla","Garcia", LocalDate.of(1980,5,20), "Femenino"));
        listaPersonas.add(new Person("66666666A","Julian","Monsalvez","Lorente", LocalDate.of(1978,2,22), "Masculino"));
        listaPersonas.add(new Person("77777777A","Emilia","Iranzo","Cabrera", LocalDate.of(1982,3,31), "Femenino"));
        listaPersonas.add(new Person("88888888A","Pablo","Rodriguez","Martinez", LocalDate.of(1999,4,11), "Masculino"));
        listaPersonas.add(new Person("99999999A","Angela","Gonzalez","Pla", LocalDate.of(1992,10,11), "Femenino"));
    }

    public List<Person> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(ArrayList<Person> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }
    public void addPerson(Person person){
       this.listaPersonas.add(person);
    }

}
>>>>>>> origin/main
