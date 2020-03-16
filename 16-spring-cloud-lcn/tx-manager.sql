/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : tx-manager

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2020-03-14 17:28:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_logger
-- ----------------------------
DROP TABLE IF EXISTS `t_logger`;
CREATE TABLE `t_logger` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `group_id` varchar(64) NOT NULL,
  `unit_id` varchar(32) NOT NULL,
  `tag` varchar(50) NOT NULL,
  `content` varchar(1024) NOT NULL,
  `create_time` varchar(30) NOT NULL,
  `app_name` varchar(128) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_tx_exception
-- ----------------------------
DROP TABLE IF EXISTS `t_tx_exception`;
CREATE TABLE `t_tx_exception` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `group_id` varchar(64) DEFAULT NULL,
  `unit_id` varchar(32) DEFAULT NULL,
  `mod_id` varchar(128) DEFAULT NULL,
  `transaction_state` tinyint(4) DEFAULT NULL,
  `registrar` tinyint(4) DEFAULT NULL,
  `remark` varchar(4096) DEFAULT NULL,
  `ex_state` tinyint(4) DEFAULT NULL COMMENT '0 未解决 1已解决',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
