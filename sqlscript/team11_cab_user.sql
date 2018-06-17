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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `UserId` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(45) DEFAULT NULL,
  `LastName` varchar(45) DEFAULT NULL,
  `Email` varchar(320) DEFAULT NULL,
  `Address` varchar(200) DEFAULT NULL,
  `ContactNo` varchar(45) DEFAULT NULL,
  `DateOfBirth` datetime DEFAULT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(60) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`UserId`),
  UNIQUE KEY `UserId_UNIQUE` (`UserId`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Gabriel','Wong','gab@gmail.com','Blk 52 West Coast Rd','97662142','1988-11-17 00:00:00','gabrielwong','$2a$10$xDiQJO.W7OR1/5EzADXa..47eoMWnHC0hbfpltUakIARfBIRw8P6S',1),(2,'Jawen','Voon','jvoon@gmail.com','Blk 53 West Coast Rd','97662143','1988-11-18 00:00:00','jawenvoon','$2a$10$xDiQJO.W7OR1/5EzADXa..47eoMWnHC0hbfpltUakIARfBIRw8P6S',1),(3,'Jin','Kang','jinkang@gmail.com','Blk 54 West Coast Rd','97662144','1988-11-19 00:00:00','jinkang','$2a$10$xDiQJO.W7OR1/5EzADXa..47eoMWnHC0hbfpltUakIARfBIRw8P6S',1),(4,'Kayla','O\'Hara','jluettgen@example.org','3849 Pearl River Apt. 763','94256243','1982-03-31 03:58:15','veum.makenna','$2a$10$0e4BkSLTnGkJ6pqQMms70eXlfMWlT17gM.8nFI5PSI/kKNtNWG1we',1),(5,'Nora','Balistreri','willms.makayla@example.com','98769 Green Lodge Apt. 600','99448182','1992-04-17 12:51:00','samanta24','$2a$10$0e4BkSLTnGkJ6pqQMms70eXlfMWlT17gM.8nFI5PSI/kKNtNWG1we',1),(6,'Khalid','Stiedemann','carlos22@example.net','83630 Emard Stravenue','92027993','1991-03-27 05:46:11','raina.robel','$2a$10$0e4BkSLTnGkJ6pqQMms70eXlfMWlT17gM.8nFI5PSI/kKNtNWG1we',1),(7,'Carmella','Okuneva','antonina.bechtelar@example.net','4624 Kasey Station Suite 720','95173972','1988-01-07 20:02:51','brenden.mcglynn','$2a$10$0e4BkSLTnGkJ6pqQMms70eXlfMWlT17gM.8nFI5PSI/kKNtNWG1we',1),(8,'Lavinia','Reilly','joana27@example.net','6546 Dee Fords Apt. 851','97945929','1989-11-28 08:08:45','nerdman','$2a$10$0e4BkSLTnGkJ6pqQMms70eXlfMWlT17gM.8nFI5PSI/kKNtNWG1we',1),(9,'Tomasa','Kirlin','gerhold.kamron@example.org','049 Schiller Shoal','94433986','1972-03-06 06:08:53','fzboncak','$2a$10$0e4BkSLTnGkJ6pqQMms70eXlfMWlT17gM.8nFI5PSI/kKNtNWG1we',1),(10,'Lorena','Lynch','vada.lowe@example.net','4035 Dicki Extensions Suite 363','94686834','1983-04-15 00:24:17','wspinka','$2a$10$0e4BkSLTnGkJ6pqQMms70eXlfMWlT17gM.8nFI5PSI/kKNtNWG1we',1),(11,'Elmira','Mayer','nicole.runolfsson@example.com','84963 McCullough Ridge Suite 092','95437387','1987-04-25 04:23:22','hulda27','$2a$10$0e4BkSLTnGkJ6pqQMms70eXlfMWlT17gM.8nFI5PSI/kKNtNWG1we',1),(12,'Theresa','Rodriguez','dietrich.rosalia@example.org','60859 Paucek Views Apt. 777','97835741','1978-12-15 08:53:46','jo90','$2a$10$0e4BkSLTnGkJ6pqQMms70eXlfMWlT17gM.8nFI5PSI/kKNtNWG1we',1),(13,'Deron','Hilpert','stephan.durgan@example.com','89184 Heller Springs Apt. 391','96475675','1986-10-02 06:08:50','jennifer85','$2a$10$0e4BkSLTnGkJ6pqQMms70eXlfMWlT17gM.8nFI5PSI/kKNtNWG1we',1);
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

-- Dump completed on 2018-06-17 19:30:06
