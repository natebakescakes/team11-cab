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
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `booking` (
  `BookingId` int(11) NOT NULL AUTO_INCREMENT,
  `TransDate` datetime DEFAULT NULL,
  `FacilityId` int(11) DEFAULT NULL,
  `UserId` int(11) DEFAULT NULL,
  `StartDate` datetime DEFAULT NULL,
  `EndDate` datetime DEFAULT NULL,
  `status` varchar(50) NOT NULL,
  PRIMARY KEY (`BookingId`),
  KEY `FacilityId_idx` (`FacilityId`),
  KEY `MemNum_idx` (`UserId`),
  CONSTRAINT `FacilityId` FOREIGN KEY (`FacilityId`) REFERENCES `facility` (`facilityid`),
  CONSTRAINT `MemNum` FOREIGN KEY (`UserId`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (1,'2018-09-06 00:00:00',1,1,'2018-09-06 08:00:00','2018-09-06 10:00:00','Booked'),(2,'2017-12-25 23:29:19',14,9,'2018-03-18 02:00:00','2018-03-18 03:00:00','Booked'),(3,'2018-04-22 16:16:24',3,12,'2018-04-23 16:00:00','2018-04-23 17:00:00','Booked'),(4,'2018-02-20 18:45:42',7,1,'2018-02-21 09:00:00','2018-02-22 10:00:00','Booked'),(5,'2018-05-07 07:28:04',16,1,'2018-05-08 12:00:00','2018-05-08 13:00:00','Booked'),(6,'2018-03-22 22:45:17',2,11,'2018-03-23 14:00:00','2018-03-23 15:00:00','Booked'),(7,'2018-03-31 16:42:44',6,3,'2018-04-03 09:00:00','2018-04-03 10:00:00','Maintenance'),(8,'2017-08-01 11:20:10',19,3,'2017-08-05 11:00:00','2017-08-05 12:00:00','Booked'),(9,'2018-05-30 02:55:01',12,13,'2018-06-02 12:00:00','2018-06-02 01:00:00','Booked'),(10,'2017-07-18 19:54:33',1,11,'2017-07-18 14:00:00','2017-07-18 15:00:00','Cancelled'),(11,'2018-01-04 08:04:34',19,5,'2018-01-05 09:00:00','2018-01-05 10:00:00','Cancelled'),(12,'2017-10-07 05:31:44',17,6,'2017-10-17 15:00:00','2017-10-17 16:00:00','Booked'),(13,'2018-03-30 21:52:29',11,12,'2018-04-10 18:00:00','2018-04-10 18:00:00','Booked'),(14,'2018-02-07 05:53:42',19,2,'2018-02-08 15:00:00','2018-02-08 16:00:00','Cancelled'),(15,'2018-06-03 16:52:53',15,11,'2018-06-04 16:00:00','2018-06-04 17:00:00','Booked'),(16,'2018-01-31 10:26:43',1,8,'2018-02-03 10:00:00','2018-02-03 11:00:00','Booked'),(17,'2017-09-09 21:33:20',16,7,'2017-09-17 12:00:00','2017-09-17 13:00:00','Cancelled'),(18,'2017-09-02 13:27:21',17,6,'2017-09-05 13:00:00','2017-09-05 15:00:00','Cancelled'),(19,'2017-07-16 01:32:26',9,11,'2017-07-19 12:00:00','2017-07-19 13:00:00','Booked'),(20,'2017-11-27 21:33:40',12,8,'2017-11-28 11:00:00','2017-11-28 12:00:00','Booked'),(21,'2017-11-10 19:06:42',12,12,'2017-11-11 18:00:00','2017-11-11 19:00:00','Booked'),(22,'2017-10-22 16:34:50',19,5,'2017-10-23 17:00:00','2017-10-23 18:00:00','Cancelled'),(23,'2018-05-26 02:57:30',12,6,'2018-05-27 15:00:00','2018-05-27 16:00:00','Booked'),(24,'2017-07-25 19:29:44',6,4,'2017-07-28 18:00:00','2017-07-28 19:00:00','Cancelled'),(25,'2017-06-19 02:13:39',12,9,'2017-06-25 12:00:00','2017-06-25 16:00:00','Booked'),(26,'2017-10-29 03:28:38',1,7,'2017-11-02 09:00:00','2017-11-02 09:00:00','Booked'),(27,'2018-04-10 04:02:50',15,6,'2018-04-12 14:00:00','2018-04-12 15:00:00','Booked'),(28,'2017-09-14 12:40:59',13,8,'2017-09-15 12:00:00','2017-09-15 14:00:00','Cancelled'),(29,'2018-03-30 07:05:21',7,5,'2018-04-03 10:00:00','2018-04-03 10:00:00','Booked'),(30,'2017-08-15 20:01:34',17,1,'2017-08-16 16:00:00','2017-08-16 17:00:00','Booked'),(31,'2017-07-17 10:21:39',7,4,'2017-07-19 10:00:00','2017-07-19 11:00:00','Booked'),(32,'2017-07-30 11:26:25',14,8,'2017-08-13 11:00:00','2017-08-13 14:00:00','Booked'),(33,'2017-10-28 13:28:18',18,10,'2017-10-29 13:00:00','2017-10-29 13:00:00','Booked'),(34,'2017-10-06 07:45:36',10,8,'2017-10-09 17:00:00','2017-10-09 18:00:00','Booked'),(35,'2017-08-15 11:36:46',8,12,'2017-08-19 11:00:00','2017-08-19 12:00:00','Cancelled'),(36,'2017-09-28 02:55:11',1,5,'2017-09-30 15:00:00','2017-09-30 16:00:00','Booked'),(37,'2017-12-13 16:11:23',9,6,'2017-12-14 16:00:00','2017-12-14 17:00:00','Booked'),(38,'2018-05-11 23:41:53',3,6,'2018-05-15 18:00:00','2018-05-15 19:00:00','Maintenance'),(39,'2017-07-31 03:40:19',2,3,'2017-07-31 15:00:00','2017-07-31 16:00:00','Booked'),(40,'2017-06-30 18:27:55',5,12,'2017-07-03 17:00:00','2017-07-03 18:00:00','Booked'),(41,'2017-08-23 17:05:38',12,8,'2017-08-29 17:00:00','2017-08-29 18:00:00','Cancelled'),(42,'2018-05-19 03:11:25',19,6,'2018-05-25 10:00:00','2018-05-25 11:00:00','Maintenance'),(43,'2017-07-10 12:44:02',14,2,'2017-07-11 12:00:00','2017-07-11 13:00:00','Booked'),(44,'2018-05-07 11:09:12',7,13,'2018-05-17 11:00:00','2018-05-17 12:00:00','Cancelled'),(45,'2017-07-19 23:11:34',13,6,'2017-07-20 10:00:00','2017-07-19 11:00:00','Cancelled'),(46,'2017-08-17 14:09:33',3,1,'2017-08-20 14:00:00','2017-08-20 15:00:00','Maintenance'),(47,'2017-08-22 04:20:49',2,10,'2017-08-22 14:00:00','2017-08-22 15:00:00','Booked'),(48,'2018-06-12 06:27:02',15,8,'2018-06-15 16:00:00','2018-06-15 17:00:00','Maintenance'),(49,'2018-01-12 19:24:00',7,7,'2018-01-13 14:00:00','2018-01-13 15:00:00','Booked'),(50,'2017-08-26 09:08:03',19,5,'2017-08-27 09:00:00','2017-08-27 12:00:00','Booked'),(51,'2018-01-15 21:39:48',16,13,'2018-01-16 09:00:00','2018-01-16 11:00:00','Booked'),(52,'2018-06-17 19:05:31',1,2,'2018-06-23 09:00:00','2018-06-23 10:00:00','Cancelled');
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
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
