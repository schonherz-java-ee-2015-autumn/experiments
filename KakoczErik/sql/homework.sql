-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: homework
-- ------------------------------------------------------
-- Server version	5.6.27-log

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
-- Table structure for table `homework`
--

DROP TABLE IF EXISTS `homework`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `homework` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(2) DEFAULT NULL,
  `city` varchar(15) DEFAULT NULL,
  `street` varchar(20) DEFAULT NULL,
  `house_number` varchar(5) DEFAULT NULL,
  `floor_number` int(11) DEFAULT NULL,
  `door_number` int(11) DEFAULT NULL,
  `bell_name` varchar(20) DEFAULT NULL,
  `company` varchar(20) DEFAULT NULL,
  `tel_number1` varchar(10) DEFAULT NULL,
  `tel_number2` varchar(10) DEFAULT NULL,
  `tel_number3` varchar(10) DEFAULT NULL,
  `cos_comment` varchar(30) DEFAULT NULL,
  `discount_percent` int(11) DEFAULT NULL,
  `banned` char(1) DEFAULT NULL,
  `premium` char(1) DEFAULT NULL,
  `number_of_orders` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `homework`
--

LOCK TABLES `homework` WRITE;
/*!40000 ALTER TABLE `homework` DISABLE KEYS */;
INSERT INTO `homework` VALUES (1,'AK','DEBRECEN','KOSSUTH UTCA','26/B',0,0,'CSÖRGETNI','','6300001585','','','',0,'f','f',0),(2,'AZ','Debrecen','ISTVÁN ÚT','39',9,27,'','','6300002542','','','',0,'f','f',0),(3,'AM','Debrecen','ISTVÁN ÚT','58',0,0,'','LUGAS SÖRŐZŐ ','6300003788','','','',0,'f','f',0),(4,'AA','DEBRECEN','BÖSZÖRMÉNYI ÚT','49',4,15,'','','6300004906','','','',0,'f','f',1),(5,'AV','Debrecen','Híd utca','10-12',0,0,'CSÖRGETNI','EON ELSŐ PORTA','6700005996','','','',0,'f','f',88),(6,'AM','DEBRECEN','PIAC UTCA','-',0,0,'','FŐTÉR PUSKÁR KERÁMIA','6200006561','','','',0,'f','f',0),(7,'AG','DEBRECEN','KISHEGYESI ÚT','113/C',0,0,'','','6700007689','','','',0,'f','f',0),(8,'AA','Debrecen','lehel','24',11,83,'','','6300008820','','','',0,'f','f',15),(9,'AV','DEBRECEN','KASSAI ÚT','26',0,309,'','CAMPUS A','6300009037','','','',0,'f','f',9),(10,'AG','DEBRECEN','KASSAI ÚT','86',1,7,'7','','6300010461','','','',0,'f','f',0),(11,'AD','Debrecen','Egyetem sugárút','47',3,16,'','','6300011529','','','',0,'f','f',0),(12,'AB','DEBRECEN','BÉKESSY BÉLA UTCA','10',1,15,'','','6300012684','','','',0,'f','f',0),(13,'AA','Debrecen','Vasvári Pál utca','20',4,0,'','','6300013569','','','',0,'f','f',1),(14,'AA','DEBRECEN','ATILLA TÉR','3',0,0,'','RÓNA','6700014282','','','',0,'f','f',0),(15,'AH','Debrecen','HATÁR ÚT','1/C.',0,0,'','RR DONNELLEY','6700015474','','','',0,'f','f',0),(16,'AG','DEBRECEN','HATVANI ISTVÁN','18',3,10,'','','6700016059','','','',0,'f','f',0),(17,'AR','DEBRECEN','VEZÉR UTCA','-',0,0,'','IT SERVICES','6300017998','','','',0,'f','f',1),(18,'AÜ','DEBRECEN','VÍGHKEDVŰ MIHÁLY UTC','7',0,0,'','','6520018931','','','',0,'f','f',4),(19,'AK','DEBRECEN','FÜREDI ÚT','42',0,0,'','FÜREDI SÖRÖZŐ','6300019633','','','',0,'f','f',0),(20,'AT','DEBRECEN','BAJCSY ZSILINSZKY UT','60',0,0,'','BELVÁROSI FOGADÓ ','6300020907','','','',0,'f','f',0),(21,'AC','DEBRECEN','KASSAI ÚT','26',333,0,'','CAMPUS B','6300021047','','','',0,'f','f',2),(22,'AA','DEBRECEN','SZABOLCS UTCA','22',0,0,'','','6300022520','6300022088','','',0,'f','f',4),(23,'AM','DEBRECEN','CIVIS UTCA','2',3,24,'','','6300023708','','','',0,'f','f',0),(24,'AM','DEBRECEN','HAJNAL UTCA','4/A',3,3,'CSÖRGETNI','','6300024708','','','',0,'f','f',0),(25,'AÁ','DEBRECEN','DIÓSZEGI ÚT','15',0,0,'','HUSZÁR GÁL ISKOLA','6300025521','','','',0,'f','f',0),(26,'AV','DEBRECEN','NAGYERDEI KÖRÚT','98',1,0,'','REHAILITÁCIÓS TANSZÉ','6300026254','','','LIFTBŐL JOBBRA\r\n',0,'f','f',0),(27,'AI','DEBRECEN','NAGYERDEI KÖRÚT','68',0,0,'','BÖLCSÖDE ÉPÜLETE','6300027323','','','',0,'f','f',0),(28,'AZ','DEBRECEN','SÁMSONI ÚT','147',0,0,'','RENDŐRSÉG','6700028863','','','',0,'f','f',2),(29,'AB','DEBRECEN','KASSAI ÚT','26',0,403,'CSÖRGETNI','CAMPUS B','6700029304','','','',0,'f','f',6),(30,'AL','DEBRECEN','NAGYERDEI KÖRÚT','98',1,0,'CSÖRGETNI','ÉLETTANI INTÉZET','6200030784','','','',0,'f','f',0),(31,'AI','DEBRECEN','DÓZSA GYÖRGY UTCA','1',0,3,'','','6300031055','6520031499','','',0,'f','f',1),(32,'AZ','DEBRECEN','MIKSZÁTH KÁLMÁN UTCA','85',1,1,'','','6300032802','','','',0,'f','f',0),(33,'AL','DEBRECEN','MIKSZÁTH KÁLMÁN UTCA','63',1,5,'','','6700033671','','','',0,'f','f',6),(34,'AL','DEBRECEN','PIAC UTCA','3',2,14,'','','6700034568','','','',0,'f','f',2),(35,'AN','DEBRECEN','SIMONFFY UTCA','21',0,0,'','','6300035014','','','',0,'f','f',1),(36,'AK','DEBRECEN','HÍD UTCA','10-12',0,0,'CSÖRGETNI','EON HÁTSÓ PORTA','6300036788','','','',0,'f','f',3),(37,'AA','DEBRECEN','BEM TÉR','14',0,0,'','MOBIL KREDIT KFT','6300037366','','','',0,'f','f',3),(38,'AV','DEBRECEN','POSTAKERT ','7/B',0,0,'','GYŐRFFY KOLI','6700038633','','','',0,'f','f',5),(39,'AS','DEBRECEN','ASZTALOS UTCA','2',0,0,'','','6300039998','','','SARKI HÁZ HÁTRA',0,'f','f',1),(40,'AC','DEBRECEN','SÁMSONI ÚT','X',0,0,'','BUSZFORDULÓ','6700040536','','','5 PERCCEL ELÖTTE CSÖRG',0,'f','f',2),(41,'AB','DEBRECEN','NÁDSÍP UTCA','8',0,0,'BAL ALSÓ','','6200041480','','','',0,'f','f',2),(42,'AZ','Debrecen','Vág utca','11/B.',0,16,'','','6300042348','','','',0,'f','f',1),(43,'AL','DEBRECEN','PIAC UTCA','41',0,0,'','ROBOSZ KÁVÉHÁZ','6300043188','','','',0,'f','f',2),(44,'AS','DEBRECEN','FÜREDI ÚT','76',0,0,'SUPER UDVARBAN HÁTUL','(Center-Print Nyomda','6300044834','','','',0,'f','f',7),(45,'AZ','DEBRECEN','NYITRA UTCA','2',2,5,'ANTAL','','6700045028','','','',0,'f','f',18),(46,'AN','DEBRECEN','KARTÁCS UTCA','21',0,0,'','','6300046965','','','',0,'f','f',1),(47,'AM','DEBRECEN','DERÉK UTCA','197',1,3,'','','6300047879','','','',0,'f','f',0),(48,'AE','DEBRECEN','VÁRMEGYEHÁZA UTCA','1/b',0,0,'levéltár épülete','','6700048008','','','',0,'f','f',0),(49,'AT','DEBRECEN','VEZÉR UTCA','-',0,0,'','IT SERVICES','6300049901','','','',0,'f','f',1),(50,'AN','DEBRECEN','MIKEPÉRCSI ÚT','132',0,0,'','GALAXI FITNESS','6300050071','6520050339','','',0,'f','f',6),(51,'AT','DEBRECEN','MIKEPÉRCSI ÚT','45/B',4,2,'42','','6300051919','','','',0,'f','f',1),(52,'AT','DEBRECEN','PALLAGI ÚT','13',0,0,'','TEVA','6300052352','','','',0,'f','f',1),(53,'AB','DEBRECEN','KÉKI LAJOS UTCA','3',0,0,'','','6300053468','','','',0,'f','f',2),(54,'AÁ','DEBRECEN','DERÉK UTCA','142',7,60,'CSÖRGETNI','','6700054912','','','',0,'f','f',1),(55,'AR','DEBRECEN','PIAC UTCA','32',0,0,'','centrál biliárd klub','6700055842','','','',0,'f','f',0),(56,'AL','DEBRECEN','VÁG UTCA','27',3,10,'CSÖRGETNI','','6700056584','','','',100,'f','f',0),(57,'AC','DEBRECEN','DOMB UTCA','1',0,0,'','KIS CAMPUS ÉTTEREM','6300057675','','','',0,'f','f',1),(58,'AB','DEBRECEN','piac','1',5,55,'','','6700058398','6700058632','6700058407','',0,'f','f',43),(59,'AA','DEBRECEN','PESTI UTCA','29-31',0,0,'CSÖRGETNI','KINCSES VENDÉGHÁZ','6300059797','','','',0,'f','f',7),(60,'AJ','DEBRECEN','HÍD UTCA','1',0,0,'CSÖRGETNI','TIGÁZ PORTA','6300060548','','','',0,'f','f',12),(61,'AG','DEBRECEN','KASSAI','26',0,0,'','CAMPUS B','6200061700','','','',0,'f','f',1),(62,'AB','DEBRECEN','EGYETEM TÉR','1',2,203,'BTK,NEVELÉSTUDOMÁNYO','FŐÉPÜLET','6300062141','','','',0,'f','f',2),(63,'AZ','DEBRECEN','BÖSZÖRMÉNYI','1',0,0,'','','6300063931','','','',0,'f','f',1),(64,'AA','DEBRECEN','KURUCZ','X',0,0,'','KIS KURUC PRESSO','6200064722','','','',0,'f','f',1),(65,'AH','DEBRECEN','HÍD','10-12',0,0,'csörgetni','eon első porta','6700065321','','','',0,'f','f',1),(66,'AP','DEBRECEN','ZOLTAI LAJOS UTCA','15',0,0,'CSÖRGETNI','','6300066677','','','',0,'f','f',1),(67,'AI','DEBRECEN','CIVIS UTCA','11',1,13,'','','6200067353','','','',0,'f','f',1),(68,'AE','DEBRECEN','SIMONFFY UTCA','13',2,5,'8','','6200068990','','','',0,'f','f',9),(69,'AE','DEBRECEN','CSAPÓ UTCA','80',7,21,'','','6300069060','6300069838','','',0,'f','f',1),(70,'AN','DEBRECEN','petőfi tér','17',3,9,'CSÖRGETNI','','6300070789','','','',0,'f','f',2),(71,'AA','DEBRECEN','MONOSTORPÁLYI ÚT','189',0,0,'','','6520071292','','','',0,'f','f',1),(72,'AP','DEBRECEN','KÁLVIN TÉR','16',0,0,'csörgetni','REFORMÁTUS KOLI','6300072265','','','',0,'f','f',1),(73,'AJ','DEBRECEN','HAJNAL UTCA','1',3,8,'','','6300073151','','','',0,'f','f',9),(74,'AS','DEBRECEN','burgundia ','4',1,7,'','','6300074813','','','',0,'f','f',7),(75,'AA','DEBRECEN','KISHATÁR ÚT','1',0,0,'','STOP SHOP ZOO DOM ÁL','6200075293','','','',0,'f','f',3),(76,'AA','DEBRECEN','HÍD UTCA','10-12',0,0,'','EON FŐPORTA','6300076659','','','',0,'f','f',13),(77,'AS','DEBRECEN','MIKEPÉRCSI','X',0,0,'','REPTÉR ELSŐ PORTA','6700077250','','','',50,'f','f',2),(78,'AJ','DEBRECEN','MALOMKÖZ','8',3,11,'','','6300078525','','','2-ES LÉPCSŐHÁZ',0,'f','f',1),(79,'AK','DEBRECEN','PALLAGI ÚT','13',0,0,'','TEVA -FŐPORTA','6300079731','','','',0,'f','f',3),(80,'AT','DEBRECEN','KÍGYÓHAGYMA UTCA','8',0,0,'','PHARMAPOLISZ','6200080553','','','',0,'f','f',4),(81,'AG','DEBRECEN','Gyulai','32',0,0,'','','6300081089','','','',0,'f','f',1),(82,'AK','DEBRECEN','BARTÓK BÉLA UTCA','2-26',0,0,'','KENÉZY BELGYÓGYÁSZAT','6300082828','','','',0,'f','f',2),(83,'AL','DEBRECEN','BÖSZÖRMÉNYI ÚT','101',1,4,'4','','6300083218','','','',0,'f','f',2),(84,'AS','DEBRECEN','SÍNAI MIKLÓS','31',5,22,'','','6300084515','','','',0,'f','f',16),(85,'AC','DEBRECEN','MATA JÁNOS UTCA','21',0,4,'','','6200085128','','','',0,'f','f',4),(86,'AV','DEBRECEN','KOMLÓSSY UTCA','37',0,0,'CSÖRGETNI','','6300086225','','','',0,'f','f',1),(87,'AK','DEBRECEN','NAGYAERDEI KRT','98',0,0,'','KLINIKA MR HÁZ','6300087969','','','',0,'f','f',2),(88,'AK','DEBRECEN','KISHEGYESI ÚT','61/A',2,8,'GYŐRI VIRÁG','','6200088259','','','',0,'f','f',1),(89,'AP','DEBRECEN','VARGA UTCA','23',3,19,'','','6300089677','','','',0,'f','f',4),(90,'AÉ','DEBRECEN','KASSAI ÚT','92',0,0,'','OMW KÚT','6700090455','','','',0,'f','f',2),(91,'AY','DEBRECEN','ANGYALFÖLDTÉR','10',5,75,'','','6300091442','','','',0,'f','f',6),(92,'AK','DEBRECEN','PAJTÁS UTCA','1',0,0,'','','6300092442','','','',0,'f','f',16),(93,'AN','DEBRECEN','HORTOBÁGY UTCA','19',3,12,'','','6200093931','','','',0,'f','f',2),(94,'AF','DEBRECEN','DOMB UTCA','1',0,0,'','COPY CON KFT','6300094044','','','',0,'f','f',4),(95,'AK','DEBRECEN','NAGYERDEI KRT','66',0,0,'RECEPCIÓRA','POSTÁS ÜDÜLŐ','6300095638','','','',0,'f','f',21),(96,'AZ','DEBRECEN','BARTÓK BÉLA UTCA','73/A',0,0,'','','6300096663','','','',0,'f','f',37),(97,'AF','DEBRECEN','BAJCSY ZSILINSZKY UT','75',0,0,'CSÖRGETNI','','6300097136','','','',0,'f','f',1),(98,'AM','DEBRECEN','SUMEN UTCA','20',0,3,'','','6700098537','','','',0,'f','f',4),(99,'AL','DEBRECEN','CSAPÓ UTCA','96',2,4,'','','6300099704','','','',0,'f','f',1),(100,'AN','DEBRECEN','EGYETEM TÉR','1',2,2052,'','ÉLETTUDOMÁNYI KÖZP.','6300100027','','','LABOR',0,'f','f',2);
/*!40000 ALTER TABLE `homework` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-03 15:46:30
