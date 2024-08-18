-- CREAMOS LA BASE DE DATOS
CREATE SCHEMA `estudiantes_db` ;

-- Usamos la Base de datos Creada
USE estudiantes_db

-- CREAMOS LAS TABLAS EN LA BASE DE DATOS
CREATE TABLE `estudiantes_db`.`estudiante` (
  `id_estudiante` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  PRIMARY KEY (`id_estudiante`));