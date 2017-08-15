/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : db_ssm

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2017-06-27 21:45:46
*/

SET FOREIGN_KEY_CHECKS=0;

--  -- -- -- -- -- -- -- -- -- -- -- -- -- -- 
--  Table structure for blog_count
--  -- -- -- -- -- -- -- -- -- -- -- -- -- -- 
DROP TABLE IF EXISTS `blog_count`;
CREATE TABLE `blog_count` (
  `tid` bigint(20) NOT NULL,
  `read_count` bigint(20) DEFAULT '0',
  `upvote` bigint(20) DEFAULT '0',
  PRIMARY KEY (`tid`),
  CONSTRAINT `blog_count_ibfk_1` FOREIGN KEY (`tid`) REFERENCES `blog` (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--  -- -- -- -- -- -- -- -- -- -- -- -- -- -- 
--  Records of blog_count
--  -- -- -- -- -- -- -- -- -- -- -- -- -- -- 
