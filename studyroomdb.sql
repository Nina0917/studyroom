/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : studyroomdb

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 23/01/2022 19:54:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for appointment
-- ----------------------------
DROP TABLE IF EXISTS `appointment`;
CREATE TABLE `appointment`  (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `userId` int(255) NOT NULL,
  `seatId` int(255) NOT NULL,
  `dateId` int(255) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of appointment
-- ----------------------------
INSERT INTO `appointment` VALUES (1, 2, 1, 5);
INSERT INTO `appointment` VALUES (2, 2, 1, 4);
INSERT INTO `appointment` VALUES (3, 2, 1, 6);
INSERT INTO `appointment` VALUES (5, 1, 2, 4);
INSERT INTO `appointment` VALUES (11, 2, 1, 8);
INSERT INTO `appointment` VALUES (12, 2, 1, 7);

-- ----------------------------
-- Table structure for date
-- ----------------------------
DROP TABLE IF EXISTS `date`;
CREATE TABLE `date`  (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `day` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of date
-- ----------------------------
INSERT INTO `date` VALUES (1, '2022-01-20');
INSERT INTO `date` VALUES (2, '2022-01-21');
INSERT INTO `date` VALUES (3, '2022-01-22');
INSERT INTO `date` VALUES (4, '2022-01-23');
INSERT INTO `date` VALUES (5, '2022-01-24');
INSERT INTO `date` VALUES (6, '2022-01-25');
INSERT INTO `date` VALUES (7, '2022-01-26');
INSERT INTO `date` VALUES (8, '2022-01-27');
INSERT INTO `date` VALUES (9, '2022-01-28');
INSERT INTO `date` VALUES (10, '2022-01-29');
INSERT INTO `date` VALUES (11, '2022-01-30');
INSERT INTO `date` VALUES (12, '2022-01-31');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record`  (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `userId` int(100) NULL DEFAULT NULL,
  `seatId` int(100) NULL DEFAULT NULL,
  `dateId` int(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES (1, 2, 1, 2);
INSERT INTO `record` VALUES (2, 2, 1, 2);
INSERT INTO `record` VALUES (3, 2, 1, 3);
INSERT INTO `record` VALUES (4, 2, 1, 2);

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room`  (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `floor` int(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES (1, 1);
INSERT INTO `room` VALUES (2, 2);
INSERT INTO `room` VALUES (3, 1);
INSERT INTO `room` VALUES (4, 2);
INSERT INTO `room` VALUES (5, 3);

-- ----------------------------
-- Table structure for seat
-- ----------------------------
DROP TABLE IF EXISTS `seat`;
CREATE TABLE `seat`  (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `roomId` int(100) NOT NULL,
  `statusId` int(100) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of seat
-- ----------------------------
INSERT INTO `seat` VALUES (1, 1, 1);
INSERT INTO `seat` VALUES (2, 1, 1);
INSERT INTO `seat` VALUES (3, 1, 1);
INSERT INTO `seat` VALUES (4, 2, 1);
INSERT INTO `seat` VALUES (5, 2, 1);
INSERT INTO `seat` VALUES (6, 2, 1);

-- ----------------------------
-- Table structure for status
-- ----------------------------
DROP TABLE IF EXISTS `status`;
CREATE TABLE `status`  (
  `id` int(100) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of status
-- ----------------------------
INSERT INTO `status` VALUES (0, '已被预约');
INSERT INTO `status` VALUES (1, '可预约');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pwd` char(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `state` int(255) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'super', '123', 1);
INSERT INTO `user` VALUES (2, 'admin', '12345', 1);
INSERT INTO `user` VALUES (3, 'Nina', '123', 0);

SET FOREIGN_KEY_CHECKS = 1;
