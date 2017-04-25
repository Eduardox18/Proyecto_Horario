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
INSERT INTO `ExperienciaEducativa` VALUES (21829,'Construcción de Software',9),(27381,'Paradigmas de Programación',10),(83291,'Sistemas Operativos',10);
/*!40000 ALTER TABLE `ExperienciaEducativa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Hora`
--

DROP TABLE IF EXISTS `Hora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Hora` (
  `idHorario` int(11) NOT NULL AUTO_INCREMENT,
  `intervaloHoras` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idHorario`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Hora`
--

LOCK TABLES `Hora` WRITE;
/*!40000 ALTER TABLE `Hora` DISABLE KEYS */;
INSERT INTO `Hora` VALUES (1,'7:00 - 8:00'),(2,'8:00 - 9:00'),(3,'9:00 - 10:00'),(4,'10:00 - 11:00'),(5,'11:00 - 12:00'),(6,'12:00 - 13:00'),(7,'13:00 - 14:00'),(8,'14:00 - 15:00'),(9,'15:00 - 16:00'),(10,'16:00 - 17:00'),(11,'17:00 - 18:00'),(12,'18:00 - 19:00'),(13,'19:00 - 20:00'),(14,'20:00 - 21:00');
/*!40000 ALTER TABLE `Hora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Horario`
--

DROP TABLE IF EXISTS `Horario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Horario` (
  `idHorario` int(11) NOT NULL AUTO_INCREMENT,
  `nombreEE` varchar(45) NOT NULL,
  `nombreProfesor` varchar(45) NOT NULL COMMENT '	',
  `nombreDia` varchar(20) NOT NULL,
  `hora` varchar(20) DEFAULT NULL,
  `noSalon` varchar(20) NOT NULL,
  PRIMARY KEY (`idHorario`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Horario`
--

LOCK TABLES `Horario` WRITE;
/*!40000 ALTER TABLE `Horario` DISABLE KEYS */;
INSERT INTO `Horario` VALUES (1,' Construcción de Software',' Fredy Castañeda','Lunes','7:00 - 8:00','104'),(2,' Construcción de Software',' Fredy Castañeda','Martes','7:00 - 8:00','104'),(4,' Construcción de Software',' Fredy Castañeda','Miércoles','7:00 - 8:00','104'),(5,' Construcción de Software',' Fredy Castañeda','Jueves','7:00 - 8:00','104');
/*!40000 ALTER TABLE `Horario` ENABLE KEYS */;
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
INSERT INTO `Profesor` VALUES (1,'Oscar José Luis','Cruz','Reyes','ocruz@gmail.com'),(2,'Fredy','Castañeda','Sánchez','fredyacademia@gmail.com'),(3,'Xavier','Limón','Riaño','limon666@gmail.com');
/*!40000 ALTER TABLE `Profesor` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SalonClases`
--

LOCK TABLES `SalonClases` WRITE;
/*!40000 ALTER TABLE `SalonClases` DISABLE KEYS */;
INSERT INTO `SalonClases` VALUES (1,'104');
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

-- Dump completed on 2017-04-24 18:31:44
