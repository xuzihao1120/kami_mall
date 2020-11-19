/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : kami

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 19/11/2020 22:02:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for kami_address
-- ----------------------------
DROP TABLE IF EXISTS `kami_address`;
CREATE TABLE `kami_address`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `receive_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货联系人',
  `receive_mobile` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '收货手机号',
  `receive_adress` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '收货地址',
  `receive_room` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '收货门牌号',
  `default_flag` tinyint(1) NULL DEFAULT 0 COMMENT '默认标识：1-默认，0-否',
  `created_by` bigint(20) NULL DEFAULT 0 COMMENT '创建人',
  `created_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint(20) NULL DEFAULT 0 COMMENT '更新人',
  `updated_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `delete_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除：0-有效，1-已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of kami_address
-- ----------------------------

-- ----------------------------
-- Table structure for kami_business
-- ----------------------------
DROP TABLE IF EXISTS `kami_business`;
CREATE TABLE `kami_business`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `business_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商家名称',
  `business_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商家编码',
  `business_image` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商家图片',
  `business_password` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '商家密码',
  `contact` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `phone_number` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `address` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系地址',
  `created_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间（商家入驻时间）',
  `created_by` bigint(20) NULL DEFAULT 0 COMMENT '创建人',
  `updated_by` bigint(20) NULL DEFAULT 0 COMMENT '更新人',
  `updated_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `delete_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除：0-有效，1-已删除',
  `salt` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '盐',
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '邮箱',
  `status` tinyint(4) NULL DEFAULT 1 COMMENT '账号状态 0-锁定；1-正常；2-禁用；3-已失效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 67 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of kami_business
-- ----------------------------
INSERT INTO `kami_business` VALUES (66, 'm', NULL, NULL, '', NULL, NULL, NULL, NULL, 0, 0, NULL, 0, '', '', 1);

-- ----------------------------
-- Table structure for kami_goods
-- ----------------------------
DROP TABLE IF EXISTS `kami_goods`;
CREATE TABLE `kami_goods`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '商品名称',
  `goods_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品价格',
  `goods_stock` bigint(20) NULL DEFAULT 0 COMMENT '商品库存',
  `sales_volume` bigint(20) NULL DEFAULT 0 COMMENT '商品销量',
  `goods_image` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '商品图片',
  `goods_detail` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '商品详情',
  `detail_image` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '详情图片',
  `created_by` bigint(20) NULL DEFAULT 0 COMMENT '创建人',
  `created_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint(20) NULL DEFAULT 0 COMMENT '更新人',
  `updated_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `delete_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除：0-有效，1-已删除',
  `goods_type` int(10) NULL DEFAULT NULL COMMENT '状态：0-手机数码，1-日用百货，等等',
  `business_id` bigint(20) NULL DEFAULT NULL COMMENT '商家id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of kami_goods
-- ----------------------------

-- ----------------------------
-- Table structure for kami_logistics_information
-- ----------------------------
DROP TABLE IF EXISTS `kami_logistics_information`;
CREATE TABLE `kami_logistics_information`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '物流信息id',
  `order_number` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单号',
  `logistics_company` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物流公司',
  `logistics_number` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物流单号',
  `status` int(10) NULL DEFAULT NULL COMMENT '状态：0-已发货，1-未发货，2-已完成，3-已下单，4，已揽件，5-运输中，6-派送中，7-待取件，8-已签收',
  `arrival` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '到达地点',
  `address_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货地址',
  `created_by` bigint(20) NULL DEFAULT 0 COMMENT '创建人',
  `created_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint(20) NULL DEFAULT 0 COMMENT '更新人',
  `updated_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `delete_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除：0-有效，1-已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of kami_logistics_information
-- ----------------------------

-- ----------------------------
-- Table structure for kami_order
-- ----------------------------
DROP TABLE IF EXISTS `kami_order`;
CREATE TABLE `kami_order`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_id` bigint(20) NULL DEFAULT 0 COMMENT '商品id',
  `goods_num` int(10) NULL DEFAULT 0 COMMENT '商品数量',
  `business_id` bigint(20) NULL DEFAULT NULL COMMENT '商家id',
  `address_id` bigint(20) NULL DEFAULT 0 COMMENT '地址id',
  `order_number` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单号',
  `logistics_company` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物流公司',
  `logistics_number` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物流单号',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `created_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间（下单时间）',
  `updated_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间（发货时间）',
  `user_id` bigint(12) NULL DEFAULT NULL COMMENT '用户id',
  `status` int(10) NULL DEFAULT NULL COMMENT '状态：0-已发货，1-未发货，2-已完成',
  `created_by` bigint(20) NULL DEFAULT 0 COMMENT '创建人',
  `updated_by` bigint(20) NULL DEFAULT 0 COMMENT '更新人',
  `delete_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除：0-有效，1-已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 120 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of kami_order
-- ----------------------------

-- ----------------------------
-- Table structure for kami_user
-- ----------------------------
DROP TABLE IF EXISTS `kami_user`;
CREATE TABLE `kami_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_account` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '用户账号',
  `user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '用户名称',
  `user_password` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '用户密码',
  `salt` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '盐',
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '邮箱',
  `mobile_number` varchar(16) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '手机',
  `status` tinyint(4) NULL DEFAULT 1 COMMENT '账号状态 0-锁定；1-正常；2-禁用；3-已失效',
  `effect_time` date NULL DEFAULT NULL COMMENT '生效时间',
  `expire_time` date NULL DEFAULT NULL COMMENT '失效时间',
  `comments` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '备注',
  `created_by` bigint(20) NULL DEFAULT 0 COMMENT '创建人',
  `created_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint(20) NULL DEFAULT 0 COMMENT '更新人',
  `updated_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `delete_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除：0-有效，1-已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of kami_user
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
