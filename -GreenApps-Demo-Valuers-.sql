-- MySQL dump 10.13  Distrib 5.7.23, for macos 10.13 (x46_64)
--
-- Host: localhost    Database: GreenAppsDemo
-- ---------------------------------------------------------
-- Server Version	5.7.23

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

USE GreenAppsDemo;

--
-- Table structure for table `Categoria`
--

DROP TABLE IF EXISTS `Categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Categoria` (
  `idCategoria` int(30) NOT NULL AUTO_INCREMENT,
  `nombreCategoria` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `descripcionCategoria` longtext COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`idCategoria`),
  UNIQUE KEY `idCategoria_UNIQUE` (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Categoria`
--

LOCK TABLES `Categoria` WRITE;
/*!40000 ALTER TABLE `Categoria` DISABLE KEYS */;
INSERT INTO `Categoria` VALUES (1,'DEFAULT','DEFAULT');
/*!40000 ALTER TABLE `Categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Ciudad`
--

DROP TABLE IF EXISTS `Ciudad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Ciudad` (
  `idCiudad` int(30) NOT NULL AUTO_INCREMENT,
  `nombreCiudad` varchar(100) NOT NULL,
  PRIMARY KEY (`idCiudad`),
  UNIQUE KEY `nombreCiudad_UNIQUE` (`nombreCiudad`),
  UNIQUE KEY `idCiudad_UNIQUE` (`idCiudad`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Ciudad`
--

LOCK TABLES `Ciudad` WRITE;
/*!40000 ALTER TABLE `Ciudad` DISABLE KEYS */;
INSERT INTO `Ciudad` VALUES (1,'DEFAULT');
/*!40000 ALTER TABLE `Ciudad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Compra`
--

DROP TABLE IF EXISTS `Compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Compra` (
  `idCompra` int(30) NOT NULL AUTO_INCREMENT,
  `numeroCompra` varchar(30) NOT NULL,
  `idEmpleado` int(30) NOT NULL,
  `idPersona` int(30) NOT NULL,
  `totalCompra` float NOT NULL,
  `idTipoTransaccion` int(30) NOT NULL,
  `fechaCompra` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `estadoCompra` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`idCompra`),
  UNIQUE KEY `idCompra_UNIQUE` (`idCompra`),
  KEY `idEmpleadoCompra_idx` (`idEmpleado`),
  KEY `idPersonaCompra_idx` (`idPersona`),
  KEY `idTipoTransaccionCompra_idx` (`idTipoTransaccion`),
  CONSTRAINT `idEmpleadoCompra` FOREIGN KEY (`idEmpleado`) REFERENCES `Empleado` (`idEmpleado`) ON UPDATE CASCADE,
  CONSTRAINT `idPersonaCompra` FOREIGN KEY (`idPersona`) REFERENCES `Persona` (`idPersona`) ON UPDATE CASCADE,
  CONSTRAINT `idTipoTransaccionCompra` FOREIGN KEY (`idTipoTransaccion`) REFERENCES `TipoTransaccion` (`idTipoTransaccion`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Compra`
--

LOCK TABLES `Compra` WRITE;
/*!40000 ALTER TABLE `Compra` DISABLE KEYS */;
INSERT INTO `Compra` VALUES (1,'1',1,1,10000,1,'2019-04-28 00:13:48',1);
/*!40000 ALTER TABLE `Compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Cotizacion`
--

DROP TABLE IF EXISTS `Cotizacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Cotizacion` (
  `idCotizacion` int(30) NOT NULL AUTO_INCREMENT,
  `numeroCotizacion` varchar(30) NOT NULL,
  `idEmpleado` int(30) NOT NULL,
  `idPersona` int(30) NOT NULL,
  `totalCotizacion` float NOT NULL,
  `totalDescuentoVenta` float DEFAULT NULL,
  `fechaCotizacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `estadoCotizacion` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`idCotizacion`),
  UNIQUE KEY `idCotizacion_UNIQUE` (`idCotizacion`),
  KEY `idEmpleadoCotizacion_idx` (`idEmpleado`),
  KEY `idPersonaCotizacion_idx` (`idPersona`),
  CONSTRAINT `idEmpleadoCotizacion` FOREIGN KEY (`idEmpleado`) REFERENCES `Empleado` (`idEmpleado`) ON UPDATE CASCADE,
  CONSTRAINT `idPersonaCotizacion` FOREIGN KEY (`idPersona`) REFERENCES `Persona` (`idPersona`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cotizacion`
--

LOCK TABLES `Cotizacion` WRITE;
/*!40000 ALTER TABLE `Cotizacion` DISABLE KEYS */;
INSERT INTO `Cotizacion` VALUES (1,'1',1,1,3000,NULL,'2019-04-28 02:40:08',1);
/*!40000 ALTER TABLE `Cotizacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Departamento`
--

DROP TABLE IF EXISTS `Departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Departamento` (
  `idDepartamento` int(30) NOT NULL AUTO_INCREMENT,
  `nombreDepartamento` varchar(100) NOT NULL,
  PRIMARY KEY (`idDepartamento`),
  UNIQUE KEY `idDepartamento_UNIQUE` (`idDepartamento`),
  UNIQUE KEY `nombreDepartamento_UNIQUE` (`nombreDepartamento`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Departamento`
--

LOCK TABLES `Departamento` WRITE;
/*!40000 ALTER TABLE `Departamento` DISABLE KEYS */;
INSERT INTO `Departamento` VALUES (1,'DEFAULT');
/*!40000 ALTER TABLE `Departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Devolucion`
--

DROP TABLE IF EXISTS `Devolucion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Devolucion` (
  `idDevolucion` int(30) NOT NULL AUTO_INCREMENT,
  `numeroDevolucion` varchar(30) NOT NULL,
  `idEmpleado` int(30) NOT NULL,
  `idPersona` int(30) NOT NULL,
  `totalDevolucion` float NOT NULL,
  `idTipoTransaccion` int(30) NOT NULL,
  `fechaDevolucion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`idDevolucion`),
  UNIQUE KEY `idDevolucion_UNIQUE` (`idDevolucion`),
  KEY `idEmpleadoDevolucion_idx` (`idEmpleado`),
  KEY `idPersonaDevolucion_idx` (`idPersona`),
  KEY `idTipoTransaccionDevolucion_idx` (`idTipoTransaccion`),
  CONSTRAINT `idEmpleadoDevolucion0` FOREIGN KEY (`idEmpleado`) REFERENCES `Empleado` (`idEmpleado`) ON UPDATE CASCADE,
  CONSTRAINT `idPersonaDevolucion0` FOREIGN KEY (`idPersona`) REFERENCES `Persona` (`idPersona`) ON UPDATE CASCADE,
  CONSTRAINT `idTipoTransaccionDevolucion0` FOREIGN KEY (`idTipoTransaccion`) REFERENCES `TipoTransaccion` (`idTipoTransaccion`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Devolucion`
--

LOCK TABLES `Devolucion` WRITE;
/*!40000 ALTER TABLE `Devolucion` DISABLE KEYS */;
INSERT INTO `Devolucion` VALUES (1,'1',1,1,30000,1,'2019-04-28 00:18:12');
/*!40000 ALTER TABLE `Devolucion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Empleado`
--

DROP TABLE IF EXISTS `Empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Empleado` (
  `idEmpleado` int(30) NOT NULL AUTO_INCREMENT,
  `identificacionEmpleado` int(30) NOT NULL,
  `nombresEmpleado` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `apellidosEmpleado` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `idDepartamento` int(30) NOT NULL,
  `idCiudad` int(30) NOT NULL,
  `direccionEmpleado` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `telefonoEmpleado` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `correoEmpleado` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`idEmpleado`),
  UNIQUE KEY `idEmpleado_UNIQUE` (`idEmpleado`),
  UNIQUE KEY `identificacionEmpleado_UNIQUE` (`identificacionEmpleado`),
  KEY `idDepartamentoEmpleado` (`idDepartamento`),
  KEY `idCiudadEmpleado` (`idCiudad`),
  CONSTRAINT `idCiudadEmpleado` FOREIGN KEY (`idCiudad`) REFERENCES `Ciudad` (`idCiudad`) ON UPDATE CASCADE,
  CONSTRAINT `idDepartamentoEmpleado` FOREIGN KEY (`idDepartamento`) REFERENCES `Departamento` (`idDepartamento`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Empleado`
--

LOCK TABLES `Empleado` WRITE;
/*!40000 ALTER TABLE `Empleado` DISABLE KEYS */;
INSERT INTO `Empleado` VALUES (1,1,'DEFAULT-EMP','DEFAULT-EMP',1,1,'DEFAULT-EMP','1','@DEFAULT-EMP');
/*!40000 ALTER TABLE `Empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Mecanico`
--

DROP TABLE IF EXISTS `Mecanico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Mecanico` (
  `idMecanico` int(30) NOT NULL AUTO_INCREMENT,
  `identificacionMecanico` int(30) NOT NULL,
  `nombresMecanico` varchar(100) NOT NULL,
  `apellidosMecanico` varchar(100) NOT NULL,
  `idDepartamento` int(30) NOT NULL,
  `idCiudad` int(30) NOT NULL,
  `direccionMecanico` varchar(100) NOT NULL,
  `telefonoMecanico` varchar(100) NOT NULL,
  `correoMecanico` varchar(100) NOT NULL,
  PRIMARY KEY (`idMecanico`),
  UNIQUE KEY `idMecanico_UNIQUE` (`idMecanico`),
  UNIQUE KEY `identificacionMecanico_UNIQUE` (`identificacionMecanico`),
  KEY `idCiudadMecanico_idx` (`idCiudad`),
  KEY `idDepartamentoMecanico_idx` (`idDepartamento`),
  CONSTRAINT `idCiudadMecanico` FOREIGN KEY (`idCiudad`) REFERENCES `Ciudad` (`idCiudad`) ON UPDATE CASCADE,
  CONSTRAINT `idDepartamentoMecanico` FOREIGN KEY (`idDepartamento`) REFERENCES `Departamento` (`idDepartamento`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Mecanico`
--

LOCK TABLES `Mecanico` WRITE;
/*!40000 ALTER TABLE `Mecanico` DISABLE KEYS */;
INSERT INTO `Mecanico` VALUES (1,1,'DEFAULT-MEC','DEFAULT-MEC',1,1,'DEFAULT-MEC','1','@DEFAULT-MEC');
/*!40000 ALTER TABLE `Mecanico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Menu`
--

DROP TABLE IF EXISTS `Menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Menu` (
  `idMenu` int(11) NOT NULL AUTO_INCREMENT,
  `nombreMenu` varchar(50) NOT NULL,
  `linkMenu` varchar(50) NOT NULL,
  `idModulos` int(11) NOT NULL,
  PRIMARY KEY (`idMenu`),
  UNIQUE KEY `idMenu_UNIQUE` (`idMenu`),
  KEY `fk_Menu_Modulos1_idx` (`idModulos`),
  CONSTRAINT `fk_Menu_Modulos1` FOREIGN KEY (`idModulos`) REFERENCES `Modulos` (`idModulos`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Menu`
--

LOCK TABLES `Menu` WRITE;
/*!40000 ALTER TABLE `Menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `Menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Modulos`
--

DROP TABLE IF EXISTS `Modulos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Modulos` (
  `idModulos` int(11) NOT NULL AUTO_INCREMENT,
  `codigoModulo` varchar(50) NOT NULL,
  `nombreModulo` varchar(50) NOT NULL,
  PRIMARY KEY (`idModulos`),
  UNIQUE KEY `idModulos_UNIQUE` (`idModulos`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Modulos`
--

LOCK TABLES `Modulos` WRITE;
/*!40000 ALTER TABLE `Modulos` DISABLE KEYS */;
/*!40000 ALTER TABLE `Modulos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Moto`
--

DROP TABLE IF EXISTS `Moto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Moto` (
  `idMoto` int(30) NOT NULL AUTO_INCREMENT,
  `nombreMoto` varchar(50) NOT NULL,
  PRIMARY KEY (`idMoto`),
  UNIQUE KEY `idMoto_UNIQUE` (`idMoto`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Moto`
--

LOCK TABLES `Moto` WRITE;
/*!40000 ALTER TABLE `Moto` DISABLE KEYS */;
INSERT INTO `Moto` VALUES (1,'DEFAULT');
/*!40000 ALTER TABLE `Moto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Perfiles`
--

DROP TABLE IF EXISTS `Perfiles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Perfiles` (
  `idPerfiles` int(11) NOT NULL AUTO_INCREMENT,
  `codigoPerfil` varchar(50) NOT NULL,
  `nombrePefil` varchar(50) NOT NULL,
  PRIMARY KEY (`idPerfiles`),
  UNIQUE KEY `idPerfiles_UNIQUE` (`idPerfiles`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Perfiles`
--

LOCK TABLES `Perfiles` WRITE;
/*!40000 ALTER TABLE `Perfiles` DISABLE KEYS */;
/*!40000 ALTER TABLE `Perfiles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Persona`
--

DROP TABLE IF EXISTS `Persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Persona` (
  `idPersona` int(30) NOT NULL AUTO_INCREMENT,
  `idTipoPersona` int(30) NOT NULL,
  `idTipoDocumento` int(30) NOT NULL,
  `identificacionPersona` int(30) NOT NULL,
  `nombresPersona` varchar(100) NOT NULL,
  `apellidosPersona` varchar(100) NOT NULL,
  `idDepartamento` int(30) NOT NULL,
  `idCiudad` int(30) NOT NULL,
  `direccionPersona` varchar(100) DEFAULT NULL,
  `telefonoPersona` varchar(100) DEFAULT NULL,
  `correoPersona` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idPersona`),
  UNIQUE KEY `idCliente_UNIQUE` (`idPersona`),
  UNIQUE KEY `identificacionPersona_UNIQUE` (`identificacionPersona`),
  KEY `idDepartamentoPersona` (`idDepartamento`),
  KEY `idCiudadPersona` (`idCiudad`),
  KEY `idTipoDocumentoPersona` (`idTipoDocumento`),
  KEY `idTipoPersonaPersona` (`idTipoPersona`),
  CONSTRAINT `idCiudadPersona` FOREIGN KEY (`idCiudad`) REFERENCES `Ciudad` (`idCiudad`) ON UPDATE CASCADE,
  CONSTRAINT `idDepartamentoPersona` FOREIGN KEY (`idDepartamento`) REFERENCES `Departamento` (`idDepartamento`) ON UPDATE CASCADE,
  CONSTRAINT `idTipoDocumentoPersona` FOREIGN KEY (`idTipoDocumento`) REFERENCES `TipoDocumento` (`idTipoDocumento`) ON UPDATE CASCADE,
  CONSTRAINT `idTipoPersonaPersona` FOREIGN KEY (`idTipoPersona`) REFERENCES `TipoPersona` (`idTipoPersona`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Persona`
--

LOCK TABLES `Persona` WRITE;
/*!40000 ALTER TABLE `Persona` DISABLE KEYS */;
INSERT INTO `Persona` VALUES (1,1,1,1,'DEFAULT-PER','DEFAULT-PER',1,1,'DEFAULT-PER','1','@DEFAULT-PER');
/*!40000 ALTER TABLE `Persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PresentacionProducto`
--

DROP TABLE IF EXISTS `PresentacionProducto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PresentacionProducto` (
  `idPresentacionProducto` int(30) NOT NULL AUTO_INCREMENT,
  `descripcionPresentacionPro` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`idPresentacionProducto`),
  UNIQUE KEY `idPresentacionProducto_UNIQUE` (`idPresentacionProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PresentacionProducto`
--

LOCK TABLES `PresentacionProducto` WRITE;
/*!40000 ALTER TABLE `PresentacionProducto` DISABLE KEYS */;
INSERT INTO `PresentacionProducto` VALUES (1,'DEFAULT');
/*!40000 ALTER TABLE `PresentacionProducto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Producto`
--

DROP TABLE IF EXISTS `Producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Producto` (
  `idProducto` int(30) NOT NULL AUTO_INCREMENT,
  `codigoProducto` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `nombreProducto` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `descripcionProducto` text COLLATE latin1_spanish_ci NOT NULL,
  `stockProducto` int(11) NOT NULL,
  `valorCompraProducto` float NOT NULL,
  `valorVentaProducto` float NOT NULL,
  `stockMinimo` int(11) NOT NULL,
  `IVA` enum('SI','NO') COLLATE latin1_spanish_ci NOT NULL,
  `idCategoria` int(30) NOT NULL,
  `idPresentacionProducto` int(30) NOT NULL,
  `idUbicacionProducto` int(30) NOT NULL,
  PRIMARY KEY (`idProducto`),
  UNIQUE KEY `idProducto_UNIQUE` (`idProducto`),
  UNIQUE KEY `codigoProducto_UNIQUE` (`codigoProducto`),
  KEY `idCategoriaProducto_idx` (`idCategoria`),
  KEY `idPresentacionProductoProducto_idx` (`idPresentacionProducto`),
  KEY `idUbicacionProductoProducto_idx` (`idUbicacionProducto`),
  CONSTRAINT `idCategoriaProducto` FOREIGN KEY (`idCategoria`) REFERENCES `Categoria` (`idCategoria`) ON UPDATE CASCADE,
  CONSTRAINT `idPresentacionProductoProducto` FOREIGN KEY (`idPresentacionProducto`) REFERENCES `PresentacionProducto` (`idPresentacionProducto`) ON UPDATE CASCADE,
  CONSTRAINT `idUbicacionProductoProducto` FOREIGN KEY (`idUbicacionProducto`) REFERENCES `UbicacionProducto` (`idUbicacionProducto`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Producto`
--

LOCK TABLES `Producto` WRITE;
/*!40000 ALTER TABLE `Producto` DISABLE KEYS */;
INSERT INTO `Producto` VALUES (1,'¡DEFAULT!','DEFAULT','DEFAULT',1111,1000,3000,111,'SI',1,1,1);
/*!40000 ALTER TABLE `Producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Roles`
--

DROP TABLE IF EXISTS `Roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Roles` (
  `idRoles` int(11) NOT NULL AUTO_INCREMENT,
  `codigoRol` varchar(50) NOT NULL,
  `nombreRol` varchar(50) NOT NULL,
  `idModulos` int(11) NOT NULL,
  PRIMARY KEY (`idRoles`),
  UNIQUE KEY `idRoles_UNIQUE` (`idRoles`),
  KEY `fk_Roles_Modulos1_idx` (`idModulos`),
  CONSTRAINT `fk_Roles_Modulos1` FOREIGN KEY (`idModulos`) REFERENCES `Modulos` (`idModulos`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Roles`
--

LOCK TABLES `Roles` WRITE;
/*!40000 ALTER TABLE `Roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `Roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Servicio`
--

DROP TABLE IF EXISTS `Servicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Servicio` (
  `idServicio` int(30) NOT NULL AUTO_INCREMENT,
  `numeroServicio` varchar(30) NOT NULL,
  `placa` varchar(30) NOT NULL,
  `idMoto` int(30) NOT NULL,
  `idMecanico` int(30) NOT NULL,
  `observacionServicio` longtext NOT NULL,
  `idEmpleado` int(30) NOT NULL,
  `idPersona` int(30) NOT NULL,
  `totalServicio` float NOT NULL,
  `totalDescuentoServicio` varchar(45) DEFAULT NULL,
  `idTipoTransaccion` int(30) NOT NULL,
  `fechaServicio` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `estadoServicio` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`idServicio`),
  UNIQUE KEY `idServicio_UNIQUE` (`idServicio`),
  KEY `idEmpleadoServicio_idx` (`idEmpleado`),
  KEY `idPersonaServicio_idx` (`idPersona`),
  KEY `idTipoTransaccionServicio_idx` (`idTipoTransaccion`),
  KEY `idMotoServicio_idx` (`idMoto`),
  KEY `idMecanicoServicio_idx` (`idMecanico`),
  CONSTRAINT `idEmpleadoServicio` FOREIGN KEY (`idEmpleado`) REFERENCES `Empleado` (`idEmpleado`) ON UPDATE CASCADE,
  CONSTRAINT `idMecanicoServicio` FOREIGN KEY (`idMecanico`) REFERENCES `Mecanico` (`idMecanico`) ON UPDATE CASCADE,
  CONSTRAINT `idMotoServicio` FOREIGN KEY (`idMoto`) REFERENCES `Moto` (`idMoto`) ON UPDATE CASCADE,
  CONSTRAINT `idPersonaServicio` FOREIGN KEY (`idPersona`) REFERENCES `Persona` (`idPersona`) ON UPDATE CASCADE,
  CONSTRAINT `idTipoTransaccionServicio` FOREIGN KEY (`idTipoTransaccion`) REFERENCES `TipoTransaccion` (`idTipoTransaccion`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Servicio`
--

LOCK TABLES `Servicio` WRITE;
/*!40000 ALTER TABLE `Servicio` DISABLE KEYS */;
INSERT INTO `Servicio` VALUES (1,1,'DEFAULT',1,1,'DEFAULT',1,1,15000,'0',1,'2018-12-12 17:12:12',1);
/*!40000 ALTER TABLE `Servicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TipoDocumento`
--

DROP TABLE IF EXISTS `TipoDocumento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TipoDocumento` (
  `idTipoDocumento` int(30) NOT NULL AUTO_INCREMENT,
  `descripcionDocumento` varchar(100) NOT NULL,
  PRIMARY KEY (`idTipoDocumento`),
  UNIQUE KEY `idTipoDocumento_UNIQUE` (`idTipoDocumento`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TipoDocumento`
--

LOCK TABLES `TipoDocumento` WRITE;
/*!40000 ALTER TABLE `TipoDocumento` DISABLE KEYS */;
INSERT INTO `TipoDocumento` VALUES (1,'DEFAULT');
/*!40000 ALTER TABLE `TipoDocumento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TipoPersona`
--

DROP TABLE IF EXISTS `TipoPersona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TipoPersona` (
  `idTipoPersona` int(30) NOT NULL AUTO_INCREMENT,
  `descripcionPersona` varchar(100) NOT NULL,
  PRIMARY KEY (`idTipoPersona`),
  UNIQUE KEY `idTipoPersona_UNIQUE` (`idTipoPersona`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TipoPersona`
--

LOCK TABLES `TipoPersona` WRITE;
/*!40000 ALTER TABLE `TipoPersona` DISABLE KEYS */;
INSERT INTO `TipoPersona` VALUES (1,'DEFAULT');
/*!40000 ALTER TABLE `TipoPersona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TipoTransaccion`
--

DROP TABLE IF EXISTS `TipoTransaccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TipoTransaccion` (
  `idTipoTransaccion` int(30) NOT NULL AUTO_INCREMENT,
  `descripcionTransaccion` varchar(30) NOT NULL,
  PRIMARY KEY (`idTipoTransaccion`),
  UNIQUE KEY `idTipoTransaccion_UNIQUE` (`idTipoTransaccion`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TipoTransaccion`
--

LOCK TABLES `TipoTransaccion` WRITE;
/*!40000 ALTER TABLE `TipoTransaccion` DISABLE KEYS */;
INSERT INTO `TipoTransaccion` VALUES (1,'DEFAULT');
/*!40000 ALTER TABLE `TipoTransaccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `UbicacionProducto`
--

DROP TABLE IF EXISTS `UbicacionProducto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `UbicacionProducto` (
  `idUbicacionProducto` int(30) NOT NULL AUTO_INCREMENT,
  `descripcionUbicacionPro` varchar(100) NOT NULL,
  PRIMARY KEY (`idUbicacionProducto`),
  UNIQUE KEY `idUbicacionProducto_UNIQUE` (`idUbicacionProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `UbicacionProducto`
--

LOCK TABLES `UbicacionProducto` WRITE;
/*!40000 ALTER TABLE `UbicacionProducto` DISABLE KEYS */;
INSERT INTO `UbicacionProducto` VALUES (1,'DEFAULT');
/*!40000 ALTER TABLE `UbicacionProducto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuario`
--

DROP TABLE IF EXISTS `Usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usuario` (
  `idUsuario` int(30) NOT NULL AUTO_INCREMENT,
  `userEmp` varchar(30) NOT NULL,
  `passEmp` varchar(333) NOT NULL,
  `idEmpleado` int(30) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `idEmpleadoUsuario_idx` (`idEmpleado`),
  CONSTRAINT `idEmpleadoUsuario` FOREIGN KEY (`idEmpleado`) REFERENCES `Empleado` (`idEmpleado`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuario`
--

LOCK TABLES `Usuario` WRITE;
/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
INSERT INTO `Usuario` VALUES (1,'CSR','48a32a3f8085032db1fdcc9c33cceffb2ad41774579bc3791a8d3379bc0ab049f0cec4a59603df4a034b36dfbf30d72a2d35a76b737f0635bce7e3811d8152ce',1);
/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Venta`
--

DROP TABLE IF EXISTS `Venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Venta` (
  `idVenta` int(30) NOT NULL AUTO_INCREMENT,
  `numeroVenta` varchar(30) NOT NULL,
  `idEmpleado` int(30) NOT NULL,
  `idPersona` int(30) NOT NULL,
  `totalVenta` float NOT NULL,
  `totalDescuentoVenta` float DEFAULT NULL,
  `idTipoTransaccion` int(30) NOT NULL,
  `fechaVenta` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `estadoVenta` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`idVenta`),
  UNIQUE KEY `idVenta_UNIQUE` (`idVenta`),
  KEY `idEmpleadoVenta_idx` (`idEmpleado`),
  KEY `idPersonaVenta_idx` (`idPersona`),
  KEY `idTipoTransaccionVenta_idx` (`idTipoTransaccion`),
  CONSTRAINT `idEmpleadoVenta` FOREIGN KEY (`idEmpleado`) REFERENCES `Empleado` (`idEmpleado`) ON UPDATE CASCADE,
  CONSTRAINT `idPersonaVenta` FOREIGN KEY (`idPersona`) REFERENCES `Persona` (`idPersona`) ON UPDATE CASCADE,
  CONSTRAINT `idTipoTransaccionVenta` FOREIGN KEY (`idTipoTransaccion`) REFERENCES `TipoTransaccion` (`idTipoTransaccion`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Venta`
--

LOCK TABLES `Venta` WRITE;
/*!40000 ALTER TABLE `Venta` DISABLE KEYS */;
INSERT INTO `Venta` VALUES (1,'1',1,1,30000,NULL,1,'2019-04-28 00:16:35',1);
/*!40000 ALTER TABLE `Venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `creditoCompra`
--

DROP TABLE IF EXISTS `creditoCompra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `creditoCompra` (
  `idCreditoCompra` int(30) NOT NULL AUTO_INCREMENT,
  `idEmpleado` int(30) NOT NULL,
  `idPersona` int(30) NOT NULL,
  `creditoNuevo` float NOT NULL,
  `fechaAbono` date NOT NULL,
  PRIMARY KEY (`idCreditoCompra`),
  UNIQUE KEY `idEmpleado_UNIQUE` (`idEmpleado`),
  UNIQUE KEY `idPersona_UNIQUE` (`idPersona`),
  KEY `idCreditoCompra_UNIQUE` (`idCreditoCompra`),
  CONSTRAINT `idEmpleadoCreditoCompra` FOREIGN KEY (`idEmpleado`) REFERENCES `Empleado` (`idEmpleado`) ON UPDATE CASCADE,
  CONSTRAINT `idPersonaCreditoCompra` FOREIGN KEY (`idPersona`) REFERENCES `Persona` (`idPersona`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `creditoCompra`
--

LOCK TABLES `creditoCompra` WRITE;
/*!40000 ALTER TABLE `creditoCompra` DISABLE KEYS */;
/*!40000 ALTER TABLE `creditoCompra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `creditoVenta`
--

DROP TABLE IF EXISTS `creditoVenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `creditoVenta` (
  `idCreditoVenta` int(30) NOT NULL AUTO_INCREMENT,
  `idEmpleado` int(30) NOT NULL,
  `idPersona` int(30) NOT NULL,
  `creditoNuevo` float NOT NULL,
  `fechaAbono` date NOT NULL,
  PRIMARY KEY (`idCreditoVenta`),
  UNIQUE KEY `idCreditoVenta_UNIQUE` (`idCreditoVenta`),
  KEY `idEmpleadoCreditoVenta_idx` (`idEmpleado`),
  KEY `idPersonaCreditoVenta_idx` (`idPersona`),
  CONSTRAINT `idEmpleadoCreditoVenta` FOREIGN KEY (`idEmpleado`) REFERENCES `Empleado` (`idEmpleado`) ON UPDATE CASCADE,
  CONSTRAINT `idPersonaCreditoVenta` FOREIGN KEY (`idPersona`) REFERENCES `Persona` (`idPersona`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `creditoVenta`
--

LOCK TABLES `creditoVenta` WRITE;
/*!40000 ALTER TABLE `creditoVenta` DISABLE KEYS */;
/*!40000 ALTER TABLE `creditoVenta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalleCompra`
--

DROP TABLE IF EXISTS `detalleCompra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalleCompra` (
  `idDetalleCompra` int(30) NOT NULL AUTO_INCREMENT,
  `idCompra` int(30) NOT NULL,
  `idProducto` int(30) NOT NULL,
  `codigoProducto` varchar(100) NOT NULL,
  `nombreProducto` varchar(100) NOT NULL,
  `valorCompraProducto` float NOT NULL,
  `valorVentaProducto` float NOT NULL,
  `unidadesCompradas` int(30) NOT NULL,
  `totalDetalleCompra` float NOT NULL,
  PRIMARY KEY (`idDetalleCompra`),
  UNIQUE KEY `idDetalleCompra_UNIQUE` (`idDetalleCompra`),
  KEY `idDetalleCompraPdcto_idx` (`idProducto`),
  KEY `idDetalleCompraCompra_idx` (`idCompra`),
  CONSTRAINT `idDetalleCompraCompra` FOREIGN KEY (`idCompra`) REFERENCES `Compra` (`idCompra`) ON UPDATE CASCADE,
  CONSTRAINT `idDetalleCompraPdcto` FOREIGN KEY (`idProducto`) REFERENCES `Producto` (`idProducto`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalleCompra`
--

LOCK TABLES `detalleCompra` WRITE;
/*!40000 ALTER TABLE `detalleCompra` DISABLE KEYS */;
INSERT INTO `detalleCompra` VALUES (1,1,1,'¡DEFAULT!','DEFAULT',1000,3000,10,10000);
/*!40000 ALTER TABLE `detalleCompra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalleCotizacion`
--

DROP TABLE IF EXISTS `detalleCotizacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalleCotizacion` (
  `idDetalleCotizacion` int(30) NOT NULL AUTO_INCREMENT,
  `idCotizacion` int(30) NOT NULL,
  `idProducto` int(30) NOT NULL,
  `codigoProducto` varchar(100) NOT NULL,
  `nombreProducto` varchar(100) NOT NULL,
  `valorVentaProducto` float NOT NULL,
  `IVA` varchar(30) NOT NULL,
  `unidadesCotizadas` int(30) NOT NULL,
  `totalDetalleCotizacion` float NOT NULL,
  PRIMARY KEY (`idDetalleCotizacion`),
  UNIQUE KEY `idDetalleCotizacion_UNIQUE` (`idDetalleCotizacion`),
  KEY `idDetalleCotizacionPdcto_idx` (`idProducto`),
  KEY `idDetalleCotizacionCotizacion_idx` (`idCotizacion`),
  CONSTRAINT `idDetalleCotizacionCotizacion` FOREIGN KEY (`idCotizacion`) REFERENCES `Cotizacion` (`idCotizacion`) ON UPDATE CASCADE,
  CONSTRAINT `idDetalleCotizacionPdcto` FOREIGN KEY (`idProducto`) REFERENCES `Producto` (`idProducto`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalleCotizacion`
--

LOCK TABLES `detalleCotizacion` WRITE;
/*!40000 ALTER TABLE `detalleCotizacion` DISABLE KEYS */;
INSERT INTO `detalleCotizacion` VALUES (1,1,1,'¡DEFAULT!','DEFAULT',3000,'SI',1,3000);
/*!40000 ALTER TABLE `detalleCotizacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalleCreditoCompra`
--

DROP TABLE IF EXISTS `detalleCreditoCompra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalleCreditoCompra` (
  `idDetalleCreditoCompra` int(30) NOT NULL AUTO_INCREMENT,
  `idCreditoCompra` int(30) NOT NULL,
  `idCompra` int(30) NOT NULL,
  `creditoCompraActual` float NOT NULL,
  `abonoCreditoCompra` float NOT NULL,
  PRIMARY KEY (`idDetalleCreditoCompra`),
  UNIQUE KEY `idDetalleCreditoCompra_UNIQUE` (`idDetalleCreditoCompra`),
  UNIQUE KEY `idCreditoCompra_UNIQUE` (`idCreditoCompra`),
  UNIQUE KEY `idCompra_UNIQUE` (`idCompra`),
  CONSTRAINT `idCompraDetalleCreditoCompra` FOREIGN KEY (`idCompra`) REFERENCES `Compra` (`idCompra`) ON UPDATE CASCADE,
  CONSTRAINT `idCreditoCompraDetalleCreditoCompra` FOREIGN KEY (`idCreditoCompra`) REFERENCES `creditoCompra` (`idCreditoCompra`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalleCreditoCompra`
--

LOCK TABLES `detalleCreditoCompra` WRITE;
/*!40000 ALTER TABLE `detalleCreditoCompra` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalleCreditoCompra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalleCreditoVenta`
--

DROP TABLE IF EXISTS `detalleCreditoVenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalleCreditoVenta` (
  `idDetalleCreditoVenta` int(30) NOT NULL AUTO_INCREMENT,
  `idCreditoVenta` int(30) NOT NULL,
  `idVenta` int(30) NOT NULL,
  `creditoVentaActual` float NOT NULL,
  `abonoCreditoVenta` float NOT NULL,
  PRIMARY KEY (`idDetalleCreditoVenta`),
  UNIQUE KEY `idDetalleCreditoVenta_UNIQUE` (`idDetalleCreditoVenta`),
  UNIQUE KEY `idVenta_UNIQUE` (`idVenta`),
  UNIQUE KEY `idCreditoVenta_UNIQUE` (`idCreditoVenta`),
  CONSTRAINT `idCreditoVentaDetalleCreditoVenta` FOREIGN KEY (`idCreditoVenta`) REFERENCES `creditoVenta` (`idCreditoVenta`) ON UPDATE CASCADE,
  CONSTRAINT `idVentaDetalleCreditoVenta` FOREIGN KEY (`idVenta`) REFERENCES `Venta` (`idVenta`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalleCreditoVenta`
--

LOCK TABLES `detalleCreditoVenta` WRITE;
/*!40000 ALTER TABLE `detalleCreditoVenta` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalleCreditoVenta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalleDevolucion`
--

DROP TABLE IF EXISTS `detalleDevolucion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalleDevolucion` (
  `idDetalleDevolucion` int(30) NOT NULL AUTO_INCREMENT,
  `idDevolucion` int(30) NOT NULL,
  `idProducto` int(30) NOT NULL,
  `codigoProducto` varchar(100) NOT NULL,
  `nombreProducto` varchar(100) NOT NULL,
  `valorVentaProducto` float NOT NULL,
  `unidadesDevueltas` int(30) NOT NULL,
  `totalDetalleDevolucion` float NOT NULL,
  PRIMARY KEY (`idDetalleDevolucion`),
  UNIQUE KEY `idDetalleDevolucion_UNIQUE` (`idDetalleDevolucion`),
  KEY `idDetalleDevolucionPdcto_idx` (`idProducto`),
  KEY `idDetalleDevolucionVenta_idx` (`idDevolucion`),
  CONSTRAINT `idDetalleDevolucionPdcto0` FOREIGN KEY (`idProducto`) REFERENCES `Producto` (`idProducto`) ON UPDATE CASCADE,
  CONSTRAINT `idDetalleDevolucionVenta0` FOREIGN KEY (`idDevolucion`) REFERENCES `Devolucion` (`idDevolucion`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalleDevolucion`
--

LOCK TABLES `detalleDevolucion` WRITE;
/*!40000 ALTER TABLE `detalleDevolucion` DISABLE KEYS */;
INSERT INTO `detalleDevolucion` VALUES (1,1,1,'¡DEFAULT!','DEFAULT',3000,10,30000);
/*!40000 ALTER TABLE `detalleDevolucion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalleServicio`
--

DROP TABLE IF EXISTS `detalleServicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalleServicio` (
  `idDetalleServicio` int(30) NOT NULL AUTO_INCREMENT,
  `idServicio` int(30) NOT NULL,
  `idProducto` int(30) NOT NULL,
  `codigoProducto` varchar(100) NOT NULL,
  `nombreProducto` varchar(100) NOT NULL,
  `valorVentaProducto` float NOT NULL,
  `IVA` varchar(30) NOT NULL,
  `unidadesVendidas` int(30) NOT NULL,
  `totalDetalleServicio` float NOT NULL,
  PRIMARY KEY (`idDetalleServicio`),
  UNIQUE KEY `idDetalleVenta_UNIQUE` (`idDetalleServicio`),
  KEY `idDetalleVentaPdcto_idx` (`idProducto`),
  KEY `idDetalleServicioServicio_idx` (`idServicio`),
  CONSTRAINT `idDetalleServicioProducto` FOREIGN KEY (`idProducto`) REFERENCES `Producto` (`idProducto`) ON UPDATE CASCADE,
  CONSTRAINT `idDetalleServicioServicio` FOREIGN KEY (`idServicio`) REFERENCES `Servicio` (`idServicio`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalleServicio`
--

LOCK TABLES `detalleServicio` WRITE;
/*!40000 ALTER TABLE `detalleServicio` DISABLE KEYS */;
INSERT INTO `detalleServicio` VALUES (1,1,1,'¡DEFAULT!','DEFAULT',3000,'SI',5,15000);
/*!40000 ALTER TABLE `detalleServicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalleVenta`
--

DROP TABLE IF EXISTS `detalleVenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalleVenta` (
  `idDetalleVenta` int(30) NOT NULL AUTO_INCREMENT,
  `idVenta` int(30) NOT NULL,
  `idProducto` int(30) NOT NULL,
  `codigoProducto` varchar(100) NOT NULL,
  `nombreProducto` varchar(100) NOT NULL,
  `valorVentaProducto` float NOT NULL,
  `IVA` varchar(30) NOT NULL,
  `unidadesVendidas` int(30) NOT NULL,
  `totalDetalleVenta` float NOT NULL,
  PRIMARY KEY (`idDetalleVenta`),
  UNIQUE KEY `idDetalleVenta_UNIQUE` (`idDetalleVenta`),
  KEY `idDetalleVentaPdcto_idx` (`idProducto`),
  KEY `idDetalleVentaVenta_idx` (`idVenta`),
  CONSTRAINT `idDetalleVentaPdcto` FOREIGN KEY (`idProducto`) REFERENCES `Producto` (`idProducto`) ON UPDATE CASCADE,
  CONSTRAINT `idDetalleVentaVenta` FOREIGN KEY (`idVenta`) REFERENCES `Venta` (`idVenta`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalleVenta`
--

LOCK TABLES `detalleVenta` WRITE;
/*!40000 ALTER TABLE `detalleVenta` DISABLE KEYS */;
INSERT INTO `detalleVenta` VALUES (1,1,1,'¡DEFAULT!','DEFAULT',3000,'SI',10,30000);
/*!40000 ALTER TABLE `detalleVenta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado_Roles`
--

DROP TABLE IF EXISTS `empleado_Roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleado_Roles` (
  `idEmpleado_Roles` int(11) NOT NULL AUTO_INCREMENT,
  `idEmpelado` int(11) NOT NULL,
  `idRoles` int(11) NOT NULL,
  PRIMARY KEY (`idEmpleado_Roles`),
  UNIQUE KEY `idempleado_roles_UNIQUE` (`idEmpleado_Roles`),
  KEY `id_empelado_idx` (`idEmpelado`),
  KEY `idroles_idx` (`idRoles`),
  CONSTRAINT `id_empelado` FOREIGN KEY (`idEmpelado`) REFERENCES `Empleado` (`idEmpleado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idroles` FOREIGN KEY (`idRoles`) REFERENCES `Roles` (`idRoles`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado_Roles`
--

LOCK TABLES `empleado_Roles` WRITE;
/*!40000 ALTER TABLE `empleado_Roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `empleado_Roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado_Usuarios`
--

DROP TABLE IF EXISTS `empleado_Usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleado_Usuarios` (
  `idEmpleado_Usuarios` int(11) NOT NULL AUTO_INCREMENT,
  `idEmpleado` int(11) NOT NULL,
  `idPerfiles` int(11) NOT NULL,
  PRIMARY KEY (`idEmpleado_Usuarios`),
  UNIQUE KEY `idempleado_usuarios_UNIQUE` (`idEmpleado_Usuarios`),
  KEY `id_empleado_idx` (`idEmpleado`),
  KEY `idperfiles_idx` (`idPerfiles`),
  CONSTRAINT `idEmpleado` FOREIGN KEY (`idEmpleado`) REFERENCES `Empleado` (`idEmpleado`) ON UPDATE CASCADE,
  CONSTRAINT `idPerfiles` FOREIGN KEY (`idPerfiles`) REFERENCES `Perfiles` (`idPerfiles`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado_Usuarios`
--

LOCK TABLES `empleado_Usuarios` WRITE;
/*!40000 ALTER TABLE `empleado_Usuarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `empleado_Usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado_Modulos`
--

DROP TABLE IF EXISTS `empleado_Modulos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleado_Modulos` (
  `idEmpleado_Modulos` int(11) NOT NULL AUTO_INCREMENT,
  `Perfiles_idPerfiles` int(11) NOT NULL,
  `Modulos_idModulos` int(11) NOT NULL,
  PRIMARY KEY (`idEmpleado_Modulos`),
  UNIQUE KEY `idempleado_modulos_UNIQUE` (`idempleado_Modulos`),
  KEY `fk_empleado_modulos_Perfiles1_idx` (`Perfiles_idPerfiles`),
  KEY `fk_empleado_modulos_Modulos1_idx` (`Modulos_idModulos`),
  CONSTRAINT `fk_empleado_modulos_Modulos1` FOREIGN KEY (`Modulos_idModulos`) REFERENCES `Modulos` (`idModulos`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_empleado_modulos_Perfiles1` FOREIGN KEY (`Perfiles_idPerfiles`) REFERENCES `Perfiles` (`idPerfiles`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado_Modulos`
--

LOCK TABLES `empleado_Modulos` WRITE;
/*!40000 ALTER TABLE `empleado_Modulos` DISABLE KEYS */;
/*!40000 ALTER TABLE `empleado_Modulos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-27 22:27:22