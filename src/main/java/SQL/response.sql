/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : db_ssm

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2017-06-27 21:45:52
*/

SET FOREIGN_KEY_CHECKS=0;

--  -- -- -- -- -- -- -- -- -- -- -- -- -- -- 
--  Table structure for response
--  -- -- -- -- -- -- -- -- -- -- -- -- -- -- 
DROP TABLE IF EXISTS `response`;
CREATE TABLE `response` (
  `post_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `tid` int(11) NOT NULL,
  `content` varchar(500) NOT NULL,
  `respond_id` bigint(20) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`post_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `response_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

--  -- -- -- -- -- -- -- -- -- -- -- -- -- -- 
--  Records of response
--  -- -- -- -- -- -- -- -- -- -- -- -- -- -- 
