/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : rfid

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 21/12/2019 01:21:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `company_id` int(11) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=135 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of company
-- ----------------------------
BEGIN;
INSERT INTO `company` VALUES (101, '长春制药');
INSERT INTO `company` VALUES (102, '泰康制药');
INSERT INTO `company` VALUES (103, '云南制药');
INSERT INTO `company` VALUES (104, 'company4');
INSERT INTO `company` VALUES (105, 'company5');
INSERT INTO `company` VALUES (106, 'company6');
INSERT INTO `company` VALUES (128, 'AA');
INSERT INTO `company` VALUES (129, 'DD');
INSERT INTO `company` VALUES (130, 'DD');
INSERT INTO `company` VALUES (131, 'DD');
INSERT INTO `company` VALUES (132, 'AA');
INSERT INTO `company` VALUES (133, 'AA');
INSERT INTO `company` VALUES (134, 'AA');
COMMIT;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) DEFAULT NULL,
  `weight` double(5,0) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `status` int(2) DEFAULT NULL,
  `create_company` int(11) DEFAULT NULL,
  `send_company` int(11) DEFAULT NULL,
  `receive_company` int(11) DEFAULT NULL,
  `destory_company` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
BEGIN;
INSERT INTO `orders` VALUES (1, 1, 10, '2019-12-01 21:30:15', 0, 103, NULL, NULL, NULL);
INSERT INTO `orders` VALUES (2, 1, 100, '2019-12-02 21:30:15', 1, NULL, 103, 104, NULL);
INSERT INTO `orders` VALUES (3, 1, 200, '2019-12-03 21:30:15', 2, NULL, 103, 104, NULL);
INSERT INTO `orders` VALUES (4, 1, 100, '2019-12-04 21:30:15', 1, NULL, 104, 105, NULL);
INSERT INTO `orders` VALUES (5, 1, 11, '2019-12-05 21:30:15', 2, NULL, 105, 106, NULL);
INSERT INTO `orders` VALUES (6, 1, 0, '2019-12-06 21:30:15', 3, NULL, NULL, NULL, 106);
INSERT INTO `orders` VALUES (7, 2, NULL, '2019-11-10 10:00:00', 2, NULL, NULL, 101, NULL);
INSERT INTO `orders` VALUES (8, 10, NULL, '2019-11-10 10:00:00', 2, NULL, NULL, 105, NULL);
INSERT INTO `orders` VALUES (9, 111, NULL, '2019-11-10 10:00:00', 2, NULL, 130, 104, NULL);
INSERT INTO `orders` VALUES (10, 111, NULL, '2018-12-31 10:00:00', 1, NULL, 102, 103, NULL);
INSERT INTO `orders` VALUES (11, 11111, NULL, '2018-12-31 10:00:00', 1, NULL, 103, 130, NULL);
INSERT INTO `orders` VALUES (12, 22222, NULL, '2019-11-10 10:00:00', 2, NULL, 102, 104, NULL);
INSERT INTO `orders` VALUES (13, 111, NULL, '2018-12-31 10:00:00', 2, NULL, 103, 133, NULL);
INSERT INTO `orders` VALUES (14, 1234, 99, '2018-12-31 10:00:00', 2, NULL, 103, 105, NULL);
INSERT INTO `orders` VALUES (15, 4321, NULL, '2019-02-01 10:00:00', 1, NULL, 102, 104, NULL);
COMMIT;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `cas_id` varchar(255) DEFAULT NULL,
  `batch_id` int(11) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `company_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
BEGIN;
INSERT INTO `product` VALUES (1, '7418-66-1', 1, '云南白药', '2019-12-01 21:30:15', 103);
INSERT INTO `product` VALUES (2, '0050-00-0', 2, '清开灵', '2019-12-18 21:31:20', 101);
INSERT INTO `product` VALUES (3, '2222-22-2', 2, 'niu', '2019-02-01 10:00:00', 101);
INSERT INTO `product` VALUES (4, '1111-11-1', 11, 'niu', '2018-12-31 10:00:00', 101);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
