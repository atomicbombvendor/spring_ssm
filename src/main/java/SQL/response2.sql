/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : db_ssm

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2017-06-27 21:46:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for response2
-- ----------------------------
DROP TABLE IF EXISTS `response2`;
CREATE TABLE `response2` (
  `post_id2` bigint(20) NOT NULL AUTO_INCREMENT,
  `post_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `content` varchar(500) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`post_id2`),
  KEY `FK_response2_users` (`user_id`),
  KEY `FK_response2_response` (`post_id`),
  CONSTRAINT `FK_response2_response` FOREIGN KEY (`post_id`) REFERENCES `response` (`post_id`),
  CONSTRAINT `FK_response2_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of response2
-- ----------------------------
