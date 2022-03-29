-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: projectwork
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `veicoli`
--

DROP TABLE IF EXISTS `veicoli`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `veicoli` (
  `id` int NOT NULL AUTO_INCREMENT,
  `categoria` enum('auto','moto','monopattino','bicicletta') DEFAULT NULL,
  `immagine` varchar(100) DEFAULT NULL,
  `modello` varchar(20) DEFAULT NULL,
  `marca` varchar(20) DEFAULT NULL,
  `alimentazione` enum('diesel','benzina','elettrica','muscolare') DEFAULT NULL,
  `trazione` enum('anteriore','posteriore','integrale') DEFAULT NULL,
  `cambio` enum('manuale','automatico','none') DEFAULT NULL,
  `prezzo` smallint DEFAULT NULL,
  `indirizzo` varchar(100) DEFAULT NULL,
  `gps` varchar(100) DEFAULT NULL,
  `status` enum('prenotata','disponibile','non disponibile') DEFAULT NULL,
  `descrizione` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `veicoli`
--

LOCK TABLES `veicoli` WRITE;
/*!40000 ALTER TABLE `veicoli` DISABLE KEYS */;
INSERT INTO `veicoli` VALUES (1,'auto',NULL,'Giulia','Alfa romeo','benzina','anteriore','manuale',160,'Viale XX Settembre, 1-17','40.348025, 18.174218','disponibile',NULL),(2,'monopattino','/IMG/Veicoli/xiaomiESS.png','Essential','Xiaomi','elettrica','anteriore','none',5,'Viale XX Settembre, 1-17','40.348025, 18.174218','disponibile','Il monopattino piu bello del mondo'),(3,'bicicletta',NULL,'Manhattan','Discovery','muscolare','posteriore','manuale',5,'Viale XX Settembre, 1-17','40.348025, 18.174218','disponibile',NULL),(4,'moto',NULL,'Panigale','Ducati','benzina','posteriore','manuale',130,'Viale XX Settembre, 1-17','40.348025, 18.174218','disponibile',NULL),(5,'auto',NULL,'m5','BMW','benzina','posteriore','automatico',130,'Viale XX Settembre, 1-17','40.348025, 18.174218','disponibile',NULL),(6,'auto','/IMG/Veicoli/gtr35.png','gtr35','Nissan','benzina','posteriore','automatico',130,'Viale XX Settembre, 1-17','40.348025, 18.174218','disponibile',NULL);
/*!40000 ALTER TABLE `veicoli` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-29 15:32:06
