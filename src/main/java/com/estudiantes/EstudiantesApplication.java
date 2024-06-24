package com.estudiantes;

import com.estudiantes.model.Estudiante;
import com.estudiantes.service.EstudianteServicio;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
// Agregamos [implements CommandLineRunner] que nos permite ejecución a nivel de la consola
public class EstudiantesApplication implements CommandLineRunner {

	@Autowired
	private EstudianteServicio estudianteServicio;

	//Para enviar mensajes ah nivel de consola
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

		var salir = false;
		var consola = new Scanner(System.in);

		while (!salir){
			mostrarMenu();
			salir = ejecutarOpcion(consola);
			logger.info(nl);
		}
		logger.info(nl);
	}

	private void mostrarMenu(){
		logger.info(nl);
		logger.info("""
				|----------------------------|
				|  SISTEMA DE ESTUDIANTES 🤓 |
				|----------------------------|
				| [1] - Listar Estudiantes   |
				| [2] - Buscar Estudiante    |
				| [3] - Agregar Estudiante   |
				| [4] - Modificar Estudiante |
				| [5] - Eliminar Estudiante  |
				| [6] - Salir del APP        |
				|----------------------------|
				| Ingrese una opción: """);
	}

	private boolean ejecutarOpcion(Scanner consola){
		var opcion = Integer.parseInt(consola.nextLine());
		var salir = false;

		switch (opcion){
			case 1 -> {
				logger.info(nl+"|-----------------LISTADO DE ESTUDIANTES-------------------------|"+nl);
				List<Estudiante> estudianntes = estudianteServicio.listarEstudiantes();
				estudianntes.forEach((estudiante -> logger.info(estudiante.toString()+nl)));
			}
			case 2 -> {
				logger.info("| Ingrese el ID de estudiante a buscar: ");
				var idEstuiante = Integer.parseInt(consola.nextLine());
				Estudiante estudiante = estudianteServicio.buscarEstudiantePorId(idEstuiante);
				if(estudiante != null){
					logger.info("Estudiante encontrado: "+estudiante + nl);
				}else{
					logger.info("Estudiante No encontrado con ID: "+idEstuiante + nl);
				}
			}
			case 3 -> {
				logger.info("| Ingrese datos de nuevo Estudiante: "+nl);
				logger.info("| Nombre: ");
				var nombre = consola.nextLine();
				logger.info("| Apellido: ");
				var apellido = consola.nextLine();
				logger.info("| Teléfono: ");
				var telefono = consola.nextLine();
				logger.info("| Email: ");
				var email = consola.nextLine();

				var nuevoEstudiante = new Estudiante();
				nuevoEstudiante.setNombre(nombre);
				nuevoEstudiante.setApellido(apellido);
				nuevoEstudiante.setTelefono(telefono);
				nuevoEstudiante.setEmail(email);

				estudianteServicio.guardarEstudiante(nuevoEstudiante);
				logger.info("Estudiante registrado correctamente: "+nuevoEstudiante+nl);
			}
			case 4 -> {
				logger.info("| Modificar Estudiante: "+nl);
				logger.info("| ID de Estudiante: ");
				var idEstudiante = Integer.parseInt(consola.nextLine());
				Estudiante estudiante = estudianteServicio.buscarEstudiantePorId(idEstudiante);
				if(estudiante != null){
					logger.info("| Nombre: ");
					var nombre = consola.nextLine();
					logger.info("| Apellido: ");
					var apellido = consola.nextLine();
					logger.info("| Teléfono: ");
					var telefono = consola.nextLine();
					logger.info("| Email: ");
					var email = consola.nextLine();
					estudiante.setNombre(nombre);
					estudiante.setApellido(apellido);
					estudiante.setTelefono(telefono);
					estudiante.setEmail(email);
					estudianteServicio.guardarEstudiante(estudiante);
					logger.info("Datos Actualizados: "+estudiante+nl);

				}else{
					logger.info("Estudiante NO encontrado con ID: "+idEstudiante+nl);
				}
			}
			case 5 -> {
				logger.info("| Eliminar Estudiante: "+nl);
				logger.info("| ID Estudiante: ");
				var idEstudiante = Integer.parseInt(consola.nextLine());

				var estudiante = estudianteServicio.buscarEstudiantePorId(idEstudiante);
				if(estudiante != null){
					estudianteServicio.eliminarEstudiante(estudiante);
					logger.info("Estudiante eliminado: "+estudiante+nl);
				}else{
					logger.info("Estudiante NO encontrado con ID: "+ idEstudiante + nl);
				}
			}
			case 6 -> {
				salir = true;
				logger.info("""
						|------------------------------|
						| GRACIAS POR USAR NUESTRA APP |
						|       HASTA PRONTO!!!        |
						|------------------------------|""");
			}
			default -> {
				logger.info("La opción NO reconocida: "+opcion);
			}
		}
		return salir;
	}
}
