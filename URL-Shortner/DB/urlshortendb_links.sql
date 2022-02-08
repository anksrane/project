-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: urlshortendb
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
-- Table structure for table `links`
--

DROP TABLE IF EXISTS `links`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `links` (
  `vid` int NOT NULL AUTO_INCREMENT,
  `longUrl` varchar(500) DEFAULT NULL,
  `shortUrl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`vid`),
  UNIQUE KEY `longUrl_UNIQUE` (`longUrl`),
  UNIQUE KEY `shortUrl_UNIQUE` (`shortUrl`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `links`
--

LOCK TABLES `links` WRITE;
/*!40000 ALTER TABLE `links` DISABLE KEYS */;
INSERT INTO `links` VALUES (1,'https://www.geeksforgeeks.org/html-td-width-attribute/','http://localhost:8080/URL-Shortner/6d161968'),(2,'https://stackoverflow.com/questions/32222318/spring-jstl-date-format-to-dd-mm-yyyy','http://localhost:8080/URL-Shortner/3bc81fdf'),(3,'https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_readonly','http://localhost:8080/URL-Shortner/41fbc8ff'),(4,'https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_onchange','http://localhost:8080/URL-Shortner/e5d9160d'),(5,'https://hmcs-my.sharepoint.com/:x:/r/personal/ankit_rane_here_com/_layouts/15/Doc.aspx?sourcedoc=%7BC9F53E14-AAB1-4753-9569-680EB7B0B7C9%7D&file=Ankit%20Work%20Sheet.xlsx&action=default&mobileredirect=true&ct=1594095600827&wdOrigin=OFFICECOM-WEB.START.MRU-OIB&cid=a1341f86-614a-4c33-96aa-fc7b81196c95','http://localhost:8080/URL-Shortner/c57f7886'),(6,'https://apps.powerapps.com/play/1930615a-31e7-40a5-b391-5ac979c63538?tenantId=6d4034cd-7225-4f72-b853-91feaea64919','http://localhost:8080/URL-Shortner/cc3dbde8'),(7,'https://www.youtube.com/watch?v=ZB-7eq4txjA&ab_channel=ApnaCollege','http://localhost:8080/URL-Shortner/cb5ed9cc'),(8,'https://codeburst.io/insert-with-select-statement-for-columns-with-foreign-key-constraint-in-mysql-with-examples-f9ab57c8e4dd','http://localhost:8080/URL-Shortner/a686cc61'),(9,'https://hmcs-my.sharepoint.com/personal/ankit_rane_here_com/_layouts/15/onedrive.aspx','http://localhost:8080/URL-Shortner/d1bfe546'),(10,'https://confluence.in.here.com/pages/viewpage.action?spaceKey=RCPDS&title=Doubt_Repository#123-1272520039','http://localhost:8080/URL-Shortner/a1543393'),(11,'https://stackoverflow.com/questions/21915875/doget-calls-dopost-or-vise-versa','http://localhost:8080/URL-Shortner/f4112364'),(12,'https://confluence.in.here.com/display/RCPDS/Doubt_Repository','http://localhost:8080/URL-Shortner/274a50c5'),(13,'https://play.google.com/store/apps/details?id=com.google.android.apps.translate&hl=en_IN&gl=US','http://localhost:8080/URL-Shortner/02498c4f'),(14,'https://confluence.in.here.com/display/RCPDS/EarthCore+Environments+-+Component+release+matrix','http://localhost:8080/URL-Shortner/9e58442b'),(15,'https://stackoverflow.com/questions/6505921/declare-multiple-string-variables-and-initialize-them-to-all-to-null-at-once/28180928','http://localhost:8080/URL-Shortner/0a90a3a5'),(16,'https://apps.powerapps.com/play/de94a498-5df7-4836-a528-aafd03f3c2c4?tenantId=6d4034cd-7225-4f72-b853-91feaea64919','http://localhost:8080/URL-Shortner/dba469f7'),(17,'https://confluence.in.here.com/display/~mojidra/calendar/984de354-3af3-489f-b287-82d74523fd11?calendarName=Team%20Amey%20Attendance','http://localhost:8080/URL-Shortner/f869c901');
/*!40000 ALTER TABLE `links` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-08 12:06:46
