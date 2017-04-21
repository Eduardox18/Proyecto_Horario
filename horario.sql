-- MySQL dump 10.13  Distrib 5.7.18, for macos10.12 (x86_64)
--
-- Host: localhost    Database: horario
-- ------------------------------------------------------
-- Server version	5.7.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Alumno`
--

DROP TABLE IF EXISTS `Alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Alumno` (
  `matricula` varchar(9) NOT NULL,
  `nombreAlumno` varchar(45) NOT NULL,
  `apPaternoAlumno` varchar(45) NOT NULL,
  `apMaternoAlumno` varchar(45) DEFAULT NULL,
  `fechaNacAlumno` varchar(45) NOT NULL,
  `emailAlumno` varchar(45) NOT NULL,
  PRIMARY KEY (`matricula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Alumno`
--

LOCK TABLES `Alumno` WRITE;
/*!40000 ALTER TABLE `Alumno` DISABLE KEYS */;
/*!40000 ALTER TABLE `Alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Dia`
--

DROP TABLE IF EXISTS `Dia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Dia` (
  `idDia` int(11) NOT NULL AUTO_INCREMENT,
  `nombreDia` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idDia`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Dia`
--

LOCK TABLES `Dia` WRITE;
/*!40000 ALTER TABLE `Dia` DISABLE KEYS */;
INSERT INTO `Dia` VALUES (1,'Lunes'),(2,'Martes'),(3,'Miércoles'),(4,'Jueves'),(5,'Viernes'),(6,'Sábado'),(7,'Domingo');
/*!40000 ALTER TABLE `Dia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ExperienciaEducativa`
--

DROP TABLE IF EXISTS `ExperienciaEducativa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ExperienciaEducativa` (
  `nrc` int(11) NOT NULL,
  `nombreEE` varchar(45) NOT NULL,
  `creditosEE` int(11) DEFAULT NULL,
  PRIMARY KEY (`nrc`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ExperienciaEducativa`
--

