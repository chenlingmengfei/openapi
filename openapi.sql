/*
 Navicat Premium Data Transfer

 Source Server         : chelin
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : openapi

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 09/07/2020 15:06:36
*/
creat database openapi;

use openapi;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_user
-- ----------------------------
DROP TABLE IF EXISTS `admin_user`;
CREATE TABLE `admin_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `realName` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_user
-- ----------------------------
INSERT INTO `admin_user` VALUES (1, '1', '2', '秋千', 1);

-- ----------------------------
-- Table structure for api_mapping
-- ----------------------------
DROP TABLE IF EXISTS `api_mapping`;
CREATE TABLE `api_mapping`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gatewayApiName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '对外接口名称',
  `insideApiUrl` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '对内的接口URL',
  `state` tinyint(4) NOT NULL COMMENT 'api状态 1 可用 0 不可用 ',
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接口描述',
  `serviceId` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `idempotents` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0',
  `needfee` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_openapiname`(`gatewayApiName`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of api_mapping
-- ----------------------------
INSERT INTO `api_mapping` VALUES (1, 'taobao.pop.order.get', '/orderget', 1, '获取订单信息接口', 'openapi-order', '0', '1');
INSERT INTO `api_mapping` VALUES (2, 'taobao.order.order.update', 'xxxx', 0, '修改订单状态接口', 'daseqweq', '0', '0');
INSERT INTO `api_mapping` VALUES (6, 'testservice01_02', '/testservice01/test02', 0, '测试服务 01 的 02 方法', 'testservice01', '0', '1');
INSERT INTO `api_mapping` VALUES (7, 'testservice02_02', '/testservice02//test02', 0, '测试服务 2 的 02 方法', 'testservice02', '0', '1');
INSERT INTO `api_mapping` VALUES (8, 'ceshi3_2', '/ceshi3/ceshi2', 1, '测试服务 3 普通方法', 'testservice03', '0', '1');
INSERT INTO `api_mapping` VALUES (9, 'testservice01_01', '/testservice01/test01/{name}', 0, '测试服务 1 的测试 1 方法', 'testservice01', '0', '1');
INSERT INTO `api_mapping` VALUES (10, 'testservice01_03', '/testservice01/test03/{name}/{age}/{pwd}', 0, '测试多路径参数', 'testservice01', '0', '1');
INSERT INTO `api_mapping` VALUES (11, 'orderget', '/orderget', 0, '查询订单', 'openapi-order', '0', '1');
INSERT INTO `api_mapping` VALUES (12, 'ordercancel', '/ordercancel', 1, '退货', 'openapi-order', '0', '1');
INSERT INTO `api_mapping` VALUES (14, 'fsdf', 'fsdf', 0, 'fsdfs', 'fsdfs', '0', '1');

-- ----------------------------
-- Table structure for api_systemparam
-- ----------------------------
DROP TABLE IF EXISTS `api_systemparam`;
CREATE TABLE `api_systemparam`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '参数名',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '介绍',
  `state` smallint(1) NULL DEFAULT 1 COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `nameuni`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of api_systemparam
-- ----------------------------
INSERT INTO `api_systemparam` VALUES (1, 'aaa', 'abcd', 0);
INSERT INTO `api_systemparam` VALUES (3, 'aaaa', 'asdasda', 1);

-- ----------------------------
-- Table structure for appinfo
-- ----------------------------
DROP TABLE IF EXISTS `appinfo`;
CREATE TABLE `appinfo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `corpName` varchar(64) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `appName` varchar(64) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `appKey` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `appSecret` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `redirectUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `linit` int(11) NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `cusId` int(11) NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of appinfo
-- ----------------------------
INSERT INTO `appinfo` VALUES (2, '同打', '掌上', '1', '1', '/url', 2, '3456', 8, 0);
INSERT INTO `appinfo` VALUES (3, '同打', '掌上', '1', '1', '/url', 2, '3456', 8, 1);
INSERT INTO `appinfo` VALUES (4, '深大', '手机音乐', '123', '123456', '/yinyue', 100, '听歌', 12, 0);

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_croatian_ci NULL DEFAULT NULL,
  `money` int(11) NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (8, '黎', '1', '同打', '广西', 14, 1);
INSERT INTO `customer` VALUES (9, '李四', '1', '冠希', '深圳', 1, 1);
INSERT INTO `customer` VALUES (10, '刘备', '1', '累死', '深圳', 1, 0);
INSERT INTO `customer` VALUES (11, '张三', '1', '掌声', '深圳', 1, 0);
INSERT INTO `customer` VALUES (12, '陈琳', '123', '深大', '深圳', 123, 1);

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `PARENT_ID` int(11) NULL DEFAULT NULL,
  `URL` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ICON` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PERMS` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TYPE` smallint(6) NULL DEFAULT NULL,
  `SORT` int(11) NULL DEFAULT 1000,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (2, '权限管理', NULL, NULL, 'fa fa-bug', NULL, 0, 1);
INSERT INTO `menu` VALUES (3, '菜单管理', 2, 'sys/menu.html', 'fa fa-th-list', 'sys:menu:list', 1, 1000);
INSERT INTO `menu` VALUES (4, '角色管理', 2, 'sys/role.html', 'fa fa-key', 'sys:user:list', 1, 1000);
INSERT INTO `menu` VALUES (5, '用户管理', 2, 'sys/user.html', 'fa fa-user', 'sys:user:list', 1, 1000);
INSERT INTO `menu` VALUES (6, '添加', 5, 'sys/user/add', NULL, 'sys:user:add', 2, 1000);
INSERT INTO `menu` VALUES (7, '修改', 5, 'sys/user/update', NULL, 'sys:user:update', 2, 1000);
INSERT INTO `menu` VALUES (8, '删除', 5, 'sys/user/del', NULL, 'sys:user:delete', 2, 1000);
INSERT INTO `menu` VALUES (9, '授权', 5, 'sys/user/assign_role', NULL, 'sys:user:assign', 2, 1000);
INSERT INTO `menu` VALUES (10, '添加', 3, 'sys/menu/add', NULL, 'sys:menu:add', 2, 1000);
INSERT INTO `menu` VALUES (11, '修改', 3, 'sys/menu/update', NULL, 'sys:menu:update', 2, 1000);
INSERT INTO `menu` VALUES (12, '删除', 3, 'sys/menu/del', NULL, 'sys:menu:delete', 2, 1000);
INSERT INTO `menu` VALUES (13, '列表', 3, 'sys/menu/list', NULL, 'sys:menu:list', 2, 1000);
INSERT INTO `menu` VALUES (14, '菜单树', 3, 'sys/menu/tree', NULL, 'sys:menu:tree', 2, 1000);
INSERT INTO `menu` VALUES (15, '详情', 3, 'sys/menu/info', NULL, 'sys:menu:info', 2, 1000);
INSERT INTO `menu` VALUES (16, '添加', 4, 'sys/role/add', NULL, 'sys:role:add', 2, 1000);
INSERT INTO `menu` VALUES (17, '修改', 4, 'sys/role/update', NULL, 'sys:role:update', 2, 1000);
INSERT INTO `menu` VALUES (18, '删除', 4, 'sys/role/delete', NULL, 'sys:role:delete', 2, 1000);
INSERT INTO `menu` VALUES (19, '授权', 4, 'sys/role/assign_menu', NULL, 'sys:role:assign', 2, 1000);
INSERT INTO `menu` VALUES (20, '路由管理', NULL, 'sys/api_mapping.html', 'fa fa-cogs', 'sys:api:list', 1, 4);
INSERT INTO `menu` VALUES (21, '添加', 20, NULL, NULL, 'sys:api:add', 2, 1000);
INSERT INTO `menu` VALUES (22, '修改', 20, NULL, NULL, 'sys:api:update', 2, 1000);
INSERT INTO `menu` VALUES (23, '删除', 20, NULL, NULL, 'sys:api:delete', 2, 1000);
INSERT INTO `menu` VALUES (24, '日志搜索', NULL, 'sys/search.html', 'fa fa-search', 'sys:search:list', 1, 8);
INSERT INTO `menu` VALUES (25, 'token管理', NULL, 'sys/token.html', 'fa fa-cubes', 'sys:token:list', 1, 6);
INSERT INTO `menu` VALUES (26, '修改', 25, NULL, NULL, 'sys:token:update', 2, 1000);
INSERT INTO `menu` VALUES (27, '应用管理', NULL, 'sys/appInfo.html', 'fa fa-diamond', 'sys:app:list', 1, 3);
INSERT INTO `menu` VALUES (28, '修改', 27, NULL, NULL, 'sys:app:update', 2, 1000);
INSERT INTO `menu` VALUES (30, '列表', 2, 'sys/user/table', NULL, 'sys:user:table', 2, 1000);
INSERT INTO `menu` VALUES (31, '用户角色树', 2, 'sys/user/role_tree', NULL, 'sys:user:role_tree', 2, 1000);
INSERT INTO `menu` VALUES (32, '用户角色', 2, 'sys/user/user_role', NULL, 'sys:user:user_role', 2, 1000);
INSERT INTO `menu` VALUES (33, '分配角色', 2, 'sys/user/assign_role', NULL, 'sys:user:ssign_role', 2, 1000);
INSERT INTO `menu` VALUES (34, '详情', 2, 'sys/user/info', NULL, 'sys:user:info', 2, 1000);
INSERT INTO `menu` VALUES (35, '系统参数管理', NULL, 'sys/api_systemparam.html', 'fa fa-diamond', 'sys:systemparamter:list', 1, 5);
INSERT INTO `menu` VALUES (36, '客户管理', NULL, 'sys/Customer.html', 'fa fa-diamond', 'sys:customer:list', 1, 2);
INSERT INTO `menu` VALUES (37, '充值管理', NULL, 'sys/recharge.html', 'fa fa-diamond', 'sys:recharge:list', 1, 7);
INSERT INTO `menu` VALUES (38, '菜单树', 4, 'sys/role/menu_tree', NULL, NULL, 2, 1000);
INSERT INTO `menu` VALUES (39, '获取角色菜单树', 4, 'sys/role/role_menu', NULL, NULL, 2, 1000);
INSERT INTO `menu` VALUES (40, '角色信息', 4, 'sys/role/info', NULL, NULL, 2, 1000);

-- ----------------------------
-- Table structure for recharge
-- ----------------------------
DROP TABLE IF EXISTS `recharge`;
CREATE TABLE `recharge`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cusId` int(11) NOT NULL COMMENT '客户 id',
  `orderId` bigint(255) NULL DEFAULT NULL COMMENT '订单号',
  `createtime` datetime(0) NOT NULL COMMENT '创建时间',
  `updatetime` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `money` int(11) NULL DEFAULT NULL COMMENT '充值金额(分)',
  `state` smallint(1) NOT NULL DEFAULT 0 COMMENT '状态,0创建,1 支付,2 取消',
  `paymenttype` smallint(3) NULL DEFAULT NULL COMMENT '支付方式 支付宝 微信等',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of recharge
-- ----------------------------
INSERT INTO `recharge` VALUES (2, 8, 1593762876567, '2020-07-03 15:54:37', '2020-07-03 17:30:13', 23, 2, 1);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `REMARK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `STATUS` int(11) NOT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'admin', '超级管理员', 1);
INSERT INTO `role` VALUES (2, 'guest', '用户', 1);
INSERT INTO `role` VALUES (3, 'user', '普通', 1);

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `ROLE_ID` int(11) NOT NULL,
  `MENU_ID` int(11) NOT NULL,
  PRIMARY KEY (`ROLE_ID`, `MENU_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES (1, 2);
INSERT INTO `role_menu` VALUES (1, 3);
INSERT INTO `role_menu` VALUES (1, 4);
INSERT INTO `role_menu` VALUES (1, 5);
INSERT INTO `role_menu` VALUES (1, 6);
INSERT INTO `role_menu` VALUES (1, 7);
INSERT INTO `role_menu` VALUES (1, 8);
INSERT INTO `role_menu` VALUES (1, 9);
INSERT INTO `role_menu` VALUES (1, 10);
INSERT INTO `role_menu` VALUES (1, 11);
INSERT INTO `role_menu` VALUES (1, 12);
INSERT INTO `role_menu` VALUES (1, 13);
INSERT INTO `role_menu` VALUES (1, 14);
INSERT INTO `role_menu` VALUES (1, 15);
INSERT INTO `role_menu` VALUES (1, 16);
INSERT INTO `role_menu` VALUES (1, 17);
INSERT INTO `role_menu` VALUES (1, 18);
INSERT INTO `role_menu` VALUES (1, 19);
INSERT INTO `role_menu` VALUES (1, 20);
INSERT INTO `role_menu` VALUES (1, 21);
INSERT INTO `role_menu` VALUES (1, 22);
INSERT INTO `role_menu` VALUES (1, 23);
INSERT INTO `role_menu` VALUES (1, 24);
INSERT INTO `role_menu` VALUES (1, 25);
INSERT INTO `role_menu` VALUES (1, 26);
INSERT INTO `role_menu` VALUES (1, 27);
INSERT INTO `role_menu` VALUES (1, 28);
INSERT INTO `role_menu` VALUES (1, 29);
INSERT INTO `role_menu` VALUES (1, 30);
INSERT INTO `role_menu` VALUES (1, 31);
INSERT INTO `role_menu` VALUES (1, 32);
INSERT INTO `role_menu` VALUES (1, 33);
INSERT INTO `role_menu` VALUES (1, 34);
INSERT INTO `role_menu` VALUES (1, 35);
INSERT INTO `role_menu` VALUES (1, 36);
INSERT INTO `role_menu` VALUES (1, 37);
INSERT INTO `role_menu` VALUES (1, 38);
INSERT INTO `role_menu` VALUES (1, 39);
INSERT INTO `role_menu` VALUES (1, 40);
INSERT INTO `role_menu` VALUES (2, 2);
INSERT INTO `role_menu` VALUES (2, 4);
INSERT INTO `role_menu` VALUES (2, 5);
INSERT INTO `role_menu` VALUES (2, 6);
INSERT INTO `role_menu` VALUES (2, 7);
INSERT INTO `role_menu` VALUES (2, 8);
INSERT INTO `role_menu` VALUES (2, 16);
INSERT INTO `role_menu` VALUES (2, 17);
INSERT INTO `role_menu` VALUES (2, 18);
INSERT INTO `role_menu` VALUES (3, 2);
INSERT INTO `role_menu` VALUES (3, 3);
INSERT INTO `role_menu` VALUES (3, 4);
INSERT INTO `role_menu` VALUES (3, 5);
INSERT INTO `role_menu` VALUES (3, 6);
INSERT INTO `role_menu` VALUES (3, 7);
INSERT INTO `role_menu` VALUES (3, 8);
INSERT INTO `role_menu` VALUES (3, 9);
INSERT INTO `role_menu` VALUES (3, 10);
INSERT INTO `role_menu` VALUES (3, 11);
INSERT INTO `role_menu` VALUES (3, 12);
INSERT INTO `role_menu` VALUES (3, 13);
INSERT INTO `role_menu` VALUES (3, 14);
INSERT INTO `role_menu` VALUES (3, 15);
INSERT INTO `role_menu` VALUES (3, 16);
INSERT INTO `role_menu` VALUES (3, 17);
INSERT INTO `role_menu` VALUES (3, 18);
INSERT INTO `role_menu` VALUES (3, 19);
INSERT INTO `role_menu` VALUES (3, 30);
INSERT INTO `role_menu` VALUES (3, 31);
INSERT INTO `role_menu` VALUES (3, 32);
INSERT INTO `role_menu` VALUES (3, 33);
INSERT INTO `role_menu` VALUES (3, 34);
INSERT INTO `role_menu` VALUES (3, 38);
INSERT INTO `role_menu` VALUES (3, 39);
INSERT INTO `role_menu` VALUES (3, 40);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `USER_ID` int(11) NOT NULL,
  `ROLE_ID` int(11) NOT NULL,
  PRIMARY KEY (`USER_ID`, `ROLE_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1);
INSERT INTO `user_role` VALUES (2, 2);

-- ----------------------------
-- Table structure for user_token
-- ----------------------------
DROP TABLE IF EXISTS `user_token`;
CREATE TABLE `user_token`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `appId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `access_token` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `expireTime` datetime(0) NOT NULL,
  `startTime` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_token
-- ----------------------------
INSERT INTO `user_token` VALUES (1, 123, 1, 'eb6aa496-4918-4099-9082-19582e8438e1', '2024-11-01 00:00:23', '2019-08-01 00:00:26');

SET FOREIGN_KEY_CHECKS = 1;
