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
-- Table structure for table `visitor`
--

DROP TABLE IF EXISTS `visitor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `visitor` (
  `uid` int NOT NULL AUTO_INCREMENT,
  `shortUrlVisitor` varchar(255) DEFAULT NULL,
  `ipAddress` varchar(30) DEFAULT NULL,
  `visitedDate` date DEFAULT NULL,
  `visitedTime` time DEFAULT NULL,
  `longUrlVisitor` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`uid`),
  KEY `Shorturlvisitor` (`shortUrlVisitor`),
  KEY `users_ibfk_2` (`longUrlVisitor`),
  CONSTRAINT `visitor_ibfk_1` FOREIGN KEY (`shortUrlVisitor`) REFERENCES `links` (`shortUrl`),
  CONSTRAINT `visitor_ibfk_2` FOREIGN KEY (`longUrlVisitor`) REFERENCES `links` (`longUrl`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visitor`
--

LOCK TABLES `visitor` WRITE;
/*!40000 ALTER TABLE `visitor` DISABLE KEYS */;
INSERT INTO `visitor` VALUES (1,'http://localhost:8080/URL-Shortner/6d161968','131.228.231.190','2022-01-27','16:01:37','https://www.geeksforgeeks.org/html-td-width-attribute/'),(2,'http://localhost:8080/URL-Shortner/cc3dbde8','131.228.231.190','2022-01-27','17:01:52','https://apps.powerapps.com/play/1930615a-31e7-40a5-b391-5ac979c63538?tenantId=6d4034cd-7225-4f72-b853-91feaea64919'),(3,'http://localhost:8080/URL-Shortner/cb5ed9cc','131.228.231.201','2022-01-28','18:01:43','https://www.youtube.com/watch?v=ZB-7eq4txjA&ab_channel=ApnaCollege'),(4,'http://localhost:8080/URL-Shortner/cb5ed9cc','131.228.231.201','2022-01-28','18:01:15','https://www.youtube.com/watch?v=ZB-7eq4txjA&ab_channel=ApnaCollege'),(5,'http://localhost:8080/URL-Shortner/a686cc61','131.228.231.246','2022-01-31','12:01:18','https://codeburst.io/insert-with-select-statement-for-columns-with-foreign-key-constraint-in-mysql-with-examples-f9ab57c8e4dd'),(6,'http://localhost:8080/URL-Shortner/d1bfe546','131.228.231.246','2022-01-31','13:01:13','https://hmcs-my.sharepoint.com/personal/ankit_rane_here_com/_layouts/15/onedrive.aspx'),(7,'http://localhost:8080/URL-Shortner/d1bfe546','131.228.231.246','2022-01-31','13:01:27','https://hmcs-my.sharepoint.com/personal/ankit_rane_here_com/_layouts/15/onedrive.aspx'),(8,'http://localhost:8080/URL-Shortner/cc3dbde8','131.228.231.129','2022-02-01','11:02:43','https://apps.powerapps.com/play/1930615a-31e7-40a5-b391-5ac979c63538?tenantId=6d4034cd-7225-4f72-b853-91feaea64919'),(9,'http://localhost:8080/URL-Shortner/cc3dbde8','103.199.176.65','2022-02-02','16:02:41','https://apps.powerapps.com/play/1930615a-31e7-40a5-b391-5ac979c63538?tenantId=6d4034cd-7225-4f72-b853-91feaea64919'),(10,'http://localhost:8080/URL-Shortner/cc3dbde8','103.199.176.65','2022-02-02','16:02:19','https://apps.powerapps.com/play/1930615a-31e7-40a5-b391-5ac979c63538?tenantId=6d4034cd-7225-4f72-b853-91feaea64919'),(11,'http://localhost:8080/URL-Shortner/cc3dbde8','103.199.176.65','2022-02-02','16:02:28','https://apps.powerapps.com/play/1930615a-31e7-40a5-b391-5ac979c63538?tenantId=6d4034cd-7225-4f72-b853-91feaea64919'),(12,'http://localhost:8080/URL-Shortner/cc3dbde8','103.199.176.65','2022-02-02','17:02:49','https://apps.powerapps.com/play/1930615a-31e7-40a5-b391-5ac979c63538?tenantId=6d4034cd-7225-4f72-b853-91feaea64919'),(13,'http://localhost:8080/URL-Shortner/cc3dbde8','103.199.176.65','2022-02-02','17:02:56','https://apps.powerapps.com/play/1930615a-31e7-40a5-b391-5ac979c63538?tenantId=6d4034cd-7225-4f72-b853-91feaea64919'),(14,'http://localhost:8080/URL-Shortner/cc3dbde8','103.199.176.65','2022-02-02','17:02:42','https://apps.powerapps.com/play/1930615a-31e7-40a5-b391-5ac979c63538?tenantId=6d4034cd-7225-4f72-b853-91feaea64919'),(15,'http://localhost:8080/URL-Shortner/f4112364','103.199.176.65','2022-02-02','17:02:53','https://stackoverflow.com/questions/21915875/doget-calls-dopost-or-vise-versa'),(16,'http://localhost:8080/URL-Shortner/f4112364','103.199.176.65','2022-02-02','17:02:07','https://stackoverflow.com/questions/21915875/doget-calls-dopost-or-vise-versa'),(17,'http://localhost:8080/URL-Shortner/f4112364','103.199.176.65','2022-02-02','17:02:54','https://stackoverflow.com/questions/21915875/doget-calls-dopost-or-vise-versa'),(18,'http://localhost:8080/URL-Shortner/f4112364','103.199.176.65','2022-02-02','17:02:56','https://stackoverflow.com/questions/21915875/doget-calls-dopost-or-vise-versa'),(19,'http://localhost:8080/URL-Shortner/f4112364','103.199.176.65','2022-02-02','17:02:03','https://stackoverflow.com/questions/21915875/doget-calls-dopost-or-vise-versa'),(20,'http://localhost:8080/URL-Shortner/274a50c5','131.228.231.163','2022-02-03','05:02:09','https://confluence.in.here.com/display/RCPDS/Doubt_Repository'),(21,'http://localhost:8080/URL-Shortner/02498c4f','131.228.231.207','2022-02-04','19:02:03','https://play.google.com/store/apps/details?id=com.google.android.apps.translate&hl=en_IN&gl=US'),(22,'http://localhost:8080/URL-Shortner/02498c4f','131.228.231.207','2022-02-04','19:02:13','https://play.google.com/store/apps/details?id=com.google.android.apps.translate&hl=en_IN&gl=US'),(23,'http://localhost:8080/URL-Shortner/02498c4f','131.228.231.207','2022-02-04','19:02:13','https://play.google.com/store/apps/details?id=com.google.android.apps.translate&hl=en_IN&gl=US'),(24,'http://localhost:8080/URL-Shortner/0a90a3a5','131.228.231.203','2022-02-05','14:02:37','https://stackoverflow.com/questions/6505921/declare-multiple-string-variables-and-initialize-them-to-all-to-null-at-once/28180928'),(25,'http://localhost:8080/URL-Shortner/274a50c5','103.199.176.45','2022-02-05','17:02:42','https://confluence.in.here.com/display/RCPDS/Doubt_Repository'),(26,'http://localhost:8080/URL-Shortner/274a50c5','103.199.176.45','2022-02-05','17:02:16','https://confluence.in.here.com/display/RCPDS/Doubt_Repository'),(27,'http://localhost:8080/URL-Shortner/cc3dbde8','103.199.176.45','2022-02-05','17:02:59','https://apps.powerapps.com/play/1930615a-31e7-40a5-b391-5ac979c63538?tenantId=6d4034cd-7225-4f72-b853-91feaea64919'),(28,'http://localhost:8080/URL-Shortner/cc3dbde8','131.228.231.251','2022-02-07','11:02:02','https://apps.powerapps.com/play/1930615a-31e7-40a5-b391-5ac979c63538?tenantId=6d4034cd-7225-4f72-b853-91feaea64919'),(29,'http://localhost:8080/URL-Shortner/cc3dbde8','131.228.231.251','2022-02-07','11:02:51','https://apps.powerapps.com/play/1930615a-31e7-40a5-b391-5ac979c63538?tenantId=6d4034cd-7225-4f72-b853-91feaea64919'),(30,'http://localhost:8080/URL-Shortner/dba469f7','131.228.231.251','2022-02-07','14:02:59','https://apps.powerapps.com/play/de94a498-5df7-4836-a528-aafd03f3c2c4?tenantId=6d4034cd-7225-4f72-b853-91feaea64919'),(31,'http://localhost:8080/URL-Shortner/f869c901','131.228.231.251','2022-02-07','14:02:43','https://confluence.in.here.com/display/~mojidra/calendar/984de354-3af3-489f-b287-82d74523fd11?calendarName=Team%20Amey%20Attendance'),(32,'http://localhost:8080/URL-Shortner/dba469f7','131.228.231.251','2022-02-07','15:02:19','https://apps.powerapps.com/play/de94a498-5df7-4836-a528-aafd03f3c2c4?tenantId=6d4034cd-7225-4f72-b853-91feaea64919');
/*!40000 ALTER TABLE `visitor` ENABLE KEYS */;
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