LOCK TABLES `ExperienciaEducativa` WRITE;
/*!40000 ALTER TABLE `ExperienciaEducativa` DISABLE KEYS */;
INSERT INTO `ExperienciaEducativa` VALUES (28391,'Redes',10),(38492,'Programación',10),(67890,'Sistemas Operativos',9);
/*!40000 ALTER TABLE `ExperienciaEducativa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ExperienciaEducativa_has_Alumno`
--

DROP TABLE IF EXISTS `ExperienciaEducativa_has_Alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ExperienciaEducativa_has_Alumno` (
  `ExperienciaEducativa_nrc` int(11) NOT NULL,
  `Alumno_matricula` varchar(9) NOT NULL,
  PRIMARY KEY (`ExperienciaEducativa_nrc`,`Alumno_matricula`),
  KEY `fk_ExperienciaEducativa_has_Alumno_Alumno1_idx` (`Alumno_matricula`),
  KEY `fk_ExperienciaEducativa_has_Alumno_ExperienciaEducativa1_idx` (`ExperienciaEducativa_nrc`),
  CONSTRAINT `fk_ExperienciaEducativa_has_Alumno_Alumno1` FOREIGN KEY (`Alumno_matricula`) REFERENCES `Alumno` (`matricula`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ExperienciaEducativa_has_Alumno_ExperienciaEducativa1` FOREIGN KEY (`ExperienciaEducativa_nrc`) REFERENCES `ExperienciaEducativa` (`nrc`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ExperienciaEducativa_has_Alumno`
--

LOCK TABLES `ExperienciaEducativa_has_Alumno` WRITE;
/*!40000 ALTER TABLE `ExperienciaEducativa_has_Alumno` DISABLE KEYS */;
/*!40000 ALTER TABLE `ExperienciaEducativa_has_Alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ExperienciaEducativa_has_SalonClases`
--

DROP TABLE IF EXISTS `ExperienciaEducativa_has_SalonClases`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ExperienciaEducativa_has_SalonClases` (
  `ExperienciaEducativa_nrc` int(11) NOT NULL,
  `SalonClases_idSalonClases` int(11) NOT NULL,
  PRIMARY KEY (`ExperienciaEducativa_nrc`,`SalonClases_idSalonClases`),
  KEY `fk_ExperienciaEducativa_has_SalonClases_SalonClases1_idx` (`SalonClases_idSalonClases`),
  KEY `fk_ExperienciaEducativa_has_SalonClases_ExperienciaEducativ_idx` (`ExperienciaEducativa_nrc`),
  CONSTRAINT `fk_ExperienciaEducativa_has_SalonClases_ExperienciaEducativa1` FOREIGN KEY (`ExperienciaEducativa_nrc`) REFERENCES `ExperienciaEducativa` (`nrc`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ExperienciaEducativa_has_SalonClases_SalonClases1` FOREIGN KEY (`SalonClases_idSalonClases`) REFERENCES `SalonClases` (`idSalonClases`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ExperienciaEducativa_has_SalonClases`
--

LOCK TABLES `ExperienciaEducativa_has_SalonClases` WRITE;
/*!40000 ALTER TABLE `ExperienciaEducativa_has_SalonClases` DISABLE KEYS */;
INSERT INTO `ExperienciaEducativa_has_SalonClases` VALUES (28391,1),(67890,2);
/*!40000 ALTER TABLE `ExperienciaEducativa_has_SalonClases` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Horario`
--

DROP TABLE IF EXISTS `Horario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Horario` (
  `idHorario` int(11) NOT NULL AUTO_INCREMENT,
  `horaInicioHorario` varchar(10) NOT NULL,
  `horaFinHorario` varchar(10) NOT NULL,
  PRIMARY KEY (`idHorario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Horario`
--

LOCK TABLES `Horario` WRITE;
/*!40000 ALTER TABLE `Horario` DISABLE KEYS */;
INSERT INTO `Horario` VALUES (1,'7:00','9:00'),(2,'9:00','11:00');
/*!40000 ALTER TABLE `Horario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Horario_has_Dia`
--

DROP TABLE IF EXISTS `Horario_has_Dia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Horario_has_Dia` (
  `Horario_idHorario` int(11) NOT NULL,
  `Dia_idDia` int(11) NOT NULL,
  PRIMARY KEY (`Horario_idHorario`,`Dia_idDia`),
  KEY `fk_Horario_has_Dia_Dia1_idx` (`Dia_idDia`),
  KEY `fk_Horario_has_Dia_Horario1_idx` (`Horario_idHorario`),
  CONSTRAINT `fk_Horario_has_Dia_Dia1` FOREIGN KEY (`Dia_idDia`) REFERENCES `Dia` (`idDia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Horario_has_Dia_Horario1` FOREIGN KEY (`Horario_idHorario`) REFERENCES `Horario` (`idHorario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Horario_has_Dia`
--

LOCK TABLES `Horario_has_Dia` WRITE;
/*!40000 ALTER TABLE `Horario_has_Dia` DISABLE KEYS */;
INSERT INTO `Horario_has_Dia` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `Horario_has_Dia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Horario_has_ExperienciaEducativa`
--

