CREATE DATABASE  IF NOT EXISTS `team11_cab` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `team11_cab`;
-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: team11_cab
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `facility`
--

DROP TABLE IF EXISTS `facility`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `facility` (
  `FacilityId` int(11) NOT NULL AUTO_INCREMENT,
  `FacilityName` varchar(45) DEFAULT NULL,
  `FacilityType` int(11) DEFAULT NULL,
  `Location` varchar(45) DEFAULT NULL,
  `Description` varchar(300) DEFAULT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`FacilityId`),
  KEY `TypeId_idx` (`FacilityType`),
  CONSTRAINT `TypeId` FOREIGN KEY (`FacilityType`) REFERENCES `facilitytype` (`typeid`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facility`
--

LOCK TABLES `facility` WRITE;
/*!40000 ALTER TABLE `facility` DISABLE KEYS */;
INSERT INTO `facility` VALUES (1,'Badminton Court 1',1,'Level 1','Nice, sleek badminton court.',1),(2,'Badminton Court 2',1,'Level 1','Nice, sleek badminton court.',1),(3,'Badminton Court 3',1,'Level 1','Nice, sleek badminton court.',1),(4,'Badminton Court 4',1,'Level 1','Nice, sleek badminton court.',1),(5,'Squash Court 1',2,'Level 1','Modern squash court.',1),(6,'Squash Court 2',2,'Level 1','Modern squash court.',1),(7,'Basketball Court',3,'Outdoor','Open-air basketball court',1),(8,'Table Tennis Court 1',4,'Level 2','Balls of Fury',1),(9,'Table Tennis Court 2',4,'Level 2','Balls of Fury',1),(10,'Table Tennis Court 3',4,'Level 2','Balls of Fury',1),(11,'Table Tennis Court 4',4,'Level 2','Balls of Fury',1),(12,'Tennis Court 1',5,'Outdoor','Balls of Fury',1),(13,'Tennis Court 2',5,'Outdoor','Balls of Fury',1),(14,'Multipurpose Hall',6,'#01-01','Can seat 1000',1),(15,'Dance Studio',7,'#02-01','For dancers',1),(16,'Azelea',8,'#03-01','Normal seminar room',1),(17,'Begonia',8,'#03-02','Normal seminar room',1),(18,'Carnation',8,'#03-03','Normal seminar room',1),(19,'Daffodil',8,'#03-04','Normal seminar room',1);
/*!40000 ALTER TABLE `facility` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-17 19:30:07
