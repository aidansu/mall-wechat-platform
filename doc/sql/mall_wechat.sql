/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : mall_wechat

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 01/07/2020 09:17:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mall_user
-- ----------------------------
DROP TABLE IF EXISTS `mall_user`;
CREATE TABLE `mall_user` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` varchar(12) DEFAULT '000000' COMMENT '租户ID',
  `unionid` varchar(255) DEFAULT NULL COMMENT '平台唯一标识',
  `mini_openid` varbinary(64) DEFAULT NULL COMMENT '小程序用户唯一标识',
  `session_key` varchar(255) DEFAULT NULL COMMENT '小程序会话密钥',
  `username` varchar(45) DEFAULT NULL COMMENT '账号',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `real_name` varchar(10) DEFAULT NULL COMMENT '真名',
  `nick_name` varchar(64) DEFAULT NULL COMMENT '昵称',
  `email` varchar(45) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(45) DEFAULT NULL COMMENT '手机',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `gender` int(2) DEFAULT NULL COMMENT '性别',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像链接',
  `city` varchar(20) DEFAULT NULL COMMENT '城市',
  `province` varchar(20) DEFAULT NULL COMMENT '省份',
  `county` varchar(20) DEFAULT NULL COMMENT '国家',
  `language` varchar(20) DEFAULT NULL COMMENT '语言',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `create_user` bigint(64) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` bigint(64) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `status` int(2) DEFAULT NULL COMMENT '状态',
  `is_deleted` int(2) DEFAULT '0' COMMENT '是否已删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `username` (`username`) USING BTREE,
  UNIQUE KEY `unionid` (`unionid`) USING BTREE,
  UNIQUE KEY `mini_openid` (`mini_openid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='用户表';

-- ----------------------------
-- Records of mall_user
-- ----------------------------
BEGIN;
INSERT INTO `mall_user` VALUES (1, '000000', NULL, NULL, NULL, 'admin', 'e10adc3949ba59abbe56e057f20f883e', 'aidan', 'aidansu', 'aidansu@163.com', '15999999999', '2019-09-09 00:00:00', 1, NULL, NULL, NULL, NULL, NULL, '2020-06-27 21:26:05', 1, '2019-09-08 11:00:00', 1, '2020-06-27 21:26:05', 1, 0);
INSERT INTO `mall_user` VALUES (2, '000001', NULL, 0x6F57537833354B5A59536634634C314979486D62554256414C6A7163, 'TjhxDd9V/axODl0FX1yJqg==', NULL, NULL, NULL, '常威暴打来福', NULL, NULL, NULL, 1, 'htts://wx.qlogo.cn/', 'Jiangmen', 'Guangdong', 'China', 'zh_CN', '2020-06-05 09:48:58', NULL, '2020-06-02 12:06:38', NULL, '2020-06-05 09:48:58', 1, 0);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
