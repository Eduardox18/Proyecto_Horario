-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema horario
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema horario
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `horario` DEFAULT CHARACTER SET utf8 ;
USE `horario` ;

-- -----------------------------------------------------
-- Table `horario`.`Profesor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `horario`.`Profesor` (
  `idProfesor` INT NOT NULL AUTO_INCREMENT,
  `nombreProfesor` VARCHAR(45) NOT NULL,
  `apPaternoProfesor` VARCHAR(45) NOT NULL,
  `apMaternoProfesor` VARCHAR(45) NULL,
  `emailProfesor` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idProfesor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `horario`.`Horario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `horario`.`Horario` (
  `idHorario` INT NOT NULL AUTO_INCREMENT,
  `horaInicioHorario` VARCHAR(10) NOT NULL,
  `horaFinHorario` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idHorario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `horario`.`ExperienciaEducativa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `horario`.`ExperienciaEducativa` (
  `nrc` INT NOT NULL,
  `nombreEE` VARCHAR(45) NOT NULL,
  `creditosEE` INT NULL,
  PRIMARY KEY (`nrc`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `horario`.`SalonClases`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `horario`.`SalonClases` (
  `idSalonClases` INT NOT NULL AUTO_INCREMENT,
  `noSalonClases` INT NOT NULL,
  PRIMARY KEY (`idSalonClases`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `horario`.`Alumno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `horario`.`Alumno` (
  `matricula` VARCHAR(9) NOT NULL,
  `nombreAlumno` VARCHAR(45) NOT NULL,
  `apPaternoAlumno` VARCHAR(45) NOT NULL,
  `apMaternoAlumno` VARCHAR(45) NULL,
  `fechaNacAlumno` VARCHAR(45) NOT NULL,
  `emailAlumno` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`matricula`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `horario`.`Profesor_has_ExperienciaEducativa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `horario`.`Profesor_has_ExperienciaEducativa` (
  `Profesor_noPersonal` INT NOT NULL,
  `ExperienciaEducativa_nrc` INT NOT NULL,
  PRIMARY KEY (`Profesor_noPersonal`, `ExperienciaEducativa_nrc`),
  INDEX `fk_Profesor_has_ExperienciaEducativa_ExperienciaEducativa1_idx` (`ExperienciaEducativa_nrc` ASC),
  INDEX `fk_Profesor_has_ExperienciaEducativa_Profesor_idx` (`Profesor_noPersonal` ASC),
  CONSTRAINT `fk_Profesor_has_ExperienciaEducativa_Profesor`
    FOREIGN KEY (`Profesor_noPersonal`)
    REFERENCES `horario`.`Profesor` (`idProfesor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Profesor_has_ExperienciaEducativa_ExperienciaEducativa1`
    FOREIGN KEY (`ExperienciaEducativa_nrc`)
    REFERENCES `horario`.`ExperienciaEducativa` (`nrc`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `horario`.`Horario_has_ExperienciaEducativa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `horario`.`Horario_has_ExperienciaEducativa` (
  `Horario_idHorario` INT NOT NULL,
  `ExperienciaEducativa_nrc` INT NOT NULL,
  PRIMARY KEY (`Horario_idHorario`, `ExperienciaEducativa_nrc`),
  INDEX `fk_Horario_has_ExperienciaEducativa_ExperienciaEducativa1_idx` (`ExperienciaEducativa_nrc` ASC),
  INDEX `fk_Horario_has_ExperienciaEducativa_Horario1_idx` (`Horario_idHorario` ASC),
  CONSTRAINT `fk_Horario_has_ExperienciaEducativa_Horario1`
    FOREIGN KEY (`Horario_idHorario`)
    REFERENCES `horario`.`Horario` (`idHorario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Horario_has_ExperienciaEducativa_ExperienciaEducativa1`
    FOREIGN KEY (`ExperienciaEducativa_nrc`)
    REFERENCES `horario`.`ExperienciaEducativa` (`nrc`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `horario`.`ExperienciaEducativa_has_Alumno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `horario`.`ExperienciaEducativa_has_Alumno` (
  `ExperienciaEducativa_nrc` INT NOT NULL,
  `Alumno_matricula` VARCHAR(9) NOT NULL,
  PRIMARY KEY (`ExperienciaEducativa_nrc`, `Alumno_matricula`),
  INDEX `fk_ExperienciaEducativa_has_Alumno_Alumno1_idx` (`Alumno_matricula` ASC),
  INDEX `fk_ExperienciaEducativa_has_Alumno_ExperienciaEducativa1_idx` (`ExperienciaEducativa_nrc` ASC),
  CONSTRAINT `fk_ExperienciaEducativa_has_Alumno_ExperienciaEducativa1`
    FOREIGN KEY (`ExperienciaEducativa_nrc`)
    REFERENCES `horario`.`ExperienciaEducativa` (`nrc`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ExperienciaEducativa_has_Alumno_Alumno1`
    FOREIGN KEY (`Alumno_matricula`)
    REFERENCES `horario`.`Alumno` (`matricula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `horario`.`ExperienciaEducativa_has_SalonClases`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `horario`.`ExperienciaEducativa_has_SalonClases` (
  `ExperienciaEducativa_nrc` INT NOT NULL,
  `SalonClases_idSalonClases` INT NOT NULL,
  PRIMARY KEY (`ExperienciaEducativa_nrc`, `SalonClases_idSalonClases`),
  INDEX `fk_ExperienciaEducativa_has_SalonClases_SalonClases1_idx` (`SalonClases_idSalonClases` ASC),
  INDEX `fk_ExperienciaEducativa_has_SalonClases_ExperienciaEducativ_idx` (`ExperienciaEducativa_nrc` ASC),
  CONSTRAINT `fk_ExperienciaEducativa_has_SalonClases_ExperienciaEducativa1`
    FOREIGN KEY (`ExperienciaEducativa_nrc`)
    REFERENCES `horario`.`ExperienciaEducativa` (`nrc`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ExperienciaEducativa_has_SalonClases_SalonClases1`
    FOREIGN KEY (`SalonClases_idSalonClases`)
    REFERENCES `horario`.`SalonClases` (`idSalonClases`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `horario`.`Profesor_has_ExperienciaEducativa1`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `horario`.`Profesor_has_ExperienciaEducativa1` (
  `Profesor_idProfesor` INT NOT NULL,
  `ExperienciaEducativa_nrc` INT NOT NULL,
  PRIMARY KEY (`Profesor_idProfesor`, `ExperienciaEducativa_nrc`),
  INDEX `fk_Profesor_has_ExperienciaEducativa1_ExperienciaEducativa1_idx` (`ExperienciaEducativa_nrc` ASC),
  INDEX `fk_Profesor_has_ExperienciaEducativa1_Profesor1_idx` (`Profesor_idProfesor` ASC),
  CONSTRAINT `fk_Profesor_has_ExperienciaEducativa1_Profesor1`
    FOREIGN KEY (`Profesor_idProfesor`)
    REFERENCES `horario`.`Profesor` (`idProfesor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Profesor_has_ExperienciaEducativa1_ExperienciaEducativa1`
    FOREIGN KEY (`ExperienciaEducativa_nrc`)
    REFERENCES `horario`.`ExperienciaEducativa` (`nrc`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `horario`.`Dia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `horario`.`Dia` (
  `idDia` INT NOT NULL AUTO_INCREMENT,
  `nombreDia` VARCHAR(20) NULL,
  PRIMARY KEY (`idDia`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `horario`.`Horario_has_Dia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `horario`.`Horario_has_Dia` (
  `Horario_idHorario` INT NOT NULL,
  `Dia_idDia` INT NOT NULL,
  PRIMARY KEY (`Horario_idHorario`, `Dia_idDia`),
  INDEX `fk_Horario_has_Dia_Dia1_idx` (`Dia_idDia` ASC),
  INDEX `fk_Horario_has_Dia_Horario1_idx` (`Horario_idHorario` ASC),
  CONSTRAINT `fk_Horario_has_Dia_Horario1`
    FOREIGN KEY (`Horario_idHorario`)
    REFERENCES `horario`.`Horario` (`idHorario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Horario_has_Dia_Dia1`
    FOREIGN KEY (`Dia_idDia`)
    REFERENCES `horario`.`Dia` (`idDia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
