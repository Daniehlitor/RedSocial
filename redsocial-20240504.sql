CREATE DATABASE  IF NOT EXISTS `redsocial` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `redsocial`;
-- MySQL dump 10.13  Distrib 8.2.0, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: redsocial
-- ------------------------------------------------------
-- Server version	8.2.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `estados`
--

DROP TABLE IF EXISTS `estados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estados` (
  `estados_id` int NOT NULL AUTO_INCREMENT,
  `estados_name` varchar(50) NOT NULL,
  `estados_short` varchar(3) NOT NULL,
  `estados_description` varchar(250) NOT NULL,
  PRIMARY KEY (`estados_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estados`
--

LOCK TABLES `estados` WRITE;
/*!40000 ALTER TABLE `estados` DISABLE KEYS */;
INSERT INTO `estados` VALUES (1,'ACTIVO','ACT','Usuario o publicacion activa'),(2,'REPORTADO','REP','Usuario o publicacion reportada'),(3,'ELIMINADO','ELM','Usuario o publicacion eliminada');
/*!40000 ALTER TABLE `estados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `likes`
--

DROP TABLE IF EXISTS `likes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `likes` (
  `likes_id` int NOT NULL AUTO_INCREMENT,
  `likes_publicacion` int NOT NULL,
  `likes_usuario` varchar(100) NOT NULL,
  `likes_date` datetime NOT NULL,
  PRIMARY KEY (`likes_id`),
  KEY `usuarios_like_idx` (`likes_usuario`),
  KEY `publicacion_like_idx` (`likes_publicacion`),
  CONSTRAINT `publicacion_like` FOREIGN KEY (`likes_publicacion`) REFERENCES `publicaciones` (`publicaciones_id`),
  CONSTRAINT `usuario_like` FOREIGN KEY (`likes_usuario`) REFERENCES `usuarios` (`usuarios_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `likes`
--

LOCK TABLES `likes` WRITE;
/*!40000 ALTER TABLE `likes` DISABLE KEYS */;
/*!40000 ALTER TABLE `likes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publicaciones`
--

DROP TABLE IF EXISTS `publicaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `publicaciones` (
  `publicaciones_id` int NOT NULL AUTO_INCREMENT,
  `publicaciones_text` varchar(2500) NOT NULL,
  `publicaciones_image` varchar(100) NOT NULL,
  `publicaciones_usuario` varchar(100) NOT NULL,
  `publicaciones_date` datetime NOT NULL,
  `publicaciones_estado` int NOT NULL,
  PRIMARY KEY (`publicaciones_id`),
  KEY `estado_publicacion_idx` (`publicaciones_estado`),
  CONSTRAINT `estado_publicacion` FOREIGN KEY (`publicaciones_estado`) REFERENCES `estados` (`estados_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publicaciones`
--

LOCK TABLES `publicaciones` WRITE;
/*!40000 ALTER TABLE `publicaciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `publicaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `usuarios_id` varchar(100) NOT NULL,
  `usuarios_displayname` varchar(50) NOT NULL,
  `usuarios_email` varchar(50) NOT NULL,
  `usuarios_password` varchar(100) NOT NULL,
  `usuarios_date` datetime NOT NULL,
  `usuarios_estado` int NOT NULL,
  PRIMARY KEY (`usuarios_id`),
  KEY `estado_usuario_idx` (`usuarios_estado`),
  CONSTRAINT `estado_usuario` FOREIGN KEY (`usuarios_estado`) REFERENCES `estados` (`estados_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-04 16:51:24
