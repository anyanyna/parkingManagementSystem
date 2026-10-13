/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.0.129
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : 192.168.0.129:3306
 Source Schema         : db_1845284868271898624_cxjmxd

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 23/10/2024 17:43:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for associated_parking_lot
-- ----------------------------
DROP TABLE IF EXISTS `associated_parking_lot`;
CREATE TABLE `associated_parking_lot`  (
                                           `id` int(11) NOT NULL COMMENT '主键',
                                           `parking_lot_number` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '车场编号',
                                           `parking_lot_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '车场名称',
                                           `associated_time` datetime NULL DEFAULT NULL COMMENT '关联时间',
                                           `association_status` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '关联状态',
                                           `associated_person` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '关联人',
                                           `create_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建者用户名称(对应登录用户的username)',
                                           `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                           `update_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '最后修改者用户名称(对应登录用户的username)',
                                           `update_time` datetime NULL DEFAULT NULL COMMENT '最后修改时间',
                                           PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'Associated parking lot table, includes fields: id, parking_lot_number, parking_lot_name, associated_time, association_status, associated_person.' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for billing_detail
-- ----------------------------
DROP TABLE IF EXISTS `billing_detail`;
CREATE TABLE `billing_detail`  (
                                   `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                   `order_id` int(11) NULL DEFAULT NULL COMMENT '订单ID',
                                   `serial_number` int(11) NULL DEFAULT NULL COMMENT '序号',
                                   `billing_type` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '计费类型',
                                   `billing_vehicle` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '计费车辆',
                                   `billing_period` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '计费时段',
                                   `start_time` datetime NULL DEFAULT NULL COMMENT '开始时间',
                                   `end_time` datetime NULL DEFAULT NULL COMMENT '结束时间',
                                   `duration` int(11) NULL DEFAULT NULL COMMENT '时长',
                                   `amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '金额',
                                   `billing_rule` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '计费规则',
                                   `create_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建者用户名称(对应登录用户的username)',
                                   `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                   `update_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '最后修改者用户名称(对应登录用户的username)',
                                   `update_time` datetime NULL DEFAULT NULL COMMENT '最后修改时间',
                                   PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 273 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '计费明细表，包含订单ID、序号、计费类型、计费车辆、计费时段、开始时间、结束时间、时长和计费规则。' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for billing_free_time_range
-- ----------------------------
DROP TABLE IF EXISTS `billing_free_time_range`;
CREATE TABLE `billing_free_time_range`  (
                                            `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                            `free_begin_time` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '开始时间',
                                            `free_end_time` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '结束时间',
                                            `billing_rule_id` int(11) NULL DEFAULT NULL COMMENT '计费规则ID',
                                            PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for billing_holiday_schedule
-- ----------------------------
DROP TABLE IF EXISTS `billing_holiday_schedule`;
CREATE TABLE `billing_holiday_schedule`  (
                                             `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                             `holiday_start_date` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '开始日期',
                                             `holiday_end_date` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '结束日期',
                                             `holiday_remarks` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '节假日备注',
                                             `user_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户ID',
                                             `billing_rule_id` int(11) NULL DEFAULT NULL COMMENT '计费规则ID',
                                             PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '计费规则节假日信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for billing_operation_record
-- ----------------------------
DROP TABLE IF EXISTS `billing_operation_record`;
CREATE TABLE `billing_operation_record`  (
                                             `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                             `operation_time` datetime NULL DEFAULT NULL COMMENT '操作时间',
                                             `operation_node` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '操作节点',
                                             `operation_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '操作内容',
                                             `operator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '操作人员',
                                             `billing_rule_id` int(11) NULL DEFAULT NULL COMMENT '计费管理ID',
                                             `create_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建者用户名称(对应登录用户的username)',
                                             `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                             `update_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '最后修改者用户名称(对应登录用户的username)',
                                             `update_time` datetime NULL DEFAULT NULL COMMENT '最后修改时间',
                                             `operation_personnel` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                             `billing_management_id` int(11) NULL DEFAULT NULL,
                                             PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'Billing operation record table, includes fields: id, billing_management_id, operation_time, operation_node, operation_content, operator.' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for billing_rule_parking
-- ----------------------------
DROP TABLE IF EXISTS `billing_rule_parking`;
CREATE TABLE `billing_rule_parking`  (
                                         `id` int(11) NOT NULL AUTO_INCREMENT,
                                         `billing_rule_id` int(11) NULL DEFAULT NULL COMMENT '规则id',
                                         `parking_lot_info_id` int(11) NULL DEFAULT NULL COMMENT '停车场id',
                                         `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                         `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
                                         `create_username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建人',
                                         `update_username` datetime NULL DEFAULT NULL COMMENT '更新人',
                                         `status` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '状态',
                                         `relation_time` datetime NULL DEFAULT NULL COMMENT '关联时间',
                                         PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for billing_rules
-- ----------------------------
DROP TABLE IF EXISTS `billing_rules`;
CREATE TABLE `billing_rules`  (
                                  `id` int(11) NOT NULL AUTO_INCREMENT,
                                  `rule_number` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '规则编号',
                                  `rule_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '规则名称',
                                  `billing_standard` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '收费方案',
                                  `rule_description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '规则描述',
                                  `status` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '状态',
                                  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建人（表单填写）',
                                  `associated_parking_count` int(11) NULL DEFAULT NULL COMMENT '关联车场数',
                                  `free_duration` int(11) NULL DEFAULT NULL COMMENT '免费时长',
                                  `new_energy_free_duration_reduction` int(11) NULL DEFAULT NULL COMMENT '新能源减免开关',
                                  `temporary_car` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '临时车',
                                  `stored_value_car` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '储值车',
                                  `new_energy_free_duration` int(11) NULL DEFAULT NULL COMMENT '新能源免费时长',
                                  `free_duration_reduction` int(11) NULL DEFAULT NULL COMMENT '免费时常开关',
                                  `white_plate_car_free` tinyint(1) NULL DEFAULT NULL COMMENT '白牌车免费开关',
                                  `new_energy_free_times` int(11) NULL DEFAULT NULL COMMENT '新能源免费次数',
                                  `free_period_reduction` int(11) NULL DEFAULT NULL COMMENT '时段减免开关',
                                  `wd_temporary_car_cap_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '工作日、白天、临时车收费封顶金额',
                                  `wd_stored_value_car_cap_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '工作日、白天、储值车收费封顶金额',
                                  `wn_temporary_car_cap_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '工作日、夜间、临时车收费封顶金额',
                                  `wn_stored_value_car_cap_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '工作日、夜间、储值车收费封顶金额',
                                  `hd_temporary_car_cap_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '节假日、白天、临时车收费封顶金额',
                                  `hd_stored_value_car_cap_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '节假日、白天、储值车收费封顶金额',
                                  `hn_temporary_car_cap_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '节假日、夜间、临时车收费封顶金额',
                                  `hn_stored_value_car_cap_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '节假日、夜间、储值车收费封顶金额',
                                  `wd_begin_time_range` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '工作日、白天开始时间',
                                  `wd_end_time_range` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '工作日、夜间结束时间',
                                  `wn_begin_time_range` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '工作日、夜间第一段开始时间',
                                  `wn_end_time_range` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '工作日、夜间第一段结束时间',
                                  `wn_second_begin_time_range` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '工作日、夜间第二段开始时间',
                                  `wn_second_end_time_range` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '工作日、夜间第二段结束时间',
                                  `hd_begin_time_range` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '节假日、白天开始时间',
                                  `hd_end_time_range` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '节假日、夜间结束时间',
                                  `hn_begin_time_range` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '节假日、夜间第一段开始时间',
                                  `hn_end_time_range` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '节假日、夜间第一段结束时间',
                                  `hn_second_begin_time_range` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '节假日、夜间第二段开始时间',
                                  `hn_second_end_time_range` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '节假日、夜间第二段结束时间',
                                  `wd_temporary_car_first_tier` decimal(10, 2) NULL DEFAULT NULL COMMENT '工作日、白天、第一阶段临时车收费价格',
                                  `wd_temporary_car_second_tier` decimal(10, 2) NULL DEFAULT NULL COMMENT '工作日、白天、第二阶段临时车收费价格',
                                  `wd_temporary_car_third_tier` decimal(10, 2) NULL DEFAULT NULL COMMENT '工作日、白天、第三阶段临时车收费价格',
                                  `wd_stored_value_car_first_tier` decimal(10, 2) NULL DEFAULT NULL COMMENT '工作日、白天、第一阶段储值车收费价格',
                                  `wd_stored_value_car_second_tier` decimal(10, 2) NULL DEFAULT NULL COMMENT '工作日、白天、第二阶段储值车收费价格',
                                  `wd_stored_value_car_third_tier` decimal(10, 2) NULL DEFAULT NULL COMMENT '工作日、白天、第三阶段储值车收费价格',
                                  `wn_temporary_car_first_tier` decimal(10, 2) NULL DEFAULT NULL COMMENT '工作日、夜间、第一阶段临时车收费价格',
                                  `wn_temporary_car_second_tier` decimal(10, 2) NULL DEFAULT NULL COMMENT '工作日、夜间、第二阶段临时车收费价格',
                                  `wn_temporary_car_third_tier` decimal(10, 2) NULL DEFAULT NULL COMMENT '工作日、夜间、第三阶段临时车收费价格',
                                  `wn_stored_value_car_first_tier` decimal(10, 2) NULL DEFAULT NULL COMMENT '工作日、夜间、第一阶段储值车收费价格',
                                  `wn_stored_value_car_second_tier` decimal(10, 2) NULL DEFAULT NULL COMMENT '工作日、夜间、第二阶段储值车收费价格',
                                  `wn_stored_value_car_third_tier` decimal(10, 2) NULL DEFAULT NULL COMMENT '工作日、夜间、第三阶段储值车收费价格',
                                  `hd_temporary_car_first_tier` decimal(10, 2) NULL DEFAULT NULL COMMENT '节假日、白天、第一阶段临时车收费价格',
                                  `hd_temporary_car_second_tier` decimal(10, 2) NULL DEFAULT NULL COMMENT '节假日、白天、第二阶段临时车收费价格',
                                  `hd_temporary_car_third_tier` decimal(10, 2) NULL DEFAULT NULL COMMENT '节假日、白天、第三阶段临时车收费价格',
                                  `hd_stored_value_car_first_tier` decimal(10, 2) NULL DEFAULT NULL COMMENT '节假日、白天、第一阶段储值车收费价格',
                                  `hd_stored_value_car_second_tier` decimal(10, 2) NULL DEFAULT NULL COMMENT '节假日、白天、第二阶段储值车收费价格',
                                  `hd_stored_value_car_third_tier` decimal(10, 2) NULL DEFAULT NULL COMMENT '节假日、白天、第三阶段储值车收费价格',
                                  `hn_temporary_car_first_tier` decimal(10, 2) NULL DEFAULT NULL COMMENT '节假日、夜间、第一阶段临时车收费价格',
                                  `hn_temporary_car_second_tier` decimal(10, 2) NULL DEFAULT NULL COMMENT '节假日、夜间、第二阶段临时车收费价格',
                                  `hn_temporary_car_third_tier` decimal(10, 2) NULL DEFAULT NULL COMMENT '节假日、夜间、第三阶段临时车收费价格',
                                  `hn_stored_value_car_first_tier` decimal(10, 2) NULL DEFAULT NULL COMMENT '节假日、夜间、第一阶段储值车收费价格',
                                  `hn_stored_value_car_second_tier` decimal(10, 2) NULL DEFAULT NULL COMMENT '节假日、夜间、第二阶段储值车收费价格',
                                  `hn_stored_value_car_third_tier` decimal(10, 2) NULL DEFAULT NULL COMMENT '节假日、夜间、第三阶段储值车收费价格',
                                  `wd_temporary_car_first_time` int(11) NULL DEFAULT NULL COMMENT '工作日、白天、第一阶段临时车时间步长',
                                  `wd_temporary_car_second_time` int(11) NULL DEFAULT NULL COMMENT '工作日、白天、第二阶段临时车时间步长',
                                  `wd_temporary_car_third_time` int(11) NULL DEFAULT NULL COMMENT '工作日、白天、第三阶段临时车时间步长',
                                  `wd_stored_value_car_first_time` int(11) NULL DEFAULT NULL COMMENT '工作日、白天、第一阶段储值车时间步长',
                                  `wd_stored_value_car_second_time` int(11) NULL DEFAULT NULL COMMENT '工作日、白天、第二阶段储值车时间步长',
                                  `wd_stored_value_car_third_time` int(11) NULL DEFAULT NULL COMMENT '工作日、白天、第三阶段储值车时间步长',
                                  `wn_temporary_car_first_time` int(11) NULL DEFAULT NULL COMMENT '工作日、夜间、第一阶段临时车时间步长',
                                  `wn_temporary_car_second_time` int(11) NULL DEFAULT NULL COMMENT '工作日、夜间、第二阶段临时车时间步长',
                                  `wn_temporary_car_third_time` int(11) NULL DEFAULT NULL COMMENT '工作日、夜间、第三阶段临时车时间步长',
                                  `wn_stored_value_car_first_time` int(11) NULL DEFAULT NULL COMMENT '工作日、夜间、第一阶段储值车时间步长',
                                  `wn_stored_value_car_second_time` int(11) NULL DEFAULT NULL COMMENT '工作日、夜间、第二阶段储值车时间步长',
                                  `wn_stored_value_car_third_time` int(11) NULL DEFAULT NULL COMMENT '工作日、夜间、第三阶段储值车时间步长',
                                  `hd_temporary_car_first_time` int(11) NULL DEFAULT NULL COMMENT '节假日、白天、第一阶段临时车时间步长',
                                  `hd_temporary_car_second_time` int(11) NULL DEFAULT NULL COMMENT '节假日、白天、第二阶段临时车时间步长',
                                  `hd_temporary_car_third_time` int(11) NULL DEFAULT NULL COMMENT '节假日、白天、第三阶段临时车时间步长',
                                  `hd_stored_value_car_first_time` int(11) NULL DEFAULT NULL COMMENT '节假日、白天、第一阶段储值车时间步长',
                                  `hd_stored_value_car_second_time` int(11) NULL DEFAULT NULL COMMENT '节假日、白天、第二阶段储值车时间步长',
                                  `hd_stored_value_car_third_time` int(11) NULL DEFAULT NULL COMMENT '节假日、白天、第三阶段储值车时间步长',
                                  `hn_temporary_car_first_time` int(11) NULL DEFAULT NULL COMMENT '节假日、夜间、第一阶段临时车时间步长',
                                  `hn_temporary_car_second_time` int(11) NULL DEFAULT NULL COMMENT '节假日、夜间、第二阶段临时车时间步长',
                                  `hn_temporary_car_third_time` int(11) NULL DEFAULT NULL COMMENT '节假日、夜间、第三阶段临时车时间步长',
                                  `hn_stored_value_car_first_time` int(11) NULL DEFAULT NULL COMMENT '节假日、夜间、第一阶段储值车时间步长',
                                  `hn_stored_value_car_second_time` int(11) NULL DEFAULT NULL COMMENT '节假日、夜间、第二阶段储值车时间步长',
                                  `hn_stored_value_car_third_time` int(11) NULL DEFAULT NULL COMMENT '节假日、夜间、第三阶段储值车时间步长',
                                  `wd_temporary_car_first_ceil` int(11) NULL DEFAULT NULL COMMENT '工作日、白天、第一阶段临时车时间上限',
                                  `wd_temporary_car_second_ceil` int(11) NULL DEFAULT NULL COMMENT '工作日、白天、第二阶段临时车时间上限',
                                  `wd_temporary_car_third_ceil` int(11) NULL DEFAULT NULL COMMENT '工作日、白天、第三阶段临时车时间上限',
                                  `wd_stored_value_car_first_ceil` int(11) NULL DEFAULT NULL COMMENT '工作日、白天、第一阶段储值车时间上限',
                                  `wd_stored_value_car_second_ceil` int(11) NULL DEFAULT NULL COMMENT '工作日、白天、第二阶段储值车时间上限',
                                  `wd_stored_value_car_third_ceil` int(11) NULL DEFAULT NULL COMMENT '工作日、白天、第三阶段储值车时间上限',
                                  `wn_temporary_car_first_ceil` int(11) NULL DEFAULT NULL COMMENT '工作日、夜间、第一阶段临时车时间上限',
                                  `wn_temporary_car_second_ceil` int(11) NULL DEFAULT NULL COMMENT '工作日、夜间、第二阶段临时车时间上限',
                                  `wn_temporary_car_third_ceil` int(11) NULL DEFAULT NULL COMMENT '工作日、夜间、第三阶段临时车时间上限',
                                  `wn_stored_value_car_first_ceil` int(11) NULL DEFAULT NULL COMMENT '工作日、夜间、第一阶段储值车时间上限',
                                  `wn_stored_value_car_second_ceil` int(11) NULL DEFAULT NULL COMMENT '工作日、夜间、第二阶段储值车时间上限',
                                  `wn_stored_value_car_third_ceil` int(11) NULL DEFAULT NULL COMMENT '工作日、夜间、第三阶段储值车时间上限',
                                  `hd_temporary_car_first_ceil` int(11) NULL DEFAULT NULL COMMENT '节假日、白天、第一阶段临时车时间上限',
                                  `hd_temporary_car_second_ceil` int(11) NULL DEFAULT NULL COMMENT '节假日、白天、第二阶段临时车时间上限',
                                  `hd_temporary_car_third_ceil` int(11) NULL DEFAULT NULL COMMENT '节假日、白天、第三阶段临时车时间上限',
                                  `hd_stored_value_car_first_ceil` int(11) NULL DEFAULT NULL COMMENT '节假日、白天、第一阶段储值车时间上限',
                                  `hd_stored_value_car_second_ceil` int(11) NULL DEFAULT NULL COMMENT '节假日、白天、第二阶段储值车时间上限',
                                  `hd_stored_value_car_third_ceil` int(11) NULL DEFAULT NULL COMMENT '节假日、白天、第三阶段储值车时间上限',
                                  `hn_temporary_car_first_ceil` int(11) NULL DEFAULT NULL COMMENT '节假日、夜间、第一阶段临时车时间上限',
                                  `hn_temporary_car_second_ceil` int(11) NULL DEFAULT NULL COMMENT '节假日、夜间、第二阶段临时车时间上限',
                                  `hn_temporary_car_third_ceil` int(11) NULL DEFAULT NULL COMMENT '节假日、夜间、第三阶段临时车时间上限',
                                  `hn_stored_value_car_first_ceil` int(11) NULL DEFAULT NULL COMMENT '节假日、夜间、第一阶段储值车时间上限',
                                  `hn_stored_value_car_second_ceil` int(11) NULL DEFAULT NULL COMMENT '节假日、夜间、第二阶段储值车时间上限',
                                  `hn_stored_value_car_third_ceil` int(11) NULL DEFAULT NULL COMMENT '节假日、夜间、第三阶段储值车时间上限',
                                  `create_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建者用户名称(对应登录用户的username)',
                                  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                  `update_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '最后修改者用户名称(对应登录用户的username)',
                                  `update_time` datetime NULL DEFAULT NULL COMMENT '最后修改时间',
                                  `created_time` datetime NULL DEFAULT NULL,
                                  `created_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                  `associated_time` datetime NULL DEFAULT NULL,
                                  `associated_person` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                  `parking_lot_id` int(11) NULL DEFAULT NULL,
                                  `charging_scheme` int(11) NULL DEFAULT NULL,
                                  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '计费规则表，包含规则编号、规则名称、收费标准、规则描述、关联车场数、创建时间、创建人。' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for billing_scheme
-- ----------------------------
DROP TABLE IF EXISTS `billing_scheme`;
CREATE TABLE `billing_scheme`  (
                                   `id` int(11) NOT NULL COMMENT '主键',
                                   `scheme_type` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '收费方案类型',
                                   `free_duration` int(11) NULL DEFAULT NULL COMMENT '免费时长',
                                   `temporary_car` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '临时车',
                                   `stored_value_car` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '储值车',
                                   `new_energy_free_duration` int(11) NULL DEFAULT NULL COMMENT '新能源免费时长',
                                   `free_duration_reduction` int(11) NULL DEFAULT NULL COMMENT '免费时长减免',
                                   `white_plate_car_free` tinyint(1) NULL DEFAULT NULL COMMENT '白牌车免费',
                                   `new_energy_free_times` int(11) NULL DEFAULT NULL COMMENT '新能源免费次数',
                                   `free_period_reduction` int(11) NULL DEFAULT NULL COMMENT '免费时段减免',
                                   `temporary_car_first_tier` int(11) NULL DEFAULT NULL COMMENT '临时车-第一阶梯',
                                   `temporary_car_second_tier` int(11) NULL DEFAULT NULL COMMENT '临时车-第二阶梯',
                                   `temporary_car_third_tier` int(11) NULL DEFAULT NULL COMMENT '临时车-第三阶梯',
                                   `stored_value_car_first_tier` int(11) NULL DEFAULT NULL COMMENT '储值车-第一阶梯',
                                   `stored_value_car_second_tier` int(11) NULL DEFAULT NULL COMMENT '储值车-第二阶梯',
                                   `stored_value_car_third_tier` int(11) NULL DEFAULT NULL COMMENT '储值车-第三阶梯',
                                   `temporary_car_cap_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '临时车-封顶金额',
                                   `stored_value_car_cap_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '储值车-封顶金额',
                                   `create_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建者用户名称(对应登录用户的username)',
                                   `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                   `update_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '最后修改者用户名称(对应登录用户的username)',
                                   `update_time` datetime NULL DEFAULT NULL COMMENT '最后修改时间',
                                   `segment_charging` tinyint(1) NULL DEFAULT NULL,
                                   PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '收费方案表，包含收费方案类型、免费时长、临时车、储值车、新能源免费时长、免费时长减免、白牌车免费、新能源免费次数、免费时段减免、临时车-第一阶梯、临时车-第二阶梯、临时车-第三阶梯、储值车-第一阶梯、储值车-第二阶梯、储值车-第三阶梯、临时车-封顶金额、储值车-封顶金额。' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for booth_management
-- ----------------------------
DROP TABLE IF EXISTS `booth_management`;
CREATE TABLE `booth_management`  (
                                     `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                     `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '姓名',
                                     `phone_number` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '手机号',
                                     `id_card` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '身份证',
                                     `status` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '状态',
                                     `entry_time` datetime NULL DEFAULT NULL COMMENT '入职时间',
                                     `resignation_time` datetime NULL DEFAULT NULL COMMENT '离职时间',
                                     `create_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建者用户名称(对应登录用户的username)',
                                     `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                     `update_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '最后修改者用户名称(对应登录用户的username)',
                                     `update_time` datetime NULL DEFAULT NULL COMMENT '最后修改时间',
                                     `parking_lot_id` int(11) NULL DEFAULT NULL COMMENT '车场ID',
                                     PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '岗亭管理表，包含车场ID、姓名、手机号、身份证、状态、入职时间、离职时间。' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for business_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `business_dictionary`;
CREATE TABLE `business_dictionary`  (
                                        `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                        `order` int(11) NULL DEFAULT NULL COMMENT '顺序',
                                        `key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                        `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '名称',
                                        `operation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '操作',
                                        `create_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建者用户名称(对应登录用户的username)',
                                        `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                        `update_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '最后修改者用户名称(对应登录用户的username)',
                                        `update_time` datetime NULL DEFAULT NULL COMMENT '最后修改时间',
                                        `key_value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '键值',
                                        `order_number` int(11) NULL DEFAULT NULL,
                                        PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '业务字典表，包含字段：id, order, key_value, name, operation, create_username, create_time, update_username, update_time' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for dictionary_detail
-- ----------------------------
DROP TABLE IF EXISTS `dictionary_detail`;
CREATE TABLE `dictionary_detail`  (
                                      `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                      `order` int(11) NULL DEFAULT NULL COMMENT '顺序',
                                      `key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                      `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '名称',
                                      `operation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '操作',
                                      `business_dictionary_id` int(11) NULL DEFAULT NULL COMMENT '业务字典ID',
                                      `create_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建者用户名称(对应登录用户的username)',
                                      `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                      `update_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '最后修改者用户名称(对应登录用户的username)',
                                      `update_time` datetime NULL DEFAULT NULL COMMENT '最后修改时间',
                                      `key_value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '键值',
                                      `order_number` int(11) NULL DEFAULT NULL,
                                      PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '字典详情表，包含字段：id, order, key_value, name, operation, business_dictionary_id, create_username, create_time, update_username, update_time' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for extended_info
-- ----------------------------
DROP TABLE IF EXISTS `extended_info`;
CREATE TABLE `extended_info`  (
                                  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                  `property_unit` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '产权单位',
                                  `building_attribute` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '建筑属性',
                                  `license_number` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '许可证编号',
                                  `business_scope` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '经营范围',
                                  `contact_person` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '联系人',
                                  `contact_phone` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '联系电话',
                                  `property_description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '产权描述',
                                  `usage_years` int(11) NULL DEFAULT NULL COMMENT '使用年限',
                                  `construction_time` date NULL DEFAULT NULL COMMENT '建设时间',
                                  `validity_period` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '有效期',
                                  `attachment_upload` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '附件上传',
                                  `create_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建者用户名称(对应登录用户的username)',
                                  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                  `update_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '最后修改者用户名称(对应登录用户的username)',
                                  `update_time` datetime NULL DEFAULT NULL COMMENT '最后修改时间',
                                  `parking_lot_id` int(11) NULL DEFAULT NULL COMMENT '车场ID',
                                  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '拓展信息表，包含车场ID、产权单位、建筑属性、许可证编号、经营范围、联系人、联系电话、产权描述、使用年限、建设时间、有效期、附件上传。' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for file_attachment_list
-- ----------------------------
DROP TABLE IF EXISTS `file_attachment_list`;
CREATE TABLE `file_attachment_list`  (
                                         `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                         `sequence_number` int(11) NULL DEFAULT NULL,
                                         `attachment_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '附件名称',
                                         `upload_time` datetime NULL DEFAULT NULL COMMENT '上传时间',
                                         `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建人',
                                         `create_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建者用户名称(对应登录用户的username)',
                                         `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                         `update_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '最后修改者用户名称(对应登录用户的username)',
                                         `update_time` datetime NULL DEFAULT NULL COMMENT '最后修改时间',
                                         `parking_lot_id` int(11) NULL DEFAULT NULL COMMENT '车场ID',
                                         PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '文件附件列表表，包含车场ID、附件名称、上传时间、创建人。' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for logout
-- ----------------------------
DROP TABLE IF EXISTS `logout`;
CREATE TABLE `logout`  (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `ref` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                           `create_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                           `create_time` datetime NULL DEFAULT NULL,
                           `update_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                           `update_time` datetime NULL DEFAULT NULL,
                           PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for menus
-- ----------------------------
DROP TABLE IF EXISTS `menus`;
CREATE TABLE `menus`  (
                          `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
                          `menu_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '菜单名称',
                          `parent_id` int(11) NULL DEFAULT NULL COMMENT '上级菜单ID',
                          `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '图标',
                          `page_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                          `sort_order` int(11) NULL DEFAULT NULL COMMENT '排序',
                          `updated_at` datetime NULL DEFAULT NULL COMMENT '更新时间',
                          `create_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建者用户名称(对应登录用户的username)',
                          `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                          `update_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '最后修改者用户名称(对应登录用户的username)',
                          `update_time` datetime NULL DEFAULT NULL COMMENT '最后修改时间',
                          `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL,
                          `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '路径',
                          `page` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '页面',
                          PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '菜单表，包含菜单ID、菜单名称、路径、图标、页面、上级菜单ID、排序和更新时间。' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for message_list
-- ----------------------------
DROP TABLE IF EXISTS `message_list`;
CREATE TABLE `message_list`  (
                                 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
                                 `user_id` int(11) NULL DEFAULT NULL COMMENT '接收消息的用户id',
                                 `message_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '消息内容',
                                 `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '消息状态（已读，未读）',
                                 `created_at` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                 `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
                                 `create_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建用户',
                                 `update_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '更新用户',
                                 `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                 PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '消息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for navigation_component
-- ----------------------------
DROP TABLE IF EXISTS `navigation_component`;
CREATE TABLE `navigation_component`  (
                                         `id` int(11) NOT NULL AUTO_INCREMENT,
                                         `component_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                         `ref` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                         `create_time` datetime NULL DEFAULT NULL,
                                         `update_time` datetime NULL DEFAULT NULL,
                                         `create_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                         `update_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                         PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for navigation_page
-- ----------------------------
DROP TABLE IF EXISTS `navigation_page`;
CREATE TABLE `navigation_page`  (
                                    `id` int(11) NOT NULL AUTO_INCREMENT,
                                    `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                    `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL,
                                    `create_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                    `create_time` datetime NULL DEFAULT NULL,
                                    `update_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                    `update_time` datetime NULL DEFAULT NULL,
                                    `page_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for operation_rules
-- ----------------------------
DROP TABLE IF EXISTS `operation_rules`;
CREATE TABLE `operation_rules`  (
                                    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                    `prepayment_overtime_duration` int(11) NULL DEFAULT NULL COMMENT '预付超时时长',
                                    `overtime_exit_handling` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '超时未离开处理',
                                    `abnormal_status` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '异常状态',
                                    `abnormal_handling` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '异常处理',
                                    `notification` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '是否通知',
                                    `blacklist` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '黑名单',
                                    `whitelist` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '白名单',
                                    `reserved_spaces_count` int(11) NULL DEFAULT NULL COMMENT '预约车位数',
                                    `reservation_overtime_duration` int(11) NULL DEFAULT NULL COMMENT '预约超时时长',
                                    `exit_scan` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '出场扫码',
                                    `create_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建者用户名称(对应登录用户的username)',
                                    `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                    `update_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '最后修改者用户名称(对应登录用户的username)',
                                    `update_time` datetime NULL DEFAULT NULL COMMENT '最后修改时间',
                                    `parking_lot_id` int(11) NULL DEFAULT NULL COMMENT '车场ID',
                                    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '运营规则表，包含车场ID、预付超时时长、超时未离开处理、异常状态、异常处理、是否通知、黑名单、白名单、预约车位数、预约超时时长、出场扫码。' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order_operation_record
-- ----------------------------
DROP TABLE IF EXISTS `order_operation_record`;
CREATE TABLE `order_operation_record`  (
                                           `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                           `order_id` int(11) NULL DEFAULT NULL COMMENT '订单ID',
                                           `serial_number` int(11) NULL DEFAULT NULL COMMENT '序号',
                                           `operator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '操作人员',
                                           `operation_type` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '操作类型',
                                           `operation_description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '操作说明',
                                           `operation_record` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '操作记录',
                                           `operation_detail` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '操作详情',
                                           `operation_time` datetime NULL DEFAULT NULL COMMENT '操作时间',
                                           `create_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建者用户名称(对应登录用户的username)',
                                           `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                           `update_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '最后修改者用户名称(对应登录用户的username)',
                                           `update_time` datetime NULL DEFAULT NULL COMMENT '最后修改时间',
                                           PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '订单操作记录表，包含订单ID、序号、操作人员、操作类型、操作说明、操作记录、操作详情和操作时间。' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order_payment_record
-- ----------------------------
DROP TABLE IF EXISTS `order_payment_record`;
CREATE TABLE `order_payment_record`  (
                                         `id` int(11) NOT NULL COMMENT '主键',
                                         `order_id` int(11) NULL DEFAULT NULL COMMENT '订单ID',
                                         `serial_number` int(11) NULL DEFAULT NULL COMMENT '序号',
                                         `payment_source` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '支付来源',
                                         `payment_method` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '支付方式',
                                         `transaction_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '交易金额',
                                         `transaction_time` datetime NULL DEFAULT NULL COMMENT '交易时间',
                                         `transaction_status` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '交易状态',
                                         `create_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建者用户名称(对应登录用户的username)',
                                         `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                         `update_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '最后修改者用户名称(对应登录用户的username)',
                                         `update_time` datetime NULL DEFAULT NULL COMMENT '最后修改时间',
                                         PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '订单支付记录表，包含订单ID、序号、支付来源、支付方式、交易金额、交易时间和交易状态。' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for organization
-- ----------------------------
DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization`  (
                                 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '组织机构ID',
                                 `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '组织机构名称',
                                 `parent_id` int(11) NULL DEFAULT NULL COMMENT '上级组织机构ID',
                                 `leader_id` int(11) NULL DEFAULT NULL,
                                 `sort_order` int(11) NULL DEFAULT NULL,
                                 `remarks` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL,
                                 `created_at` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                 `updated_at` datetime NULL DEFAULT NULL COMMENT '更新时间',
                                 `create_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建者用户名称(对应登录用户的username)',
                                 `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                 `update_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '最后修改者用户名称(对应登录用户的username)',
                                 `update_time` datetime NULL DEFAULT NULL COMMENT '最后修改时间',
                                 `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '组织机构描述',
                                 `leader` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                 `remark` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL,
                                 PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 65 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '组织机构表，包含组织机构ID、组织机构名称、组织机构描述、上级组织机构ID、创建时间、更新时间。' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for parking_lot_info
-- ----------------------------
DROP TABLE IF EXISTS `parking_lot_info`;
CREATE TABLE `parking_lot_info`  (
                                     `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                     `parking_lot_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '车场编号',
                                     `parking_lot_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '车场名称',
                                     `parking_lot_short_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '车场简称',
                                     `parking_spaces` int(11) NULL DEFAULT NULL COMMENT '泊车数量',
                                     `long_term_spaces` int(11) NULL DEFAULT NULL COMMENT '长租车位',
                                     `reserved_spaces` int(11) NULL DEFAULT NULL COMMENT '预约车位',
                                     `vip_spaces` int(11) NULL DEFAULT NULL COMMENT '贵宾车位',
                                     `charging_piles` int(11) NULL DEFAULT NULL COMMENT '充电桩数',
                                     `operating_company` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '运营公司',
                                     `manager` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '负责人',
                                     `contact_number` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '联系电话',
                                     `latitude_longitude` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '经纬度',
                                     `detailed_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '详细地址',
                                     `parking_lot_description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '车场描述',
                                     `parking_lot_status` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '车场状态',
                                     `parking_lot_type` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '车场类型',
                                     `region` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '所属区域',
                                     `category` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '车场类别',
                                     `sector` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '所属板块',
                                     `charging_service` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '充电服务',
                                     `additional_service` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '附加服务',
                                     `screen_visibility` tinyint(1) NULL DEFAULT NULL COMMENT '大屏是否可见',
                                     `parking_lot_icon` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '车场图标',
                                     `parking_lot_photo` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '车场照片',
                                     `bill_rule_id` int(11) NULL DEFAULT NULL COMMENT '计费规则ID',
                                     `create_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建者用户名称(对应登录用户的username)',
                                     `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                     `update_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '最后修改者用户名称(对应登录用户的username)',
                                     `update_time` datetime NULL DEFAULT NULL COMMENT '最后修改时间',
                                     PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '车场信息表，包含车场编号、车场名称、车场简称、泊车数量、长租车位、预约车位、贵宾车位、充电桩数、运营公司、负责人、联系电话、经纬度、详细地址、车场描述、车场状态、车场类型、所属区域、车场类别、所属板块、充电服务、附加服务、大屏是否可见、车场图标、车场照片。' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for parking_lot_list
-- ----------------------------
DROP TABLE IF EXISTS `parking_lot_list`;
CREATE TABLE `parking_lot_list`  (
                                     `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                     `sequence_number` int(11) NULL DEFAULT NULL COMMENT '序号',
                                     `parking_lot_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '车场编号',
                                     `parking_lot_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '车场名称',
                                     `region` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '所属区域',
                                     `sector` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '所属板块',
                                     `category` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '车场类别',
                                     `parking_lot_type` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '车场类型',
                                     `parking_lot_status` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '车场状态',
                                     `parking_spaces` int(11) NULL DEFAULT NULL COMMENT '泊车数量',
                                     `operating_company` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '运营公司',
                                     `manager` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '负责人',
                                     `contact_number` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '联系电话',
                                     `operation` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '操作',
                                     `create_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建者用户名称(对应登录用户的username)',
                                     `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                     `update_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '最后修改者用户名称(对应登录用户的username)',
                                     `update_time` datetime NULL DEFAULT NULL COMMENT '最后修改时间',
                                     PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '车场列表表，包含序号、车场编号、车场名称、所属区域、所属板块、车场类别、车场类型、车场状态、泊车数量、运营公司、负责人、联系电话、操作。' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for parking_lot_user
-- ----------------------------
DROP TABLE IF EXISTS `parking_lot_user`;
CREATE TABLE `parking_lot_user`  (
                                     `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary Key',
                                     `user_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'User Code',
                                     `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Name',
                                     `contact` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Contact',
                                     `main_license_plate` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Main License Plate',
                                     `secondary_license_plate` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Secondary License Plate',
                                     `created_at` datetime NULL DEFAULT NULL COMMENT 'Created At',
                                     `status` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Status',
                                     `create_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建者用户名称(对应登录用户的username)',
                                     `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                     `update_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '最后修改者用户名称(对应登录用户的username)',
                                     `update_time` datetime NULL DEFAULT NULL COMMENT '最后修改时间',
                                     `identity_card` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                     `contact_info` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                     `creation_time` datetime NULL DEFAULT NULL,
                                     `operation` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                     PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'Parking lot user table, containing user ID, user code, name, contact, main license plate, secondary license plate, created at, and status.' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for parking_operation_records
-- ----------------------------
DROP TABLE IF EXISTS `parking_operation_records`;
CREATE TABLE `parking_operation_records`  (
                                              `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                              `sequence_number` int(11) NULL DEFAULT NULL,
                                              `operation_time` datetime NULL DEFAULT NULL COMMENT '操作时间',
                                              `operation_node` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '操作节点',
                                              `operation_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '操作内容',
                                              `operator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '操作人员',
                                              `create_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建者用户名称(对应登录用户的username)',
                                              `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                              `update_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '最后修改者用户名称(对应登录用户的username)',
                                              `update_time` datetime NULL DEFAULT NULL COMMENT '最后修改时间',
                                              `parking_lot_id` int(11) NULL DEFAULT NULL COMMENT '车场ID',
                                              PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '车场操作记录表，包含车场ID、操作时间、操作节点、操作内容、操作人员。' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
                               `id` int(11) NOT NULL COMMENT '权限ID',
                               `permission_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '权限名称',
                               `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '权限描述',
                               `create_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建者用户名称(对应登录用户的username)',
                               `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                               `update_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '最后修改者用户名称(对应登录用户的username)',
                               `update_time` datetime NULL DEFAULT NULL COMMENT '最后修改时间',
                               PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '权限表，包含权限的基本信息，如权限ID、权限名称和权限描述。' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for platform_info
-- ----------------------------
DROP TABLE IF EXISTS `platform_info`;
CREATE TABLE `platform_info`  (
                                  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                  `operating_mode` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '运营模式',
                                  `operating_company` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '运营公司',
                                  `integration_platform` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                  `create_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建者用户名称(对应登录用户的username)',
                                  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                  `update_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '最后修改者用户名称(对应登录用户的username)',
                                  `update_time` datetime NULL DEFAULT NULL COMMENT '最后修改时间',
                                  `parking_lot_id` int(11) NULL DEFAULT NULL COMMENT '车场ID',
                                  `docking_platform` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '对接平台',
                                  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '平台信息表，包含车场ID、运营模式、运营公司、对接平台。' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
                         `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
                         `role_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '角色名称',
                         `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL,
                         `create_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建者用户名称(对应登录用户的username)',
                         `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                         `update_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '最后修改者用户名称(对应登录用户的username)',
                         `update_time` datetime NULL DEFAULT NULL COMMENT '最后修改时间',
                         `role_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '角色代号',
                         `role_description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL,
                         PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '角色表，包含角色ID、角色名称。' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
                              `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
                              `role_id` int(11) NULL DEFAULT NULL COMMENT '角色ID',
                              `menu_id` int(11) NULL DEFAULT NULL COMMENT '菜单ID',
                              `create_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建者用户名称(对应登录用户的username)',
                              `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                              `update_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '最后修改者用户名称(对应登录用户的username)',
                              `update_time` datetime NULL DEFAULT NULL COMMENT '最后修改时间',
                              PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 132 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '角色菜单关联表，包含自增主键ID、角色ID和菜单ID。' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role_menu_permissions
-- ----------------------------
DROP TABLE IF EXISTS `role_menu_permissions`;
CREATE TABLE `role_menu_permissions`  (
                                          `id` int(11) NOT NULL COMMENT '自增主键ID',
                                          `role_id` int(11) NULL DEFAULT NULL COMMENT '角色ID',
                                          `menu_id` int(11) NULL DEFAULT NULL COMMENT '菜单ID',
                                          `permission_id` int(11) NULL DEFAULT NULL COMMENT '权限ID',
                                          `create_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建者用户名称(对应登录用户的username)',
                                          `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                          `update_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '最后修改者用户名称(对应登录用户的username)',
                                          `update_time` datetime NULL DEFAULT NULL COMMENT '最后修改时间',
                                          PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '角色与菜单权限关联表，包含自增主键ID、角色ID、菜单ID和权限ID。' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role_menus
-- ----------------------------
DROP TABLE IF EXISTS `role_menus`;
CREATE TABLE `role_menus`  (
                               `id` int(11) NOT NULL AUTO_INCREMENT,
                               `role_id` int(11) NULL DEFAULT NULL,
                               `menu_id` int(11) NULL DEFAULT NULL,
                               `create_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                               `create_time` datetime NULL DEFAULT NULL,
                               `update_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                               `update_time` datetime NULL DEFAULT NULL,
                               PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
                                    `id` int(11) NOT NULL AUTO_INCREMENT,
                                    `role_id` int(11) NULL DEFAULT NULL,
                                    `permission_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                    `create_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                    `create_time` datetime NULL DEFAULT NULL,
                                    `update_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                    `update_time` datetime NULL DEFAULT NULL,
                                    `role_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '角色代号',
                                    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for rule_information
-- ----------------------------
DROP TABLE IF EXISTS `rule_information`;
CREATE TABLE `rule_information`  (
                                     `id` int(11) NOT NULL COMMENT '主键',
                                     `rule_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                     `rule_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '规则名称',
                                     `rule_description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '规则描述',
                                     `charge_plan` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                     `create_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建者用户名称(对应登录用户的username)',
                                     `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                     `update_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '最后修改者用户名称(对应登录用户的username)',
                                     `update_time` datetime NULL DEFAULT NULL COMMENT '最后修改时间',
                                     `charging_scheme` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '收费方案',
                                     `rule_number` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '规则编号',
                                     PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'Rule information table, includes fields: id, rule_number, rule_name, rule_description, charging_scheme.' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_action
-- ----------------------------
DROP TABLE IF EXISTS `user_action`;
CREATE TABLE `user_action`  (
                                `id` int(11) NOT NULL AUTO_INCREMENT,
                                `user_id` int(11) NULL DEFAULT NULL,
                                `action_type` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                `action_time` datetime NULL DEFAULT NULL,
                                `create_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                `create_time` datetime NULL DEFAULT NULL,
                                `update_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                `update_time` datetime NULL DEFAULT NULL,
                                PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_center
-- ----------------------------
DROP TABLE IF EXISTS `user_center`;
CREATE TABLE `user_center`  (
                                `id` int(11) NOT NULL AUTO_INCREMENT,
                                `ref` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                `user_id` int(11) NULL DEFAULT NULL,
                                `panel_state` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                `create_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                `create_time` datetime NULL DEFAULT NULL,
                                `update_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                `update_time` datetime NULL DEFAULT NULL,
                                PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_order
-- ----------------------------
DROP TABLE IF EXISTS `user_order`;
CREATE TABLE `user_order`  (
                               `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                               `order_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '订单编号',
                               `license_plate` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '车牌号',
                               `order_status` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '订单状态',
                               `entry_time` datetime NULL DEFAULT NULL COMMENT '进入时间',
                               `exit_time` datetime NULL DEFAULT NULL COMMENT '离开时间',
                               `payment_status` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '支付状态',
                               `received_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '收到的金额',
                               `cashier` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '收银员',
                               `create_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建者用户名(对应登录用户的用户名)',
                               `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                               `update_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '最后修改者用户名(对应登录用户的用户名)',
                               `update_time` datetime NULL DEFAULT NULL COMMENT '最后修改时间',
                               `license_type` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '车牌类型',
                               `parking_lot` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '停车场',
                               `parking_duration` int(11) NULL DEFAULT NULL COMMENT '停车时长',
                               `order_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '订单金额',
                               `discount_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '折扣金额',
                               `receivable_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '应收金额',
                               `refund_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '退款金额',
                               `payment_channel` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '支付渠道',
                               `discount_channel` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '折扣渠道',
                               `operation` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '操作',
                               `payment_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '支付金额',
                               `payment_staff` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '支付工作人员',
                               `actual_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '实际金额',
                               `charging_staff` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '计费人员',
                               `order_source` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '订单来源',
                               `refund` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '是否退款订单',
                               `order_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '订单类型',
                               PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户订单表，包含订单编号、车牌号、车牌类型、停车场、订单状态、支付状态、进入时间、离开时间、停车时长、订单金额、折扣金额、应收金额、实际金额、退款金额、支付渠道、折扣渠道、计费人员、操作、支付金额等信息。' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
                              `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
                              `user_id` int(11) NULL DEFAULT NULL COMMENT '用户ID',
                              `role_id` int(11) NULL DEFAULT NULL COMMENT '角色ID',
                              `create_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建者用户名称(对应登录用户的username)',
                              `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                              `update_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '最后修改者用户名称(对应登录用户的username)',
                              `update_time` datetime NULL DEFAULT NULL COMMENT '最后修改时间',
                              PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户角色关联表，用于关联用户和角色，包含用户ID和角色ID。' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
                          `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
                          `user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '账号',
                          `nick_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '昵称',
                          `email` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '邮箱',
                          `phone_number` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                          `contact` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                          `status` tinyint(4) NULL DEFAULT NULL COMMENT '状态(0:正常,1:已删除,2:已被锁定),存进时默认值需要为0',
                          `password` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '密码(使用BCryptPasswordEncoder加密存进数据库)',
                          `avatar` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '头像',
                          `creation_time` datetime NULL DEFAULT NULL,
                          `updated_at` datetime NULL DEFAULT NULL,
                          `create_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建者用户名称(对应登录用户的username)',
                          `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                          `update_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '最后修改者用户名称(对应登录用户的username)',
                          `update_time` datetime NULL DEFAULT NULL COMMENT '最后修改时间',
                          `mobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '手机号',
                          `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '电话',
                          `organization_id` int(11) NULL DEFAULT NULL COMMENT '组织机构ID',
                          `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                          PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户表，包含用户的基本信息，如用户ID、账号、昵称、邮箱、手机号、电话、状态、组织机构ID、创建时间和更新时间。' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for vehicle_entry_exit_record
-- ----------------------------
DROP TABLE IF EXISTS `vehicle_entry_exit_record`;
CREATE TABLE `vehicle_entry_exit_record`  (
                                              `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary Key',
                                              `last_entry_time` datetime NULL DEFAULT NULL COMMENT 'Last Entry Time',
                                              `last_exit_time` datetime NULL DEFAULT NULL COMMENT 'Last Exit Time',
                                              `last_parking_lot` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '最近出入停车场',
                                              `create_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Creator Username',
                                              `create_time` datetime NULL DEFAULT NULL COMMENT 'Creation Time',
                                              `update_username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Last Modifier Username',
                                              `update_time` datetime NULL DEFAULT NULL COMMENT 'Last Modification Time',
                                              `license_plate_number` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'License Plate Number',
                                              `license_plate_type` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'License Plate Type',
                                              `entry_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '入口名字',
                                              `exit_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '出口名字',
                                              `contact` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '联系方式',
                                              `entry_picture` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '进入图片',
                                              `exit_picture` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '出场图片',
                                              `certificate` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '凭证',
                                              `berth_number` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '泊位编号',
                                              PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '车辆进出记录表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
