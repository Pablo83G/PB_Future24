package com.springfw.ejercicios.services.implement;

import com.springfw.ejercicios.modelo.Person;
import com.springfw.ejercicios.modelo.People;
import com.springfw.ejercicios.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
@Service
public class PersonSeviceImplement implements PersonService {
    People personas = new People();//Objeto con ArrayList de personas


    @Override
    public Person getPerson() {
        return new Person("Jennifer", "Madrigal", "Perez", LocalDate.of(1992, 9, 19), "Femenino");
    }

    /**
     * @param dni
     * @return
     */
    @Override
    public ResponseEntity<Person> getPersonDni(String dni) {
        for(Person returnPerson : personas.getListaPersonas()){
            if(returnPerson.getDni().equals(dni)){
                return new ResponseEntity<Person>(returnPerson, HttpStatus.OK);
            }
        }
        //Si no ha encontrado coincidencia devuelve un 204@
        return new ResponseEntity<Person>(HttpStatus.NO_CONTENT);
    }

    /**
     * @param personData
     */
    @Override
    public void addNewPerson(Person personData) {
        personas.addPerson(personData);
    }

    /**
     * @param newDataPerson
     * @param dni
     * @return
     */
    @Override
    public ResponseEntity updatePerson(Person newDataPerson, String dni) {
        for(Person persona : personas.getListaPersonas()){
            if(persona.getDni().equals(dni)){
                persona.setName(newDataPerson.getName());
                persona.setFirstSurname(newDataPerson.getFirstSurname());
                persona.setSecondSurname(newDataPerson.getSecondSurname());
                persona.setBirthdate(newDataPerson.getBirthdate());
                persona.setSex(newDataPerson.getSex());
                persona.setFullname();
                //OK devuelve un 200
                return new ResponseEntity( HttpStatus.OK);
            }
        }
        //Si no ha encontrado coincidencia devuelve un 204
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
