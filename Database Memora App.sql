CREATE DATABASE  IF NOT EXISTS `memora` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `memora`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: memora
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `bad_cards`
--

DROP TABLE IF EXISTS `bad_cards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bad_cards` (
  `id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bad_cards`
--

LOCK TABLES `bad_cards` WRITE;
/*!40000 ALTER TABLE `bad_cards` DISABLE KEYS */;
INSERT INTO `bad_cards` VALUES (1),(2),(3),(4),(6),(7),(9),(10),(12),(14),(16),(17),(18),(20),(21),(32);
/*!40000 ALTER TABLE `bad_cards` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cards`
--

DROP TABLE IF EXISTS `cards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cards` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Question` longtext,
  `Answer` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cards`
--

LOCK TABLES `cards` WRITE;
/*!40000 ALTER TABLE `cards` DISABLE KEYS */;
INSERT INTO `cards` VALUES (1,'Who painted the Mona Lisa?','Leonardo da Vinci'),(2,'What is the capital of Australia?','Canberra'),(3,'What is the tallest mammal?','Giraffe'),(4,'What is the largest ocean?','Pacific Ocean'),(5,'Who wrote the novel \"Pride and Prejudice\"?','Jane Austen'),(6,'What is the currency of Japan?','Japanese yen'),(7,'What is the boiling point of water in Celsius?','100 degrees'),(8,'What is the smallest planet in our solar system?','Mercury'),(9,'What is the capital of Brazil?','Brasília'),(10,'Who invented the telephone?','Alexander Graham Bell'),(11,'What is the tallest mountain in the world?','Mount Everest'),(12,'What is the chemical symbol for gold?','Au'),(13,'What is the largest continent?','Asia'),(14,'What is the capital of Spain?','Madrid'),(15,'What is the process of converting a solid directly to a gas called?','Sublimation'),(16,'Who wrote the play \"Hamlet\"?','William Shakespeare'),(17,'What is the smallest country in the world?','Vatican City'),(18,'What is the distance between the Earth and the Sun?','149.6 million kilometers'),(19,'What is the main component of the Earth\'s atmosphere?','Nitrogen'),(20,'What is the speed of light in a vacuum?','299,792,458 meters per second'),(21,'What is the name of the Greek goddess of wisdom?','Athena'),(32,'what sv your name?','your booy muguwara');
/*!40000 ALTER TABLE `cards` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `good_cards`
--

DROP TABLE IF EXISTS `good_cards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `good_cards` (
  `id` int NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `good_cards`
--

LOCK TABLES `good_cards` WRITE;
/*!40000 ALTER TABLE `good_cards` DISABLE KEYS */;
INSERT INTO `good_cards` VALUES (13),(15),(8);
/*!40000 ALTER TABLE `good_cards` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfect_cards`
--

DROP TABLE IF EXISTS `perfect_cards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `perfect_cards` (
  `id` int NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfect_cards`
--

LOCK TABLES `perfect_cards` WRITE;
/*!40000 ALTER TABLE `perfect_cards` DISABLE KEYS */;
INSERT INTO `perfect_cards` VALUES (19),(11),(5);
/*!40000 ALTER TABLE `perfect_cards` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `FullName` longtext,
  `Bio` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Elon Musk','Elon Musk is a South African-born entrepreneur and inventor known for his leadership roles in several groundbreaking technology companies including Tesla, SpaceX, The Boring Company, and Neuralink. He is known for his innovative thinking, bold visions, and relentless pursuit of cutting-edge technology.'),(2,'Elon Musk','Elon Musk is a South African-born entrepreneur and inventor known for his leadership roles in several groundbreaking technology companies including Tesla, SpaceX, The Boring Company, and Neuralink. He is known for his innovative thinking, bold visions, and relentless pursuit of cutting-edge technology.');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-27  1:46:20
