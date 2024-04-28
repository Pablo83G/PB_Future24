package com.springfw.ejercicios.services;

import com.springfw.ejercicios.modelo.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface PersonService {
    Person getPerson();
    ResponseEntity<Person> getPersonDni(@PathVariable String dni);
    void addNewPerson( Person personData);
    ResponseEntity updatePerson(@RequestBody Person newDataPerson, @PathVariable String dni);

}
