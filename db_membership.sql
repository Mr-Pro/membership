/*
Navicat MySQL Data Transfer

Source Server         : ASUS_Pro
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : db_membership

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2017-12-21 23:08:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL auto_increment,
  `password` varchar(255) default NULL,
  `role` enum('G_ADMIN','S_ADMIN') default 'G_ADMIN',
  `username` varchar(255) default NULL,
  `email` varchar(255) default NULL,
  `phone` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '123', 'G_ADMIN', '123', '123123@qq.com', '123232132');
INSERT INTO `admin` VALUES ('2', 'admin', 'S_ADMIN', 'admin', null, null);

-- ----------------------------
-- Table structure for commodity
-- ----------------------------
DROP TABLE IF EXISTS `commodity`;
CREATE TABLE `commodity` (
  `id` varchar(255) NOT NULL,
  `commodity_integral` varchar(255) default NULL,
  `commodity_name` varchar(255) default NULL,
  `commodity_number` varchar(255) default NULL,
  `commodity_price` float default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of commodity
-- ----------------------------
INSERT INTO `commodity` VALUES ('2c9ba08b60634aab016063caa6650000', '210', '英国蛋糕', '100', '100');
INSERT INTO `commodity` VALUES ('2c9bc008606839470160684477410000', '200', 'aaaaa', '19', '100');

-- ----------------------------
-- Table structure for exchange_record
-- ----------------------------
DROP TABLE IF EXISTS `exchange_record`;
CREATE TABLE `exchange_record` (
  `id` varchar(255) NOT NULL,
  `member_id` varchar(255) default NULL,
  `gift_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FKq7e6h8mogedtw6esuoyrkgbe1` (`gift_id`),
  KEY `FKshbsm33hs4ck8c5b9f8mh9qem` (`member_id`),
  CONSTRAINT `FKshbsm33hs4ck8c5b9f8mh9qem` FOREIGN KEY (`member_id`) REFERENCES `member` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKq7e6h8mogedtw6esuoyrkgbe1` FOREIGN KEY (`gift_id`) REFERENCES `gift` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exchange_record
-- ----------------------------
INSERT INTO `exchange_record` VALUES ('2c9ba08b6064ba9d016064bab71100as', '20171215143150425', '2');
INSERT INTO `exchange_record` VALUES ('2c9bc2e6606d2d4401606d4a9b670001', '2017121514185175', '7');
INSERT INTO `exchange_record` VALUES ('2c9bc2e6606d2d4401606d4ae2420002', '2017121514185175', '7');
INSERT INTO `exchange_record` VALUES ('2c9bc2e6606d2d4401606d4aecd80003', '2017121514185175', '7');
INSERT INTO `exchange_record` VALUES ('2c9bc2e6606d2d4401606d4b424400', '20171215143945448', '2');
INSERT INTO `exchange_record` VALUES ('2c9bc2e6606d2d4401606d4b42440004', '2017121514185175', '8');
INSERT INTO `exchange_record` VALUES ('2cd4a08b6064ba9d016064bab7110000', '20171215142401745', '1');

-- ----------------------------
-- Table structure for gift
-- ----------------------------
DROP TABLE IF EXISTS `gift`;
CREATE TABLE `gift` (
  `id` int(11) NOT NULL auto_increment,
  `gift_integral` int(11) NOT NULL,
  `gift_name` varchar(255) NOT NULL,
  `gift_number` int(11) NOT NULL,
  `gift_price` float default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gift
-- ----------------------------
INSERT INTO `gift` VALUES ('1', '100', '小熊维尼', '10', '20');
INSERT INTO `gift` VALUES ('2', '50', '米奇', '19', '10');
INSERT INTO `gift` VALUES ('7', '2343', '323', '0', '2332');
INSERT INTO `gift` VALUES ('8', '2343', '323', '2', '2332');

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` varchar(255) NOT NULL,
  `balance` float default NULL,
  `birthday` date default NULL,
  `member_integral` bigint(20) default '0',
  `member_name` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  `phone` varchar(255) default NULL,
  `sex` varchar(255) default NULL,
  `state` enum('停用','挂失','正常') default '正常',
  `member_grade_id` int(11) default NULL,
  `email` varchar(255) default NULL,
  `icon_path` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FKf8d3mewhnt0infepk70wm9qju` (`member_grade_id`),
  CONSTRAINT `FKf8d3mewhnt0infepk70wm9qju` FOREIGN KEY (`member_grade_id`) REFERENCES `member_grade` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('2017121514185175', '123', '2017-12-06', '2928', 'sdhfhsdf', '123', '122222222', '男', '正常', '1', '123455892@qq.com', '/assets/icon/01.jpg');
INSERT INTO `member` VALUES ('20171215141851753', '0', '2017-12-03', '2262', '123', '123', '123', '女', '挂失', '1', '123455892@qq.com', '/assets/icon/01.jpg');
INSERT INTO `member` VALUES ('20171215142401745', '0', '2017-12-05', '200', '123333', '12', '12323123123', '女', '停用', '1', '12312@qq.com', '/assets/icon/01.jpg');
INSERT INTO `member` VALUES ('20171215143150425', '0', '2013-12-21', '201', '123', '123', '123', '女', '挂失', '1', '1111@qq.com', '/assets/icon/01.jpg');
INSERT INTO `member` VALUES ('20171215143945448', '100.1', '2017-12-31', '0', '123', '123', '123213123123', '女', '正常', '2', '123455892@qq.com', '/assets/icon/01.jpg');
INSERT INTO `member` VALUES ('20171220163147750', '0', '2017-12-21', '0', '骚男', '123', '12312312312', '男', '正常', '1', '2222@163.com', '/static/assets/icon/e45c34da0e5748f8aa78929cf45d6a0c.jpg');
INSERT INTO `member` VALUES ('20171220163440900', '0', '2017-12-21', '0', '哈哈', '123', '2131231231231', '女', '正常', '2', '222222@163.com', '/assets/icon/aaf5ebe176d0415eb0667d88d3a5162f.jpg');
INSERT INTO `member` VALUES ('2017122121594813', '0', '2017-12-17', '0', '我是会员', '123', '020-2222222222', '男', '正常', '1', '123123@qq.com', '/static/assets/icon/common.jpg');
INSERT INTO `member` VALUES ('20171221220207858', '0', '2017-12-09', '0', '我是会员', '123', '020-2222222', '男', '正常', '1', '123123@qq.com', '/assets/icon/efe5b411ac644020a1b3c9666211cee0.jpg');

-- ----------------------------
-- Table structure for member_grade
-- ----------------------------
DROP TABLE IF EXISTS `member_grade`;
CREATE TABLE `member_grade` (
  `id` int(11) NOT NULL auto_increment,
  `grade_name` varchar(255) default NULL,
  `minimum_integral` bigint(20) default NULL,
  `discount` float default NULL,
  `comment` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member_grade
-- ----------------------------
INSERT INTO `member_grade` VALUES ('1', '普通会员', '100', '9.8', '数据我改过了，打我呀');
INSERT INTO `member_grade` VALUES ('2', '高级会员', '1000', '9.5', '数据我修改了，哈哈');
INSERT INTO `member_grade` VALUES ('3', '特级会员', null, '9', '测试测试');

-- ----------------------------
-- Table structure for transaction_record
-- ----------------------------
DROP TABLE IF EXISTS `transaction_record`;
CREATE TABLE `transaction_record` (
  `id` varchar(255) NOT NULL,
  `commodity_id` varchar(255) default NULL,
  `member_id` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FKc0uvpwiqycu4oxaxpik7hmli1` (`member_id`),
  KEY `FKs4kvgkphxwmfmakoqyk03xnoa` (`commodity_id`),
  CONSTRAINT `FKs4kvgkphxwmfmakoqyk03xnoa` FOREIGN KEY (`commodity_id`) REFERENCES `commodity` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKc0uvpwiqycu4oxaxpik7hmli1` FOREIGN KEY (`member_id`) REFERENCES `member` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of transaction_record
-- ----------------------------
INSERT INTO `transaction_record` VALUES ('2c9ba08b6064ba9d016064bab7110000', '2c9ba08b60634aab016063caa6650000', '20171215143945448');
INSERT INTO `transaction_record` VALUES ('2c9bc2e6606d2d4401606d4965d30000', '2c9ba08b60634aab016063caa6650000', '2017121514185175');
INSERT INTO `transaction_record` VALUES ('sd23df123asdasdas1ds1111s9d016064', '2c9bc008606839470160684477410000', '20171215143150425');
