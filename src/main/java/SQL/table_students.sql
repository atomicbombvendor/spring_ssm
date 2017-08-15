/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : db_ssm

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2017-06-27 21:46:16
*/

SET FOREIGN_KEY_CHECKS=0;

--  -- -- -- -- -- -- -- -- -- -- -- -- -- -- 
--  Table structure for students
--  -- -- -- -- -- -- -- -- -- -- -- -- -- -- 
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `sex` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--  -- -- -- -- -- -- -- -- -- -- -- -- -- -- 
--  Records of students
--  -- -- -- -- -- -- -- -- -- -- -- -- -- -- 
INSERT INTO `students` VALUES ('1', 'xiaoxiao', 'female');
INSERT INTO `students` VALUES ('2', 'mengmeng', 'female');
