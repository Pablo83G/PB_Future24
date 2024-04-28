<<<<<<< HEAD
package com.cleanCode.CCJen.ejercicio5.controller;

import com.cleanCode.CCJen.ejercicio5.Euromillones;
import com.cleanCode.CCJen.ejercicio5.Service.implem.EuroMillonServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashSet;
import java.util.Set;

@RestController
public class EuroMillonController {

    @Autowired
    EuroMillonServiceImp euroMillonServiceImp;

    /**
     * @return Nuevo objeto Euromillones inicializado.
     */
    @GetMapping("/euromillon")
    public Euromillones generarApuesta(){

        Set<Integer> numerosPrincipal=euroMillonServiceImp.generateNumbers(1,50,5);
        Set<Integer> numerosEstrella=euroMillonServiceImp.generateNumbers(1,12,2);
        Euromillones euromillones=new Euromillones(numerosPrincipal,numerosEstrella);

       return euromillones;
    }

}
=======
package com.cleanCode.CCJen.ejercicio5.controller;

import com.cleanCode.CCJen.ejercicio5.Euromillones;
import com.cleanCode.CCJen.ejercicio5.Service.implem.EuroMillonServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashSet;
import java.util.Set;

@RestController
public class EuroMillonController {

    @Autowired
    EuroMillonServiceImp euroMillonServiceImp;

    /**
     * @return Nuevo objeto Euromillones inicializado.
     */
    @GetMapping("/euromillon")
    public Euromillones generarApuesta(){

        Set<Integer> numerosPrincipal=euroMillonServiceImp.generateNumbers(1,50,5);
        Set<Integer> numerosEstrella=euroMillonServiceImp.generateNumbers(1,12,2);
        Euromillones euromillones=new Euromillones(numerosPrincipal,numerosEstrella);

       return euromillones;
    }

}
>>>>>>> origin/main
