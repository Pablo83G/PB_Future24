package com.springfw.ejercicios.controlador;

import com.springfw.ejercicios.modelo.Person;
import com.springfw.ejercicios.modelo.People;
import com.springfw.ejercicios.services.implement.PersonSeviceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController

public class PersonController {

    Person personaForm;
    @Autowired
    PersonSeviceImplement personService=new PersonSeviceImplement();

    @GetMapping("/person")
    public ResponseEntity <Person> getPerson(){
        Person persona=personService.getPerson();
        return new ResponseEntity<Person>(persona, HttpStatus.OK);
    }
    @GetMapping("/person/{dni}")
    public ResponseEntity <Person> getPersonDni(@Validated @PathVariable String dni){

        return  personService.getPersonDni(dni);
    }
    @PostMapping("/envioFormulario")
    public ResponseEntity createNewPerson(
            @Validated
            @RequestParam (value="nombre") String name,
            @RequestParam (value="apellido1") String firstSurname,
            @RequestParam (value="apellido2") String secondSurname,
            @RequestParam (value="fechaNacimiento") LocalDate birthdate,
            @RequestParam (value="sexo") String sex)
        {
        //Inicializa el objeto
        personaForm= new Person(name,firstSurname,secondSurname,birthdate,sex);
        personService.addNewPerson(personaForm);
        //Devuelve por consola los datos del objeto creado
            System.out.println( personaForm.toString());//he creado un metodo toString para devolver por consola los datos del objeto creado
        return new ResponseEntity( HttpStatus.OK);
    }

    @PutMapping(path="/person/{dni}",
                consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updatePerson(@Validated @RequestBody Person newDataPerson, @PathVariable String dni){

        return personService.updatePerson(newDataPerson, dni);
    }

}

