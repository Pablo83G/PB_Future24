package com.ejercicios.springjpa;

import com.ejercicios.springjpa.entities.Autor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringjpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringjpaApplication.class, args);
	}
	/*
	@Bean
	CommandLineRunner commandLineRunner(AutorRepository autorRepository){
		return args -> {/*
			Autor autor = new Autor(
					"FRANCISCO",
					"DIAZ DIAZ",
					LocalDate.parse("1982-06-22")
			);
			autorRepository.save(autor);
		};
	List<Autor> autores = new ArrayList<>();
	Autor autor1 = new Autor(
			"FRANCISCO",
			"DIAZ DIAZ",
			LocalDate.parse("1982-06-22")
	);
	Autor autor2 = new Autor(
			"ALBERTO",
			"MIGUELEZ LOPEZ",
			LocalDate.parse("1992-06-12")
	);
	Autor autor3 = new Autor(
			"RAUL",
			"OCHANDIANO RIVERA",
			LocalDate.parse("1956-10-12")
	);
			autores.add(autor1);
			autores.add(autor2);
			autores.add(autor3);
			autorRepository.saveAll(autores);
};*/
}
