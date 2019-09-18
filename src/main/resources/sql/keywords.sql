/*
 Navicat Premium Data Transfer

 Source Server         : mysql5.6
 Source Server Type    : MySQL
 Source Server Version : 50644
 Source Host           : localhost:3306
 Source Schema         : shop

 Target Server Type    : MySQL
 Target Server Version : 50644
 File Encoding         : 65001

 Date: 04/08/2019 22:36:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for keywords
-- ----------------------------
DROP TABLE IF EXISTS `keywords`;
CREATE TABLE `keywords`  (
  `id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关键字名称',
  `hot` tinyint(4) NULL DEFAULT NULL COMMENT '热门：0,非热门 1,热门',
  `type` tinyint(4) NULL DEFAULT NULL COMMENT '类型： 0,普通 1,热门',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of keywords
-- ----------------------------
INSERT INTO `keywords` VALUES ('79947e26b5b611e9a2d694de800cfcb2', '游戏', NULL, 0);
INSERT INTO `keywords` VALUES ('79957dd9b5b611e9a2d694de800cfcb2', '耐克', NULL, 0);
INSERT INTO `keywords` VALUES ('7996000fb5b611e9a2d694de800cfcb2', '洗发水', NULL, 1);
INSERT INTO `keywords` VALUES ('79979ce5b5b611e9a2d694de800cfcb2', '床单', NULL, 0);
INSERT INTO `keywords` VALUES ('7998ff7cb5b611e9a2d694de800cfcb2', '女朋友', NULL, 1);
INSERT INTO `keywords` VALUES ('7999c2bdb5b611e9a2d694de800cfcb2', '恶搞', NULL, 1);
INSERT INTO `keywords` VALUES ('799a81fdb5b611e9a2d694de800cfcb2', '百度网盘', NULL, 0);
INSERT INTO `keywords` VALUES ('799b4846b5b611e9a2d694de800cfcb2', '2020新款羽绒服', NULL, 0);
INSERT INTO `keywords` VALUES ('799c0bb8b5b611e9a2d694de800cfcb2', '球鞋', NULL, 1);
INSERT INTO `keywords` VALUES ('799ccccfb5b611e9a2d694de800cfcb2', '手工编织', NULL, 0);
INSERT INTO `keywords` VALUES ('799df26fb5b611e9a2d694de800cfcb2', '三国志', NULL, 0);
INSERT INTO `keywords` VALUES ('799eb3b4b5b611e9a2d694de800cfcb2', '西游记', NULL, 0);
INSERT INTO `keywords` VALUES ('d8a02ac6b5b511e9a2d694de800cfcb2', '口红', NULL, 0);

SET FOREIGN_KEY_CHECKS = 1;
