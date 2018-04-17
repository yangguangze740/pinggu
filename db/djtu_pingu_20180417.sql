CREATE DATABASE  IF NOT EXISTS `djtu_pinggu` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `djtu_pinggu`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: djtu_pinggu
-- ------------------------------------------------------
-- Server version	5.6.13-log

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
-- Table structure for table `bak_menu`
--

DROP TABLE IF EXISTS `bak_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bak_menu` (
  `menuId` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '菜单ID',
  `parentId` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT '0' COMMENT '父菜单ID',
  `menuName` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '菜单名',
  `menuURL` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '菜单URL',
  `menuType` tinyint(4) NOT NULL DEFAULT '1' COMMENT '菜单类型 0文本 1超链接',
  `icon` varchar(101) CHARACTER SET utf8 NOT NULL COMMENT '菜单icon',
  `orderNum` tinyint(4) NOT NULL DEFAULT '1' COMMENT '菜单排序',
  `menuGroupValue` varchar(45) CHARACTER SET utf8 NOT NULL COMMENT '菜单中分组的英文',
  `menuGroupName` varchar(45) CHARACTER SET utf8 NOT NULL COMMENT '菜单中分组的名字',
  `version` varchar(45) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT '备份的版本',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '菜单创建的时间',
  `backTime` varchar(45) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'CURRENT_TIMESTAMP' COMMENT '菜单备份的时间',
  `isParentMenu` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否父菜单 0:否 1:是',
  PRIMARY KEY (`menuId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='系统初始化menu的备份';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bak_menu`
--

LOCK TABLES `bak_menu` WRITE;
/*!40000 ALTER TABLE `bak_menu` DISABLE KEYS */;
INSERT INTO `bak_menu` VALUES ('1028d885-6d0a-4790-b0b2-79846c56329d','','系统UI配置','/admin/ui',1,'',0,'system','系统配置','2','2018-04-02 08:49:21','CURRENT_TIMESTAMP',0),('20fe9614-0a8f-4c5f-bfb5-e237ab62746e','','系统UI配置','/admin/ui',1,'',0,'system','系统配置','0','2018-04-02 08:31:14','CURRENT_TIMESTAMP',0),('4cd00418-1808-4203-b53e-ed213c687761','','系统UI配置','/admin/ui',1,'',0,'system','系统配置','1','2018-04-02 08:43:52','CURRENT_TIMESTAMP',0),('57584201-69c3-421b-aca8-1b8437e5ae2f','0','系统角色配置','/admin/role',1,'',1,'system','系统配置','4','2018-04-08 12:21:55','CURRENT_TIMESTAMP',0),('5e67f167-b5fd-4dfe-a65c-298b842e9e8a','0','系统菜单配置','/admin/menu',1,'',2,'system','系统配置','5','2018-04-09 08:42:04','CURRENT_TIMESTAMP',0),('874afa47-3f4e-4eda-8f23-4d06d78241bb','0','系统UI配置','/admin/ui',1,'',2,'system','系统配置','4','2018-04-08 12:21:55','CURRENT_TIMESTAMP',0),('897bcbdd-6a73-4900-b36b-bb6590172326','0','系统角色配置','/admin/role',1,'',0,'system','系统配置','5','2018-04-09 08:42:04','CURRENT_TIMESTAMP',0),('906dada8-b0b1-4109-982d-144e7a5aba5e','0','系统菜单配置','/admin/menu',1,'fa-align-justify',1,'system','系统配置','3','2018-04-02 12:47:29','CURRENT_TIMESTAMP',0),('969022be-8980-493c-9958-8baba92b9132','0','系统UI配置','/admin/ui',1,'',1,'system','系统配置','5','2018-04-09 08:42:04','CURRENT_TIMESTAMP',0),('b373aff1-0ff8-49c0-a4f1-8f732874170a','0','系统菜单配置','/admin/menu',1,'',0,'system','系统配置','4','2018-04-08 12:21:55','CURRENT_TIMESTAMP',0),('e5d14893-9599-446e-8819-ab6d150d7ee9','0','系统UI配置','/admin/ui',1,'fa-firefox',0,'system','系统配置','3','2018-04-02 12:47:29','CURRENT_TIMESTAMP',0);
/*!40000 ALTER TABLE `bak_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bak_permission`
--

DROP TABLE IF EXISTS `bak_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bak_permission` (
  `permissionId` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '权限ID',
  `permissionName` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '权限名',
  `permissionRemark` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '权限说明',
  `permissionCreateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '权限创建时间',
  `permissionGroup` varchar(45) CHARACTER SET utf8 NOT NULL COMMENT '权限分组',
  `permissionValue` varchar(45) CHARACTER SET utf8 NOT NULL COMMENT '权限表达 user:r',
  `version` int(11) NOT NULL COMMENT '权限迭代版本',
  `backTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '权限备份的时间',
  `permissionGroupName` varchar(45) COLLATE utf8_unicode_ci NOT NULL COMMENT '权限分组名',
  PRIMARY KEY (`permissionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='权限备份,每次刷新权限的上一版本备份';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bak_permission`
--

LOCK TABLES `bak_permission` WRITE;
/*!40000 ALTER TABLE `bak_permission` DISABLE KEYS */;
INSERT INTO `bak_permission` VALUES ('11c1a0f7-079c-4fdd-857b-83df1999f6c2','角色查询','','2018-04-09 08:42:04','role','role:rr',6,'2018-04-09 09:57:14','角色组'),('142b1510-eae5-4ad8-b79c-4c45f0cbca1d','父菜单添加','','2018-04-08 12:21:55','menu','menu:pc',5,'2018-04-09 08:42:04',''),('149a159c-db6c-4876-bede-41f68118c26e','所有权限查询','','2018-04-08 12:21:55','permission','permission:apr',5,'2018-04-09 08:42:04','权限组'),('256477c5-df21-4fa0-8824-1fb0348c14e4','独立菜单查询','','2018-04-08 12:21:55','menu','menu:amr',5,'2018-04-09 08:42:04','菜单组'),('2df1342d-a04e-4d0b-90b5-87ea411a1ef6','全部子菜单查询','','2018-04-09 08:42:04','menu','menu:acmr',6,'2018-04-09 09:57:14','菜单组'),('2e4b7097-b2b6-4380-9f3a-f99e56260ac2','用户角色查询','','2018-04-02 08:43:52','role','role:ruserr',2,'2018-04-02 08:49:21',''),('30bf8637-5d7f-4993-9bec-d7b993a26520','菜单编辑查询','','2018-04-08 12:21:55','menu','menu:mer',5,'2018-04-09 08:42:04','菜单组'),('3626002d-94bf-470e-8442-a0fb8173f0df','角色权限查询','','2018-04-09 08:42:04','permission','permission:rrolep',6,'2018-04-09 09:57:14','权限组'),('36f06bc4-1864-43e9-afac-61b163f561dd','角色权限查询','','2018-04-02 08:49:21','permission','permission:rrolep',3,'2018-04-02 12:47:29',''),('37cb0371-9ccb-408e-bb4f-67cef74ed79e','角色添加','','2018-04-09 08:42:04','role','role:ra',6,'2018-04-09 09:57:14','角色组'),('39e154fe-91eb-4dd7-a138-26614764617e','全部子菜单查询','','2018-04-08 12:21:55','menu','menu:acmr',5,'2018-04-09 08:42:04','菜单组'),('3c2ebf90-bbd8-4923-b5ba-14e145ea9518','菜单编辑查询','','2018-04-09 08:42:04','menu','menu:mer',6,'2018-04-09 09:57:14','菜单组'),('3cae548b-83c4-4f5a-a11f-59b1d200315f','角色权限查询','','2018-04-02 08:43:52','permission','permission:rrolep',2,'2018-04-02 08:49:21',''),('3d0d4b25-77ce-4028-96f8-5ba89205d537','菜单查询','','2018-04-08 12:21:55','menu','menu:r',5,'2018-04-09 08:42:04','菜单组'),('3da7ecff-c82e-4adf-a9c0-999e9882cc47','用户角色查询','','2018-04-02 08:49:21','role','role:ruserr',3,'2018-04-02 12:47:29',''),('3fd1fef7-cb43-451e-a154-2648fc9610b7','菜单删除','','2018-04-08 12:21:55','menu','menu:md',5,'2018-04-09 08:42:04','菜单组'),('41ef7dc8-dd84-448d-9a49-813a8a5f6b5d','用户角色查询','','2018-04-02 12:47:29','role','role:ruserr',4,'2018-04-08 12:21:55',''),('41fdd165-f91f-4b85-b3a4-092c7590b4d0','用户角色查询','','2018-04-09 08:42:04','role','role:urr',6,'2018-04-09 09:57:14','角色组'),('4e258486-6292-46f0-87aa-c2e6fb706b6c','用户角色查询','','2018-04-02 08:31:14','role','role:ruserr',0,'2018-04-02 08:43:52',''),('5e0ff503-6d3f-4b9e-a9b0-5e29b6e5b668','菜单更新','','2018-04-09 08:42:04','menu','menu:mu',6,'2018-04-09 09:57:14','菜单组'),('67824bd0-46f8-41ad-9d32-0565c8079d44','独立菜单查询','','2018-04-09 08:42:04','menu','menu:amr',6,'2018-04-09 09:57:14','菜单组'),('72ce9d67-534c-456d-9afa-4ca9b9e7f027','父菜单添加','','2018-04-09 08:42:04','menu','menu:pc',6,'2018-04-09 09:57:14','菜单组'),('772ca3bf-353a-489b-975d-dd729c9b773b','所有权限查询','','2018-04-09 08:42:04','permission','permission:apr',6,'2018-04-09 09:57:14','权限组'),('8cdeb727-7d77-4c35-82b3-20d05b8c31ed','角色权限查询','','2018-04-08 12:21:55','permission','permission:rrolep',5,'2018-04-09 08:42:04','权限组'),('8faa8938-f198-457d-a4cc-cfc323af51a8','菜单删除','','2018-04-09 08:42:04','menu','menu:md',6,'2018-04-09 09:57:14','菜单组'),('a3732ee4-5ec6-4f73-9a8f-a7a81f2f0fa0','用户角色查询','','2018-04-08 12:21:55','role','role:urr',5,'2018-04-09 08:42:04','角色组'),('a58394f0-d62c-4705-a79b-9c32d9ff1449','菜单查询','','2018-04-09 08:42:04','menu','menu:r',6,'2018-04-09 09:57:14','菜单组'),('ad8b8037-5e69-449b-b6ed-64590134c0b6','菜单更新','','2018-04-08 12:21:55','menu','menu:mu',5,'2018-04-09 08:42:04','菜单组'),('b407219e-64bf-4f61-ad8b-2f0d137c152a','角色权限查询','','2018-04-02 12:47:29','permission','permission:rrolep',4,'2018-04-08 12:21:55',''),('c0b4b894-e636-47f4-bce8-c5b8702d4938','角色权限查询','','2018-04-02 08:31:14','permission','permission:rrolep',0,'2018-04-02 08:43:52',''),('daa36b17-73cb-475c-962a-f2e867031e64','角色查询','','2018-04-08 12:21:55','role','role:rr',5,'2018-04-09 08:42:04','角色组');
/*!40000 ALTER TABLE `bak_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bak_role`
--

DROP TABLE IF EXISTS `bak_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bak_role` (
  `roleId` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '角色ID',
  `roleName` varchar(45) CHARACTER SET utf8 NOT NULL COMMENT '角色名',
  `roleRemark` varchar(45) CHARACTER SET utf8 NOT NULL COMMENT '角色说明',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '角色创建时间',
  `roleGroup` varchar(45) CHARACTER SET utf8 NOT NULL COMMENT '角色分组',
  `roleValue` varchar(45) CHARACTER SET utf8 NOT NULL COMMENT '角色值 user:m',
  `version` int(11) NOT NULL COMMENT '版本号',
  `backTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '角色备份的时间',
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='角色备份,每次刷新角色时上一版本备份';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bak_role`
--

LOCK TABLES `bak_role` WRITE;
/*!40000 ALTER TABLE `bak_role` DISABLE KEYS */;
INSERT INTO `bak_role` VALUES ('0704c282-b296-4ee1-9836-67037215ccf5','角色管理角色','','2018-04-02 08:43:52','basicInfo','role:m',2,'2018-04-02 08:49:21'),('0c33d14a-3645-4547-9384-a7281e41a777','菜单管理角色','','2018-04-08 12:21:55','system','menu:m',5,'2018-04-09 08:42:04'),('23c10400-0964-48f3-a074-f96e32ef66b2','菜单管理角色','','2018-04-09 08:42:04','system','menu:m',6,'2018-04-09 09:57:14'),('2c0f548e-44e4-44f0-b652-f80ec6d0b51f','权限管理角色','','2018-04-02 08:43:52','basicInfo','permission:m',2,'2018-04-02 08:49:21'),('2ead83ed-3d85-41a0-bc45-f412771b4bba','权限管理角色','','2018-04-02 08:49:21','basicInfo','permission:m',3,'2018-04-02 12:47:29'),('369d147b-66c5-4cbf-b0f0-459f3929dcba','权限管理角色','','2018-04-02 12:47:29','basicInfo','permission:m',4,'2018-04-08 12:21:55'),('6cf93436-b496-4d5f-8ff5-2f4b768b4ba1','角色管理角色','','2018-04-02 08:31:14','basicInfo','role:m',1,'2018-04-02 08:43:52'),('96bae410-5e99-46a6-a6ea-20dd92e700dc','角色管理角色','','2018-04-08 12:21:55','basicInfo','role:m',5,'2018-04-09 08:42:04'),('99b9c130-5665-4fd3-8bd6-922ed5677e2e','角色管理角色','','2018-04-02 12:47:29','basicInfo','role:m',4,'2018-04-08 12:21:55'),('a7e61abe-2e0d-4da7-a153-f29b427fd9db','角色管理角色','','2018-04-02 08:49:21','basicInfo','role:m',3,'2018-04-02 12:47:29'),('c1098bbf-5b2b-4dcd-85d3-d51836025e2a','权限管理角色','','2018-04-08 12:21:55','system','permission:m',5,'2018-04-09 08:42:04'),('cff8f11d-f144-477a-a441-26618fc1ea53','权限管理角色','','2018-04-09 08:42:04','system','permission:m',6,'2018-04-09 09:57:14'),('eb0566de-29c4-4a8c-a01f-4178ad9dffcf','角色管理角色','','2018-04-09 08:42:04','basicInfo','role:m',6,'2018-04-09 09:57:14'),('feca5193-b97c-4882-a051-bb96e7769c8e','权限管理角色','','2018-04-02 08:31:14','basicInfo','permission:m',1,'2018-04-02 08:43:52');
/*!40000 ALTER TABLE `bak_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_menu`
--

DROP TABLE IF EXISTS `system_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `system_menu` (
  `menuId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '菜单ID',
  `parentId` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT '父菜单ID',
  `menuName` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '菜单名',
  `menuURL` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '菜单URL',
  `menuType` tinyint(4) NOT NULL DEFAULT '1' COMMENT '菜单类型 0文本 1超链接',
  `icon` varchar(101) COLLATE utf8_unicode_ci NOT NULL COMMENT '菜单icon',
  `orderNum` tinyint(4) NOT NULL DEFAULT '1' COMMENT '菜单排序',
  `menuGroupValue` varchar(45) CHARACTER SET utf8 NOT NULL COMMENT '菜单中分组的英文表示',
  `menuGroupName` varchar(45) CHARACTER SET utf8 NOT NULL COMMENT '菜单中分组的名字',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '菜单的创建时间',
  `isParentMenu` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否是父菜单 0:否 1:是',
  `editFlag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否可更改 0:不可更改 1:可更改',
  PRIMARY KEY (`menuId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='系统菜单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_menu`
--

LOCK TABLES `system_menu` WRITE;
/*!40000 ALTER TABLE `system_menu` DISABLE KEYS */;
INSERT INTO `system_menu` VALUES ('7be64c4e-120a-428a-9320-9249e0a89d78','f8605673-2260-4af3-87bb-a7543893f72d','系统UI配置','/admin/ui',1,'',1,'system','系统配置','2018-04-09 09:57:14',0,0),('d1d5d465-4e3f-49c8-8965-d3e494d9e782','f8605673-2260-4af3-87bb-a7543893f72d','系统角色配置','/admin/role',1,'',2,'system','系统配置','2018-04-09 09:57:14',0,0),('f8605673-2260-4af3-87bb-a7543893f72d','0','系统管理','',1,'fa-sliders',3,'menu:parent','父菜单','2018-04-10 09:09:04',1,1),('fd4b92d4-78c8-478a-bc41-6985d38a261b','f8605673-2260-4af3-87bb-a7543893f72d','系统菜单配置','/admin/menu',1,'',0,'system','系统配置','2018-04-09 09:57:14',0,0);
/*!40000 ALTER TABLE `system_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_permission`
--

DROP TABLE IF EXISTS `system_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `system_permission` (
  `permissionId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '权限ID',
  `permissionName` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '权限名',
  `permissionRemark` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '权限说明',
  `permissionCreateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '权限创建时间',
  `permissionGroup` varchar(45) COLLATE utf8_unicode_ci NOT NULL COMMENT '权限分组',
  `permissionValue` varchar(45) COLLATE utf8_unicode_ci NOT NULL COMMENT '权限表达 user:r',
  `permissionGroupName` varchar(45) CHARACTER SET utf8 NOT NULL COMMENT '权限分组名',
  PRIMARY KEY (`permissionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='系统权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_permission`
--

LOCK TABLES `system_permission` WRITE;
/*!40000 ALTER TABLE `system_permission` DISABLE KEYS */;
INSERT INTO `system_permission` VALUES ('23dae94e-719e-491f-bf52-d1497664c8ea','角色查询','','2018-04-09 09:57:14','role','role:rr','角色组'),('2d124321-5aa2-453e-9a78-ab5d47bc7844','角色添加','','2018-04-09 09:57:14','role','role:ra','角色组'),('33f6b6d3-604f-439b-904d-8afb3151f017','菜单编辑查询','','2018-04-09 09:57:14','menu','menu:mer','菜单组'),('7a91b1c7-9826-4324-9851-0841dd46ad90','全部子菜单查询','','2018-04-09 09:57:14','menu','menu:acmr','菜单组'),('8b5f444d-dc3a-4189-b564-3a720aacfb28','父菜单添加','','2018-04-09 09:57:14','menu','menu:pc','菜单组'),('98be7761-19f5-467d-8c6e-841dbcd12faa','用户角色查询','','2018-04-09 09:57:14','role','role:urr','角色组'),('9b10fbc4-03ec-4d30-9822-da76fec7cd84','独立菜单查询','','2018-04-09 09:57:14','menu','menu:amr','菜单组'),('9ce1e7d7-4dc3-4924-ae18-fb871a20c369','菜单查询','','2018-04-09 09:57:14','menu','menu:r','菜单组'),('af2c9dda-1341-48e5-b778-fa172abc0f54','菜单删除','','2018-04-09 09:57:14','menu','menu:md','菜单组'),('c6da68c4-5bcb-4ce2-af65-85aa8f2df6a4','角色权限查询','','2018-04-09 09:57:14','permission','permission:rrolep','权限组'),('d1db8f87-4312-4467-b5cf-de3efa7b2aa5','所有权限查询','','2018-04-09 09:57:14','permission','permission:apr','权限组'),('da749254-c76e-4c88-b2b4-91bef719a0c4','菜单更新','','2018-04-09 09:57:14','menu','menu:mu','菜单组');
/*!40000 ALTER TABLE `system_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_role`
--

DROP TABLE IF EXISTS `system_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `system_role` (
  `roleId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '角色ID',
  `roleName` varchar(45) COLLATE utf8_unicode_ci NOT NULL COMMENT '角色名',
  `roleRemark` varchar(45) COLLATE utf8_unicode_ci NOT NULL COMMENT '角色说明',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '角色创建时间',
  `roleGroup` varchar(45) COLLATE utf8_unicode_ci NOT NULL COMMENT '角色分组',
  `roleValue` varchar(45) COLLATE utf8_unicode_ci NOT NULL COMMENT '角色值 user:m',
  `editFlag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否可更改 0:不可更改 1:可更改',
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='系统角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_role`
--

LOCK TABLES `system_role` WRITE;
/*!40000 ALTER TABLE `system_role` DISABLE KEYS */;
INSERT INTO `system_role` VALUES ('25a417bf-a385-472d-9edf-11e5ec01c0f7','测试角色','','2018-04-10 09:21:11','system','ceshi:m',1),('4c4735cc-e3eb-454f-8dc2-e0707e19247a','菜单管理角色','','2018-04-09 09:57:14','system','menu:m',0),('71ceb8e9-3fa2-4bb1-a242-734c3c5879fb','权限管理角色','','2018-04-09 09:57:14','system','permission:m',0),('dd1540bf-6714-4d35-aa35-73da1613e1ac','角色管理角色','','2018-04-09 09:57:14','basicInfo','role:m',0);
/*!40000 ALTER TABLE `system_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_role_menu`
--

DROP TABLE IF EXISTS `system_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `system_role_menu` (
  `roleId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '角色表主键',
  `menuId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '菜单表主键',
  PRIMARY KEY (`roleId`,`menuId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='系统角色关联的菜单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_role_menu`
--

LOCK TABLES `system_role_menu` WRITE;
/*!40000 ALTER TABLE `system_role_menu` DISABLE KEYS */;
INSERT INTO `system_role_menu` VALUES ('25a417bf-a385-472d-9edf-11e5ec01c0f7','fd4b92d4-78c8-478a-bc41-6985d38a261b');
/*!40000 ALTER TABLE `system_role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_role_permission`
--

DROP TABLE IF EXISTS `system_role_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `system_role_permission` (
  `roleId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '角色ID',
  `permissionId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '权限ID',
  `shouldDeleteFlag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '可删除标识 0:不可 1:可',
  PRIMARY KEY (`roleId`,`permissionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='角色和权限关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_role_permission`
--

LOCK TABLES `system_role_permission` WRITE;
/*!40000 ALTER TABLE `system_role_permission` DISABLE KEYS */;
INSERT INTO `system_role_permission` VALUES ('25a417bf-a385-472d-9edf-11e5ec01c0f7','33f6b6d3-604f-439b-904d-8afb3151f017',1),('25a417bf-a385-472d-9edf-11e5ec01c0f7','7a91b1c7-9826-4324-9851-0841dd46ad90',1),('25a417bf-a385-472d-9edf-11e5ec01c0f7','8b5f444d-dc3a-4189-b564-3a720aacfb28',1),('25a417bf-a385-472d-9edf-11e5ec01c0f7','9b10fbc4-03ec-4d30-9822-da76fec7cd84',1),('25a417bf-a385-472d-9edf-11e5ec01c0f7','9ce1e7d7-4dc3-4924-ae18-fb871a20c369',1),('25a417bf-a385-472d-9edf-11e5ec01c0f7','af2c9dda-1341-48e5-b778-fa172abc0f54',1),('25a417bf-a385-472d-9edf-11e5ec01c0f7','da749254-c76e-4c88-b2b4-91bef719a0c4',1),('4c4735cc-e3eb-454f-8dc2-e0707e19247a','33f6b6d3-604f-439b-904d-8afb3151f017',0),('4c4735cc-e3eb-454f-8dc2-e0707e19247a','7a91b1c7-9826-4324-9851-0841dd46ad90',0),('4c4735cc-e3eb-454f-8dc2-e0707e19247a','8b5f444d-dc3a-4189-b564-3a720aacfb28',0),('4c4735cc-e3eb-454f-8dc2-e0707e19247a','9b10fbc4-03ec-4d30-9822-da76fec7cd84',0),('4c4735cc-e3eb-454f-8dc2-e0707e19247a','9ce1e7d7-4dc3-4924-ae18-fb871a20c369',0),('4c4735cc-e3eb-454f-8dc2-e0707e19247a','af2c9dda-1341-48e5-b778-fa172abc0f54',0),('4c4735cc-e3eb-454f-8dc2-e0707e19247a','da749254-c76e-4c88-b2b4-91bef719a0c4',0),('71ceb8e9-3fa2-4bb1-a242-734c3c5879fb','c6da68c4-5bcb-4ce2-af65-85aa8f2df6a4',0),('71ceb8e9-3fa2-4bb1-a242-734c3c5879fb','d1db8f87-4312-4467-b5cf-de3efa7b2aa5',0),('dd1540bf-6714-4d35-aa35-73da1613e1ac','23dae94e-719e-491f-bf52-d1497664c8ea',0),('dd1540bf-6714-4d35-aa35-73da1613e1ac','2d124321-5aa2-453e-9a78-ab5d47bc7844',0),('dd1540bf-6714-4d35-aa35-73da1613e1ac','98be7761-19f5-467d-8c6e-841dbcd12faa',0);
/*!40000 ALTER TABLE `system_role_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_ui_config`
--

DROP TABLE IF EXISTS `system_ui_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `system_ui_config` (
  `uiConfigId` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '2e7dfb5c-9117-4263-a799-ee3b4c1fba68' COMMENT '系统ui配置的Id',
  `loginLogo` varchar(300) COLLATE utf8_unicode_ci NOT NULL DEFAULT '/system/logo.png' COMMENT '登录页面的logo',
  `systemName` varchar(45) COLLATE utf8_unicode_ci NOT NULL DEFAULT '后台管理模板系统' COMMENT '系统的名字',
  `titleValue` varchar(45) COLLATE utf8_unicode_ci NOT NULL DEFAULT '项目基础模板' COMMENT '浏览器中也签的名',
  `navTitle` varchar(45) COLLATE utf8_unicode_ci NOT NULL DEFAULT '模板' COMMENT '导航栏折叠后显示的名',
  `titleIco` varchar(300) COLLATE utf8_unicode_ci NOT NULL DEFAULT '/system/favicon.ico' COMMENT '浏览器页签上的ico配置',
  PRIMARY KEY (`uiConfigId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='系统UI配置';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_ui_config`
--

LOCK TABLES `system_ui_config` WRITE;
/*!40000 ALTER TABLE `system_ui_config` DISABLE KEYS */;
INSERT INTO `system_ui_config` VALUES ('2e7dfb5c-9117-4263-a799-ee3b4c1fba68','/system/5ecd55d7628a67b77172864585f418bf.png','测试成长系统','成长系统','成长','/system/8f79aa7dcf51445ce16388384794cd76.ico');
/*!40000 ALTER TABLE `system_ui_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_user`
--

DROP TABLE IF EXISTS `system_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `system_user` (
  `userId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户表主键Id',
  `username` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8 NOT NULL,
  `salt` varchar(100) CHARACTER SET utf8 NOT NULL,
  `userStatus` tinyint(4) NOT NULL DEFAULT '0' COMMENT '用户状态: 0未锁 1锁',
  `userAvatar` varchar(300) COLLATE utf8_unicode_ci NOT NULL DEFAULT '/default/user.png' COMMENT '用户头像',
  `editFlag` tinyint(4) NOT NULL DEFAULT '1' COMMENT '可编辑标识 1:可编辑 0:不可编辑',
  `deleteFlag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标识 0:未删除 1:已删除',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='系统用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_user`
--

LOCK TABLES `system_user` WRITE;
/*!40000 ALTER TABLE `system_user` DISABLE KEYS */;
INSERT INTO `system_user` VALUES ('0','admin','b69b0b14878a575aeaa1695f6cc2192d48db88c7a697a5e9fef643dc3d1d9c08','PiFF6VSE3nlcmQQqVKD0',0,'/default/user.png',0,0),('0716b872-3d23-4c60-ba9f-b628e1efaa83','ceshi','8c059d5ebc4f9548b60d4a2991e51cf3a87d9653c26c980a1eedb764223163c9','9Ch3qBEW6rKmAiBfEJMz',0,'/default/user.png',1,0);
/*!40000 ALTER TABLE `system_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_user_role`
--

DROP TABLE IF EXISTS `system_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `system_user_role` (
  `userId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户ID',
  `roleId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`userId`,`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='系统用户和角色关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_user_role`
--

LOCK TABLES `system_user_role` WRITE;
/*!40000 ALTER TABLE `system_user_role` DISABLE KEYS */;
INSERT INTO `system_user_role` VALUES ('0716b872-3d23-4c60-ba9f-b628e1efaa83','4c4735cc-e3eb-454f-8dc2-e0707e19247a'),('0716b872-3d23-4c60-ba9f-b628e1efaa83','71ceb8e9-3fa2-4bb1-a242-734c3c5879fb');
/*!40000 ALTER TABLE `system_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_user_token`
--

DROP TABLE IF EXISTS `system_user_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `system_user_token` (
  `userId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户ID',
  `token` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户登录token',
  `expireTime` datetime NOT NULL COMMENT '过期时间',
  `updateTime` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='系统用户token';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_user_token`
--

LOCK TABLES `system_user_token` WRITE;
/*!40000 ALTER TABLE `system_user_token` DISABLE KEYS */;
INSERT INTO `system_user_token` VALUES ('0','41f0h7ee19e93e9hf9ca97b451h1502f','2018-04-17 21:25:15','2018-04-17 09:25:15'),('0716b872-3d23-4c60-ba9f-b628e1efaa83','b220f2a09g0hae721f2cbc7hcgeg27bc','2018-04-17 21:25:00','2018-04-17 09:25:00');
/*!40000 ALTER TABLE `system_user_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_userinfo`
--

DROP TABLE IF EXISTS `system_userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `system_userinfo` (
  `userId` varchar(100) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `userMobile` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `userRealName` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `userEmail` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '用户添加时间',
  `deleteFlag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标识 0:未删除 1:已删除',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='系统用户详细信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_userinfo`
--

LOCK TABLES `system_userinfo` WRITE;
/*!40000 ALTER TABLE `system_userinfo` DISABLE KEYS */;
INSERT INTO `system_userinfo` VALUES ('0','11111111','管理员','super@example.com','2017-12-15 12:07:16',0),('0716b872-3d23-4c60-ba9f-b628e1efaa83','1234567','测试','ceshi@example.com','2018-04-17 08:40:13',0);
/*!40000 ALTER TABLE `system_userinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-17 21:04:21
