-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: jiajiao
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `evaluate`
--

DROP TABLE IF EXISTS `evaluate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `evaluate` (
  `id` int NOT NULL AUTO_INCREMENT,
  `parent_phone` varchar(11) NOT NULL,
  `teacher_phone` varchar(11) NOT NULL,
  `content` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `date` datetime DEFAULT NULL,
  `subject` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evaluate`
--

LOCK TABLES `evaluate` WRITE;
/*!40000 ALTER TABLE `evaluate` DISABLE KEYS */;
INSERT INTO `evaluate` VALUES (1,'16517962749','151515','good teacher','2025-04-23 00:00:00','数学'),(2,'16517962749','131313','the teacher is handsome!! I love him!','2025-04-24 00:00:00','英语'),(3,'16517962749','151515','too serious!','2025-04-24 14:37:49','数学'),(4,'16517962749','20202002','这个老师很漂亮,孩子很喜欢','2025-04-24 17:54:29','语文'),(5,'19324841007','20202007','老师细心有耐心，学科知识扎实，孩子进步很大','2025-04-24 19:48:08','物理'),(6,'16517962749','121212','good teacher!','2025-04-24 20:23:00','英语'),(7,'16517962749','20202015','beautiful teacher!','2025-04-24 20:33:27','化学');
/*!40000 ALTER TABLE `evaluate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `par_money`
--

DROP TABLE IF EXISTS `par_money`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `par_money` (
  `id` int NOT NULL AUTO_INCREMENT,
  `phone` varchar(11) NOT NULL,
  `account_balance` varchar(255) NOT NULL,
  `current_balance` varchar(11) NOT NULL,
  `points` varchar(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `par_money`
--

LOCK TABLES `par_money` WRITE;
/*!40000 ALTER TABLE `par_money` DISABLE KEYS */;
INSERT INTO `par_money` VALUES (1,'17746676575','1000','200','100000'),(2,'16517962749','2000','500','100000');
/*!40000 ALTER TABLE `par_money` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `par_order`
--

DROP TABLE IF EXISTS `par_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `par_order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `parent_phone` varchar(11) NOT NULL,
  `bookname` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `count` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `price` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `state` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `par_order`
--

LOCK TABLES `par_order` WRITE;
/*!40000 ALTER TABLE `par_order` DISABLE KEYS */;
INSERT INTO `par_order` VALUES (1,'17746676575','java虚拟器','1','70','已收获'),(2,'17746676575','java编程思想','1','98','已收获'),(3,'17746676575','ssh框架','2','105','正在发货');
/*!40000 ALTER TABLE `par_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `par_reward`
--

DROP TABLE IF EXISTS `par_reward`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `par_reward` (
  `id` int NOT NULL AUTO_INCREMENT,
  `parent_phone` varchar(11) NOT NULL,
  `account` varchar(255) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `par_reward`
--

LOCK TABLES `par_reward` WRITE;
/*!40000 ALTER TABLE `par_reward` DISABLE KEYS */;
INSERT INTO `par_reward` VALUES (1,'16517962749','5','2025-05-14'),(2,'16517962749','3','2025-05-06'),(3,'16517962749','3','2025-06-01');
/*!40000 ALTER TABLE `par_reward` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parent`
--

DROP TABLE IF EXISTS `parent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parent` (
  `id` int NOT NULL AUTO_INCREMENT,
  `parent_phone` varchar(11) NOT NULL,
  `paswd` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `icon` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parent`
--

LOCK TABLES `parent` WRITE;
/*!40000 ALTER TABLE `parent` DISABLE KEYS */;
INSERT INTO `parent` VALUES (15,'16517962749','2072b80a9cc9664484e33861ad641491','person.png',NULL),(16,'19324841007','ccd18bfec16ecf93afac5ea137fc73ff','person.png',NULL);
/*!40000 ALTER TABLE `parent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plant`
--

DROP TABLE IF EXISTS `plant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plant` (
  `id` int NOT NULL AUTO_INCREMENT,
  `parent_phone` varchar(11) NOT NULL,
  `content` varchar(255) NOT NULL,
  `datetime` date NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plant`
--

LOCK TABLES `plant` WRITE;
/*!40000 ALTER TABLE `plant` DISABLE KEYS */;
/*!40000 ALTER TABLE `plant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserve`
--

DROP TABLE IF EXISTS `reserve`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reserve` (
  `id` int NOT NULL AUTO_INCREMENT,
  `parent_phone` varchar(255) NOT NULL,
  `teacher_phone` varchar(255) NOT NULL,
  `teacher_name` varchar(255) NOT NULL,
  `subject` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `date` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserve`
--

LOCK TABLES `reserve` WRITE;
/*!40000 ALTER TABLE `reserve` DISABLE KEYS */;
INSERT INTO `reserve` VALUES (1,'17746676575','131313','张鑫','英语','2020-12-1'),(2,'17746676575','20202005','张三5','物理','2020-12-1'),(3,'16517962749','131313','张鑫','english','2025-04-22 10:01:30'),(4,'16517962749','131313','张鑫','english','2025-04-22 10:03:49'),(5,'16517962749','20202018','张三18','地理','2025-04-22 19:08:38'),(6,'16517962749','20202011','张三11','政治','2025-04-22 20:35:50'),(7,'19324841007','20202011','张三11','政治','2025-04-24 19:31:26'),(8,'16517962749','181818','郭亮','生物','2025-04-24 20:22:01'),(9,'16517962749','20202017','张三17','地理','2025-04-24 20:29:23'),(10,'16517962749','20202009','张三9','政治','2025-04-24 20:32:13');
/*!40000 ALTER TABLE `reserve` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `id` int NOT NULL AUTO_INCREMENT,
  `teacher_phone` varchar(255) NOT NULL,
  `teacher_sex` varchar(11) NOT NULL,
  `teacher_name` varchar(255) NOT NULL,
  `teacher_icon` varchar(255) NOT NULL,
  `teacher_address` varchar(255) NOT NULL,
  `teacher_exper` varchar(255) DEFAULT NULL,
  `teacher_sub` varchar(10) NOT NULL,
  `grade` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'131313','男','张鑫','','','高考英语134，非常nb','english','一年级'),(2,'17548293854','女','张兰','','',NULL,'english','二年级'),(3,'151515','女','李四','','',NULL,'math','三年级'),(4,'161616','男','张三','','',NULL,'math','四年级'),(5,'121212','女','李辛','','',NULL,'math','六年级'),(6,'171717','女','王编','','',NULL,'math','六年级'),(7,'181818','男','郭亮','','',NULL,'biology','四年级'),(8,'20202001','男','张三1','','',NULL,'chinese','四年级'),(9,'20202002','男','张三2','','',NULL,'chinese','六年级'),(10,'20202003','男','张三3','','',NULL,'chinese','六年级'),(11,'20202004','男','张三4','','',NULL,'chinese','二年级'),(12,'20202005','男','张三5','','',NULL,'physics','高一'),(13,'20202006','男','张三6','','',NULL,'physics','初三'),(14,'20202007','男','张三7','','',NULL,'physics','初三'),(15,'20202008','男','张三8','','',NULL,'physics','初三'),(16,'20202009','男','张三9','','',NULL,'politics','高一'),(17,'20202010','男','张三10','','',NULL,'politics','初三'),(18,'20202011','男','张三11','','',NULL,'politics','初三'),(19,'20202012','男','张三12','','',NULL,'politics','初三'),(20,'20202013','男','张三13','','',NULL,'chemistry','初三'),(21,'20202014','男','张三14','','',NULL,'chemistry','初三'),(22,'20202015','男','张三15','','',NULL,'chemistry','初三'),(23,'20202016','男','张三16','','',NULL,'chemistry','高一'),(24,'20202017','男','张三17','','',NULL,'geography','初三'),(25,'20202018','男','张三18','','',NULL,'geography','高二'),(26,'20202019','男','张三19','','',NULL,'geography','高二'),(27,'20202020','男','张三20','','',NULL,'english','四年级'),(28,'20202021','男','张三21','','',NULL,'biology','高二'),(29,'20202022','男','张三22','','',NULL,'biology','高二'),(30,'20202023','男','张三23','','',NULL,'biology','高二');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-24 20:47:18
