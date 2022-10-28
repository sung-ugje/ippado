-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: ippado
-- ------------------------------------------------------
-- Server version	5.5.5-10.7.3-MariaDB-1:10.7.3+maria~focal

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
-- Table structure for table `IDS`
--

DROP TABLE IF EXISTS `IDS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `IDS` (
  `TABLE_NAME` varchar(20) NOT NULL,
  `NEXT_ID` decimal(30,0) NOT NULL DEFAULT 0,
  PRIMARY KEY (`TABLE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='IDS';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `IDS`
--

LOCK TABLES `IDS` WRITE;
/*!40000 ALTER TABLE `IDS` DISABLE KEYS */;
INSERT INTO `IDS` VALUES ('BBS_ID',1),('FILE_ID',1),('LOGINLOG_ID',821),('PROGRAM_ID',1),('SAMPLE',1),('SYSLOG_ID',1),('TMPLAT_ID',1),('USRCNFRM_ID',11);
/*!40000 ALTER TABLE `IDS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `IPD_AUTHOR`
--

DROP TABLE IF EXISTS `IPD_AUTHOR`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `IPD_AUTHOR` (
  `AUTHOR_CODE` varchar(30) NOT NULL DEFAULT '' COMMENT '권한코드',
  `AUTHOR_NM` varchar(60) NOT NULL COMMENT '권한명',
  `AUTHOR_DC` varchar(200) DEFAULT NULL COMMENT '권한설명',
  `AUTHOR_CREAT_DE` char(20) NOT NULL COMMENT '권한생성일',
  PRIMARY KEY (`AUTHOR_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='권한정보';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `IPD_AUTHOR`
--

LOCK TABLES `IPD_AUTHOR` WRITE;
/*!40000 ALTER TABLE `IPD_AUTHOR` DISABLE KEYS */;
INSERT INTO `IPD_AUTHOR` VALUES ('ROLE_ADMIN','전체관리자','시스템의 모든 메뉴에 접근할수있다.','2011-08-03'),('ROLE_USER_MEMBER','티켓 오퍼레이터','티켓발급과 관련된 메뉴에 접근할 수 있다.','2011-08-03');
/*!40000 ALTER TABLE `IPD_AUTHOR` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `IPD_AUTHOR_ROLE`
--

DROP TABLE IF EXISTS `IPD_AUTHOR_ROLE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `IPD_AUTHOR_ROLE` (
  `AUTHOR_CODE` varchar(30) NOT NULL COMMENT '권한코드',
  `ROLE_CODE` varchar(50) NOT NULL COMMENT '롤코드',
  `CREAT_DT` datetime DEFAULT NULL COMMENT '생성일시',
  PRIMARY KEY (`AUTHOR_CODE`,`ROLE_CODE`),
  KEY `R_292` (`ROLE_CODE`),
  CONSTRAINT `IPD_AUTHOR_ROLE_ibfk_1` FOREIGN KEY (`AUTHOR_CODE`) REFERENCES `IPD_AUTHOR` (`AUTHOR_CODE`) ON DELETE CASCADE,
  CONSTRAINT `IPD_AUTHOR_ROLE_ibfk_2` FOREIGN KEY (`ROLE_CODE`) REFERENCES `IPD_ROLE` (`ROLE_CODE`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='권한롤관계';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `IPD_AUTHOR_ROLE`
--

LOCK TABLES `IPD_AUTHOR_ROLE` WRITE;
/*!40000 ALTER TABLE `IPD_AUTHOR_ROLE` DISABLE KEYS */;
INSERT INTO `IPD_AUTHOR_ROLE` VALUES ('ROLE_ADMIN','sec-gmt','2009-08-25 00:00:00'),('ROLE_ADMIN','sec-ram','2009-08-25 00:00:00'),('ROLE_ADMIN','sec-rgm','2009-08-25 00:00:00'),('ROLE_ADMIN','sec-rmt','2009-08-25 00:00:00'),('ROLE_ADMIN','sym-ccm-cca','2009-08-25 00:00:00'),('ROLE_ADMIN','sym-ccm-ccc','2009-08-25 00:00:00'),('ROLE_ADMIN','sym-ccm-cde','2009-08-25 00:00:00'),('ROLE_ADMIN','sym-ccm-zip','2009-08-25 00:00:00'),('ROLE_ADMIN','sym-mnu-mcm','2009-08-25 00:00:00'),('ROLE_ADMIN','sym-mnu-mpm','2009-08-25 00:00:00'),('ROLE_ADMIN','sym-prm','2009-08-25 00:00:00'),('ROLE_ADMIN','uat-uap','2009-08-25 00:00:00'),('ROLE_ADMIN','uss-umt-cmm','2009-08-25 00:00:00'),('ROLE_ADMIN','uss-umt-user','2009-08-25 00:00:00'),('ROLE_USER_MEMBER','cop-com','2009-08-25 00:00:00'),('ROLE_USER_MEMBER','sts-cst','2009-08-25 00:00:00'),('ROLE_USER_MEMBER','sym-log-clg','2009-08-25 00:00:00'),('ROLE_USER_MEMBER','uss-ion-uas','2009-08-25 00:00:00');
/*!40000 ALTER TABLE `IPD_AUTHOR_ROLE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `IPD_CL_CODE`
--

DROP TABLE IF EXISTS `IPD_CL_CODE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `IPD_CL_CODE` (
  `CL_CODE` char(3) NOT NULL COMMENT '분류코드',
  `CL_CODE_NM` varchar(60) DEFAULT NULL COMMENT '분류코드명',
  `CL_CODE_DC` varchar(200) DEFAULT NULL COMMENT '분류코드설명',
  `USE_AT` char(1) DEFAULT NULL COMMENT '사용여부',
  `FRST_REGIST_PNTTM` datetime DEFAULT NULL COMMENT '최초등록시점',
  `FRST_REGISTER_ID` varchar(20) DEFAULT NULL COMMENT '최초등록자ID',
  `LAST_UPDT_PNTTM` datetime DEFAULT NULL COMMENT '최종수정시점',
  `LAST_UPDUSR_ID` varchar(20) DEFAULT NULL COMMENT '최종수정자ID',
  PRIMARY KEY (`CL_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='공통분류코드';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `IPD_CL_CODE`
--

LOCK TABLES `IPD_CL_CODE` WRITE;
/*!40000 ALTER TABLE `IPD_CL_CODE` DISABLE KEYS */;
INSERT INTO `IPD_CL_CODE` VALUES ('IPD','서해도선','서해도선 프로잭트에서 사용하는 코드','Y','2022-03-06 04:22:28',NULL,'2022-03-06 04:22:28',NULL),('LET','경량 템플릿','경량 템플릿','Y','2011-08-02 21:13:03','SYSTEM','2022-03-06 04:20:23',NULL),('WSF','서해도선','서해도선에서사용하는 코드','Y','2022-04-03 03:22:12',NULL,'2022-04-03 03:22:12',NULL);
/*!40000 ALTER TABLE `IPD_CL_CODE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `IPD_CODE`
--

DROP TABLE IF EXISTS `IPD_CODE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `IPD_CODE` (
  `CODE_ID` varchar(6) NOT NULL COMMENT '코드ID',
  `CODE_ID_NM` varchar(60) DEFAULT NULL COMMENT '코드ID명',
  `CODE_ID_DC` varchar(200) DEFAULT NULL COMMENT '코드ID설명',
  `USE_AT` char(1) DEFAULT NULL COMMENT '사용여부',
  `CL_CODE` char(3) DEFAULT NULL COMMENT '분류코드',
  `FRST_REGIST_PNTTM` datetime DEFAULT NULL COMMENT '최초등록시점',
  `FRST_REGISTER_ID` varchar(20) DEFAULT NULL COMMENT '최초등록자ID',
  `LAST_UPDT_PNTTM` datetime DEFAULT NULL COMMENT '최종수정시점',
  `LAST_UPDUSR_ID` varchar(20) DEFAULT NULL COMMENT '최종수정자ID',
  PRIMARY KEY (`CODE_ID`),
  KEY `R_179` (`CL_CODE`),
  CONSTRAINT `IPD_CODE_ibfk_1` FOREIGN KEY (`CL_CODE`) REFERENCES `IPD_CL_CODE` (`CL_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='공통코드';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `IPD_CODE`
--

LOCK TABLES `IPD_CODE` WRITE;
/*!40000 ALTER TABLE `IPD_CODE` DISABLE KEYS */;
INSERT INTO `IPD_CODE` VALUES ('COM001','등록구분','게시판, 커뮤니티, 동호회 등록구분코드1','Y','LET','2011-08-02 21:13:03','SYSTEM','2011-08-09 17:56:24',NULL),('COM003','업무구분','업무구분코드','Y','LET','2011-08-02 21:13:03','SYSTEM','2011-08-02 21:13:03','SYSTEM'),('COM004','게시판유형','게시판유형구분코드','Y','LET','2011-08-02 21:13:03','SYSTEM','2011-08-02 21:13:03','SYSTEM'),('COM005','템플릿유형','템플릿유형구분코드','Y','LET','2011-08-02 21:13:03','SYSTEM','2011-08-02 21:13:03','SYSTEM'),('COM009','게시판속성','게시판 속성','Y','LET','2011-08-02 21:13:03','SYSTEM','2011-08-02 21:13:03','SYSTEM'),('COM013','회원상태','회원 가입 신청/승인/삭제를 위한 상태 구분','Y','LET','2011-08-11 11:32:57','SYSTEM','2011-08-11 11:32:57','SYSTEM'),('COM014','성별구분','남녀 성별 구분','Y','LET','2011-08-11 11:32:50','SYSTEM','2011-08-11 11:32:50','SYSTEM'),('COM022','비밀번호 힌트','비밀번호 힌트 구분코드','Y','LET','2011-08-11 11:31:02','SYSTEM','2011-08-11 11:31:02','SYSTEM'),('COM025','소속기관','소속기관정보를 관리할때 사용하는 구분코드(시스템별로 재정의)','Y','LET','2011-08-11 11:32:57','SYSTEM','2011-08-11 11:32:57','SYSTEM'),('COM029','롤유형코드','','Y','LET','2011-08-12 10:45:16','SYSTEM','2011-08-12 10:45:16','SYSTEM');
/*!40000 ALTER TABLE `IPD_CODE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `IPD_DETAIL_CODE`
--

DROP TABLE IF EXISTS `IPD_DETAIL_CODE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `IPD_DETAIL_CODE` (
  `CODE_ID` varchar(6) NOT NULL COMMENT '코드ID',
  `CODE` varchar(15) NOT NULL COMMENT '코드',
  `CODE_NM` varchar(60) DEFAULT NULL COMMENT '코드명',
  `CODE_DC` varchar(200) DEFAULT NULL COMMENT '코드설명',
  `USE_AT` char(1) DEFAULT NULL COMMENT '사용여부',
  `FRST_REGIST_PNTTM` datetime DEFAULT NULL COMMENT '최초등록시점',
  `FRST_REGISTER_ID` varchar(20) DEFAULT NULL COMMENT '최초등록자ID',
  `LAST_UPDT_PNTTM` datetime DEFAULT NULL COMMENT '최종수정시점',
  `LAST_UPDUSR_ID` varchar(20) DEFAULT NULL COMMENT '최종수정자ID',
  PRIMARY KEY (`CODE_ID`,`CODE`),
  CONSTRAINT `IPD_DETAIL_CODE_ibfk_1` FOREIGN KEY (`CODE_ID`) REFERENCES `IPD_CODE` (`CODE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='공통상세코드';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `IPD_DETAIL_CODE`
--

LOCK TABLES `IPD_DETAIL_CODE` WRITE;
/*!40000 ALTER TABLE `IPD_DETAIL_CODE` DISABLE KEYS */;
INSERT INTO `IPD_DETAIL_CODE` VALUES ('COM001','REGC01','단일 게시판 이용등록','단일 게시판 이용등록','Y','2011-08-02 21:13:03','SYSTEM','2011-08-02 21:13:03','SYSTEM'),('COM001','REGC07','게시판사용자등록','게시판사용자등록','Y','2011-08-02 21:13:03','SYSTEM','2011-08-02 21:13:03','SYSTEM'),('COM003','BBS','게시판','게시판','Y','2011-08-02 21:13:03','SYSTEM','2011-08-02 21:13:03','SYSTEM'),('COM004','BBST01','일반게시판','일반게시판','Y','2011-08-02 21:13:03','SYSTEM','2011-08-02 21:13:03','SYSTEM'),('COM004','BBST02','익명게시판','익명게시판','N','2011-08-02 21:13:03','SYSTEM','2011-08-02 21:13:03','SYSTEM'),('COM004','BBST03','공지게시판','공지게시판','Y','2011-08-02 21:13:03','SYSTEM','2011-08-02 21:13:03','SYSTEM'),('COM005','TMPT01','게시판템플릿','게시판템플릿','Y','2011-08-02 21:13:03','SYSTEM','2011-08-02 21:13:03','SYSTEM'),('COM009','BBSA01','유효게시판','유효게시판','N','2011-08-02 21:13:03','SYSTEM','2011-08-02 21:13:03','SYSTEM'),('COM009','BBSA02','갤러리','갤러리','Y','2011-08-02 21:13:03','SYSTEM','2011-08-02 21:13:03','SYSTEM'),('COM009','BBSA03','일반게시판','일반게시판','Y','2011-08-02 21:13:03','SYSTEM','2011-08-02 21:13:03','SYSTEM'),('COM013','A','회원 가입 신청 상태','회원 가입 신청 상태','Y','2011-08-11 11:32:57','SYSTEM','2011-08-11 11:32:57','SYSTEM'),('COM013','D','회원 가입 삭제 상태','회원 가입 삭제 상태','Y','2011-08-11 11:32:57','SYSTEM','2011-08-11 11:32:57','SYSTEM'),('COM013','P','회원 가입 승인 상태','회원 가입 승인 상태','Y','2011-08-11 11:32:57','SYSTEM','2011-08-11 11:32:57','SYSTEM'),('COM014','F','여자','여자','Y','2011-08-11 11:32:57','SYSTEM','2011-08-11 11:32:57','SYSTEM'),('COM014','M','남자','남자','Y','2011-08-11 11:32:57','SYSTEM','2011-08-11 11:32:57','SYSTEM'),('COM022',' P01','가장 기억에 남는 장소는?','가장 기억에 남는 장소는?','Y','2011-08-11 11:32:57','SYSTEM','2011-08-11 11:32:57','SYSTEM'),('COM022',' P02','나의 좌우명은?','나의 좌우명은?','Y','2011-08-11 11:32:57','SYSTEM','2011-08-11 11:32:57','SYSTEM'),('COM022',' P03','나의 보물 제1호는?','나의 보물 제1호는?','Y','2011-08-11 11:32:57','SYSTEM','2011-08-11 11:32:57','SYSTEM'),('COM022',' P04','가장 기억에 남는 선생님 성함은?','가장 기억에 남는 선생님 성함은?','Y','2011-08-11 11:32:57','SYSTEM','2011-08-11 11:32:57','SYSTEM'),('COM022',' P05','다른 사람은 모르는 나만의 신체비밀은?','다른 사람은 모르는 나만의 신체비밀은?','Y','2011-08-11 11:32:57','SYSTEM','2011-08-11 11:32:57','SYSTEM'),('COM025','00000001','공공기관','공공기관','Y','2011-08-11 11:33:10','SYSTEM','2011-08-11 11:33:10','SYSTEM'),('COM025','00000002','금융기관','금융기관','Y','2011-08-11 11:33:10','SYSTEM','2011-08-11 11:33:10','SYSTEM'),('COM025','00000003','교육기관','교육기관','Y','2011-08-11 11:33:10','SYSTEM','2011-08-11 11:33:10','SYSTEM'),('COM025','00000004','의료기관','의료기관','Y','2011-08-11 11:33:10','SYSTEM','2011-08-11 11:33:10','SYSTEM'),('COM029','url','URL','URL','Y','2011-08-12 10:46:18','SYSTEM','2011-08-12 10:46:18','SYSTEM');
/*!40000 ALTER TABLE `IPD_DETAIL_CODE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `IPD_GROUP`
--

DROP TABLE IF EXISTS `IPD_GROUP`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `IPD_GROUP` (
  `GROUP_ID` char(20) NOT NULL DEFAULT '' COMMENT '그룹ID',
  `GROUP_NM` varchar(60) NOT NULL COMMENT '그룹명',
  `GROUP_CREAT_DE` char(20) NOT NULL COMMENT '그룹생성일',
  `GROUP_DC` varchar(100) DEFAULT NULL COMMENT '그룹설명',
  PRIMARY KEY (`GROUP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='권한그룹정보';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `IPD_GROUP`
--

LOCK TABLES `IPD_GROUP` WRITE;
/*!40000 ALTER TABLE `IPD_GROUP` DISABLE KEYS */;
INSERT INTO `IPD_GROUP` VALUES ('GROUP_00000000000000','관리자그룹','2022-03-16 05:18:24','관리자'),('GROUP_00000000000001','티켓 오퍼레이터','2022-03-21 06:12:08','티켓 발급 업무를 하는사람.');
/*!40000 ALTER TABLE `IPD_GROUP` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `IPD_LOGIN_LOG`
--

DROP TABLE IF EXISTS `IPD_LOGIN_LOG`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `IPD_LOGIN_LOG` (
  `LOG_ID` char(20) NOT NULL COMMENT '로그ID',
  `CONECT_ID` varchar(20) DEFAULT NULL COMMENT '접속ID',
  `CONECT_IP` varchar(23) DEFAULT NULL COMMENT '접속IP',
  `CONECT_MTHD` char(4) DEFAULT NULL COMMENT '접속방식',
  `ERROR_OCCRRNC_AT` char(1) DEFAULT NULL COMMENT '오류발생여부',
  `ERROR_CODE` char(3) DEFAULT NULL COMMENT '오류코드',
  `CREAT_DT` datetime DEFAULT NULL COMMENT '생성일시',
  PRIMARY KEY (`LOG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='접속로그';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `IPD_LOGIN_LOG`
--

LOCK TABLES `IPD_LOGIN_LOG` WRITE;
/*!40000 ALTER TABLE `IPD_LOGIN_LOG` DISABLE KEYS */;
INSERT INTO `IPD_LOGIN_LOG` VALUES ('LOGIN_00000000000001','','','I','N','','2022-03-06 01:39:15'),('LOGIN_00000000000011','','','I','N','','2022-03-06 01:40:27'),('LOGIN_00000000000013','','','I','N','','2022-03-06 01:33:01'),('LOGIN_00000000000021','','','I','N','','2022-03-06 03:12:41'),('LOGIN_00000000000031','','','I','N','','2022-03-06 03:18:38'),('LOGIN_00000000000032','','','I','N','','2022-03-06 03:18:48'),('LOGIN_00000000000041','','','I','N','','2022-03-06 03:48:17'),('LOGIN_00000000000042','','','I','N','','2022-03-06 03:48:27'),('LOGIN_00000000000051','','','I','N','','2022-03-06 04:08:05'),('LOGIN_00000000000061','','','I','N','','2022-03-06 04:14:56'),('LOGIN_00000000000071','','','I','N','','2022-03-07 16:19:16'),('LOGIN_00000000000081','','','I','N','','2022-03-07 16:44:42'),('LOGIN_00000000000082','','','I','N','','2022-03-07 16:44:49'),('LOGIN_00000000000091','','','I','N','','2022-03-07 17:04:34'),('LOGIN_00000000000092','','','I','N','','2022-03-07 17:04:47'),('LOGIN_00000000000101','','','I','N','','2022-03-11 12:32:06'),('LOGIN_00000000000111','','','I','N','','2022-03-13 05:21:00'),('LOGIN_00000000000121','','','I','N','','2022-03-13 06:24:33'),('LOGIN_00000000000131','','','I','N','','2022-03-14 01:29:09'),('LOGIN_00000000000141','','','I','N','','2022-03-14 02:30:18'),('LOGIN_00000000000151','','','I','N','','2022-03-16 02:29:26'),('LOGIN_00000000000161','','','I','N','','2022-03-16 07:44:09'),('LOGIN_00000000000162','','','I','N','','2022-03-16 08:30:52'),('LOGIN_00000000000171','','','I','N','','2022-03-16 11:31:22'),('LOGIN_00000000000181','','','I','N','','2022-03-17 00:51:04'),('LOGIN_00000000000182','','','I','N','','2022-03-17 00:51:14'),('LOGIN_00000000000191','','','I','N','','2022-03-17 00:57:47'),('LOGIN_00000000000201','','','I','N','','2022-03-17 01:00:12'),('LOGIN_00000000000211','','','I','N','','2022-03-17 01:30:10'),('LOGIN_00000000000212','','','I','N','','2022-03-17 01:30:14'),('LOGIN_00000000000221','','','I','N','','2022-03-17 02:26:42'),('LOGIN_00000000000222','','','I','N','','2022-03-17 02:27:03'),('LOGIN_00000000000231','','','I','N','','2022-03-17 05:42:08'),('LOGIN_00000000000241','','','I','N','','2022-03-17 05:43:44'),('LOGIN_00000000000251','','','I','N','','2022-03-17 05:45:07'),('LOGIN_00000000000261','','','I','N','','2022-03-17 05:45:17'),('LOGIN_00000000000262','','','I','N','','2022-03-17 05:45:17'),('LOGIN_00000000000263','','','I','N','','2022-03-17 05:45:25'),('LOGIN_00000000000271','','','I','N','','2022-03-17 05:45:48'),('LOGIN_00000000000281','','','I','N','','2022-03-17 05:52:07'),('LOGIN_00000000000282','','','I','N','','2022-03-17 05:52:10'),('LOGIN_00000000000291','','','I','N','','2022-03-17 05:53:08'),('LOGIN_00000000000301','','','I','N','','2022-03-17 06:53:06'),('LOGIN_00000000000302','','','I','N','','2022-03-17 07:27:27'),('LOGIN_00000000000303','','','I','N','','2022-03-17 07:27:27'),('LOGIN_00000000000304','','','I','N','','2022-03-17 07:27:30'),('LOGIN_00000000000305','','','I','N','','2022-03-17 07:27:30'),('LOGIN_00000000000306','','','I','N','','2022-03-17 07:28:07'),('LOGIN_00000000000307','','','I','N','','2022-03-17 07:28:08'),('LOGIN_00000000000308','','','I','N','','2022-03-17 07:35:35'),('LOGIN_00000000000309','','','I','N','','2022-03-17 07:35:35'),('LOGIN_00000000000311','','','I','N','','2022-03-18 02:07:33'),('LOGIN_00000000000321','','','I','N','','2022-03-18 02:34:01'),('LOGIN_00000000000331','','','I','N','','2022-03-18 06:26:45'),('LOGIN_00000000000332','','','I','N','','2022-03-18 06:27:04'),('LOGIN_00000000000333','','','I','N','','2022-03-18 06:28:15'),('LOGIN_00000000000334','','','I','N','','2022-03-18 06:46:59'),('LOGIN_00000000000335','','','I','N','','2022-03-18 06:46:59'),('LOGIN_00000000000336','','','I','N','','2022-03-18 06:47:03'),('LOGIN_00000000000337','','','I','N','','2022-03-18 06:47:03'),('LOGIN_00000000000338','','','I','N','','2022-03-18 06:48:08'),('LOGIN_00000000000339','','','I','N','','2022-03-18 11:59:29'),('LOGIN_00000000000340','','','I','N','','2022-03-18 11:59:33'),('LOGIN_00000000000341','','','I','N','','2022-03-18 13:26:44'),('LOGIN_00000000000342','','','I','N','','2022-03-18 13:27:17'),('LOGIN_00000000000351','','','I','N','','2022-03-18 14:28:28'),('LOGIN_00000000000352','','','I','N','','2022-03-18 14:28:36'),('LOGIN_00000000000353','','','I','N','','2022-03-18 14:34:05'),('LOGIN_00000000000354','','','I','N','','2022-03-18 14:34:05'),('LOGIN_00000000000355','','','I','N','','2022-03-18 14:34:48'),('LOGIN_00000000000356','','','I','N','','2022-03-18 14:34:48'),('LOGIN_00000000000357','','','I','N','','2022-03-18 14:34:58'),('LOGIN_00000000000358','','','I','N','','2022-03-18 14:34:58'),('LOGIN_00000000000361','','','I','N','','2022-03-20 23:31:39'),('LOGIN_00000000000362','','','I','N','','2022-03-20 23:31:40'),('LOGIN_00000000000363','','','I','N','','2022-03-20 23:31:47'),('LOGIN_00000000000364','','','I','N','','2022-03-20 23:31:47'),('LOGIN_00000000000371','','','I','N','','2022-03-20 23:37:38'),('LOGIN_00000000000372','','','I','N','','2022-03-20 23:37:38'),('LOGIN_00000000000373','','','I','N','','2022-03-20 23:37:46'),('LOGIN_00000000000374','','','I','N','','2022-03-20 23:37:46'),('LOGIN_00000000000381','','','I','N','','2022-03-20 23:39:14'),('LOGIN_00000000000391','USRCNFRM_00000000000',NULL,'I','N','','2022-03-21 00:38:53'),('LOGIN_00000000000392','USRCNFRM_00000000000',NULL,'I','N','','2022-03-21 00:38:53'),('LOGIN_00000000000401','USRCNFRM_00000000000',NULL,'I','N','','2022-03-21 01:10:04'),('LOGIN_00000000000411','','','I','N','','2022-03-21 01:43:19'),('LOGIN_00000000000421','','','I','N','','2022-03-21 01:53:07'),('LOGIN_00000000000431','','','I','N','','2022-03-21 02:01:36'),('LOGIN_00000000000441','','','I','N','','2022-03-21 02:06:02'),('LOGIN_00000000000442','','','I','N','','2022-03-21 02:07:05'),('LOGIN_00000000000443','','','I','N','','2022-03-21 02:07:48'),('LOGIN_00000000000444','','','I','N','','2022-03-21 02:08:57'),('LOGIN_00000000000445','','','I','N','','2022-03-21 02:09:11'),('LOGIN_00000000000446','','','I','N','','2022-03-21 02:09:52'),('LOGIN_00000000000447','','','I','N','','2022-03-21 02:09:52'),('LOGIN_00000000000448','','','I','N','','2022-03-21 02:10:12'),('LOGIN_00000000000449','','','I','N','','2022-03-21 02:10:45'),('LOGIN_00000000000450','','','I','N','','2022-03-21 02:10:45'),('LOGIN_00000000000451','','','I','N','','2022-03-21 02:12:19'),('LOGIN_00000000000452','','','I','N','','2022-03-21 02:12:19'),('LOGIN_00000000000461','','','I','N','','2022-03-21 02:17:20'),('LOGIN_00000000000462','','','I','N','','2022-03-21 02:17:20'),('LOGIN_00000000000463','','','I','N','','2022-03-21 02:19:40'),('LOGIN_00000000000471','','','I','N','','2022-03-21 02:25:01'),('LOGIN_00000000000472','','','I','N','','2022-03-21 02:25:29'),('LOGIN_00000000000473','','','I','N','','2022-03-21 02:26:04'),('LOGIN_00000000000481','','','I','N','','2022-03-21 02:28:26'),('LOGIN_00000000000482','','','I','N','','2022-03-21 02:28:47'),('LOGIN_00000000000483','','','I','N','','2022-03-21 02:31:44'),('LOGIN_00000000000491','','','I','N','','2022-03-21 06:09:49'),('LOGIN_00000000000492','','','I','N','','2022-03-21 23:48:07'),('LOGIN_00000000000493','','','I','N','','2022-03-21 23:48:21'),('LOGIN_00000000000501','','','I','N','','2022-03-22 11:39:06'),('LOGIN_00000000000511','','','I','N','','2022-03-22 11:55:38'),('LOGIN_00000000000521','','','I','N','','2022-03-22 12:41:01'),('LOGIN_00000000000531','','','I','N','','2022-03-23 00:59:49'),('LOGIN_00000000000541','','','I','N','','2022-03-23 03:49:38'),('LOGIN_00000000000551','','','I','N','','2022-03-23 04:02:38'),('LOGIN_00000000000561','','','I','N','','2022-03-23 04:04:28'),('LOGIN_00000000000571','','','I','N','','2022-03-23 05:24:45'),('LOGIN_00000000000572','ippado',NULL,'I','N','','2022-03-23 05:25:35'),('LOGIN_00000000000573','ippado',NULL,'I','N','','2022-03-23 05:25:42'),('LOGIN_00000000000581','','','I','N','','2022-03-23 05:29:36'),('LOGIN_00000000000591','','','I','N','','2022-03-23 05:47:13'),('LOGIN_00000000000601','','','I','N','','2022-03-23 07:27:38'),('LOGIN_00000000000611','','','I','N','','2022-03-23 07:55:38'),('LOGIN_00000000000612','','','I','N','','2022-03-23 07:55:42'),('LOGIN_00000000000621','','','I','N','','2022-03-23 23:27:21'),('LOGIN_00000000000631','','','I','N','','2022-03-24 01:23:35'),('LOGIN_00000000000641','','','I','N','','2022-03-24 03:51:05'),('LOGIN_00000000000651','','','I','N','','2022-03-25 00:05:17'),('LOGIN_00000000000661','','','I','N','','2022-03-25 01:17:46'),('LOGIN_00000000000671','','','I','N','','2022-03-25 06:19:19'),('LOGIN_00000000000681','','','I','N','','2022-03-28 07:01:54'),('LOGIN_00000000000691','','','I','N','','2022-03-31 21:50:04'),('LOGIN_00000000000692','','','I','N','','2022-03-31 21:50:08'),('LOGIN_00000000000693','','','I','N','','2022-03-31 23:35:03'),('LOGIN_00000000000701','','','I','N','','2022-04-01 02:44:01'),('LOGIN_00000000000702','','','I','N','','2022-04-01 02:44:05'),('LOGIN_00000000000711','','','I','N','','2022-04-01 02:53:16'),('LOGIN_00000000000712','','','I','N','','2022-04-01 02:53:21'),('LOGIN_00000000000713','','','I','N','','2022-04-01 02:53:24'),('LOGIN_00000000000731','','','I','N','','2022-04-01 11:36:39'),('LOGIN_00000000000732','ippado',NULL,'I','N','','2022-04-01 11:42:51'),('LOGIN_00000000000741','','','I','N','','2022-04-02 22:28:49'),('LOGIN_00000000000742','','','I','N','','2022-04-03 01:36:27'),('LOGIN_00000000000751','','','I','N','','2022-04-03 02:19:47'),('LOGIN_00000000000761','','','I','N','','2022-04-03 02:52:59'),('LOGIN_00000000000762','','','I','N','','2022-04-03 02:53:32'),('LOGIN_00000000000771','','','I','N','','2022-04-03 03:56:25'),('LOGIN_00000000000781','','','I','N','','2022-04-03 04:48:21'),('LOGIN_00000000000791','','','I','N','','2022-04-03 06:58:52'),('LOGIN_00000000000801','','','I','N','','2022-04-03 12:29:17'),('LOGIN_00000000000811','','','I','N','','2022-04-04 02:02:42');
/*!40000 ALTER TABLE `IPD_LOGIN_LOG` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `IPD_LOGIN_POLICY`
--

DROP TABLE IF EXISTS `IPD_LOGIN_POLICY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `IPD_LOGIN_POLICY` (
  `USER_ID` varchar(20) NOT NULL DEFAULT '' COMMENT '사용자ID',
  `IP_INFO` varchar(23) NOT NULL COMMENT 'IP정보',
  `DPLCT_PERM_AT` char(1) NOT NULL COMMENT '중복허용여부',
  `LMTT_AT` char(1) NOT NULL COMMENT '제한여부',
  `FRST_REGISTER_ID` varchar(20) DEFAULT NULL COMMENT '최초등록자ID',
  `FRST_REGIST_PNTTM` datetime DEFAULT NULL COMMENT '최초등록시점',
  `LAST_UPDUSR_ID` varchar(20) DEFAULT NULL COMMENT '최종수정자ID',
  `LAST_UPDT_PNTTM` datetime DEFAULT NULL COMMENT '최종수정시점',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='로그인정책';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `IPD_LOGIN_POLICY`
--

LOCK TABLES `IPD_LOGIN_POLICY` WRITE;
/*!40000 ALTER TABLE `IPD_LOGIN_POLICY` DISABLE KEYS */;
/*!40000 ALTER TABLE `IPD_LOGIN_POLICY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `IPD_MBER`
--

DROP TABLE IF EXISTS `IPD_MBER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `IPD_MBER` (
  `USER_ID` varchar(20) NOT NULL COMMENT '업무사용자ID',
  `USER_NM` varchar(60) NOT NULL COMMENT '사용자명',
  `PASSWORD` varchar(200) NOT NULL COMMENT '비밀번호',
  `MBTLNUM` varchar(20) DEFAULT NULL COMMENT '모바일번호',
  `EMAIL_ADRES` varchar(50) DEFAULT NULL COMMENT '이메일주소',
  `GROUP_ID` char(20) DEFAULT NULL COMMENT '그룹ID',
  `USER_STTUS_CODE` char(1) NOT NULL COMMENT '사용자상태코드',
  `SBSCR_DE` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`USER_ID`),
  KEY `LETTNEMPLYRINFO_ibfk_2` (`GROUP_ID`),
  CONSTRAINT `IPD_MBER_ibfk_2` FOREIGN KEY (`GROUP_ID`) REFERENCES `IPD_GROUP` (`GROUP_ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='업무사용자정보';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `IPD_MBER`
--

LOCK TABLES `IPD_MBER` WRITE;
/*!40000 ALTER TABLE `IPD_MBER` DISABLE KEYS */;
INSERT INTO `IPD_MBER` VALUES ('ekxkaks','다타만','r1kqnsBW1Mqg3CNzRYsi+dEu58wx6QLjpgpKJMP80EY=','01022223333','ekxkaks0@naver.com','GROUP_00000000000001','P','2022-03-21 04:18:51'),('ippado','서해도선','3dcPgm5w+/wXqnooAWpLqZPK2aPRaKgQLIv9t6Agcdg=','010-8274-4050','ippado@ippado.co.kr','GROUP_00000000000000','P','2022-03-21 00:34:57');
/*!40000 ALTER TABLE `IPD_MBER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `IPD_MBER_AUTHOR`
--

DROP TABLE IF EXISTS `IPD_MBER_AUTHOR`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `IPD_MBER_AUTHOR` (
  `SCRTY_DTRMN_TRGET_ID` varchar(20) NOT NULL COMMENT '보안설정대상ID',
  `MBER_TY_CODE` char(5) DEFAULT NULL COMMENT '회원유형코드',
  `AUTHOR_CODE` varchar(30) NOT NULL COMMENT '권한코드',
  PRIMARY KEY (`SCRTY_DTRMN_TRGET_ID`),
  KEY `LETTNEMPLYRSCRTYESTBS_ibfk_4` (`AUTHOR_CODE`),
  CONSTRAINT `IPD_MBER_AUTHOR_ibfk_4` FOREIGN KEY (`AUTHOR_CODE`) REFERENCES `IPD_AUTHOR` (`AUTHOR_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='사용자보안설정';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `IPD_MBER_AUTHOR`
--

LOCK TABLES `IPD_MBER_AUTHOR` WRITE;
/*!40000 ALTER TABLE `IPD_MBER_AUTHOR` DISABLE KEYS */;
INSERT INTO `IPD_MBER_AUTHOR` VALUES ('ekxkaks','','ROLE_USER_MEMBER'),('ippado','','ROLE_ADMIN');
/*!40000 ALTER TABLE `IPD_MBER_AUTHOR` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `IPD_MBER_HISTORY`
--

DROP TABLE IF EXISTS `IPD_MBER_HISTORY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `IPD_MBER_HISTORY` (
  `USER_ID` varchar(20) NOT NULL,
  `CHANGE_DE` datetime NOT NULL,
  `GROUP_ID` char(20) DEFAULT NULL,
  `MBTLNUM` varchar(20) DEFAULT NULL,
  `EMAIL_ADRES` varchar(50) DEFAULT NULL,
  `USER_STTUS_CODE` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`,`CHANGE_DE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `IPD_MBER_HISTORY`
--

LOCK TABLES `IPD_MBER_HISTORY` WRITE;
/*!40000 ALTER TABLE `IPD_MBER_HISTORY` DISABLE KEYS */;
INSERT INTO `IPD_MBER_HISTORY` VALUES ('admin','2022-03-21 00:44:25','GROUP_00000000000000',NULL,'ippado@ippado.co.kr','P'),('admin','2022-03-21 00:48:39','GROUP_00000000000000','01024405548','ippado@ippado.co.kr','P'),('admin','2022-03-21 00:50:12','GROUP_00000000000000','01024405548','ippado@ippado.co.kr','P'),('admin','2022-03-21 01:32:37','GROUP_00000000000000','01024405548','ippado@ippado.co.kr','P'),('ekxkaks','2022-03-21 06:12:35','GROUP_00000000000000','01022223333','','P'),('ekxkaks','2022-03-21 06:13:05','GROUP_00000000000001','01022223333','','P'),('ippado','2022-03-21 01:33:17','GROUP_00000000000000','01024405548','ippado@ippado.co.kr','P'),('ippado','2022-03-21 01:34:53','GROUP_00000000000000','010-8274-4050','ippado@ippado.co.kr','P');
/*!40000 ALTER TABLE `IPD_MBER_HISTORY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `IPD_MENUS`
--

DROP TABLE IF EXISTS `IPD_MENUS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `IPD_MENUS` (
  `MENU_NM` varchar(60) NOT NULL COMMENT '메뉴명',
  `PROGRM_FILE_NM` varchar(60) NOT NULL COMMENT '프로그램파일명',
  `MENU_NO` decimal(20,0) NOT NULL COMMENT '메뉴번호',
  `UPPER_MENU_NO` decimal(20,0) DEFAULT NULL COMMENT '상위메뉴번호',
  `MENU_ORDR` decimal(5,0) NOT NULL COMMENT '메뉴순서',
  `MENU_DC` varchar(250) DEFAULT NULL COMMENT '메뉴설명',
  `RELATE_IMAGE_PATH` varchar(100) DEFAULT NULL COMMENT '관계이미지경로',
  `RELATE_IMAGE_NM` varchar(60) DEFAULT NULL COMMENT '관계이미지명',
  PRIMARY KEY (`MENU_NO`),
  KEY `R_2` (`PROGRM_FILE_NM`),
  KEY `R_4` (`UPPER_MENU_NO`),
  CONSTRAINT `IPD_MENUS_ibfk_2` FOREIGN KEY (`UPPER_MENU_NO`) REFERENCES `IPD_MENUS` (`MENU_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='메뉴정보';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `IPD_MENUS`
--

LOCK TABLES `IPD_MENUS` WRITE;
/*!40000 ALTER TABLE `IPD_MENUS` DISABLE KEYS */;
INSERT INTO `IPD_MENUS` VALUES ('root','dir',0,0,1,'root','/','/'),('서해도선','dir',5000000,0,5,'서해도선','/','/'),('접수자메뉴','dir',5010000,5000000,1,'접수자메뉴','/','/'),('게시판템플릿관리','EgovTemplateList',5010100,5010000,1,'게시판템플릿관리','/','/'),('게시판생성관리','EgovBoardMstrList',5010200,5010000,2,'게시판생성관리','/','/'),('게시판사용관리','EgovBoardUseInfList',5010300,5010000,3,'게시판사용관리','/','/'),('업무게시판관리','EgovInfoWorkAdmin',5010500,5010000,5,'업무게시판관리','/','/'),('사용현황관리','dir',5020000,6000000,5,'사용현황관리','/','/'),('접속로그관리','EgovLoginLogList',5020100,5020000,1,'접속로그관리','/','/'),('접속통계관리','EgovConectStats',5020200,5020000,2,'접속통계관리','/','/'),('로그인정책관리','EgovLoginPolicyList',5020300,5020000,3,'로그인정책관리','',''),('시스템관리','dir',6000000,0,6,'시스템관리','/','/'),('사용자관리','dir',6010000,6000000,1,'사용자관리','/','/'),('사용자관리','EgovUserManage',6010100,6010000,1,'사용자등록관리','/','/'),('사용자부재관리','EgovUserAbsnceList',6010200,6010000,2,'사용자부재관리','/','/'),('권한관리','dir',6020000,6000000,2,'사용자권한관리','/','/'),('권한관리','EgovAuthorManage',6020100,6020000,1,'권한관리','/','/'),('사용자별권한관리','EgovAuthorGroupManage',6020300,6010000,3,'사용자별권한관리','/','/'),('메뉴관리','dir',6030000,6000000,3,'메뉴관리','/','/'),('프로그램목록관리','EgovProgramListManage',6030100,6030000,1,'프로그램목록관리','/','/'),('권한별메뉴관리','EgovMenuCreatManage',6030200,6020000,2,'권한별메뉴관리','/','/'),('메뉴목록관리','EgovMenuManage',6030300,6030000,4,'메뉴목록관리','/','/'),('코드관리','dir',6040000,6000000,4,'코드관리','/','/'),('분류코드관리','EgovCcmCmmnClCodeList',6040100,6040000,1,'분류코드관리','/','/'),('공통코드관리','EgovCcmCmmnCodeList',6040200,6040000,2,'공통코드관리','/','/'),('상세코드관리','EgovCcmCmmnDetailCodeList',6040300,6040000,3,'상세코드관리','','');
/*!40000 ALTER TABLE `IPD_MENUS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `IPD_MENU_AUTHOR`
--

DROP TABLE IF EXISTS `IPD_MENU_AUTHOR`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `IPD_MENU_AUTHOR` (
  `MENU_NO` decimal(20,0) NOT NULL COMMENT '메뉴번호',
  `AUTHOR_CODE` varchar(30) NOT NULL COMMENT '권한코드',
  `MAPNG_CREAT_ID` varchar(30) DEFAULT NULL COMMENT '매핑생성ID',
  PRIMARY KEY (`MENU_NO`,`AUTHOR_CODE`),
  KEY `R_247` (`MAPNG_CREAT_ID`),
  KEY `R_303` (`AUTHOR_CODE`),
  CONSTRAINT `IPD_MENU_AUTHOR_ibfk_1` FOREIGN KEY (`MENU_NO`) REFERENCES `IPD_MENUS` (`MENU_NO`) ON DELETE CASCADE,
  CONSTRAINT `IPD_MENU_AUTHOR_ibfk_3` FOREIGN KEY (`AUTHOR_CODE`) REFERENCES `IPD_AUTHOR` (`AUTHOR_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='메뉴생성내역';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `IPD_MENU_AUTHOR`
--

LOCK TABLES `IPD_MENU_AUTHOR` WRITE;
/*!40000 ALTER TABLE `IPD_MENU_AUTHOR` DISABLE KEYS */;
INSERT INTO `IPD_MENU_AUTHOR` VALUES (5000000,'ROLE_ADMIN',NULL),(5000000,'ROLE_USER_MEMBER',NULL),(5010000,'ROLE_ADMIN',NULL),(5010000,'ROLE_USER_MEMBER',NULL),(5010100,'ROLE_ADMIN',NULL),(5010100,'ROLE_USER_MEMBER',NULL),(5010200,'ROLE_ADMIN',NULL),(5010200,'ROLE_USER_MEMBER',NULL),(5010300,'ROLE_ADMIN',NULL),(5010300,'ROLE_USER_MEMBER',NULL),(5010500,'ROLE_ADMIN',NULL),(5010500,'ROLE_USER_MEMBER',NULL),(5020000,'ROLE_ADMIN',NULL),(5020000,'ROLE_USER_MEMBER',NULL),(5020100,'ROLE_ADMIN',NULL),(5020100,'ROLE_USER_MEMBER',NULL),(5020200,'ROLE_ADMIN',NULL),(5020200,'ROLE_USER_MEMBER',NULL),(5020300,'ROLE_ADMIN',NULL),(5020300,'ROLE_USER_MEMBER',NULL),(6000000,'ROLE_ADMIN',NULL),(6010000,'ROLE_ADMIN',NULL),(6010100,'ROLE_ADMIN',NULL),(6010200,'ROLE_ADMIN',NULL),(6020000,'ROLE_ADMIN',NULL),(6020100,'ROLE_ADMIN',NULL),(6020300,'ROLE_ADMIN',NULL),(6030000,'ROLE_ADMIN',NULL),(6030100,'ROLE_ADMIN',NULL),(6030200,'ROLE_ADMIN',NULL),(6030300,'ROLE_ADMIN',NULL),(6040000,'ROLE_ADMIN',NULL),(6040100,'ROLE_ADMIN',NULL),(6040200,'ROLE_ADMIN',NULL),(6040300,'ROLE_ADMIN',NULL);
/*!40000 ALTER TABLE `IPD_MENU_AUTHOR` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `IPD_PROGRMS`
--

DROP TABLE IF EXISTS `IPD_PROGRMS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `IPD_PROGRMS` (
  `PROGRAM_ID` varchar(10) NOT NULL COMMENT '프로그램아이디',
  `PROGRM_FILE_NM` varchar(60) NOT NULL DEFAULT '' COMMENT '프로그램파일명',
  `PROGRM_STRE_PATH` varchar(100) NOT NULL COMMENT '프로그램저장경로',
  `PROGRM_KOREAN_NM` varchar(60) DEFAULT NULL COMMENT '프로그램한글명',
  `PROGRM_DC` varchar(200) DEFAULT NULL COMMENT '프로그램설명',
  `URL` varchar(100) NOT NULL COMMENT 'URL'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='프로그램목록';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `IPD_PROGRMS`
--

LOCK TABLES `IPD_PROGRMS` WRITE;
/*!40000 ALTER TABLE `IPD_PROGRMS` DISABLE KEYS */;
INSERT INTO `IPD_PROGRMS` VALUES ('PG_00001','Author','/sys/author/','권한수정','권한수정','/sys/author/Author.do'),('PG_00002','dir','/','디렉토리','디렉토리','/'),('PG_00003','EgovAuthorGroupManage','/sys/user/','사용자별권한관리','사용자별권한관리','/sys/user/UserAuthorListView.do'),('PG_00004','EgovAuthorInsert','/sys/author/','권한등록','권한등록','/sys/author/AuthorInsertView.do'),('PG_00005','EgovAuthorManage','/sys/author/','권한관리','권한관리','/sys/author/AuthorList.do'),('PG_00006','EgovBoardMstrList','/cop/bbs/','게시판 목록조회','게시판 목록조회','/cop/bbs/SelectBBSMasterInfs.do'),('PG_00007','EgovBoardMstrRegist','/cop/bbs/','게시판 생성','게시판 생성','/cop/bbs/addBBSMaster.do'),('PG_00008','EgovBoardMstrUpdt','/cop/bbs/','게시판 수정','게시판 수정','/cop/bbs/SelectBBSMasterInf.do'),('PG_00009','EgovBoardUseInfInqire','/cop/com/','게시판사용여부 상세조회','게시판사용여부 상세조회','/cop/com/selectBBSUseInf.do'),('PG_00010','EgovBoardUseInfList','/cop/com/','게시판사용여부 목록 조회','게시판사용여부 목록 조회','/cop/com/selectBBSUseInfs.do'),('PG_00011','EgovBoardUseInfRegist','/cop/com/','게시판사용여부 등록','게시판사용여부 등록','/cop/com/addBBSUseInf.do'),('PG_00012','EgovCcmCmmnClCodeDetail','/sys/code/','공통분류코드 상세조회','공통분류코드 상세조회','/sys/code/ClCodeDetail.do'),('PG_00013','EgovCcmCmmnClCodeList','/sys/code/','공통분류코드목록 조회','공통분류코드목록 조회','/sys/code/ClCodeList.do'),('PG_00014','EgovCcmCmmnClCodeModify','/sys/code/','공통분류코드 수정','공통분류코드 수정','/sys/code/ClCodeModify.do'),('PG_00015','EgovCcmCmmnClCodeRegist','/sys/code/','공통분류코드 등록','공통분류코드 등록','/sys/code/ClCodeRegist.do'),('PG_00016','EgovCcmCmmnCodeDetail','/sys/code/','공통코드 상세조회','공통코드 상세조회','/sys/code/CodeDetail.do'),('PG_00017','EgovCcmCmmnCodeList','/sys/code/','공통코드목록 조회','공통코드목록 조회','/sys/code/CodeList.do'),('PG_00018','EgovCcmCmmnCodeModify','/sys/code/','공통코드 수정','공통코드 수정','/sys/code/CodeModify.do'),('PG_00019','EgovCcmCmmnCodeRegist','/sys/code/','공통코드 등록','공통코드 등록','/sys/code/CodeRegist.do'),('PG_00020','EgovCcmCmmnDetailCodeDetail','/sys/code/','공통상세코드 상세조회','공통상세코드 상세조회','/sys/code/DetailCodeDetail.do'),('PG_00021','EgovCcmCmmnDetailCodeList','/sys/code/','공통상세코드목록 조회','공통상세코드목록 조회','/sys/code/DetailCodeList.do'),('PG_00022','EgovCcmCmmnDetailCodeModify','/sys/code/','공통상세코드 수정','공통상세코드 수정','/sys/code/DetailCodeModify.do'),('PG_00023','EgovCcmCmmnDetailCodeRegist','/sys/code/','공통상세코드 등록','공통상세코드 등록','/sys/code/DetailCodeRegist.do'),('PG_00024','EgovConectStats','/sys/log/','접속통계','접속통계','/sys/log/ConectStats.do'),('PG_00025','EgovFileNmSearch','/sys/menu/','파일명검색','파일명검색','/sys/menu/ProgramListSearch.do'),('PG_00026','EgovGroupInsert','/sec/gmt/','그룹등록','그룹등록','/sec/gmt/EgovGroupInsertView.do'),('PG_00027','EgovGroupManage','/sec/gmt/','그룹관리','그룹관리','/sec/gmt/EgovGroupList.do'),('PG_00028','EgovGroupUpdt','/sec/gmt/','그룹수정','그룹수정','/sec/gmt/EgovGroup.do'),('PG_00029','EgovIdDplctCnfirm','/sys/user/','아이디중복확인','아이디중복확인','/sys/user/IdDplctCnfirmView.do'),('PG_00030','EgovInfoNotice','/cop/bbs/','공지사항','공지사항','/cop/bbs/selectBoardList.do?bbsId=BBSMSTR_AAAAAAAAAAAA'),('PG_00031','EgovInfoNoticeAdmin','/cop/bbs/','공지사항관리','공지사항관리','/cop/bbs/selectBoardList.do?bbsId=BBSMSTR_AAAAAAAAAAAA'),('PG_00032','EgovInfoWork','/cop/bbs/','업무게시판','업무게시판','/cop/bbs/selectBoardList.do?bbsId=BBSMSTR_CCCCCCCCCCCC'),('PG_00033','EgovInfoWorkAdmin','/cop/bbs/','업무게시판관리','업무게시판관리','/cop/bbs/selectBoardList.do?bbsId=BBSMSTR_CCCCCCCCCCCC'),('PG_00034','EgovJoinHistory','/','입퇴사정보 관리','입퇴사정보 관리','/EgovPageLink.do?link=main/sample_menu/Sample'),('PG_00035','EgovLoginLogInqire','/sys/log/','로그인로그상세조회','로그인로그상세조회','/sys/log/InqireLoginLog.do'),('PG_00036','EgovLoginLogList','/sys/log/','로그인로그조회','로그인로그조회','/sys/log/LoginLogList.do'),('PG_00037','EgovLoginPolicyList','/sys/log/','로그인정책관리','로그인정책관리','/sys/log/LoginPolicyList.do'),('PG_00038','EgovLoginPolicyRegist','/sys/log/','로그인정책등록','로그인정책등록','/sys/log/getLoginPolicy.do'),('PG_00039','EgovLoginPolicyUpdt','/sys/log/','로그인정책수정','로그인정책수정','/sys/log/getLoginPolicy.do'),('PG_00040','EgovLoginUsr','/uat/uia/','내부업무 로그인','내부업무 로그인','/uat/uia/egovLoginUsr.do'),('PG_00041','EgovMainHome','/uat/uia/','내부업무 메인','내부업무 메인','/uat/uia/actionMain.do'),('PG_00042','EgovMberPositionl','/','직위정보 관리','직위정보 관리','/EgovPageLink.do?link=main/sample_menu/Sample'),('PG_00043','EgovMberRank','/','직급정보 관리','직급정보 관리','/EgovPageLink.do?link=main/sample_menu/Sample'),('PG_00044','EgovMenuBndeRegist','/sys/menu/','메뉴일괄등록','메뉴일괄등록','/sys/menu/MenuBndeRegist.do'),('PG_00045','EgovMenuCreat','/sys/author/','권한별메뉴','권한별메뉴','/sys/author/AuthorMenuSelect.do'),('PG_00046','EgovMenuCreatManage','/sys/author/','권한별메뉴관리','권한별메뉴관리','/sys/author/AuthorMenuManageSelect.do'),('PG_00047','EgovMenuDetailSelectUpdt','/sys/menu/','메뉴상세조회/수정','메뉴상세조회/수정','/sys/menu/MenuManageListDetailSelect.do'),('PG_00048','EgovMenuManage','/sys/menu/','메뉴관리','메뉴관리','/sys/menu/MenuManageSelect.do'),('PG_00049','EgovMenuRegist','/sys/menu/','메뉴등록','메뉴등록','/sys/menu/MenuRegistInsert.do'),('PG_00050','EgovNoticeInqire','/cop/bbs/','게시물조회','게시물조회','/cop/bbs/selectBoardArticle.do'),('PG_00051','EgovNoticeList','/cop/bbs/','게시물 목록','게시물 목록','/cop/bbs/selectBoardList.do'),('PG_00052','EgovNoticeRegist','/cop/bbs/','게시물 등록','게시물 등록','/cop/bbs/addBoardArticle.do'),('PG_00053','EgovNoticeReply','/cop/bbs/','답글 작성','답글 작성','/cop/bbs/addReplyBoardArticle.do'),('PG_00054','EgovNoticeUpdt','/cop/bbs/','게시물 수정','게시물 수정','/cop/bbs/forUpdateBoardArticle.do'),('PG_00055','EgovProgramListDetailSelectUpdt','/sys/menu/','프로그램목록상세조회/수정','프로그램목록상세조회/수정','/sys/menu/ProgramListDetailSelect.do'),('PG_00056','EgovProgramListManage','/sys/menu/','프로그램목록관리','프로그램목록관리','/sys/menu/ProgramListManageSelect.do'),('PG_00057','EgovProgramListRegist','/sys/menu/','프로그램목록등록','프로그램목록등록','/sys/menu/ProgramListRegist.do'),('PG_00058','EgovRoleInsert','/sec/rmt/','롤등록','롤등록','/sec/rmt/EgovRoleInsertView.do'),('PG_00059','EgovRoleManage','/sec/rmt/','롤관리','롤관리','/sec/rmt/EgovRoleList.do'),('PG_00060','EgovRoleUpdt','/sec/rmt/','롤수정','롤수정','/sec/rmt/EgovRole.do'),('PG_00061','EgovTemplateInqirePopup','/cop/com/','템플릿 조회팝업','템플릿 조회팝업','/cop/com/selectTemplateInfs.do'),('PG_00062','EgovTemplateList','/cop/com/','템플릿 목록 조회','템플릿 목록 조회','/cop/com/selectTemplateInfs.do'),('PG_00063','EgovTemplateRegist','/cop/com/','템플릿 등록','템플릿 등록','/cop/com/addTemplateInf.do'),('PG_00064','EgovTemplateUpdt','/cop/com/','템플릿 수정','템플릿 수정','/cop/com/selectTemplateInf.do'),('PG_00065','EgovUserAbsnceList','/sys/user/','사용자부재관리','사용자부재관리','/sys/user/UserAbsnceListView.do'),('PG_00066','EgovUserAbsnceRegist','/uss/ion/uas/','사용자부재등록','사용자부재등록','/sys/user/UserAbsnceAdd.do'),('PG_00067','EgovUserAbsnceUpdt','/sys/user/','사용자부재수정','사용자부재수정','/sys/user/UserAbsnceUpdate.do'),('PG_00068','EgovUserInsert','/sys/user/','사용자등록','사용자등록','/sys/user/UserInsertView.do'),('PG_00069','EgovUserManage','/sys/user/','사용자관리(조회,삭제)','사용자관리(조회,삭제)','/sys/user/UserManage.do'),('PG_00070','EgovUserPasswordUpdt','/sys/user/','사용자암호수정','사용자암호수정','/sys/user/UserPasswordUpdtView.do'),('PG_00071','EgovUserSelectUpdt','/sys/user/','사용자상세조회,수정','사용자상세조회,수정','/sys/user/UserSelectUpdtView.do'),('PG_00072','EgovWorkAttendance','/','출퇴근정보 관리','출퇴근정보 관리','/EgovPageLink.do?link=main/sample_menu/Sample'),('PG_00073','EgovWorkAward','/','상벌정보 관리','상벌정보 관리','/EgovPageLink.do?link=main/sample_menu/Sample'),('PG_00074','EgovWorkEstimation','/','업무평가점수 관리','업무평가점수 관리','/EgovPageLink.do?link=main/sample_menu/Sample'),('PG_00075','EgovWorkVacation','/','휴무정보 관리','휴무정보 관리','/EgovPageLink.do?link=main/sample_menu/Sample');
/*!40000 ALTER TABLE `IPD_PROGRMS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `IPD_ROLE`
--

DROP TABLE IF EXISTS `IPD_ROLE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `IPD_ROLE` (
  `ROLE_CODE` varchar(50) NOT NULL DEFAULT '' COMMENT '롤코드',
  `ROLE_NM` varchar(60) NOT NULL COMMENT '롤명',
  `ROLE_PTTRN` varchar(300) DEFAULT NULL COMMENT '롤패턴',
  `ROLE_DC` varchar(200) DEFAULT NULL COMMENT '롤설명',
  `ROLE_TY` varchar(80) DEFAULT NULL COMMENT '롤유형',
  `ROLE_SORT` varchar(10) DEFAULT NULL COMMENT '롤정렬',
  `ROLE_CREAT_DE` char(20) NOT NULL COMMENT '롤생성일',
  PRIMARY KEY (`ROLE_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='롤정보';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `IPD_ROLE`
--

LOCK TABLES `IPD_ROLE` WRITE;
/*!40000 ALTER TABLE `IPD_ROLE` DISABLE KEYS */;
INSERT INTO `IPD_ROLE` VALUES ('cop-bbs','cop-bbs','/cop/bbs/.*.do.*','게시판','url','1','2011-08-31 15:41:24'),('cop-com','cop-com','/cop/com/.*.do.*','게시판사용','url','2','2011-08-24 0:00'),('sec-gmt','sec-gmt','/sec/gmt/.*.do.*','그룹관리','url','3','2011-08-24 0:00'),('sec-ram','sec-ram','/sec/ram/.*.do.*','권한관리','url','4','2011-08-24 0:00'),('sec-rgm','sec-rgm','/sec/rgm/.*.do.*','권한그룹관리','url','5','2011-08-24 0:00'),('sec-rmt','sec-rmt','/sec/rmt/.*.do.*','롤관리','url','6','2011-08-24 0:00'),('sts-cst','sts-cst','/sts/cst/.*.do.*','접속통계','url','7','2011-08-24 0:00'),('sym-ccm-cca','sym-ccm-cca','/sym/ccm/cca/.*.do.*','공통코드 등록','url','8','2011-08-24 0:00'),('sym-ccm-ccc','sym-ccm-ccc','/sym/ccm/ccc/.*.do.*','공통분류코드 상세조회','url','9','2011-08-24 0:00'),('sym-ccm-cde','sym-ccm-cde','/sym/ccm/cde/.*.do.*','공통상세코드 등록','url','10','2011-08-24 0:00'),('sym-ccm-zip','sym-ccm-zip','/sym/ccm/zip/.*.do.*','우편번호','url','11','2011-08-24 0:00'),('sym-cmm','sym-cmm','/sym/cmm/.*.do.*','우편번호 찾기','url','12','2011-08-24 0:00'),('sym-log-clg','sym-log-clg','/sym/log/clg/.*.do.*','로그인로그조회','url','13','2011-08-24 0:00'),('sym-mnu-mcm','sym-mnu-mcm','/sym/mnu/mcm/.*.do.*','메뉴생성관리','url','14','2011-08-24 0:00'),('sym-mnu-mpm','sym-mnu-mpm','/sym/mnu/mpm/.*.do.*','메뉴관리','url','15','2011-08-24 0:00'),('sym-prm','sym-prm','/sym/prm/.*.do.*','프로그램목록관리','url','16','2011-08-24 0:00'),('uat-uap','uat-uap','/uat/uap/.*.do.*','로그인정책관리','url','17','2011-08-24 0:00'),('uat-uia','uat-uia','/uat/uia/.*.do.*','로그인메인','url','18','2011-08-24 0:00'),('uss-ion-uas','uss-ion-uas','/uss/ion/uas/.*.do.*','사용자부재관리','url','19','2011-08-24 0:00'),('uss-umt-cmm','uss-umt-cmm','/uss/umt/cmm/.*.do.*','아이디중복확인','url','20','2011-08-24 0:00'),('uss-umt-user','uss-umt-user','/uss/umt/user/.*.do.*','사용자등록','url','21','2011-08-24 0:00');
/*!40000 ALTER TABLE `IPD_ROLE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `IPD_ROLES_HIERARCHY`
--

DROP TABLE IF EXISTS `IPD_ROLES_HIERARCHY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `IPD_ROLES_HIERARCHY` (
  `PARNTS_ROLE` varchar(30) NOT NULL COMMENT '부모롤',
  `CHLDRN_ROLE` varchar(30) NOT NULL COMMENT '자식롤',
  PRIMARY KEY (`PARNTS_ROLE`,`CHLDRN_ROLE`),
  KEY `R_308` (`CHLDRN_ROLE`),
  CONSTRAINT `IPD_ROLES_HIERARCHY_ibfk_1` FOREIGN KEY (`PARNTS_ROLE`) REFERENCES `IPD_AUTHOR` (`AUTHOR_CODE`) ON DELETE CASCADE,
  CONSTRAINT `IPD_ROLES_HIERARCHY_ibfk_2` FOREIGN KEY (`CHLDRN_ROLE`) REFERENCES `IPD_AUTHOR` (`AUTHOR_CODE`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='롤 계층구조';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `IPD_ROLES_HIERARCHY`
--

LOCK TABLES `IPD_ROLES_HIERARCHY` WRITE;
/*!40000 ALTER TABLE `IPD_ROLES_HIERARCHY` DISABLE KEYS */;
INSERT INTO `IPD_ROLES_HIERARCHY` VALUES ('ROLE_USER_MEMBER','ROLE_ADMIN');
/*!40000 ALTER TABLE `IPD_ROLES_HIERARCHY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `IPD_WSF_CUSTOMER`
--

DROP TABLE IF EXISTS `IPD_WSF_CUSTOMER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `IPD_WSF_CUSTOMER` (
  `CSTMR_ID` varchar(20) NOT NULL COMMENT '고객ID',
  `CSTMR_NM` varchar(50) NOT NULL COMMENT '고객명',
  `SEXDSTN` char(1) DEFAULT NULL COMMENT '성별',
  `BRTHDY` char(8) DEFAULT NULL COMMENT '생년월일',
  `CTTPC` varchar(20) NOT NULL COMMENT '연락처',
  `REMARK` varchar(1000) DEFAULT NULL COMMENT '메모',
  `FRST_REGIST_PNTTM` datetime DEFAULT NULL COMMENT '최초등록일시',
  `FRST_REGISTER_ID` varchar(20) DEFAULT NULL COMMENT '등록자',
  `LAST_UPDT_PNTTM` datetime DEFAULT NULL COMMENT '마지막수정일시',
  `LAST_UPDUSR_ID` varchar(20) DEFAULT NULL COMMENT '수정자',
  PRIMARY KEY (`CSTMR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='서해도선 고객관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `IPD_WSF_CUSTOMER`
--

LOCK TABLES `IPD_WSF_CUSTOMER` WRITE;
/*!40000 ALTER TABLE `IPD_WSF_CUSTOMER` DISABLE KEYS */;
/*!40000 ALTER TABLE `IPD_WSF_CUSTOMER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `IPD_WSF_EMBARKATION`
--

DROP TABLE IF EXISTS `IPD_WSF_EMBARKATION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `IPD_WSF_EMBARKATION` (
  `EMBRK_ID` varchar(20) NOT NULL COMMENT '승선ID',
  `NVG_ID` varchar(20) NOT NULL COMMENT '운항ID',
  `CHRGE_ID` varchar(20) NOT NULL COMMENT '요금ID',
  `GRP_YN` char(1) DEFAULT NULL COMMENT '그룹여부',
  `CHIL_YN` char(1) DEFAULT NULL COMMENT '소인여부',
  `INHBTNT_YN` varchar(1) DEFAULT NULL COMMENT '주민여부',
  `PYMNTMNY` int(10) DEFAULT NULL COMMENT '지불금',
  `PRNTNG_YN` char(1) DEFAULT NULL COMMENT '출력여부',
  `FRST_REGIST_PNTTM` datetime DEFAULT NULL COMMENT '최초등록일시',
  `FRST_REGISTER_ID` varchar(20) DEFAULT NULL COMMENT '등록자',
  `LAST_UPDT_PNTTM` datetime DEFAULT NULL COMMENT '마지막수정일시',
  `LAST_UPDUSR_ID` varchar(20) DEFAULT NULL COMMENT '수정자',
  PRIMARY KEY (`EMBRK_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='서해도선 승선관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `IPD_WSF_EMBARKATION`
--

LOCK TABLES `IPD_WSF_EMBARKATION` WRITE;
/*!40000 ALTER TABLE `IPD_WSF_EMBARKATION` DISABLE KEYS */;
/*!40000 ALTER TABLE `IPD_WSF_EMBARKATION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `IPD_WSF_NAVIGATION`
--

DROP TABLE IF EXISTS `IPD_WSF_NAVIGATION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `IPD_WSF_NAVIGATION` (
  `NVG_ID` varchar(20) NOT NULL COMMENT '운항ID',
  `START_PORT` varchar(6) DEFAULT NULL COMMENT '출발항',
  `ARVL_PORT` varchar(6) DEFAULT NULL COMMENT '도착항',
  `START_DT` datetime DEFAULT NULL COMMENT '출발일시',
  `NVG_DIV` varchar(6) DEFAULT NULL COMMENT '운항구분',
  `FRST_REGIST_PNTTM` datetime DEFAULT NULL COMMENT '최초등록일시',
  `FRST_REGISTER_ID` varchar(20) DEFAULT NULL COMMENT '등록자',
  `LAST_UPDT_PNTTM` datetime DEFAULT NULL COMMENT '마지막수정일시',
  `LAST_UPDUSR_ID` varchar(20) DEFAULT NULL COMMENT '수정자',
  PRIMARY KEY (`NVG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='서해도선 운항관리';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `IPD_WSF_NAVIGATION`
--

LOCK TABLES `IPD_WSF_NAVIGATION` WRITE;
/*!40000 ALTER TABLE `IPD_WSF_NAVIGATION` DISABLE KEYS */;
/*!40000 ALTER TABLE `IPD_WSF_NAVIGATION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LETTNBBS`
--

DROP TABLE IF EXISTS `LETTNBBS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `LETTNBBS` (
  `NTT_ID` decimal(20,0) NOT NULL COMMENT '게시물ID',
  `BBS_ID` char(20) NOT NULL COMMENT '게시판ID',
  `NTT_NO` decimal(20,0) DEFAULT NULL COMMENT '게시물번호',
  `NTT_SJ` varchar(2000) DEFAULT NULL COMMENT '게시물제목',
  `NTT_CN` mediumtext DEFAULT NULL COMMENT '게시물내용',
  `ANSWER_AT` char(1) DEFAULT NULL COMMENT '댓글여부',
  `PARNTSCTT_NO` decimal(10,0) DEFAULT NULL COMMENT '부모글번호',
  `ANSWER_LC` decimal(8,0) DEFAULT NULL COMMENT '댓글위치',
  `SORT_ORDR` decimal(8,0) DEFAULT NULL COMMENT '정렬순서',
  `RDCNT` decimal(10,0) DEFAULT NULL COMMENT '조회수',
  `USE_AT` char(1) NOT NULL COMMENT '사용여부',
  `NTCE_BGNDE` char(20) DEFAULT NULL COMMENT '게시시작일',
  `NTCE_ENDDE` char(20) DEFAULT NULL COMMENT '게시종료일',
  `NTCR_ID` varchar(20) DEFAULT NULL COMMENT '게시자ID',
  `NTCR_NM` varchar(20) DEFAULT NULL COMMENT '게시자명',
  `PASSWORD` varchar(200) DEFAULT NULL COMMENT '비밀번호',
  `ATCH_FILE_ID` char(20) DEFAULT NULL COMMENT '첨부파일ID',
  `FRST_REGIST_PNTTM` datetime NOT NULL COMMENT '최초등록시점',
  `FRST_REGISTER_ID` varchar(20) NOT NULL COMMENT '최초등록자ID',
  `LAST_UPDT_PNTTM` datetime DEFAULT NULL COMMENT '최종수정시점',
  `LAST_UPDUSR_ID` varchar(20) DEFAULT NULL COMMENT '최종수정자ID',
  PRIMARY KEY (`NTT_ID`,`BBS_ID`),
  KEY `LETTNBBS_ibfk_1` (`BBS_ID`),
  CONSTRAINT `LETTNBBS_ibfk_1` FOREIGN KEY (`BBS_ID`) REFERENCES `LETTNBBSMASTER` (`BBS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='게시판';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LETTNBBS`
--

LOCK TABLES `LETTNBBS` WRITE;
/*!40000 ALTER TABLE `LETTNBBS` DISABLE KEYS */;
INSERT INTO `LETTNBBS` VALUES (1,'BBSMSTR_AAAAAAAAAAAA',1,'홈페이지 샘플공지1','홈페이지 샘플공지1','N',0,0,2,1,'Y','10000101','99991231','','','',NULL,'2022-03-01 07:54:29','USRCNFRM_00000000000','2022-03-07 16:44:54','USRCNFRM_00000000000'),(2,'BBSMSTR_AAAAAAAAAAAA',1,'홈페이지 샘플공지2','홈페이지 샘플공지2','N',0,0,2,0,'Y','10000101','99991231','','','',NULL,'2022-03-01 07:54:29','USRCNFRM_00000000000',NULL,NULL),(3,'BBSMSTR_AAAAAAAAAAAA',1,'홈페이지 샘플공지3','홈페이지 샘플공지3','N',0,0,2,0,'Y','10000101','99991231','','','',NULL,'2022-03-01 07:54:29','USRCNFRM_00000000000',NULL,NULL),(4,'BBSMSTR_AAAAAAAAAAAA',1,'홈페이지 샘플공지4','홈페이지 샘플공지4','N',0,0,2,0,'Y','10000101','99991231','','','',NULL,'2022-03-01 07:54:29','USRCNFRM_00000000000',NULL,NULL),(5,'BBSMSTR_AAAAAAAAAAAA',1,'홈페이지 샘플공지5','홈페이지 샘플공지5','N',0,0,2,0,'Y','10000101','99991231','','','',NULL,'2022-03-01 07:54:29','USRCNFRM_00000000000',NULL,NULL),(6,'BBSMSTR_CCCCCCCCCCCC',1,'홈페이지 샘플업무1','홈페이지 샘플업무1','N',0,0,2,1,'Y','10000101','99991231','','','',NULL,'2022-03-01 07:54:29','USRCNFRM_00000000000','2022-03-07 16:45:07','USRCNFRM_00000000000'),(7,'BBSMSTR_CCCCCCCCCCCC',1,'홈페이지 샘플업무2','홈페이지 샘플업무2','N',0,0,2,0,'Y','10000101','99991231','','','',NULL,'2022-03-01 07:54:29','USRCNFRM_00000000000',NULL,NULL),(8,'BBSMSTR_CCCCCCCCCCCC',1,'홈페이지 샘플업무3','홈페이지 샘플업무3','N',0,0,2,0,'Y','10000101','99991231','','','',NULL,'2022-03-01 07:54:29','USRCNFRM_00000000000',NULL,NULL),(9,'BBSMSTR_CCCCCCCCCCCC',1,'홈페이지 샘플업무4','홈페이지 샘플업무4','N',0,0,2,0,'Y','10000101','99991231','','','',NULL,'2022-03-01 07:54:29','USRCNFRM_00000000000',NULL,NULL),(10,'BBSMSTR_CCCCCCCCCCCC',1,'홈페이지 샘플업무5','홈페이지 샘플업무5','N',0,0,2,0,'Y','10000101','99991231','','','',NULL,'2022-03-01 07:54:29','USRCNFRM_00000000000',NULL,NULL);
/*!40000 ALTER TABLE `LETTNBBS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LETTNBBSMASTER`
--

DROP TABLE IF EXISTS `LETTNBBSMASTER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `LETTNBBSMASTER` (
  `BBS_ID` char(20) NOT NULL COMMENT '게시판ID',
  `BBS_NM` varchar(255) NOT NULL COMMENT '게시판명',
  `BBS_INTRCN` varchar(2400) DEFAULT NULL COMMENT '게시판소개',
  `BBS_TY_CODE` char(6) NOT NULL COMMENT '게시판유형코드',
  `BBS_ATTRB_CODE` char(6) NOT NULL,
  `REPLY_POSBL_AT` char(1) DEFAULT NULL COMMENT '답장가능여부',
  `FILE_ATCH_POSBL_AT` char(1) NOT NULL COMMENT '파일첨부가능여부',
  `ATCH_POSBL_FILE_NUMBER` decimal(2,0) NOT NULL COMMENT '첨부가능파일숫자',
  `ATCH_POSBL_FILE_SIZE` decimal(8,0) DEFAULT NULL COMMENT '첨부가능파일사이즈',
  `USE_AT` char(1) NOT NULL COMMENT '사용여부',
  `TMPLAT_ID` char(20) DEFAULT NULL COMMENT '템플릿ID',
  `FRST_REGISTER_ID` varchar(20) NOT NULL COMMENT '최초등록자ID',
  `FRST_REGIST_PNTTM` datetime NOT NULL COMMENT '최초등록시점',
  `LAST_UPDUSR_ID` varchar(20) DEFAULT NULL COMMENT '최종수정자ID',
  `LAST_UPDT_PNTTM` datetime DEFAULT NULL COMMENT '최종수정시점',
  PRIMARY KEY (`BBS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='게시판마스터';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LETTNBBSMASTER`
--

LOCK TABLES `LETTNBBSMASTER` WRITE;
/*!40000 ALTER TABLE `LETTNBBSMASTER` DISABLE KEYS */;
INSERT INTO `LETTNBBSMASTER` VALUES ('BBSMSTR_AAAAAAAAAAAA','공지사항','공지사항게시판','BBST03','BBSA03','Y','Y',2,5242880,'Y','TMPLAT_BOARD_DEFAULT','USRCNFRM_00000000000','2011-08-31 12:00:00','USRCNFRM_00000000000','2011-08-31 12:00:00'),('BBSMSTR_BBBBBBBBBBBB','갤러리','갤러리게시판','BBST01','BBSA02','Y','Y',2,5242880,'Y','TMPLAT_BOARD_DEFAULT','USRCNFRM_00000000000','2011-08-31 12:00:00','USRCNFRM_00000000000','2011-08-31 12:00:00'),('BBSMSTR_CCCCCCCCCCCC','자료실','자료실게시판','BBST01','BBSA03','Y','Y',2,5242880,'Y','TMPLAT_BOARD_DEFAULT','USRCNFRM_00000000000','2011-08-31 12:00:00','USRCNFRM_00000000000','2011-08-31 12:00:00');
/*!40000 ALTER TABLE `LETTNBBSMASTER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LETTNBBSMASTEROPTN`
--

DROP TABLE IF EXISTS `LETTNBBSMASTEROPTN`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `LETTNBBSMASTEROPTN` (
  `BBS_ID` char(20) NOT NULL COMMENT '게시판ID',
  `ANSWER_AT` char(1) NOT NULL COMMENT '댓글여부',
  `STSFDG_AT` char(1) NOT NULL COMMENT '만족도여부',
  `FRST_REGIST_PNTTM` datetime NOT NULL COMMENT '최초등록시점',
  `LAST_UPDT_PNTTM` datetime DEFAULT NULL COMMENT '최종수정시점',
  `FRST_REGISTER_ID` varchar(20) NOT NULL COMMENT '최초등록자ID',
  `LAST_UPDUSR_ID` varchar(20) DEFAULT NULL COMMENT '최종수정자ID',
  PRIMARY KEY (`BBS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='게시판마스터옵션';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LETTNBBSMASTEROPTN`
--

LOCK TABLES `LETTNBBSMASTEROPTN` WRITE;
/*!40000 ALTER TABLE `LETTNBBSMASTEROPTN` DISABLE KEYS */;
/*!40000 ALTER TABLE `LETTNBBSMASTEROPTN` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LETTNBBSUSE`
--

DROP TABLE IF EXISTS `LETTNBBSUSE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `LETTNBBSUSE` (
  `BBS_ID` char(20) NOT NULL COMMENT '게시판ID',
  `TRGET_ID` char(20) NOT NULL DEFAULT '' COMMENT '대상ID',
  `USE_AT` char(1) NOT NULL COMMENT '사용여부',
  `REGIST_SE_CODE` char(6) DEFAULT NULL COMMENT '등록구분코드',
  `FRST_REGIST_PNTTM` datetime DEFAULT NULL COMMENT '최초등록시점',
  `FRST_REGISTER_ID` varchar(20) NOT NULL COMMENT '최초등록자ID',
  `LAST_UPDT_PNTTM` datetime DEFAULT NULL COMMENT '최종수정시점',
  `LAST_UPDUSR_ID` varchar(20) DEFAULT NULL COMMENT '최종수정자ID',
  PRIMARY KEY (`BBS_ID`,`TRGET_ID`),
  CONSTRAINT `LETTNBBSUSE_ibfk_1` FOREIGN KEY (`BBS_ID`) REFERENCES `LETTNBBSMASTER` (`BBS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='게시판활용';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LETTNBBSUSE`
--

LOCK TABLES `LETTNBBSUSE` WRITE;
/*!40000 ALTER TABLE `LETTNBBSUSE` DISABLE KEYS */;
INSERT INTO `LETTNBBSUSE` VALUES ('BBSMSTR_AAAAAAAAAAAA','SYSTEM_DEFAULT_BOARD','Y','REGC01','2011-08-31 12:00:00','USRCNFRM_00000000000','2011-08-31 12:00:00','USRCNFRM_00000000000'),('BBSMSTR_BBBBBBBBBBBB','SYSTEM_DEFAULT_BOARD','Y','REGC01','2011-08-31 12:00:00','USRCNFRM_00000000000','2011-08-31 12:00:00','USRCNFRM_00000000000'),('BBSMSTR_CCCCCCCCCCCC','SYSTEM_DEFAULT_BOARD','Y','REGC01','2011-08-31 12:00:00','USRCNFRM_00000000000','2011-08-31 12:00:00','USRCNFRM_00000000000');
/*!40000 ALTER TABLE `LETTNBBSUSE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LETTNFILE`
--

DROP TABLE IF EXISTS `LETTNFILE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `LETTNFILE` (
  `ATCH_FILE_ID` char(20) NOT NULL COMMENT '첨부파일ID',
  `CREAT_DT` datetime NOT NULL COMMENT '생성일시',
  `USE_AT` char(1) DEFAULT NULL COMMENT '사용여부',
  PRIMARY KEY (`ATCH_FILE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='파일속성';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LETTNFILE`
--

LOCK TABLES `LETTNFILE` WRITE;
/*!40000 ALTER TABLE `LETTNFILE` DISABLE KEYS */;
/*!40000 ALTER TABLE `LETTNFILE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LETTNFILEDETAIL`
--

DROP TABLE IF EXISTS `LETTNFILEDETAIL`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `LETTNFILEDETAIL` (
  `ATCH_FILE_ID` char(20) NOT NULL COMMENT '첨부파일ID',
  `FILE_SN` decimal(10,0) NOT NULL COMMENT '파일순번',
  `FILE_STRE_COURS` varchar(2000) NOT NULL COMMENT '파일저장경로',
  `STRE_FILE_NM` varchar(255) NOT NULL COMMENT '저장파일명',
  `ORIGNL_FILE_NM` varchar(255) DEFAULT NULL COMMENT '원파일명',
  `FILE_EXTSN` varchar(20) NOT NULL COMMENT '파일확장자',
  `FILE_CN` mediumtext DEFAULT NULL COMMENT '파일내용',
  `FILE_SIZE` decimal(8,0) DEFAULT NULL COMMENT '파일크기',
  PRIMARY KEY (`ATCH_FILE_ID`,`FILE_SN`),
  CONSTRAINT `LETTNFILEDETAIL_ibfk_1` FOREIGN KEY (`ATCH_FILE_ID`) REFERENCES `LETTNFILE` (`ATCH_FILE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='파일상세정보';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LETTNFILEDETAIL`
--

LOCK TABLES `LETTNFILEDETAIL` WRITE;
/*!40000 ALTER TABLE `LETTNFILEDETAIL` DISABLE KEYS */;
/*!40000 ALTER TABLE `LETTNFILEDETAIL` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LETTNSYSLOG`
--

DROP TABLE IF EXISTS `LETTNSYSLOG`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `LETTNSYSLOG` (
  `REQUST_ID` varchar(20) NOT NULL COMMENT '요청ID',
  `JOB_SE_CODE` char(3) DEFAULT NULL COMMENT '업무구분코드',
  `INSTT_CODE` char(7) DEFAULT NULL COMMENT '기관코드',
  `OCCRRNC_DE` datetime DEFAULT NULL COMMENT '발생일',
  `RQESTER_IP` varchar(23) DEFAULT NULL COMMENT '요청자IP',
  `RQESTER_ID` varchar(20) DEFAULT NULL COMMENT '요청자ID',
  `TRGET_MENU_NM` varchar(255) DEFAULT NULL COMMENT '대상메뉴명',
  `SVC_NM` varchar(255) DEFAULT NULL COMMENT '서비스명',
  `METHOD_NM` varchar(60) DEFAULT NULL COMMENT '메서드명',
  `PROCESS_SE_CODE` char(3) DEFAULT NULL COMMENT '처리구분코드',
  `PROCESS_CO` decimal(10,0) DEFAULT NULL COMMENT '처리수',
  `PROCESS_TIME` varchar(14) DEFAULT NULL COMMENT '처리시간',
  `RSPNS_CODE` char(3) DEFAULT NULL COMMENT '응답코드',
  `ERROR_SE` char(1) DEFAULT NULL COMMENT '오류구분',
  `ERROR_CO` decimal(10,0) DEFAULT NULL COMMENT '오류수',
  `ERROR_CODE` char(3) DEFAULT NULL COMMENT '오류코드',
  PRIMARY KEY (`REQUST_ID`),
  UNIQUE KEY `LETTNSYSLOG_PK` (`REQUST_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LETTNSYSLOG`
--

LOCK TABLES `LETTNSYSLOG` WRITE;
/*!40000 ALTER TABLE `LETTNSYSLOG` DISABLE KEYS */;
/*!40000 ALTER TABLE `LETTNSYSLOG` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LETTNSYSLOGSUMMARY`
--

DROP TABLE IF EXISTS `LETTNSYSLOGSUMMARY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `LETTNSYSLOGSUMMARY` (
  `OCCRRNC_DE` char(8) NOT NULL COMMENT '발생일',
  `SRVC_NM` varchar(255) NOT NULL,
  `METHOD_NM` varchar(60) NOT NULL COMMENT '메서드명',
  `CREAT_CO` decimal(10,0) DEFAULT NULL COMMENT '생성수',
  `UPDT_CO` decimal(10,0) DEFAULT NULL COMMENT '수정수',
  `RDCNT` decimal(10,0) DEFAULT NULL COMMENT '조회수',
  `DELETE_CO` decimal(10,0) DEFAULT NULL COMMENT '삭제수',
  `OUTPT_CO` decimal(10,0) DEFAULT NULL COMMENT '출력수',
  `ERROR_CO` decimal(10,0) DEFAULT NULL COMMENT '오류수',
  PRIMARY KEY (`OCCRRNC_DE`,`SRVC_NM`,`METHOD_NM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='시스템로그요약';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LETTNSYSLOGSUMMARY`
--

LOCK TABLES `LETTNSYSLOGSUMMARY` WRITE;
/*!40000 ALTER TABLE `LETTNSYSLOGSUMMARY` DISABLE KEYS */;
/*!40000 ALTER TABLE `LETTNSYSLOGSUMMARY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LETTNTMPLATINFO`
--

DROP TABLE IF EXISTS `LETTNTMPLATINFO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `LETTNTMPLATINFO` (
  `TMPLAT_ID` char(20) NOT NULL DEFAULT '' COMMENT '템플릿ID',
  `TMPLAT_NM` varchar(255) DEFAULT NULL COMMENT '템플릿명',
  `TMPLAT_COURS` varchar(2000) DEFAULT NULL COMMENT '템플릿경로',
  `USE_AT` char(1) DEFAULT NULL COMMENT '사용여부',
  `TMPLAT_SE_CODE` char(6) DEFAULT NULL COMMENT '템플릿구분코드',
  `FRST_REGISTER_ID` varchar(20) DEFAULT NULL COMMENT '최초등록자ID',
  `FRST_REGIST_PNTTM` datetime DEFAULT NULL COMMENT '최초등록시점',
  `LAST_UPDUSR_ID` varchar(20) DEFAULT NULL COMMENT '최종수정자ID',
  `LAST_UPDT_PNTTM` datetime DEFAULT NULL COMMENT '최종수정시점',
  PRIMARY KEY (`TMPLAT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='템플릿';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LETTNTMPLATINFO`
--

LOCK TABLES `LETTNTMPLATINFO` WRITE;
/*!40000 ALTER TABLE `LETTNTMPLATINFO` DISABLE KEYS */;
INSERT INTO `LETTNTMPLATINFO` VALUES ('TMPLAT_BOARD_DEFAULT','게시판 기본템플릿','/css/egovframework/cop/bbs/egovbbsTemplate.css','Y','TMPT01','USRCNFRM_00000000000','2011-08-02 21:01:59','USRCNFRM_00000000000','2011-08-08 16:12:57');
/*!40000 ALTER TABLE `LETTNTMPLATINFO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LETTNUSERABSNCE`
--

DROP TABLE IF EXISTS `LETTNUSERABSNCE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `LETTNUSERABSNCE` (
  `USER_ID` varchar(20) NOT NULL DEFAULT '' COMMENT '사용자ID',
  `USER_ABSNCE_AT` char(1) NOT NULL COMMENT '사용자부재여부',
  `FRST_REGISTER_ID` varchar(20) DEFAULT NULL COMMENT '최초등록자ID',
  `FRST_REGIST_PNTTM` datetime DEFAULT NULL COMMENT '최초등록시점',
  `LAST_UPDUSR_ID` varchar(20) DEFAULT NULL COMMENT '최종수정자ID',
  `LAST_UPDT_PNTTM` datetime DEFAULT NULL COMMENT '최종수정시점',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='사용자부재';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LETTNUSERABSNCE`
--

LOCK TABLES `LETTNUSERABSNCE` WRITE;
/*!40000 ALTER TABLE `LETTNUSERABSNCE` DISABLE KEYS */;
INSERT INTO `LETTNUSERABSNCE` VALUES ('ekxkaks','N','ippado','2022-03-23 05:47:49','ippado','2022-03-23 05:47:58'),('ippado','N','ippado','2022-03-21 07:47:55','ippado','2022-03-21 07:48:08');
/*!40000 ALTER TABLE `LETTNUSERABSNCE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'ippado'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-04 11:55:03
