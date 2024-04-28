<<<<<<< HEAD
package com.cleanCode.CCJen.ejercicio5.Service.implem;

import com.cleanCode.CCJen.ejercicio5.Service.EuroMillonService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
@Service
public class EuroMillonServiceImp implements EuroMillonService {

    /**
     * @param min numero menor rango
     * @param max numero mayor rango
     * @param amount cantidad de numeros a generar
     * @return Lista de numeros dentro del rango y cantidad especificada sin repeticiones
     */
    @Override
    public Set<Integer> generateNumbers(int min, int max, int amount) {

        //Comprobación para evitar bucle infinito
        if(amount > (max-min+1))
            throw new IllegalArgumentException("La cantidad de numeros no puede ser mayor al rango al no poder repetirse ");
        //creacion de variable retorno y generador
        Set<Integer>numbers=new LinkedHashSet<>();
        Random random = new Random();
        //bucle para crear la cantidad de numeros correspondientes, al ser Set no guardará el numero si ya esta repetido
        while (numbers.size()<amount){
            int num =random.nextInt(max-min+1)+min;
            numbers.add(num);
        }
        return numbers;
    }
}

=======
package com.cleanCode.CCJen.ejercicio5.Service.implem;

import com.cleanCode.CCJen.ejercicio5.Service.EuroMillonService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
@Service
public class EuroMillonServiceImp implements EuroMillonService {

    /**
     * @param min numero menor rango
     * @param max numero mayor rango
     * @param amount cantidad de numeros a generar
     * @return Lista de numeros dentro del rango y cantidad especificada sin repeticiones
     */
    @Override
    public Set<Integer> generateNumbers(int min, int max, int amount) {

        //Comprobación para evitar bucle infinito
        if(amount > (max-min+1))
            throw new IllegalArgumentException("La cantidad de numeros no puede ser mayor al rango al no poder repetirse ");
        //creacion de variable retorno y generador
        Set<Integer>numbers=new LinkedHashSet<>();
        Random random = new Random();
        //bucle para crear la cantidad de numeros correspondientes, al ser Set no guardará el numero si ya esta repetido
        while (numbers.size()<amount){
            int num =random.nextInt(max-min+1)+min;
            numbers.add(num);
        }
        return numbers;
    }
}

>>>>>>> origin/main
