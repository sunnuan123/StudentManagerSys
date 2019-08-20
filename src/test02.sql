/*
 Navicat Premium Data Transfer

 Source Server         : con1
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : test02

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 20/08/2019 23:04:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin`  (
  `ano` int(55) NOT NULL AUTO_INCREMENT,
  `name` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pwd` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `employdate` date NULL DEFAULT NULL,
  `hobby` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ano`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21090130 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES (20190101, '李四', '111', '1234', '12345@123', '男', NULL, NULL, '222');
INSERT INTO `t_admin` VALUES (20190102, '王五', '22', '123', '12345@123', '男', NULL, NULL, '今天天气不错哦');
INSERT INTO `t_admin` VALUES (20190103, '赵六', '33', '122', '12345@123', '男', NULL, NULL, '我叫赵六');
INSERT INTO `t_admin` VALUES (20190104, '田七', '44', '112', '12345@123', '男', NULL, NULL, '我叫田七');
INSERT INTO `t_admin` VALUES (20190105, '宋八', '55', '222', '12345@123', '男', NULL, NULL, '我叫送吧');
INSERT INTO `t_admin` VALUES (20190106, '颖酒', '66', '111', '12345@123', '男', NULL, NULL, '我叫饮酒');
INSERT INTO `t_admin` VALUES (20190818, '胖虎', '2222', '15830983396', '27675014@qq.com', '男', NULL, NULL, '这是一个悲伤的故事');
INSERT INTO `t_admin` VALUES (21090120, '傻妞', '77', '4444', '12345@123', '男', NULL, NULL, '这是傻妞');
INSERT INTO `t_admin` VALUES (21090121, '赵丽颖', '111', '1276182', '126176@qq.com', '女', '2019-01-01', '看书', '注释注释');
INSERT INTO `t_admin` VALUES (21090123, '周杰伦', '111', '172318', '12571@qq.com', '男', '2019-03-31', '{学习, 睡觉, 打游戏}', '全能人才');
INSERT INTO `t_admin` VALUES (21090127, '胡老师', '111', '1551624615', '1245121@qq.com', '男', '2019-07-14', '{学习}', '爱学习的好老师');
INSERT INTO `t_admin` VALUES (21090128, 'www', '111', '15810646297', '1248452992@qq.com', '男', '2019-04-01', '{学习}', '喜欢java');
INSERT INTO `t_admin` VALUES (21090129, '胡一刀', '111', '15810646297', '125722221@qq.com', '男', '2019-02-02', '{学习}', '好学生');

-- ----------------------------
-- Table structure for t_class
-- ----------------------------
DROP TABLE IF EXISTS `t_class`;
CREATE TABLE `t_class`  (
  `classno` int(55) NOT NULL,
  `cname` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cteacher` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `classroom` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`classno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_class
-- ----------------------------
INSERT INTO `t_class` VALUES (1, 'java7班', '刘老师', '102');
INSERT INTO `t_class` VALUES (2, 'ios班', '张老师', '506');
INSERT INTO `t_class` VALUES (3, 'javaweb', '李老师', '407');
INSERT INTO `t_class` VALUES (4, '安卓1', '周老师', '201');
INSERT INTO `t_class` VALUES (5, 'java5班', '曹老师', '209');
INSERT INTO `t_class` VALUES (6, 'IOS1班', '王老师', '303');

-- ----------------------------
-- Table structure for t_course
-- ----------------------------
DROP TABLE IF EXISTS `t_course`;
CREATE TABLE `t_course`  (
  `cno` int(55) NOT NULL AUTO_INCREMENT,
  `cname` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `credit` int(55) NULL DEFAULT NULL,
  `periodstart` date NULL DEFAULT NULL,
  `periodend` date NULL DEFAULT NULL,
  PRIMARY KEY (`cno`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20170113 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_course
-- ----------------------------
INSERT INTO `t_course` VALUES (20170101, 'JAVA编程语言', 1, '2017-08-21', '2017-08-26');
INSERT INTO `t_course` VALUES (20170103, 'c#从入门到放弃', 2, '2017-08-22', '2017-08-30');
INSERT INTO `t_course` VALUES (20170104, 'JavaWEB从入门到精通', 2, '2017-08-29', '2017-08-26');
INSERT INTO `t_course` VALUES (20170105, '电子线路', 2, '2017-08-14', '2017-08-26');
INSERT INTO `t_course` VALUES (20170106, '电路基础', 2, '2017-08-13', '2017-08-26');
INSERT INTO `t_course` VALUES (20170107, '数字电路', 1, '2017-08-14', '2017-08-15');
INSERT INTO `t_course` VALUES (20170108, '模拟电路', 1, '2017-08-22', '2017-08-25');
INSERT INTO `t_course` VALUES (20170109, '数据结构', 2, '2017-08-07', '2017-08-10');
INSERT INTO `t_course` VALUES (20170110, '编译原理', 3, '2017-08-30', '2017-09-12');
INSERT INTO `t_course` VALUES (20170112, 'python', 4, '2019-09-01', '2019-12-12');

-- ----------------------------
-- Table structure for t_sc
-- ----------------------------
DROP TABLE IF EXISTS `t_sc`;
CREATE TABLE `t_sc`  (
  `sno` int(55) NULL DEFAULT NULL,
  `cno` int(55) NULL DEFAULT NULL,
  `tno` int(55) NULL DEFAULT NULL,
  `score` int(55) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_sc
-- ----------------------------
INSERT INTO `t_sc` VALUES (20170101, 20170103, 20170103, 33);
INSERT INTO `t_sc` VALUES (20170101, 20170108, 20170106, 0);
INSERT INTO `t_sc` VALUES (20170101, 20170105, 20170103, 31);
INSERT INTO `t_sc` VALUES (20170101, 20170106, 20170107, 0);
INSERT INTO `t_sc` VALUES (20170101, 20170107, 20170106, 0);
INSERT INTO `t_sc` VALUES (20170102, 20170101, 20170101, 33);
INSERT INTO `t_sc` VALUES (20170102, 20170103, 20170103, 558);
INSERT INTO `t_sc` VALUES (20170102, 20170107, 20170106, 0);
INSERT INTO `t_sc` VALUES (20170102, 20170108, 20170106, 0);
INSERT INTO `t_sc` VALUES (20170102, 20170109, 20170104, 0);
INSERT INTO `t_sc` VALUES (20170102, 20170110, 20170108, 0);
INSERT INTO `t_sc` VALUES (20170103, 20170101, 20170101, 55);
INSERT INTO `t_sc` VALUES (20170103, 20170104, 20170104, 0);
INSERT INTO `t_sc` VALUES (20170103, 20170103, 20170103, 23);
INSERT INTO `t_sc` VALUES (20170103, 20170108, 20170101, 22);
INSERT INTO `t_sc` VALUES (20170103, 20170105, 20170103, 44);
INSERT INTO `t_sc` VALUES (20170107, 20170103, 20170103, 555);
INSERT INTO `t_sc` VALUES (20170107, 20170104, 20170104, 0);
INSERT INTO `t_sc` VALUES (20170107, 20170106, 20170107, 0);
INSERT INTO `t_sc` VALUES (20170107, 20170108, 20170101, 33);
INSERT INTO `t_sc` VALUES (20170107, 20170109, 20170104, 0);

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student`  (
  `sno` int(55) NOT NULL AUTO_INCREMENT,
  `pwd` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sname` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birth` date NULL DEFAULT NULL,
  `classno` int(55) NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`sno`) USING BTREE,
  INDEX `pr_claass`(`classno`) USING BTREE,
  CONSTRAINT `pr_claass` FOREIGN KEY (`classno`) REFERENCES `t_class` (`classno`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 20180126 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES (20180101, '111', '尼古拉斯.赵四', '716253167', '男', '2019-01-02', 1, '们都爱笑你只懂啊吗');
INSERT INTO `t_student` VALUES (20180102, '222', '阿伊土鳖.张', '1234567', '女', '2017-08-30', 2, NULL);
INSERT INTO `t_student` VALUES (20180103, '333', '张无忌', '1234567', '男', '2017-08-22', 3, NULL);
INSERT INTO `t_student` VALUES (20180104, '444', '梅超风', '1234567', '男', '2017-08-23', 4, NULL);
INSERT INTO `t_student` VALUES (20180105, '111', '灭绝师太', '1234567', '女', '2017-08-23', 6, NULL);
INSERT INTO `t_student` VALUES (20180106, '222', '乔峰张', '1234567', '男', '2017-08-14', 3, NULL);
INSERT INTO `t_student` VALUES (20180107, '333', '淑芬', '1234567', '女', '2017-09-14', 5, '');
INSERT INTO `t_student` VALUES (20180109, '111', '张三丰', '1234567', '男', '2017-08-02', 2, '');
INSERT INTO `t_student` VALUES (20180112, '111', '曾阿牛', '1234567', '男', '2017-08-28', 5, 'ww13932222');
INSERT INTO `t_student` VALUES (20180116, '1234567', '王六久', '18911370041', '男', '1994-06-20', 2, '我是一个学生，是一个做IOS的好学生');

-- ----------------------------
-- Table structure for t_tc
-- ----------------------------
DROP TABLE IF EXISTS `t_tc`;
CREATE TABLE `t_tc`  (
  `cno` int(55) NOT NULL,
  `tno` int(55) NOT NULL,
  PRIMARY KEY (`cno`, `tno`) USING BTREE,
  INDEX `cno`(`cno`) USING BTREE,
  INDEX `tno`(`tno`) USING BTREE,
  CONSTRAINT `t_tc_ibfk_1` FOREIGN KEY (`cno`) REFERENCES `t_course` (`cno`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_tc_ibfk_2` FOREIGN KEY (`tno`) REFERENCES `t_teacher` (`tno`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_tc
-- ----------------------------
INSERT INTO `t_tc` VALUES (20170101, 20170101);
INSERT INTO `t_tc` VALUES (20170103, 20170103);
INSERT INTO `t_tc` VALUES (20170104, 20170104);
INSERT INTO `t_tc` VALUES (20170105, 20170101);
INSERT INTO `t_tc` VALUES (20170105, 20170103);
INSERT INTO `t_tc` VALUES (20170106, 20170107);
INSERT INTO `t_tc` VALUES (20170107, 20170106);
INSERT INTO `t_tc` VALUES (20170108, 20170106);
INSERT INTO `t_tc` VALUES (20170109, 20170104);
INSERT INTO `t_tc` VALUES (20170110, 20170106);

-- ----------------------------
-- Table structure for t_teacher
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher`  (
  `tno` int(55) NOT NULL AUTO_INCREMENT,
  `tname` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tpwd` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tphone` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hiredate` date NULL DEFAULT NULL,
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`tno`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20170109 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO `t_teacher` VALUES (20170101, '刘老师', '0101', '15830983396', '2017-08-22', '没有了备注');
INSERT INTO `t_teacher` VALUES (20170103, '王府井', '0', '0', '2017-08-23', '00');
INSERT INTO `t_teacher` VALUES (20170104, '假正经', '222', '2222', '2017-08-30', '我就是一个程序员');
INSERT INTO `t_teacher` VALUES (20170105, '刘宝钢', '333', '15830983396', '2017-08-21', '我就是一个程序员');
INSERT INTO `t_teacher` VALUES (20170106, '张家辉', '444', '15830983396', '2017-08-29', '我就是一个程序员');
INSERT INTO `t_teacher` VALUES (20170107, '鲤鱼同', '555', '15830983396', '2017-08-26', '我就是一个程序员');
INSERT INTO `t_teacher` VALUES (20170108, '张晓风', '666', '15830983396', '2017-08-20', '我就是一个程序员');

SET FOREIGN_KEY_CHECKS = 1;
