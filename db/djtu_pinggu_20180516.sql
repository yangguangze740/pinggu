CREATE DATABASE  IF NOT EXISTS `djtu_pinggu` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `djtu_pinggu`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 10.1.1.121    Database: djtu_pinggu
-- ------------------------------------------------------
-- Server version	5.7.13

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
INSERT INTO `bak_menu` VALUES ('014789a7-5c7f-4b33-bbcc-e7e453ae2590','0','部门管理','/admin/department',1,'',13,'problem','评审问题','10','2018-04-23 10:57:27','CURRENT_TIMESTAMP',0),('02dd9545-d84b-4190-8a13-aef23c2edf01','0','系统菜单配置','/admin/menu',1,'',2,'system','系统配置','10','2018-04-18 15:14:15','CURRENT_TIMESTAMP',0),('03356cbd-277a-4556-9da1-f1c5bf5a0d11','0','系统菜单配置','/admin/menu',1,'',6,'system','系统配置','10','2018-04-23 10:57:27','CURRENT_TIMESTAMP',0),('03b26e3b-5733-4256-8e33-ad384018cfce','0','系统UI配置','/admin/ui',1,'',18,'system','系统配置','10','2018-04-23 10:57:27','CURRENT_TIMESTAMP',0),('03b926c0-7f53-45c6-93a9-02400060d582','0','普通用户管理','/admin/user/general',1,'',2,'frontUser','前台用户','7','2018-04-18 12:47:25','CURRENT_TIMESTAMP',0),('06e7d5bc-334c-4e43-ba99-dd2ba11bc406','0','系统用户管理','/admin/user',1,'',8,'system','系统配置','10','2018-04-22 10:53:24','CURRENT_TIMESTAMP',0),('08915a38-1c92-439c-be2f-a842468e36d9','0','系统权限管理','/admin/permission',1,'',2,'system','系统配置','10','2018-04-18 14:39:02','CURRENT_TIMESTAMP',0),('0afecc23-b342-4be0-b8ef-70edee1014c0','0','评审问题管理','/admin/problem',1,'',3,'problem','评审问题','10','2018-04-25 09:15:57','CURRENT_TIMESTAMP',0),('0c145787-604c-44b0-930b-a965b5af2069','0','普通用户管理','/admin/user/general',1,'',7,'frontUser','前台用户','10','2018-04-22 10:53:24','CURRENT_TIMESTAMP',0),('0ce60cc8-76eb-43e8-a3c1-55054fbb09ef','0','部门管理','/admin/department',1,'',18,'problem','评审问题','10','2018-04-22 10:53:24','CURRENT_TIMESTAMP',0),('0e1f8a7c-55b9-4423-b922-cf68335d3149','0','系统菜单配置','/admin/menu',1,'',3,'system','系统配置','10','2018-04-18 14:39:02','CURRENT_TIMESTAMP',0),('0e2a7f1b-4102-480a-a2e0-46c1b90c24e5','0','系统角色配置','/admin/role',1,'',18,'system','系统配置','10','2018-04-25 09:15:57','CURRENT_TIMESTAMP',0),('1028d885-6d0a-4790-b0b2-79846c56329d','','系统UI配置','/admin/ui',1,'',0,'system','系统配置','2','2018-04-02 08:49:21','CURRENT_TIMESTAMP',0),('11aa9623-5d3a-41f4-8df4-093e522d5fbf','0','牵头部门管理','/admin/lead',1,'',16,'supportFile','支撑文件','10','2018-04-25 09:15:57','CURRENT_TIMESTAMP',0),('12f5f160-3f90-4f84-8053-d5d1e606ed62','0','系统权限管理','/admin/permission',1,'',0,'system','系统配置','10','2018-04-18 14:46:42','CURRENT_TIMESTAMP',0),('134dcef9-01d3-4d72-a5b5-a53deb3a9634','a13a7a40-8b8b-4315-8ce9-90ab6e0b7303','评审文件管理','/admin/raterFile',1,'',12,'file','文件管理','10','2018-04-22 12:50:28','CURRENT_TIMESTAMP',0),('14c52b00-f2e2-4b8f-b2e7-564da69cfabd','0','支撑文件管理','/admin/supportFile',1,'',14,'file','文件管理','10','2018-04-22 10:53:24','CURRENT_TIMESTAMP',0),('17c6a00e-e7ba-44b1-a631-2ff990c4d04d','66fc11ce-cfd9-4036-ac15-1751c067a79e','牵头部门管理','/admin/lead',1,'',9,'supportFile','支撑文件','10','2018-04-22 12:50:28','CURRENT_TIMESTAMP',0),('1a2a4aaa-a6bb-4c44-99ea-c16c7fd3d52b','0','系统UI配置','/admin/ui',1,'',4,'system','系统配置','10','2018-04-18 14:46:42','CURRENT_TIMESTAMP',0),('20fe9614-0a8f-4c5f-bfb5-e237ab62746e','','系统UI配置','/admin/ui',1,'',0,'system','系统配置','0','2018-04-02 08:31:14','CURRENT_TIMESTAMP',0),('22802650-e088-450a-acb6-be5a0d779c45','0','系统用户管理','/admin/user',1,'',10,'system','系统配置','10','2018-04-23 10:57:27','CURRENT_TIMESTAMP',0),('23569347-10e3-4615-aa86-8a2c80ba4662','0','系统用户管理','/admin/user',1,'',3,'system','系统配置','10','2018-04-18 14:47:57','CURRENT_TIMESTAMP',0),('25a370a2-11ad-46dc-9259-fce585089e90','0','系统UI配置','/admin/ui',1,'',4,'system','系统配置','10','2018-04-18 14:47:57','CURRENT_TIMESTAMP',0),('25ff0650-8dba-4bbd-bb90-54d4b3ed1734','0','评审问题管理','/admin/problem',1,'',8,'problem','评审问题','10','2018-04-23 10:57:27','CURRENT_TIMESTAMP',0),('27250f26-cddd-42b7-b330-1fb77afac380','0','责任部门管理','/admin/department/duty',1,'',14,'supportFile','支撑文件','10','2018-04-25 09:15:57','CURRENT_TIMESTAMP',0),('29c62ab8-7825-4c9a-8905-a7fbe697e0bc','0','系统权限管理','/admin/permission',1,'',1,'system','系统配置','8','2018-04-18 12:54:28','CURRENT_TIMESTAMP',0),('2b2e0135-887c-4ce5-a97a-1e5b26515148','0','普通用户管理','/admin/user/general',1,'',0,'frontUser','前台用户','8','2018-04-18 12:54:28','CURRENT_TIMESTAMP',0),('2b4b02d0-5f7b-4c60-9a1e-e67938177171','bc63c206-84a1-4518-87d0-454aa3a7455b','系统菜单配置','/admin/menu',1,'',11,'system','系统配置','10','2018-04-22 12:50:28','CURRENT_TIMESTAMP',0),('2bb599eb-5624-4f2f-afba-8ad89453eb95','0','系统用户管理','/admin/user',1,'',3,'system','系统配置','10','2018-04-18 14:46:42','CURRENT_TIMESTAMP',0),('2d6c0be7-d8c2-4d79-9706-d1a45c1abae4','66fc11ce-cfd9-4036-ac15-1751c067a79e','审核要素管理','/admin/point',1,'',17,'supportFile','支撑文件','10','2018-04-22 12:50:28','CURRENT_TIMESTAMP',0),('2f89c9ac-4989-4e22-b607-968a16c2b32d','0','系统权限管理','/admin/permission',1,'',2,'system','系统配置','10','2018-04-18 14:41:24','CURRENT_TIMESTAMP',0),('2fded94d-ad05-4ff6-87d4-66673ae28f46','0','分数管理','/admin/score',1,'',10,'problem','评审问题','10','2018-04-22 10:53:24','CURRENT_TIMESTAMP',0),('3186f449-1df6-448f-b30a-8b7955e96363','0','审核要素管理','/admin/element',1,'',2,'supportFile','支撑文件','10','2018-04-25 09:15:57','CURRENT_TIMESTAMP',0),('33014d3a-5be3-4e5f-9cc6-bee1f7bbc82a','0','评审问题管理','/admin/problem',1,'',1,'problem','评审问题','10','2018-04-22 12:50:28','CURRENT_TIMESTAMP',0),('35afb6df-2c0e-436e-8691-fa0dc8024d8f','7ad13ca3-9194-4721-8908-4a0eabe5d69f','类型管理','/admin/type',1,'',19,'problem','评审问题','10','2018-04-22 12:50:28','CURRENT_TIMESTAMP',0),('364f0ac1-315d-4208-a97d-227da93d598b','0','系统配置','/admin/config',1,'',4,'config','系统配置','10','2018-04-25 09:15:57','CURRENT_TIMESTAMP',0),('3a7869ad-c82e-482b-b769-5c1e04229010','0','类型管理','/admin/type',1,'',9,'problem','评审问题','10','2018-04-25 09:15:57','CURRENT_TIMESTAMP',0),('3c7b2700-4cb9-48f6-87d9-6e9799a82d15','0','评审用户管理','/admin/user/rater',1,'',4,'frontUser','前台用户','10','2018-04-22 10:53:24','CURRENT_TIMESTAMP',0),('3ef0c024-8fd4-46d9-a40b-4ae042a8ff3c','0','普通用户管理','/admin/user/general',1,'',3,'frontUser','前台用户','10','2018-04-18 15:14:15','CURRENT_TIMESTAMP',0),('3fece416-6f31-41bf-9d50-6a75dd7a0902','0','前台用户管理','',1,'fa-users',20,'menu:parent','父菜单','10','2018-04-23 10:20:18','CURRENT_TIMESTAMP',1),('4027014f-958d-4811-bffd-714c7124cc49','0','系统UI配置','/admin/ui',1,'',7,'system','系统配置','10','2018-04-25 09:15:57','CURRENT_TIMESTAMP',0),('4311e9b5-fec4-469d-9a14-d2f3509f61df','0','普通用户管理','/admin/user/general',1,'',2,'frontUser','前台用户','10','2018-04-18 14:46:42','CURRENT_TIMESTAMP',0),('43c26857-cb32-4347-aa1c-e1e2b3320020','0','系统权限管理','/admin/permission',1,'',5,'system','系统配置','10','2018-04-25 09:15:57','CURRENT_TIMESTAMP',0),('45e8a403-1e16-4abb-9881-2c27d90f5975','0','审核要点管理','/admin/point',1,'',9,'supportFile','支撑文件','10','2018-04-22 10:53:24','CURRENT_TIMESTAMP',0),('492271fd-2274-4555-9521-ea6ceb03c3b0','0','分数管理','/admin/score',1,'',14,'problem','评审问题','10','2018-04-23 10:57:27','CURRENT_TIMESTAMP',0),('49dce65d-9727-40fc-9a9f-2fbe07a013f4','0','系统菜单配置','/admin/menu',1,'',13,'system','系统配置','10','2018-04-22 10:53:24','CURRENT_TIMESTAMP',0),('4b3b5c6c-db37-4932-9412-c4dc376123e0','0','部门管理','/admin/department',1,'',13,'problem','评审问题','10','2018-04-25 09:15:57','CURRENT_TIMESTAMP',0),('4cd00418-1808-4203-b53e-ed213c687761','','系统UI配置','/admin/ui',1,'',0,'system','系统配置','1','2018-04-02 08:43:52','CURRENT_TIMESTAMP',0),('5067bc71-804d-480f-9767-69cdc037b758','0','系统角色配置','/admin/role',1,'',3,'system','系统配置','10','2018-04-22 10:53:24','CURRENT_TIMESTAMP',0),('50c98602-ac06-4e50-9936-0d44357b9059','0','类型管理','/admin/type',1,'',19,'problem','评审问题','10','2018-04-22 10:53:24','CURRENT_TIMESTAMP',0),('536d1d92-867d-4392-a890-c5ae07a2aec2','0','系统角色配置','/admin/role',1,'',4,'system','系统配置','10','2018-04-18 14:41:24','CURRENT_TIMESTAMP',0),('551465fb-06ba-4f17-aa08-a323642884d2','0','系统角色配置','/admin/role',1,'',1,'system','系统配置','10','2018-04-18 14:47:57','CURRENT_TIMESTAMP',0),('57584201-69c3-421b-aca8-1b8437e5ae2f','0','系统角色配置','/admin/role',1,'',1,'system','系统配置','4','2018-04-08 12:21:55','CURRENT_TIMESTAMP',0),('57d7a52d-493c-4c7f-9697-c1adc56daf7e','0','系统UI配置','/admin/ui',1,'',3,'system','系统配置','7','2018-04-18 12:47:25','CURRENT_TIMESTAMP',0),('593da538-ccf7-423d-8957-5b924a1f23e0','0','系统权限管理','/admin/permission',1,'',5,'system','系统配置','10','2018-04-23 10:57:27','CURRENT_TIMESTAMP',0),('59d8535f-ddf4-4204-9e3b-bb0c392254be','0','系统角色配置','/admin/role',1,'',0,'system','系统配置','7','2018-04-18 12:47:25','CURRENT_TIMESTAMP',0),('5c29d7c6-a3c2-4e93-b6e6-4e94004ca801','0','支撑文件管理','/admin/supportFile',1,'',8,'file','文件管理','10','2018-04-25 09:15:57','CURRENT_TIMESTAMP',0),('5e67f167-b5fd-4dfe-a65c-298b842e9e8a','0','系统菜单配置','/admin/menu',1,'',2,'system','系统配置','5','2018-04-09 08:42:04','CURRENT_TIMESTAMP',0),('61b8beb5-9c92-40dd-b12d-3571967ec69a','66fc11ce-cfd9-4036-ac15-1751c067a79e','审核项目管理','/admin/project',1,'',4,'supportFile','支撑文件','10','2018-04-22 12:50:28','CURRENT_TIMESTAMP',0),('6488a956-068c-4bab-b2dc-b8dd0d0ab2fe','0','审核要素管理','/admin/point',1,'',2,'supportFile','支撑文件','10','2018-04-22 10:53:24','CURRENT_TIMESTAMP',0),('66590b52-dd27-4ac1-bf38-20395db7b47e','bc63c206-84a1-4518-87d0-454aa3a7455b','系统UI配置','/admin/ui',1,'',2,'system','系统配置','10','2018-04-22 12:50:28','CURRENT_TIMESTAMP',0),('66db5425-07d7-4b46-81d0-325d0cd453e6','0','审核要点管理','/admin/point',1,'',12,'supportFile','支撑文件','10','2018-04-25 09:15:57','CURRENT_TIMESTAMP',0),('66fc11ce-cfd9-4036-ac15-1751c067a79e','0','支撑文件结构管理','',1,'fa-folder-open-o',23,'menu:parent','父菜单','10','2018-04-23 10:24:00','CURRENT_TIMESTAMP',1),('6836e80b-3d01-4264-bc7c-af25bb8bc275','0','系统用户管理','/admin/user',1,'',5,'system','系统配置','10','2018-04-18 14:39:02','CURRENT_TIMESTAMP',0),('6bfc1519-0aa1-464a-9ab3-441ef1bc0bc1','0','普通用户管理','/admin/user/general',1,'',2,'frontUser','前台用户','10','2018-04-18 14:47:57','CURRENT_TIMESTAMP',0),('6e0fb4ae-b734-4549-bb06-d3db93262f10','0','系统权限管理','/admin/permission',1,'',1,'system','系统配置','7','2018-04-18 12:47:25','CURRENT_TIMESTAMP',0),('6e806406-985c-4228-b3fe-bf562f14db42','0','系统权限管理','/admin/permission',1,'',16,'system','系统配置','10','2018-04-22 10:53:24','CURRENT_TIMESTAMP',0),('6ee4e8dc-1cf4-4e4f-a60a-801c178639a4','0','系统UI配置','/admin/ui',1,'',3,'system','系统配置','9','2018-04-18 13:00:26','CURRENT_TIMESTAMP',0),('6f952d67-5972-4e58-aa49-c78267d98732','0','评审问题管理','/admin/problem',1,'',11,'problem','评审问题','10','2018-04-22 10:53:24','CURRENT_TIMESTAMP',0),('786fa9af-a070-4eb4-a211-7e006b5e6145','0','普通用户管理','/admin/user/general',1,'',0,'frontUser','前台用户','10','2018-04-25 09:15:57','CURRENT_TIMESTAMP',0),('792b0864-2971-4c4a-a732-727acfec13d0','0','评审用户管理','/admin/user/rater',1,'',19,'frontUser','前台用户','10','2018-04-25 09:15:57','CURRENT_TIMESTAMP',0),('79590123-e283-4811-a98a-3add5945c7f9','bc63c206-84a1-4518-87d0-454aa3a7455b','系统用户管理','/admin/user',1,'',8,'system','系统配置','10','2018-04-22 12:50:28','CURRENT_TIMESTAMP',0),('797c0acc-76be-462b-903e-8f1273f3714c','0','牵头部门管理','/admin/lead',1,'',1,'supportFile','支撑文件','10','2018-04-22 10:53:24','CURRENT_TIMESTAMP',0),('7a1d20b3-4dbc-4882-bc16-6923f7f64d71','0','系统用户管理','/admin/user',1,'',5,'system','系统配置','10','2018-04-18 14:41:24','CURRENT_TIMESTAMP',0),('7ad13ca3-9194-4721-8908-4a0eabe5d69f','0','自评文件结构','',1,'fa-puzzle-piece',24,'menu:parent','父菜单','10','2018-04-23 10:26:23','CURRENT_TIMESTAMP',1),('7be64c4e-120a-428a-9320-9249e0a89d78','f8605673-2260-4af3-87bb-a7543893f72d','系统UI配置','/admin/ui',1,'',1,'system','系统配置','6','2018-04-09 09:57:14','CURRENT_TIMESTAMP',0),('7dca4504-6952-4c2b-bdf3-dfdd377bf1c8','0','系统配置','/admin/config',1,'',5,'config','系统配置','10','2018-04-22 10:53:24','CURRENT_TIMESTAMP',0),('7e3e0355-744e-473c-957f-9c0a231a5ccf','0','系统权限管理','/admin/permission',1,'',0,'system','系统配置','10','2018-04-18 14:47:57','CURRENT_TIMESTAMP',0),('8011fb9b-60ee-41a8-8ad2-a9cad59fe9cf','0','系统配置','/admin/config',1,'',3,'config','系统配置','10','2018-04-23 10:57:27','CURRENT_TIMESTAMP',0),('80c0506d-7fad-4196-a05b-d44d176abe0a','0','责任部门管理','/admin/department/duty',1,'',0,'supportFile','支撑文件','10','2018-04-22 10:53:24','CURRENT_TIMESTAMP',0),('81eec7f7-ebf8-42a0-a003-5cec763f1ce5','0','审核要素管理','/admin/point',1,'',11,'supportFile','支撑文件','10','2018-04-23 10:57:27','CURRENT_TIMESTAMP',0),('8278741e-0cb0-4fcd-a0a2-3d4979df28d2','0','系统菜单配置','/admin/menu',1,'',2,'system','系统配置','9','2018-04-18 13:00:26','CURRENT_TIMESTAMP',0),('864333e9-8eea-4f01-bdeb-a302494ec2fe','0','系统菜单配置','/admin/menu',1,'',4,'system','系统配置','7','2018-04-18 12:47:25','CURRENT_TIMESTAMP',0),('8649c08b-938b-47e6-a012-61ecb74acb57','3fece416-6f31-41bf-9d50-6a75dd7a0902','评审用户管理','/admin/user/rater',1,'fa-arrow-down',10,'frontUser','前台用户','10','2018-04-22 12:50:28','CURRENT_TIMESTAMP',0),('86b34aa7-2bfa-42de-bc54-310f6d3d823d','0','系统菜单配置','/admin/menu',1,'',5,'system','系统配置','10','2018-04-18 14:46:42','CURRENT_TIMESTAMP',0),('874afa47-3f4e-4eda-8f23-4d06d78241bb','0','系统UI配置','/admin/ui',1,'',2,'system','系统配置','4','2018-04-08 12:21:55','CURRENT_TIMESTAMP',0),('897bcbdd-6a73-4900-b36b-bb6590172326','0','系统角色配置','/admin/role',1,'',0,'system','系统配置','5','2018-04-09 08:42:04','CURRENT_TIMESTAMP',0),('8dcebcb7-c220-4e3f-9ab6-aeb178be146a','0','系统菜单配置','/admin/menu',1,'',2,'system','系统配置','8','2018-04-18 12:54:28','CURRENT_TIMESTAMP',0),('906dada8-b0b1-4109-982d-144e7a5aba5e','0','系统菜单配置','/admin/menu',1,'fa-align-justify',1,'system','系统配置','3','2018-04-02 12:47:29','CURRENT_TIMESTAMP',0),('940192a5-c08c-4945-a833-f0133912a427','0','普通用户管理','/admin/user/general',1,'',17,'frontUser','前台用户','10','2018-04-23 10:57:27','CURRENT_TIMESTAMP',0),('969022be-8980-493c-9958-8baba92b9132','0','系统UI配置','/admin/ui',1,'',1,'system','系统配置','5','2018-04-09 08:42:04','CURRENT_TIMESTAMP',0),('9e9827bc-4824-49f1-b30d-2a86f0795bb6','0','审核项目管理','/admin/project',1,'',2,'supportFile','支撑文件','10','2018-04-23 10:57:27','CURRENT_TIMESTAMP',0),('9ec22092-dae7-4bc1-9949-43d261a1cec2','0','普通用户管理','/admin/user/general',1,'',0,'frontUser','前台用户','10','2018-04-18 14:41:24','CURRENT_TIMESTAMP',0),('9f51220a-2cbb-4cb3-94c4-66ca66579f30','bc63c206-84a1-4518-87d0-454aa3a7455b','系统配置','/admin/config',1,'',13,'config','系统配置','10','2018-04-22 12:50:28','CURRENT_TIMESTAMP',0),('9f834242-841b-47fb-9d06-1e0426ac1d70','0','日志','/admin/log',1,'',19,'config','系统配置','10','2018-04-23 10:57:27','CURRENT_TIMESTAMP',0),('a02095ef-fa96-4aa5-be49-ba8ceacafd13','0','系统UI配置','/admin/ui',1,'',0,'system','系统配置','10','2018-04-18 15:14:15','CURRENT_TIMESTAMP',0),('a109cfe0-93ac-4b43-a892-a717e6f55e12','0','系统UI配置','/admin/ui',1,'',1,'system','系统配置','10','2018-04-18 14:39:02','CURRENT_TIMESTAMP',0),('a13a7a40-8b8b-4315-8ce9-90ab6e0b7303','0','文件管理','',1,'fa-file',21,'menu:parent','父菜单','10','2018-04-23 10:21:54','CURRENT_TIMESTAMP',1),('a1d0518c-938d-4981-91bd-d5c474de1eea','0','支撑文件管理','/admin/supportFile',1,'',7,'file','文件管理','10','2018-04-23 10:57:27','CURRENT_TIMESTAMP',0),('a2afa61e-2827-4118-9aef-dea75d80d3bf','66fc11ce-cfd9-4036-ac15-1751c067a79e','审核要点管理','/admin/point',1,'',0,'supportFile','支撑文件','10','2018-04-22 12:50:28','CURRENT_TIMESTAMP',0),('aaba12e7-9cf2-4c07-bd67-556a843f7986','7ad13ca3-9194-4721-8908-4a0eabe5d69f','部门管理','/admin/department',1,'',15,'problem','评审问题','10','2018-04-22 12:50:28','CURRENT_TIMESTAMP',0),('adf7c523-6faf-4ed2-8c62-3526956233cc','0','系统菜单配置','/admin/menu',1,'',3,'system','系统配置','10','2018-04-18 14:41:24','CURRENT_TIMESTAMP',0),('b023fe72-d511-497b-a40c-cce995acc665','0','系统角色配置','/admin/role',1,'',1,'system','系统配置','10','2018-04-18 14:46:42','CURRENT_TIMESTAMP',0),('b373aff1-0ff8-49c0-a4f1-8f732874170a','0','系统菜单配置','/admin/menu',1,'',0,'system','系统配置','4','2018-04-08 12:21:55','CURRENT_TIMESTAMP',0),('b6b38fca-885b-4e61-b742-6115dafd4383','0','系统角色配置','/admin/role',1,'',1,'system','系统配置','10','2018-04-18 15:14:15','CURRENT_TIMESTAMP',0),('bc63c206-84a1-4518-87d0-454aa3a7455b','0','系统配置','',1,'fa-sliders',22,'menu:parent','父菜单','10','2018-04-23 10:23:00','CURRENT_TIMESTAMP',1),('bd5964e6-ecef-409e-9081-642f05a00a9a','a13a7a40-8b8b-4315-8ce9-90ab6e0b7303','支撑文件管理','/admin/supportFile',1,'',14,'file','文件管理','10','2018-04-22 12:50:28','CURRENT_TIMESTAMP',0),('be6c798c-7173-43da-a447-7f440e17ee29','0','普通用户管理','/admin/user/general',1,'',0,'frontUser','前台用户','10','2018-04-18 14:39:02','CURRENT_TIMESTAMP',0),('beb86ccb-61a2-45bf-8337-d4e9428174f7','0','系统权限管理','/admin/permission',1,'',4,'system','系统配置','10','2018-04-18 15:14:15','CURRENT_TIMESTAMP',0),('c072ef53-e874-4c94-818c-6c255d79aaf9','0','系统UI配置','/admin/ui',1,'',3,'system','系统配置','8','2018-04-18 12:54:28','CURRENT_TIMESTAMP',0),('c3674342-ed83-41cb-8079-ab13816870b5','0','系统菜单配置','/admin/menu',1,'',5,'system','系统配置','10','2018-04-18 14:47:57','CURRENT_TIMESTAMP',0),('c46565d1-cac0-4545-8235-6da37b1bf047','0','系统用户管理','/admin/user',1,'',1,'system','系统配置','10','2018-04-25 09:15:57','CURRENT_TIMESTAMP',0),('c6ae065b-1a9d-417e-a030-b71ec75f0c3b','0','系统用户管理','/admin/user',1,'',5,'system','系统配置','10','2018-04-18 15:14:15','CURRENT_TIMESTAMP',0),('c8bd18e9-c6cf-4a3d-ab01-9276b0e354aa','0','系统菜单配置','/admin/menu',1,'',11,'system','系统配置','10','2018-04-25 09:15:57','CURRENT_TIMESTAMP',0),('ca23ad01-a045-4714-9f3b-4e1dd83ee038','0','日志','/admin/log',1,'',10,'config','系统配置','10','2018-04-25 09:15:57','CURRENT_TIMESTAMP',0),('cc8ba049-68b9-479c-b2f3-9f4848213566','0','审核项目管理','/admin/project',1,'',12,'supportFile','支撑文件','10','2018-04-22 10:53:24','CURRENT_TIMESTAMP',0),('ccb78353-edef-4543-b69d-2a6280199e32','0','审核要点管理','/admin/point',1,'',1,'supportFile','支撑文件','10','2018-04-23 10:57:27','CURRENT_TIMESTAMP',0),('ccd59ca7-04d5-47dd-802a-0fd0a245549d','0','系统UI配置','/admin/ui',1,'',1,'system','系统配置','10','2018-04-18 14:41:24','CURRENT_TIMESTAMP',0),('cd4dadcc-aa16-40e2-a33a-6580ee605584','0','责任部门管理','/admin/department/duty',1,'',16,'supportFile','支撑文件','10','2018-04-23 10:57:27','CURRENT_TIMESTAMP',0),('cf250a7b-a2b9-4158-82cf-464fb2cc1251','0','分数管理','/admin/score',1,'',6,'problem','评审问题','10','2018-04-25 09:15:57','CURRENT_TIMESTAMP',0),('d1d5d465-4e3f-49c8-8965-d3e494d9e782','f8605673-2260-4af3-87bb-a7543893f72d','系统角色配置','/admin/role',1,'',2,'system','系统配置','6','2018-04-09 09:57:14','CURRENT_TIMESTAMP',0),('d58565a7-c288-4459-b611-6cd4220d162f','0','评审文件管理','/admin/raterFile',1,'',17,'file','文件管理','10','2018-04-22 10:53:24','CURRENT_TIMESTAMP',0),('d836d33d-7cc3-47b6-b043-4ae1a69271a9','0','评审用户管理','/admin/user/rater',1,'',15,'frontUser','前台用户','10','2018-04-23 10:57:27','CURRENT_TIMESTAMP',0),('db97765e-f394-4d8a-90ee-de72e021d483','0','审核项目管理','/admin/project',1,'',17,'supportFile','支撑文件','10','2018-04-25 09:15:57','CURRENT_TIMESTAMP',0),('dd372d2a-6192-4aee-9a8a-2e92b6605790','3fece416-6f31-41bf-9d50-6a75dd7a0902','普通用户管理','/admin/user/general',1,'',5,'frontUser','前台用户','10','2018-04-22 12:50:28','CURRENT_TIMESTAMP',0),('df49fe23-98d6-49ad-8a5f-973d31b44536','66fc11ce-cfd9-4036-ac15-1751c067a79e','责任部门管理','/admin/department/duty',1,'',18,'supportFile','支撑文件','10','2018-04-22 12:50:28','CURRENT_TIMESTAMP',0),('e21d420d-43e6-42c6-ab2d-1f0ce57e1a41','0','系统角色配置','/admin/role',1,'',12,'system','系统配置','10','2018-04-23 10:57:27','CURRENT_TIMESTAMP',0),('e5bd306f-cb39-4e14-93fc-bcad05eabb19','0','分数管理','/admin/score',1,'',6,'problem','评审问题','10','2018-04-22 12:50:28','CURRENT_TIMESTAMP',0),('e5d14893-9599-446e-8819-ab6d150d7ee9','0','系统UI配置','/admin/ui',1,'fa-firefox',0,'system','系统配置','3','2018-04-02 12:47:29','CURRENT_TIMESTAMP',0),('e7770170-94df-4968-956f-87b52511caf4','0','类型管理','/admin/type',1,'',9,'problem','评审问题','10','2018-04-23 10:57:27','CURRENT_TIMESTAMP',0),('e89f854e-c281-4ed8-a00f-579e5f5abf88','0','牵头部门管理','/admin/lead',1,'',0,'supportFile','支撑文件','10','2018-04-23 10:57:27','CURRENT_TIMESTAMP',0),('e9c94144-6e4f-4495-9ba4-a1b181b73fe9','0','系统权限管理','/admin/permission',1,'',1,'system','系统配置','9','2018-04-18 13:00:26','CURRENT_TIMESTAMP',0),('ead6957f-ca56-4729-8923-51cfac8e2420','bc63c206-84a1-4518-87d0-454aa3a7455b','系统权限管理','/admin/permission',1,'',3,'system','系统配置','10','2018-04-22 12:50:28','CURRENT_TIMESTAMP',0),('eca5acbb-c9d2-4c1e-88f2-689ebf439c3d','0','系统角色配置','/admin/role',1,'',4,'system','系统配置','10','2018-04-18 14:39:02','CURRENT_TIMESTAMP',0),('efec3aae-5497-4136-9841-925e978c5b8a','0','评审文件管理','/admin/raterFile',1,'',15,'file','文件管理','10','2018-04-25 09:15:57','CURRENT_TIMESTAMP',0),('f0f4b6e8-9536-40e7-95a4-780061231840','bc63c206-84a1-4518-87d0-454aa3a7455b','系统角色配置','/admin/role',1,'',7,'system','系统配置','10','2018-04-22 12:50:28','CURRENT_TIMESTAMP',0),('f483e81c-5dc0-43b8-8502-ebae78509e09','0','系统UI配置','/admin/ui',1,'',15,'system','系统配置','10','2018-04-22 10:53:24','CURRENT_TIMESTAMP',0),('f8094a82-d39d-4ac0-baa7-62339814825a','0','普通用户管理','/admin/user/general',1,'',0,'frontUser','前台用户','9','2018-04-18 13:00:26','CURRENT_TIMESTAMP',0),('f8605673-2260-4af3-87bb-a7543893f72d','0','系统管理','',1,'fa-sliders',3,'menu:parent','父菜单','6','2018-04-10 09:09:04','CURRENT_TIMESTAMP',1),('f9aade08-e0cb-4e9c-b90e-4bdb93fce227','0','评审文件管理','/admin/raterFile',1,'',4,'file','文件管理','10','2018-04-23 10:57:27','CURRENT_TIMESTAMP',0),('f9d2e521-1999-4fb8-b2c7-659a1ebf17d6','0','日志','/admin/log',1,'',6,'config','系统配置','10','2018-04-22 10:53:24','CURRENT_TIMESTAMP',0),('fd4b92d4-78c8-478a-bc41-6985d38a261b','f8605673-2260-4af3-87bb-a7543893f72d','系统菜单配置','/admin/menu',1,'',0,'system','系统配置','6','2018-04-09 09:57:14','CURRENT_TIMESTAMP',0),('fe38cb51-3b56-46d6-9724-95def189b91b','0','日志','/admin/log',1,'',16,'config','系统配置','10','2018-04-22 12:50:28','CURRENT_TIMESTAMP',0),('fe79e8df-e576-4d87-af2a-982fe21a09bb','0','系统角色配置','/admin/role',1,'',4,'system','系统配置','9','2018-04-18 13:00:26','CURRENT_TIMESTAMP',0),('ff047795-3818-49dc-bdba-6d2944c7e208','0','系统角色配置','/admin/role',1,'',4,'system','系统配置','8','2018-04-18 12:54:28','CURRENT_TIMESTAMP',0);
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
INSERT INTO `bak_permission` VALUES ('005bd233-7058-4ce6-b75e-4ea9886e632b','独立菜单查询','','2018-04-18 12:54:28','menu','menu:amr',9,'2018-04-18 13:00:26','菜单组'),('00828b03-a47f-4c83-855f-d44ef3379a56','角色查询','','2018-04-25 09:15:58','role','role:rr',19,'2018-04-25 09:16:27','角色组'),('00887d7d-3e2b-4070-874a-b4a945607fcf','责任部门查看','','2018-04-23 10:57:28','supportFile','dutyDepartment:fr',18,'2018-04-25 09:15:58','责任部门管理组'),('01d65b8b-e669-42b6-b50c-ad3e0860e427','部门添加','','2018-04-22 12:50:29','department','department:mc',17,'2018-04-23 10:57:27','部门组'),('01d8050b-5499-4540-97ef-ae33c4081d57','分数编辑','','2018-04-23 10:57:28','score','score:mu',18,'2018-04-25 09:15:58','分数组'),('01e51fc4-17e3-43df-b8fe-31726ad4748d','评审用户查看','','2018-04-22 10:53:24','frontUser','raterUser:mr',16,'2018-04-22 12:50:28','评审用户组'),('01f24afc-7850-4ec3-ad75-18db83e8b090','普通用户添加','','2018-04-18 13:00:26','generalUser','generalUser:mc',10,'2018-04-18 14:39:02','普通用户组'),('01f2c304-57cb-47e7-b899-17d90542ad35','支撑问件查看','','2018-04-23 10:57:28','support','support:mr',18,'2018-04-25 09:15:58','支撑文件组'),('021f7e51-c0d5-4135-b516-7040010f4281','牵头部门删除','','2018-04-25 09:15:58','supportFile','leadDepartment:fd',19,'2018-04-25 09:16:27','牵头部门管理组'),('02bd9699-1ad1-4a54-8314-6fa758d4785e','用户角色更新','','2018-04-23 10:57:28','user','user:uru',18,'2018-04-25 09:15:58','用户组'),('02cc69d7-868f-4693-a428-c5d39baed680','用户删除','','2018-04-18 14:39:02','user','user:ud',11,'2018-04-18 14:41:24','用户组'),('030aaffc-e7f1-409f-ba41-29710e9dc0a0','菜单查询','','2018-04-18 14:41:24','menu','menu:r',12,'2018-04-18 14:46:42','菜单组'),('03ab846b-2de9-444a-8056-7ff12fe7aee4','所有权限查询','','2018-04-23 10:57:28','permission','permission:apr',18,'2018-04-25 09:15:58','权限组'),('0405001d-f480-402e-82d9-eab2ef04219c','普通用户详细','','2018-04-18 13:00:26','generalUser','generalUser:md',10,'2018-04-18 14:39:02','普通用户组'),('04a75a5e-a325-40f4-bb5f-469e127a2d47','用户查询','','2018-04-18 12:54:28','user','user:ur',9,'2018-04-18 13:00:26','用户组'),('04b8f00a-93ab-4b64-aa6d-1d725d0edeea','用户角色查询','','2018-04-22 12:50:29','role','role:urr',17,'2018-04-23 10:57:27','角色组'),('04e361d1-4462-4111-9522-047ff543351d','审查要点删除','','2018-04-25 09:15:58','supportFile','point:fd',19,'2018-04-25 09:16:27','审查要点管理组'),('054346c2-b618-4967-8b90-6b799b4fecf0','角色删除','','2018-04-25 09:15:58','role','role:rd',19,'2018-04-25 09:16:27','角色组'),('056d95c4-29f0-4178-a015-a9f6598c4b2e','用户添加','','2018-04-22 12:50:29','user','user:ua',17,'2018-04-23 10:57:27','用户组'),('05ff9df0-a612-4ee6-977d-833c8338d9cd','用户添加','','2018-04-25 09:15:58','user','user:ua',19,'2018-04-25 09:16:27','用户组'),('0671b215-d9cd-4c39-aa3b-aac02ed10c97','角色菜单查询','','2018-04-23 10:57:28','role','role:rmr',18,'2018-04-25 09:15:58','菜单组'),('069cd636-8dae-4c53-bc97-616b4152bbb1','菜单编辑查询','','2018-04-18 14:41:24','menu','menu:mer',12,'2018-04-18 14:46:42','菜单组'),('06e16888-fb90-426b-95c1-16a661c2d4d7','用户详细','','2018-04-18 14:41:24','user','user:ud',12,'2018-04-18 14:46:42','用户组'),('06e7b4c3-5294-4d87-bf88-71df4c39ea93','角色菜单查询','','2018-04-18 12:54:28','role','role:rmr',9,'2018-04-18 13:00:26','菜单组'),('06f7f647-e162-476d-811e-4fce2a346f41','用户详细','','2018-04-18 12:54:28','user','user:ud',9,'2018-04-18 13:00:26','用户组'),('07a4caea-dee3-470a-b361-2520e1e5e7d8','审核要点查看','','2018-04-25 09:15:58','supportFile','point:fr',19,'2018-04-25 09:16:27','审核要点管理组'),('07eccc4c-4249-4db2-a1fa-01db943eef25','审核项目编辑','','2018-04-25 09:15:58','supportFile','project:fe',19,'2018-04-25 09:16:27','审核项目管理组'),('0817b595-a0c2-4718-8e32-004aedb197c4','所有权限查询','','2018-04-18 14:47:57','permission','permission:apr',14,'2018-04-18 15:14:15','权限组'),('08fb4144-2879-4d70-a974-3667b600e98a','独立菜单查询','','2018-04-18 14:46:42','menu','menu:amr',13,'2018-04-18 14:47:57','菜单组'),('094902d4-cad3-4551-a8bb-426725c72f2b','自评问件删除','','2018-04-23 10:57:28','rater','rater:md',18,'2018-04-25 09:15:58','自评文件组'),('0977dddd-fede-4113-8c12-05eb9015b9b7','角色权限查询','','2018-04-18 14:47:57','role','role:rpr',14,'2018-04-18 15:14:15','角色组'),('09bdab86-f0c5-48ca-8461-39ae51aed8ec','所有权限查询','','2018-04-18 14:39:02','permission','permission:apr',11,'2018-04-18 14:41:24','权限组'),('09bdf5f0-7369-4982-8b65-617e7e79981c','角色添加','','2018-04-25 09:15:58','role','role:ra',19,'2018-04-25 09:16:27','角色组'),('09f25d28-809a-4471-93bb-bded627223fc','用户角色更新','','2018-04-25 09:15:58','user','user:uru',19,'2018-04-25 09:16:27','用户组'),('09f405d9-3660-4574-8494-472eae38df5b','自评问件查看','','2018-04-22 10:53:24','rater','rater:mr',16,'2018-04-22 12:50:28','自评文件组'),('0a24f2ad-4805-4eb5-8b16-f307300eecc5','配置编辑','','2018-04-22 10:53:24','config','config:mr',16,'2018-04-22 12:50:28','配置组'),('0b62285f-7c2c-4d78-89c4-74f29cc7cc6d','角色添加','','2018-04-18 12:47:25','role','role:ra',8,'2018-04-18 12:54:28','角色组'),('0b9d397a-6683-4928-97d4-428d169a233c','审查要点查看','','2018-04-23 10:57:28','supportFile','point:fr',18,'2018-04-25 09:15:58','审查要点管理组'),('0c0bd38c-77f3-4229-bd08-539a9cd46585','用户更新','','2018-04-25 09:15:58','user','user:uu',19,'2018-04-25 09:16:27','用户组'),('0c3a958c-213b-481c-b513-8676e0ef94b8','角色权限查询','','2018-04-18 14:39:02','role','role:rpr',11,'2018-04-18 14:41:24','角色组'),('0d35d4ed-1a0f-43a0-a82b-46041c3a0ba9','问题添加','','2018-04-22 12:50:29','problem','problem:mc',17,'2018-04-23 10:57:27','问题组'),('0d6ad7d8-9761-4ec3-a3dc-ad56f73c0fda','菜单更新','','2018-04-18 14:39:02','menu','menu:mu',11,'2018-04-18 14:41:24','菜单组'),('0df4ce53-c38c-4bd0-8843-c154e62e4017','支撑问件删除','','2018-04-25 09:15:58','support','support:md',19,'2018-04-25 09:16:27','支撑文件组'),('0e21d0da-9ed7-45f9-9ff5-d946a5f57fdf','评审用户删除','','2018-04-25 09:15:58','frontUser','raterUser:md',19,'2018-04-25 09:16:27','普通用户组'),('0ebea995-48d9-49f1-adf9-59fc52831340','菜单查询','','2018-04-18 13:00:26','menu','menu:r',10,'2018-04-18 14:39:02','菜单组'),('0ec2498a-424a-4f48-bb73-c0530da38879','用户角色查询','','2018-04-18 14:47:57','role','role:urr',14,'2018-04-18 15:14:15','角色组'),('0f285d81-04d9-4246-a3f7-67d679316c66','菜单删除','','2018-04-18 12:54:28','menu','menu:md',9,'2018-04-18 13:00:26','菜单组'),('0f6edb63-9c8f-47e5-832b-c752f189b1f7','角色权限查询','','2018-04-18 14:41:24','permission','permission:rrolep',12,'2018-04-18 14:46:42','权限组'),('0f73fca7-6e14-483d-a5ec-ae09f1b84d72','角色详细查询','','2018-04-23 10:57:28','role','role:rv',18,'2018-04-25 09:15:58','角色组'),('0fdf7a3b-5593-40b6-ab41-4208a4b548cf','问题删除','','2018-04-22 10:53:24','problem','problem:md',16,'2018-04-22 12:50:28','问题组'),('1057cb41-1e98-4e2f-a420-162b964e0fd3','角色详细查询','','2018-04-18 14:46:42','role','role:rv',13,'2018-04-18 14:47:57','角色组'),('10800a44-f4c3-474f-81a2-718c4fb82cc1','角色权限查询','','2018-04-18 15:14:15','permission','permission:rrolep',15,'2018-04-22 10:53:24','权限组'),('11c1a0f7-079c-4fdd-857b-83df1999f6c2','角色查询','','2018-04-09 08:42:04','role','role:rr',6,'2018-04-09 09:57:14','角色组'),('12159870-a42a-40fb-9cb1-1f7158526002','问题类型查询','','2018-04-23 10:57:28','type','type:mr',18,'2018-04-25 09:15:58','类型组'),('1216db95-790e-4b41-9822-74f904c70109','配置查看','','2018-04-22 10:53:24','config','config:mr',16,'2018-04-22 12:50:28','配置组'),('12a994c2-f752-4f39-95fd-fdd1c87b1a3b','普通用户编辑','','2018-04-22 10:53:24','generalUser','generalUser:me',16,'2018-04-22 12:50:28','普通用户组'),('1320fc7e-4474-4037-8f27-b5f7232b5e5c','自评问件查看','','2018-04-23 10:57:28','rater','rater:mr',18,'2018-04-25 09:15:58','自评文件组'),('13d1367d-4988-45d3-9685-9a683a937bd8','角色查询','','2018-04-18 12:47:25','role','role:rr',8,'2018-04-18 12:54:28','角色组'),('142b1510-eae5-4ad8-b79c-4c45f0cbca1d','父菜单添加','','2018-04-08 12:21:55','menu','menu:pc',5,'2018-04-09 08:42:04',''),('143c86c1-540e-49e2-b9e4-ba65a9ec42fa','用户更新','','2018-04-23 10:57:28','user','user:uu',18,'2018-04-25 09:15:58','用户组'),('14685841-490b-4827-8716-86e1aa550db9','日志查看','','2018-04-23 10:57:28','log','log:mr',18,'2018-04-25 09:15:58','日志组'),('149a159c-db6c-4876-bede-41f68118c26e','所有权限查询','','2018-04-08 12:21:55','permission','permission:apr',5,'2018-04-09 08:42:04','权限组'),('149c5848-6e30-4780-b6a2-9b4590f5f24c','菜单更新','','2018-04-18 14:47:57','menu','menu:mu',14,'2018-04-18 15:14:15','菜单组'),('156ef7c3-d344-4e86-8643-106c8300765c','配置查看','','2018-04-22 12:50:29','config','config:mr',17,'2018-04-23 10:57:27','配置组'),('1579fe53-3123-4b6e-97d3-e50e14b99ecf','普通用户查看','','2018-04-22 12:50:29','generalUser','generalUser:mr',17,'2018-04-23 10:57:27','普通用户组'),('157a25ab-2fc4-4aa3-b8f8-869272a17c1d','评审用户详细','','2018-04-25 09:15:58','frontUser','raterUser:md',19,'2018-04-25 09:16:27','评审用户组'),('1580bbc7-f3c1-42d7-9e12-a24f202a33f3','问题类型查询','','2018-04-25 09:15:58','type','type:mr',19,'2018-04-25 09:16:27','类型组'),('19b83167-fa21-4ac6-ad95-1f18a4a21599','角色权限查询','','2018-04-22 10:53:24','role','role:rpr',16,'2018-04-22 12:50:28','角色组'),('19c41774-1a85-49cc-b159-539d479eade6','角色权限查询','','2018-04-25 09:15:58','role','role:rpr',19,'2018-04-25 09:16:27','角色组'),('1a03ca99-ee1a-41c8-b072-3332cc9eb72c','UI查询','','2018-04-18 15:14:15','ui','ui:ur',15,'2018-04-22 10:53:24','UI组'),('1a03dfc1-78d3-436d-abc6-790646a3f474','角色详细查询','','2018-04-25 09:15:58','role','role:rv',19,'2018-04-25 09:16:27','角色组'),('1a27b0e7-56c6-4949-a6c3-30f5208b63aa','用户详细','','2018-04-23 10:57:28','user','user:ud',18,'2018-04-25 09:15:58','用户组'),('1b2a8ec9-5e6d-4072-90d8-b166b08f4fd7','角色添加','','2018-04-18 14:47:57','role','role:ra',14,'2018-04-18 15:14:15','角色组'),('1b9e148d-1ed2-4f8d-94a7-73fb2830b2ef','用户角色更新','','2018-04-22 12:50:29','user','user:uru',17,'2018-04-23 10:57:27','用户组'),('1beefac9-faf8-41c8-9e6d-e31e63b61dee','角色删除','','2018-04-18 15:14:15','role','role:rd',15,'2018-04-22 10:53:24','角色组'),('1bf6530b-aee8-4c61-adad-fd27e3172923','用户查询','','2018-04-18 12:47:25','user','user:ur',8,'2018-04-18 12:54:28','用户组'),('1c9d698e-763e-4aa0-9abc-ddc18b4981d1','问题类型查询','','2018-04-22 10:53:24','type','type:mr',16,'2018-04-22 12:50:28','类型组'),('1d17a7ac-5200-449f-9a60-3c584cd7e9c3','用户角色查询','','2018-04-18 14:46:42','role','role:urr',13,'2018-04-18 14:47:57','角色组'),('1d3cf5a0-28e2-4003-af11-7ceac3c683af','审查要素查看','','2018-04-23 10:57:28','supportFile','element:fr',18,'2018-04-25 09:15:58','审查要素管理组'),('1d56a5f9-266d-4d65-9e39-1ab0eec1132c','普通用户删除','','2018-04-22 10:53:24','generalUser','generalUser:md',16,'2018-04-22 12:50:28','普通用户组'),('1d8e2eab-a2cb-4e24-8b97-09630f894a54','普通用户删除','','2018-04-18 12:54:28','generalUser','generalUser:md',9,'2018-04-18 13:00:26','普通用户组'),('1d95a78d-98d7-44a8-a3b7-111de306ea39','角色删除','','2018-04-22 10:53:24','role','role:rd',16,'2018-04-22 12:50:28','角色组'),('1e317d79-92f8-48f8-9416-79afd68a309f','全部子菜单查询','','2018-04-18 15:14:15','menu','menu:acmr',15,'2018-04-22 10:53:24','菜单组'),('1e35508a-d718-48b1-b9de-d37476dd900d','问题添加','','2018-04-23 10:57:28','problem','problem:mc',18,'2018-04-25 09:15:58','问题组'),('1e5ad461-0b57-428e-8b0f-6b115d717673','独立菜单查询','','2018-04-18 13:00:26','menu','menu:amr',10,'2018-04-18 14:39:02','菜单组'),('1f5912a3-52fb-45fc-9949-00ef3a3da47f','用户角色更新','','2018-04-18 14:46:42','user','user:uru',13,'2018-04-18 14:47:57','用户组'),('1fa4b67b-2e17-4aa3-bd38-f34935cef541','独立菜单查询','','2018-04-18 14:41:24','menu','menu:amr',12,'2018-04-18 14:46:42','菜单组'),('1fb16a0d-a27e-4d6f-954c-c577fb73dd75','用户查询','','2018-04-25 09:15:58','user','user:ur',19,'2018-04-25 09:16:27','用户组'),('1fc9c64d-2f3e-4a57-8faa-843799ada733','部门查看','','2018-04-22 10:53:24','department','department:mr',16,'2018-04-22 12:50:28','部门组'),('204742e7-a679-4ec3-9549-b7538c2966ba','用户角色更新','','2018-04-18 12:47:25','user','user:uru',8,'2018-04-18 12:54:28','用户组'),('20caaf12-7e5a-4165-8d9f-1bf52b92e8b3','审核项目删除','','2018-04-23 10:57:28','supportFile','project:fd',18,'2018-04-25 09:15:58','审核项目管理组'),('2181d140-d27a-413c-92ea-a75903d4c500','UI查询','','2018-04-22 10:53:24','ui','ui:ur',16,'2018-04-22 12:50:28','UI组'),('21ccc802-b81d-4e94-b9cc-dd5b25b321e0','评审用户查看','','2018-04-22 12:50:29','frontUser','raterUser:mr',17,'2018-04-23 10:57:27','评审用户组'),('2225fc99-7d8e-40bc-9247-f47e8752ef88','用户查询','','2018-04-18 15:14:15','user','user:ur',15,'2018-04-22 10:53:24','用户组'),('231ba500-7b4d-48b9-9fea-bfeb59b17208','父菜单添加','','2018-04-22 10:53:24','menu','menu:pc',16,'2018-04-22 12:50:28','菜单组'),('2367a8ca-2e29-43c9-bd5a-2b35452f2760','普通用户添加','','2018-04-18 14:46:42','generalUser','generalUser:mc',13,'2018-04-18 14:47:57','普通用户组'),('23dae94e-719e-491f-bf52-d1497664c8ea','角色查询','','2018-04-09 09:57:14','role','role:rr',7,'2018-04-18 12:47:25','角色组'),('240a4483-6f53-4cb8-855b-9dda305a46b8','角色删除','','2018-04-18 13:00:26','role','role:rd',10,'2018-04-18 14:39:02','角色组'),('2459b740-18a8-4569-9a1e-a9f6bb14f9a2','问题删除','','2018-04-22 12:50:29','problem','problem:md',17,'2018-04-23 10:57:27','问题组'),('2459cc84-f5a2-47a6-86a8-0869027ad8d6','用户添加','','2018-04-18 12:54:28','user','user:ua',9,'2018-04-18 13:00:26','用户组'),('256477c5-df21-4fa0-8824-1fb0348c14e4','独立菜单查询','','2018-04-08 12:21:55','menu','menu:amr',5,'2018-04-09 08:42:04','菜单组'),('25a1c240-89ba-4f5c-a64c-74ca7bbce530','审查要点添加','','2018-04-23 10:57:28','supportFile','point:fc',18,'2018-04-25 09:15:58','审查要点管理组'),('25a2b635-35ad-47b7-9a06-803fe85b0c59','UI更新','','2018-04-18 15:14:15','ui','ui:',15,'2018-04-22 10:53:24','UI组'),('25bbeeb8-3898-48f1-8fdf-282994f2b9e3','牵头部门添加','','2018-04-25 09:15:58','supportFile','leadDepartment:fc',19,'2018-04-25 09:16:27','牵头部门管理组'),('25cb7bfe-52f0-45a2-91d1-4958ee2f3380','问题类型查询','','2018-04-25 09:15:58','type','type:mr',19,'2018-04-25 09:16:27','类型组'),('26a89b9a-11be-45ef-864b-5ac0b434d075','独立菜单查询','','2018-04-18 15:14:15','menu','menu:amr',15,'2018-04-22 10:53:24','菜单组'),('26e9f1bd-2a5c-47c1-a1a8-680e798fc23a','普通用户编辑','','2018-04-18 14:39:02','generalUser','generalUser:me',11,'2018-04-18 14:41:24','普通用户组'),('27497b05-72d7-4325-b229-57d5228feb41','UI查询','','2018-04-25 09:15:58','ui','ui:ur',19,'2018-04-25 09:16:27','UI组'),('27542fa9-f2e4-4d4f-b858-458183484d0e','菜单删除','','2018-04-18 13:00:26','menu','menu:md',10,'2018-04-18 14:39:02','菜单组'),('27ddfe11-29de-4121-bd03-93d492db3687','部门添加','','2018-04-22 10:53:24','department','department:mc',16,'2018-04-22 12:50:28','部门组'),('291d3336-b710-4c94-8c50-1ea147b6e19d','问题编辑','','2018-04-25 09:15:58','problem','problem:mu',19,'2018-04-25 09:16:27','问题组'),('29dc08de-b727-45ce-86fc-7e179a1707ed','用户角色更新','','2018-04-18 14:41:24','user','user:uru',12,'2018-04-18 14:46:42','用户组'),('2a005489-a838-4d46-9af1-2fa79756d8ca','角色权限查询','','2018-04-18 14:46:42','permission','permission:rrolep',13,'2018-04-18 14:47:57','权限组'),('2a12192d-d8f8-4304-9eb8-69b9d86a48b7','普通用户详细','','2018-04-18 14:46:42','generalUser','generalUser:md',13,'2018-04-18 14:47:57','普通用户组'),('2a18ad44-030b-4565-aa6e-03194ec0c40a','用户角色查询','','2018-04-18 14:41:24','role','role:urr',12,'2018-04-18 14:46:42','角色组'),('2a3c38e5-f163-43db-bbf1-4519a76d1ecf','审查要点删除','','2018-04-23 10:57:28','supportFile','point:fd',18,'2018-04-25 09:15:58','审查要点管理组'),('2a49e973-1df3-4f45-8ec6-976f1b3bd361','审核要点详细','','2018-04-25 09:15:58','supportFile','point:fd',19,'2018-04-25 09:16:27','审核要点管理组'),('2ab2859d-f50e-4483-b780-404ff64f1071','普通用户编辑','','2018-04-18 13:00:26','generalUser','generalUser:me',10,'2018-04-18 14:39:02','普通用户组'),('2ae5c264-3452-40f5-9e7d-0ab17123dc2d','普通用户添加','','2018-04-18 14:47:57','generalUser','generalUser:mc',14,'2018-04-18 15:14:15','普通用户组'),('2b5301be-b767-4ab9-a03f-4dfb2cd27bcf','问题删除','','2018-04-23 10:57:28','problem','problem:md',18,'2018-04-25 09:15:58','问题组'),('2ba1479a-a1de-4766-ab04-d82ee6283cd2','责任部门详细','','2018-04-25 09:15:58','supportFile','dutyDepartment:fd',19,'2018-04-25 09:16:27','责任部门管理组'),('2c51daed-8085-47ac-b524-b3869a4208ae','UI查询','','2018-04-22 12:50:29','ui','ui:ur',17,'2018-04-23 10:57:27','UI组'),('2c8ae370-02e2-4116-ba91-467fb56a6cd3','问题类型详细','','2018-04-22 10:53:24','type','type:mr',16,'2018-04-22 12:50:28','类型组'),('2ca4d2f9-d00b-4535-a32a-4c78de4a4001','用户更新','','2018-04-22 12:50:29','user','user:uu',17,'2018-04-23 10:57:27','用户组'),('2d124321-5aa2-453e-9a78-ab5d47bc7844','角色添加','','2018-04-09 09:57:14','role','role:ra',7,'2018-04-18 12:47:25','角色组'),('2d6b800b-7d79-405a-a388-934e62764a8c','部门详细','','2018-04-22 10:53:24','department','department:mr',16,'2018-04-22 12:50:28','部门组'),('2d6edbaf-09e6-4203-a1a0-c2fba003e4f4','分数编辑','','2018-04-22 10:53:24','score','score:mu',16,'2018-04-22 12:50:28','分数组'),('2d701831-1928-46ca-a2ea-a16d89bbeb9d','角色菜单查询','','2018-04-18 14:39:02','role','role:rmr',11,'2018-04-18 14:41:24','菜单组'),('2d8fe6bb-8406-431c-a5c8-dada59ee0ad6','菜单编辑查询','','2018-04-18 14:46:42','menu','menu:mer',13,'2018-04-18 14:47:57','菜单组'),('2df1342d-a04e-4d0b-90b5-87ea411a1ef6','全部子菜单查询','','2018-04-09 08:42:04','menu','menu:acmr',6,'2018-04-09 09:57:14','菜单组'),('2e4b7097-b2b6-4380-9f3a-f99e56260ac2','用户角色查询','','2018-04-02 08:43:52','role','role:ruserr',2,'2018-04-02 08:49:21',''),('2e6804f0-122f-4b76-8a7b-fa18fb684df2','UI更新','','2018-04-18 14:41:24','ui','ui:',12,'2018-04-18 14:46:42','UI组'),('2e825bc7-f76c-4a1f-b438-d5113fde5da3','用户更新','','2018-04-22 10:53:24','user','user:uu',16,'2018-04-22 12:50:28','用户组'),('2f4fba13-207c-4bae-91e9-b713fa6685ae','菜单更新','','2018-04-22 10:53:24','menu','menu:mu',16,'2018-04-22 12:50:28','菜单组'),('30871a0a-06b5-4d5d-8733-26c9fc046114','普通用户编辑','','2018-04-18 12:54:28','generalUser','generalUser:me',9,'2018-04-18 13:00:26','普通用户组'),('30bd47f1-a6b7-4f74-8453-3f94c0ebf156','问题类型查看','','2018-04-23 10:57:28','type','type:mu',18,'2018-04-25 09:15:58','类型组'),('30bf8637-5d7f-4993-9bec-d7b993a26520','菜单编辑查询','','2018-04-08 12:21:55','menu','menu:mer',5,'2018-04-09 08:42:04','菜单组'),('30d2fd76-db50-4508-8264-9309b1dfcb16','菜单删除','','2018-04-22 12:50:29','menu','menu:md',17,'2018-04-23 10:57:27','菜单组'),('30dadb99-a51f-47ea-8450-ef961dc9641e','审核项目删除','','2018-04-25 09:15:58','supportFile','project:fd',19,'2018-04-25 09:16:27','审核项目管理组'),('314493ed-c7b9-4073-9b4f-978429b01bb4','用户删除','','2018-04-18 12:54:28','user','user:ud',9,'2018-04-18 13:00:26','用户组'),('31463df8-f996-4e04-bf00-96e268e6d337','角色添加','','2018-04-18 14:46:42','role','role:ra',13,'2018-04-18 14:47:57','角色组'),('315b6b28-0c4a-483f-9549-385bf20b9d11','问题类型查看','','2018-04-23 10:57:28','type','type:mr',18,'2018-04-25 09:15:58','类型组'),('319f45ac-5847-487f-aa4d-5ab1f07ae586','普通用户删除','','2018-04-23 10:57:28','generalUser','generalUser:md',18,'2018-04-25 09:15:58','普通用户组'),('31ca8e20-91de-4d28-bdd4-f48742eb0558','问题查看','','2018-04-23 10:57:28','problem','problem:mr',18,'2018-04-25 09:15:58','问题组'),('31e9c22f-5515-47c5-be5c-18b029a38118','用户角色查询','','2018-04-23 10:57:28','role','role:urr',18,'2018-04-25 09:15:58','角色组'),('32aa7fdd-9b0f-40f0-965f-fc11977a242e','角色添加','','2018-04-18 13:00:26','role','role:ra',10,'2018-04-18 14:39:02','角色组'),('3373d772-37a6-4941-a10a-81cb21cc9540','普通用户详细','','2018-04-18 14:47:57','generalUser','generalUser:md',14,'2018-04-18 15:14:15','普通用户组'),('3383e10e-fa72-41b0-8b85-017bd5939c6c','角色权限查询','','2018-04-18 12:54:28','permission','permission:rrolep',9,'2018-04-18 13:00:26','权限组'),('33f6b6d3-604f-439b-904d-8afb3151f017','菜单编辑查询','','2018-04-09 09:57:14','menu','menu:mer',7,'2018-04-18 12:47:25','菜单组'),('345bb7de-654b-46b8-ac7e-c14890c740bf','用户更新','','2018-04-18 14:47:57','user','user:uu',14,'2018-04-18 15:14:15','用户组'),('354c329e-bbf5-4eb2-b6fd-8e88dec445d8','用户详细','','2018-04-25 09:15:58','user','user:ud',19,'2018-04-25 09:16:27','用户组'),('3626002d-94bf-470e-8442-a0fb8173f0df','角色权限查询','','2018-04-09 08:42:04','permission','permission:rrolep',6,'2018-04-09 09:57:14','权限组'),('36afc11c-4c9b-4e6a-a62e-5d34ae9df5b9','分数详细','','2018-04-23 10:57:28','score','score:mr',18,'2018-04-25 09:15:58','分数组'),('36f06bc4-1864-43e9-afac-61b163f561dd','角色权限查询','','2018-04-02 08:49:21','permission','permission:rrolep',3,'2018-04-02 12:47:29',''),('36f5d205-0579-4e66-b9fb-71eace4fd049','角色菜单查询','','2018-04-22 12:50:29','role','role:rmr',17,'2018-04-23 10:57:27','菜单组'),('379ce162-1fc0-4a87-bdc0-b76bb8ab8f1c','UI查询','','2018-04-18 12:54:28','ui','ui:ur',9,'2018-04-18 13:00:26','UI组'),('37cb0371-9ccb-408e-bb4f-67cef74ed79e','角色添加','','2018-04-09 08:42:04','role','role:ra',6,'2018-04-09 09:57:14','角色组'),('37fcee8b-4983-4734-a9ee-c9bbd66240d1','问题类型查询','','2018-04-22 10:53:24','type','type:mr',16,'2018-04-22 12:50:28','类型组'),('394b826a-fcb5-42be-977c-376673b72424','审核项目详细','','2018-04-25 09:15:58','supportFile','project:fd',19,'2018-04-25 09:16:27','审核项目管理组'),('397f2073-12d4-457a-a65b-af6f1b889065','部门编辑','','2018-04-22 12:50:29','department','department:mu',17,'2018-04-23 10:57:27','部门组'),('39a4881a-e52d-4ed4-b36b-3803c32adb03','普通用户删除','','2018-04-22 12:50:29','generalUser','generalUser:md',17,'2018-04-23 10:57:27','普通用户组'),('39d2fe2a-e2b4-42ff-a32c-149b18104094','审查要点添加','','2018-04-25 09:15:58','supportFile','point:fc',19,'2018-04-25 09:16:27','审查要点管理组'),('39e154fe-91eb-4dd7-a138-26614764617e','全部子菜单查询','','2018-04-08 12:21:55','menu','menu:acmr',5,'2018-04-09 08:42:04','菜单组'),('39ecff18-f84b-48e7-a5d0-5e313f88f61c','审核项目添加','','2018-04-25 09:15:58','supportFile','project:fc',19,'2018-04-25 09:16:27','审核项目管理组'),('3a8d185d-74ab-4a23-ae9c-a3d9c5a5d44a','审责任部门添加','','2018-04-23 10:57:28','supportFile','dutyDepartment:fc',18,'2018-04-25 09:15:58','责任部门管理组'),('3a97efc6-92ec-4a6f-97c9-d4d458a53a64','用户详细','','2018-04-18 14:46:42','user','user:ud',13,'2018-04-18 14:47:57','用户组'),('3af31aba-9391-423b-9493-0840292d0cc4','用户查询','','2018-04-18 14:39:02','user','user:ur',11,'2018-04-18 14:41:24','用户组'),('3bab4e87-a4e3-4c30-8a10-c29cb46f58c8','用户角色更新','','2018-04-22 10:53:24','user','user:uru',16,'2018-04-22 12:50:28','用户组'),('3bb3cefd-3eb5-46c0-ab7e-f77e7c331e03','普通用户编辑','','2018-04-18 12:54:28','generalUser','generalUser:me',9,'2018-04-18 13:00:26','普通用户组'),('3bcf9a1a-95f5-4741-b09e-73e0be610cb3','普通用户编辑','','2018-04-23 10:57:28','generalUser','generalUser:me',18,'2018-04-25 09:15:58','普通用户组'),('3c2ebf90-bbd8-4923-b5ba-14e145ea9518','菜单编辑查询','','2018-04-09 08:42:04','menu','menu:mer',6,'2018-04-09 09:57:14','菜单组'),('3c6c6f1f-e66d-4b5b-b441-7a8b39616021','用户角色查询','','2018-04-18 12:47:25','role','role:urr',8,'2018-04-18 12:54:28','角色组'),('3cae548b-83c4-4f5a-a11f-59b1d200315f','角色权限查询','','2018-04-02 08:43:52','permission','permission:rrolep',2,'2018-04-02 08:49:21',''),('3d0d4b25-77ce-4028-96f8-5ba89205d537','菜单查询','','2018-04-08 12:21:55','menu','menu:r',5,'2018-04-09 08:42:04','菜单组'),('3d691f49-7785-48d3-9b4a-20d41f5b79b6','部门删除','','2018-04-22 10:53:24','department','department:md',16,'2018-04-22 12:50:28','部门组'),('3da7ecff-c82e-4adf-a9c0-999e9882cc47','用户角色查询','','2018-04-02 08:49:21','role','role:ruserr',3,'2018-04-02 12:47:29',''),('3e7fd374-d27b-470a-b2f8-98f8fc4e26e0','UI查询','','2018-04-18 14:41:24','ui','ui:ur',12,'2018-04-18 14:46:42','UI组'),('3ed0f892-ba20-4c0e-966b-1dbe603b1c3d','评审用户查看','','2018-04-23 10:57:28','frontUser','raterUser:mr',18,'2018-04-25 09:15:58','评审用户组'),('3fd1fef7-cb43-451e-a154-2648fc9610b7','菜单删除','','2018-04-08 12:21:55','menu','menu:md',5,'2018-04-09 08:42:04','菜单组'),('4166f58e-f819-4ca1-9fe0-0d453ea67c9b','UI查询','','2018-04-18 14:46:42','ui','ui:ur',13,'2018-04-18 14:47:57','UI组'),('4183cea3-c6eb-4c06-9f09-927c51cd5d1b','父菜单添加','','2018-04-23 10:57:28','menu','menu:pc',18,'2018-04-25 09:15:58','菜单组'),('41ef7dc8-dd84-448d-9a49-813a8a5f6b5d','用户角色查询','','2018-04-02 12:47:29','role','role:ruserr',4,'2018-04-08 12:21:55',''),('41fdd165-f91f-4b85-b3a4-092c7590b4d0','用户角色查询','','2018-04-09 08:42:04','role','role:urr',6,'2018-04-09 09:57:14','角色组'),('42246b46-e2b9-48e8-ad19-fc3767801314','部门详细','','2018-04-23 10:57:28','department','department:mr',18,'2018-04-25 09:15:58','部门组'),('44773bbb-1b6d-45c1-97b6-3df0071b4e55','菜单编辑查询','','2018-04-22 12:50:29','menu','menu:mer',17,'2018-04-23 10:57:27','菜单组'),('448ef905-fc9c-47a2-9600-59e21729f771','用户查询','','2018-04-18 14:46:42','user','user:ur',13,'2018-04-18 14:47:57','用户组'),('46229524-aea3-417d-9a16-4060485e2b42','分数详细','','2018-04-22 12:50:29','score','score:mr',17,'2018-04-23 10:57:27','分数组'),('464a4d7b-c4e4-4faa-a14f-3592e9cf32ad','角色查询','','2018-04-18 12:54:28','role','role:rr',9,'2018-04-18 13:00:26','角色组'),('46ca8471-e449-43a6-851d-05741ac3c30e','用户删除','','2018-04-18 14:47:57','user','user:ud',14,'2018-04-18 15:14:15','用户组'),('470ad70c-cd46-465e-a121-e00ce08e168b','普通用户详细','','2018-04-18 12:54:28','generalUser','generalUser:md',9,'2018-04-18 13:00:26','普通用户组'),('47ed9521-f35b-4870-91c8-4611ceb7566b','菜单编辑查询','','2018-04-22 10:53:24','menu','menu:mer',16,'2018-04-22 12:50:28','菜单组'),('48159119-5523-432d-8066-1821a41a2388','角色菜单查询','','2018-04-18 15:14:15','role','role:rmr',15,'2018-04-22 10:53:24','菜单组'),('48522e0b-a138-46d4-9960-372bcbe8f074','普通用户详细','','2018-04-18 14:39:02','generalUser','generalUser:md',11,'2018-04-18 14:41:24','普通用户组'),('49449969-4b3b-45f2-94b6-1c0d3a459707','审责任部门删除','','2018-04-25 09:15:58','supportFile','dutyDepartment:fd',19,'2018-04-25 09:16:27','责任部门管理组'),('494e8f70-b922-4aa3-9ef9-0310ccd6d712','菜单查询','','2018-04-25 09:15:58','menu','menu:r',19,'2018-04-25 09:16:27','菜单组'),('4a21dfdb-d9bd-4341-98fd-78ac425d0a76','角色添加','','2018-04-18 14:39:02','role','role:ra',11,'2018-04-18 14:41:24','角色组'),('4a4c9bc7-7e7f-4ed9-9fa1-b3ab79975111','部门查看','','2018-04-23 10:57:28','department','department:mr',18,'2018-04-25 09:15:58','部门组'),('4ad01ebf-bbcf-43f3-a8ac-1fbfdf11fee3','普通用户编辑','','2018-04-18 14:47:57','generalUser','generalUser:me',14,'2018-04-18 15:14:15','普通用户组'),('4c0e7bdb-f1e9-4da3-b86a-58a4a5d83373','全部子菜单查询','','2018-04-18 14:39:02','menu','menu:acmr',11,'2018-04-18 14:41:24','菜单组'),('4cdf4c61-3476-418f-810e-94b8c756e9c1','角色权限查询','','2018-04-18 15:14:15','role','role:rpr',15,'2018-04-22 10:53:24','角色组'),('4d4c977b-053f-499f-a439-90c8b28ec1e7','用户删除','','2018-04-18 12:47:25','user','user:ud',8,'2018-04-18 12:54:28','用户组'),('4e258486-6292-46f0-87aa-c2e6fb706b6c','用户角色查询','','2018-04-02 08:31:14','role','role:ruserr',0,'2018-04-02 08:43:52',''),('4e35d350-fb20-4fb2-b7bb-52985fa57fbb','用户删除','','2018-04-18 14:41:24','user','user:ud',12,'2018-04-18 14:46:42','用户组'),('4e6f9cbf-a4e6-4329-82e6-2fd9b676039e','用户角色更新','','2018-04-18 14:47:57','user','user:uru',14,'2018-04-18 15:14:15','用户组'),('5079340d-5dcd-4b52-9466-c3a1a82a6434','审核项目编辑','','2018-04-23 10:57:28','supportFile','project:fe',18,'2018-04-25 09:15:58','审核项目管理组'),('50e45d33-f102-49c3-96c4-93c7c2584c85','菜单更新','','2018-04-25 09:15:58','menu','menu:mu',19,'2018-04-25 09:16:27','菜单组'),('5237cee7-6717-4052-8b8f-3653594f1c8b','普通用户详细','','2018-04-18 14:47:57','generalUser','generalUser:md',14,'2018-04-18 15:14:15','普通用户组'),('5389f42a-2090-44bb-8844-b53a4f4ec20f','普通用户删除','','2018-04-18 14:46:42','generalUser','generalUser:md',13,'2018-04-18 14:47:57','普通用户组'),('53c22c5b-0b7b-40be-a6dc-65e545947731','父菜单添加','','2018-04-22 12:50:29','menu','menu:pc',17,'2018-04-23 10:57:27','菜单组'),('53d4d834-3405-49f7-9653-424f04b01200','分数编辑','','2018-04-25 09:15:58','score','score:mu',19,'2018-04-25 09:16:27','分数组'),('53df0245-854a-44c6-9349-0e91d4cc423d','支撑问件查看','','2018-04-22 12:50:29','support','support:mr',17,'2018-04-23 10:57:27','支撑文件组'),('540a6ad0-bb1b-4887-9e53-82a69648cdc5','父菜单添加','','2018-04-25 09:15:58','menu','menu:pc',19,'2018-04-25 09:16:27','菜单组'),('547ea0d5-2ae0-4b0d-9e2b-57bbc1679c7b','角色编辑','','2018-04-23 10:57:28','role','role:ru',18,'2018-04-25 09:15:58','角色组'),('548e1240-56ed-4255-88bd-b40618698323','用户查询','','2018-04-18 14:41:24','user','user:ur',12,'2018-04-18 14:46:42','用户组'),('54aec8b4-0fd2-4680-8c2f-66282b4c8551','角色权限查询','','2018-04-22 10:53:24','permission','permission:rrolep',16,'2018-04-22 12:50:28','权限组'),('54c31818-cfbc-4e79-8912-0f56c8261787','分数删除','','2018-04-22 10:53:24','score','score:md',16,'2018-04-22 12:50:28','分数组'),('54ccb209-ff8b-4e74-9514-19b2fa169736','部门删除','','2018-04-25 09:15:58','department','department:md',19,'2018-04-25 09:16:27','部门组'),('54f51dcb-4056-44cc-84a7-0a2ff5eb4fbc','问题类型查看','','2018-04-22 12:50:29','type','type:mr',17,'2018-04-23 10:57:27','类型组'),('5527dcd7-a544-4a5b-999a-f8b6de105afc','用户详细','','2018-04-18 14:47:57','user','user:ud',14,'2018-04-18 15:14:15','用户组'),('552aab88-04a2-4eed-be66-5c5bfd24eed9','普通用户详细','','2018-04-18 15:14:15','generalUser','generalUser:md',15,'2018-04-22 10:53:24','普通用户组'),('56969bef-51ef-49b9-b274-16efb6ee4326','用户详细','','2018-04-18 12:47:25','user','user:ud',8,'2018-04-18 12:54:28','用户组'),('56df1fa3-2ad8-4fdc-a3ef-a3a3de136ef0','UI更新','','2018-04-18 12:47:25','ui','ui:',8,'2018-04-18 12:54:28','UI组'),('572ff480-7338-4311-9a91-148d38441e11','角色菜单查询','','2018-04-18 14:46:42','role','role:rmr',13,'2018-04-18 14:47:57','菜单组'),('577a755a-f1db-4f64-96a8-fdc752c40c6d','日志查看','','2018-04-25 09:15:58','log','log:mr',19,'2018-04-25 09:16:27','日志组'),('58b54a6f-f5b4-4f5f-8124-efb7c4aa3340','分数添加','','2018-04-25 09:15:58','score','score:mc',19,'2018-04-25 09:16:27','分数组'),('592064d9-7f82-4e66-8469-7bc11bbbbb18','问题类型删除','','2018-04-22 10:53:24','type','type:md',16,'2018-04-22 12:50:28','类型组'),('5952239b-4480-4acf-8524-c5f3e83ea7f3','独立菜单查询','','2018-04-25 09:15:58','menu','menu:amr',19,'2018-04-25 09:16:27','菜单组'),('5a0fbd22-c702-44ec-9d1f-b1457b71e8ff','问题类型添加','','2018-04-22 12:50:29','type','type:mc',17,'2018-04-23 10:57:27','类型组'),('5a2f7527-ccf4-466e-959f-5c2809fc68ef','父菜单添加','','2018-04-18 15:14:15','menu','menu:pc',15,'2018-04-22 10:53:24','菜单组'),('5a8f8c74-8e98-42ab-9deb-cc9f963b0ec4','UI查询','','2018-04-18 13:00:26','ui','ui:ur',10,'2018-04-18 14:39:02','UI组'),('5b247f0e-04cd-4be2-a842-694e89ccc278','评审用户查看','','2018-04-25 09:15:58','frontUser','raterUser:mr',19,'2018-04-25 09:16:27','评审用户组'),('5b4e7851-6f3d-4137-996f-f09ac9018c2c','部门删除','','2018-04-23 10:57:28','department','department:md',18,'2018-04-25 09:15:58','部门组'),('5b7c9a79-cfff-4a6c-be21-8d82e1be4d36','普通用户详细','','2018-04-18 13:00:26','generalUser','generalUser:md',10,'2018-04-18 14:39:02','普通用户组'),('5bda37b5-a128-4269-b6a5-83a723446c1f','普通用户编辑','','2018-04-18 13:00:26','generalUser','generalUser:me',10,'2018-04-18 14:39:02','普通用户组'),('5e0ff503-6d3f-4b9e-a9b0-5e29b6e5b668','菜单更新','','2018-04-09 08:42:04','menu','menu:mu',6,'2018-04-09 09:57:14','菜单组'),('5e45590c-a1d5-4d8e-993a-ea4422816a15','角色查询','','2018-04-18 13:00:26','role','role:rr',10,'2018-04-18 14:39:02','角色组'),('5e4dbcd9-312f-4f85-9d44-88ca73cb82d8','审查要点编辑','','2018-04-23 10:57:28','supportFile','point:fe',18,'2018-04-25 09:15:58','审查要点管理组'),('5e89f0b4-1679-417a-8410-f34d0c6ac2ab','部门详细','','2018-04-25 09:15:58','department','department:mr',19,'2018-04-25 09:16:27','部门组'),('5e9cf608-287c-4880-abd6-d5d745d797a3','角色编辑','','2018-04-25 09:15:58','role','role:ru',19,'2018-04-25 09:16:27','角色组'),('5ed96e7f-c9d7-4201-bdb3-960cc9301d2c','普通用户添加','','2018-04-18 12:54:28','generalUser','generalUser:mc',9,'2018-04-18 13:00:26','普通用户组'),('5f3ed7b6-1f2e-40fe-a734-6e98ab20e192','配置编辑','','2018-04-25 09:15:58','config','config:mr',19,'2018-04-25 09:16:27','配置组'),('5fe748e9-2496-4913-b342-81acc36abd8f','普通用户编辑','','2018-04-18 14:39:02','generalUser','generalUser:me',11,'2018-04-18 14:41:24','普通用户组'),('6032c8da-bc6b-4021-9c6a-0717c9027123','评审用户编辑','','2018-04-25 09:15:58','frontUser','raterUser:me',19,'2018-04-25 09:16:27','评审用户组'),('6040ac2c-be47-490e-8a77-86bac28368ad','UI更新','','2018-04-18 13:00:26','ui','ui:',10,'2018-04-18 14:39:02','UI组'),('60c45922-7ef7-4bcf-9df4-02db9b9baf8b','问题类型详细','','2018-04-25 09:15:58','type','type:mr',19,'2018-04-25 09:16:27','类型组'),('60d38c27-7e8b-4531-bc78-abda11a2157d','父菜单添加','','2018-04-18 12:54:28','menu','menu:pc',9,'2018-04-18 13:00:26','菜单组'),('60f6be0e-82de-474c-b61b-2f08b25f70ba','审核要素详细','','2018-04-25 09:15:58','supportFile','element:fd',19,'2018-04-25 09:16:27','审核要素管理组'),('61d17a4d-ca9e-4001-bafa-7acf294e3f68','普通用户添加','','2018-04-25 09:15:58','generalUser','generalUser:mc',19,'2018-04-25 09:16:27','普通用户组'),('622be9ed-b4e3-4935-97c6-2bf5e2f79c06','角色添加','','2018-04-22 12:50:29','role','role:ra',17,'2018-04-23 10:57:27','角色组'),('62ef94c7-86cc-4d01-8a10-dab3bee8a534','用户添加','','2018-04-18 15:14:15','user','user:ua',15,'2018-04-22 10:53:24','用户组'),('6380a653-eba7-4de7-9e1c-1398dd6a4342','菜单删除','','2018-04-18 14:41:24','menu','menu:md',12,'2018-04-18 14:46:42','菜单组'),('63fbf617-c903-4dca-aa44-7b005221bc70','菜单查询','','2018-04-23 10:57:28','menu','menu:r',18,'2018-04-25 09:15:58','菜单组'),('643b13be-9357-4d64-b143-eb500a60bbc4','UI查询','','2018-04-18 14:47:57','ui','ui:ur',14,'2018-04-18 15:14:15','UI组'),('648d494c-22ac-4312-a3b4-1bd570b542e5','普通用户编辑','','2018-04-18 15:14:15','generalUser','generalUser:me',15,'2018-04-22 10:53:24','普通用户组'),('64df0685-9f9f-4912-8067-88a9c9615750','角色编辑','','2018-04-18 14:39:02','role','role:ru',11,'2018-04-18 14:41:24','角色组'),('65b444d3-26e6-45f6-80f3-3b2d5e4490ad','评审用户详细','','2018-04-22 10:53:24','frontUser','raterUser:md',16,'2018-04-22 12:50:28','评审用户组'),('65dd98eb-0276-4cfe-9b20-dc6ac0ce9b8a','菜单编辑查询','','2018-04-25 09:15:58','menu','menu:mer',19,'2018-04-25 09:16:27','菜单组'),('65fd599d-1335-443f-a300-3732b2a0ddd2','普通用户添加','','2018-04-18 14:41:24','generalUser','generalUser:mc',12,'2018-04-18 14:46:42','普通用户组'),('662a4970-ac08-4db0-bb1c-33b32a1f7736','问题类型详细','','2018-04-23 10:57:28','type','type:mr',18,'2018-04-25 09:15:58','类型组'),('6637ed67-12ee-4ebb-b846-051004cca752','用户添加','','2018-04-18 14:41:24','user','user:ua',12,'2018-04-18 14:46:42','用户组'),('664eec87-9837-4d40-90f3-a39b2543684d','部门详细','','2018-04-22 12:50:29','department','department:mr',17,'2018-04-23 10:57:27','部门组'),('67022deb-5d76-4022-9b32-46024f17d71b','普通用户查看','','2018-04-18 14:39:02','generalUser','generalUser:mr',11,'2018-04-18 14:41:24','普通用户组'),('674d09af-811c-4233-b763-db8593899d1c','角色菜单查询','','2018-04-22 10:53:24','role','role:rmr',16,'2018-04-22 12:50:28','菜单组'),('67641b5a-35cd-4288-a556-8edaad0b64e2','角色详细查询','','2018-04-18 14:39:02','role','role:rv',11,'2018-04-18 14:41:24','角色组'),('67824bd0-46f8-41ad-9d32-0565c8079d44','独立菜单查询','','2018-04-09 08:42:04','menu','menu:amr',6,'2018-04-09 09:57:14','菜单组'),('67fc010a-06e6-4089-a0f4-e58f3b28c93a','用户添加','','2018-04-18 13:00:26','user','user:ua',10,'2018-04-18 14:39:02','用户组'),('682d5bad-9e07-4444-9497-c4c893b0cd77','问题类型查询','','2018-04-22 12:50:29','type','type:mr',17,'2018-04-23 10:57:27','类型组'),('686310df-4ab7-4cef-be7d-e0a8edea32c3','分数详细','','2018-04-25 09:15:58','score','score:mr',19,'2018-04-25 09:16:27','分数组'),('68dac14e-d6bb-413e-8d71-842a1007d679','角色菜单查询','','2018-04-18 12:47:25','role','role:rmr',8,'2018-04-18 12:54:28','菜单组'),('691d46fa-22c1-45cd-b023-71debf1a4629','日志查看','','2018-04-22 10:53:24','log','log:mr',16,'2018-04-22 12:50:28','日志组'),('6968ead0-8ac9-472e-84ac-7129d0307866','评审用户编辑','','2018-04-23 10:57:28','frontUser','raterUser:me',18,'2018-04-25 09:15:58','评审用户组'),('69aea9ed-9a24-401e-bfae-40b5f7db084e','UI更新','','2018-04-18 14:39:02','ui','ui:',11,'2018-04-18 14:41:24','UI组'),('6a8054ae-2ecf-47a3-b27a-bb2ac1a12ab5','角色权限查询','','2018-04-18 14:47:57','permission','permission:rrolep',14,'2018-04-18 15:14:15','权限组'),('6b35e7e1-cb7d-48f9-af38-8098dcb4acd9','用户添加','','2018-04-18 14:47:57','user','user:ua',14,'2018-04-18 15:14:15','用户组'),('6bb923cf-3bb7-4cbb-afea-a63cc8fe2b0b','审查要素详细','','2018-04-23 10:57:28','supportFile','element:fd',18,'2018-04-25 09:15:58','审查要素管理组'),('6be4a228-8439-4028-9896-dfa68f4d1512','评审用户详细','','2018-04-22 12:50:29','frontUser','raterUser:md',17,'2018-04-23 10:57:27','评审用户组'),('6c107b86-7680-4963-a0c5-258800e11c00','普通用户添加','','2018-04-18 14:41:24','generalUser','generalUser:mc',12,'2018-04-18 14:46:42','普通用户组'),('6c25b280-e0d2-4ade-a320-c9893feeba1d','配置编辑','','2018-04-22 12:50:29','config','config:mr',17,'2018-04-23 10:57:27','配置组'),('6ced2ffe-0499-45d7-a477-96d6abdebe59','UI更新','','2018-04-23 10:57:28','ui','ui:',18,'2018-04-25 09:15:58','UI组'),('6da8ff50-628d-450e-8fc5-80f3c61a7501','问题查看','','2018-04-25 09:15:58','problem','problem:mr',19,'2018-04-25 09:16:27','问题组'),('6e65ee1c-f228-4015-86f5-5c79f9003dfe','普通用户编辑','','2018-04-18 14:47:57','generalUser','generalUser:me',14,'2018-04-18 15:14:15','普通用户组'),('6e692e5c-3914-41f4-b4db-a535ec9def3c','普通用户查看','','2018-04-18 14:46:42','generalUser','generalUser:mr',13,'2018-04-18 14:47:57','普通用户组'),('6ead7500-a1e7-44b6-be7a-073b6a893f22','部门添加','','2018-04-25 09:15:58','department','department:mc',19,'2018-04-25 09:16:27','部门组'),('6eed81e0-ba18-4ec2-bc9b-e737c6deeaaf','角色权限查询','','2018-04-22 12:50:29','permission','permission:rrolep',17,'2018-04-23 10:57:27','权限组'),('6f92d23c-19a7-409a-8c80-d971bbce226a','角色菜单查询','','2018-04-18 14:41:24','role','role:rmr',12,'2018-04-18 14:46:42','菜单组'),('6f9abdf6-13bd-4c48-a607-0578a6d25b5a','问题添加','','2018-04-25 09:15:58','problem','problem:mc',19,'2018-04-25 09:16:27','问题组'),('6ff1228e-62c2-4da3-ae93-e6734ba9438d','普通用户详细','','2018-04-25 09:15:58','generalUser','generalUser:md',19,'2018-04-25 09:16:27','普通用户组'),('70f08a59-b4df-4eda-bbbf-5f5ed369d8f5','问题编辑','','2018-04-22 10:53:24','problem','problem:mu',16,'2018-04-22 12:50:28','问题组'),('7252215a-f77b-4837-9b42-b309c61aebbc','普通用户查看','','2018-04-18 13:00:26','generalUser','generalUser:mr',10,'2018-04-18 14:39:02','普通用户组'),('72555ed0-f799-4d14-bae6-017d612f977f','角色添加','','2018-04-23 10:57:28','role','role:ra',18,'2018-04-25 09:15:58','角色组'),('725ba62f-8001-4f12-a23e-496899eb4196','角色权限查询','','2018-04-18 14:46:42','role','role:rpr',13,'2018-04-18 14:47:57','角色组'),('72ce9d67-534c-456d-9afa-4ca9b9e7f027','父菜单添加','','2018-04-09 08:42:04','menu','menu:pc',6,'2018-04-09 09:57:14','菜单组'),('72fbaa48-459d-4f3f-81b6-501bb60009a6','角色编辑','','2018-04-18 15:14:15','role','role:ru',15,'2018-04-22 10:53:24','角色组'),('73177e2b-fb1b-439b-9fa4-9c9d6ba7e686','菜单编辑查询','','2018-04-18 13:00:26','menu','menu:mer',10,'2018-04-18 14:39:02','菜单组'),('733886ff-aa1a-45ef-8946-9d59d7571c01','普通用户查看','','2018-04-22 10:53:24','generalUser','generalUser:mr',16,'2018-04-22 12:50:28','普通用户组'),('73951661-8379-42eb-b9df-9a05a2001654','责任部门编辑','','2018-04-23 10:57:28','supportFile','dutyDepartment:fe',18,'2018-04-25 09:15:58','责任部门管理组'),('7430476f-126c-4e80-ba41-3efa42973e2a','角色编辑','','2018-04-22 10:53:24','role','role:ru',16,'2018-04-22 12:50:28','角色组'),('75029c90-6672-4592-b80e-9c105dc95b6b','责任部门编辑','','2018-04-25 09:15:58','supportFile','dutyDepartment:fe',19,'2018-04-25 09:16:27','责任部门管理组'),('75ba7d81-ddc8-4005-b5cf-223efdc8b47a','牵头部门编辑','','2018-04-25 09:15:58','supportFile','leadDepartment:fe',19,'2018-04-25 09:16:27','牵头部门管理组'),('76389d15-018b-4b76-a553-40219ce3a5cb','用户查询','','2018-04-22 12:50:29','user','user:ur',17,'2018-04-23 10:57:27','用户组'),('76f125fd-df90-47ad-a371-d3d5eb472b53','分数编辑','','2018-04-22 12:50:29','score','score:mu',17,'2018-04-23 10:57:27','分数组'),('772ca3bf-353a-489b-975d-dd729c9b773b','所有权限查询','','2018-04-09 08:42:04','permission','permission:apr',6,'2018-04-09 09:57:14','权限组'),('77418cdc-5dd0-4cd8-a083-9bc17afdf3b2','角色权限查询','','2018-04-23 10:57:28','permission','permission:rrolep',18,'2018-04-25 09:15:58','权限组'),('774397be-5169-4cc4-93ff-41da06919452','菜单更新','','2018-04-23 10:57:28','menu','menu:mu',18,'2018-04-25 09:15:58','菜单组'),('77482570-eb6b-4221-8972-c78f6d1be9ca','角色编辑','','2018-04-18 13:00:26','role','role:ru',10,'2018-04-18 14:39:02','角色组'),('77749a27-d66a-4e0b-97a4-85d98073eac5','角色查询','','2018-04-18 14:47:57','role','role:rr',14,'2018-04-18 15:14:15','角色组'),('77e907b4-66bb-4efb-b5fd-f36dc60f90a1','用户删除','','2018-04-22 10:53:24','user','user:ud',16,'2018-04-22 12:50:28','用户组'),('7821ced0-4f7e-4e63-b903-613a06be6652','角色菜单查询','','2018-04-18 14:47:57','role','role:rmr',14,'2018-04-18 15:14:15','菜单组'),('78823418-3f05-4b73-ae8d-6dd1aea8b27f','父菜单添加','','2018-04-18 12:47:25','menu','menu:pc',8,'2018-04-18 12:54:28','菜单组'),('79678661-6f97-440e-b3b1-0b7a1baa623e','用户角色查询','','2018-04-18 15:14:15','role','role:urr',15,'2018-04-22 10:53:24','角色组'),('7a8b669c-fac2-4a57-8a8a-ad01116efd95','角色权限查询','','2018-04-22 12:50:29','role','role:rpr',17,'2018-04-23 10:57:27','角色组'),('7a91b1c7-9826-4324-9851-0841dd46ad90','全部子菜单查询','','2018-04-09 09:57:14','menu','menu:acmr',7,'2018-04-18 12:47:25','菜单组'),('7aefa503-eed6-4028-9a24-f04efe864671','菜单删除','','2018-04-18 14:47:57','menu','menu:md',14,'2018-04-18 15:14:15','菜单组'),('7b0e5823-c70a-4e88-b63b-408790783488','独立菜单查询','','2018-04-22 10:53:24','menu','menu:amr',16,'2018-04-22 12:50:28','菜单组'),('7b46a51c-2c0b-4c30-a3c6-00470145eea3','配置查看','','2018-04-25 09:15:58','config','config:mr',19,'2018-04-25 09:16:27','配置组'),('7b75f633-3e9b-4caa-9295-2f3e214bd2eb','普通用户查看','','2018-04-18 15:14:15','generalUser','generalUser:mr',15,'2018-04-22 10:53:24','普通用户组'),('7bca6003-aee4-4aab-acbe-7144ad651d1d','菜单编辑查询','','2018-04-18 14:39:02','menu','menu:mer',11,'2018-04-18 14:41:24','菜单组'),('7c72f059-00a7-4969-aa20-b61eeb2c0f5f','父菜单添加','','2018-04-18 14:46:42','menu','menu:pc',13,'2018-04-18 14:47:57','菜单组'),('7d1e6449-a478-4b5d-a226-bc4a8ca119bd','普通用户添加','','2018-04-18 14:39:02','generalUser','generalUser:mc',11,'2018-04-18 14:41:24','普通用户组'),('7d2a80d4-9f69-460a-bef8-61128272c9f0','独立菜单查询','','2018-04-22 12:50:29','menu','menu:amr',17,'2018-04-23 10:57:27','菜单组'),('7d67e6b0-a731-4a2e-b1ad-197e9881b35d','菜单查询','','2018-04-18 14:46:42','menu','menu:r',13,'2018-04-18 14:47:57','菜单组'),('7de7d08b-b724-4a68-95b3-e7a461c71ac6','日志查看','','2018-04-22 12:50:29','log','log:mr',17,'2018-04-23 10:57:27','日志组'),('7e39a476-9414-4806-ad78-a88cf7c889ff','角色删除','','2018-04-18 14:39:02','role','role:rd',11,'2018-04-18 14:41:24','角色组'),('7e511192-4d7e-4a8b-bf23-bfe0c26c5ab9','问题查看','','2018-04-22 10:53:24','problem','problem:mr',16,'2018-04-22 12:50:28','问题组'),('7e7e5993-16ee-4775-af48-f68bc9ffb7c7','普通用户查看','','2018-04-25 09:15:58','generalUser','generalUser:mr',19,'2018-04-25 09:16:27','普通用户组'),('7eae6178-7932-4913-b25e-70223eda5ca8','用户角色查询','','2018-04-18 14:39:02','role','role:urr',11,'2018-04-18 14:41:24','角色组'),('7edc5519-286e-42b0-8ce2-03b514ee5102','菜单编辑查询','','2018-04-18 12:47:25','menu','menu:mer',8,'2018-04-18 12:54:28','菜单组'),('7f2d8634-264c-416f-b8c7-80aa3e6d2383','角色详细查询','','2018-04-18 14:41:24','role','role:rv',12,'2018-04-18 14:46:42','角色组'),('80db8204-9d6f-4a71-a14e-a9fc6c3761e8','用户更新','','2018-04-18 14:39:02','user','user:uu',11,'2018-04-18 14:41:24','用户组'),('80eca598-8c17-4d64-acd6-bc615f02a653','全部子菜单查询','','2018-04-18 12:47:25','menu','menu:acmr',8,'2018-04-18 12:54:28','菜单组'),('83cadfde-469d-4851-a73b-5c63adeefdea','牵头部门编辑','','2018-04-23 10:57:28','supportFile','leadDepartment:fe',18,'2018-04-25 09:15:58','牵头部门管理组'),('8473a392-91bb-4181-904f-4948cdbe295f','问题类型查看','','2018-04-22 10:53:24','type','type:mr',16,'2018-04-22 12:50:28','类型组'),('848a0961-6f77-4d68-8b93-1b53ee6dde97','菜单删除','','2018-04-18 14:39:02','menu','menu:md',11,'2018-04-18 14:41:24','菜单组'),('854ef937-2e15-40cf-8c20-345838a65c5d','问题类型查看','','2018-04-22 10:53:24','type','type:mu',16,'2018-04-22 12:50:28','类型组'),('8589c4f4-f002-4ce6-b56a-50fa88c754bd','普通用户查看','','2018-04-18 14:41:24','generalUser','generalUser:mr',12,'2018-04-18 14:46:42','普通用户组'),('864b334f-8a54-4e54-ae0d-a1ab5d6c2bb6','角色删除','','2018-04-23 10:57:28','role','role:rd',18,'2018-04-25 09:15:58','角色组'),('8680dec0-6ddf-4e27-9c3f-98132fe5c120','分数查看','','2018-04-22 12:50:29','score','score:mr',17,'2018-04-23 10:57:27','分数组'),('86e130f3-f457-4468-921d-2d16f2d7c9c8','责任部门查看','','2018-04-25 09:15:58','supportFile','dutyDepartment:fr',19,'2018-04-25 09:16:27','责任部门管理组'),('874eb68a-965f-4e42-96be-ea155bb7dab8','角色查询','','2018-04-18 15:14:15','role','role:rr',15,'2018-04-22 10:53:24','角色组'),('8836e7b2-caef-45d2-a2a2-87f3e0aef9cd','评审用户添加','','2018-04-25 09:15:58','frontUser','raterUser:mc',19,'2018-04-25 09:16:27','普通用户组'),('8a5c2528-f55f-4032-86c0-08b4eca76bf9','普通用户删除','','2018-04-18 14:47:57','generalUser','generalUser:md',14,'2018-04-18 15:14:15','普通用户组'),('8a5f05c2-716e-4e9e-8051-deb0f4c849d7','普通用户删除','','2018-04-18 15:14:15','generalUser','generalUser:md',15,'2018-04-22 10:53:24','普通用户组'),('8a84ee8c-2a54-4012-865b-d0cbbd550340','菜单删除','','2018-04-23 10:57:28','menu','menu:md',18,'2018-04-25 09:15:58','菜单组'),('8aa78b1e-780a-499c-ad57-0f27cb582778','菜单更新','','2018-04-18 14:46:42','menu','menu:mu',13,'2018-04-18 14:47:57','菜单组'),('8ade9af9-9676-45d4-bd23-1acdd4fed71f','角色查询','','2018-04-22 12:50:29','role','role:rr',17,'2018-04-23 10:57:27','角色组'),('8b3343d6-a134-4d13-9f7f-4d8bbbd67605','问题查看','','2018-04-25 09:15:58','problem','problem:mr',19,'2018-04-25 09:16:27','问题组'),('8b3caddc-5c7b-4562-94b2-756a7bae6a14','用户更新','','2018-04-18 14:41:24','user','user:uu',12,'2018-04-18 14:46:42','用户组'),('8b5f444d-dc3a-4189-b564-3a720aacfb28','父菜单添加','','2018-04-09 09:57:14','menu','menu:pc',7,'2018-04-18 12:47:25','菜单组'),('8b73f696-0a2d-41e5-a7ab-4d3aacf3bcb5','菜单查询','','2018-04-18 15:14:15','menu','menu:r',15,'2018-04-22 10:53:24','菜单组'),('8caef1fa-e84d-49d6-911d-02c7e7b7e0fe','角色权限查询','','2018-04-18 14:39:02','permission','permission:rrolep',11,'2018-04-18 14:41:24','权限组'),('8cdeb727-7d77-4c35-82b3-20d05b8c31ed','角色权限查询','','2018-04-08 12:21:55','permission','permission:rrolep',5,'2018-04-09 08:42:04','权限组'),('8d180f87-ca18-45a5-b9bb-24743e39b3f3','普通用户查看','','2018-04-18 14:47:57','generalUser','generalUser:mr',14,'2018-04-18 15:14:15','普通用户组'),('8d602e66-36f4-4142-9696-ab2366f93fe7','所有权限查询','','2018-04-18 12:54:28','permission','permission:apr',9,'2018-04-18 13:00:26','权限组'),('8d86cd87-e1e1-4ecb-ba6d-dfbb8d18d199','菜单查询','','2018-04-22 10:53:24','menu','menu:r',16,'2018-04-22 12:50:28','菜单组'),('8d8aee2b-8e9c-43b9-b739-efb5d5fd0826','角色查询','','2018-04-18 14:41:24','role','role:rr',12,'2018-04-18 14:46:42','角色组'),('8d9d2c45-bfa2-48ba-b977-77c045e9153c','分数删除','','2018-04-25 09:15:58','score','score:md',19,'2018-04-25 09:16:27','分数组'),('8dba9779-5083-4263-aaca-3a359bb7090d','普通用户删除','','2018-04-18 14:41:24','generalUser','generalUser:md',12,'2018-04-18 14:46:42','普通用户组'),('8df3ebf7-8023-4efa-9775-858097439a4c','用户查询','','2018-04-18 13:00:26','user','user:ur',10,'2018-04-18 14:39:02','用户组'),('8e806015-d683-4363-8b59-b2319a9b917c','用户角色更新','','2018-04-18 15:14:15','user','user:uru',15,'2018-04-22 10:53:24','用户组'),('8eddb9c9-deb2-4155-abc5-e816163ba4c6','部门编辑','','2018-04-25 09:15:58','department','department:mu',19,'2018-04-25 09:16:27','部门组'),('8f4ad8f9-875b-43e9-a9cf-d39d884d5b4a','审责任部门添加','','2018-04-25 09:15:58','supportFile','dutyDepartment:fc',19,'2018-04-25 09:16:27','责任部门管理组'),('8faa8938-f198-457d-a4cc-cfc323af51a8','菜单删除','','2018-04-09 08:42:04','menu','menu:md',6,'2018-04-09 09:57:14','菜单组'),('900e66fa-6995-41fe-876f-b587a6232207','角色菜单查询','','2018-04-25 09:15:58','role','role:rmr',19,'2018-04-25 09:16:27','菜单组'),('908a6225-8cb0-47ff-8f00-1f2347118dcb','评审用户删除','','2018-04-22 10:53:24','frontUser','raterUser:md',16,'2018-04-22 12:50:28','普通用户组'),('927d9410-cf4f-4e2a-b86d-46cee0e51913','普通用户删除','','2018-04-25 09:15:58','generalUser','generalUser:md',19,'2018-04-25 09:16:27','普通用户组'),('92b6c515-20c7-41cd-b6c2-2ee0be7966d4','用户更新','','2018-04-18 12:54:28','user','user:uu',9,'2018-04-18 13:00:26','用户组'),('93049fa4-720f-4d0a-b9f2-2ef993570b71','普通用户详细','','2018-04-18 12:54:28','generalUser','generalUser:md',9,'2018-04-18 13:00:26','普通用户组'),('93b21677-c949-47d3-a556-bfaf321d56d8','角色删除','','2018-04-22 12:50:29','role','role:rd',17,'2018-04-23 10:57:27','角色组'),('93b94688-ed8b-42ac-ae3d-d7c55b1b2a88','分数添加','','2018-04-22 12:50:29','score','score:mc',17,'2018-04-23 10:57:27','分数组'),('94e12d38-9274-4a8d-b7c2-f9d8a3df2eac','问题详细','','2018-04-22 12:50:29','problem','problem:mr',17,'2018-04-23 10:57:27','问题组'),('955ef9b0-e71c-4730-b5fb-8a4be62ef06e','审查要点详细','','2018-04-23 10:57:28','supportFile','point:fd',18,'2018-04-25 09:15:58','审查要点管理组'),('9584ba6c-7b43-4d57-b187-8f9407818730','UI更新','','2018-04-18 12:54:28','ui','ui:',9,'2018-04-18 13:00:26','UI组'),('95c0dae2-3f86-4526-8391-0a5280828d91','用户详细','','2018-04-18 13:00:26','user','user:ud',10,'2018-04-18 14:39:02','用户组'),('95c93316-1b9c-4984-a05c-1b67576d547d','问题编辑','','2018-04-22 12:50:29','problem','problem:mu',17,'2018-04-23 10:57:27','问题组'),('973075c8-acf4-40ec-8b44-d141fbd95b33','所有权限查询','','2018-04-18 12:47:25','permission','permission:apr',8,'2018-04-18 12:54:28','权限组'),('974d821e-e6ad-471f-b9e0-a2ba0eb3ab79','普通用户添加','','2018-04-22 12:50:29','generalUser','generalUser:mc',17,'2018-04-23 10:57:27','普通用户组'),('97f9c2b1-4819-4d6e-83e4-834845b636e4','父菜单添加','','2018-04-18 13:00:26','menu','menu:pc',10,'2018-04-18 14:39:02','菜单组'),('98303a61-c552-4237-b9e2-1f878245dab4','角色详细查询','','2018-04-18 15:14:15','role','role:rv',15,'2018-04-22 10:53:24','角色组'),('9875919a-2eb1-43b0-a03c-d3b41c7861c6','全部子菜单查询','','2018-04-22 12:50:29','menu','menu:acmr',17,'2018-04-23 10:57:27','菜单组'),('9895feb5-088c-48fa-bc07-3905d28a66f1','牵头部门查看','','2018-04-25 09:15:58','supportFile','leadDepartment:fr',19,'2018-04-25 09:16:27','牵头部门管理组'),('98be7761-19f5-467d-8c6e-841dbcd12faa','用户角色查询','','2018-04-09 09:57:14','role','role:urr',7,'2018-04-18 12:47:25','角色组'),('98f052c4-3d7e-481b-8bfb-9dfda292c500','菜单编辑查询','','2018-04-18 14:47:57','menu','menu:mer',14,'2018-04-18 15:14:15','菜单组'),('98f31359-8d10-4e81-8edb-b699641d7620','审核项目查看','','2018-04-23 10:57:28','supportFile','project:fr',18,'2018-04-25 09:15:58','审核项目管理组'),('98fd07d4-73c6-4f70-9f9f-28d25cb2d0ad','独立菜单查询','','2018-04-18 14:47:57','menu','menu:amr',14,'2018-04-18 15:14:15','菜单组'),('9960afb9-00f8-4e3f-9677-ea8b767ae537','角色权限查询','','2018-04-23 10:57:28','role','role:rpr',18,'2018-04-25 09:15:58','角色组'),('99ad580a-0d43-4ae5-bc5a-00e781cf12ad','菜单查询','','2018-04-18 12:47:25','menu','menu:r',8,'2018-04-18 12:54:28','菜单组'),('99f84eed-d615-471b-b661-c0cedfde8c29','UI更新','','2018-04-18 14:46:42','ui','ui:',13,'2018-04-18 14:47:57','UI组'),('9a486757-7d48-42de-9edf-c9e01b1ce9f2','用户更新','','2018-04-18 12:47:25','user','user:uu',8,'2018-04-18 12:54:28','用户组'),('9a6572ac-7d7f-4965-93d3-d70f422cddb1','普通用户编辑','','2018-04-18 14:46:42','generalUser','generalUser:me',13,'2018-04-18 14:47:57','普通用户组'),('9a8b02f7-6597-4bdc-93cd-a74ab9d72375','角色编辑','','2018-04-22 12:50:29','role','role:ru',17,'2018-04-23 10:57:27','角色组'),('9a9c9ac5-ca7d-4231-8de2-94dcfef739aa','角色删除','','2018-04-18 14:46:42','role','role:rd',13,'2018-04-18 14:47:57','角色组'),('9abf999c-1c38-4efa-b810-0a1d676ec9eb','用户查询','','2018-04-23 10:57:28','user','user:ur',18,'2018-04-25 09:15:58','用户组'),('9ac55288-4e53-43c3-9ff1-ed70f8990431','问题类型查看','','2018-04-25 09:15:58','type','type:mr',19,'2018-04-25 09:16:27','类型组'),('9ad624c6-609b-47ed-ae46-f3bc4bd76483','菜单更新','','2018-04-18 12:54:28','menu','menu:mu',9,'2018-04-18 13:00:26','菜单组'),('9afec170-72b0-4779-8e90-e53f4e61e14a','角色详细查询','','2018-04-18 12:54:28','role','role:rv',9,'2018-04-18 13:00:26','角色组'),('9b10fbc4-03ec-4d30-9822-da76fec7cd84','独立菜单查询','','2018-04-09 09:57:14','menu','menu:amr',7,'2018-04-18 12:47:25','菜单组'),('9b6cc9ab-a2c4-4c7d-83ac-f78e0ae9664c','角色编辑','','2018-04-18 14:41:24','role','role:ru',12,'2018-04-18 14:46:42','角色组'),('9bca211f-0fe7-4d82-9319-d79ee2ea7400','菜单查询','','2018-04-22 12:50:29','menu','menu:r',17,'2018-04-23 10:57:27','菜单组'),('9ce1e7d7-4dc3-4924-ae18-fb871a20c369','菜单查询','','2018-04-09 09:57:14','menu','menu:r',7,'2018-04-18 12:47:25','菜单组'),('9cfc990f-05ab-4d4c-8615-7be118a9611e','用户角色更新','','2018-04-18 13:00:26','user','user:uru',10,'2018-04-18 14:39:02','用户组'),('9d63b6d2-8a98-4d69-b964-4795e517a330','角色编辑','','2018-04-18 14:47:57','role','role:ru',14,'2018-04-18 15:14:15','角色组'),('9db17ed0-68e1-4993-a12f-e1be8fddc744','评审用户添加','','2018-04-23 10:57:28','frontUser','raterUser:mc',18,'2018-04-25 09:15:58','普通用户组'),('9dbb401a-3b3c-4278-ae91-e82bafc9da08','角色菜单查询','','2018-04-18 13:00:26','role','role:rmr',10,'2018-04-18 14:39:02','菜单组'),('9df0bd1f-6f0e-4d96-a5c4-574025a3839b','用户删除','','2018-04-25 09:15:58','user','user:ud',19,'2018-04-25 09:16:27','用户组'),('9f678893-bb68-442b-8c04-d9daa3e8d047','角色删除','','2018-04-18 14:47:57','role','role:rd',14,'2018-04-18 15:14:15','角色组'),('9fd63805-0b64-4678-8c97-c519db394d39','牵头部门详细','','2018-04-25 09:15:58','supportFile','leadDepartment:fd',19,'2018-04-25 09:16:27','牵头部门管理组'),('a015866f-6f65-48c9-9fa0-428dbf4832f9','用户详细','','2018-04-18 15:14:15','user','user:ud',15,'2018-04-22 10:53:24','用户组'),('a02ed822-7979-48ac-ab4a-30ef1b0de31d','审核项目查看','','2018-04-25 09:15:58','supportFile','project:fr',19,'2018-04-25 09:16:27','审核项目管理组'),('a14c99a0-3a4e-4544-836b-5265efa46396','用户添加','','2018-04-18 12:47:25','user','user:ua',8,'2018-04-18 12:54:28','用户组'),('a16c0a14-52ef-4b56-8410-150bbe319bb7','用户角色查询','','2018-04-18 12:54:28','role','role:urr',9,'2018-04-18 13:00:26','角色组'),('a1e1c0ae-20c3-49fe-bf73-6288e4d4d64c','用户角色查询','','2018-04-18 13:00:26','role','role:urr',10,'2018-04-18 14:39:02','角色组'),('a20f7273-d6f9-4d05-8851-e601a1d2fca5','审核要素查看','','2018-04-25 09:15:58','supportFile','element:fr',19,'2018-04-25 09:16:27','审核要素管理组'),('a30d43a4-7200-4443-b48f-0f62b12136bf','自评问件删除','','2018-04-22 12:50:29','rater','rater:md',17,'2018-04-23 10:57:27','自评文件组'),('a3596466-09e7-430d-8741-c05bd3cd865b','审查要素添加','','2018-04-23 10:57:28','supportFile','element:fc',18,'2018-04-25 09:15:58','审查要素管理组'),('a35d3900-861e-4b13-b824-a34a0ad33cb1','支撑问件查看','','2018-04-25 09:15:58','support','support:mr',19,'2018-04-25 09:16:27','支撑文件组'),('a3618f23-2b86-4d8f-a30d-c882b9ee27f9','菜单更新','','2018-04-22 12:50:29','menu','menu:mu',17,'2018-04-23 10:57:27','菜单组'),('a3732ee4-5ec6-4f73-9a8f-a7a81f2f0fa0','用户角色查询','','2018-04-08 12:21:55','role','role:urr',5,'2018-04-09 08:42:04','角色组'),('a46beda6-767d-420f-8c0f-4a97da4ab15a','用户角色查询','','2018-04-22 10:53:24','role','role:urr',16,'2018-04-22 12:50:28','角色组'),('a50bfe8c-9079-4c16-bba3-fff0f4603f0f','用户详细','','2018-04-22 12:50:29','user','user:ud',17,'2018-04-23 10:57:27','用户组'),('a58394f0-d62c-4705-a79b-9c32d9ff1449','菜单查询','','2018-04-09 08:42:04','menu','menu:r',6,'2018-04-09 09:57:14','菜单组'),('a5bb7c1a-f9ed-4e08-b9ba-7821c452f31c','普通用户详细','','2018-04-22 12:50:29','generalUser','generalUser:md',17,'2018-04-23 10:57:27','普通用户组'),('a6116a19-3f69-46b2-99b0-bda97a82aea3','自评问件删除','','2018-04-22 10:53:24','rater','rater:md',16,'2018-04-22 12:50:28','自评文件组'),('a77d51e4-31c7-4eb9-807b-355e491e8959','父菜单添加','','2018-04-18 14:39:02','menu','menu:pc',11,'2018-04-18 14:41:24','菜单组'),('a7a5bdef-10fc-4ec6-a31a-de30ef34f31d','部门查看','','2018-04-25 09:15:58','department','department:mr',19,'2018-04-25 09:16:27','部门组'),('a7accd2f-9654-4cd7-a72f-c2814428bf11','UI更新','','2018-04-25 09:15:58','ui','ui:',19,'2018-04-25 09:16:27','UI组'),('a7f2be1f-1710-4dc2-b0cc-65896fd84b94','用户查询','','2018-04-18 14:47:57','user','user:ur',14,'2018-04-18 15:14:15','用户组'),('a913aedb-2478-4298-960b-b235bfe8dde7','评审用户编辑','','2018-04-22 12:50:29','frontUser','raterUser:me',17,'2018-04-23 10:57:27','评审用户组'),('a9f8da04-6f4c-47b7-9226-5b75a7ce1d93','UI查询','','2018-04-18 14:39:02','ui','ui:ur',11,'2018-04-18 14:41:24','UI组'),('aa6642e6-cdaa-41eb-92b6-ee7342569d6f','所有权限查询','','2018-04-22 10:53:24','permission','permission:apr',16,'2018-04-22 12:50:28','权限组'),('ab3b7b87-8618-4682-a65b-c941a96fd053','评审用户添加','','2018-04-22 10:53:24','frontUser','raterUser:mc',16,'2018-04-22 12:50:28','普通用户组'),('abe1a9bc-089b-489d-8570-8b4313cbefd6','普通用户编辑','','2018-04-25 09:15:58','generalUser','generalUser:me',19,'2018-04-25 09:16:27','普通用户组'),('ac22ed34-cd07-4ee4-9b7e-df118b074010','牵头部门删除','','2018-04-23 10:57:28','supportFile','leadDepartment:fd',18,'2018-04-25 09:15:58','牵头部门管理组'),('ac9624cc-319b-476c-9ab2-8a64b29884f1','用户删除','','2018-04-18 15:14:15','user','user:ud',15,'2018-04-22 10:53:24','用户组'),('acdeae9a-716d-4edf-ac44-f6516b008a7f','用户删除','','2018-04-18 13:00:26','user','user:ud',10,'2018-04-18 14:39:02','用户组'),('ad3e0362-c7b1-472c-90b1-77b21f713a4d','配置查看','','2018-04-23 10:57:28','config','config:mr',18,'2018-04-25 09:15:58','配置组'),('ad8b8037-5e69-449b-b6ed-64590134c0b6','菜单更新','','2018-04-08 12:21:55','menu','menu:mu',5,'2018-04-09 08:42:04','菜单组'),('ad929557-a34a-4683-816e-e40c3e652b99','角色编辑','','2018-04-18 12:47:25','role','role:ru',8,'2018-04-18 12:54:28','角色组'),('ae337078-d746-4ce4-864a-cadc27aae2ea','角色详细查询','','2018-04-18 12:47:25','role','role:rv',8,'2018-04-18 12:54:28','角色组'),('aec74fe6-6f6e-4903-86de-351a103fcf7a','牵头部门详细','','2018-04-23 10:57:28','supportFile','leadDepartment:fd',18,'2018-04-25 09:15:58','牵头部门管理组'),('af0e6fcf-c215-416e-8268-c786415d4d57','菜单删除','','2018-04-25 09:15:58','menu','menu:md',19,'2018-04-25 09:16:27','菜单组'),('af2c9dda-1341-48e5-b778-fa172abc0f54','菜单删除','','2018-04-09 09:57:14','menu','menu:md',7,'2018-04-18 12:47:25','菜单组'),('af2d7fb5-c9f5-423f-a3d8-b6850e14e8d4','用户角色更新','','2018-04-18 14:39:02','user','user:uru',11,'2018-04-18 14:41:24','用户组'),('af3eaaf9-7aab-45d7-8c2c-c34878577417','角色编辑','','2018-04-18 14:46:42','role','role:ru',13,'2018-04-18 14:47:57','角色组'),('af7e8c7b-c5ff-4eee-91d2-f1939718cec3','问题类型查看','','2018-04-22 12:50:29','type','type:mu',17,'2018-04-23 10:57:27','类型组'),('aff9f0ad-199b-4ed5-a698-9acf6cf2fcde','普通用户查看','','2018-04-18 14:41:24','generalUser','generalUser:mr',12,'2018-04-18 14:46:42','普通用户组'),('b052e9c6-e09f-4f1a-b11e-016e747f6f3d','问题查看','','2018-04-23 10:57:28','problem','problem:mr',18,'2018-04-25 09:15:58','问题组'),('b0b0dfc7-0f95-403b-bab0-3b1790c1f9e5','问题详细','','2018-04-25 09:15:58','problem','problem:mr',19,'2018-04-25 09:16:27','问题组'),('b0dbfb37-4c2e-47be-872d-928bc5cba976','菜单编辑查询','','2018-04-18 15:14:15','menu','menu:mer',15,'2018-04-22 10:53:24','菜单组'),('b2052300-c8e8-4ed5-805d-ef5ae51519a8','部门删除','','2018-04-22 12:50:29','department','department:md',17,'2018-04-23 10:57:27','部门组'),('b3604f6d-6260-4973-856c-7eac7fd44b03','普通用户编辑','','2018-04-18 14:46:42','generalUser','generalUser:me',13,'2018-04-18 14:47:57','普通用户组'),('b407219e-64bf-4f61-ad8b-2f0d137c152a','角色权限查询','','2018-04-02 12:47:29','permission','permission:rrolep',4,'2018-04-08 12:21:55',''),('b493720b-4366-4e5b-86f6-91049961e7ad','菜单编辑查询','','2018-04-23 10:57:28','menu','menu:mer',18,'2018-04-25 09:15:58','菜单组'),('b5323e5f-68ee-44b6-b30e-a3176d2f1004','问题类型删除','','2018-04-22 12:50:29','type','type:md',17,'2018-04-23 10:57:27','类型组'),('b55aa114-a26f-48a3-b43b-9dcf494b4225','问题类型删除','','2018-04-25 09:15:58','type','type:md',19,'2018-04-25 09:16:27','类型组'),('b5fa146c-9ca6-48f6-9b1f-a0c5be677c85','普通用户添加','','2018-04-18 14:46:42','generalUser','generalUser:mc',13,'2018-04-18 14:47:57','普通用户组'),('b62de0d6-c28c-4458-b487-e122b41a9465','审核项目详细','','2018-04-23 10:57:28','supportFile','project:fd',18,'2018-04-25 09:15:58','审核项目管理组'),('b6b697cb-755f-4be6-814c-c485885781db','问题类型添加','','2018-04-23 10:57:28','type','type:mc',18,'2018-04-25 09:15:58','类型组'),('b6d86882-7da7-4e3d-ba98-7cf13cf52c5e','菜单删除','','2018-04-22 10:53:24','menu','menu:md',16,'2018-04-22 12:50:28','菜单组'),('b76b69e3-f18a-4ce1-885b-d15ac429bb65','菜单更新','','2018-04-18 15:14:15','menu','menu:mu',15,'2018-04-22 10:53:24','菜单组'),('b7f07a79-8236-45f7-b3cb-d88e735d5bc8','用户更新','','2018-04-18 15:14:15','user','user:uu',15,'2018-04-22 10:53:24','用户组'),('b8b4f610-e693-4ae0-9ef2-e1eaf65d2b8d','用户删除','','2018-04-23 10:57:28','user','user:ud',18,'2018-04-25 09:15:58','用户组'),('b9e231e8-0e01-4355-afdf-6ae4e607cd81','责任部门详细','','2018-04-23 10:57:28','supportFile','dutyDepartment:fd',18,'2018-04-25 09:15:58','责任部门管理组'),('ba87706d-5b8c-49f8-b1aa-606bc149c787','审核要点编辑','','2018-04-25 09:15:58','supportFile','point:fe',19,'2018-04-25 09:16:27','审核要点管理组'),('bb613cd1-1060-4441-97a2-3aa1201f89e9','用户添加','','2018-04-23 10:57:28','user','user:ua',18,'2018-04-25 09:15:58','用户组'),('bb9dba79-2572-4160-a232-4e840c95c038','问题类型删除','','2018-04-23 10:57:28','type','type:md',18,'2018-04-25 09:15:58','类型组'),('bbcc5b43-9122-4be6-a85e-2d60f7242ff2','部门查看','','2018-04-22 12:50:29','department','department:mr',17,'2018-04-23 10:57:27','部门组'),('bbfaf6bc-bddf-4e22-b123-0cd7b718ef1b','角色查询','','2018-04-18 14:39:02','role','role:rr',11,'2018-04-18 14:41:24','角色组'),('bbfb3015-bf68-4395-9fa6-238b6ced650a','用户添加','','2018-04-22 10:53:24','user','user:ua',16,'2018-04-22 12:50:28','用户组'),('bc1d838a-5c90-4b5e-84b4-f6faf4c33c34','牵头部门查看','','2018-04-23 10:57:28','supportFile','leadDepartment:fr',18,'2018-04-25 09:15:58','牵头部门管理组'),('bcf21bab-7602-4f52-9f9f-41cafa37dc9f','审核要素编辑','','2018-04-25 09:15:58','supportFile','element:fe',19,'2018-04-25 09:16:27','审核要素管理组'),('be608a4c-0ee5-45f7-8a58-b561b3dced42','菜单查询','','2018-04-18 14:39:02','menu','menu:r',11,'2018-04-18 14:41:24','菜单组'),('bf6a96f3-fff4-454e-b999-71c7092bd0e2','普通用户添加','','2018-04-22 10:53:24','generalUser','generalUser:mc',16,'2018-04-22 12:50:28','普通用户组'),('bfa8c8e5-8175-4e4f-9848-3922c539d90f','全部子菜单查询','','2018-04-18 14:47:57','menu','menu:acmr',14,'2018-04-18 15:14:15','菜单组'),('c0b4b894-e636-47f4-bce8-c5b8702d4938','角色权限查询','','2018-04-02 08:31:14','permission','permission:rrolep',0,'2018-04-02 08:43:52',''),('c0c3be5e-a5dd-4a90-b156-8a3488da51e8','评审用户详细','','2018-04-23 10:57:28','frontUser','raterUser:md',18,'2018-04-25 09:15:58','评审用户组'),('c0e613cc-e8ef-4345-ab6f-130a125b0807','部门编辑','','2018-04-22 10:53:24','department','department:mu',16,'2018-04-22 12:50:28','部门组'),('c1d7ed89-5030-46a9-b6d2-14f3b866271e','普通用户添加','','2018-04-18 14:47:57','generalUser','generalUser:mc',14,'2018-04-18 15:14:15','普通用户组'),('c1fabe5c-5a98-4cd7-b395-b44082bd145f','评审用户编辑','','2018-04-22 10:53:24','frontUser','raterUser:me',16,'2018-04-22 12:50:28','评审用户组'),('c24af867-0f3c-4560-b2df-c65f256bd8b3','问题查看','','2018-04-22 12:50:29','problem','problem:mr',17,'2018-04-23 10:57:27','问题组'),('c2c90111-99ab-436d-a5b2-ca1c28a7e0a3','用户查询','','2018-04-22 10:53:24','user','user:ur',16,'2018-04-22 12:50:28','用户组'),('c5059ac7-babb-4fb6-ae62-422f06d85ad7','分数详细','','2018-04-22 10:53:24','score','score:mr',16,'2018-04-22 12:50:28','分数组'),('c69b5df9-bfc5-46e0-a98f-7ea19526028e','普通用户添加','','2018-04-18 12:54:28','generalUser','generalUser:mc',9,'2018-04-18 13:00:26','普通用户组'),('c69c1f9e-5ad2-44d0-917e-9dc0ecf7b39f','UI更新','','2018-04-18 14:47:57','ui','ui:',14,'2018-04-18 15:14:15','UI组'),('c6ae31af-4d93-417c-b6eb-d98e396acb91','普通用户查看','','2018-04-18 14:47:57','generalUser','generalUser:mr',14,'2018-04-18 15:14:15','普通用户组'),('c6c158f3-635e-4743-8429-1c520ec3b981','普通用户查看','','2018-04-23 10:57:28','generalUser','generalUser:mr',18,'2018-04-25 09:15:58','普通用户组'),('c6cbc9e0-146f-429f-912a-ca46de3af4df','UI更新','','2018-04-22 12:50:29','ui','ui:',17,'2018-04-23 10:57:27','UI组'),('c6da68c4-5bcb-4ce2-af65-85aa8f2df6a4','角色权限查询','','2018-04-09 09:57:14','permission','permission:rrolep',7,'2018-04-18 12:47:25','权限组'),('c75615df-1234-4aab-be07-91c02ce3d092','问题添加','','2018-04-22 10:53:24','problem','problem:mc',16,'2018-04-22 12:50:28','问题组'),('c838e271-ba1f-4aaf-b495-72701ef08d15','普通用户编辑','','2018-04-22 12:50:29','generalUser','generalUser:me',17,'2018-04-23 10:57:27','普通用户组'),('c8e4c13c-a3a3-4a5e-bee0-8f6a38bc7889','全部子菜单查询','','2018-04-23 10:57:28','menu','menu:acmr',18,'2018-04-25 09:15:58','菜单组'),('c98904b0-dcdf-40de-8e85-b87ff2b3c6dd','普通用户删除','','2018-04-18 13:00:26','generalUser','generalUser:md',10,'2018-04-18 14:39:02','普通用户组'),('c9dadfc1-a42d-4774-8297-b8789363c528','普通用户查看','','2018-04-18 12:54:28','generalUser','generalUser:mr',9,'2018-04-18 13:00:26','普通用户组'),('ca26b74a-289c-4947-a2e0-9a4a276e563c','用户更新','','2018-04-18 14:46:42','user','user:uu',13,'2018-04-18 14:47:57','用户组'),('ca73e94c-4f59-4c8f-8bc0-68d65eb97177','问题类型查询','','2018-04-23 10:57:28','type','type:mr',18,'2018-04-25 09:15:58','类型组'),('ca7f4d40-c6bd-4811-8e74-8cb05826e5f6','分数查看','','2018-04-25 09:15:58','score','score:mr',19,'2018-04-25 09:16:27','分数组'),('cb0b7605-2a3d-4baf-aa02-14d5b9f811db','所有权限查询','','2018-04-25 09:15:58','permission','permission:apr',19,'2018-04-25 09:16:27','权限组'),('cc07f52e-f68c-4df5-bef0-683faf64d15c','所有权限查询','','2018-04-18 14:46:42','permission','permission:apr',13,'2018-04-18 14:47:57','权限组'),('cc1b1323-22d6-490d-8ca5-a47aa627869d','角色权限查询','','2018-04-25 09:15:58','permission','permission:rrolep',19,'2018-04-25 09:16:27','权限组'),('cd0a5233-4581-44d2-aa1d-96066c9f86b7','普通用户删除','','2018-04-18 14:39:02','generalUser','generalUser:md',11,'2018-04-18 14:41:24','普通用户组'),('cd2d13c8-710d-406d-b980-aa80b42b8090','UI更新','','2018-04-22 10:53:24','ui','ui:',16,'2018-04-22 12:50:28','UI组'),('cd827b8c-6163-4ffe-8f69-6d8b3ef96459','用户删除','','2018-04-22 12:50:29','user','user:ud',17,'2018-04-23 10:57:27','用户组'),('ce01cb6b-1cc9-4b5c-acf6-5ba43674bb07','角色权限查询','','2018-04-18 12:47:25','role','role:rqr',8,'2018-04-18 12:54:28','权限'),('ce6964e9-7f7f-44cf-8b84-19c781f83ef0','全部子菜单查询','','2018-04-18 12:54:28','menu','menu:acmr',9,'2018-04-18 13:00:26','菜单组'),('ce80b554-1efa-4728-ade0-48ed5ae17af7','问题查看','','2018-04-22 10:53:24','problem','problem:mr',16,'2018-04-22 12:50:28','问题组'),('cf03260d-dd81-47d1-a981-527e63d932a2','菜单更新','','2018-04-18 14:41:24','menu','menu:mu',12,'2018-04-18 14:46:42','菜单组'),('cf97cb9b-c343-49ac-b979-e3419e1ac0a9','用户添加','','2018-04-18 14:46:42','user','user:ua',13,'2018-04-18 14:47:57','用户组'),('cfb4eb35-7d66-4d45-b972-3c900b736cc9','评审用户添加','','2018-04-22 12:50:29','frontUser','raterUser:mc',17,'2018-04-23 10:57:27','普通用户组'),('d040c3e3-d03b-404d-95a2-069fa722bb9a','用户添加','','2018-04-18 14:39:02','user','user:ua',11,'2018-04-18 14:41:24','用户组'),('d07e1c69-a551-4d04-a61a-483f5d7190c4','全部子菜单查询','','2018-04-18 13:00:26','menu','menu:acmr',10,'2018-04-18 14:39:02','菜单组'),('d15b9548-c712-4743-8476-2996b69bb30c','角色删除','','2018-04-18 14:41:24','role','role:rd',12,'2018-04-18 14:46:42','角色组'),('d16dd765-d548-447a-b26a-dfcfc7d6aea9','全部子菜单查询','','2018-04-18 14:46:42','menu','menu:acmr',13,'2018-04-18 14:47:57','菜单组'),('d1d1bdcb-edfa-4022-bdf5-0a5d8c4634da','审核项目添加','','2018-04-23 10:57:28','supportFile','project:fc',18,'2018-04-25 09:15:58','审核项目管理组'),('d1db8f87-4312-4467-b5cf-de3efa7b2aa5','所有权限查询','','2018-04-09 09:57:14','permission','permission:apr',7,'2018-04-18 12:47:25','权限组'),('d1e76963-4b00-436d-ad4e-675a18ae35bd','所有权限查询','','2018-04-18 13:00:26','permission','permission:apr',10,'2018-04-18 14:39:02','权限组'),('d20a7a59-4b15-4b06-9bb3-ae37c041191d','父菜单添加','','2018-04-18 14:41:24','menu','menu:pc',12,'2018-04-18 14:46:42','菜单组'),('d243a059-c206-4a06-a348-b825c474a483','父菜单添加','','2018-04-18 14:47:57','menu','menu:pc',14,'2018-04-18 15:14:15','菜单组'),('d2bd3331-50ed-4430-9929-cc40c0f2e26c','分数删除','','2018-04-22 12:50:29','score','score:md',17,'2018-04-23 10:57:27','分数组'),('d2c4c2a0-fffc-47e5-bea1-660fb13220e1','角色权限查询','','2018-04-18 12:47:25','permission','permission:rrolep',8,'2018-04-18 12:54:28','权限组'),('d37a43e7-2f62-4710-926c-37fb13b57274','配置编辑','','2018-04-23 10:57:28','config','config:mr',18,'2018-04-25 09:15:58','配置组'),('d3c6e8fa-4f27-4e6a-af8c-1fc31044426a','角色权限查询','','2018-04-18 13:00:26','permission','permission:rrolep',10,'2018-04-18 14:39:02','权限组'),('d3c8e429-7478-4944-a37e-7c831d6eed82','角色权限查询','','2018-04-18 14:41:24','role','role:rpr',12,'2018-04-18 14:46:42','角色组'),('d3f8f43c-acec-4aa9-bcc3-0f75ee179572','部门编辑','','2018-04-23 10:57:28','department','department:mu',18,'2018-04-25 09:15:58','部门组'),('d472f68a-7ebb-452a-bbc8-08d4d3c699bc','普通用户查看','','2018-04-18 14:46:42','generalUser','generalUser:mr',13,'2018-04-18 14:47:57','普通用户组'),('d5ee8ae3-e133-4c81-babb-e3fe43c479a3','角色删除','','2018-04-18 12:47:25','role','role:rd',8,'2018-04-18 12:54:28','角色组'),('d5f3f43c-a126-4730-b3d4-3d6917bd2422','角色添加','','2018-04-18 15:14:15','role','role:ra',15,'2018-04-22 10:53:24','角色组'),('d6139a20-a3b2-47a1-bc65-7fe1bb10935a','审核要素删除','','2018-04-25 09:15:58','supportFile','element:fd',19,'2018-04-25 09:16:27','审核要素管理组'),('d635187e-95a3-4de3-8fd1-c5abdd8eb495','独立菜单查询','','2018-04-18 12:47:25','menu','menu:amr',8,'2018-04-18 12:54:28','菜单组'),('d6602d54-0d4f-48ab-9985-83c2708df73d','角色详细查询','','2018-04-22 10:53:24','role','role:rv',16,'2018-04-22 12:50:28','角色组'),('d7cc121b-9932-4f72-9912-cfe9793ba763','分数查看','','2018-04-22 10:53:24','score','score:mr',16,'2018-04-22 12:50:28','分数组'),('d8556732-da28-4abe-b587-56e8c80848e8','普通用户详细','','2018-04-18 14:46:42','generalUser','generalUser:md',13,'2018-04-18 14:47:57','普通用户组'),('d862157c-7768-49de-82d6-d868e72a0b26','用户角色更新','','2018-04-18 12:54:28','user','user:uru',9,'2018-04-18 13:00:26','用户组'),('d9b8347f-f8df-4d21-aec4-669f28e41d71','所有权限查询','','2018-04-22 12:50:29','permission','permission:apr',17,'2018-04-23 10:57:27','权限组'),('d9b9f2f6-fb75-470a-a3bc-727155172a21','角色权限查询','','2018-04-18 13:00:26','role','role:rqr',10,'2018-04-18 14:39:02','权限'),('da749254-c76e-4c88-b2b4-91bef719a0c4','菜单更新','','2018-04-09 09:57:14','menu','menu:mu',7,'2018-04-18 12:47:25','菜单组'),('da9ddd65-ea39-4bf5-8250-407eb9d28045','问题类型添加','','2018-04-25 09:15:58','type','type:mc',19,'2018-04-25 09:16:27','类型组'),('daa36b17-73cb-475c-962a-f2e867031e64','角色查询','','2018-04-08 12:21:55','role','role:rr',5,'2018-04-09 08:42:04','角色组'),('db058df6-b2dd-437a-b395-523f0a4505a3','菜单删除','','2018-04-18 12:47:25','menu','menu:md',8,'2018-04-18 12:54:28','菜单组'),('db56e421-0c27-493f-8bf7-599ea03f2995','菜单编辑查询','','2018-04-18 12:54:28','menu','menu:mer',9,'2018-04-18 13:00:26','菜单组'),('db8f5c55-a929-447f-a486-e8f1dbe15bb4','普通用户查看','','2018-04-18 12:54:28','generalUser','generalUser:mr',9,'2018-04-18 13:00:26','普通用户组'),('dba2fa40-c8ab-4c6b-a3a2-f5d2719a4197','用户更新','','2018-04-18 13:00:26','user','user:uu',10,'2018-04-18 14:39:02','用户组'),('dbd44e3f-dacd-4c7c-a54b-a0961e107479','审查要素编辑','','2018-04-23 10:57:28','supportFile','element:fe',18,'2018-04-25 09:15:58','审查要素管理组'),('dbe55609-f3d2-43bc-8fa2-a0d6883e2a56','UI查询','','2018-04-23 10:57:28','ui','ui:ur',18,'2018-04-25 09:15:58','UI组'),('dc161f86-c385-4592-8e34-4eaf7571766d','独立菜单查询','','2018-04-23 10:57:28','menu','menu:amr',18,'2018-04-25 09:15:58','菜单组'),('de170fb9-2513-4a17-8466-42964615a5f4','问题类型详细','','2018-04-22 12:50:29','type','type:mr',17,'2018-04-23 10:57:27','类型组'),('de85458d-6b53-4fa7-9bd6-b9e21198c469','问题类型添加','','2018-04-22 10:53:24','type','type:mc',16,'2018-04-22 12:50:28','类型组'),('df497225-9fb6-4625-b848-3cdeee5ab550','普通用户查看','','2018-04-18 13:00:26','generalUser','generalUser:mr',10,'2018-04-18 14:39:02','普通用户组'),('dfcfbbd8-a034-4a1a-b0c6-03eea8f5b230','问题删除','','2018-04-25 09:15:58','problem','problem:md',19,'2018-04-25 09:16:27','问题组'),('dfe49fc2-7c99-491b-91a6-df30f1f7a10e','支撑问件删除','','2018-04-23 10:57:28','support','support:md',18,'2018-04-25 09:15:58','支撑文件组'),('e0894310-133b-4531-a007-0e5e46d614dd','普通用户详细','','2018-04-22 10:53:24','generalUser','generalUser:md',16,'2018-04-22 12:50:28','普通用户组'),('e0aa0ce3-a61a-47c7-b3d2-534b79f853d4','角色查询','','2018-04-18 14:46:42','role','role:rr',13,'2018-04-18 14:47:57','角色组'),('e310528e-d6e0-4cdb-adfc-60f186292850','普通用户详细','','2018-04-18 14:41:24','generalUser','generalUser:md',12,'2018-04-18 14:46:42','普通用户组'),('e33f807c-851e-491b-9ff5-31a3090b21a2','分数查看','','2018-04-23 10:57:28','score','score:mr',18,'2018-04-25 09:15:58','分数组'),('e4ade86b-be9e-4808-a91b-9bcb34b221d8','审核要素添加','','2018-04-25 09:15:58','supportFile','element:fc',19,'2018-04-25 09:16:27','审核要素管理组'),('e4e07d1e-ba32-409b-82ad-0c2afab614e8','普通用户编辑','','2018-04-18 14:41:24','generalUser','generalUser:me',12,'2018-04-18 14:46:42','普通用户组'),('e4f83322-4606-47c7-9d11-0f7cba892a8b','普通用户添加','','2018-04-18 15:14:15','generalUser','generalUser:mc',15,'2018-04-22 10:53:24','普通用户组'),('e5672f51-8834-43d5-af59-8723b02405cb','全部子菜单查询','','2018-04-18 14:41:24','menu','menu:acmr',12,'2018-04-18 14:46:42','菜单组'),('e641614b-fa8c-45dd-b58a-b0a05826b5c7','问题详细','','2018-04-23 10:57:28','problem','problem:mr',18,'2018-04-25 09:15:58','问题组'),('e662645d-758a-47e0-8370-8b4375d86fd0','审责任部门删除','','2018-04-23 10:57:28','supportFile','dutyDepartment:fd',18,'2018-04-25 09:15:58','责任部门管理组'),('e71f5285-17e6-427a-bebb-a10b8609e499','问题详细','','2018-04-22 10:53:24','problem','problem:mr',16,'2018-04-22 12:50:28','问题组'),('e7d43735-9a09-4184-ba05-4658ed7af044','UI查询','','2018-04-18 12:47:25','ui','ui:ur',8,'2018-04-18 12:54:28','UI组'),('e7d51a08-782c-4245-b6eb-1bbd9824c55f','全部子菜单查询','','2018-04-25 09:15:58','menu','menu:acmr',19,'2018-04-25 09:16:27','菜单组'),('e805b604-6e8f-4610-b5f5-21b56ce55f39','问题类型查看','','2018-04-25 09:15:58','type','type:mu',19,'2018-04-25 09:16:27','类型组'),('e8a03ee1-4c4b-4b09-aa74-a3a3cf9837c6','分数添加','','2018-04-23 10:57:28','score','score:mc',18,'2018-04-25 09:15:58','分数组'),('e90be9bd-ac60-42ee-9013-bdafca698f85','普通用户编辑','','2018-04-18 14:41:24','generalUser','generalUser:me',12,'2018-04-18 14:46:42','普通用户组'),('e95129e5-794e-4f7a-8ad1-034e60f5e087','用户角色查询','','2018-04-25 09:15:58','role','role:urr',19,'2018-04-25 09:16:27','角色组'),('e9a8547b-fe59-48d5-88ff-f43e8cfffaaa','分数删除','','2018-04-23 10:57:28','score','score:md',18,'2018-04-25 09:15:58','分数组'),('ea29e59d-fa2a-4f00-97e1-4725f8855c77','角色添加','','2018-04-18 14:41:24','role','role:ra',12,'2018-04-18 14:46:42','角色组'),('ea6422a1-1cb1-4919-af8e-c450e3b1c358','普通用户详细','','2018-04-23 10:57:28','generalUser','generalUser:md',18,'2018-04-25 09:15:58','普通用户组'),('eb77d546-c455-402d-abc1-b81430fc328c','问题类型查询','','2018-04-22 12:50:29','type','type:mr',17,'2018-04-23 10:57:27','类型组'),('eb9451d4-e380-45ad-b53f-8afca003ef5f','审查要素删除','','2018-04-23 10:57:28','supportFile','element:fd',18,'2018-04-25 09:15:58','审查要素管理组'),('ebc0d433-9125-494c-a822-7e3fd89c8c63','普通用户添加','','2018-04-23 10:57:28','generalUser','generalUser:mc',18,'2018-04-25 09:15:58','普通用户组'),('ecb636a2-04cf-4ed6-a54f-65c5d24a5411','菜单查询','','2018-04-18 14:47:57','menu','menu:r',14,'2018-04-18 15:14:15','菜单组'),('ed3dae4b-76d8-4f51-baab-fd5d0e233901','用户删除','','2018-04-18 14:46:42','user','user:ud',13,'2018-04-18 14:47:57','用户组'),('eda91a2c-29ba-4872-abf6-946037f58abe','自评问件查看','','2018-04-22 12:50:29','rater','rater:mr',17,'2018-04-23 10:57:27','自评文件组'),('edf941f0-3ca4-4f50-8f3c-2c6cbab82ca0','角色查询','','2018-04-22 10:53:24','role','role:rr',16,'2018-04-22 12:50:28','角色组'),('ee36d1c0-fa1b-45dd-b629-261b8198c4c3','部门添加','','2018-04-23 10:57:28','department','department:mc',18,'2018-04-25 09:15:58','部门组'),('ee4a41e4-1144-4866-9e2d-86b2f2e27548','普通用户添加','','2018-04-18 14:39:02','generalUser','generalUser:mc',11,'2018-04-18 14:41:24','普通用户组'),('ee86f476-6643-4c44-a2d0-fb858f86d37c','菜单更新','','2018-04-18 13:00:26','menu','menu:mu',10,'2018-04-18 14:39:02','菜单组'),('eeb2d8cc-97da-4d09-bb00-2342586e98ec','分数添加','','2018-04-22 10:53:24','score','score:mc',16,'2018-04-22 12:50:28','分数组'),('eee9a962-8dc1-44c8-ba3b-4bd1e294daae','角色添加','','2018-04-18 12:54:28','role','role:ra',9,'2018-04-18 13:00:26','角色组'),('eef53ce7-d5d4-4095-9ebf-1e027c943495','菜单更新','','2018-04-18 12:47:25','menu','menu:mu',8,'2018-04-18 12:54:28','菜单组'),('ef8a1dae-77ef-4eb6-95cf-4ca060b54c7d','支撑问件查看','','2018-04-22 10:53:24','support','support:mr',16,'2018-04-22 12:50:28','支撑文件组'),('efec3f77-a077-47a5-b31b-44922c0f6168','普通用户添加','','2018-04-18 13:00:26','generalUser','generalUser:mc',10,'2018-04-18 14:39:02','普通用户组'),('f06252aa-b91b-4d2e-ae0b-7dfd81fe4bb0','角色详细查询','','2018-04-22 12:50:29','role','role:rv',17,'2018-04-23 10:57:27','角色组'),('f0b343f5-dbee-419b-9265-07420c4aabb8','普通用户详细','','2018-04-18 14:41:24','generalUser','generalUser:md',12,'2018-04-18 14:46:42','普通用户组'),('f0e9a637-526f-436c-b61d-7ca546dc9204','评审用户删除','','2018-04-23 10:57:28','frontUser','raterUser:md',18,'2018-04-25 09:15:58','普通用户组'),('f19f7ce5-dd3c-44f4-a92e-e08cf6c6f460','用户详细','','2018-04-22 10:53:24','user','user:ud',16,'2018-04-22 12:50:28','用户组'),('f222aae7-33a2-40a6-9568-6c695beeb1ba','角色删除','','2018-04-18 12:54:28','role','role:rd',9,'2018-04-18 13:00:26','角色组'),('f225fe9c-c0ea-4675-88a5-529615bc29bf','普通用户查看','','2018-04-18 14:39:02','generalUser','generalUser:mr',11,'2018-04-18 14:41:24','普通用户组'),('f2882626-eac7-4b7d-9bb1-9ee9e81570ed','支撑问件删除','','2018-04-22 10:53:24','support','support:md',16,'2018-04-22 12:50:28','支撑文件组'),('f2b834ba-db6b-4594-afa9-c1d866722696','问题编辑','','2018-04-23 10:57:28','problem','problem:mu',18,'2018-04-25 09:15:58','问题组'),('f319ac90-25a9-4a93-ab2d-397f1022c2ca','所有权限查询','','2018-04-18 14:41:24','permission','permission:apr',12,'2018-04-18 14:46:42','权限组'),('f4f4daf8-308b-4077-a1fb-45a7f634cc99','角色查询','','2018-04-23 10:57:28','role','role:rr',18,'2018-04-25 09:15:58','角色组'),('f4fc491f-d7a2-4c68-bdbf-a8f46aa89aa2','用户详细','','2018-04-18 14:39:02','user','user:ud',11,'2018-04-18 14:41:24','用户组'),('f50e35a0-3d02-425c-bd77-c490eefdfdab','菜单查询','','2018-04-18 12:54:28','menu','menu:r',9,'2018-04-18 13:00:26','菜单组'),('f53292a5-0b41-43e8-9774-21552402980d','支撑问件删除','','2018-04-22 12:50:29','support','support:md',17,'2018-04-23 10:57:27','支撑文件组'),('f558acaa-cbd6-4b4a-9fb6-8f4c1367512c','问题查看','','2018-04-22 12:50:29','problem','problem:mr',17,'2018-04-23 10:57:27','问题组'),('f63efd23-a23b-455c-aebc-8d1ca240c2a4','角色权限查询','','2018-04-18 12:54:28','role','role:rqr',9,'2018-04-18 13:00:26','权限'),('f99b67a2-cfeb-4474-8a82-2b8e624fed53','独立菜单查询','','2018-04-18 14:39:02','menu','menu:amr',11,'2018-04-18 14:41:24','菜单组'),('f9bc9241-5241-4237-981b-190377974c23','全部子菜单查询','','2018-04-22 10:53:24','menu','menu:acmr',16,'2018-04-22 12:50:28','菜单组'),('fb7346fa-b7b1-4b6d-aadd-09583f8dda4f','自评问件删除','','2018-04-25 09:15:58','rater','rater:md',19,'2018-04-25 09:16:27','自评文件组'),('fbec2a16-68cb-4553-abb0-4f9869af876a','牵头部门添加','','2018-04-23 10:57:28','supportFile','leadDepartment:fc',18,'2018-04-25 09:15:58','牵头部门管理组'),('fbf5df02-0527-4a09-9a43-de83f5f9440e','自评问件查看','','2018-04-25 09:15:58','rater','rater:mr',19,'2018-04-25 09:16:27','自评文件组'),('fc297e47-8db7-4a9c-abf6-608ea432c2f4','角色详细查询','','2018-04-18 13:00:26','role','role:rv',10,'2018-04-18 14:39:02','角色组'),('fc7c4245-4808-4ad3-a40b-422fa76a7139','普通用户详细','','2018-04-18 14:39:02','generalUser','generalUser:md',11,'2018-04-18 14:41:24','普通用户组'),('fc9565c0-8ed1-4b01-9266-27191c7afba2','评审用户删除','','2018-04-22 12:50:29','frontUser','raterUser:md',17,'2018-04-23 10:57:27','普通用户组'),('fcbe3240-4fc0-4f56-bcdc-8e71829749be','角色编辑','','2018-04-18 12:54:28','role','role:ru',9,'2018-04-18 13:00:26','角色组'),('fe74287e-173a-4a7d-a639-5dc78e1d4cf3','角色添加','','2018-04-22 10:53:24','role','role:ra',16,'2018-04-22 12:50:28','角色组'),('ff906e52-37ea-4886-b9fe-b8d5571bac32','所有权限查询','','2018-04-18 15:14:15','permission','permission:apr',15,'2018-04-22 10:53:24','权限组'),('ffe4c3e5-79b6-4bb1-bce6-cc7b986ef405','菜单删除','','2018-04-18 14:46:42','menu','menu:md',13,'2018-04-18 14:47:57','菜单组'),('ffeb0556-5840-45dc-a1d0-9af587d30f12','角色详细查询','','2018-04-18 14:47:57','role','role:rv',14,'2018-04-18 15:14:15','角色组'),('ffef3000-5afa-491d-819f-7890426bb485','菜单删除','','2018-04-18 15:14:15','menu','menu:md',15,'2018-04-22 10:53:24','菜单组');
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
INSERT INTO `bak_role` VALUES ('01660490-48bf-42cd-9662-5f987d039c29','普通用户管理角色','','2018-04-25 09:15:57','generalUser','generalUser:m',19,'2018-04-25 09:16:27'),('042227e0-8a06-4803-9633-664da866ca5c','用户管理角色','','2018-04-18 12:47:25','system','user:m',8,'2018-04-18 12:54:28'),('0704c282-b296-4ee1-9836-67037215ccf5','角色管理角色','','2018-04-02 08:43:52','basicInfo','role:m',2,'2018-04-02 08:49:21'),('09c00ccf-e2b1-4257-b507-15525adab8a1','菜单管理角色','','2018-04-18 14:39:02','system','menu:m',11,'2018-04-18 14:41:24'),('0b627c8d-530e-43cc-8068-f3149c8d9b55','系统配置','','2018-04-25 09:15:57','config','config:m',19,'2018-04-25 09:16:27'),('0be3d3d9-35fe-4d7a-9734-63e397f9ffd0','普通用户管理角色','','2018-04-18 15:14:15','generalUser','generalUser:m',15,'2018-04-22 10:53:24'),('0c1807bc-36a7-4926-bf80-f9234d90c3f1','问题管理','','2018-04-25 09:15:57','problem','problem:m',19,'2018-04-25 09:16:27'),('0c33d14a-3645-4547-9384-a7281e41a777','菜单管理角色','','2018-04-08 12:21:55','system','menu:m',5,'2018-04-09 08:42:04'),('137568e8-5f3b-414c-b6cb-278a68b4de25','系统配置','','2018-04-22 12:50:28','config','config:m',17,'2018-04-23 10:57:27'),('13f1991f-77b1-48ec-aa56-cef5ca8d713e','系统配置','','2018-04-23 10:57:27','config','config:m',18,'2018-04-25 09:15:57'),('13f88ef3-2753-4741-b484-043e138eee7a','普通用户管理角色','','2018-04-23 10:57:27','generalUser','generalUser:m',18,'2018-04-25 09:15:57'),('1cbceea6-0521-4734-9140-c5f046cc362b','权限管理角色','','2018-04-23 10:57:27','system','permission:m',18,'2018-04-25 09:15:57'),('1e1968fb-a2ad-41eb-80f5-e2ef3bee0f8b','UI管理角色','','2018-04-18 14:41:24','system','ui:m',12,'2018-04-18 14:46:42'),('1f90a625-1875-433e-92f4-4b1bcb65865e','权限管理角色','','2018-04-18 13:00:26','system','permission:m',10,'2018-04-18 14:39:02'),('23c10400-0964-48f3-a074-f96e32ef66b2','菜单管理角色','','2018-04-09 08:42:04','system','menu:m',6,'2018-04-09 09:57:14'),('25a417bf-a385-472d-9edf-11e5ec01c0f7','测试角色','','2018-04-10 09:21:11','system','ceshi:m',7,'2018-04-18 12:47:25'),('261e90a8-a734-44b3-9343-78767eaa2ffe','普通用户管理角色','','2018-04-18 14:39:02','generalUser','generalUser:m',11,'2018-04-18 14:41:24'),('28416e1e-cb49-4947-9e65-c99065632bdf','权限管理角色','','2018-04-22 10:53:24','system','permission:m',16,'2018-04-22 12:50:28'),('2c0f548e-44e4-44f0-b652-f80ec6d0b51f','权限管理角色','','2018-04-02 08:43:52','basicInfo','permission:m',2,'2018-04-02 08:49:21'),('2ead83ed-3d85-41a0-bc45-f412771b4bba','权限管理角色','','2018-04-02 08:49:21','basicInfo','permission:m',3,'2018-04-02 12:47:29'),('31c1a827-3c07-45cf-a871-1d576bfa8fe9','系统配置','','2018-04-22 10:53:24','config','config:m',16,'2018-04-22 12:50:28'),('33e1abbd-7ddd-4c8b-b9aa-9d4db86b8aa6','角色管理角色','','2018-04-18 14:41:24','system','role:m',12,'2018-04-18 14:46:42'),('340e430c-1f7d-4a30-9127-16a56a073d6a','问题管理','','2018-04-22 10:53:24','problem','problem:m',16,'2018-04-22 12:50:28'),('3514b79a-a452-46c1-954c-a32202d81e68','用户管理角色','','2018-04-18 12:54:28','system','user:m',9,'2018-04-18 13:00:26'),('35af2c70-3a91-4960-871b-f1a19e94f301','问题管理','','2018-04-22 12:50:28','problem','problem:m',17,'2018-04-23 10:57:27'),('36764ad8-404c-41fd-b24e-6a554fb0a6e7','权限管理角色','','2018-04-18 12:54:28','system','permission:m',9,'2018-04-18 13:00:26'),('369d147b-66c5-4cbf-b0f0-459f3929dcba','权限管理角色','','2018-04-02 12:47:29','basicInfo','permission:m',4,'2018-04-08 12:21:55'),('39080c11-de3f-4264-b082-ce43b75947f7','菜单管理角色','','2018-04-25 09:15:57','system','menu:m',19,'2018-04-25 09:16:27'),('3941f89d-64e9-4e41-9b53-59a550f2843f','问题管理','','2018-04-25 09:15:57','problem','problem:m',19,'2018-04-25 09:16:27'),('3a0222a8-3db9-4646-83d2-d0d0adee348c','牵头部门管理','','2018-04-23 10:57:27','supportFile','dutyDepartment:f',18,'2018-04-25 09:15:57'),('3c9668ac-0613-488f-9642-464717b0f096','权限管理角色','','2018-04-18 14:47:57','system','permission:m',14,'2018-04-18 15:14:15'),('3dab3cbe-b79c-4a98-9e8c-b13f804dbfa6','审核要点管理','','2018-04-25 09:15:57','supportFile','point:f',19,'2018-04-25 09:16:27'),('3f52dfd6-d116-498e-93e4-3bd76a0091b7','系统配置','','2018-04-23 10:57:27','config','config:m',18,'2018-04-25 09:15:57'),('3fe00873-391e-4511-a200-e02bf0d35597','文件管理','','2018-04-22 10:53:24','file','file:m',16,'2018-04-22 12:50:28'),('40a75cd9-4887-4cae-9f79-c645f6bd1d51','菜单管理角色','','2018-04-23 10:57:27','system','menu:m',18,'2018-04-25 09:15:57'),('40e418de-1163-4742-a20a-2f6c4f29a851','权限管理角色','','2018-04-22 12:50:28','system','permission:m',17,'2018-04-23 10:57:27'),('415d88f9-48cb-4e69-ba66-323b397289fa','审核要素管理','','2018-04-25 09:15:57','supportFile','element:f',19,'2018-04-25 09:16:27'),('4263a156-b3ba-4dc5-af36-f4c7b583913a','文件管理','','2018-04-25 09:15:57','file','file:m',19,'2018-04-25 09:16:27'),('426c98be-55ae-4fbb-8ff3-0fb06dc9b26c','用户管理角色','','2018-04-18 14:41:24','system','user:m',12,'2018-04-18 14:46:42'),('45969921-2b30-4b0c-8b93-d950a3178304','角色管理角色','','2018-04-18 13:00:26','system','role:m',10,'2018-04-18 14:39:02'),('4c4735cc-e3eb-454f-8dc2-e0707e19247a','菜单管理角色','','2018-04-09 09:57:14','system','menu:m',7,'2018-04-18 12:47:25'),('4ca01a40-15ad-4950-80ad-6d4af996e0bd','用户管理角色','','2018-04-18 14:39:02','system','user:m',11,'2018-04-18 14:41:24'),('4ee677b1-3142-4e49-895b-5316e634436d','角色管理角色','','2018-04-25 09:15:57','system','role:m',19,'2018-04-25 09:16:27'),('4fabdf3f-2832-43f7-8180-7c722cede49b','菜单管理角色','','2018-04-18 15:14:15','system','menu:m',15,'2018-04-22 10:53:24'),('52ff4225-3b21-410a-b3d4-23bab9538f55','牵头部门管理','','2018-04-25 09:15:57','supportFile','leadDepartment:f',19,'2018-04-25 09:16:27'),('5a19dd9a-1ee2-4bae-96ad-abe6cba25ee9','角色管理角色','','2018-04-22 10:53:24','system','role:m',16,'2018-04-22 12:50:28'),('5ab46aa4-e4a5-45a7-970f-d55c72f1f24b','文件管理','','2018-04-22 10:53:24','file','file:m',16,'2018-04-22 12:50:28'),('649fa7c5-ada6-4bb7-b4b5-169339a2bcea','牵头部门管理','','2018-04-23 10:57:27','supportFile','leadDepartment:f',18,'2018-04-25 09:15:57'),('67344416-1f82-40e1-b7d0-ec590de2143e','权限管理角色','','2018-04-18 12:47:25','system','permission:m',8,'2018-04-18 12:54:28'),('67598238-302b-4453-8536-af286ce9212d','系统配置','','2018-04-22 12:50:28','config','config:m',17,'2018-04-23 10:57:27'),('677dd847-f0c9-49fe-b9c6-ef7e59c0e2f1','用户管理角色','','2018-04-22 12:50:28','system','user:m',17,'2018-04-23 10:57:27'),('691e6ab6-d4ad-4b37-968b-224fe7caf030','文件管理','','2018-04-22 12:50:28','file','file:m',17,'2018-04-23 10:57:27'),('6b040b19-00e7-4eaf-81ee-c6b14fd641fd','角色管理角色','','2018-04-18 14:47:57','system','role:m',14,'2018-04-18 15:14:15'),('6cf93436-b496-4d5f-8ff5-2f4b768b4ba1','角色管理角色','','2018-04-02 08:31:14','basicInfo','role:m',1,'2018-04-02 08:43:52'),('71ceb8e9-3fa2-4bb1-a242-734c3c5879fb','权限管理角色','','2018-04-09 09:57:14','system','permission:m',7,'2018-04-18 12:47:25'),('7256b544-9b10-44e4-8da7-f75bbe521fd7','UI管理角色','','2018-04-18 12:54:28','system','ui:m',9,'2018-04-18 13:00:26'),('72da550d-f8b5-4d7d-84b7-1c140a28c657','角色管理角色','','2018-04-18 12:47:25','system','role:m',8,'2018-04-18 12:54:28'),('7436545c-fef9-451a-aaf6-fb6e3b40d35c','问题管理','','2018-04-23 10:57:27','problem','problem:m',18,'2018-04-25 09:15:57'),('7670f236-6656-4c10-b04f-6083cecf88de','权限管理角色','','2018-04-18 14:39:02','system','permission:m',11,'2018-04-18 14:41:24'),('7eef6108-c7a5-40a6-bdec-cc4ba37df8b6','问题管理','','2018-04-25 09:15:57','problem','problem:m',19,'2018-04-25 09:16:27'),('848b435f-9323-4a15-9846-688579c5b81c','系统配置','','2018-04-22 10:53:24','config','config:m',16,'2018-04-22 12:50:28'),('85260f50-ec5e-4a49-857e-dbba1ed6df01','问题管理','','2018-04-23 10:57:27','problem','problem:m',18,'2018-04-25 09:15:57'),('852636cd-95e1-4f46-bf21-f722850b9942','用户管理角色','','2018-04-22 10:53:24','system','user:m',16,'2018-04-22 12:50:28'),('890a46f4-342e-42c0-b333-203e16ddc172','UI管理角色','','2018-04-18 12:47:25','system','ui:m',8,'2018-04-18 12:54:28'),('8a17b371-d60e-4d88-912b-c4fafb3238f5','用户管理角色','','2018-04-23 10:57:27','system','user:m',18,'2018-04-25 09:15:57'),('8a278e49-d06d-422b-be0f-d9a4da305dc3','角色管理角色','','2018-04-18 14:46:42','system','role:m',13,'2018-04-18 14:47:57'),('8aafd071-0d36-4b7f-b1b2-0e4a2f3bdec7','UI管理角色','','2018-04-18 14:39:02','system','ui:m',11,'2018-04-18 14:41:24'),('8daf17cd-b929-498c-8999-eae024ad5c82','UI管理角色','','2018-04-22 12:50:28','system','ui:m',17,'2018-04-23 10:57:27'),('8ed8bba9-4969-427c-9dd7-23af610ca8ff','UI管理角色','','2018-04-18 14:47:57','system','ui:m',14,'2018-04-18 15:14:15'),('916e8e73-413a-4790-9a24-79c1255877e6','角色管理角色','','2018-04-23 10:57:27','system','role:m',18,'2018-04-25 09:15:57'),('944511cf-816c-43ff-83f2-082cf1aa3b65','审查要素管理','','2018-04-23 10:57:27','supportFile','element:f',18,'2018-04-25 09:15:57'),('9592bde5-461d-466a-b61f-7c64beca4d72','评审用户管理角色','','2018-04-23 10:57:27','frontUser','raterUser:m',18,'2018-04-25 09:15:57'),('968f473e-2177-4189-a044-22a6d4e462da','用户管理角色','','2018-04-18 15:14:15','system','user:m',15,'2018-04-22 10:53:24'),('96bae410-5e99-46a6-a6ea-20dd92e700dc','角色管理角色','','2018-04-08 12:21:55','basicInfo','role:m',5,'2018-04-09 08:42:04'),('97ceb759-92b5-4ee7-a912-d5c1b7d08921','问题管理','','2018-04-22 10:53:24','problem','problem:m',16,'2018-04-22 12:50:28'),('990c465a-d879-4807-bf37-47c6d8ce7370','审核项目管理','','2018-04-25 09:15:57','supportFile','element:f',19,'2018-04-25 09:16:27'),('99b9c130-5665-4fd3-8bd6-922ed5677e2e','角色管理角色','','2018-04-02 12:47:29','basicInfo','role:m',4,'2018-04-08 12:21:55'),('9c584c65-c384-444f-8aaf-b951fcc4660a','菜单管理角色','','2018-04-18 14:47:57','system','menu:m',14,'2018-04-18 15:14:15'),('9eb88420-9642-46da-83ac-8f844797d1d3','权限管理角色','','2018-04-18 14:46:42','system','permission:m',13,'2018-04-18 14:47:57'),('9f6cc117-4aa4-4769-86ee-5ffd486ab941','角色管理角色','','2018-04-18 14:39:02','system','role:m',11,'2018-04-18 14:41:24'),('a0b485da-4d93-45a6-acd0-51ff0c7a9050','审核项目管理','','2018-04-23 10:57:27','supportFile','element:f',18,'2018-04-25 09:15:57'),('a1cb3db6-1aab-410d-9585-c62a90447bfd','审查要点管理','','2018-04-23 10:57:27','supportFile','point:f',18,'2018-04-25 09:15:57'),('a5339017-6e8e-4568-946d-a359eb80ae9a','文件管理','','2018-04-25 09:15:57','file','file:m',19,'2018-04-25 09:16:27'),('a7e61abe-2e0d-4da7-a153-f29b427fd9db','角色管理角色','','2018-04-02 08:49:21','basicInfo','role:m',3,'2018-04-02 12:47:29'),('ab7bdee5-33bc-4471-83a5-c69c78358915','菜单管理角色','','2018-04-18 13:00:26','system','menu:m',10,'2018-04-18 14:39:02'),('b1208424-e4b4-4289-bbb4-bb93b69e362d','菜单管理角色','','2018-04-18 12:54:28','system','menu:m',9,'2018-04-18 13:00:26'),('b1d577fd-7d27-4598-82f3-bc9cbeb9361d','用户管理角色','','2018-04-18 14:47:57','system','user:m',14,'2018-04-18 15:14:15'),('b3cf235d-944f-4206-9caa-0e4ca70d4173','问题管理','','2018-04-23 10:57:27','problem','problem:m',18,'2018-04-25 09:15:57'),('b51d5f5b-76ff-49a0-ab2a-bf3720938afd','评审用户管理角色','','2018-04-22 12:50:28','frontUser','raterUser:m',17,'2018-04-23 10:57:27'),('b74d4bfb-c37b-43ef-b959-c4c8daf9b7b9','牵头部门管理','','2018-04-25 09:15:57','supportFile','dutyDepartment:f',19,'2018-04-25 09:16:27'),('b997a487-294c-4b25-a760-6116f42b737e','系统配置','','2018-04-25 09:15:57','config','config:m',19,'2018-04-25 09:16:27'),('bb24d83b-e3ae-459f-95dc-37929ffd1be1','UI管理角色','','2018-04-22 10:53:24','system','ui:m',16,'2018-04-22 12:50:28'),('c1098bbf-5b2b-4dcd-85d3-d51836025e2a','权限管理角色','','2018-04-08 12:21:55','system','permission:m',5,'2018-04-09 08:42:04'),('c13cba65-5cd8-4a70-a89d-142806d4b4ce','文件管理','','2018-04-23 10:57:27','file','file:m',18,'2018-04-25 09:15:57'),('c2854af8-6792-4f66-8247-f24ecf40b505','菜单管理角色','','2018-04-18 12:47:25','system','menu:m',8,'2018-04-18 12:54:28'),('c2b77595-eef6-4859-b659-0ece71a28f3b','评审用户管理角色','','2018-04-22 10:53:24','frontUser','raterUser:m',16,'2018-04-22 12:50:28'),('c2edb177-dd5c-4805-9fed-cc4d30717c77','问题管理','','2018-04-25 09:15:57','problem','problem:m',19,'2018-04-25 09:16:27'),('c30515a2-99aa-4cfb-a4fe-8c1bce3e538f','UI管理角色','','2018-04-18 15:14:15','system','ui:m',15,'2018-04-22 10:53:24'),('c39c8204-2916-4efc-8170-3af68b836043','普通用户管理角色','','2018-04-18 14:47:57','generalUser','generalUser:m',14,'2018-04-18 15:14:15'),('c3c297ad-d6be-4025-b844-2323233b8aca','权限管理角色','','2018-04-18 14:41:24','system','permission:m',12,'2018-04-18 14:46:42'),('c4344121-2f87-4360-9f66-44c8b0011d25','普通用户管理角色','','2018-04-18 14:41:24','generalUser','generalUser:m',12,'2018-04-18 14:46:42'),('c701d6cf-6027-46d0-aeec-864004054f4c','菜单管理角色','','2018-04-18 14:46:42','system','menu:m',13,'2018-04-18 14:47:57'),('c7ae191a-e0cf-4fc8-bdcf-9062363c3f60','UI管理角色','','2018-04-23 10:57:27','system','ui:m',18,'2018-04-25 09:15:57'),('cb114af1-ae62-4c56-b4fe-bb83e7626d11','菜单管理角色','','2018-04-18 14:41:24','system','menu:m',12,'2018-04-18 14:46:42'),('cdfebf1b-3a5f-4a2b-a08a-9f7e1b777ae2','角色管理角色','','2018-04-18 15:14:15','system','role:m',15,'2018-04-22 10:53:24'),('ce676dc6-6471-4fde-88af-deb7402b372e','测试角色','','2018-04-18 12:57:37','ceshi','ceshi:m',9,'2018-04-18 13:00:26'),('cff8f11d-f144-477a-a441-26618fc1ea53','权限管理角色','','2018-04-09 08:42:04','system','permission:m',6,'2018-04-09 09:57:14'),('d0569805-0957-4a3f-927c-0863054bf915','权限管理角色','','2018-04-18 15:14:15','system','permission:m',15,'2018-04-22 10:53:24'),('d171c768-e290-4efc-af27-46a526770d09','权限管理角色','','2018-04-25 09:15:57','system','permission:m',19,'2018-04-25 09:16:27'),('d3ac12af-66f4-44d5-bdbc-a64bb7380a9d','用户管理角色','','2018-04-25 09:15:57','system','user:m',19,'2018-04-25 09:16:27'),('d616a0cf-61bd-4a79-a973-93d97155e87d','角色管理角色','','2018-04-22 12:50:28','system','role:m',17,'2018-04-23 10:57:27'),('dd1540bf-6714-4d35-aa35-73da1613e1ac','角色管理角色','','2018-04-09 09:57:14','basicInfo','role:m',7,'2018-04-18 12:47:25'),('df271ed2-6eb0-4115-b3b5-1ffbdb3b3aa9','角色管理角色','','2018-04-18 12:54:28','system','role:m',9,'2018-04-18 13:00:26'),('e3614661-c413-4dce-9a5e-0850bcf375a1','用户管理角色','','2018-04-18 13:00:26','system','user:m',10,'2018-04-18 14:39:02'),('e3dc2c98-03f9-46fc-8b0d-ea4133edb32f','普通用户管理角色','','2018-04-18 14:46:42','generalUser','generalUser:m',13,'2018-04-18 14:47:57'),('e4d6478e-1757-4a1c-8fc7-016171a0da76','普通用户管理角色','','2018-04-22 10:53:24','generalUser','generalUser:m',16,'2018-04-22 12:50:28'),('e61f345d-868b-4a0e-94eb-bd11b7de8262','普通用户管理角色','','2018-04-18 13:00:26','generalUser','generalUser:m',10,'2018-04-18 14:39:02'),('e709f668-5fe5-457f-84ee-1a6640888cfc','菜单管理角色','','2018-04-22 10:53:24','system','menu:m',16,'2018-04-22 12:50:28'),('e7bd1bd7-c2bc-40aa-851f-9740d4bd68c4','问题管理','','2018-04-22 12:50:28','problem','problem:m',17,'2018-04-23 10:57:27'),('e98eed49-fca7-45ba-9109-814f542859b4','问题管理','','2018-04-22 10:53:24','problem','problem:m',16,'2018-04-22 12:50:28'),('eb0566de-29c4-4a8c-a01f-4178ad9dffcf','角色管理角色','','2018-04-09 08:42:04','basicInfo','role:m',6,'2018-04-09 09:57:14'),('ebc852ca-557a-41c2-96f2-a610d800c534','评审用户管理角色','','2018-04-25 09:15:57','frontUser','raterUser:m',19,'2018-04-25 09:16:27'),('ee574b78-7ecd-47b2-a914-7a01df06a12c','问题管理','','2018-04-22 12:50:28','problem','problem:m',17,'2018-04-23 10:57:27'),('ee70c943-c53e-4750-8049-cffdd13cfbb1','UI管理角色','','2018-04-18 14:46:42','system','ui:m',13,'2018-04-18 14:47:57'),('efb5fb02-f7be-4162-9a4c-389821181136','文件管理','','2018-04-23 10:57:27','file','file:m',18,'2018-04-25 09:15:57'),('f56aeff9-c93b-4efa-9fab-41a7ef6839ba','用户管理角色','','2018-04-18 14:46:42','system','user:m',13,'2018-04-18 14:47:57'),('f5dd06ed-c00b-41bb-95ec-c88a6c83fa31','问题管理','','2018-04-22 10:53:24','problem','problem:m',16,'2018-04-22 12:50:28'),('f61da50b-34c9-4af3-89ee-abf0827f245b','普通用户管理角色','','2018-04-22 12:50:28','generalUser','generalUser:m',17,'2018-04-23 10:57:27'),('f80ba8e0-5ce6-4a79-b349-ca69d825bf62','文件管理','','2018-04-22 12:50:28','file','file:m',17,'2018-04-23 10:57:27'),('f968e0dd-75e2-458b-bacd-4b0b0e9f0521','菜单管理角色','','2018-04-22 12:50:28','system','menu:m',17,'2018-04-23 10:57:27'),('f9b8ad9b-2085-4fc6-a326-4cd702902cd8','问题管理','','2018-04-23 10:57:27','problem','problem:m',18,'2018-04-25 09:15:57'),('fcf6ef44-f7cf-406f-aedb-08167b264d60','UI管理角色','','2018-04-18 13:00:26','system','ui:m',10,'2018-04-18 14:39:02'),('feca5193-b97c-4882-a051-bb96e7769c8e','权限管理角色','','2018-04-02 08:31:14','basicInfo','permission:m',1,'2018-04-02 08:43:52'),('ff5dc773-ac9d-41b9-84b1-591591239ebb','问题管理','','2018-04-22 12:50:28','problem','problem:m',17,'2018-04-23 10:57:27'),('ff79e47e-2920-43b2-8318-b959da317ca1','普通用户管理角色','','2018-04-18 12:54:28','generalUser','generalUser:m',9,'2018-04-18 13:00:26'),('fff0e789-8fe6-4444-a96d-e5d713669e00','UI管理角色','','2018-04-25 09:15:57','system','ui:m',19,'2018-04-25 09:16:27');
/*!40000 ALTER TABLE `bak_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pinggu_college_structure_college`
--

DROP TABLE IF EXISTS `pinggu_college_structure_college`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pinggu_college_structure_college` (
  `collegeId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `collegeName` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `createUserId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleteFlag` tinyint(2) NOT NULL DEFAULT '0',
  `lockFlag` tinyint(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`collegeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='院系材料中的学院表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinggu_college_structure_college`
--

LOCK TABLES `pinggu_college_structure_college` WRITE;
/*!40000 ALTER TABLE `pinggu_college_structure_college` DISABLE KEYS */;
INSERT INTO `pinggu_college_structure_college` VALUES ('7d7c2258-eccf-414c-a263-2de7806aab23','机械工程学院','0','2018-05-15 13:59:57',0,0);
/*!40000 ALTER TABLE `pinggu_college_structure_college` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pinggu_college_structure_discipline`
--

DROP TABLE IF EXISTS `pinggu_college_structure_discipline`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pinggu_college_structure_discipline` (
  `disciplineId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `disciplineName` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `collegeId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleteFlag` tinyint(2) NOT NULL DEFAULT '0',
  `lockFlag` tinyint(2) NOT NULL DEFAULT '0',
  `createUserId` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '操作人员Id',
  PRIMARY KEY (`disciplineId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='院系材料中的专业表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinggu_college_structure_discipline`
--

LOCK TABLES `pinggu_college_structure_discipline` WRITE;
/*!40000 ALTER TABLE `pinggu_college_structure_discipline` DISABLE KEYS */;
INSERT INTO `pinggu_college_structure_discipline` VALUES ('1b6d042f-fe59-4f72-a362-753e98067056','机械工程','7d7c2258-eccf-414c-a263-2de7806aab23','2018-05-15 14:04:54',0,0,'0'),('dd65ee22-05f3-40d3-9d23-3cabd22a1e78','工业工程','7d7c2258-eccf-414c-a263-2de7806aab23','2018-05-15 14:05:13',0,0,'0');
/*!40000 ALTER TABLE `pinggu_college_structure_discipline` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pinggu_college_structure_file`
--

DROP TABLE IF EXISTS `pinggu_college_structure_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pinggu_college_structure_file` (
  `paperFileId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `paperId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `subjectId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `disciplineId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `collegeId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `userId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `fileTypeFlag` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '格式标识 用字符串存储 PDF等',
  `paperFileCreateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `paperFileName` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `paperFileDBName` varchar(225) COLLATE utf8_unicode_ci NOT NULL,
  `paperFilePath` varchar(1000) COLLATE utf8_unicode_ci NOT NULL,
  `deleteFlag` tinyint(4) NOT NULL DEFAULT '0',
  `paperFileRemark` varchar(1000) COLLATE utf8_unicode_ci NOT NULL COMMENT '文件备注',
  PRIMARY KEY (`paperFileId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='试卷文件表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinggu_college_structure_file`
--

LOCK TABLES `pinggu_college_structure_file` WRITE;
/*!40000 ALTER TABLE `pinggu_college_structure_file` DISABLE KEYS */;
/*!40000 ALTER TABLE `pinggu_college_structure_file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pinggu_college_structure_file_archive`
--

DROP TABLE IF EXISTS `pinggu_college_structure_file_archive`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pinggu_college_structure_file_archive` (
  `paperFileArchiveId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `archiveUserId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '归档人Id',
  `paperArchiveTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '归档时间',
  `paperFileName` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '文件名',
  `paperFileDBName` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `paperFilePath` varchar(1000) COLLATE utf8_unicode_ci NOT NULL,
  `paperFileReadNum` int(11) NOT NULL COMMENT '文件阅读次数',
  `uploadUserId` varchar(45) COLLATE utf8_unicode_ci NOT NULL COMMENT '文件上传人Id',
  `uploadTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `archiveFilePath` varchar(1000) COLLATE utf8_unicode_ci NOT NULL COMMENT '归档文件路径',
  `paperFileId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '试卷文件Id与pinggu_college_structure_file关联',
  PRIMARY KEY (`paperFileArchiveId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='试卷文件归档表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinggu_college_structure_file_archive`
--

LOCK TABLES `pinggu_college_structure_file_archive` WRITE;
/*!40000 ALTER TABLE `pinggu_college_structure_file_archive` DISABLE KEYS */;
/*!40000 ALTER TABLE `pinggu_college_structure_file_archive` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pinggu_college_structure_file_modify`
--

DROP TABLE IF EXISTS `pinggu_college_structure_file_modify`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pinggu_college_structure_file_modify` (
  `paperFileModifyId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `userId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '修改人Id',
  `paperFileId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '归档文件Id',
  `paperFileModifyTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `paperArchiveId` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT '归档文件ID 0:添加文件',
  `modifyFlag` int(11) NOT NULL DEFAULT '0' COMMENT '修改标识：0为修改，1为删除',
  PRIMARY KEY (`paperFileModifyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='试卷文件修改表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinggu_college_structure_file_modify`
--

LOCK TABLES `pinggu_college_structure_file_modify` WRITE;
/*!40000 ALTER TABLE `pinggu_college_structure_file_modify` DISABLE KEYS */;
/*!40000 ALTER TABLE `pinggu_college_structure_file_modify` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pinggu_college_structure_file_person_record`
--

DROP TABLE IF EXISTS `pinggu_college_structure_file_person_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pinggu_college_structure_file_person_record` (
  `paperFileReadPersonId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `userId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '阅读人Id',
  `paperPersonReadTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '阅读时间',
  `readPaperFileId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '阅读文件Id',
  `userType` tinyint(4) NOT NULL COMMENT '阅读人类型标识：评审人1  普通用户0',
  PRIMARY KEY (`paperFileReadPersonId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='试卷文件阅读人记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinggu_college_structure_file_person_record`
--

LOCK TABLES `pinggu_college_structure_file_person_record` WRITE;
/*!40000 ALTER TABLE `pinggu_college_structure_file_person_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `pinggu_college_structure_file_person_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pinggu_college_structure_file_read_record`
--

DROP TABLE IF EXISTS `pinggu_college_structure_file_read_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pinggu_college_structure_file_read_record` (
  `paperFileId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '试卷文件Id',
  `readPaperNumber` int(11) NOT NULL DEFAULT '0' COMMENT '阅读数',
  PRIMARY KEY (`paperFileId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='试卷文件阅读次数记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinggu_college_structure_file_read_record`
--

LOCK TABLES `pinggu_college_structure_file_read_record` WRITE;
/*!40000 ALTER TABLE `pinggu_college_structure_file_read_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `pinggu_college_structure_file_read_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pinggu_college_structure_paper`
--

DROP TABLE IF EXISTS `pinggu_college_structure_paper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pinggu_college_structure_paper` (
  `paperId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '院系材料第四结构的Id',
  `paperName` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '院系材料第四结构的名字',
  `paperCreateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '院系材料第四结构的创建时间',
  `createUserId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '院系材料第四结构的创建用户Id',
  `subjectId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '院系材料第三层的Id',
  `disciplineId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '院系材料第二层的Id',
  `collegeId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '院系材料第一层的Id',
  `deleteFlag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标识 0:未删除 1:删除',
  PRIMARY KEY (`paperId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='院系材料中的课程试卷表,第四级别';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinggu_college_structure_paper`
--

LOCK TABLES `pinggu_college_structure_paper` WRITE;
/*!40000 ALTER TABLE `pinggu_college_structure_paper` DISABLE KEYS */;
/*!40000 ALTER TABLE `pinggu_college_structure_paper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pinggu_college_structure_subject`
--

DROP TABLE IF EXISTS `pinggu_college_structure_subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pinggu_college_structure_subject` (
  `subjectId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `subjectName` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `disciplineId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `createUserId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleteFlag` tinyint(2) NOT NULL DEFAULT '0',
  `collegeId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`subjectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='院系材料中的课程表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinggu_college_structure_subject`
--

LOCK TABLES `pinggu_college_structure_subject` WRITE;
/*!40000 ALTER TABLE `pinggu_college_structure_subject` DISABLE KEYS */;
/*!40000 ALTER TABLE `pinggu_college_structure_subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pinggu_config`
--

DROP TABLE IF EXISTS `pinggu_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pinggu_config` (
  `configId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `configStartTime` date NOT NULL COMMENT '评审开始时间',
  `configEndTime` date NOT NULL COMMENT '评审结束时间',
  `configLevel` tinyint(4) NOT NULL COMMENT '可读级别:0为用户可读，1为部门可读',
  PRIMARY KEY (`configId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='配置信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinggu_config`
--

LOCK TABLES `pinggu_config` WRITE;
/*!40000 ALTER TABLE `pinggu_config` DISABLE KEYS */;
INSERT INTO `pinggu_config` VALUES ('0','2018-04-03','2018-04-20',0);
/*!40000 ALTER TABLE `pinggu_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pinggu_department`
--

DROP TABLE IF EXISTS `pinggu_department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pinggu_department` (
  `departmentId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `departmentName` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '部门名',
  `departmentCreateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '部门添加时间',
  `adminId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '关联admin表，部门添加人',
  `lockFlag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '锁标识 0为未加锁  1为加锁',
  PRIMARY KEY (`departmentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='部门表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinggu_department`
--

LOCK TABLES `pinggu_department` WRITE;
/*!40000 ALTER TABLE `pinggu_department` DISABLE KEYS */;
INSERT INTO `pinggu_department` VALUES ('2349a19d-cfc0-414b-81c9-a8cea3d2ca8a','机械工程学院','2018-04-25 10:26:00','0',0),('25a8b45a-c200-422e-804d-0b374e1052fd','材料科学与工程学院','2018-04-25 10:26:11','0',0),('3098974a-477d-43ed-9aeb-9c6eb1de068a','理学院','2018-04-27 06:19:11','0',0),('32dd00a4-d1d2-4fed-937b-ffdecdaa1153','创新创业教育学院','2018-05-04 02:28:50','0',0),('3943d920-8123-4383-9cca-2d80458df1f5','马克思主义学院','2018-05-04 02:26:37','0',0),('3ff7c049-9106-4adc-9ce7-5c0816e6af81','环境与化学工程学院','2018-04-27 06:18:16','0',0),('51b93036-9eba-490f-848c-9d516a0f4265','信息学院','2018-05-04 02:28:24','0',0),('5c2ace35-87bc-43fa-93b7-b3e3695de1f7','土木与安全工程学院','2018-04-27 06:18:25','0',0),('6f9ce374-eb8d-4121-8b38-9f0265e5e644','体育工作部','2018-05-04 02:27:03','0',0),('8c486753-4238-43e7-8884-184cf62c59dc','电气信息学院','2018-04-27 06:18:06','0',0),('bb7fd7fa-21ed-4f51-9c68-f3857b427564','爱恩国际学院','2018-05-04 02:26:15','0',0),('bf779712-a066-4ab7-a369-ff7ca1739c03','经济管理学院','2018-04-27 06:18:54','0',0),('ceeda756-4159-470d-999d-8ce711b9203e','交通运输工程学院','2018-04-27 06:17:55','0',0),('da4305af-343b-475f-bdb9-ed873f3d99c6','艺术学院','2018-04-27 06:19:02','0',0),('e2b45cf1-b76b-4029-8118-a29425136495','外国语学院','2018-05-04 02:25:26','0',0),('f38d0911-08ab-4694-9c8c-42d50bf0ed66','动车运用与维护工程学院','2018-04-27 06:18:44','0',0),('f3e479e9-164e-4820-aeff-170b2eb7c746','软件学院','2018-04-27 06:18:34','0',0);
/*!40000 ALTER TABLE `pinggu_department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pinggu_department_type`
--

DROP TABLE IF EXISTS `pinggu_department_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pinggu_department_type` (
  `departmentId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `typeId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`departmentId`,`typeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='部门和类别中间表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinggu_department_type`
--

LOCK TABLES `pinggu_department_type` WRITE;
/*!40000 ALTER TABLE `pinggu_department_type` DISABLE KEYS */;
INSERT INTO `pinggu_department_type` VALUES ('2349a19d-cfc0-414b-81c9-a8cea3d2ca8a','1ab91c71-7a71-4c62-b1da-8d9d8da71430'),('2349a19d-cfc0-414b-81c9-a8cea3d2ca8a','50ce4f9b-8448-4341-8921-a7db13d7c11b'),('2349a19d-cfc0-414b-81c9-a8cea3d2ca8a','6fa3bac1-b8dd-4fc4-bf7e-a53fba9804e0'),('2349a19d-cfc0-414b-81c9-a8cea3d2ca8a','7061faf4-0d3d-4d5a-92af-7947c910dd8e'),('2349a19d-cfc0-414b-81c9-a8cea3d2ca8a','83a9a972-0ce9-4ed5-a753-7936aa86f6d6'),('2349a19d-cfc0-414b-81c9-a8cea3d2ca8a','a49532ee-a94c-497e-8a01-df2acee52f36'),('2349a19d-cfc0-414b-81c9-a8cea3d2ca8a','d52f4ce7-7bcd-4c75-ae19-5f35c710939a'),('25a8b45a-c200-422e-804d-0b374e1052fd','1ab91c71-7a71-4c62-b1da-8d9d8da71430'),('25a8b45a-c200-422e-804d-0b374e1052fd','50ce4f9b-8448-4341-8921-a7db13d7c11b'),('25a8b45a-c200-422e-804d-0b374e1052fd','6fa3bac1-b8dd-4fc4-bf7e-a53fba9804e0'),('25a8b45a-c200-422e-804d-0b374e1052fd','7061faf4-0d3d-4d5a-92af-7947c910dd8e'),('25a8b45a-c200-422e-804d-0b374e1052fd','83a9a972-0ce9-4ed5-a753-7936aa86f6d6'),('25a8b45a-c200-422e-804d-0b374e1052fd','a49532ee-a94c-497e-8a01-df2acee52f36'),('25a8b45a-c200-422e-804d-0b374e1052fd','d52f4ce7-7bcd-4c75-ae19-5f35c710939a'),('3098974a-477d-43ed-9aeb-9c6eb1de068a','1ab91c71-7a71-4c62-b1da-8d9d8da71430'),('3098974a-477d-43ed-9aeb-9c6eb1de068a','50ce4f9b-8448-4341-8921-a7db13d7c11b'),('3098974a-477d-43ed-9aeb-9c6eb1de068a','6fa3bac1-b8dd-4fc4-bf7e-a53fba9804e0'),('3098974a-477d-43ed-9aeb-9c6eb1de068a','7061faf4-0d3d-4d5a-92af-7947c910dd8e'),('3098974a-477d-43ed-9aeb-9c6eb1de068a','83a9a972-0ce9-4ed5-a753-7936aa86f6d6'),('3098974a-477d-43ed-9aeb-9c6eb1de068a','a49532ee-a94c-497e-8a01-df2acee52f36'),('3098974a-477d-43ed-9aeb-9c6eb1de068a','d52f4ce7-7bcd-4c75-ae19-5f35c710939a'),('32dd00a4-d1d2-4fed-937b-ffdecdaa1153','1ab91c71-7a71-4c62-b1da-8d9d8da71430'),('32dd00a4-d1d2-4fed-937b-ffdecdaa1153','50ce4f9b-8448-4341-8921-a7db13d7c11b'),('32dd00a4-d1d2-4fed-937b-ffdecdaa1153','6fa3bac1-b8dd-4fc4-bf7e-a53fba9804e0'),('32dd00a4-d1d2-4fed-937b-ffdecdaa1153','7061faf4-0d3d-4d5a-92af-7947c910dd8e'),('32dd00a4-d1d2-4fed-937b-ffdecdaa1153','83a9a972-0ce9-4ed5-a753-7936aa86f6d6'),('32dd00a4-d1d2-4fed-937b-ffdecdaa1153','a49532ee-a94c-497e-8a01-df2acee52f36'),('32dd00a4-d1d2-4fed-937b-ffdecdaa1153','d52f4ce7-7bcd-4c75-ae19-5f35c710939a'),('3943d920-8123-4383-9cca-2d80458df1f5','1ab91c71-7a71-4c62-b1da-8d9d8da71430'),('3943d920-8123-4383-9cca-2d80458df1f5','50ce4f9b-8448-4341-8921-a7db13d7c11b'),('3943d920-8123-4383-9cca-2d80458df1f5','6fa3bac1-b8dd-4fc4-bf7e-a53fba9804e0'),('3943d920-8123-4383-9cca-2d80458df1f5','7061faf4-0d3d-4d5a-92af-7947c910dd8e'),('3943d920-8123-4383-9cca-2d80458df1f5','83a9a972-0ce9-4ed5-a753-7936aa86f6d6'),('3943d920-8123-4383-9cca-2d80458df1f5','a49532ee-a94c-497e-8a01-df2acee52f36'),('3943d920-8123-4383-9cca-2d80458df1f5','d52f4ce7-7bcd-4c75-ae19-5f35c710939a'),('3ff7c049-9106-4adc-9ce7-5c0816e6af81','1ab91c71-7a71-4c62-b1da-8d9d8da71430'),('3ff7c049-9106-4adc-9ce7-5c0816e6af81','50ce4f9b-8448-4341-8921-a7db13d7c11b'),('3ff7c049-9106-4adc-9ce7-5c0816e6af81','6fa3bac1-b8dd-4fc4-bf7e-a53fba9804e0'),('3ff7c049-9106-4adc-9ce7-5c0816e6af81','7061faf4-0d3d-4d5a-92af-7947c910dd8e'),('3ff7c049-9106-4adc-9ce7-5c0816e6af81','83a9a972-0ce9-4ed5-a753-7936aa86f6d6'),('3ff7c049-9106-4adc-9ce7-5c0816e6af81','a49532ee-a94c-497e-8a01-df2acee52f36'),('3ff7c049-9106-4adc-9ce7-5c0816e6af81','d52f4ce7-7bcd-4c75-ae19-5f35c710939a'),('51b93036-9eba-490f-848c-9d516a0f4265','1ab91c71-7a71-4c62-b1da-8d9d8da71430'),('51b93036-9eba-490f-848c-9d516a0f4265','50ce4f9b-8448-4341-8921-a7db13d7c11b'),('51b93036-9eba-490f-848c-9d516a0f4265','6fa3bac1-b8dd-4fc4-bf7e-a53fba9804e0'),('51b93036-9eba-490f-848c-9d516a0f4265','7061faf4-0d3d-4d5a-92af-7947c910dd8e'),('51b93036-9eba-490f-848c-9d516a0f4265','83a9a972-0ce9-4ed5-a753-7936aa86f6d6'),('51b93036-9eba-490f-848c-9d516a0f4265','a49532ee-a94c-497e-8a01-df2acee52f36'),('51b93036-9eba-490f-848c-9d516a0f4265','d52f4ce7-7bcd-4c75-ae19-5f35c710939a'),('5c2ace35-87bc-43fa-93b7-b3e3695de1f7','1ab91c71-7a71-4c62-b1da-8d9d8da71430'),('5c2ace35-87bc-43fa-93b7-b3e3695de1f7','50ce4f9b-8448-4341-8921-a7db13d7c11b'),('5c2ace35-87bc-43fa-93b7-b3e3695de1f7','6fa3bac1-b8dd-4fc4-bf7e-a53fba9804e0'),('5c2ace35-87bc-43fa-93b7-b3e3695de1f7','7061faf4-0d3d-4d5a-92af-7947c910dd8e'),('5c2ace35-87bc-43fa-93b7-b3e3695de1f7','83a9a972-0ce9-4ed5-a753-7936aa86f6d6'),('5c2ace35-87bc-43fa-93b7-b3e3695de1f7','a49532ee-a94c-497e-8a01-df2acee52f36'),('5c2ace35-87bc-43fa-93b7-b3e3695de1f7','d52f4ce7-7bcd-4c75-ae19-5f35c710939a'),('6f9ce374-eb8d-4121-8b38-9f0265e5e644','1ab91c71-7a71-4c62-b1da-8d9d8da71430'),('6f9ce374-eb8d-4121-8b38-9f0265e5e644','50ce4f9b-8448-4341-8921-a7db13d7c11b'),('6f9ce374-eb8d-4121-8b38-9f0265e5e644','6fa3bac1-b8dd-4fc4-bf7e-a53fba9804e0'),('6f9ce374-eb8d-4121-8b38-9f0265e5e644','7061faf4-0d3d-4d5a-92af-7947c910dd8e'),('6f9ce374-eb8d-4121-8b38-9f0265e5e644','83a9a972-0ce9-4ed5-a753-7936aa86f6d6'),('6f9ce374-eb8d-4121-8b38-9f0265e5e644','a49532ee-a94c-497e-8a01-df2acee52f36'),('6f9ce374-eb8d-4121-8b38-9f0265e5e644','d52f4ce7-7bcd-4c75-ae19-5f35c710939a'),('8c486753-4238-43e7-8884-184cf62c59dc','1ab91c71-7a71-4c62-b1da-8d9d8da71430'),('8c486753-4238-43e7-8884-184cf62c59dc','50ce4f9b-8448-4341-8921-a7db13d7c11b'),('8c486753-4238-43e7-8884-184cf62c59dc','6fa3bac1-b8dd-4fc4-bf7e-a53fba9804e0'),('8c486753-4238-43e7-8884-184cf62c59dc','7061faf4-0d3d-4d5a-92af-7947c910dd8e'),('8c486753-4238-43e7-8884-184cf62c59dc','83a9a972-0ce9-4ed5-a753-7936aa86f6d6'),('8c486753-4238-43e7-8884-184cf62c59dc','a49532ee-a94c-497e-8a01-df2acee52f36'),('8c486753-4238-43e7-8884-184cf62c59dc','d52f4ce7-7bcd-4c75-ae19-5f35c710939a'),('bb7fd7fa-21ed-4f51-9c68-f3857b427564','1ab91c71-7a71-4c62-b1da-8d9d8da71430'),('bb7fd7fa-21ed-4f51-9c68-f3857b427564','50ce4f9b-8448-4341-8921-a7db13d7c11b'),('bb7fd7fa-21ed-4f51-9c68-f3857b427564','6fa3bac1-b8dd-4fc4-bf7e-a53fba9804e0'),('bb7fd7fa-21ed-4f51-9c68-f3857b427564','7061faf4-0d3d-4d5a-92af-7947c910dd8e'),('bb7fd7fa-21ed-4f51-9c68-f3857b427564','83a9a972-0ce9-4ed5-a753-7936aa86f6d6'),('bb7fd7fa-21ed-4f51-9c68-f3857b427564','a49532ee-a94c-497e-8a01-df2acee52f36'),('bb7fd7fa-21ed-4f51-9c68-f3857b427564','d52f4ce7-7bcd-4c75-ae19-5f35c710939a'),('bf779712-a066-4ab7-a369-ff7ca1739c03','1ab91c71-7a71-4c62-b1da-8d9d8da71430'),('bf779712-a066-4ab7-a369-ff7ca1739c03','50ce4f9b-8448-4341-8921-a7db13d7c11b'),('bf779712-a066-4ab7-a369-ff7ca1739c03','6fa3bac1-b8dd-4fc4-bf7e-a53fba9804e0'),('bf779712-a066-4ab7-a369-ff7ca1739c03','7061faf4-0d3d-4d5a-92af-7947c910dd8e'),('bf779712-a066-4ab7-a369-ff7ca1739c03','83a9a972-0ce9-4ed5-a753-7936aa86f6d6'),('bf779712-a066-4ab7-a369-ff7ca1739c03','a49532ee-a94c-497e-8a01-df2acee52f36'),('bf779712-a066-4ab7-a369-ff7ca1739c03','d52f4ce7-7bcd-4c75-ae19-5f35c710939a'),('ceeda756-4159-470d-999d-8ce711b9203e','1ab91c71-7a71-4c62-b1da-8d9d8da71430'),('ceeda756-4159-470d-999d-8ce711b9203e','50ce4f9b-8448-4341-8921-a7db13d7c11b'),('ceeda756-4159-470d-999d-8ce711b9203e','6fa3bac1-b8dd-4fc4-bf7e-a53fba9804e0'),('ceeda756-4159-470d-999d-8ce711b9203e','7061faf4-0d3d-4d5a-92af-7947c910dd8e'),('ceeda756-4159-470d-999d-8ce711b9203e','83a9a972-0ce9-4ed5-a753-7936aa86f6d6'),('ceeda756-4159-470d-999d-8ce711b9203e','a49532ee-a94c-497e-8a01-df2acee52f36'),('ceeda756-4159-470d-999d-8ce711b9203e','d52f4ce7-7bcd-4c75-ae19-5f35c710939a'),('da4305af-343b-475f-bdb9-ed873f3d99c6','1ab91c71-7a71-4c62-b1da-8d9d8da71430'),('da4305af-343b-475f-bdb9-ed873f3d99c6','50ce4f9b-8448-4341-8921-a7db13d7c11b'),('da4305af-343b-475f-bdb9-ed873f3d99c6','6fa3bac1-b8dd-4fc4-bf7e-a53fba9804e0'),('da4305af-343b-475f-bdb9-ed873f3d99c6','7061faf4-0d3d-4d5a-92af-7947c910dd8e'),('da4305af-343b-475f-bdb9-ed873f3d99c6','83a9a972-0ce9-4ed5-a753-7936aa86f6d6'),('da4305af-343b-475f-bdb9-ed873f3d99c6','a49532ee-a94c-497e-8a01-df2acee52f36'),('da4305af-343b-475f-bdb9-ed873f3d99c6','d52f4ce7-7bcd-4c75-ae19-5f35c710939a'),('e2b45cf1-b76b-4029-8118-a29425136495','1ab91c71-7a71-4c62-b1da-8d9d8da71430'),('e2b45cf1-b76b-4029-8118-a29425136495','50ce4f9b-8448-4341-8921-a7db13d7c11b'),('e2b45cf1-b76b-4029-8118-a29425136495','6fa3bac1-b8dd-4fc4-bf7e-a53fba9804e0'),('e2b45cf1-b76b-4029-8118-a29425136495','7061faf4-0d3d-4d5a-92af-7947c910dd8e'),('e2b45cf1-b76b-4029-8118-a29425136495','83a9a972-0ce9-4ed5-a753-7936aa86f6d6'),('e2b45cf1-b76b-4029-8118-a29425136495','a49532ee-a94c-497e-8a01-df2acee52f36'),('e2b45cf1-b76b-4029-8118-a29425136495','d52f4ce7-7bcd-4c75-ae19-5f35c710939a'),('f38d0911-08ab-4694-9c8c-42d50bf0ed66','1ab91c71-7a71-4c62-b1da-8d9d8da71430'),('f38d0911-08ab-4694-9c8c-42d50bf0ed66','50ce4f9b-8448-4341-8921-a7db13d7c11b'),('f38d0911-08ab-4694-9c8c-42d50bf0ed66','6fa3bac1-b8dd-4fc4-bf7e-a53fba9804e0'),('f38d0911-08ab-4694-9c8c-42d50bf0ed66','7061faf4-0d3d-4d5a-92af-7947c910dd8e'),('f38d0911-08ab-4694-9c8c-42d50bf0ed66','83a9a972-0ce9-4ed5-a753-7936aa86f6d6'),('f38d0911-08ab-4694-9c8c-42d50bf0ed66','a49532ee-a94c-497e-8a01-df2acee52f36'),('f38d0911-08ab-4694-9c8c-42d50bf0ed66','d52f4ce7-7bcd-4c75-ae19-5f35c710939a'),('f3e479e9-164e-4820-aeff-170b2eb7c746','1ab91c71-7a71-4c62-b1da-8d9d8da71430'),('f3e479e9-164e-4820-aeff-170b2eb7c746','50ce4f9b-8448-4341-8921-a7db13d7c11b'),('f3e479e9-164e-4820-aeff-170b2eb7c746','6fa3bac1-b8dd-4fc4-bf7e-a53fba9804e0'),('f3e479e9-164e-4820-aeff-170b2eb7c746','7061faf4-0d3d-4d5a-92af-7947c910dd8e'),('f3e479e9-164e-4820-aeff-170b2eb7c746','83a9a972-0ce9-4ed5-a753-7936aa86f6d6'),('f3e479e9-164e-4820-aeff-170b2eb7c746','a49532ee-a94c-497e-8a01-df2acee52f36'),('f3e479e9-164e-4820-aeff-170b2eb7c746','d52f4ce7-7bcd-4c75-ae19-5f35c710939a');
/*!40000 ALTER TABLE `pinggu_department_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pinggu_duty_department`
--

DROP TABLE IF EXISTS `pinggu_duty_department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pinggu_duty_department` (
  `dutyDepartmentId` varchar(100) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `dutyName` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dutyCreateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `adminId` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `deleteFlag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标识：0为未删除 1为已删除',
  `lockFlag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '锁标识：0为未加锁 1为加锁',
  PRIMARY KEY (`dutyDepartmentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='责任部门表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinggu_duty_department`
--

LOCK TABLES `pinggu_duty_department` WRITE;
/*!40000 ALTER TABLE `pinggu_duty_department` DISABLE KEYS */;
INSERT INTO `pinggu_duty_department` VALUES ('0053d1ef-8b07-4cd2-9d96-ab3d21941986','对外联络处','2018-04-27 05:42:57','0',0,0),('090fbb37-74f6-42cf-ad10-c962ab0b208b','人事处','2018-04-25 08:14:40','0',0,0),('0964c823-30ef-43f0-9583-96f3a8c3a491','图书馆','2018-04-27 05:42:34','0',0,0),('371748c8-70a9-44e2-8b80-633bfe147009','学生处','2018-04-27 05:44:03','0',0,0),('37a418d8-5ca1-485a-8cef-e4217a0ac54f','校团委','2018-04-27 05:43:19','0',0,0),('3aeff7ae-749d-4908-aaaa-243dd6d13377','责任部门2','2018-04-22 14:16:07','0',1,0),('557e899c-2f96-4d81-a43d-25d836e0a86d','科技处','2018-04-27 05:44:52','0',0,0),('5d60a1e7-0fd7-4df5-a918-c684ef10ee6e','党政办公室','2018-04-25 01:13:27','0',0,0),('7a380903-9f60-478a-b8d1-2d23c3d75c0d','网络信息管理中心','2018-04-27 05:42:27','0',0,0),('7ca3e062-cd67-4e3e-9da3-cf942aeeea35','教务处','2018-04-25 01:13:42','0',0,0),('860da36c-fa08-4d1c-b750-1eb40e57ae5b','国有资产管理处','2018-04-27 05:42:13','0',0,0),('9c0cdaca-38af-4754-a53e-e003bfb989ec','国际合作与交流处','2018-04-27 05:43:31','0',0,0),('9d246ecb-b3c0-4af5-a8f8-e795c1d66dbb','教师发展中心','2018-04-25 08:14:58','0',0,0),('a0865ca4-96b1-4915-9a01-7da00b6283fe','体育工作部','2018-04-27 05:42:43','0',0,0),('a0e84240-6326-40c2-9d05-f9954fe60c43','发展规划处','2018-04-25 01:13:35','0',0,0),('d7d0873e-445b-4ad9-8d69-73d0c3929637','儿童','2018-04-22 14:17:22','0',1,0),('e0618b7f-02ea-47b7-b412-9879c27cffd4','计财处','2018-04-25 08:15:06','0',0,0),('e3bfc210-1707-4af6-8d0c-51d772521150','招生与就业处','2018-04-27 05:43:47','0',0,0),('ebaf9034-31a6-4e04-a38a-f7daf08d421a','创新创业学院','2018-04-27 05:45:13','0',0,0);
/*!40000 ALTER TABLE `pinggu_duty_department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pinggu_general_user`
--

DROP TABLE IF EXISTS `pinggu_general_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pinggu_general_user` (
  `userId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `departmentId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '关联的部门ID',
  `userName` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户真实姓名',
  `userPassword` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户密码',
  `userAccount` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '登录账号',
  `lockFlag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '锁标识：0为未上锁 1为上锁',
  `deleteFlag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标识：0为未删除 1为已删除',
  PRIMARY KEY (`userId`),
  KEY `login` (`userPassword`(191),`userAccount`(191))
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='普通用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinggu_general_user`
--

LOCK TABLES `pinggu_general_user` WRITE;
/*!40000 ALTER TABLE `pinggu_general_user` DISABLE KEYS */;
INSERT INTO `pinggu_general_user` VALUES ('22e59379-2b6d-40fd-a1fc-0825fcea4e3e','25a8b45a-c200-422e-804d-0b374e1052fd','材料院办','putong2','putong2',0,0),('2635ed1f-b666-4204-992e-6ce05cbeddb6','2349a19d-cfc0-414b-81c9-a8cea3d2ca8a','putong1','putong1','putong1',0,1),('38475c46-6e18-4209-bdcc-4a4d2faa9e87','2349a19d-cfc0-414b-81c9-a8cea3d2ca8a','机械院办','putong1','putong1',0,0),('f7370f46-6ea0-41aa-8749-7029f3617c64','2349a19d-cfc0-414b-81c9-a8cea3d2ca8a','ceshishanchu','ceshishanchu','ceshishanchu',0,1);
/*!40000 ALTER TABLE `pinggu_general_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pinggu_give_mark`
--

DROP TABLE IF EXISTS `pinggu_give_mark`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pinggu_give_mark` (
  `markId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `problemId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '问题ID',
  `departmenId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '部门ID',
  `markScore` varchar(10) COLLATE utf8_unicode_ci NOT NULL COMMENT '分数',
  `raterUserId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '评分人',
  `markCreateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '评分创建时间',
  PRIMARY KEY (`markId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='打分表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinggu_give_mark`
--

LOCK TABLES `pinggu_give_mark` WRITE;
/*!40000 ALTER TABLE `pinggu_give_mark` DISABLE KEYS */;
/*!40000 ALTER TABLE `pinggu_give_mark` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pinggu_lead_department`
--

DROP TABLE IF EXISTS `pinggu_lead_department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pinggu_lead_department` (
  `leadDepartmentId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `leadName` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `leadCreateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `adminId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `deleteFlag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标识：0为未删除 1为已删除',
  `lockFlag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '锁标识 ：0为未上锁 1为上锁',
  PRIMARY KEY (`leadDepartmentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='牵头部门';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinggu_lead_department`
--

LOCK TABLES `pinggu_lead_department` WRITE;
/*!40000 ALTER TABLE `pinggu_lead_department` DISABLE KEYS */;
INSERT INTO `pinggu_lead_department` VALUES ('13bad3d2-3717-4846-aa3a-31347a4079a5','计划财务处','2018-04-25 01:13:04','0',0,0),('28b9c26f-ac71-4995-bce6-02eb547b5b8a','人事处','2018-04-25 01:12:51','0',0,0),('77db709b-7b6d-452e-881e-7717d84e46de','教务处','2018-04-25 08:07:36','0',0,0),('868146ee-afe9-47c2-b96f-d97b388f4265','党政办公室','2018-04-25 01:12:44','0',0,0),('e5a9d132-8242-4889-861c-87b3852db499','学生处','2018-04-25 08:07:46','0',0,0),('ff601356-d336-4bb2-b971-2b2ea34dea90','国有资产管理处','2018-04-25 08:07:28','0',0,0);
/*!40000 ALTER TABLE `pinggu_lead_department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pinggu_log`
--

DROP TABLE IF EXISTS `pinggu_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pinggu_log` (
  `logId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `logAction` tinyint(2) NOT NULL COMMENT '操作：1：检索 2：删除 3：添加 4：修改 5：其他',
  `logLevel` tinyint(2) NOT NULL DEFAULT '0' COMMENT '级别：1：提示 2：其他',
  `logContent` varchar(1000) COLLATE utf8_unicode_ci NOT NULL COMMENT '内容',
  `logUser` varchar(45) COLLATE utf8_unicode_ci NOT NULL COMMENT '操作者',
  `logTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '操作时间',
  `logIp` varchar(100) COLLATE utf8_unicode_ci NOT NULL COMMENT '删除标识：0为未删除 1为已删除',
  `logUserId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '操作人ID',
  PRIMARY KEY (`logId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='日志表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinggu_log`
--

LOCK TABLES `pinggu_log` WRITE;
/*!40000 ALTER TABLE `pinggu_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `pinggu_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pinggu_problem`
--

DROP TABLE IF EXISTS `pinggu_problem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pinggu_problem` (
  `problemId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `problemContent` varchar(1000) COLLATE utf8_unicode_ci NOT NULL COMMENT '问题内容',
  `problemCreateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '问题的创建时间',
  `adminId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '添加人ID',
  `lockFlag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '锁标识 ：0为未上锁  1为已上锁',
  PRIMARY KEY (`problemId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='问题库表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinggu_problem`
--

LOCK TABLES `pinggu_problem` WRITE;
/*!40000 ALTER TABLE `pinggu_problem` DISABLE KEYS */;
INSERT INTO `pinggu_problem` VALUES ('0b871135-0966-411f-9dbc-72b769479117','4月17日会议参会情况','2018-05-16 00:35:04','0',0),('152eb5cd-d771-4dd6-a515-2865d82523c1','4月28日会议参会情况','2018-05-16 00:35:26','0',0),('25e274fe-8f42-4209-bdf3-a44afc42ef25','学院定位是否符合五个度的要求？','2018-04-25 23:55:19','0',0),('34706d13-4952-4924-930e-95bab2306538','毕业设计是否达到了规范性要求？','2018-04-25 23:56:11','0',0),('cf7f54ef-3ad3-4895-a19a-f53b350bf8da','4月23日会议参会情况','2018-05-16 00:35:16','0',0);
/*!40000 ALTER TABLE `pinggu_problem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pinggu_problem_department`
--

DROP TABLE IF EXISTS `pinggu_problem_department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pinggu_problem_department` (
  `departmentId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `problemId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`departmentId`,`problemId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='问题和部门中间表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinggu_problem_department`
--

LOCK TABLES `pinggu_problem_department` WRITE;
/*!40000 ALTER TABLE `pinggu_problem_department` DISABLE KEYS */;
INSERT INTO `pinggu_problem_department` VALUES ('2349a19d-cfc0-414b-81c9-a8cea3d2ca8a','0b871135-0966-411f-9dbc-72b769479117'),('2349a19d-cfc0-414b-81c9-a8cea3d2ca8a','152eb5cd-d771-4dd6-a515-2865d82523c1'),('2349a19d-cfc0-414b-81c9-a8cea3d2ca8a','cf7f54ef-3ad3-4895-a19a-f53b350bf8da'),('25a8b45a-c200-422e-804d-0b374e1052fd','0b871135-0966-411f-9dbc-72b769479117'),('25a8b45a-c200-422e-804d-0b374e1052fd','152eb5cd-d771-4dd6-a515-2865d82523c1'),('25a8b45a-c200-422e-804d-0b374e1052fd','cf7f54ef-3ad3-4895-a19a-f53b350bf8da');
/*!40000 ALTER TABLE `pinggu_problem_department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pinggu_problem_list`
--

DROP TABLE IF EXISTS `pinggu_problem_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pinggu_problem_list` (
  `problemListId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `projectId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '关联审核项目表 审核项目ID',
  `elementId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '关联审核元素表，审核元素ID',
  `problemContent` varchar(3000) CHARACTER SET utf8 NOT NULL COMMENT '存在问题',
  `problemShow` varchar(3000) CHARACTER SET utf8 NOT NULL COMMENT '问题表现',
  `problemModifyMeasure` varchar(3000) COLLATE utf8_unicode_ci NOT NULL COMMENT '整改措施',
  `problemPlanSolveTime` date NOT NULL COMMENT '拟定的解决时间',
  `departmentId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '部门ID 关联部门表',
  `problemCreateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '问题创建时间',
  `deleteFlag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标识 0为未删除 1为删除',
  `createUserId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '提出人Id',
  `problemListRemark` varchar(3000) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '问题清单中问题的批注',
  `problemAnalysis` varchar(3000) COLLATE utf8_unicode_ci NOT NULL COMMENT '问题原因分析',
  PRIMARY KEY (`problemListId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='问题清单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinggu_problem_list`
--

LOCK TABLES `pinggu_problem_list` WRITE;
/*!40000 ALTER TABLE `pinggu_problem_list` DISABLE KEYS */;
INSERT INTO `pinggu_problem_list` VALUES ('2386fd0f-cbfe-4bd4-9a88-9888b7d044dd','04e46aa8-8653-45d2-8087-6e39c887156f','b5e315b3-7c73-406f-8e9e-2f8e7201966f','XX专业实验设备无法满足学生主干课要求','问题表现样例文本问题表现样例文本问题表现样例文本问题表现样例文本问题表现样例文本问题表现样例文本问题表现样例文本问题表现样例文本问题表现样例文本问题表现样例文本问题表现样例文本问题表现样例文本问题表现样例文本问题表现样例文本问题表现样例文本问题表现样例文本问题表现样例文本问题表现样例文本\r\n1. 问题表现样例文本问题表现样例文本问题表现样例文本问题表现样例文本问题表现样例文本问题表现样例文本问题表现样例文本问题表现样例文本问题表现样例文本问题表现样例文本问题表现样例文本\r\n2. 问题表现样例文本问题表现样例文本问题表现样例文本问题表现样例文本问题表现样例文本问题表现样例文本问题表现样例文本问题表现样例文本问题表现样例文本3. 问题表现样例文本问题表现样例文本问题表现样例文本问题表现样例文本\r\n问题表现样例文本问题表现样例文本问题表现样例文本问题表现样例文本问题表现样例文本问题表现样例文本问题表现样例文本问题表现样例文本','整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本\r\n1.  整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本\r\n2.  整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本\r\n3. 整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本\r\n整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本整改措施样例文本','2018-08-30','2349a19d-cfc0-414b-81c9-a8cea3d2ca8a','2018-05-16 06:27:02',1,'38475c46-6e18-4209-bdcc-4a4d2faa9e87','',''),('d9ba3b15-a6dc-4c1c-b843-e741e93dad38','9e9c9743-afd8-4c8e-85bc-4c8a8d166521','0e1abff3-9c26-4a94-b0aa-482b34ea72de','测试问题','总共能写300字总共能写300字总共能写300字总共能写300字总共能写300字总共能写300字总共能写300字总共能写300字总共能写300字总共能写300字总共能写300字总共能写300字总共能写300字总共能写300字总共能写300字总共能写300字总共能写300字总共能写300字总共能写300字总共能写300字总共能写300字总共能写300字总共能写300字总共能写300字总共能写300字总共能写300字总共能写300字总共能写300字总共能写300字总共能写300字总共能写300字总共能写300字总共能写300字','    13. 评估报告内容。《审核评估报告》应在全面深入考察和准确把握所有审核内容基础上，对各审核项目及其要素的审核情况进行描述，并围绕审核重点对学校本科人才培养总体情况作出判断和评价，同时明确学校教学工作值得肯定、需要改进和必须整改的方面。\r\n14．评估结论审议与发布。各省（区、市）教育行政部门和教育部评估中心应按年度将所组织的审核评估情况形成总结报告报教育部。教育部组织评估专家委员会进行审议，公布审议结果，并由教育部评估中心和各地教育行政部门公开发布参评高校的审核评估结论。 \r\n15. 评估结果。审核评估结果是学校教育教学质量的反映，与学校办学、发展直接相关，学校要根据审核评估中提出的问题及建议进行整改，有关教育行政部门应对评估学校的整改情况进行指导和检查，并在政策制定、资源配置、招生规模、学科专业建设等方面予以\r\n','2018-07-28','2349a19d-cfc0-414b-81c9-a8cea3d2ca8a','2018-05-06 12:27:38',1,'38475c46-6e18-4209-bdcc-4a4d2faa9e87','测试','');
/*!40000 ALTER TABLE `pinggu_problem_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pinggu_problem_score`
--

DROP TABLE IF EXISTS `pinggu_problem_score`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pinggu_problem_score` (
  `problemScoreId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '问题打分表主键',
  `problemId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '问题Id',
  `score` tinyint(4) NOT NULL COMMENT '分数',
  `raterUserId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '评审人员Id',
  `departmentId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '部门Id',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '打分生成时间',
  PRIMARY KEY (`problemScoreId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='问题分数表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinggu_problem_score`
--

LOCK TABLES `pinggu_problem_score` WRITE;
/*!40000 ALTER TABLE `pinggu_problem_score` DISABLE KEYS */;
/*!40000 ALTER TABLE `pinggu_problem_score` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pinggu_rater_file`
--

DROP TABLE IF EXISTS `pinggu_rater_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pinggu_rater_file` (
  `raterFileId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `raterFileName` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '评审真实文件名',
  `raterFileDbName` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '评审文件业务文件名',
  `raterFilePath` varchar(1000) COLLATE utf8_unicode_ci NOT NULL COMMENT '评审文件路径',
  `departmentId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '部门ID',
  `userId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '上传者ID',
  `fileTypeFlag` varchar(10) COLLATE utf8_unicode_ci NOT NULL COMMENT '文件格式标识',
  `raterFileCreateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '文件上传时间',
  `departmentTypeId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '部门类型Id与pinggu_type关联',
  `raterFileRemark` varchar(1000) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '文件备注',
  `deleteFlag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标识：0为未删除 1为已删除',
  PRIMARY KEY (`raterFileId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='评审文件表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinggu_rater_file`
--

LOCK TABLES `pinggu_rater_file` WRITE;
/*!40000 ALTER TABLE `pinggu_rater_file` DISABLE KEYS */;
INSERT INTO `pinggu_rater_file` VALUES ('2efb4d2e-b62f-466d-888e-34520723bd5d','评建办发201802号：关于印发大连交通大学本科教学审核评估动员大会领导讲话的通知.pdf','390ccd229db7866cd348d9625c802af8.pdf','/var/pinggu/rater/2349a19d-cfc0-414b-81c9-a8cea3d2ca8a/83a9a972-0ce9-4ed5-a753-7936aa86f6d6/38475c46-6e18-4209-bdcc-4a4d2faa9e87/','2349a19d-cfc0-414b-81c9-a8cea3d2ca8a','38475c46-6e18-4209-bdcc-4a4d2faa9e87','pdf','2018-05-16 06:27:23','83a9a972-0ce9-4ed5-a753-7936aa86f6d6','',1),('6e2fb0d9-4fca-42ac-ad46-c844caf97c15','评建办发201803号：关于成立教学单位审核评估工作组的通知.pdf','e8fc7c3aebf31ce5352185493ed5bc01.pdf','/var/pinggu/rater/2349a19d-cfc0-414b-81c9-a8cea3d2ca8a/83a9a972-0ce9-4ed5-a753-7936aa86f6d6/38475c46-6e18-4209-bdcc-4a4d2faa9e87/','2349a19d-cfc0-414b-81c9-a8cea3d2ca8a','38475c46-6e18-4209-bdcc-4a4d2faa9e87','pdf','2018-05-16 05:52:45','83a9a972-0ce9-4ed5-a753-7936aa86f6d6','',1),('c17391a2-ee20-4445-8816-2b10bd3c7295','评建办发〔2018〕4号_关于与各单位开展评建工作进行研讨和对接的通知.pdf','6245961773a5f46c56ace0a5e9509cd1.pdf','/var/pinggu/rater/2349a19d-cfc0-414b-81c9-a8cea3d2ca8a/7c82a66a-e5c3-412f-9b1f-8b734de607af/38475c46-6e18-4209-bdcc-4a4d2faa9e87/','2349a19d-cfc0-414b-81c9-a8cea3d2ca8a','38475c46-6e18-4209-bdcc-4a4d2faa9e87','pdf','2018-05-06 12:27:12','7c82a66a-e5c3-412f-9b1f-8b734de607af','',1),('ed5cd205-5611-46fe-8f3d-b79a75b6a2c7','本科教学审核评估方案设计与实施重点_李志义.pdf','ee15b25b8893dbe7e96da91ad51105e8.pdf','/var/pinggu/rater/2349a19d-cfc0-414b-81c9-a8cea3d2ca8a/a49532ee-a94c-497e-8a01-df2acee52f36/38475c46-6e18-4209-bdcc-4a4d2faa9e87/','2349a19d-cfc0-414b-81c9-a8cea3d2ca8a','38475c46-6e18-4209-bdcc-4a4d2faa9e87','pdf','2018-05-07 02:46:35','a49532ee-a94c-497e-8a01-df2acee52f36','',1),('f1e74cb0-fc3a-4860-8b7d-35132c4322b8','architect201711-1510052364654.pdf','ae63bf480f03ffe60a0159522016ac82.pdf','/var/pinggu/rater/2349a19d-cfc0-414b-81c9-a8cea3d2ca8a/7c82a66a-e5c3-412f-9b1f-8b734de607af/38475c46-6e18-4209-bdcc-4a4d2faa9e87/','2349a19d-cfc0-414b-81c9-a8cea3d2ca8a','38475c46-6e18-4209-bdcc-4a4d2faa9e87','pdf','2018-05-06 12:27:15','7c82a66a-e5c3-412f-9b1f-8b734de607af','',1);
/*!40000 ALTER TABLE `pinggu_rater_file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pinggu_rater_file_archive`
--

DROP TABLE IF EXISTS `pinggu_rater_file_archive`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pinggu_rater_file_archive` (
  `raterFileArchiveId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `archiveUserId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '归档人ID',
  `raterArchiveTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '归档时间',
  `raterFileName` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '文件名',
  `raterFileDbName` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '文件数据库名',
  `raterFilePath` varchar(1000) COLLATE utf8_unicode_ci NOT NULL COMMENT '文件路径',
  `fileReadNum` int(11) NOT NULL COMMENT '文件被阅读次数',
  `uploadUserId` varchar(45) COLLATE utf8_unicode_ci NOT NULL COMMENT '文件上传人Id',
  `uploadTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '文件上传时间',
  `archiveFilePath` varchar(1000) COLLATE utf8_unicode_ci NOT NULL COMMENT '归档文件的路径',
  `raterFileId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '评审文件Id与rater_file关联',
  PRIMARY KEY (`raterFileArchiveId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='评审文件归档表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinggu_rater_file_archive`
--

LOCK TABLES `pinggu_rater_file_archive` WRITE;
/*!40000 ALTER TABLE `pinggu_rater_file_archive` DISABLE KEYS */;
/*!40000 ALTER TABLE `pinggu_rater_file_archive` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pinggu_rater_file_modify`
--

DROP TABLE IF EXISTS `pinggu_rater_file_modify`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pinggu_rater_file_modify` (
  `raterFileModifyId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `userId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '修改人ID',
  `raterFileId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '归档文件ID',
  `raterFileModifyTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `raterArchiveId` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT '归档文件ID 0:添加文件',
  `modifyFlag` int(11) NOT NULL DEFAULT '0' COMMENT '修改标识：0为修改，1为删除',
  PRIMARY KEY (`raterFileModifyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='评审文件修改表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinggu_rater_file_modify`
--

LOCK TABLES `pinggu_rater_file_modify` WRITE;
/*!40000 ALTER TABLE `pinggu_rater_file_modify` DISABLE KEYS */;
INSERT INTO `pinggu_rater_file_modify` VALUES ('129e1dd1-67ee-409f-b8e6-2df1b6a86352','38475c46-6e18-4209-bdcc-4a4d2faa9e87','ed5cd205-5611-46fe-8f3d-b79a75b6a2c7','2018-05-07 02:46:13','0',0),('56624091-af14-435d-9f3e-ed114fb83bcd','38475c46-6e18-4209-bdcc-4a4d2faa9e87','6e2fb0d9-4fca-42ac-ad46-c844caf97c15','2018-05-09 01:49:25','0',0),('62127726-da60-400e-997e-809c1ded8794','38475c46-6e18-4209-bdcc-4a4d2faa9e87','f1e74cb0-fc3a-4860-8b7d-35132c4322b8','2018-04-23 10:01:09','0',0),('a30f8e60-7d43-4861-924a-5e4fbae15315','38475c46-6e18-4209-bdcc-4a4d2faa9e87','c17391a2-ee20-4445-8816-2b10bd3c7295','2018-04-27 05:13:11','0',0),('b76c798b-4253-41cb-944f-5be67ffdd27f','38475c46-6e18-4209-bdcc-4a4d2faa9e87','2efb4d2e-b62f-466d-888e-34520723bd5d','2018-05-16 06:14:55','0',0);
/*!40000 ALTER TABLE `pinggu_rater_file_modify` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pinggu_rater_file_person_record`
--

DROP TABLE IF EXISTS `pinggu_rater_file_person_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pinggu_rater_file_person_record` (
  `raterFileReadPersonId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '评审阅读人',
  `userId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '阅读人ID',
  `raterPersonReadTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '阅读时间',
  `readRaterFileId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '评审文件ID',
  `userType` tinyint(4) NOT NULL DEFAULT '0' COMMENT '阅读人类型标识：评审人1  普通用户0',
  PRIMARY KEY (`raterFileReadPersonId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='评审文件阅读人记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinggu_rater_file_person_record`
--

LOCK TABLES `pinggu_rater_file_person_record` WRITE;
/*!40000 ALTER TABLE `pinggu_rater_file_person_record` DISABLE KEYS */;
INSERT INTO `pinggu_rater_file_person_record` VALUES ('236a060f-afc7-4317-a1ff-80243cb4f309','38475c46-6e18-4209-bdcc-4a4d2faa9e87','2018-04-27 02:50:24','f1e74cb0-fc3a-4860-8b7d-35132c4322b8',0),('65b77828-4f1c-43e4-9932-a4ef55866f99','38475c46-6e18-4209-bdcc-4a4d2faa9e87','2018-05-04 08:42:43','f1e74cb0-fc3a-4860-8b7d-35132c4322b8',0),('6aa0cce2-6cd4-4f48-9e36-2c609cd416a0','3a9cbdd2-27f7-4da7-b58d-5df8d142d2a4','2018-04-25 10:00:50','f1e74cb0-fc3a-4860-8b7d-35132c4322b8',1),('7adeb61b-66f1-4b0f-94aa-4b890e80899f','3a9cbdd2-27f7-4da7-b58d-5df8d142d2a4','2018-05-04 08:34:29','c17391a2-ee20-4445-8816-2b10bd3c7295',1),('8cf58804-2d84-42d0-b241-918535eae337','38475c46-6e18-4209-bdcc-4a4d2faa9e87','2018-04-27 05:13:17','c17391a2-ee20-4445-8816-2b10bd3c7295',0),('96f528fc-68a4-4a0c-a1d6-bcb09ccd9840','38475c46-6e18-4209-bdcc-4a4d2faa9e87','2018-05-04 08:42:22','c17391a2-ee20-4445-8816-2b10bd3c7295',0),('99e5c9b9-68b6-4105-a5d3-3bfd03a2ff72','38475c46-6e18-4209-bdcc-4a4d2faa9e87','2018-05-07 02:46:20','ed5cd205-5611-46fe-8f3d-b79a75b6a2c7',0),('9f02332f-24e2-4655-8dae-c424b01f058b','3a9cbdd2-27f7-4da7-b58d-5df8d142d2a4','2018-04-27 05:15:40','c17391a2-ee20-4445-8816-2b10bd3c7295',1),('b9226bf6-9e45-4664-9a75-493d6fd4fae8','38475c46-6e18-4209-bdcc-4a4d2faa9e87','2018-05-16 06:15:00','2efb4d2e-b62f-466d-888e-34520723bd5d',0),('bcf4a3e5-d233-41f8-955f-6b8077bfe3ca','38475c46-6e18-4209-bdcc-4a4d2faa9e87','2018-04-23 10:01:13','f1e74cb0-fc3a-4860-8b7d-35132c4322b8',0),('d11da07a-3f33-4678-8509-77e2eed2fd09','38475c46-6e18-4209-bdcc-4a4d2faa9e87','2018-04-23 10:09:23','f1e74cb0-fc3a-4860-8b7d-35132c4322b8',0),('eadd2502-18e7-44eb-b656-89da05a38b46','38475c46-6e18-4209-bdcc-4a4d2faa9e87','2018-05-03 04:10:58','c17391a2-ee20-4445-8816-2b10bd3c7295',0),('ffb5bfef-4cf7-440e-925a-643bba808d81','38475c46-6e18-4209-bdcc-4a4d2faa9e87','2018-04-25 09:50:22','f1e74cb0-fc3a-4860-8b7d-35132c4322b8',0);
/*!40000 ALTER TABLE `pinggu_rater_file_person_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pinggu_rater_file_read_record`
--

DROP TABLE IF EXISTS `pinggu_rater_file_read_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pinggu_rater_file_read_record` (
  `raterFileId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '评审文件ID',
  `readRaterNumber` int(11) NOT NULL DEFAULT '0' COMMENT '阅读数',
  PRIMARY KEY (`raterFileId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='评审文件阅读次数记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinggu_rater_file_read_record`
--

LOCK TABLES `pinggu_rater_file_read_record` WRITE;
/*!40000 ALTER TABLE `pinggu_rater_file_read_record` DISABLE KEYS */;
INSERT INTO `pinggu_rater_file_read_record` VALUES ('2efb4d2e-b62f-466d-888e-34520723bd5d',1),('6e2fb0d9-4fca-42ac-ad46-c844caf97c15',0),('c17391a2-ee20-4445-8816-2b10bd3c7295',11111),('ed5cd205-5611-46fe-8f3d-b79a75b6a2c7',1),('f1e74cb0-fc3a-4860-8b7d-35132c4322b8',111111);
/*!40000 ALTER TABLE `pinggu_rater_file_read_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pinggu_rater_user`
--

DROP TABLE IF EXISTS `pinggu_rater_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pinggu_rater_user` (
  `raterUserId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `raterUserName` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户真实姓名',
  `raterUserPassword` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '密码',
  `raterUserAccount` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '登录名',
  `lockFlag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '锁标识：0为未上锁 1为已上锁',
  `deleteFlag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标识： 0为未删除 1为已删除',
  PRIMARY KEY (`raterUserId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='评审用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinggu_rater_user`
--

LOCK TABLES `pinggu_rater_user` WRITE;
/*!40000 ALTER TABLE `pinggu_rater_user` DISABLE KEYS */;
INSERT INTO `pinggu_rater_user` VALUES ('0e3fb903-7a3d-4f5d-8b17-d77976e8ff66','pinggu2','pinggu2','pinggu2',0,0),('3a9cbdd2-27f7-4da7-b58d-5df8d142d2a4','pinggu12','pinggu12','pinggu12',0,0),('57736e3a-8ac7-49a1-8a24-0840644bc7bb','pinggu12','pinggu12','pinggu12',0,1),('a9fba095-612e-4aec-8d77-08654dc452cd','ceshishanchu','ceshishanchu','ceshishanchu',0,1);
/*!40000 ALTER TABLE `pinggu_rater_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pinggu_review_element`
--

DROP TABLE IF EXISTS `pinggu_review_element`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pinggu_review_element` (
  `elementId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `projectId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '项目ID',
  `elementName` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '要素名',
  `elementCreateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `adminId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '添加人ID',
  `elementSort` int(11) NOT NULL COMMENT '排序键',
  `deleteFlag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标识：0为未删除  1为已删除',
  PRIMARY KEY (`elementId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='审核要素';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinggu_review_element`
--

LOCK TABLES `pinggu_review_element` WRITE;
/*!40000 ALTER TABLE `pinggu_review_element` DISABLE KEYS */;
INSERT INTO `pinggu_review_element` VALUES ('094551b5-773a-44d4-8aa6-b1e1c63cc0c5','a82ee014-9b37-40c8-bd84-b3c3e101eed8','4.4. 第二课堂','2018-05-03 13:07:06','0',16,0),('0bf9ce82-b4c6-4df1-96c0-b5b0a562ea36','04e46aa8-8653-45d2-8087-6e39c887156f','3.1 教学经费','2018-04-27 05:30:45','0',8,0),('0e1abff3-9c26-4a94-b0aa-482b34ea72de','9e9c9743-afd8-4c8e-85bc-4c8a8d166521','2.2 教育教学水平','2018-04-25 07:59:24','0',5,0),('111d01a2-bd8c-4218-b7ce-abecdfff2a3f','9e2bb1f3-1c69-4253-ae74-b229ae1d5f48','1.1 办学定位','2018-04-25 07:56:59','0',1,0),('14bda6cd-fd65-492b-b9bc-8adab357b67a','a82ee014-9b37-40c8-bd84-b3c3e101eed8','4.3. 实践教学','2018-05-03 13:06:43','0',15,0),('21515d6d-ca9f-4be6-b72c-2b325c38fe92','9e9c9743-afd8-4c8e-85bc-4c8a8d166521','2.3 教师教学投入','2018-04-25 07:59:12','0',6,0),('2662e91c-f716-4282-b1e4-99bca55f1c27','c454630c-20e1-48c3-b6b2-ad919d162244','6.4. 质量改进','2018-05-03 13:10:34','0',24,0),('26e815c7-737d-4102-8ee8-352ede2eb85c','27bd0158-e317-4215-9edf-7c4a5965fbd5','7.1. 校企协同育人','2018-05-03 13:10:54','0',25,0),('27f462a5-ea68-45dd-95ed-3b2b18004b0a','7c8da989-ab0e-4241-9caf-fcb9d21fb002','5.3. 学风与学习效果','2018-05-03 13:08:47','0',19,0),('2a69c25e-e9fd-491b-bb65-2646db3c059f','c454630c-20e1-48c3-b6b2-ad919d162244','6.1. 教学质量保障体系','2018-05-03 13:09:41','0',21,0),('2d467104-0f22-46a2-a9a7-1769a6f4f0f1','9e2bb1f3-1c69-4253-ae74-b229ae1d5f48','1.2 培养目标','2018-04-25 07:57:16','0',2,0),('2fd8da35-bec6-4653-9dba-0110f34a1534','7c8da989-ab0e-4241-9caf-fcb9d21fb002','5.4. 就业与发展','2018-05-03 13:09:15','0',20,0),('35ecba12-bfab-4eb1-88b8-50c862f94445','27bd0158-e317-4215-9edf-7c4a5965fbd5','7.3. 创新创业','2018-05-03 13:11:28','0',27,0),('4732b7c8-aeef-4b20-9fda-a35672440c35','a82ee014-9b37-40c8-bd84-b3c3e101eed8','4.1 教学改革','2018-04-27 05:34:33','0',13,0),('47f6cefe-9dc1-4b1f-8b3a-d3ec2f31bb25','27bd0158-e317-4215-9edf-7c4a5965fbd5','7.2. 转型发展','2018-05-03 13:11:12','0',26,0),('497e9a73-b199-4944-9cc6-4d2119a8c585','27bd0158-e317-4215-9edf-7c4a5965fbd5','7.4. 跨校修读学分与国际合作','2018-05-03 13:11:46','0',28,0),('79a2e0d3-2286-4681-a624-aea1bd9752fc','04e46aa8-8653-45d2-8087-6e39c887156f','3.3 专业设置与培养方案','2018-04-27 05:31:53','0',10,0),('7e0e28e4-6f01-4a43-9831-4beb0219781e','7c8da989-ab0e-4241-9caf-fcb9d21fb002','5.2. 学生指导与服务','2018-05-03 13:08:29','0',18,0),('97926369-dbff-486a-b943-63d9a88dcfdf','9e9c9743-afd8-4c8e-85bc-4c8a8d166521','2.4 教师发展服务','2018-04-25 08:00:14','0',7,0),('a348a45b-c0ee-4d0c-9c3e-5b9f15a114fb','c454630c-20e1-48c3-b6b2-ad919d162244','6.3. 质量信息及利用','2018-05-03 13:10:13','0',23,0),('b1e96e7a-a470-48fc-b4e5-8a6d995f7e0c','a82ee014-9b37-40c8-bd84-b3c3e101eed8','4.2. 课堂教学','2018-05-03 13:06:23','0',14,0),('b44d65f9-5389-43bc-ab85-9c5746ee46ef','c454630c-20e1-48c3-b6b2-ad919d162244','6.2. 质量监控','2018-05-03 13:09:58','0',22,0),('b5e315b3-7c73-406f-8e9e-2f8e7201966f','04e46aa8-8653-45d2-8087-6e39c887156f','3.2 教学设施','2018-04-27 05:31:25','0',9,0),('c2f86da3-da52-45ab-af95-9fc4e147c19d','ee7b8be7-6508-4d96-a44d-2391569932fe','8. 自选特色项目','2018-05-04 02:19:21','0',29,0),('c8973086-ab25-4de3-bf2a-d58c1adfb714','7c8da989-ab0e-4241-9caf-fcb9d21fb002','5.1. 招生及生源情况','2018-05-03 13:08:09','0',17,0),('d0c6edbc-519c-42b0-ad0f-cfeed4d26b8d','9e9c9743-afd8-4c8e-85bc-4c8a8d166521','2.1 数量与结构','2018-04-25 07:58:15','0',4,0),('d6a6a648-57dd-4617-81fc-55136062a3a4','04e46aa8-8653-45d2-8087-6e39c887156f','3.5 社会资源','2018-04-27 05:33:47','0',12,0),('f88757d8-c208-4bf0-adcb-46d8b1faa444','04e46aa8-8653-45d2-8087-6e39c887156f','3.4 课程资源','2018-04-27 05:32:52','0',11,0),('f9a448a0-6795-499a-8bfa-05eb4d8f4397','9e2bb1f3-1c69-4253-ae74-b229ae1d5f48','1.3 人才培养中心地位','2018-04-25 07:57:37','0',3,0);
/*!40000 ALTER TABLE `pinggu_review_element` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pinggu_review_point`
--

DROP TABLE IF EXISTS `pinggu_review_point`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pinggu_review_point` (
  `pointId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `pointName` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '要点名',
  `pointCreateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `adminId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '创建人ID',
  `pointSort` int(11) NOT NULL COMMENT '排序键',
  `deleteFlag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标识  0为未删除 1为已删除',
  `elementId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '评审要素ID',
  `leadDepartmentId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '牵头单位ID',
  `projectId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '审核项目',
  PRIMARY KEY (`pointId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='评估要点';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinggu_review_point`
--

LOCK TABLES `pinggu_review_point` WRITE;
/*!40000 ALTER TABLE `pinggu_review_point` DISABLE KEYS */;
INSERT INTO `pinggu_review_point` VALUES ('03b1b594-dc37-46ab-8b63-7bd4c2b84e9e','3.5.3. 社会捐赠情况','2018-05-04 01:48:52','0',30,0,'d6a6a648-57dd-4617-81fc-55136062a3a4','77db709b-7b6d-452e-881e-7717d84e46de','04e46aa8-8653-45d2-8087-6e39c887156f'),('0555df7b-0356-4f01-9058-1db85c6fa33b','3.5.1. 合作办学、合作育人的措施与效果','2018-05-04 01:47:01','0',28,0,'d6a6a648-57dd-4617-81fc-55136062a3a4','77db709b-7b6d-452e-881e-7717d84e46de','04e46aa8-8653-45d2-8087-6e39c887156f'),('08f09e7b-df82-48f0-9d15-a411b860d972','8. 自选特色项目','2018-05-04 02:19:58','0',77,0,'c2f86da3-da52-45ab-af95-9fc4e147c19d','868146ee-afe9-47c2-b96f-d97b388f4265','ee7b8be7-6508-4d96-a44d-2391569932fe'),('0a0fae61-e184-405c-8426-d9236dce995d','2.1.2. 教师队伍建设规划及发展态势','2018-05-04 01:38:42','0',9,0,'d0c6edbc-519c-42b0-ad0f-cfeed4d26b8d','28b9c26f-ac71-4995-bce6-02eb547b5b8a','9e9c9743-afd8-4c8e-85bc-4c8a8d166521'),('0e0dbbf1-b8a8-4096-8d6a-d8e885810044','5.3.2. 学生学业成绩及综合素质表现','2018-05-04 02:06:03','0',50,0,'27f462a5-ea68-45dd-95ed-3b2b18004b0a','e5a9d132-8242-4889-861c-87b3852db499','7c8da989-ab0e-4241-9caf-fcb9d21fb002'),('0f705361-71b9-4a77-afba-27a830979c06','3.1.3. 教学经费分配方式、比例及使用效益','2018-05-04 01:43:00','0',18,0,'0bf9ce82-b4c6-4df1-96c0-b5b0a562ea36','13bad3d2-3717-4846-aa3a-31347a4079a5','04e46aa8-8653-45d2-8087-6e39c887156f'),('107554f5-1ac3-4808-ae9f-4472dd7b90e9','1.3.1. 落实人才培养中心地位的政策与措施','2018-05-04 01:36:21','0',5,0,'f9a448a0-6795-499a-8bfa-05eb4d8f4397','868146ee-afe9-47c2-b96f-d97b388f4265','9e2bb1f3-1c69-4253-ae74-b229ae1d5f48'),('17a86c11-9864-472a-a8e5-54d3b6999840','2.4.2. 服务教师职业生涯发展的政策措施','2018-05-04 01:41:56','0',15,0,'97926369-dbff-486a-b943-63d9a88dcfdf','28b9c26f-ac71-4995-bce6-02eb547b5b8a','9e9c9743-afd8-4c8e-85bc-4c8a8d166521'),('1a02b954-b311-49ba-924e-eeededfcae3f','4.4.1. 第二课堂育人体系建设与保障措施','2018-05-04 02:02:22','0',41,0,'094551b5-773a-44d4-8aa6-b1e1c63cc0c5','77db709b-7b6d-452e-881e-7717d84e46de','a82ee014-9b37-40c8-bd84-b3c3e101eed8'),('1d722535-cf8d-4770-a4c4-507cc63423b2','2.3.2. 教师开展教学研究、参与教学改革与建设情况','2018-05-04 01:40:51','0',13,0,'21515d6d-ca9f-4be6-b72c-2b325c38fe92','28b9c26f-ac71-4995-bce6-02eb547b5b8a','9e9c9743-afd8-4c8e-85bc-4c8a8d166521'),('1de5a335-4d8f-45f6-afd9-89efc6280647','7.3.3. 创新创业教育成效及带动就业情况','2018-05-04 02:15:58','0',73,0,'35ecba12-bfab-4eb1-88b8-50c862f94445','13bad3d2-3717-4846-aa3a-31347a4079a5','27bd0158-e317-4215-9edf-7c4a5965fbd5'),('27cd75af-6b1a-4166-a1ba-7117298ec9d5','1.1.1. 学校办学方向、办学定位及确定依据','2018-04-27 05:35:10','0',1,0,'111d01a2-bd8c-4218-b7ce-abecdfff2a3f','868146ee-afe9-47c2-b96f-d97b388f4265','9e2bb1f3-1c69-4253-ae74-b229ae1d5f48'),('28ae6681-147d-491f-ac26-9c4eb60dd645','7.2.2. 应用型人才培养模式和培养方案建设情况','2018-05-04 02:13:37','0',69,0,'47f6cefe-9dc1-4b1f-8b3a-d3ec2f31bb25','77db709b-7b6d-452e-881e-7717d84e46de','27bd0158-e317-4215-9edf-7c4a5965fbd5'),('37d0e830-9407-4529-8239-f60ee4a629c1','2.4.1. 提升教师教学能力和专业水平的政策措施','2018-05-04 01:41:15','0',14,0,'97926369-dbff-486a-b943-63d9a88dcfdf','28b9c26f-ac71-4995-bce6-02eb547b5b8a','9e9c9743-afd8-4c8e-85bc-4c8a8d166521'),('3946097b-08c4-4a2f-beb4-06ff6f8e15de','5.2.1. 学生指导与服务的内容及效果','2018-05-04 02:04:32','0',46,0,'7e0e28e4-6f01-4a43-9831-4beb0219781e','e5a9d132-8242-4889-861c-87b3852db499','7c8da989-ab0e-4241-9caf-fcb9d21fb002'),('39ac5623-3928-4535-91ca-32ac6194360c','5.3.3. 学生对自我学习及成长的满意度','2018-05-04 02:06:24','0',51,0,'27f462a5-ea68-45dd-95ed-3b2b18004b0a','e5a9d132-8242-4889-861c-87b3852db499','7c8da989-ab0e-4241-9caf-fcb9d21fb002'),('3a862b65-c1bf-4ba8-9027-382952d174e0','5.1.2. 各专业生源数量及特征','2018-05-04 02:04:08','0',45,0,'c8973086-ab25-4de3-bf2a-d58c1adfb714','e5a9d132-8242-4889-861c-87b3852db499','7c8da989-ab0e-4241-9caf-fcb9d21fb002'),('3df876ad-8f54-46ac-b8f0-c0474ee23b00','4.2.2. 教学内容对人才培养目标的体现，科研转化教学','2018-05-04 02:00:04','0',35,0,'b1e96e7a-a470-48fc-b4e5-8a6d995f7e0c','77db709b-7b6d-452e-881e-7717d84e46de','a82ee014-9b37-40c8-bd84-b3c3e101eed8'),('3e7c5cea-9fd4-40fc-8cf5-1435146ae6e6','6.1.4. 教学质量管理队伍建设','2018-05-04 02:08:36','0',57,0,'2a69c25e-e9fd-491b-bb65-2646db3c059f','77db709b-7b6d-452e-881e-7717d84e46de','c454630c-20e1-48c3-b6b2-ad919d162244'),('43001100-ae57-4c36-a677-da2c1e4d31fa','1.2.2. 专业培养目标、标准及确定依据','2018-04-27 05:41:27','0',4,0,'2d467104-0f22-46a2-a9a7-1769a6f4f0f1','868146ee-afe9-47c2-b96f-d97b388f4265','9e2bb1f3-1c69-4253-ae74-b229ae1d5f48'),('46493df7-dac3-42e9-afac-b13b646fcd92','1.3.2. 人才培养中心地位的体现与效果','2018-05-04 01:36:53','0',6,0,'f9a448a0-6795-499a-8bfa-05eb4d8f4397','868146ee-afe9-47c2-b96f-d97b388f4265','9e2bb1f3-1c69-4253-ae74-b229ae1d5f48'),('4c521a95-d4cc-4aa7-a3d7-f65172ade63e','7.3.2. 创新创业训练计划、科技创新竞赛的覆盖面、受益面','2018-05-04 02:15:27','0',72,0,'35ecba12-bfab-4eb1-88b8-50c862f94445','77db709b-7b6d-452e-881e-7717d84e46de','27bd0158-e317-4215-9edf-7c4a5965fbd5'),('54eb7519-a873-41e6-886c-55bd8d900e80','3.3.3. 培养方案的制定、执行与调整','2018-05-04 01:45:39','0',24,0,'79a2e0d3-2286-4681-a624-aea1bd9752fc','77db709b-7b6d-452e-881e-7717d84e46de','04e46aa8-8653-45d2-8087-6e39c887156f'),('5512dc14-4873-403f-9e5c-f65332891e96','2.2.1. 专任教师的专业水平与教学能力','2018-05-04 01:39:14','0',10,0,'0e1abff3-9c26-4a94-b0aa-482b34ea72de','28b9c26f-ac71-4995-bce6-02eb547b5b8a','9e9c9743-afd8-4c8e-85bc-4c8a8d166521'),('5baa899d-5268-4ff0-a171-86d9e20d8d4b','6.3.2. 质量信息统计、分析、反馈机制','2018-05-04 02:10:05','0',61,0,'a348a45b-c0ee-4d0c-9c3e-5b9f15a114fb','77db709b-7b6d-452e-881e-7717d84e46de','c454630c-20e1-48c3-b6b2-ad919d162244'),('5d47e0e5-3430-454d-bb21-60ca2b9b7cae','3.1.2. 学校教学经费年度变化情况','2018-05-04 01:42:44','0',17,0,'0bf9ce82-b4c6-4df1-96c0-b5b0a562ea36','13bad3d2-3717-4846-aa3a-31347a4079a5','04e46aa8-8653-45d2-8087-6e39c887156f'),('5d8d0959-19c2-4280-bfe5-f731c2d4f53c','4.4.3. 学生国内外交流学习情况','2018-05-04 02:03:10','0',43,0,'094551b5-773a-44d4-8aa6-b1e1c63cc0c5','77db709b-7b6d-452e-881e-7717d84e46de','a82ee014-9b37-40c8-bd84-b3c3e101eed8'),('5fe2fcd9-dfca-4eac-abb0-0d01485e5b21','6.3.3. 质量信息公开及年度质量报告','2018-05-04 02:10:29','0',62,0,'a348a45b-c0ee-4d0c-9c3e-5b9f15a114fb','77db709b-7b6d-452e-881e-7717d84e46de','c454630c-20e1-48c3-b6b2-ad919d162244'),('63849c5f-f820-4480-8d9d-d3afd93ba5b9','7.1.1. 联盟体的建设情况','2018-05-04 02:11:52','0',65,0,'26e815c7-737d-4102-8ee8-352ede2eb85c','77db709b-7b6d-452e-881e-7717d84e46de','27bd0158-e317-4215-9edf-7c4a5965fbd5'),('69d6d33e-6323-4a26-9a7d-3f5bf23ccfdb','3.2.2. 教学、科研设施的开放程度及利用情况','2018-05-04 01:43:55','0',20,0,'b5e315b3-7c73-406f-8e9e-2f8e7201966f','ff601356-d336-4bb2-b971-2b2ea34dea90','04e46aa8-8653-45d2-8087-6e39c887156f'),('6d9c8a90-18e0-47f6-b464-7d2ec99afd92','6.2.2. 自我评估及质量监控的实施效果','2018-05-04 02:09:21','0',59,0,'b44d65f9-5389-43bc-ab85-9c5746ee46ef','77db709b-7b6d-452e-881e-7717d84e46de','c454630c-20e1-48c3-b6b2-ad919d162244'),('7465a1c3-2663-48be-981c-a05cfdd4c185','3.4.3. 教材建设与选用','2018-05-04 01:46:42','0',27,0,'f88757d8-c208-4bf0-adcb-46d8b1faa444','77db709b-7b6d-452e-881e-7717d84e46de','04e46aa8-8653-45d2-8087-6e39c887156f'),('77fe8c75-173c-4179-a591-b33b50691e6f','3.4.2. 课程的数量、结构及优质课程资源建设','2018-05-04 01:46:21','0',26,0,'f88757d8-c208-4bf0-adcb-46d8b1faa444','77db709b-7b6d-452e-881e-7717d84e46de','04e46aa8-8653-45d2-8087-6e39c887156f'),('7c1fddb7-6ea8-460a-a704-89aec3762534','5.1.1. 学校总体生源情况','2018-05-04 02:03:41','0',44,0,'c8973086-ab25-4de3-bf2a-d58c1adfb714','e5a9d132-8242-4889-861c-87b3852db499','7c8da989-ab0e-4241-9caf-fcb9d21fb002'),('853218d9-15ed-492e-a87b-07f65bfdb617','4.3.2. 实验教学与实验室开放情况','2018-05-04 02:01:33','0',39,0,'14bda6cd-fd65-492b-b9bc-8adab357b67a','77db709b-7b6d-452e-881e-7717d84e46de','a82ee014-9b37-40c8-bd84-b3c3e101eed8'),('891350d2-333e-4d32-afb4-aad40335db1d','4.1.3. 教学及管理信息化','2018-05-04 01:55:35','0',33,0,'4732b7c8-aeef-4b20-9fda-a35672440c35','77db709b-7b6d-452e-881e-7717d84e46de','a82ee014-9b37-40c8-bd84-b3c3e101eed8'),('8bc2e5d4-e5c6-472b-bdd6-dc448ce81e7b','4.4.2. 社团建设与校园文化、科技活动及育人效果','2018-05-04 02:02:47','0',42,0,'094551b5-773a-44d4-8aa6-b1e1c63cc0c5','77db709b-7b6d-452e-881e-7717d84e46de','a82ee014-9b37-40c8-bd84-b3c3e101eed8'),('8c141aae-7bcb-4c9d-a9df-109c6e09d422','2.3.1. 教授、副教授为本科生上课情况','2018-05-04 01:40:24','0',12,0,'21515d6d-ca9f-4be6-b72c-2b325c38fe92','28b9c26f-ac71-4995-bce6-02eb547b5b8a','9e9c9743-afd8-4c8e-85bc-4c8a8d166521'),('8c2b0c6a-0649-4bec-8329-becb5b01db7c','6.3.1. 校内教学基本状态数据库建设情况','2018-05-04 02:09:44','0',60,0,'a348a45b-c0ee-4d0c-9c3e-5b9f15a114fb','77db709b-7b6d-452e-881e-7717d84e46de','c454630c-20e1-48c3-b6b2-ad919d162244'),('8c30cd90-debf-4576-b52f-45a233b82f48','1.1.2. 办学定位在学校发展规划中的体现','2018-04-25 09:30:32','0',2,0,'111d01a2-bd8c-4218-b7ce-abecdfff2a3f','868146ee-afe9-47c2-b96f-d97b388f4265','9e2bb1f3-1c69-4253-ae74-b229ae1d5f48'),('8f41b204-68ae-41b0-90fd-0811724c96b7','6.4.1. 质量改进的途径与方法','2018-05-04 02:10:47','0',63,0,'2662e91c-f716-4282-b1e4-99bca55f1c27','77db709b-7b6d-452e-881e-7717d84e46de','c454630c-20e1-48c3-b6b2-ad919d162244'),('90e5c0af-3dc4-4684-a097-04fa827cd678','3.3.1. 专业建设规划与执行','2018-05-04 01:44:56','0',22,0,'79a2e0d3-2286-4681-a624-aea1bd9752fc','77db709b-7b6d-452e-881e-7717d84e46de','04e46aa8-8653-45d2-8087-6e39c887156f'),('96289d35-9cf6-46b6-a609-b9af73480a5d','7.2.1. 服务辽宁经济结构调整、产业转型升级、对接产业链的应用型专业体系建设情况','2018-05-04 02:13:07','0',68,0,'47f6cefe-9dc1-4b1f-8b3a-d3ec2f31bb25','77db709b-7b6d-452e-881e-7717d84e46de','27bd0158-e317-4215-9edf-7c4a5965fbd5'),('9d38c307-8396-4b67-8a39-6ad90dab3316','6.1.3. 质量保障体系的组织、制度建设','2018-05-04 02:08:15','0',56,0,'2a69c25e-e9fd-491b-bb65-2646db3c059f','77db709b-7b6d-452e-881e-7717d84e46de','c454630c-20e1-48c3-b6b2-ad919d162244'),('a29236b0-aa30-4dcf-975c-5c21e145b8db','7.1.2. 产教融合校企合作的新模式和新机制','2018-05-04 02:12:20','0',66,0,'26e815c7-737d-4102-8ee8-352ede2eb85c','77db709b-7b6d-452e-881e-7717d84e46de','27bd0158-e317-4215-9edf-7c4a5965fbd5'),('a7421bd5-5ee8-4a78-b972-a82715c78ba9','3.2.3. 教学信息化条件及资源建设','2018-05-04 01:44:36','0',21,0,'b5e315b3-7c73-406f-8e9e-2f8e7201966f','ff601356-d336-4bb2-b971-2b2ea34dea90','04e46aa8-8653-45d2-8087-6e39c887156f'),('a78f91c7-450a-4bbd-ad16-2c7622c6d79e','6.4.2. 质量改进的效果与评价','2018-05-04 02:11:08','0',64,0,'2662e91c-f716-4282-b1e4-99bca55f1c27','77db709b-7b6d-452e-881e-7717d84e46de','c454630c-20e1-48c3-b6b2-ad919d162244'),('a9b1a188-c846-4b35-b300-d58016e7f6f3','6.1.2. 质量保障模式及体系结构','2018-05-04 02:07:54','0',55,0,'2a69c25e-e9fd-491b-bb65-2646db3c059f','77db709b-7b6d-452e-881e-7717d84e46de','c454630c-20e1-48c3-b6b2-ad919d162244'),('acba43df-3c4d-4323-91bb-e798c0862420','3.3.2. 专业设置与结构调整，优势专业与新专业建设','2018-05-04 01:45:19','0',23,0,'79a2e0d3-2286-4681-a624-aea1bd9752fc','77db709b-7b6d-452e-881e-7717d84e46de','04e46aa8-8653-45d2-8087-6e39c887156f'),('b043b933-9f3c-436a-a748-cfe4ce8812eb','6.1.1. 质量标准建设','2018-05-04 02:07:36','0',54,0,'2a69c25e-e9fd-491b-bb65-2646db3c059f','77db709b-7b6d-452e-881e-7717d84e46de','c454630c-20e1-48c3-b6b2-ad919d162244'),('b3027a31-4746-4edd-b4ea-c2ddd37326d3','2.1.1. 教师队伍的数量与结构','2018-05-04 01:37:58','0',8,0,'d0c6edbc-519c-42b0-ad0f-cfeed4d26b8d','28b9c26f-ac71-4995-bce6-02eb547b5b8a','9e9c9743-afd8-4c8e-85bc-4c8a8d166521'),('b450db87-305c-423f-9600-869364ac583e','3.5.2. 共建教学资源情况','2018-05-04 01:47:20','0',29,0,'d6a6a648-57dd-4617-81fc-55136062a3a4','77db709b-7b6d-452e-881e-7717d84e46de','04e46aa8-8653-45d2-8087-6e39c887156f'),('b78766b5-de3b-4876-9cc8-60f8d2a1b1ad','7.4.2. 与境外同类高校、相关企业合作办学情况','2018-05-04 02:17:49','0',75,0,'497e9a73-b199-4944-9cc6-4d2119a8c585','77db709b-7b6d-452e-881e-7717d84e46de','27bd0158-e317-4215-9edf-7c4a5965fbd5'),('b802b9f0-bdd1-4bb8-9d63-23be6965a7d8','4.2.4. 考试考核的方式方法及管理','2018-05-04 02:00:54','0',37,0,'b1e96e7a-a470-48fc-b4e5-8a6d995f7e0c','77db709b-7b6d-452e-881e-7717d84e46de','a82ee014-9b37-40c8-bd84-b3c3e101eed8'),('b9d516b3-a8d9-4238-8a0d-2eaf35b3b32a','4.3.1. 实践教学体系建设','2018-05-04 02:01:11','0',38,0,'14bda6cd-fd65-492b-b9bc-8adab357b67a','77db709b-7b6d-452e-881e-7717d84e46de','a82ee014-9b37-40c8-bd84-b3c3e101eed8'),('c0cb6090-d60d-4ec7-9616-f230fe38a294','7.4.3. 中外合作高校间学生互换、学分互换、学位互授情况（中外高校间的合作）','2018-05-04 02:18:27','0',76,0,'497e9a73-b199-4944-9cc6-4d2119a8c585','77db709b-7b6d-452e-881e-7717d84e46de','27bd0158-e317-4215-9edf-7c4a5965fbd5'),('c0ea1024-0bb5-498c-893c-05c013da6695','3.2.1. 教学设施满足教学需要情况','2018-05-04 01:43:28','0',19,0,'b5e315b3-7c73-406f-8e9e-2f8e7201966f','ff601356-d336-4bb2-b971-2b2ea34dea90','04e46aa8-8653-45d2-8087-6e39c887156f'),('c1d218c8-edee-422a-a1b8-81b4eceef503','4.1.2. 人才培养模式改革，人才培养体制、机制改革','2018-05-04 01:55:16','0',32,0,'4732b7c8-aeef-4b20-9fda-a35672440c35','77db709b-7b6d-452e-881e-7717d84e46de','a82ee014-9b37-40c8-bd84-b3c3e101eed8'),('c34431e0-269b-4aa1-ba40-d784ecce3c10','2.2.2. 学校师德师风建设措施与效果','2018-05-04 01:39:48','0',11,0,'0e1abff3-9c26-4a94-b0aa-482b34ea72de','28b9c26f-ac71-4995-bce6-02eb547b5b8a','9e9c9743-afd8-4c8e-85bc-4c8a8d166521'),('c827b25f-6a44-4f41-96a1-24c12b83caaf','7.3.1. 创新创业教育的平台建设、资源建设、经费支持和保障措施','2018-05-04 02:14:55','0',71,0,'35ecba12-bfab-4eb1-88b8-50c862f94445','77db709b-7b6d-452e-881e-7717d84e46de','27bd0158-e317-4215-9edf-7c4a5965fbd5'),('ceb290f9-0864-4ee2-802a-958354183b8e','3.1.1. 教学经费投入及保障机制','2018-05-04 01:42:22','0',16,0,'0bf9ce82-b4c6-4df1-96c0-b5b0a562ea36','13bad3d2-3717-4846-aa3a-31347a4079a5','04e46aa8-8653-45d2-8087-6e39c887156f'),('cf996d6c-8936-400a-b081-bbe3f88a9c09','4.2.1. 教学大纲的制订与执行','2018-05-04 01:59:46','0',34,0,'b1e96e7a-a470-48fc-b4e5-8a6d995f7e0c','77db709b-7b6d-452e-881e-7717d84e46de','a82ee014-9b37-40c8-bd84-b3c3e101eed8'),('d03f6aff-fae6-4080-b89a-99d7074dfe58','4.3.3. 实习实训、社会实践、毕业设计（论文）的落实及效果','2018-05-04 02:01:53','0',40,0,'14bda6cd-fd65-492b-b9bc-8adab357b67a','77db709b-7b6d-452e-881e-7717d84e46de','a82ee014-9b37-40c8-bd84-b3c3e101eed8'),('d042d5bb-755b-4c13-a840-3bd6f40292df','6.2.1. 自我评估及质量监控的内容与方式','2018-05-04 02:08:58','0',58,0,'b44d65f9-5389-43bc-ab85-9c5746ee46ef','77db709b-7b6d-452e-881e-7717d84e46de','c454630c-20e1-48c3-b6b2-ad919d162244'),('d0df5e77-34b3-48d2-8f12-c9f7215e4759','7.4.1. 被选用省级精品开放课程门数（次）、选用省级精品开放课程门数（次）','2018-05-04 02:16:24','0',74,0,'497e9a73-b199-4944-9cc6-4d2119a8c585','77db709b-7b6d-452e-881e-7717d84e46de','27bd0158-e317-4215-9edf-7c4a5965fbd5'),('d3e20f17-1419-4a22-9eb6-c8bad453115e','4.1.1. 教学改革的总体思路及政策措施','2018-05-04 01:54:56','0',31,0,'4732b7c8-aeef-4b20-9fda-a35672440c35','77db709b-7b6d-452e-881e-7717d84e46de','a82ee014-9b37-40c8-bd84-b3c3e101eed8'),('dd6b4f6d-f737-4a00-83be-000781c65421','5.2.3. 学生指导与服务的评价','2018-05-04 02:05:24','0',48,0,'7e0e28e4-6f01-4a43-9831-4beb0219781e','e5a9d132-8242-4889-861c-87b3852db499','7c8da989-ab0e-4241-9caf-fcb9d21fb002'),('e4b156e5-47e0-4a28-acdd-6c0f06630ad2','7.1.3. 行业企业需求为导向的定向订单定制式专业人才培养成效','2018-05-04 02:12:45','0',67,0,'26e815c7-737d-4102-8ee8-352ede2eb85c','77db709b-7b6d-452e-881e-7717d84e46de','27bd0158-e317-4215-9edf-7c4a5965fbd5'),('eabd3ac1-944b-4b85-afc5-146133a759f5','5.3.1. 学风建设的措施与效果','2018-05-04 02:05:44','0',49,0,'27f462a5-ea68-45dd-95ed-3b2b18004b0a','e5a9d132-8242-4889-861c-87b3852db499','7c8da989-ab0e-4241-9caf-fcb9d21fb002'),('efbecea2-71b7-4e4c-ba3d-1e982519a155','4.2.3. 教师教学方法，学生学习方式','2018-05-04 02:00:25','0',36,0,'b1e96e7a-a470-48fc-b4e5-8a6d995f7e0c','77db709b-7b6d-452e-881e-7717d84e46de','a82ee014-9b37-40c8-bd84-b3c3e101eed8'),('f32cb2b1-f27e-425c-8904-5eece100d924','5.4.1. 毕业生就业率与学生发展情况','2018-05-04 02:06:50','0',52,0,'2fd8da35-bec6-4653-9dba-0110f34a1534','e5a9d132-8242-4889-861c-87b3852db499','7c8da989-ab0e-4241-9caf-fcb9d21fb002'),('f432f706-a555-4051-bd12-b6e185a11d7a','7.2.3. 学校整体转型、专业转型情况和取得的成效','2018-05-04 02:14:04','0',70,0,'47f6cefe-9dc1-4b1f-8b3a-d3ec2f31bb25','77db709b-7b6d-452e-881e-7717d84e46de','27bd0158-e317-4215-9edf-7c4a5965fbd5'),('f500cd10-c8c0-4230-a6f1-1f50247d0ad2','1.2.1. 学校人才培养总目标及确定依据','2018-04-27 05:39:26','0',3,0,'2d467104-0f22-46a2-a9a7-1769a6f4f0f1','868146ee-afe9-47c2-b96f-d97b388f4265','9e2bb1f3-1c69-4253-ae74-b229ae1d5f48'),('f743870e-86cc-4156-91af-8054128a3cfc','5.2.2. 学生指导与服务的组织与条件保障','2018-05-04 02:04:59','0',47,0,'27f462a5-ea68-45dd-95ed-3b2b18004b0a','e5a9d132-8242-4889-861c-87b3852db499','7c8da989-ab0e-4241-9caf-fcb9d21fb002'),('f93c9adf-d23f-4c18-8aa9-dfb28ee3b11a','3.4.1. 课程建设规划与执行','2018-05-04 01:45:59','0',25,0,'f88757d8-c208-4bf0-adcb-46d8b1faa444','77db709b-7b6d-452e-881e-7717d84e46de','04e46aa8-8653-45d2-8087-6e39c887156f'),('fa7b63be-c1b0-4c2a-8bf2-155835367b89','5.4.2. 用人单位对毕业生评价','2018-05-04 02:07:11','0',53,0,'2fd8da35-bec6-4653-9dba-0110f34a1534','e5a9d132-8242-4889-861c-87b3852db499','7c8da989-ab0e-4241-9caf-fcb9d21fb002'),('fb07b823-aab3-4e90-beea-ae56d95e0e20','1.3.3. 学校领导对本科教学的重视情况','2018-05-04 01:37:10','0',7,0,'f9a448a0-6795-499a-8bfa-05eb4d8f4397','868146ee-afe9-47c2-b96f-d97b388f4265','9e2bb1f3-1c69-4253-ae74-b229ae1d5f48');
/*!40000 ALTER TABLE `pinggu_review_point` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pinggu_review_point_duty_department`
--

DROP TABLE IF EXISTS `pinggu_review_point_duty_department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pinggu_review_point_duty_department` (
  `pointId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `dutyDepartmentId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`pointId`,`dutyDepartmentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='审核要点与责任单位中间表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinggu_review_point_duty_department`
--

LOCK TABLES `pinggu_review_point_duty_department` WRITE;
/*!40000 ALTER TABLE `pinggu_review_point_duty_department` DISABLE KEYS */;
INSERT INTO `pinggu_review_point_duty_department` VALUES ('03b1b594-dc37-46ab-8b63-7bd4c2b84e9e','0053d1ef-8b07-4cd2-9d96-ab3d21941986'),('0555df7b-0356-4f01-9058-1db85c6fa33b','7ca3e062-cd67-4e3e-9da3-cf942aeeea35'),('08f09e7b-df82-48f0-9d15-a411b860d972','5d60a1e7-0fd7-4df5-a918-c684ef10ee6e'),('08f09e7b-df82-48f0-9d15-a411b860d972','a0e84240-6326-40c2-9d05-f9954fe60c43'),('0a0fae61-e184-405c-8426-d9236dce995d','090fbb37-74f6-42cf-ad10-c962ab0b208b'),('0e0dbbf1-b8a8-4096-8d6a-d8e885810044','371748c8-70a9-44e2-8b80-633bfe147009'),('0f705361-71b9-4a77-afba-27a830979c06','e0618b7f-02ea-47b7-b412-9879c27cffd4'),('107554f5-1ac3-4808-ae9f-4472dd7b90e9','5d60a1e7-0fd7-4df5-a918-c684ef10ee6e'),('17a86c11-9864-472a-a8e5-54d3b6999840','9d246ecb-b3c0-4af5-a8f8-e795c1d66dbb'),('1a02b954-b311-49ba-924e-eeededfcae3f','37a418d8-5ca1-485a-8cef-e4217a0ac54f'),('1d722535-cf8d-4770-a4c4-507cc63423b2','7ca3e062-cd67-4e3e-9da3-cf942aeeea35'),('1de5a335-4d8f-45f6-afd9-89efc6280647','e3bfc210-1707-4af6-8d0c-51d772521150'),('1de5a335-4d8f-45f6-afd9-89efc6280647','ebaf9034-31a6-4e04-a38a-f7daf08d421a'),('27cd75af-6b1a-4166-a1ba-7117298ec9d5','5d60a1e7-0fd7-4df5-a918-c684ef10ee6e'),('27cd75af-6b1a-4166-a1ba-7117298ec9d5','a0e84240-6326-40c2-9d05-f9954fe60c43'),('28ae6681-147d-491f-ac26-9c4eb60dd645','7ca3e062-cd67-4e3e-9da3-cf942aeeea35'),('37d0e830-9407-4529-8239-f60ee4a629c1','9d246ecb-b3c0-4af5-a8f8-e795c1d66dbb'),('3946097b-08c4-4a2f-beb4-06ff6f8e15de','371748c8-70a9-44e2-8b80-633bfe147009'),('39ac5623-3928-4535-91ca-32ac6194360c','371748c8-70a9-44e2-8b80-633bfe147009'),('3a862b65-c1bf-4ba8-9027-382952d174e0','371748c8-70a9-44e2-8b80-633bfe147009'),('3df876ad-8f54-46ac-b8f0-c0474ee23b00','7ca3e062-cd67-4e3e-9da3-cf942aeeea35'),('3e7c5cea-9fd4-40fc-8cf5-1435146ae6e6','7ca3e062-cd67-4e3e-9da3-cf942aeeea35'),('43001100-ae57-4c36-a677-da2c1e4d31fa','7ca3e062-cd67-4e3e-9da3-cf942aeeea35'),('46493df7-dac3-42e9-afac-b13b646fcd92','5d60a1e7-0fd7-4df5-a918-c684ef10ee6e'),('4c521a95-d4cc-4aa7-a3d7-f65172ade63e','37a418d8-5ca1-485a-8cef-e4217a0ac54f'),('4c521a95-d4cc-4aa7-a3d7-f65172ade63e','ebaf9034-31a6-4e04-a38a-f7daf08d421a'),('54eb7519-a873-41e6-886c-55bd8d900e80','7ca3e062-cd67-4e3e-9da3-cf942aeeea35'),('5512dc14-4873-403f-9e5c-f65332891e96','7ca3e062-cd67-4e3e-9da3-cf942aeeea35'),('5baa899d-5268-4ff0-a171-86d9e20d8d4b','7ca3e062-cd67-4e3e-9da3-cf942aeeea35'),('5d47e0e5-3430-454d-bb21-60ca2b9b7cae','e0618b7f-02ea-47b7-b412-9879c27cffd4'),('5d8d0959-19c2-4280-bfe5-f731c2d4f53c','9c0cdaca-38af-4754-a53e-e003bfb989ec'),('5fe2fcd9-dfca-4eac-abb0-0d01485e5b21','7ca3e062-cd67-4e3e-9da3-cf942aeeea35'),('63849c5f-f820-4480-8d9d-d3afd93ba5b9','0053d1ef-8b07-4cd2-9d96-ab3d21941986'),('69d6d33e-6323-4a26-9a7d-3f5bf23ccfdb','860da36c-fa08-4d1c-b750-1eb40e57ae5b'),('6d9c8a90-18e0-47f6-b464-7d2ec99afd92','7ca3e062-cd67-4e3e-9da3-cf942aeeea35'),('7465a1c3-2663-48be-981c-a05cfdd4c185','7ca3e062-cd67-4e3e-9da3-cf942aeeea35'),('77fe8c75-173c-4179-a591-b33b50691e6f','7ca3e062-cd67-4e3e-9da3-cf942aeeea35'),('7c1fddb7-6ea8-460a-a704-89aec3762534','e3bfc210-1707-4af6-8d0c-51d772521150'),('853218d9-15ed-492e-a87b-07f65bfdb617','7ca3e062-cd67-4e3e-9da3-cf942aeeea35'),('891350d2-333e-4d32-afb4-aad40335db1d','7ca3e062-cd67-4e3e-9da3-cf942aeeea35'),('8bc2e5d4-e5c6-472b-bdd6-dc448ce81e7b','37a418d8-5ca1-485a-8cef-e4217a0ac54f'),('8c141aae-7bcb-4c9d-a9df-109c6e09d422','7ca3e062-cd67-4e3e-9da3-cf942aeeea35'),('8c2b0c6a-0649-4bec-8329-becb5b01db7c','7ca3e062-cd67-4e3e-9da3-cf942aeeea35'),('8c30cd90-debf-4576-b52f-45a233b82f48','7ca3e062-cd67-4e3e-9da3-cf942aeeea35'),('8f41b204-68ae-41b0-90fd-0811724c96b7','7ca3e062-cd67-4e3e-9da3-cf942aeeea35'),('90e5c0af-3dc4-4684-a097-04fa827cd678','7ca3e062-cd67-4e3e-9da3-cf942aeeea35'),('96289d35-9cf6-46b6-a609-b9af73480a5d','557e899c-2f96-4d81-a43d-25d836e0a86d'),('96289d35-9cf6-46b6-a609-b9af73480a5d','7ca3e062-cd67-4e3e-9da3-cf942aeeea35'),('9d38c307-8396-4b67-8a39-6ad90dab3316','7ca3e062-cd67-4e3e-9da3-cf942aeeea35'),('a29236b0-aa30-4dcf-975c-5c21e145b8db','557e899c-2f96-4d81-a43d-25d836e0a86d'),('a29236b0-aa30-4dcf-975c-5c21e145b8db','7ca3e062-cd67-4e3e-9da3-cf942aeeea35'),('a7421bd5-5ee8-4a78-b972-a82715c78ba9','0964c823-30ef-43f0-9583-96f3a8c3a491'),('a7421bd5-5ee8-4a78-b972-a82715c78ba9','7a380903-9f60-478a-b8d1-2d23c3d75c0d'),('a7421bd5-5ee8-4a78-b972-a82715c78ba9','a0865ca4-96b1-4915-9a01-7da00b6283fe'),('a78f91c7-450a-4bbd-ad16-2c7622c6d79e','7ca3e062-cd67-4e3e-9da3-cf942aeeea35'),('a9b1a188-c846-4b35-b300-d58016e7f6f3','7ca3e062-cd67-4e3e-9da3-cf942aeeea35'),('acba43df-3c4d-4323-91bb-e798c0862420','7ca3e062-cd67-4e3e-9da3-cf942aeeea35'),('b043b933-9f3c-436a-a748-cfe4ce8812eb','7ca3e062-cd67-4e3e-9da3-cf942aeeea35'),('b3027a31-4746-4edd-b4ea-c2ddd37326d3','090fbb37-74f6-42cf-ad10-c962ab0b208b'),('b450db87-305c-423f-9600-869364ac583e','7ca3e062-cd67-4e3e-9da3-cf942aeeea35'),('b78766b5-de3b-4876-9cc8-60f8d2a1b1ad','7ca3e062-cd67-4e3e-9da3-cf942aeeea35'),('b78766b5-de3b-4876-9cc8-60f8d2a1b1ad','9c0cdaca-38af-4754-a53e-e003bfb989ec'),('b802b9f0-bdd1-4bb8-9d63-23be6965a7d8','7ca3e062-cd67-4e3e-9da3-cf942aeeea35'),('b9d516b3-a8d9-4238-8a0d-2eaf35b3b32a','7ca3e062-cd67-4e3e-9da3-cf942aeeea35'),('c0cb6090-d60d-4ec7-9616-f230fe38a294','9c0cdaca-38af-4754-a53e-e003bfb989ec'),('c0ea1024-0bb5-498c-893c-05c013da6695','860da36c-fa08-4d1c-b750-1eb40e57ae5b'),('c1d218c8-edee-422a-a1b8-81b4eceef503','7ca3e062-cd67-4e3e-9da3-cf942aeeea35'),('c34431e0-269b-4aa1-ba40-d784ecce3c10','7ca3e062-cd67-4e3e-9da3-cf942aeeea35'),('c827b25f-6a44-4f41-96a1-24c12b83caaf','37a418d8-5ca1-485a-8cef-e4217a0ac54f'),('c827b25f-6a44-4f41-96a1-24c12b83caaf','ebaf9034-31a6-4e04-a38a-f7daf08d421a'),('ceb290f9-0864-4ee2-802a-958354183b8e','e0618b7f-02ea-47b7-b412-9879c27cffd4'),('cf996d6c-8936-400a-b081-bbe3f88a9c09','7ca3e062-cd67-4e3e-9da3-cf942aeeea35'),('d03f6aff-fae6-4080-b89a-99d7074dfe58','7ca3e062-cd67-4e3e-9da3-cf942aeeea35'),('d042d5bb-755b-4c13-a840-3bd6f40292df','7ca3e062-cd67-4e3e-9da3-cf942aeeea35'),('d0df5e77-34b3-48d2-8f12-c9f7215e4759','7ca3e062-cd67-4e3e-9da3-cf942aeeea35'),('d3e20f17-1419-4a22-9eb6-c8bad453115e','7ca3e062-cd67-4e3e-9da3-cf942aeeea35'),('dd6b4f6d-f737-4a00-83be-000781c65421','371748c8-70a9-44e2-8b80-633bfe147009'),('e4b156e5-47e0-4a28-acdd-6c0f06630ad2','7ca3e062-cd67-4e3e-9da3-cf942aeeea35'),('eabd3ac1-944b-4b85-afc5-146133a759f5','371748c8-70a9-44e2-8b80-633bfe147009'),('efbecea2-71b7-4e4c-ba3d-1e982519a155','7ca3e062-cd67-4e3e-9da3-cf942aeeea35'),('f32cb2b1-f27e-425c-8904-5eece100d924','e3bfc210-1707-4af6-8d0c-51d772521150'),('f432f706-a555-4051-bd12-b6e185a11d7a','7ca3e062-cd67-4e3e-9da3-cf942aeeea35'),('f500cd10-c8c0-4230-a6f1-1f50247d0ad2','7ca3e062-cd67-4e3e-9da3-cf942aeeea35'),('f743870e-86cc-4156-91af-8054128a3cfc','371748c8-70a9-44e2-8b80-633bfe147009'),('f93c9adf-d23f-4c18-8aa9-dfb28ee3b11a','7ca3e062-cd67-4e3e-9da3-cf942aeeea35'),('fa7b63be-c1b0-4c2a-8bf2-155835367b89','e3bfc210-1707-4af6-8d0c-51d772521150'),('fb07b823-aab3-4e90-beea-ae56d95e0e20','5d60a1e7-0fd7-4df5-a918-c684ef10ee6e');
/*!40000 ALTER TABLE `pinggu_review_point_duty_department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pinggu_review_project`
--

DROP TABLE IF EXISTS `pinggu_review_project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pinggu_review_project` (
  `projectId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `projectName` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '项目名',
  `projectCreateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `adminId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '添加者ID',
  `deleteFlag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标识：0为未删除  1为已删除',
  `projectSort` int(11) NOT NULL COMMENT '排序键',
  PRIMARY KEY (`projectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='审核项目表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinggu_review_project`
--

LOCK TABLES `pinggu_review_project` WRITE;
/*!40000 ALTER TABLE `pinggu_review_project` DISABLE KEYS */;
INSERT INTO `pinggu_review_project` VALUES ('04e46aa8-8653-45d2-8087-6e39c887156f','3. 教学资源','2018-04-25 01:18:08','0',0,3),('27bd0158-e317-4215-9edf-7c4a5965fbd5','7. 服务辽宁','2018-04-25 01:19:42','0',0,7),('7c8da989-ab0e-4241-9caf-fcb9d21fb002','5. 学生发展','2018-04-25 01:19:03','0',0,5),('9e2bb1f3-1c69-4253-ae74-b229ae1d5f48','1. 定位与目标','2018-04-25 01:17:10','0',0,1),('9e9c9743-afd8-4c8e-85bc-4c8a8d166521','2. 师资队伍','2018-04-25 01:17:33','0',0,2),('a82ee014-9b37-40c8-bd84-b3c3e101eed8','4. 培养过程','2018-04-25 01:18:32','0',0,4),('c454630c-20e1-48c3-b6b2-ad919d162244','6. 质量保障','2018-04-25 01:19:23','0',0,6),('ee7b8be7-6508-4d96-a44d-2391569932fe','8. 自选特色项目','2018-04-25 01:20:06','0',0,8);
/*!40000 ALTER TABLE `pinggu_review_project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pinggu_score`
--

DROP TABLE IF EXISTS `pinggu_score`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pinggu_score` (
  `scoreId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `scoreContent` varchar(10) COLLATE utf8_unicode_ci NOT NULL COMMENT '分数内容',
  PRIMARY KEY (`scoreId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='分数表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinggu_score`
--

LOCK TABLES `pinggu_score` WRITE;
/*!40000 ALTER TABLE `pinggu_score` DISABLE KEYS */;
INSERT INTO `pinggu_score` VALUES ('06c508c2-6e5b-4cb5-b013-1745a8791308','1'),('385875aa-f5db-4369-bc14-71de1e6c25b8','2'),('7ed9a73d-83d1-4ec1-96eb-edadaf6e622b','3'),('bef8fbb7-8e96-478d-b4c5-8e1a0cbed9cf','4'),('cebf5fc6-7443-4986-b986-3fcbc64d1d6b','5');
/*!40000 ALTER TABLE `pinggu_score` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pinggu_support_file`
--

DROP TABLE IF EXISTS `pinggu_support_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pinggu_support_file` (
  `supportFileId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `departmentId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '部门ID',
  `userId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '上传人ID',
  `fileTypeFlag` varchar(10) COLLATE utf8_unicode_ci NOT NULL COMMENT '格式标识 用字符串存储 PDF等',
  `supportFileCreateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '文件添加时间',
  `pointId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '审核要点ID',
  `dutyDepartmentId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '责任部门ID',
  `leadDepartmentId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '牵头部门ID',
  `supportFileName` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '文件名',
  `supportFileDbName` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '业务文件名',
  `supportFilePath` varchar(1000) COLLATE utf8_unicode_ci NOT NULL COMMENT '文件路径',
  `deleteFlag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标识：0为未删除 1为已删除',
  `supportFileRemark` varchar(1000) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '支撑文件备注',
  `projectId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `elementId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '审核要素Id',
  PRIMARY KEY (`supportFileId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='支撑文件表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinggu_support_file`
--

LOCK TABLES `pinggu_support_file` WRITE;
/*!40000 ALTER TABLE `pinggu_support_file` DISABLE KEYS */;
INSERT INTO `pinggu_support_file` VALUES ('535277a0-642b-49c0-9d42-1169215d7780','2349a19d-cfc0-414b-81c9-a8cea3d2ca8a','38475c46-6e18-4209-bdcc-4a4d2faa9e87','pdf','2018-05-06 13:39:13','27cd75af-6b1a-4166-a1ba-7117298ec9d5','a0e84240-6326-40c2-9d05-f9954fe60c43','28b9c26f-ac71-4995-bce6-02eb547b5b8a','评建办发201803号：关于成立教学单位评建工作组的通知.pdf','67c95492c6cae3621fb2d717579dd48e.pdf','/var/pinggu/support/9e2bb1f3-1c69-4253-ae74-b229ae1d5f48/111d01a2-bd8c-4218-b7ce-abecdfff2a3f/27cd75af-6b1a-4166-a1ba-7117298ec9d5/28b9c26f-ac71-4995-bce6-02eb547b5b8a/a0e84240-6326-40c2-9d05-f9954fe60c43/',1,'','9e2bb1f3-1c69-4253-ae74-b229ae1d5f48','111d01a2-bd8c-4218-b7ce-abecdfff2a3f');
/*!40000 ALTER TABLE `pinggu_support_file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pinggu_support_file_archive`
--

DROP TABLE IF EXISTS `pinggu_support_file_archive`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pinggu_support_file_archive` (
  `supportFileArchiveId` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '支撑文件归档Id',
  `supportArchiveCreateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '归档时间',
  `supportFileName` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '文件名',
  `supportFileDbName` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '业务文件名',
  `supportFilePath` varchar(1000) CHARACTER SET utf8 NOT NULL COMMENT '文件路径',
  `archiveUserId` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '归档人Id',
  `fileReadNum` int(11) NOT NULL COMMENT '文件阅读数',
  `uploadUserId` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '文件上传人Id',
  `uploadTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '文件上传时间',
  `archiveFilePath` varchar(1000) CHARACTER SET utf8 NOT NULL COMMENT '归档文件路径',
  `supportFileId` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '支撑文件Id',
  PRIMARY KEY (`supportFileArchiveId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='支撑文件的归档表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinggu_support_file_archive`
--

LOCK TABLES `pinggu_support_file_archive` WRITE;
/*!40000 ALTER TABLE `pinggu_support_file_archive` DISABLE KEYS */;
INSERT INTO `pinggu_support_file_archive` VALUES ('ec2df202-c724-4dea-8c1b-a6d6d0ae57e9','2018-04-25 09:35:19','督导通知（第二号）0420.doc','d1690b8518ce71a2f4751a887c755c07.doc','/var/pinggu/support/9e2bb1f3-1c69-4253-ae74-b229ae1d5f48/111d01a2-bd8c-4218-b7ce-abecdfff2a3f/27cd75af-6b1a-4166-a1ba-7117298ec9d5/28b9c26f-ac71-4995-bce6-02eb547b5b8a/a0e84240-6326-40c2-9d05-f9954fe60c43/','38475c46-6e18-4209-bdcc-4a4d2faa9e87',0,'38475c46-6e18-4209-bdcc-4a4d2faa9e87','2018-04-25 09:35:08','/var/pinggu/archive/support/9e2bb1f3-1c69-4253-ae74-b229ae1d5f48/111d01a2-bd8c-4218-b7ce-abecdfff2a3f/27cd75af-6b1a-4166-a1ba-7117298ec9d5/28b9c26f-ac71-4995-bce6-02eb547b5b8a/a0e84240-6326-40c2-9d05-f9954fe60c43/','535277a0-642b-49c0-9d42-1169215d7780');
/*!40000 ALTER TABLE `pinggu_support_file_archive` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pinggu_support_file_modify`
--

DROP TABLE IF EXISTS `pinggu_support_file_modify`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pinggu_support_file_modify` (
  `supportFileModifyId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '支撑文件修改Id',
  `userId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '修改人ID',
  `supportFileId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '支撑文件Id',
  `supportModifyTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '支撑文件修改时间',
  `supportArchiveId` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT '支撑文件归档Id',
  `modifyFlag` int(11) NOT NULL DEFAULT '0' COMMENT '支撑文件修改标识：0为编辑，1为删除',
  PRIMARY KEY (`supportFileModifyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='支撑文件修改表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinggu_support_file_modify`
--

LOCK TABLES `pinggu_support_file_modify` WRITE;
/*!40000 ALTER TABLE `pinggu_support_file_modify` DISABLE KEYS */;
INSERT INTO `pinggu_support_file_modify` VALUES ('65612a45-fad1-4e52-b3e0-63fd437fb915','38475c46-6e18-4209-bdcc-4a4d2faa9e87','535277a0-642b-49c0-9d42-1169215d7780','2018-04-25 09:35:08','0',0),('865cf655-79c1-4b26-9dea-432b39688340','38475c46-6e18-4209-bdcc-4a4d2faa9e87','535277a0-642b-49c0-9d42-1169215d7780','2018-04-25 09:35:19','ec2df202-c724-4dea-8c1b-a6d6d0ae57e9',0);
/*!40000 ALTER TABLE `pinggu_support_file_modify` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pinggu_support_file_person_record`
--

DROP TABLE IF EXISTS `pinggu_support_file_person_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pinggu_support_file_person_record` (
  `supportFileReadPersonId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '支撑文件阅读Id',
  `userId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '阅读者ID',
  `supportPersonReadTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '阅读时间',
  `readSupportFileId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '关联文章阅读记录ID',
  `userType` tinyint(4) NOT NULL DEFAULT '0' COMMENT '阅读人类型标识：评审用户1 普通用户0',
  PRIMARY KEY (`supportFileReadPersonId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='支撑文件阅读者记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinggu_support_file_person_record`
--

LOCK TABLES `pinggu_support_file_person_record` WRITE;
/*!40000 ALTER TABLE `pinggu_support_file_person_record` DISABLE KEYS */;
INSERT INTO `pinggu_support_file_person_record` VALUES ('39432cf6-efaf-4af2-9a85-c320b1cd5ca7','3a9cbdd2-27f7-4da7-b58d-5df8d142d2a4','2018-05-04 08:36:23','535277a0-642b-49c0-9d42-1169215d7780',1),('41c38558-6c78-4fc5-881d-8f8e6c6b0b63','38475c46-6e18-4209-bdcc-4a4d2faa9e87','2018-05-06 13:19:37','535277a0-642b-49c0-9d42-1169215d7780',0),('5894ae0d-4adb-415f-b4c7-82072ec36cce','38475c46-6e18-4209-bdcc-4a4d2faa9e87','2018-04-25 09:50:28','535277a0-642b-49c0-9d42-1169215d7780',0),('9385afd5-0ae1-4386-a66c-07f95a10b336','38475c46-6e18-4209-bdcc-4a4d2faa9e87','2018-04-27 05:14:23','535277a0-642b-49c0-9d42-1169215d7780',0),('96142d01-0b66-4b19-a9ec-9977b1a1a064','38475c46-6e18-4209-bdcc-4a4d2faa9e87','2018-04-25 09:35:21','535277a0-642b-49c0-9d42-1169215d7780',0),('b3dbddd6-1617-4774-90be-baffcb65fa82','3a9cbdd2-27f7-4da7-b58d-5df8d142d2a4','2018-04-25 23:57:18','535277a0-642b-49c0-9d42-1169215d7780',1),('be66faa7-3fd8-4b77-99c4-ce262935074d','3a9cbdd2-27f7-4da7-b58d-5df8d142d2a4','2018-04-25 09:59:47','535277a0-642b-49c0-9d42-1169215d7780',1),('d3426b14-5f2b-4651-b8f2-3ef39c7ed828','3a9cbdd2-27f7-4da7-b58d-5df8d142d2a4','2018-05-04 08:36:17','535277a0-642b-49c0-9d42-1169215d7780',1),('eb1a3fe0-2125-415c-a35f-4171c2763dc5','3a9cbdd2-27f7-4da7-b58d-5df8d142d2a4','2018-04-27 05:16:36','535277a0-642b-49c0-9d42-1169215d7780',1);
/*!40000 ALTER TABLE `pinggu_support_file_person_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pinggu_support_file_read_record`
--

DROP TABLE IF EXISTS `pinggu_support_file_read_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pinggu_support_file_read_record` (
  `supportFileId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '支撑文件ID',
  `readSupportNumber` int(11) NOT NULL DEFAULT '0' COMMENT '阅读数'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='支撑文件阅读记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinggu_support_file_read_record`
--

LOCK TABLES `pinggu_support_file_read_record` WRITE;
/*!40000 ALTER TABLE `pinggu_support_file_read_record` DISABLE KEYS */;
INSERT INTO `pinggu_support_file_read_record` VALUES ('535277a0-642b-49c0-9d42-1169215d7780',9);
/*!40000 ALTER TABLE `pinggu_support_file_read_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pinggu_type`
--

DROP TABLE IF EXISTS `pinggu_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pinggu_type` (
  `typeId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `typeName` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '类别名',
  `typeCreateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '类别的添加时间',
  `adminId` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '添加者ID',
  `lockFlag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '锁标识：0为未上锁 1为已上锁',
  `deleteFlag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标识：0为未删除  1为已删除',
  `typeFileNumber` tinyint(4) NOT NULL COMMENT '需要上传的文件数',
  PRIMARY KEY (`typeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='部门类别表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinggu_type`
--

LOCK TABLES `pinggu_type` WRITE;
/*!40000 ALTER TABLE `pinggu_type` DISABLE KEYS */;
INSERT INTO `pinggu_type` VALUES ('1ab91c71-7a71-4c62-b1da-8d9d8da71430','7. 服务辽宁','2018-05-16 05:45:09','0',0,1,5),('3467af54-7a7e-4071-b3b8-0a58182a03a8','测试类别删除','2018-04-22 12:50:00','0',0,1,3),('50ce4f9b-8448-4341-8921-a7db13d7c11b','4. 培养过程','2018-05-16 05:45:10','0',0,1,6),('6fa3bac1-b8dd-4fc4-bf7e-a53fba9804e0','5. 学生发展','2018-05-16 05:45:11','0',0,1,6),('7061faf4-0d3d-4d5a-92af-7947c910dd8e','3. 教学资源','2018-05-16 05:45:12','0',0,1,4),('7c82a66a-e5c3-412f-9b1f-8b734de607af','试卷','2018-05-09 00:54:06','0',0,1,3),('83a9a972-0ce9-4ed5-a753-7936aa86f6d6','实施方案','2018-05-16 05:45:27','0',0,0,1),('a49532ee-a94c-497e-8a01-df2acee52f36','自评总结','2018-05-16 05:46:06','0',0,0,2),('d52f4ce7-7bcd-4c75-ae19-5f35c710939a','8. 特色项目','2018-05-16 05:45:14','0',0,1,2);
/*!40000 ALTER TABLE `pinggu_type` ENABLE KEYS */;
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
INSERT INTO `system_menu` VALUES ('00427a88-9860-44eb-bede-528fa8eea040','b3db40b5-4643-4600-994a-115f14eb976e','系统角色配置','/admin/role',1,'',18,'system','系统配置','2018-04-25 09:16:27',0,0),('091ec75f-b9d6-4a9d-a54e-2ebc92f747b3','edc4d53c-2e25-4738-9a41-4efda775f2da','审核项目管理','/admin/project',1,'',17,'supportFile','支撑文件','2018-04-25 09:16:27',0,0),('10e76916-e69d-4527-96d1-93667cdddf8a','ea50eecd-c110-4dca-a675-b73286820326','上传文档管理','/admin/paperFile',1,'',15,'paperFile','试卷文件管理','2018-05-15 10:05:50',0,0),('14c179a9-8000-472d-a639-aae0153b8fe0','b3db40b5-4643-4600-994a-115f14eb976e','日志','/admin/log',1,'',10,'config','系统配置','2018-04-25 09:16:27',0,0),('346559e0-8e7b-4bb2-a525-c446697ef83e','b3db40b5-4643-4600-994a-115f14eb976e','系统配置','/admin/config',1,'',4,'config','系统配置','2018-04-25 09:16:27',0,0),('3ceb785c-fd96-494a-82f7-ce0c5ba12287','cf2460a1-d046-40ae-a67c-bb67fb84bf3c','评审用户管理','/admin/user/rater',1,'',19,'frontUser','前台用户','2018-04-25 09:16:27',0,0),('4c174eb5-c638-4241-a5fc-c1592cb3dbf5','0','评价子系统','',1,'fa fa-address-card-o',25,'menu:parent','父菜单','2018-05-03 04:17:30',1,1),('4d3bbc92-b99f-4776-93c3-d04137e80c45','b3db40b5-4643-4600-994a-115f14eb976e','系统UI配置','/admin/ui',1,'',7,'system','系统配置','2018-04-25 09:16:27',0,0),('5b5ea24d-45d7-4739-bbbe-73fd8fe57182','b8067050-2ca5-4441-9fb8-33b9ae4d47f8','评审文件管理','/admin/raterFile',1,'',15,'file','文件管理','2018-04-25 09:16:27',0,0),('5c48fec0-8166-41a7-aea0-40bd18b97750','edc4d53c-2e25-4738-9a41-4efda775f2da','支撑文件管理','/admin/supportFile',1,'',8,'file','文件管理','2018-04-25 09:16:27',0,0),('64b8159c-c149-4439-9159-10a3e990fe7f','b3db40b5-4643-4600-994a-115f14eb976e','系统菜单配置','/admin/menu',1,'',11,'system','系统配置','2018-04-25 09:16:27',0,0),('7f89f00c-affd-4d49-a0db-ab64d115bb9b','ea50eecd-c110-4dca-a675-b73286820326','课程管理','/admin/subject',1,'',0,'paperFile','试卷文件管理','2018-05-15 10:05:50',0,0),('81136b2c-acc7-4501-9cfc-d42a6b72aba0','4c174eb5-c638-4241-a5fc-c1592cb3dbf5','评审问题管理','/admin/problem',1,'',3,'problem','评审问题','2018-04-25 09:16:27',0,0),('9cb58155-7d41-422d-833f-862d6762f128','edc4d53c-2e25-4738-9a41-4efda775f2da','审核要点管理','/admin/point',1,'',12,'supportFile','支撑文件','2018-04-25 09:16:27',0,0),('a0b0024b-9c0c-44bd-b7b1-852c90f80b78','cf2460a1-d046-40ae-a67c-bb67fb84bf3c','普通用户管理','/admin/user/general',1,'',0,'frontUser','前台用户','2018-04-25 09:16:27',0,0),('aecee7a0-243e-4e7b-861e-399f6a042f6a','edc4d53c-2e25-4738-9a41-4efda775f2da','责任部门管理','/admin/department/duty',1,'',14,'supportFile','支撑文件','2018-04-25 09:16:27',0,0),('b3db40b5-4643-4600-994a-115f14eb976e','0','系统管理','',1,'fa fa-sliders',21,'menu:parent','父菜单','2018-04-25 09:17:28',1,1),('b5e66b58-d1f0-428e-878f-c0dd1a97c5d1','b3db40b5-4643-4600-994a-115f14eb976e','系统权限管理','/admin/permission',1,'',5,'system','系统配置','2018-04-25 09:16:27',0,0),('b8067050-2ca5-4441-9fb8-33b9ae4d47f8','0','自评材料子系统','',1,'fa fa-cloud-upload',24,'menu:parent','父菜单','2018-04-25 10:25:01',1,1),('cf2460a1-d046-40ae-a67c-bb67fb84bf3c','0','用户管理','',1,'fa-user',23,'menu:parent','父菜单','2018-04-25 09:18:32',1,1),('cffa03d1-095c-46e1-a1b5-1f7413d5063e','b8067050-2ca5-4441-9fb8-33b9ae4d47f8','类型管理','/admin/type',1,'',9,'problem','评审问题','2018-04-25 09:16:27',0,0),('d4ffc71c-e2e0-40eb-a9c3-06cb47de7b5a','edc4d53c-2e25-4738-9a41-4efda775f2da','牵头部门管理','/admin/lead',1,'',16,'supportFile','支撑文件','2018-04-25 09:16:27',0,0),('d7282933-211f-4251-832a-48ceb644c5ef','4c174eb5-c638-4241-a5fc-c1592cb3dbf5','分数管理','/admin/score',1,'',6,'problem','评审问题','2018-04-25 09:16:27',0,0),('d9c8f646-e711-4064-8379-cbb64633df39','ea50eecd-c110-4dca-a675-b73286820326','专业管理','/admin/discipline',1,'',17,'paperFile','试卷文件管理','2018-05-15 10:05:50',0,0),('da2e2573-2a56-406b-94d1-9b7eecaef8a6','b8067050-2ca5-4441-9fb8-33b9ae4d47f8','部门管理','/admin/department',1,'',13,'problem','评审问题','2018-04-25 09:16:27',0,0),('e6e2cd04-fdf0-492b-b8a5-42983c05952a','b3db40b5-4643-4600-994a-115f14eb976e','系统用户管理','/admin/user',1,'',1,'system','系统配置','2018-04-25 09:16:27',0,0),('ea50eecd-c110-4dca-a675-b73286820326','0','教学文档子系统','',1,'fa-envelope',26,'menu:parent','父菜单','2018-05-16 00:32:55',1,1),('ec13b723-f19b-40c8-830b-912d6178edfb','ea50eecd-c110-4dca-a675-b73286820326','学院管理','/admin/college',1,'',23,'paperFile','试卷文件管理','2018-05-15 10:05:50',0,0),('ecbe8ce4-e8f6-427e-9e23-d756d03239e3','edc4d53c-2e25-4738-9a41-4efda775f2da','审核要素管理','/admin/element',1,'',2,'supportFile','支撑文件','2018-04-25 09:16:27',0,0),('edc4d53c-2e25-4738-9a41-4efda775f2da','0','支撑文件子系统','',1,'fa fa-file',22,'menu:parent','父菜单','2018-04-25 09:18:17',1,1),('f339d55a-08db-461f-89fa-1ee832be8a55','ea50eecd-c110-4dca-a675-b73286820326','文档类别管理','/admin/paper',1,'',11,'paperFile','试卷文件管理','2018-05-15 10:05:50',0,0);
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
INSERT INTO `system_permission` VALUES ('04ce2ff5-2825-470f-9705-fde664ff635a','菜单编辑查询','','2018-04-25 09:16:27','menu','menu:mer','菜单组'),('09e14dc6-3b6e-48f1-a783-208c68043d6a','审责任部门添加','','2018-04-25 09:16:27','supportFile','dutyDepartment:fc','责任部门管理组'),('0c0b9fd7-f489-432b-925c-66a1f286f704','角色删除','','2018-04-25 09:16:27','role','role:rd','角色组'),('0c2398b2-6409-4566-b968-0cc57586eec7','问题类型详细','','2018-04-25 09:16:27','type','type:mr','类型组'),('0cf108f7-635c-4bbb-8e6c-2c8beb72a7d2','普通用户查看','','2018-04-25 09:16:27','generalUser','generalUser:mr','普通用户组'),('10f25dee-9d46-4f6a-ad91-55d97b6cd361','课程添加','','2018-05-15 10:05:50','paperFile','subject:mc','试卷文件组'),('163122c9-8104-4435-949f-4b70ff0729a7','专业查看','','2018-05-15 10:05:50','paperFile','discipline:mr','试卷文件组'),('165523d8-899a-4e82-9e33-8b6dc143c294','角色添加','','2018-04-25 09:16:27','role','role:ra','角色组'),('18f38fc9-c6fb-4375-8c40-39a2a167385d','专业查看详细','','2018-05-15 10:05:50','paperFile','discipline:mr','试卷文件组'),('196646fb-1f9c-4e3e-a72d-d043a82377b7','课程删除','','2018-05-15 10:05:50','paperFile','subject:md','试卷文件组'),('1fe9a067-a528-4ce6-89e8-22746902223f','UI更新','','2018-04-25 09:16:27','ui','ui:','UI组'),('20443040-c7fc-4ff0-bff0-7d475ebb7f62','独立菜单查询','','2018-04-25 09:16:27','menu','menu:amr','菜单组'),('20c129ad-f643-4b8d-873a-a43668b20165','责任部门详细','','2018-04-25 09:16:27','supportFile','dutyDepartment:fd','责任部门管理组'),('2289c305-8b26-4278-a7db-a1a1b2acb552','配置查看','','2018-04-25 09:16:27','config','config:mr','配置组'),('22b6bc44-4da8-4884-bab0-06a3b38b3c3e','问题详细','','2018-04-25 09:16:27','problem','problem:mr','问题组'),('246c6928-9be4-4e46-86a7-c03e38b99a59','日志查看','','2018-04-25 09:16:27','log','log:mr','日志组'),('24bd6183-1689-46a3-84fa-1a5ee26e25ef','部门添加','','2018-04-25 09:16:27','department','department:mc','部门组'),('2524fda7-1a41-4914-b3a8-777175c2cbdb','试卷编辑','','2018-05-15 10:05:50','paperFile','paper:mu','试卷文件组'),('2539ad15-9d60-47ca-be65-438d3c549e9f','试卷添加','','2018-05-15 10:05:50','paperFile','paper:mc','试卷文件组'),('27fc98f7-0c7d-4bc3-93a6-62f7773cb79b','普通用户删除','','2018-04-25 09:16:27','generalUser','generalUser:md','普通用户组'),('2a63265b-df40-4290-97f0-78c0a9667465','全部子菜单查询','','2018-04-25 09:16:27','menu','menu:acmr','菜单组'),('2bbd7345-3874-49f0-80dd-e49f57d54884','牵头部门删除','','2018-04-25 09:16:27','supportFile','leadDepartment:fd','牵头部门管理组'),('2d204c05-fc7f-4df0-adbb-729fe37b6dcc','配置编辑','','2018-04-25 09:16:27','config','config:mr','配置组'),('2d6094d1-fce5-4ff0-a9c9-5297bd7173cd','学院编辑','','2018-05-15 10:05:50','paperFile','college:mu','试卷文件组'),('32a84b2d-f67a-40b5-826b-4b8dc5e249cd','用户角色更新','','2018-04-25 09:16:27','user','user:uru','用户组'),('36b52dc3-d64d-4714-afd2-b3554a785da2','用户更新','','2018-04-25 09:16:27','user','user:uu','用户组'),('379a8674-2794-4fe6-a09b-6ea84ee6d66e','审核要素查看','','2018-04-25 09:16:27','supportFile','element:fr','审核要素管理组'),('3914f6e2-f325-4a2d-82cc-7bdefeeee7e8','所有权限查询','','2018-04-25 09:16:27','permission','permission:apr','权限组'),('3966f315-fa51-4cd6-9d26-b0fceaf93a3c','分数添加','','2018-04-25 09:16:27','score','score:mc','分数组'),('3b66adec-3608-494b-93a7-4535856d15ce','审核要素添加','','2018-04-25 09:16:27','supportFile','element:fc','审核要素管理组'),('3b6aaff8-8a63-42fa-b151-7b2f46b5cc79','角色权限查询','','2018-04-25 09:16:27','permission','permission:rrolep','权限组'),('3d15cb8f-72e1-4499-a753-42f76a60cd7a','问题类型查看','','2018-04-25 09:16:27','type','type:mu','类型组'),('3d24b72e-04bb-467e-816d-0d754921f988','学院添加','','2018-05-15 10:05:50','paperFile','college:mc','试卷文件组'),('3f665925-ded0-416c-9f58-d627d2c37c49','评审用户详细','','2018-04-25 09:16:27','frontUser','raterUser:md','评审用户组'),('400e334d-4e52-4c12-a917-d4d3034f874f','审核项目删除','','2018-04-25 09:16:27','supportFile','project:fd','审核项目管理组'),('40986dcb-f7fd-4ae3-97f5-bce0335a33c2','支撑问件删除','','2018-04-25 09:16:27','support','support:md','支撑文件组'),('416f165f-9739-4a74-af84-10e8964c10fd','试卷文件删除','','2018-05-15 10:05:50','paperFile','paperFile:md','试卷文件组'),('4417f473-1338-416c-84e2-27aa43be1b39','试卷删除','','2018-05-15 10:05:50','paperFile','paper:md','试卷文件组'),('45990970-a177-41bc-993a-6f6258201c21','问题类型删除','','2018-04-25 09:16:27','type','type:md','类型组'),('45c1221b-fce7-4da8-b08a-cccae5790721','审查要点添加','','2018-04-25 09:16:27','supportFile','point:fc','审查要点管理组'),('45de11dd-7556-4c81-b34c-c33f31bcd92a','审核要素删除','','2018-04-25 09:16:27','supportFile','element:fd','审核要素管理组'),('4cf3e598-97ee-4575-8929-aed843b97c3d','评审用户添加','','2018-04-25 09:16:27','frontUser','raterUser:mc','普通用户组'),('4dd6f0a2-eb27-4c96-8d27-e5d77849ccb2','审查要点删除','','2018-04-25 09:16:27','supportFile','point:fd','审查要点管理组'),('521b4911-38ce-4a67-8019-0110a71d58cd','审核项目详细','','2018-04-25 09:16:27','supportFile','project:fd','审核项目管理组'),('56338634-d117-4663-bde2-af0b31c689f4','用户删除','','2018-04-25 09:16:27','user','user:ud','用户组'),('56bd01eb-bb92-44f7-ab3d-06fa24833de4','专业添加','','2018-05-15 10:05:50','paperFile','discipline:mc','试卷文件组'),('56cf226f-c2ee-4825-aeaa-baa71b78ceaa','支撑问件查看','','2018-04-25 09:16:27','support','support:mr','支撑文件组'),('57d846ee-8d2e-4185-8ec3-75ef7af7bb41','责任部门查看','','2018-04-25 09:16:27','supportFile','dutyDepartment:fr','责任部门管理组'),('5866b634-cffd-4192-9f31-326a4ee3b8b1','普通用户添加','','2018-04-25 09:16:27','generalUser','generalUser:mc','普通用户组'),('5a3c99a9-c91e-4506-8d50-766287d4f64d','牵头部门添加','','2018-04-25 09:16:27','supportFile','leadDepartment:fc','牵头部门管理组'),('60e349bc-b9d0-4106-8c17-9e920c803144','角色详细查询','','2018-04-25 09:16:27','role','role:rv','角色组'),('63d13cc9-1395-4216-adc5-36bdcb468a99','自评问件删除','','2018-04-25 09:16:27','rater','rater:md','自评文件组'),('67e9279a-8903-46fe-baf1-80f4fffc631c','普通用户编辑','','2018-04-25 09:16:27','generalUser','generalUser:me','普通用户组'),('6876b232-0dac-433b-9e33-c529d3ec0f48','菜单删除','','2018-04-25 09:16:27','menu','menu:md','菜单组'),('6a4d730f-567f-4ec2-9388-1e2c1a4d9d0d','学院查看详细','','2018-05-15 10:05:50','paperFile','college:mr','试卷文件组'),('6ce4f0e6-9cd5-44e1-bc1c-43f1f6e3ff20','审核要点查看','','2018-04-25 09:16:27','supportFile','point:fr','审核要点管理组'),('70d6bab0-714b-4ad3-9f07-d9125c03e72f','部门查看','','2018-04-25 09:16:27','department','department:mr','部门组'),('71779d1d-4fd2-418a-a813-88687ee752a7','问题查看','','2018-04-25 09:16:27','problem','problem:mr','问题组'),('71bbc937-0ec3-4df8-86ef-d2d8989d367f','专业删除','','2018-05-15 10:05:50','paperFile','discipline:md','试卷文件组'),('785e5be4-b62d-4fa5-a06c-dce04d556f3d','试卷查看','','2018-05-15 10:05:50','paperFile','paper:mr','试卷文件组'),('78b63510-9823-4bcc-b847-1b5c276974cb','评审用户删除','','2018-04-25 09:16:27','frontUser','raterUser:md','普通用户组'),('7acbf5b8-2600-41e8-88b1-d5f6e00d656a','问题查看','','2018-04-25 09:16:27','problem','problem:mr','问题组'),('8daee223-c383-4949-afff-42daac4b94f1','问题添加','','2018-04-25 09:16:27','problem','problem:mc','问题组'),('8f7f6207-6471-4a60-8b2e-df4a6e3ce8b4','问题删除','','2018-04-25 09:16:27','problem','problem:md','问题组'),('92807081-f673-449f-9893-3a602a71aad6','审核项目编辑','','2018-04-25 09:16:27','supportFile','project:fe','审核项目管理组'),('98acbc43-1e98-4a6d-b7f1-15f0bc698b4b','责任部门编辑','','2018-04-25 09:16:27','supportFile','dutyDepartment:fe','责任部门管理组'),('9a82b2c6-bdbe-4435-9833-fcad48e90ff9','牵头部门详细','','2018-04-25 09:16:27','supportFile','leadDepartment:fd','牵头部门管理组'),('9b475230-fd2e-41a4-aefd-a8cd5c56188f','评审用户查看','','2018-04-25 09:16:27','frontUser','raterUser:mr','评审用户组'),('9d37ac7a-6231-469a-97b4-f7d857348889','分数详细','','2018-04-25 09:16:27','score','score:mr','分数组'),('9f335ec6-f9cf-49a2-ab67-6c0749af683f','用户角色查询','','2018-04-25 09:16:27','role','role:urr','角色组'),('a1047021-349e-406d-87d9-d32357a2ef00','审核要素详细','','2018-04-25 09:16:27','supportFile','element:fd','审核要素管理组'),('a1e4f44c-c3d5-4821-9bab-b5b397b2a43d','专业编辑','','2018-05-15 10:05:50','paperFile','discipline:mu','试卷文件组'),('a28a35bc-7474-41e6-9841-b8e52f486d36','学院查看','','2018-05-15 10:05:50','paperFile','college:mr','试卷文件组'),('a53e3582-59fb-4c8f-82f6-5e40235860a9','角色菜单查询','','2018-04-25 09:16:27','role','role:rmr','菜单组'),('a6ebe9db-2f6d-47a8-864f-e59cbfa54dcc','父菜单添加','','2018-04-25 09:16:27','menu','menu:pc','菜单组'),('a8d83493-1c81-4678-a702-736a7787387e','试卷查看','','2018-05-15 10:05:50','paperFile','paper:mr','试卷文件组'),('ab187978-81c5-4a26-ac5c-2ed2fe627f10','审责任部门删除','','2018-04-25 09:16:27','supportFile','dutyDepartment:fd','责任部门管理组'),('af7b1c81-008f-4c68-aef1-8cdd74fca0d7','审核项目查看','','2018-04-25 09:16:27','supportFile','project:fr','审核项目管理组'),('b447f38e-ce27-42a1-b120-1f1d1af00029','问题类型查询','','2018-04-25 09:16:27','type','type:mr','类型组'),('b50133b9-ea61-4971-a5ce-bcc16405655e','部门编辑','','2018-04-25 09:16:27','department','department:mu','部门组'),('b5515a74-566b-49ff-ba51-73d90970a053','用户查询','','2018-04-25 09:16:27','user','user:ur','用户组'),('bae09cc4-a85e-4902-89da-2c00bf4d3107','普通用户详细','','2018-04-25 09:16:27','generalUser','generalUser:md','普通用户组'),('bd36b3a8-abb4-4d24-8a1e-5ff786509905','用户添加','','2018-04-25 09:16:27','user','user:ua','用户组'),('c12d0e69-48bc-40d4-b6ed-1ea31bf8f03b','部门删除','','2018-04-25 09:16:27','department','department:md','部门组'),('c39f8f3c-d607-43f6-b035-f41a747a74fb','牵头部门查看','','2018-04-25 09:16:27','supportFile','leadDepartment:fr','牵头部门管理组'),('c51a6c0a-4a69-462c-a6e1-b3de7f42b5bb','课程查看详细','','2018-05-15 10:05:50','paperFile','subject:mr','试卷文件组'),('c5295cb6-5486-4935-950e-b6a6de509262','UI查询','','2018-04-25 09:16:27','ui','ui:ur','UI组'),('c66dc5a9-c1cf-4575-afb0-3cfcde0b2cf6','用户详细','','2018-04-25 09:16:27','user','user:ud','用户组'),('c9906635-2f54-41b3-89e2-364aba91d7e8','评审用户编辑','','2018-04-25 09:16:27','frontUser','raterUser:me','评审用户组'),('cbe4450e-1bbb-4bf8-a518-2647c577f41e','问题类型查询','','2018-04-25 09:16:27','type','type:mr','类型组'),('cf524f1a-9284-4a0a-b620-429722192b94','学院删除','','2018-05-15 10:05:50','paperFile','college:md','试卷文件组'),('cfa8f16a-d059-4da9-b5b0-44ce297b9b29','问题编辑','','2018-04-25 09:16:27','problem','problem:mu','问题组'),('d1403666-3091-4e0e-8d91-8f72e2461499','角色查询','','2018-04-25 09:16:27','role','role:rr','角色组'),('d8cc861c-9c2a-4436-b604-cfd13dbc160f','审核项目添加','','2018-04-25 09:16:27','supportFile','project:fc','审核项目管理组'),('dbe440a1-d421-4726-bc29-407504296036','课程编辑','','2018-05-15 10:05:50','paperFile','subject:mu','试卷文件组'),('ddd83bbc-b552-42ad-acde-a82d6f6a966d','自评问件查看','','2018-04-25 09:16:27','rater','rater:mr','自评文件组'),('ddf7d1ee-3840-4cd7-91a0-2fed8b0ecb7b','菜单查询','','2018-04-25 09:16:27','menu','menu:r','菜单组'),('dff2bbaf-eb01-437f-9a89-9f5e67374dc6','审核要点详细','','2018-04-25 09:16:27','supportFile','point:fd','审核要点管理组'),('e12b17a3-65e7-4ff3-98af-3c71b229caa0','角色权限查询','','2018-04-25 09:16:27','role','role:rpr','角色组'),('e1e0d23b-f4a7-43b1-b51d-8dc175ad2461','角色编辑','','2018-04-25 09:16:27','role','role:ru','角色组'),('e35a4413-043a-4967-a35b-20fd4bdfb4c0','审核要点编辑','','2018-04-25 09:16:27','supportFile','point:fe','审核要点管理组'),('e47c9404-2891-42fa-8270-f6d3c5255889','分数删除','','2018-04-25 09:16:27','score','score:md','分数组'),('e8319432-dac1-41bb-87ab-5a9e58a90df2','分数编辑','','2018-04-25 09:16:27','score','score:mu','分数组'),('eb0a1c93-a769-4394-afbe-607482dc1ae7','问题类型添加','','2018-04-25 09:16:27','type','type:mc','类型组'),('eea9c4a2-9f81-4619-bde6-0836bef9c984','分数查看','','2018-04-25 09:16:27','score','score:mr','分数组'),('f25cbf7c-eac0-45bb-9984-cab797c3a983','菜单更新','','2018-04-25 09:16:27','menu','menu:mu','菜单组'),('f3af6051-8e96-4ca4-a3d4-b8082884bb5d','审核要素编辑','','2018-04-25 09:16:27','supportFile','element:fe','审核要素管理组'),('f4502c12-ddb1-48c0-a6d8-675067f355ca','牵头部门编辑','','2018-04-25 09:16:27','supportFile','leadDepartment:fe','牵头部门管理组'),('f719b895-4032-4a36-bbbb-303e9879dd3d','问题类型查看','','2018-04-25 09:16:27','type','type:mr','类型组'),('fb0b423f-7501-41af-a7f0-e1b7cc0c7e85','部门详细','','2018-04-25 09:16:27','department','department:mr','部门组'),('fe26891a-2917-4540-a306-2af2a70a2c4b','试卷文件查看','','2018-05-15 10:05:50','paperFile','paperFile:mr','试卷文件组'),('fecb0fc6-6a00-44c0-bef2-a01906d9ce90','课程查看','','2018-05-15 10:05:50','paperFile','subject:mr','试卷文件组');
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
INSERT INTO `system_role` VALUES ('0ed935f6-c1e9-4c07-a84a-e6c181a2ed44','问题管理','','2018-04-25 09:16:27','problem','problem:m',0),('105dfbe7-9d4a-4010-91ce-60a4c5a39f9c','文件管理','','2018-04-25 09:16:27','file','file:m',0),('25646f36-462b-47e6-bb4a-a3e4bc71178a','文件管理','','2018-04-25 09:16:27','file','file:m',0),('2f425838-1ca3-401e-b832-307bda146cb1','专业管理','','2018-05-15 10:05:50','paperFile','discipline:m',0),('3176f4e2-f34f-49d6-bda5-a49ed1225c40','问题管理','','2018-04-25 09:16:27','problem','problem:m',0),('44331be9-2161-4b68-9721-a5a013e9325d','问题管理','','2018-04-25 09:16:27','problem','problem:m',0),('4589fefa-b37f-4f8e-9b73-e9e61cb6276b','系统配置','','2018-04-25 09:16:27','config','config:m',0),('4adfa160-7101-43db-b5ff-2f6a8fddbd1a','系统配置','','2018-04-25 09:16:27','config','config:m',0),('556989b0-4a3b-491d-96ea-8a0c1c6d8d34','评审用户管理角色','','2018-04-25 09:16:27','frontUser','raterUser:m',0),('65ed78d4-3813-4b5d-8be3-1d55c553eebd','学院管理','','2018-05-15 10:05:50','paperFile','college:m',0),('6bf3d371-f89f-4259-9555-6d380d06ebc4','试卷管理','','2018-05-15 10:05:50','paperFile','paper:m',0),('756b4ad1-c18e-4703-afe8-ef62d6d9c698','审核要素管理','','2018-04-25 09:16:27','supportFile','element:f',0),('7f6a218d-cac1-49fb-9c27-5e987dea3b97','问题管理','','2018-04-25 09:16:27','problem','problem:m',0),('92403faf-608c-4764-abbe-179b7db76d8d','角色管理角色','','2018-04-25 09:16:27','system','role:m',0),('97cb79ba-c238-4d03-a383-313801331733','审核项目管理','','2018-04-25 09:16:27','supportFile','element:f',0),('981d9d3c-7543-4a2a-9309-d11dfef66fa6','审核要点管理','','2018-04-25 09:16:27','supportFile','point:f',0),('9df505a6-3554-4057-a9a7-d085fc2f1ab3','UI管理角色','','2018-04-25 09:16:27','system','ui:m',0),('9f8c8be6-7d2c-4841-9e5e-79d31b203698','试卷文件管理','','2018-05-15 10:05:50','paperFile','paperFile:m',0),('a144c327-70b4-4d46-b2cf-98ca3ab71338','普通用户管理角色','','2018-04-25 09:16:27','generalUser','generalUser:m',0),('b05ca046-7709-4f80-b0e7-9b60bd6899f5','用户管理角色','','2018-04-25 09:16:27','system','user:m',0),('b665bac8-c549-4907-a6e2-7d88b6de96ea','牵头部门管理','','2018-04-25 09:16:27','supportFile','dutyDepartment:f',0),('cab27a22-2579-46f8-8f88-5e0f0d52de71','牵头部门管理','','2018-04-25 09:16:27','supportFile','leadDepartment:f',0),('dc69277a-675d-47f2-a461-e8a213a71b77','菜单管理角色','','2018-04-25 09:16:27','system','menu:m',0),('e16bc39d-ad99-4d31-931b-c410855c348a','课程管理','','2018-05-15 10:05:50','paperFile','subject:m',0),('fc453fbf-07d3-4eee-bcce-86e1007614af','权限管理角色','','2018-04-25 09:16:27','system','permission:m',0);
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
INSERT INTO `system_role_menu` VALUES ('0ed935f6-c1e9-4c07-a84a-e6c181a2ed44','cffa03d1-095c-46e1-a1b5-1f7413d5063e'),('105dfbe7-9d4a-4010-91ce-60a4c5a39f9c','5c48fec0-8166-41a7-aea0-40bd18b97750'),('25646f36-462b-47e6-bb4a-a3e4bc71178a','5b5ea24d-45d7-4739-bbbe-73fd8fe57182'),('2f425838-1ca3-401e-b832-307bda146cb1','d9c8f646-e711-4064-8379-cbb64633df39'),('3176f4e2-f34f-49d6-bda5-a49ed1225c40','81136b2c-acc7-4501-9cfc-d42a6b72aba0'),('44331be9-2161-4b68-9721-a5a013e9325d','d7282933-211f-4251-832a-48ceb644c5ef'),('4589fefa-b37f-4f8e-9b73-e9e61cb6276b','346559e0-8e7b-4bb2-a525-c446697ef83e'),('4adfa160-7101-43db-b5ff-2f6a8fddbd1a','14c179a9-8000-472d-a639-aae0153b8fe0'),('556989b0-4a3b-491d-96ea-8a0c1c6d8d34','3ceb785c-fd96-494a-82f7-ce0c5ba12287'),('65ed78d4-3813-4b5d-8be3-1d55c553eebd','ec13b723-f19b-40c8-830b-912d6178edfb'),('6bf3d371-f89f-4259-9555-6d380d06ebc4','f339d55a-08db-461f-89fa-1ee832be8a55'),('756b4ad1-c18e-4703-afe8-ef62d6d9c698','ecbe8ce4-e8f6-427e-9e23-d756d03239e3'),('7f6a218d-cac1-49fb-9c27-5e987dea3b97','da2e2573-2a56-406b-94d1-9b7eecaef8a6'),('92403faf-608c-4764-abbe-179b7db76d8d','00427a88-9860-44eb-bede-528fa8eea040'),('97cb79ba-c238-4d03-a383-313801331733','091ec75f-b9d6-4a9d-a54e-2ebc92f747b3'),('981d9d3c-7543-4a2a-9309-d11dfef66fa6','9cb58155-7d41-422d-833f-862d6762f128'),('9df505a6-3554-4057-a9a7-d085fc2f1ab3','4d3bbc92-b99f-4776-93c3-d04137e80c45'),('9f8c8be6-7d2c-4841-9e5e-79d31b203698','10e76916-e69d-4527-96d1-93667cdddf8a'),('a144c327-70b4-4d46-b2cf-98ca3ab71338','a0b0024b-9c0c-44bd-b7b1-852c90f80b78'),('b05ca046-7709-4f80-b0e7-9b60bd6899f5','e6e2cd04-fdf0-492b-b8a5-42983c05952a'),('b665bac8-c549-4907-a6e2-7d88b6de96ea','aecee7a0-243e-4e7b-861e-399f6a042f6a'),('cab27a22-2579-46f8-8f88-5e0f0d52de71','d4ffc71c-e2e0-40eb-a9c3-06cb47de7b5a'),('dc69277a-675d-47f2-a461-e8a213a71b77','64b8159c-c149-4439-9159-10a3e990fe7f'),('e16bc39d-ad99-4d31-931b-c410855c348a','7f89f00c-affd-4d49-a0db-ab64d115bb9b'),('fc453fbf-07d3-4eee-bcce-86e1007614af','b5e66b58-d1f0-428e-878f-c0dd1a97c5d1');
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
INSERT INTO `system_role_permission` VALUES ('0ed935f6-c1e9-4c07-a84a-e6c181a2ed44','0c2398b2-6409-4566-b968-0cc57586eec7',0),('0ed935f6-c1e9-4c07-a84a-e6c181a2ed44','3d15cb8f-72e1-4499-a753-42f76a60cd7a',0),('0ed935f6-c1e9-4c07-a84a-e6c181a2ed44','45990970-a177-41bc-993a-6f6258201c21',0),('0ed935f6-c1e9-4c07-a84a-e6c181a2ed44','b447f38e-ce27-42a1-b120-1f1d1af00029',0),('0ed935f6-c1e9-4c07-a84a-e6c181a2ed44','cbe4450e-1bbb-4bf8-a518-2647c577f41e',0),('0ed935f6-c1e9-4c07-a84a-e6c181a2ed44','eb0a1c93-a769-4394-afbe-607482dc1ae7',0),('0ed935f6-c1e9-4c07-a84a-e6c181a2ed44','f719b895-4032-4a36-bbbb-303e9879dd3d',0),('105dfbe7-9d4a-4010-91ce-60a4c5a39f9c','40986dcb-f7fd-4ae3-97f5-bce0335a33c2',0),('105dfbe7-9d4a-4010-91ce-60a4c5a39f9c','56cf226f-c2ee-4825-aeaa-baa71b78ceaa',0),('25646f36-462b-47e6-bb4a-a3e4bc71178a','63d13cc9-1395-4216-adc5-36bdcb468a99',0),('25646f36-462b-47e6-bb4a-a3e4bc71178a','ddd83bbc-b552-42ad-acde-a82d6f6a966d',0),('2f425838-1ca3-401e-b832-307bda146cb1','163122c9-8104-4435-949f-4b70ff0729a7',0),('2f425838-1ca3-401e-b832-307bda146cb1','18f38fc9-c6fb-4375-8c40-39a2a167385d',0),('2f425838-1ca3-401e-b832-307bda146cb1','56bd01eb-bb92-44f7-ab3d-06fa24833de4',0),('2f425838-1ca3-401e-b832-307bda146cb1','71bbc937-0ec3-4df8-86ef-d2d8989d367f',0),('2f425838-1ca3-401e-b832-307bda146cb1','a1e4f44c-c3d5-4821-9bab-b5b397b2a43d',0),('3176f4e2-f34f-49d6-bda5-a49ed1225c40','22b6bc44-4da8-4884-bab0-06a3b38b3c3e',0),('3176f4e2-f34f-49d6-bda5-a49ed1225c40','71779d1d-4fd2-418a-a813-88687ee752a7',0),('3176f4e2-f34f-49d6-bda5-a49ed1225c40','7acbf5b8-2600-41e8-88b1-d5f6e00d656a',0),('3176f4e2-f34f-49d6-bda5-a49ed1225c40','8daee223-c383-4949-afff-42daac4b94f1',0),('3176f4e2-f34f-49d6-bda5-a49ed1225c40','8f7f6207-6471-4a60-8b2e-df4a6e3ce8b4',0),('3176f4e2-f34f-49d6-bda5-a49ed1225c40','cfa8f16a-d059-4da9-b5b0-44ce297b9b29',0),('44331be9-2161-4b68-9721-a5a013e9325d','3966f315-fa51-4cd6-9d26-b0fceaf93a3c',0),('44331be9-2161-4b68-9721-a5a013e9325d','9d37ac7a-6231-469a-97b4-f7d857348889',0),('44331be9-2161-4b68-9721-a5a013e9325d','e47c9404-2891-42fa-8270-f6d3c5255889',0),('44331be9-2161-4b68-9721-a5a013e9325d','e8319432-dac1-41bb-87ab-5a9e58a90df2',0),('44331be9-2161-4b68-9721-a5a013e9325d','eea9c4a2-9f81-4619-bde6-0836bef9c984',0),('4589fefa-b37f-4f8e-9b73-e9e61cb6276b','2289c305-8b26-4278-a7db-a1a1b2acb552',0),('4589fefa-b37f-4f8e-9b73-e9e61cb6276b','2d204c05-fc7f-4df0-adbb-729fe37b6dcc',0),('4adfa160-7101-43db-b5ff-2f6a8fddbd1a','246c6928-9be4-4e46-86a7-c03e38b99a59',0),('556989b0-4a3b-491d-96ea-8a0c1c6d8d34','3f665925-ded0-416c-9f58-d627d2c37c49',0),('556989b0-4a3b-491d-96ea-8a0c1c6d8d34','4cf3e598-97ee-4575-8929-aed843b97c3d',0),('556989b0-4a3b-491d-96ea-8a0c1c6d8d34','78b63510-9823-4bcc-b847-1b5c276974cb',0),('556989b0-4a3b-491d-96ea-8a0c1c6d8d34','9b475230-fd2e-41a4-aefd-a8cd5c56188f',0),('556989b0-4a3b-491d-96ea-8a0c1c6d8d34','c9906635-2f54-41b3-89e2-364aba91d7e8',0),('65ed78d4-3813-4b5d-8be3-1d55c553eebd','2d6094d1-fce5-4ff0-a9c9-5297bd7173cd',0),('65ed78d4-3813-4b5d-8be3-1d55c553eebd','3d24b72e-04bb-467e-816d-0d754921f988',0),('65ed78d4-3813-4b5d-8be3-1d55c553eebd','6a4d730f-567f-4ec2-9388-1e2c1a4d9d0d',0),('65ed78d4-3813-4b5d-8be3-1d55c553eebd','a28a35bc-7474-41e6-9841-b8e52f486d36',0),('65ed78d4-3813-4b5d-8be3-1d55c553eebd','cf524f1a-9284-4a0a-b620-429722192b94',0),('6bf3d371-f89f-4259-9555-6d380d06ebc4','2524fda7-1a41-4914-b3a8-777175c2cbdb',0),('6bf3d371-f89f-4259-9555-6d380d06ebc4','2539ad15-9d60-47ca-be65-438d3c549e9f',0),('6bf3d371-f89f-4259-9555-6d380d06ebc4','4417f473-1338-416c-84e2-27aa43be1b39',0),('6bf3d371-f89f-4259-9555-6d380d06ebc4','785e5be4-b62d-4fa5-a06c-dce04d556f3d',0),('6bf3d371-f89f-4259-9555-6d380d06ebc4','a8d83493-1c81-4678-a702-736a7787387e',0),('756b4ad1-c18e-4703-afe8-ef62d6d9c698','379a8674-2794-4fe6-a09b-6ea84ee6d66e',0),('756b4ad1-c18e-4703-afe8-ef62d6d9c698','3b66adec-3608-494b-93a7-4535856d15ce',0),('756b4ad1-c18e-4703-afe8-ef62d6d9c698','45de11dd-7556-4c81-b34c-c33f31bcd92a',0),('756b4ad1-c18e-4703-afe8-ef62d6d9c698','a1047021-349e-406d-87d9-d32357a2ef00',0),('756b4ad1-c18e-4703-afe8-ef62d6d9c698','f3af6051-8e96-4ca4-a3d4-b8082884bb5d',0),('7f6a218d-cac1-49fb-9c27-5e987dea3b97','24bd6183-1689-46a3-84fa-1a5ee26e25ef',0),('7f6a218d-cac1-49fb-9c27-5e987dea3b97','70d6bab0-714b-4ad3-9f07-d9125c03e72f',0),('7f6a218d-cac1-49fb-9c27-5e987dea3b97','b50133b9-ea61-4971-a5ce-bcc16405655e',0),('7f6a218d-cac1-49fb-9c27-5e987dea3b97','c12d0e69-48bc-40d4-b6ed-1ea31bf8f03b',0),('7f6a218d-cac1-49fb-9c27-5e987dea3b97','fb0b423f-7501-41af-a7f0-e1b7cc0c7e85',0),('92403faf-608c-4764-abbe-179b7db76d8d','0c0b9fd7-f489-432b-925c-66a1f286f704',0),('92403faf-608c-4764-abbe-179b7db76d8d','165523d8-899a-4e82-9e33-8b6dc143c294',0),('92403faf-608c-4764-abbe-179b7db76d8d','60e349bc-b9d0-4106-8c17-9e920c803144',0),('92403faf-608c-4764-abbe-179b7db76d8d','9f335ec6-f9cf-49a2-ab67-6c0749af683f',0),('92403faf-608c-4764-abbe-179b7db76d8d','d1403666-3091-4e0e-8d91-8f72e2461499',0),('92403faf-608c-4764-abbe-179b7db76d8d','e1e0d23b-f4a7-43b1-b51d-8dc175ad2461',0),('97cb79ba-c238-4d03-a383-313801331733','400e334d-4e52-4c12-a917-d4d3034f874f',0),('97cb79ba-c238-4d03-a383-313801331733','521b4911-38ce-4a67-8019-0110a71d58cd',0),('97cb79ba-c238-4d03-a383-313801331733','92807081-f673-449f-9893-3a602a71aad6',0),('97cb79ba-c238-4d03-a383-313801331733','af7b1c81-008f-4c68-aef1-8cdd74fca0d7',0),('97cb79ba-c238-4d03-a383-313801331733','d8cc861c-9c2a-4436-b604-cfd13dbc160f',0),('981d9d3c-7543-4a2a-9309-d11dfef66fa6','45c1221b-fce7-4da8-b08a-cccae5790721',0),('981d9d3c-7543-4a2a-9309-d11dfef66fa6','4dd6f0a2-eb27-4c96-8d27-e5d77849ccb2',0),('981d9d3c-7543-4a2a-9309-d11dfef66fa6','6ce4f0e6-9cd5-44e1-bc1c-43f1f6e3ff20',0),('981d9d3c-7543-4a2a-9309-d11dfef66fa6','dff2bbaf-eb01-437f-9a89-9f5e67374dc6',0),('981d9d3c-7543-4a2a-9309-d11dfef66fa6','e35a4413-043a-4967-a35b-20fd4bdfb4c0',0),('9df505a6-3554-4057-a9a7-d085fc2f1ab3','1fe9a067-a528-4ce6-89e8-22746902223f',0),('9df505a6-3554-4057-a9a7-d085fc2f1ab3','c5295cb6-5486-4935-950e-b6a6de509262',0),('9f8c8be6-7d2c-4841-9e5e-79d31b203698','416f165f-9739-4a74-af84-10e8964c10fd',0),('9f8c8be6-7d2c-4841-9e5e-79d31b203698','fe26891a-2917-4540-a306-2af2a70a2c4b',0),('a144c327-70b4-4d46-b2cf-98ca3ab71338','0cf108f7-635c-4bbb-8e6c-2c8beb72a7d2',0),('a144c327-70b4-4d46-b2cf-98ca3ab71338','27fc98f7-0c7d-4bc3-93a6-62f7773cb79b',0),('a144c327-70b4-4d46-b2cf-98ca3ab71338','5866b634-cffd-4192-9f31-326a4ee3b8b1',0),('a144c327-70b4-4d46-b2cf-98ca3ab71338','67e9279a-8903-46fe-baf1-80f4fffc631c',0),('a144c327-70b4-4d46-b2cf-98ca3ab71338','bae09cc4-a85e-4902-89da-2c00bf4d3107',0),('b05ca046-7709-4f80-b0e7-9b60bd6899f5','32a84b2d-f67a-40b5-826b-4b8dc5e249cd',0),('b05ca046-7709-4f80-b0e7-9b60bd6899f5','36b52dc3-d64d-4714-afd2-b3554a785da2',0),('b05ca046-7709-4f80-b0e7-9b60bd6899f5','56338634-d117-4663-bde2-af0b31c689f4',0),('b05ca046-7709-4f80-b0e7-9b60bd6899f5','b5515a74-566b-49ff-ba51-73d90970a053',0),('b05ca046-7709-4f80-b0e7-9b60bd6899f5','bd36b3a8-abb4-4d24-8a1e-5ff786509905',0),('b05ca046-7709-4f80-b0e7-9b60bd6899f5','c66dc5a9-c1cf-4575-afb0-3cfcde0b2cf6',0),('b665bac8-c549-4907-a6e2-7d88b6de96ea','09e14dc6-3b6e-48f1-a783-208c68043d6a',0),('b665bac8-c549-4907-a6e2-7d88b6de96ea','20c129ad-f643-4b8d-873a-a43668b20165',0),('b665bac8-c549-4907-a6e2-7d88b6de96ea','57d846ee-8d2e-4185-8ec3-75ef7af7bb41',0),('b665bac8-c549-4907-a6e2-7d88b6de96ea','98acbc43-1e98-4a6d-b7f1-15f0bc698b4b',0),('b665bac8-c549-4907-a6e2-7d88b6de96ea','ab187978-81c5-4a26-ac5c-2ed2fe627f10',0),('cab27a22-2579-46f8-8f88-5e0f0d52de71','2bbd7345-3874-49f0-80dd-e49f57d54884',0),('cab27a22-2579-46f8-8f88-5e0f0d52de71','5a3c99a9-c91e-4506-8d50-766287d4f64d',0),('cab27a22-2579-46f8-8f88-5e0f0d52de71','9a82b2c6-bdbe-4435-9833-fcad48e90ff9',0),('cab27a22-2579-46f8-8f88-5e0f0d52de71','c39f8f3c-d607-43f6-b035-f41a747a74fb',0),('cab27a22-2579-46f8-8f88-5e0f0d52de71','f4502c12-ddb1-48c0-a6d8-675067f355ca',0),('dc69277a-675d-47f2-a461-e8a213a71b77','04ce2ff5-2825-470f-9705-fde664ff635a',0),('dc69277a-675d-47f2-a461-e8a213a71b77','20443040-c7fc-4ff0-bff0-7d475ebb7f62',0),('dc69277a-675d-47f2-a461-e8a213a71b77','2a63265b-df40-4290-97f0-78c0a9667465',0),('dc69277a-675d-47f2-a461-e8a213a71b77','6876b232-0dac-433b-9e33-c529d3ec0f48',0),('dc69277a-675d-47f2-a461-e8a213a71b77','a53e3582-59fb-4c8f-82f6-5e40235860a9',0),('dc69277a-675d-47f2-a461-e8a213a71b77','a6ebe9db-2f6d-47a8-864f-e59cbfa54dcc',0),('dc69277a-675d-47f2-a461-e8a213a71b77','ddf7d1ee-3840-4cd7-91a0-2fed8b0ecb7b',0),('dc69277a-675d-47f2-a461-e8a213a71b77','f25cbf7c-eac0-45bb-9984-cab797c3a983',0),('e16bc39d-ad99-4d31-931b-c410855c348a','10f25dee-9d46-4f6a-ad91-55d97b6cd361',0),('e16bc39d-ad99-4d31-931b-c410855c348a','196646fb-1f9c-4e3e-a72d-d043a82377b7',0),('e16bc39d-ad99-4d31-931b-c410855c348a','c51a6c0a-4a69-462c-a6e1-b3de7f42b5bb',0),('e16bc39d-ad99-4d31-931b-c410855c348a','dbe440a1-d421-4726-bc29-407504296036',0),('e16bc39d-ad99-4d31-931b-c410855c348a','fecb0fc6-6a00-44c0-bef2-a01906d9ce90',0),('fc453fbf-07d3-4eee-bcce-86e1007614af','3914f6e2-f325-4a2d-82cc-7bdefeeee7e8',0),('fc453fbf-07d3-4eee-bcce-86e1007614af','3b6aaff8-8a63-42fa-b151-7b2f46b5cc79',0),('fc453fbf-07d3-4eee-bcce-86e1007614af','e12b17a3-65e7-4ff3-98af-3c71b229caa0',0);
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
INSERT INTO `system_ui_config` VALUES ('2e7dfb5c-9117-4263-a799-ee3b4c1fba68','/system/6b0d48e2046fd5023b067a3689a747d1.ico','大连交通大学本科教学工作审核评估数据平台','评建数据平台','评建','/system/73d838966cd321ff0f705b93e8814ca2.ico');
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
INSERT INTO `system_user` VALUES ('0','admin','408459bf142be9a8965d3df26d66816e83480a0cfbf4299f9bdc539c367d2d10','PiFF6VSE3nlcmQQqVKD0',0,'/default/user.png',0,0),('0716b872-3d23-4c60-ba9f-b628e1efaa83','ceshi','8c059d5ebc4f9548b60d4a2991e51cf3a87d9653c26c980a1eedb764223163c9','9Ch3qBEW6rKmAiBfEJMz',0,'/default/user.png',1,0);
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
INSERT INTO `system_user_role` VALUES ('0','0ed935f6-c1e9-4c07-a84a-e6c181a2ed44'),('0','105dfbe7-9d4a-4010-91ce-60a4c5a39f9c'),('0','25646f36-462b-47e6-bb4a-a3e4bc71178a'),('0','2f425838-1ca3-401e-b832-307bda146cb1'),('0','3176f4e2-f34f-49d6-bda5-a49ed1225c40'),('0','44331be9-2161-4b68-9721-a5a013e9325d'),('0','4589fefa-b37f-4f8e-9b73-e9e61cb6276b'),('0','4adfa160-7101-43db-b5ff-2f6a8fddbd1a'),('0','556989b0-4a3b-491d-96ea-8a0c1c6d8d34'),('0','65ed78d4-3813-4b5d-8be3-1d55c553eebd'),('0','6bf3d371-f89f-4259-9555-6d380d06ebc4'),('0','756b4ad1-c18e-4703-afe8-ef62d6d9c698'),('0','7f6a218d-cac1-49fb-9c27-5e987dea3b97'),('0','92403faf-608c-4764-abbe-179b7db76d8d'),('0','97cb79ba-c238-4d03-a383-313801331733'),('0','981d9d3c-7543-4a2a-9309-d11dfef66fa6'),('0','9df505a6-3554-4057-a9a7-d085fc2f1ab3'),('0','9f8c8be6-7d2c-4841-9e5e-79d31b203698'),('0','a144c327-70b4-4d46-b2cf-98ca3ab71338'),('0','b05ca046-7709-4f80-b0e7-9b60bd6899f5'),('0','b665bac8-c549-4907-a6e2-7d88b6de96ea'),('0','cab27a22-2579-46f8-8f88-5e0f0d52de71'),('0','dc69277a-675d-47f2-a461-e8a213a71b77'),('0','e16bc39d-ad99-4d31-931b-c410855c348a'),('0','fc453fbf-07d3-4eee-bcce-86e1007614af');
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
INSERT INTO `system_user_token` VALUES ('0','244fg0921e020c49a41714g83bafb44c','2018-05-17 00:08:33','2018-05-16 12:08:33'),('0716b872-3d23-4c60-ba9f-b628e1efaa83','b220f2a09g0hae721f2cbc7hcgeg27bc','2018-04-17 21:25:00','2018-04-17 09:25:00');
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
INSERT INTO `system_userinfo` VALUES ('0','11111111','管理员','super@example.com','2017-12-15 12:07:16',0),('0716b872-3d23-4c60-ba9f-b628e1efaa83','12345672','测试','ceshi@example.com','2018-04-17 08:40:13',0);
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

-- Dump completed on 2018-05-16 20:11:14
