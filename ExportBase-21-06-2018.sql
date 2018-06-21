-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: testfarma
-- ------------------------------------------------------
-- Server version	5.5.60

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
-- Table structure for table `detalle_factura`
--

DROP TABLE IF EXISTS `detalle_factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_factura` (
  `id_detalle_factura` bigint(20) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio_lista` bigint(20) NOT NULL,
  `precio_venta` bigint(20) NOT NULL,
  `id_factura` bigint(20) NOT NULL,
  `id_producto` bigint(20) NOT NULL,
  PRIMARY KEY (`id_detalle_factura`),
  KEY `FK_factura_detalleFactura` (`id_factura`),
  KEY `FK_producto_detalleFactura` (`id_producto`),
  CONSTRAINT `FK_factura_detalleFactura` FOREIGN KEY (`id_factura`) REFERENCES `factura` (`id_factura`),
  CONSTRAINT `FK_producto_detalleFactura` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_factura`
--

LOCK TABLES `detalle_factura` WRITE;
/*!40000 ALTER TABLE `detalle_factura` DISABLE KEYS */;
INSERT INTO `detalle_factura` VALUES (1,2,20,30,1,1),(2,4,20,30,1,2),(3,8,20,30,2,1),(4,10,20,30,2,2),(5,15,30,40,3,4),(6,20,30,50,4,2),(7,30,35,60,5,1),(8,3,20,35,6,6),(9,6,10,15,6,3),(10,8,15,20,7,5),(11,9,5,10,7,8),(12,12,5,10,8,9),(13,4,10,15,9,9),(14,6,30,35,10,1),(15,2,12,18,10,4),(16,7,15,20,11,6),(17,13,17,23,12,2),(18,10,81,90,13,7),(19,23,78,90,14,9),(20,9,34,54,15,9),(21,3,45,50,15,9),(22,4,50,55,16,8),(23,6,55,60,17,7),(24,7,60,65,17,6),(25,9,10,15,17,5),(26,10,15,20,18,4),(27,12,20,25,19,3),(28,34,25,40,20,1),(29,23,30,35,20,4),(30,45,35,40,21,3),(31,2,40,45,22,5),(32,3,45,50,23,6),(33,3,45,50,24,6),(34,7,35,40,24,5),(35,6,25,30,25,4),(36,8,15,20,26,2),(37,9,5,10,27,1),(38,5,10,15,28,5),(39,4,15,20,28,3),(40,2,20,25,30,7);
/*!40000 ALTER TABLE `detalle_factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleado` (
  `cuil` bigint(20) NOT NULL,
  `encargado` bigint(20) NOT NULL,
  `id_empleado` bigint(20) NOT NULL,
  `id_sucursal` bigint(20) NOT NULL,
  PRIMARY KEY (`id_empleado`),
  KEY `FK_sucursal_empleado` (`id_sucursal`),
  CONSTRAINT `FKg7ihv9hpt96oij8plo26p13pl` FOREIGN KEY (`id_empleado`) REFERENCES `persona` (`id_persona`),
  CONSTRAINT `FK_sucursal_empleado` FOREIGN KEY (`id_sucursal`) REFERENCES `sucursal` (`id_sucursal`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (123123123,1,1,1),(25443534,0,2,2),(209459836,0,3,1),(25235235,0,4,1),(345345345,1,5,2),(645654656,0,6,2),(654654245,1,7,3),(871297183,0,8,3),(127362736,0,9,3);
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `factura` (
  `id_factura` bigint(20) NOT NULL,
  `codigo` int(11) NOT NULL,
  `fecha` date DEFAULT NULL,
  `nro_ticket` varchar(255) DEFAULT NULL,
  `id_cajero` bigint(20) NOT NULL,
  `id_cliente` bigint(20) NOT NULL,
  `id_forma_de_pago` bigint(20) NOT NULL,
  `id_sucursal` bigint(20) NOT NULL,
  `id_vendedor` bigint(20) NOT NULL,
  PRIMARY KEY (`id_factura`),
  KEY `FK_empleadoCajero_factura` (`id_cajero`),
  KEY `FK_persona_factura` (`id_cliente`),
  KEY `FK_formaDePago_factura` (`id_forma_de_pago`),
  KEY `FK_sucursal_factura` (`id_sucursal`),
  KEY `FK_empleadoVendedor_factura` (`id_vendedor`),
  CONSTRAINT `FK_empleadoCajero_factura` FOREIGN KEY (`id_cajero`) REFERENCES `empleado` (`id_empleado`),
  CONSTRAINT `FK_empleadoVendedor_factura` FOREIGN KEY (`id_vendedor`) REFERENCES `empleado` (`id_empleado`),
  CONSTRAINT `FK_formaDePago_factura` FOREIGN KEY (`id_forma_de_pago`) REFERENCES `forma_de_pago` (`id_forma_de_pago`),
  CONSTRAINT `FK_persona_factura` FOREIGN KEY (`id_cliente`) REFERENCES `persona` (`id_persona`),
  CONSTRAINT `FK_sucursal_factura` FOREIGN KEY (`id_sucursal`) REFERENCES `sucursal` (`id_sucursal`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
INSERT INTO `factura` VALUES (1,1123,'2018-05-10','1',1,1,1,1,1),(2,4241,'2018-05-04','2',2,2,2,1,2),(3,4124,'2018-06-05','3',1,3,2,1,3),(4,3423,'2018-07-05','4',3,1,2,1,2),(5,35435,'2018-06-15','5',4,2,2,1,4),(6,52346,'2018-06-20','6',4,1,1,1,5),(7,76587,'2018-06-21','7',3,3,1,1,6),(8,684567,'2018-06-21','8',4,7,2,1,8),(9,65362,'2018-06-09','9',1,8,1,1,9),(10,45346,'2018-06-05','10',4,9,2,1,2),(11,67567,'2018-05-10','11',2,10,1,2,5),(12,546365,'2018-05-10','12',2,7,2,2,2),(13,436534,'2018-05-11','13',5,3,1,2,5),(14,5473475,'2018-05-21','14',5,10,1,2,7),(15,2452345,'2018-05-20','15',5,8,2,2,8),(16,234572,'2018-05-10','16',6,10,2,2,2),(17,7547456,'2018-05-30','17',6,6,1,2,4),(18,4352345,'2018-05-05','18',6,10,2,2,3),(19,75437347,'2018-05-07','19',2,10,1,2,8),(20,12341234,'2018-05-09','20',2,9,1,2,9),(21,246246,'2018-06-20','21',7,10,1,3,3),(22,4262345,'2018-06-05','22',7,5,2,3,5),(23,32452346,'2018-06-09','23',8,10,2,3,7),(24,23462345,'2018-06-09','24',8,9,1,3,8),(25,627876,'2018-06-10','25',9,10,1,3,9),(26,67864,'2018-06-17','26',9,7,1,3,9),(27,54746,'2018-06-18','27',7,10,2,3,5),(28,78458,'2018-06-07','28',8,4,2,3,3),(29,546362,'2018-06-19','29',8,10,1,3,6),(30,346345,'2018-06-15','30',9,2,1,3,1);
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forma_de_pago`
--

DROP TABLE IF EXISTS `forma_de_pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `forma_de_pago` (
  `id_forma_de_pago` bigint(20) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_forma_de_pago`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forma_de_pago`
--

LOCK TABLES `forma_de_pago` WRITE;
/*!40000 ALTER TABLE `forma_de_pago` DISABLE KEYS */;
INSERT INTO `forma_de_pago` VALUES (1,'efectivo'),(2,'debito');
/*!40000 ALTER TABLE `forma_de_pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1),(1),(1),(1),(1),(1),(1),(1),(1),(1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `localidad`
--

DROP TABLE IF EXISTS `localidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `localidad` (
  `id_localidad` bigint(20) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `id_provincia` bigint(20) NOT NULL,
  PRIMARY KEY (`id_localidad`),
  KEY `FK_provincia_localidad` (`id_provincia`),
  CONSTRAINT `FK_provincia_localidad` FOREIGN KEY (`id_provincia`) REFERENCES `provincia` (`id_provincia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localidad`
--

LOCK TABLES `localidad` WRITE;
/*!40000 ALTER TABLE `localidad` DISABLE KEYS */;
INSERT INTO `localidad` VALUES (1,'lanus',1),(2,'avellaneda',2),(3,'temperley',2),(4,'chingolo',1);
/*!40000 ALTER TABLE `localidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `obra_social`
--

DROP TABLE IF EXISTS `obra_social`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `obra_social` (
  `id_obra_social` bigint(20) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_obra_social`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `obra_social`
--

LOCK TABLES `obra_social` WRITE;
/*!40000 ALTER TABLE `obra_social` DISABLE KEYS */;
INSERT INTO `obra_social` VALUES (1,'osde'),(2,'medicus'),(3,'galeno');
/*!40000 ALTER TABLE `obra_social` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `id_persona` bigint(20) NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `calle` varchar(255) DEFAULT NULL,
  `dni` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `num_afiliado` varchar(255) DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  `id_localidad` bigint(20) NOT NULL,
  `id_obra_social` bigint(20) NOT NULL,
  PRIMARY KEY (`id_persona`),
  KEY `FK_localidad_persona` (`id_localidad`),
  KEY `FK_obraSocial_persona` (`id_obra_social`),
  CONSTRAINT `FK_localidad_persona` FOREIGN KEY (`id_localidad`) REFERENCES `localidad` (`id_localidad`),
  CONSTRAINT `FK_obraSocial_persona` FOREIGN KEY (`id_obra_social`) REFERENCES `obra_social` (`id_obra_social`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'rolle','juan b justo',123456,'leandro','123456','2876',1,1),(2,'nazzi','salta',534534,'gino','1234567','3243',1,2),(3,'canete','irigoyen',2314214,'diego','12345678','4324',2,2),(4,'lopez','tucuman',2345243,'juan','3423432','3243',3,1),(5,'gonzalez','cordoba',1231233,'Kevin','1231233','1233',4,1),(6,'paria','guidi',1545455,'Jonatan','4234234','3424',1,2),(7,'gomez','uruguay',3984729,'Pedro','8923231','2341',2,2),(8,'Higa','Juan v gonzalez',7342343,'Lucas','7123412','2133',3,1),(9,'Spasiuk','Jujuy',6123123,'Kevin','5132123','2837',1,2),(10,'Filandro','Paraguay',4124233,'Nicolas','7689678','7232',2,1);
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `id_producto` bigint(20) NOT NULL,
  `codigo` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `precio` bigint(20) NOT NULL,
  `id_tipo_producto` bigint(20) NOT NULL,
  PRIMARY KEY (`id_producto`),
  KEY `FK_tipoProducto_producto` (`id_tipo_producto`),
  CONSTRAINT `FK_tipoProducto_producto` FOREIGN KEY (`id_tipo_producto`) REFERENCES `tipo_producto` (`id_tipo_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,12312312,'crema',20,1),(2,123213,'perfume one',40,1),(3,131233,'curita',10,1),(4,1253459,'aguao xigenada',5,1),(5,2352352,'jabon liquido',10,1),(6,4535345,'alcohol',10,1),(7,3452341,'perfume paco',20,1),(8,7347673,'crema sol',30,2),(9,568567,'crema corporal',40,2),(10,43534637,'spray pelo',50,2);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provincia`
--

DROP TABLE IF EXISTS `provincia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `provincia` (
  `id_provincia` bigint(20) NOT NULL,
  `codigo` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_provincia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provincia`
--

LOCK TABLES `provincia` WRITE;
/*!40000 ALTER TABLE `provincia` DISABLE KEYS */;
INSERT INTO `provincia` VALUES (1,1234,'bsas'),(2,4242,'salta'),(3,4234,'Jujuy');
/*!40000 ALTER TABLE `provincia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sucursal`
--

DROP TABLE IF EXISTS `sucursal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sucursal` (
  `id_sucursal` bigint(20) NOT NULL,
  `calle` varchar(255) DEFAULT NULL,
  `num_sucursal` int(11) DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  `id_localidad` bigint(20) NOT NULL,
  PRIMARY KEY (`id_sucursal`),
  KEY `FK_localidad_sucursal` (`id_localidad`),
  CONSTRAINT `FK_localidad_sucursal` FOREIGN KEY (`id_localidad`) REFERENCES `localidad` (`id_localidad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sucursal`
--

LOCK TABLES `sucursal` WRITE;
/*!40000 ALTER TABLE `sucursal` DISABLE KEYS */;
INSERT INTO `sucursal` VALUES (1,'Lanus',80,'1',1),(2,'Avellaneda',20,'2',2),(3,'Lomas',90,'3',3);
/*!40000 ALTER TABLE `sucursal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_producto`
--

DROP TABLE IF EXISTS `tipo_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_producto` (
  `id_tipo_producto` bigint(20) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_tipo_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_producto`
--

LOCK TABLES `tipo_producto` WRITE;
/*!40000 ALTER TABLE `tipo_producto` DISABLE KEYS */;
INSERT INTO `tipo_producto` VALUES (1,'medicamentos'),(2,'perfumeria');
/*!40000 ALTER TABLE `tipo_producto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-20 17:02:12
