-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: redsocial
-- ------------------------------------------------------
-- Server version	8.2.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
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
  `likes_usuario` int NOT NULL,
  `likes_date` datetime NOT NULL,
  PRIMARY KEY (`likes_id`),
  KEY `publicacion_like_idx` (`likes_publicacion`),
  KEY `likes_usuarios_FK` (`likes_usuario`),
  CONSTRAINT `likes_usuarios_FK` FOREIGN KEY (`likes_usuario`) REFERENCES `usuarios` (`usuarios_id`),
  CONSTRAINT `publicacion_like` FOREIGN KEY (`likes_publicacion`) REFERENCES `publicaciones` (`publicaciones_id`)
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
  `publicaciones_usuario` int NOT NULL,
  `publicaciones_estado` int NOT NULL DEFAULT '1',
  `publicaciones_text` varchar(2500) NOT NULL,
  `publicaciones_image` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `publicaciones_date` datetime NOT NULL,
  PRIMARY KEY (`publicaciones_id`),
  KEY `estado_publicacion_idx` (`publicaciones_estado`),
  KEY `publicaciones_usuarios_FK` (`publicaciones_usuario`),
  CONSTRAINT `estado_publicacion` FOREIGN KEY (`publicaciones_estado`) REFERENCES `estados` (`estados_id`),
  CONSTRAINT `publicaciones_usuarios_FK` FOREIGN KEY (`publicaciones_usuario`) REFERENCES `usuarios` (`usuarios_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publicaciones`
--

LOCK TABLES `publicaciones` WRITE;
/*!40000 ALTER TABLE `publicaciones` DISABLE KEYS */;
INSERT INTO `publicaciones` VALUES (1,1,1,'Hola beibi',NULL,'2024-05-26 00:00:00'),(2,1,1,'Hola uwu',NULL,'2024-05-26 00:00:00'),(3,1,1,'Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen. No sólo sobrevivió 500 años, sino que tambien ingresó como texto de relleno en documentos electrónicos, quedando esencialmente igual al original. Fue popularizado en los 60s con la creación de las hojas \"Letraset\", las cuales contenian pasajes de Lorem Ipsum, y más recientemente con software de autoedición, como por ejemplo Aldus PageMaker, el cual incluye versiones de Lorem Ipsum.',NULL,'2024-05-26 00:00:00'),(4,1,1,'Hola Que tal como está',NULL,'2024-05-26 00:00:00');
/*!40000 ALTER TABLE `publicaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `usuarios_id` int NOT NULL AUTO_INCREMENT,
  `usuarios_displayname` varchar(50) NOT NULL,
  `usuarios_email` varchar(50) NOT NULL,
  `usuarios_password` varchar(100) NOT NULL,
  `usuarios_date` datetime NOT NULL,
  `usuarios_estado` int NOT NULL DEFAULT '1',
  `usuarios_logged` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`usuarios_id`),
  KEY `estado_usuario_idx` (`usuarios_estado`),
  CONSTRAINT `usuarios_estados_FK` FOREIGN KEY (`usuarios_estado`) REFERENCES `estados` (`estados_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'daniehlitor','daniehlitor@gmail.com','Dubitoking12','2024-05-26 00:00:00',1,1);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'redsocial'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-26 19:29:58