DROP TABLE IF EXISTS `Horario_has_ExperienciaEducativa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Horario_has_ExperienciaEducativa` (
  `Horario_idHorario` int(11) NOT NULL,
  `ExperienciaEducativa_nrc` int(11) NOT NULL,
  PRIMARY KEY (`Horario_idHorario`,`ExperienciaEducativa_nrc`),
  KEY `fk_Horario_has_ExperienciaEducativa_ExperienciaEducativa1_idx` (`ExperienciaEducativa_nrc`),
  KEY `fk_Horario_has_ExperienciaEducativa_Horario1_idx` (`Horario_idHorario`),
  CONSTRAINT `fk_Horario_has_ExperienciaEducativa_ExperienciaEducativa1` FOREIGN KEY (`ExperienciaEducativa_nrc`) REFERENCES `ExperienciaEducativa` (`nrc`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Horario_has_ExperienciaEducativa_Horario1` FOREIGN KEY (`Horario_idHorario`) REFERENCES `Horario` (`idHorario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Horario_has_ExperienciaEducativa`
--

LOCK TABLES `Horario_has_ExperienciaEducativa` WRITE;
/*!40000 ALTER TABLE `Horario_has_ExperienciaEducativa` DISABLE KEYS */;
INSERT INTO `Horario_has_ExperienciaEducativa` VALUES (1,28391),(2,67890);
/*!40000 ALTER TABLE `Horario_has_ExperienciaEducativa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Profesor`
--

DROP TABLE IF EXISTS `Profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Profesor` (
  `idProfesor` int(11) NOT NULL AUTO_INCREMENT,
  `nombreProfesor` varchar(45) NOT NULL,
  `apPaternoProfesor` varchar(45) NOT NULL,
  `apMaternoProfesor` varchar(45) DEFAULT NULL,
  `emailProfesor` varchar(45) NOT NULL,
  PRIMARY KEY (`idProfesor`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Profesor`
--

LOCK TABLES `Profesor` WRITE;
/*!40000 ALTER TABLE `Profesor` DISABLE KEYS */;
INSERT INTO `Profesor` VALUES (1,'Oscar José Luis','Cruz','Reyes','ocruz@gmail.com'),(2,'Lizbeth Alejandra','Hernández','González','lizbeth@gmail.com'),(3,'Xavier','Limón','Riaño','xl666@gmail.com');
/*!40000 ALTER TABLE `Profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Profesor_has_ExperienciaEducativa`
--

DROP TABLE IF EXISTS `Profesor_has_ExperienciaEducativa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Profesor_has_ExperienciaEducativa` (
  `Profesor_idProfesor` int(11) NOT NULL,
  `ExperienciaEducativa_nrc` int(11) NOT NULL,
  PRIMARY KEY (`Profesor_idProfesor`,`ExperienciaEducativa_nrc`),
  KEY `fk_Profesor_has_ExperienciaEducativa1_ExperienciaEducativa1_idx` (`ExperienciaEducativa_nrc`),
  KEY `fk_Profesor_has_ExperienciaEducativa1_Profesor1_idx` (`Profesor_idProfesor`),
  CONSTRAINT `fk_Profesor_has_ExperienciaEducativa1_ExperienciaEducativa1` FOREIGN KEY (`ExperienciaEducativa_nrc`) REFERENCES `ExperienciaEducativa` (`nrc`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Profesor_has_ExperienciaEducativa1_Profesor1` FOREIGN KEY (`Profesor_idProfesor`) REFERENCES `Profesor` (`idProfesor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Profesor_has_ExperienciaEducativa`
--

LOCK TABLES `Profesor_has_ExperienciaEducativa` WRITE;
/*!40000 ALTER TABLE `Profesor_has_ExperienciaEducativa` DISABLE KEYS */;
INSERT INTO `Profesor_has_ExperienciaEducativa` VALUES (1,28391),(3,67890);
/*!40000 ALTER TABLE `Profesor_has_ExperienciaEducativa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SalonClases`
--

DROP TABLE IF EXISTS `SalonClases`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SalonClases` (
  `idSalonClases` int(11) NOT NULL AUTO_INCREMENT,
  `noSalonClases` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`idSalonClases`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SalonClases`
--

LOCK TABLES `SalonClases` WRITE;
/*!40000 ALTER TABLE `SalonClases` DISABLE KEYS */;
INSERT INTO `SalonClases` VALUES (1,'CC2'),(2,'104');
/*!40000 ALTER TABLE `SalonClases` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-20 21:47:55
