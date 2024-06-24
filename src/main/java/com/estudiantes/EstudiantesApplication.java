package com.estudiantes;

import com.estudiantes.service.EstudianteServicio;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// Agregamos [implements CommandLineRunner] que nos permite ejecución a nivel de la consola
public class EstudiantesApplication implements CommandLineRunner {

	@Autowired
	private EstudianteServicio estudianteServicio;

	//Para enviar mensaje a nivel de la consola
	private static final Logger logger = LoggerFactory.getLogger(EstudiantesApplication.class);

	String nl = System.lineSeparator();

	public static void main(String[] args) {
		logger.info("Iniciando la Aplicación con Spring....");

		//Levanta la fabrica de Spring
		SpringApplication.run(EstudiantesApplication.class, args);

		logger.info("Aplicación finalizada...");
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Se esta ejecutando la aplicación..."+nl);
	}
}
