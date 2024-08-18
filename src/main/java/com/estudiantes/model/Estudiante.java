package com.estudiantes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
// Boilerplate - Repetitivo
@Data                   // Getter y Setter
@NoArgsConstructor      // Constructor Vacío
@AllArgsConstructor     // Constructor con todos los argumentos
@ToString               // Mensaje con todos los datos
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstudiante;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
}
