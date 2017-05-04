CREATE DATABASE  IF NOT EXISTS `drugstore` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `drugstore`;
-- MySQL dump 10.13  Distrib 5.6.24, for Win32 (x86)
--
-- Host: localhost    Database: drugstore
-- ------------------------------------------------------
-- Server version	5.6.26-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `employee_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone_number` varchar(30) DEFAULT NULL,
  `age` tinyint(3) NOT NULL,
  `active` tinyint(1) NOT NULL DEFAULT '1',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_update` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` (`employee_id`, `first_name`, `last_name`, `email`, `phone_number`, `age`, `active`, `create_date`, `last_update`) VALUES (1,'Julio Sergio Eduardo','Pastor Tantaleán','jsergiopastor@gmail.com','993726671',20,1,'2015-09-24 02:55:05','2015-09-24 14:44:02');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_permission`
--

DROP TABLE IF EXISTS `employee_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_permission` (
  `employee_permission_id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `employee_id` smallint(5) unsigned NOT NULL,
  `permission_id` tinyint(3) unsigned NOT NULL,
  `last_update` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`employee_permission_id`),
  KEY `idx_fk_employee_id` (`employee_id`),
  KEY `idx_fk_permission_id` (`permission_id`),
  CONSTRAINT `fk_employee_permission_employee` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_employee_permission_permission` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`permission_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_permission`
--

LOCK TABLES `employee_permission` WRITE;
/*!40000 ALTER TABLE `employee_permission` DISABLE KEYS */;
INSERT INTO `employee_permission` (`employee_permission_id`, `employee_id`, `permission_id`, `last_update`) VALUES (1,1,1,'2015-10-01 12:45:19'),(2,1,2,'2015-10-01 12:45:19'),(3,1,3,'2015-10-01 12:45:19'),(4,1,4,'2015-10-01 12:45:19');
/*!40000 ALTER TABLE `employee_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entry`
--

DROP TABLE IF EXISTS `entry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entry` (
  `entry_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `product_id` mediumint(8) unsigned NOT NULL,
  `entry_unit_price` decimal(20,7) NOT NULL,
  `entry_profit_percentage` decimal(17,7) NOT NULL,
  `quantity` int(10) NOT NULL,
  `batch` varchar(35) DEFAULT NULL,
  `supplier_id` mediumint(8) unsigned NOT NULL,
  `proof_of_payment_id` int(10) unsigned NOT NULL,
  `sanitary_register` varchar(50) DEFAULT NULL,
  `arrival_date` datetime NOT NULL,
  `expiry_date` datetime NOT NULL,
  `last_update` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`entry_id`),
  KEY `idx_fk_product_id` (`product_id`),
  KEY `idx_fk_supplier_id` (`supplier_id`),
  KEY `idx_fk_proof_of_payment_id` (`proof_of_payment_id`),
  CONSTRAINT `fk_entry_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_entry_proof_of_payment` FOREIGN KEY (`proof_of_payment_id`) REFERENCES `proof_of_payment` (`proof_of_payment_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_entry_supplier` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`supplier_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entry`
--

LOCK TABLES `entry` WRITE;
/*!40000 ALTER TABLE `entry` DISABLE KEYS */;
INSERT INTO `entry` (`entry_id`, `product_id`, `entry_unit_price`, `entry_profit_percentage`, `quantity`, `batch`, `supplier_id`, `proof_of_payment_id`, `sanitary_register`, `arrival_date`, `expiry_date`, `last_update`) VALUES (1,1,1.0000000,1.0000000,1,'1',1,1,'1','2015-11-07 00:00:00','2015-11-07 00:00:00','2015-11-07 00:28:44'),(2,1,1.0000000,1.0000000,1222,'1',1,3,'1','2015-11-07 00:00:00','2015-11-07 00:00:00','2015-11-07 00:30:58'),(3,1,1.0000000,1.0000000,1300,'12121',2,6,'1','2015-11-15 00:00:00','2015-11-15 00:00:00','2015-12-21 01:15:30'),(4,2,1.0000000,1.0000000,200,'Lote1',3,7,'123456789','2015-11-21 00:00:00','2015-11-21 00:00:00','2015-11-21 17:36:22'),(5,2,1.0000000,1.0000000,300,'Lote2',1,8,'123456789','2015-11-21 00:00:00','2015-11-21 00:00:00','2015-11-21 17:40:05'),(6,2,1.0000000,1.0000000,100,'Lote4',4,9,'123132132','2015-11-21 00:00:00','2015-11-21 00:00:00','2015-11-21 19:02:04'),(7,2,1.1200000,1.0000000,1,'1',4,10,'12345546','2015-11-22 00:00:00','2015-11-22 00:00:00','2015-11-22 18:02:38');
/*!40000 ALTER TABLE `entry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `form`
--

DROP TABLE IF EXISTS `form`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `form` (
  `form_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `detail` varchar(30) NOT NULL,
  `last_update` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`form_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `form`
--

LOCK TABLES `form` WRITE;
/*!40000 ALTER TABLE `form` DISABLE KEYS */;
INSERT INTO `form` (`form_id`, `detail`, `last_update`) VALUES (1,'asdasd','2015-11-07 00:28:43'),(2,'Pastilla','2015-11-21 17:36:22');
/*!40000 ALTER TABLE `form` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permission` (
  `permission_id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `description` varchar(200) NOT NULL,
  `last_update` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission`
--

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
INSERT INTO `permission` (`permission_id`, `description`, `last_update`) VALUES (1,'warehouse access','2015-09-18 01:30:57'),(2,'reports access','2015-09-18 01:30:57'),(3,'sales access','2015-09-18 01:30:57'),(4,'users access','2015-09-18 01:30:57');
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `product_id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `description` varchar(50) NOT NULL,
  `form_id` smallint(5) unsigned NOT NULL,
  `product_unit_price` decimal(20,7) NOT NULL,
  `product_profit_percentage` decimal(17,7) NOT NULL,
  `sale_price` decimal(20,2) NOT NULL,
  `stock` int(10) unsigned NOT NULL,
  `last_update` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`product_id`),
  KEY `idx_fk_form_id` (`form_id`),
  CONSTRAINT `fk_product_form` FOREIGN KEY (`form_id`) REFERENCES `form` (`form_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`product_id`, `description`, `form_id`, `product_unit_price`, `product_profit_percentage`, `sale_price`, `stock`, `last_update`) VALUES (1,'asdasd',1,1.0000000,1.0000000,1.01,1077,'2015-12-21 01:15:29'),(2,'Pastillon',2,1.1200000,1.0000000,1.13,401,'2015-11-22 18:02:38');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proof_of_payment`
--

DROP TABLE IF EXISTS `proof_of_payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proof_of_payment` (
  `proof_of_payment_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `number` varchar(50) NOT NULL,
  `type` varchar(30) NOT NULL,
  `active` tinyint(1) NOT NULL DEFAULT '1',
  `comment` varchar(100) DEFAULT NULL,
  `last_update` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`proof_of_payment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proof_of_payment`
--

LOCK TABLES `proof_of_payment` WRITE;
/*!40000 ALTER TABLE `proof_of_payment` DISABLE KEYS */;
INSERT INTO `proof_of_payment` (`proof_of_payment_id`, `number`, `type`, `active`, `comment`, `last_update`) VALUES (1,'1','BOLETA',1,NULL,'2015-11-07 00:28:44'),(2,'12','BOLETA',1,NULL,'2015-11-07 00:30:22'),(3,'1','BOLETA',1,NULL,'2015-11-07 00:30:58'),(4,'1','BOLETA',1,NULL,'2015-11-07 00:34:18'),(5,'1','BOLETA',1,NULL,'2015-11-07 00:34:31'),(6,'123123','BOLETA',1,NULL,'2015-11-15 22:36:54'),(7,'123456789','BOLETA',0,'Julio Sergio Eduardo Pastor Tantaleán','2015-11-21 17:39:50'),(8,'123456789','BOLETA',1,NULL,'2015-11-21 17:36:50'),(9,'20000231','BOLETA',1,NULL,'2015-11-21 19:02:04'),(10,'12131231231232145','BOLETA',1,NULL,'2015-11-22 18:01:41'),(11,'123123312312132','BOLETA',1,NULL,'2015-12-21 01:13:37');
/*!40000 ALTER TABLE `proof_of_payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sale`
--

DROP TABLE IF EXISTS `sale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sale` (
  `sale_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `proof_of_payment_id` int(10) unsigned NOT NULL,
  `employee_id` smallint(5) unsigned NOT NULL,
  `subtotal` decimal(15,2) NOT NULL,
  `igv` decimal(15,2) NOT NULL,
  `total` decimal(15,2) NOT NULL,
  `sale_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_update` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`sale_id`),
  KEY `idx_fk_proof_of_payment_id` (`proof_of_payment_id`),
  KEY `idx_fk_employee_id` (`employee_id`),
  CONSTRAINT `fk_sale_employee` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_sale_proof_of_payment` FOREIGN KEY (`proof_of_payment_id`) REFERENCES `proof_of_payment` (`proof_of_payment_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sale`
--

LOCK TABLES `sale` WRITE;
/*!40000 ALTER TABLE `sale` DISABLE KEYS */;
INSERT INTO `sale` (`sale_id`, `proof_of_payment_id`, `employee_id`, `subtotal`, `igv`, `total`, `sale_date`, `last_update`) VALUES (1,2,1,1.00,0.00,1.00,'2015-11-07 00:00:00','2015-11-07 00:30:22'),(2,4,1,0.00,0.00,0.00,'2015-11-07 00:00:00','2015-11-07 00:34:18'),(3,5,1,0.00,0.00,0.00,'2015-11-07 00:00:00','2015-11-07 00:34:31'),(4,11,1,0.50,0.00,0.50,'2015-12-21 00:00:00','2015-12-21 01:13:37');
/*!40000 ALTER TABLE `sale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sale_product`
--

DROP TABLE IF EXISTS `sale_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sale_product` (
  `sale_product_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `sale_id` int(10) unsigned NOT NULL,
  `product_id` mediumint(8) unsigned NOT NULL,
  `quantity` int(10) unsigned NOT NULL,
  `sale_price` decimal(20,7) DEFAULT NULL,
  `sale_total_price` decimal(20,7) DEFAULT NULL,
  `last_update` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`sale_product_id`),
  KEY `idx_fk_sale_id` (`sale_id`),
  KEY `idx_fk_product_id` (`product_id`),
  CONSTRAINT `pk_sale_product_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON UPDATE CASCADE,
  CONSTRAINT `pk_sale_product_sale` FOREIGN KEY (`sale_id`) REFERENCES `sale` (`sale_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sale_product`
--

LOCK TABLES `sale_product` WRITE;
/*!40000 ALTER TABLE `sale_product` DISABLE KEYS */;
INSERT INTO `sale_product` (`sale_product_id`, `sale_id`, `product_id`, `quantity`, `sale_price`, `sale_total_price`, `last_update`) VALUES (1,1,1,1,1.0000000,NULL,'2015-11-07 00:30:23'),(2,4,1,1,0.5000000,0.5000000,'2015-12-21 01:13:37');
/*!40000 ALTER TABLE `sale_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplier` (
  `supplier_id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `supplier_name` varchar(75) NOT NULL,
  `last_update` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`supplier_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` (`supplier_id`, `supplier_name`, `last_update`) VALUES (1,'1','2015-11-07 00:28:43'),(2,'11','2015-11-15 22:36:53'),(3,'Proveedor1','2015-11-21 17:36:22'),(4,'Proveedor12','2015-11-21 19:02:03');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password_hash` varchar(102) NOT NULL,
  `employee_id` smallint(5) unsigned NOT NULL,
  `last_update` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `idx_fk_employee_id` (`employee_id`),
  CONSTRAINT `fk_user_employee` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`user_id`, `username`, `password_hash`, `employee_id`, `last_update`) VALUES (1,'Elouan','1000:05ecc5b33112c48a25160a31e0eef76f480bd944877d3783:cea9dddcd757177c90359d893a1586aafca8a78b4fa0b084',1,'2015-10-01 10:58:02');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'drugstore'
--

--
-- Dumping routines for database 'drugstore'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-30 11:22:17
