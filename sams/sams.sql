-- MySQL dump 10.14  Distrib 5.5.41-MariaDB, for debian-linux-gnu (i686)
--
-- Host: localhost    Database: sams
-- ------------------------------------------------------
-- Server version	5.5.41-MariaDB-1ubuntu0.14.04.1

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
-- Table structure for table `courses`
--
use sams
DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `courses` (
  `course_code` varchar(8) NOT NULL,
  `course_name` varchar(30) NOT NULL,
  `faculty_id` varchar(6) NOT NULL,
  PRIMARY KEY (`course_code`,`faculty_id`),
  KEY `fk_courses_faculties1` (`faculty_id`),
  CONSTRAINT `fk_courses_faculties1` FOREIGN KEY (`faculty_id`) REFERENCES `faculties` (`faculty_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES ('CEF405','Technical Writing','FET'),('CEF409','Artificial Inteligence','FET'),('CEF499','Aerodynamics and aeronautics','FET');
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `dept_id` varchar(8) NOT NULL,
  `dept_name` varchar(30) NOT NULL,
  `faculty_id` varchar(6) NOT NULL,
  PRIMARY KEY (`dept_id`,`faculty_id`),
  KEY `fk_department_faculties1` (`faculty_id`),
  CONSTRAINT `fk_department_faculties1` FOREIGN KEY (`faculty_id`) REFERENCES `faculties` (`faculty_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES ('COMP','COMPUTER ENGINEERING','COT'),('COMP','COMPUTER ENGINEERING','FET'),('COMPCOT','COMPUTER ENGINEERING(COT)','COT'),('CST/GEO','CST Geography','FED'),('CST/HIS','Curriculum Studies and Teachin','FED'),('EEE','ELECTRICAL AND ELECTRONIC ENGI','FET');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculties`
--

DROP TABLE IF EXISTS `faculties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `faculties` (
  `faculty_id` varchar(6) NOT NULL,
  `faculty_name` varchar(30) NOT NULL,
  PRIMARY KEY (`faculty_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculties`
--

LOCK TABLES `faculties` WRITE;
/*!40000 ALTER TABLE `faculties` DISABLE KEYS */;
INSERT INTO `faculties` VALUES ('ASTI','ARTS and Translation'),('COT','College of Technology'),('FED','EDUCATION'),('FET','FACULTY OF ENGINEERING AND TEC');
/*!40000 ALTER TABLE `faculties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `programme`
--

DROP TABLE IF EXISTS `programme`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `programme` (
  `dept_id` varchar(10) NOT NULL DEFAULT '',
  `prog_name` varchar(10) NOT NULL DEFAULT '',
  `specialty` varchar(6) NOT NULL,
  `name_of_specialty` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`dept_id`,`prog_name`),
  CONSTRAINT `programme_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `department` (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `programme`
--

LOCK TABLES `programme` WRITE;
/*!40000 ALTER TABLE `programme` DISABLE KEYS */;
INSERT INTO `programme` VALUES ('COMP','BENG','NE','NETWORK ENGINEERING');
/*!40000 ALTER TABLE `programme` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `staff` (
  `staff_id` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `staff_fname` varchar(20) NOT NULL,
  `staff_lname` varchar(30) NOT NULL,
  `position` varchar(10) NOT NULL,
  `dept_id` varchar(8) NOT NULL,
  PRIMARY KEY (`staff_id`,`password`,`dept_id`),
  KEY `fk_staff_department1` (`dept_id`),
  CONSTRAINT `fk_staff_department1` FOREIGN KEY (`dept_id`) REFERENCES `department` (`dept_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES ('admin@gmail.com','easy','Mr','Admin','lecturer','COMP');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff_teaches_courses`
--

DROP TABLE IF EXISTS `staff_teaches_courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `staff_teaches_courses` (
  `staff_staff_id` varchar(20) NOT NULL,
  `course_code` varchar(8) NOT NULL,
  PRIMARY KEY (`staff_staff_id`,`course_code`),
  KEY `fk_staff_has_courses_courses1` (`course_code`),
  KEY `fk_staff_has_courses_staff1` (`staff_staff_id`),
  CONSTRAINT `fk_staff_has_courses_courses1` FOREIGN KEY (`course_code`) REFERENCES `courses` (`course_code`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_staff_has_courses_staff1` FOREIGN KEY (`staff_staff_id`) REFERENCES `staff` (`staff_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff_teaches_courses`
--

LOCK TABLES `staff_teaches_courses` WRITE;
/*!40000 ALTER TABLE `staff_teaches_courses` DISABLE KEYS */;
INSERT INTO `staff_teaches_courses` VALUES ('admin@gmail.com','CEF405'),('admin@gmail.com','CEF409'),('admin@gmail.com','CEF499');
/*!40000 ALTER TABLE `staff_teaches_courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_attends_courses`
--

DROP TABLE IF EXISTS `student_attends_courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_attends_courses` (
  `student_id` int(11) NOT NULL,
  `student_matricule` char(8) NOT NULL,
  `course_code` varchar(8) NOT NULL,
  `staff_id` varchar(20) NOT NULL,
  `date` date NOT NULL,
  `is_extra_class` tinyint(1) DEFAULT '0',
  `time` time NOT NULL,
  KEY `fk_student_takes_course_has_staff_teaches_courses_staff_teach1` (`staff_id`),
  KEY `fk_student_takes_course_has_staff_teaches_courses_student_tak1` (`student_id`,`student_matricule`,`course_code`),
  CONSTRAINT `fk_student_takes_course_has_staff_teaches_courses_staff_teach1` FOREIGN KEY (`staff_id`) REFERENCES `staff_teaches_courses` (`staff_staff_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_takes_course_has_staff_teaches_courses_student_tak1` FOREIGN KEY (`student_id`, `student_matricule`, `course_code`) REFERENCES `student_takes_course` (`student_info_id`, `student_matricule`, `course_code`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_attends_courses`
--

LOCK TABLES `student_attends_courses` WRITE;
/*!40000 ALTER TABLE `student_attends_courses` DISABLE KEYS */;
INSERT INTO `student_attends_courses` VALUES (14,'FE12A107','CEF409','admin@gmail.com','2015-03-01',0,'23:58:10'),(15,'FE12A104','CEF409','admin@gmail.com','2015-03-01',0,'23:58:10'),(16,'FE12A127','CEF409','admin@gmail.com','2015-03-01',0,'23:58:10'),(17,'FE12A124','CEF409','admin@gmail.com','2015-03-01',0,'23:58:10'),(18,'FE12A197','CEF409','admin@gmail.com','2015-03-01',0,'23:58:11'),(19,'FE12A125','CEF409','admin@gmail.com','2015-03-01',0,'23:58:11'),(14,'FE12A107','CEF409','admin@gmail.com','2015-03-01',0,'23:59:16'),(15,'FE12A104','CEF409','admin@gmail.com','2015-03-01',0,'23:59:16'),(16,'FE12A127','CEF409','admin@gmail.com','2015-03-01',0,'23:59:16'),(17,'FE12A124','CEF409','admin@gmail.com','2015-03-01',0,'23:59:16'),(18,'FE12A197','CEF409','admin@gmail.com','2015-03-01',0,'23:59:16'),(19,'FE12A125','CEF409','admin@gmail.com','2015-03-01',0,'23:59:16'),(20,'FE12A198','CEF409','admin@gmail.com','2015-03-01',0,'23:59:16'),(21,'FE12A195','CEF409','admin@gmail.com','2015-03-01',0,'23:59:16'),(22,'FE12A201','CEF409','admin@gmail.com','2015-03-01',0,'23:59:16'),(23,'FE12A192','CEF409','admin@gmail.com','2015-03-01',0,'23:59:16'),(24,'FE12A221','CEF409','admin@gmail.com','2015-03-01',0,'23:59:16'),(25,'FE12A122','CEF409','admin@gmail.com','2015-03-01',0,'23:59:16'),(26,'FE12A121','CEF409','admin@gmail.com','2015-03-01',0,'23:59:16'),(27,'FE12A132','CEF409','admin@gmail.com','2015-03-01',0,'23:59:16'),(16,'FE12A127','CEF409','admin@gmail.com','2015-06-03',0,'23:43:45'),(23,'FE12A192','CEF409','admin@gmail.com','2015-06-03',0,'23:43:46'),(16,'FE12A127','CEF409','admin@gmail.com','2015-06-03',0,'23:44:25'),(23,'FE12A192','CEF409','admin@gmail.com','2015-06-03',0,'23:44:25'),(14,'FE12A107','CEF409','admin@gmail.com','2015-06-03',0,'23:50:40'),(15,'FE12A104','CEF409','admin@gmail.com','2015-06-03',0,'23:50:40'),(16,'FE12A127','CEF409','admin@gmail.com','2015-06-03',0,'23:50:40'),(17,'FE12A124','CEF409','admin@gmail.com','2015-06-03',0,'23:50:40'),(18,'FE12A197','CEF409','admin@gmail.com','2015-06-03',0,'23:50:40'),(19,'FE12A125','CEF409','admin@gmail.com','2015-06-03',0,'23:50:40'),(20,'FE12A198','CEF409','admin@gmail.com','2015-06-03',0,'23:50:40'),(21,'FE12A195','CEF409','admin@gmail.com','2015-06-03',0,'23:50:40'),(22,'FE12A201','CEF409','admin@gmail.com','2015-06-03',0,'23:50:40'),(23,'FE12A192','CEF409','admin@gmail.com','2015-06-03',0,'23:50:40'),(24,'FE12A221','CEF409','admin@gmail.com','2015-06-03',0,'23:50:40'),(25,'FE12A122','CEF409','admin@gmail.com','2015-06-03',0,'23:50:40'),(26,'FE12A121','CEF409','admin@gmail.com','2015-06-03',0,'23:50:40'),(27,'FE12A132','CEF409','admin@gmail.com','2015-06-03',0,'23:50:40'),(14,'FE12A107','CEF409','admin@gmail.com','2015-06-03',0,'23:59:35'),(15,'FE12A104','CEF409','admin@gmail.com','2015-06-03',0,'23:59:35'),(16,'FE12A127','CEF409','admin@gmail.com','2015-06-03',0,'23:59:35'),(17,'FE12A124','CEF409','admin@gmail.com','2015-06-03',0,'23:59:35'),(18,'FE12A197','CEF409','admin@gmail.com','2015-06-03',0,'23:59:35'),(19,'FE12A125','CEF409','admin@gmail.com','2015-06-03',0,'23:59:35'),(20,'FE12A198','CEF409','admin@gmail.com','2015-06-03',0,'23:59:35'),(21,'FE12A195','CEF409','admin@gmail.com','2015-06-03',0,'23:59:35'),(22,'FE12A201','CEF409','admin@gmail.com','2015-06-03',0,'23:59:35'),(23,'FE12A192','CEF409','admin@gmail.com','2015-06-03',0,'23:59:35'),(14,'FE12A107','CEF409','admin@gmail.com','2015-07-03',0,'00:34:48'),(15,'FE12A104','CEF409','admin@gmail.com','2015-07-03',0,'00:34:48'),(17,'FE12A124','CEF409','admin@gmail.com','2015-07-03',0,'00:34:48'),(18,'FE12A197','CEF409','admin@gmail.com','2015-07-03',0,'00:34:48'),(19,'FE12A125','CEF409','admin@gmail.com','2015-07-03',0,'00:34:48'),(20,'FE12A198','CEF409','admin@gmail.com','2015-07-03',0,'00:34:48'),(21,'FE12A195','CEF409','admin@gmail.com','2015-07-03',0,'00:34:49'),(22,'FE12A201','CEF409','admin@gmail.com','2015-07-03',0,'00:34:49'),(24,'FE12A221','CEF409','admin@gmail.com','2015-07-03',0,'00:34:49'),(25,'FE12A122','CEF409','admin@gmail.com','2015-07-03',0,'00:34:49'),(26,'FE12A121','CEF409','admin@gmail.com','2015-07-03',0,'00:34:49'),(27,'FE12A132','CEF409','admin@gmail.com','2015-07-03',0,'00:34:49'),(14,'FE12A107','CEF409','admin@gmail.com','2015-07-03',0,'10:57:53'),(15,'FE12A104','CEF409','admin@gmail.com','2015-07-03',0,'10:57:53'),(16,'FE12A127','CEF409','admin@gmail.com','2015-07-03',0,'10:57:53'),(17,'FE12A124','CEF409','admin@gmail.com','2015-07-03',0,'10:57:53'),(18,'FE12A197','CEF409','admin@gmail.com','2015-07-03',0,'10:57:53'),(19,'FE12A125','CEF409','admin@gmail.com','2015-07-03',0,'10:57:53'),(20,'FE12A198','CEF409','admin@gmail.com','2015-07-03',0,'10:57:53'),(21,'FE12A195','CEF409','admin@gmail.com','2015-07-03',0,'10:57:53'),(24,'FE12A221','CEF409','admin@gmail.com','2015-07-03',0,'10:57:53'),(25,'FE12A122','CEF409','admin@gmail.com','2015-07-03',0,'10:57:53'),(26,'FE12A121','CEF409','admin@gmail.com','2015-07-03',0,'10:57:53'),(25,'FE12A122','CEF409','admin@gmail.com','2015-07-03',0,'10:58:17'),(26,'FE12A121','CEF409','admin@gmail.com','2015-07-03',0,'10:58:17'),(27,'FE12A132','CEF409','admin@gmail.com','2015-07-03',0,'10:58:17');
/*!40000 ALTER TABLE `student_attends_courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_info`
--

DROP TABLE IF EXISTS `student_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `matricule` char(8) NOT NULL,
  `fname` varchar(20) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `is_photo_set` tinyint(4) DEFAULT '0',
  `current_level` varchar(5) NOT NULL,
  `dept_id` varchar(8) NOT NULL,
  `programme` varchar(8) NOT NULL,
  PRIMARY KEY (`id`,`matricule`,`dept_id`),
  UNIQUE KEY `matricule` (`matricule`),
  UNIQUE KEY `matricule_2` (`matricule`),
  KEY `fk_student_info_department1` (`dept_id`),
  CONSTRAINT `fk_student_info_department1` FOREIGN KEY (`dept_id`) REFERENCES `department` (`dept_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_info`
--

LOCK TABLES `student_info` WRITE;
/*!40000 ALTER TABLE `student_info` DISABLE KEYS */;
INSERT INTO `student_info` VALUES (14,'FE12A107','Weke','Fake',0,'400','COMP','BEng'),(15,'FE12A104','Wase','Nganji',0,'400','COMP','BEng'),(16,'FE12A127','Wepsingong','Kongnyu',0,'400','COMP','BEng'),(17,'FE12A124','Fantang','Konji',0,'400','COMP','BEng'),(18,'FE12A197','Wepsibu','Kokay',0,'400','COMP','BEng'),(19,'FE12A125','Murboh','Mukwe',0,'400','COMP','BEng'),(20,'FE12A198','Wepbu','Njohkay',0,'400','COMP','BEng'),(21,'FE12A195','Abia','Manaka',0,'400','COMP','BEng'),(22,'FE12A201','Bantu','Njohkay',0,'400','COMP','BEng'),(23,'FE12A192','Faziatu','Manaka',0,'400','COMP','BEng'),(24,'FE12A221','Bongntu','Munyu',0,'400','COMP','BEng'),(25,'FE12A122','Babayaru','Manaka',0,'400','COMP','BEng'),(26,'FE12A121','Fangntu','Munyu',0,'400','COMP','BEng'),(27,'FE12A132','Muwir','Kwahnsung',0,'400','COMP','BEng');
/*!40000 ALTER TABLE `student_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_takes_course`
--

DROP TABLE IF EXISTS `student_takes_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_takes_course` (
  `student_info_id` int(11) NOT NULL,
  `student_matricule` char(8) NOT NULL,
  `course_code` varchar(8) NOT NULL,
  `ca_marks` tinyint(4) DEFAULT '0',
  `exam_mark` tinyint(4) DEFAULT '0',
  `grade` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`student_info_id`,`student_matricule`,`course_code`),
  KEY `fk_student_info_has_courses_courses1` (`course_code`),
  KEY `fk_student_info_has_courses_student_info` (`student_info_id`,`student_matricule`),
  CONSTRAINT `fk_student_info_has_courses_courses1` FOREIGN KEY (`course_code`) REFERENCES `courses` (`course_code`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_info_has_courses_student_info` FOREIGN KEY (`student_info_id`, `student_matricule`) REFERENCES `student_info` (`id`, `matricule`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_takes_course`
--

LOCK TABLES `student_takes_course` WRITE;
/*!40000 ALTER TABLE `student_takes_course` DISABLE KEYS */;
INSERT INTO `student_takes_course` VALUES (14,'FE12A107','CEF409',0,0,NULL),(15,'FE12A104','CEF409',0,0,NULL),(16,'FE12A127','CEF409',0,0,NULL),(17,'FE12A124','CEF409',0,0,NULL),(18,'FE12A197','CEF409',0,0,NULL),(19,'FE12A125','CEF409',0,0,NULL),(20,'FE12A198','CEF409',0,0,NULL),(21,'FE12A195','CEF409',0,0,NULL),(22,'FE12A201','CEF409',0,0,NULL),(23,'FE12A192','CEF409',0,0,NULL),(24,'FE12A221','CEF409',0,0,NULL),(25,'FE12A122','CEF409',0,0,NULL),(26,'FE12A121','CEF409',0,0,NULL),(27,'FE12A132','CEF409',0,0,NULL);
/*!40000 ALTER TABLE `student_takes_course` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-03-07 13:22:03
