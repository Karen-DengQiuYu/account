/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50529
Source Host           : localhost:3306
Source Database       : accounts

Target Server Type    : MYSQL
Target Server Version : 50529
File Encoding         : 65001

Date: 2022-06-08 20:47:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bill
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(20) DEFAULT NULL,
  `type_id` int(20) DEFAULT NULL COMMENT '分类',
  `account` double(20,0) DEFAULT NULL COMMENT '金额',
  `pay_method` int(20) DEFAULT NULL COMMENT '支付方式 对应了card里的id',
  `date` datetime DEFAULT NULL COMMENT '更新时间 年月日 时分秒',
  `state` int(20) DEFAULT NULL COMMENT '-1表示支出 1表示收入',
  `comment` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of bill
-- ----------------------------
INSERT INTO `bill` VALUES ('4', '4', '2', '-10', '3', '2022-04-07 22:44:12', '-1', '4.7打车支出');
INSERT INTO `bill` VALUES ('7', '4', '2', '-20', '3', '2022-04-08 23:05:00', '-1', '打车支出');
INSERT INTO `bill` VALUES ('8', '4', '2', '-10', '3', '2022-04-18 23:05:00', '-1', '打车支出');
INSERT INTO `bill` VALUES ('9', '4', '3', '200', '2', '2022-04-19 23:13:15', '1', '工资');
INSERT INTO `bill` VALUES ('10', '4', '3', '50', '2', '2022-04-20 23:13:15', '1', '工资');
INSERT INTO `bill` VALUES ('11', '4', '2', '-20', '3', '2022-04-20 23:13:15', '-1', '支出');
INSERT INTO `bill` VALUES ('12', '4', '2', '-50', '3', '2022-04-22 23:13:15', '-1', '支出');
INSERT INTO `bill` VALUES ('13', '4', '1', '-50', '1', '2022-05-02 00:00:00', '-1', '加油');
INSERT INTO `bill` VALUES ('14', '4', '3', '100', '2', '2022-05-02 01:03:03', '1', '收入');
INSERT INTO `bill` VALUES ('24', '4', '2', '-15', '3', '2022-04-07 22:45:12', '-1', '4.7打车支出');
INSERT INTO `bill` VALUES ('25', '4', '2', '-10', '3', '2022-04-07 22:46:08', '-1', '打车支出');
INSERT INTO `bill` VALUES ('26', '4', '3', '1000', '2', '2022-04-07 23:13:15', '1', '工资');
INSERT INTO `bill` VALUES ('27', '4', '2', '-20', '3', '2022-04-08 23:05:00', '-1', '打车支出');
INSERT INTO `bill` VALUES ('28', '4', '2', '-10', '3', '2022-04-18 23:05:00', '-1', '打车支出');
INSERT INTO `bill` VALUES ('29', '4', '3', '200', '2', '2022-04-19 23:13:15', '1', '工资');
INSERT INTO `bill` VALUES ('30', '4', '3', '50', '2', '2022-04-20 23:13:15', '1', '工资');
INSERT INTO `bill` VALUES ('31', '4', '2', '-20', '3', '2022-04-20 23:13:15', '-1', '支出');
INSERT INTO `bill` VALUES ('32', '4', '2', '-50', '3', '2022-04-22 23:13:15', '-1', '支出');
INSERT INTO `bill` VALUES ('33', '4', '1', '-50', '1', '2022-05-02 00:00:00', '-1', '加油');
INSERT INTO `bill` VALUES ('34', '4', '7', '-10', '1', '2022-05-10 09:03:05', '-1', '晚餐');
INSERT INTO `bill` VALUES ('36', '4', '6', '-200', '2', '2022-05-10 22:00:00', '-1', '服饰');
INSERT INTO `bill` VALUES ('37', '4', '1', '-50', '1', '2022-05-11 00:00:00', '-1', '考试');
INSERT INTO `bill` VALUES ('38', '4', '3', '100', '2', '2022-05-11 01:30:00', '1', '工资');
INSERT INTO `bill` VALUES ('50', '4', '3', '100', '2', '2022-05-10 01:30:00', '1', '工资');
INSERT INTO `bill` VALUES ('51', '4', '3', '100', '2', '2022-05-09 01:30:00', '1', '工资');
INSERT INTO `bill` VALUES ('52', '4', '4', '-10', '1', '2022-05-12 08:00:00', '-1', '早餐');

-- ----------------------------
-- Table structure for card
-- ----------------------------
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(20) DEFAULT NULL,
  `card_name` varchar(256) DEFAULT NULL COMMENT '账号名',
  `card_overage` double(20,0) DEFAULT NULL COMMENT '卡余额 可以为负数 为负数就是 花呗',
  `interest_id` int(20) unsigned zerofill DEFAULT NULL COMMENT '利息表id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of card
-- ----------------------------
INSERT INTO `card` VALUES ('1', '4', '现金', '-725', '00000000000000000000');
INSERT INTO `card` VALUES ('2', '4', '工商银行', '3630', '00000000000000000000');
INSERT INTO `card` VALUES ('3', '4', '支付宝', '390', '00000000000000000000');
INSERT INTO `card` VALUES ('4', '4', '建设银行', '10000', '00000000000000000001');
INSERT INTO `card` VALUES ('5', '4', '工商银行', '2000', '00000000000000000002');
INSERT INTO `card` VALUES ('6', '4', '农业银行', '3000', '00000000000000000003');
INSERT INTO `card` VALUES ('7', '4', '理财产品', '1000', '00000000000000000004');
INSERT INTO `card` VALUES ('8', '4', '理财', '12000', '00000000000000000005');
INSERT INTO `card` VALUES ('12', '4', '花呗', '20', '00000000000000000000');
INSERT INTO `card` VALUES ('13', '4', '微信', '496', '00000000000000000000');
INSERT INTO `card` VALUES ('14', '4', '银行卡', '500', '00000000000000000000');
INSERT INTO `card` VALUES ('15', '23', '支付宝', '500', '00000000000000000000');
INSERT INTO `card` VALUES ('17', '4', '建设银行', '12000', '00000000000000000007');

-- ----------------------------
-- Table structure for echarts
-- ----------------------------
DROP TABLE IF EXISTS `echarts`;
CREATE TABLE `echarts` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of echarts
-- ----------------------------
INSERT INTO `echarts` VALUES ('1', '衣服', '159', '2022-04-07 01:33:07');
INSERT INTO `echarts` VALUES ('2', '裤子', '160', '2022-04-06 01:33:12');
INSERT INTO `echarts` VALUES ('3', '鞋子', '500', '2022-04-05 01:33:16');
INSERT INTO `echarts` VALUES ('4', '饰品', '60', '2022-04-03 01:33:19');

-- ----------------------------
-- Table structure for interest
-- ----------------------------
DROP TABLE IF EXISTS `interest`;
CREATE TABLE `interest` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id自增',
  `rate` varchar(20) DEFAULT NULL COMMENT '利率',
  `date` datetime DEFAULT NULL COMMENT '存入时间',
  `comment` varchar(256) DEFAULT NULL COMMENT '注释',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of interest
-- ----------------------------
INSERT INTO `interest` VALUES ('1', '1.75', '2021-01-02 00:00:00', '存钱放入');
INSERT INTO `interest` VALUES ('2', '1.75', '2022-05-02 00:00:00', '1.75利率');
INSERT INTO `interest` VALUES ('3', '1.75', '2022-04-30 01:03:03', '1.75利率');
INSERT INTO `interest` VALUES ('4', '3', '2022-05-10 01:48:46', '理财产品');
INSERT INTO `interest` VALUES ('5', '2', '2022-05-08 00:00:00', '理财产品');
INSERT INTO `interest` VALUES ('6', '1.75', '2022-05-11 03:00:00', '就k');

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(30) NOT NULL,
  `date` datetime NOT NULL,
  `content` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('9', '知识科普活动', '2022-05-04 07:25:50', '<p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\"><span style=\"font-family:PingFangSC-Regular\">今日，银行业理财登记中心发布</span>2022年一季度银行业理财数据，一季度，银行理财产品期限持续拉长，产品结构体系不断丰富，服务实体经济质效进一步深化。3月份，新发封闭式产品加权平均期限为456天，同比增长61.70%。产品期限的拉长有利于汇集中长期资金，助力我国实体经济平稳发展。截至3月底，银行理财产品通过投资债券、非标准化债权、未上市股权等资产，支持实体经济规模约25万亿元，同比增长4.61%。</span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; border: 0px; font-family: 宋体, Arial, sans-serif; text-indent: 2em; color: rgb(50, 50, 50); font-size: 14px; white-space: normal; text-align: right;\"><span style=\"font-family:PingFangSC-Regular\">央视财经（记者</span>&nbsp;<span style=\"font-family:PingFangSC-Regular\">黄晓丽）</span></p>');
INSERT INTO `news` VALUES ('11', '银行理财投资者倡议书', '2022-05-06 07:25:50', '<p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\"><span style=\"font-family:PingFangSC-Regular\">今日，银行业理财登记中心发布</span>2022年一季度银行业理财数据，一季度，银行理财产品期限持续拉长，产品结构体系不断丰富，服务实体经济质效进一步深化。3月份，新发封闭式产品加权平均期限为456天，同比增长61.70%。产品期限的拉长有利于汇集中长期资金，助力我国实体经济平稳发展。截至3月底，银行理财产品通过投资债券、非标准化债权、未上市股权等资产，支持实体经济规模约25万亿元，同比增长4.61%。</span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; border: 0px; font-family: 宋体, Arial, sans-serif; text-indent: 2em; color: rgb(50, 50, 50); font-size: 14px; white-space: normal; text-align: right;\"><span style=\"font-family:PingFangSC-Regular\">央视财经（记者</span>&nbsp;<span style=\"font-family:PingFangSC-Regular\">黄晓丽）</span></p>');
INSERT INTO `news` VALUES ('12', '理财助力乡村振兴', '2022-05-06 07:25:50', '<p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\"><span style=\"font-family:PingFangSC-Regular\">今日，银行业理财登记中心发布</span>2022年一季度银行业理财数据，一季度，银行理财产品期限持续拉长，产品结构体系不断丰富，服务实体经济质效进一步深化。3月份，新发封闭式产品加权平均期限为456天，同比增长61.70%。产品期限的拉长有利于汇集中长期资金，助力我国实体经济平稳发展。截至3月底，银行理财产品通过投资债券、非标准化债权、未上市股权等资产，支持实体经济规模约25万亿元，同比增长4.61%。</span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; border: 0px; font-family: 宋体, Arial, sans-serif; text-indent: 2em; color: rgb(50, 50, 50); font-size: 14px; white-space: normal; text-align: right;\"><span style=\"font-family:PingFangSC-Regular\">央视财经（记者</span>&nbsp;<span style=\"font-family:PingFangSC-Regular\">黄晓丽）</span></p>');
INSERT INTO `news` VALUES ('13', '央视财经', '2022-05-06 07:25:50', '<p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\"><span style=\"font-family:PingFangSC-Regular\">今日，银行业理财登记中心发布</span>2022年一季度银行业理财数据，一季度，银行理财产品期限持续拉长，产品结构体系不断丰富，服务实体经济质效进一步深化。3月份，新发封闭式产品加权平均期限为456天，同比增长61.70%。产品期限的拉长有利于汇集中长期资金，助力我国实体经济平稳发展。截至3月底，银行理财产品通过投资债券、非标准化债权、未上市股权等资产，支持实体经济规模约25万亿元，同比增长4.61%。</span></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; border: 0px; font-family: 宋体, Arial, sans-serif; text-indent: 2em; color: rgb(50, 50, 50); font-size: 14px; white-space: normal; text-align: right;\"><span style=\"font-family:PingFangSC-Regular\">央视财经（记者</span>&nbsp;<span style=\"font-family:PingFangSC-Regular\">黄晓丽）</span></p>');
INSERT INTO `news` VALUES ('14', '银行理财净值波动幅度有限 破净率持续所好转', '2022-05-06 07:27:31', '<p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\">有业内人士认为，银行理财净值波动幅度有限，涉及产品数量占比极低，总体情况可控。随着未来市场企稳、银行理财子公司投研能力的进一步增强，预计银行理财为客户创收仍将持续上升。</span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\"font-family:宋体\">财联社</span>4月24日讯，<span style=\"font-family:宋体\">理财登记中心今日发布数据显示，今年一季度理财市场规模保持平稳，累计为投资者创造收益</span>2058亿元，同比下降1.81%。其中，理财公司兑付投资者收益1004亿元，同比增长1.81倍，银行机构兑付投资者收益1054亿元。</p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\">有业内人士认为，银行理财净值波动幅度有限，涉及产品数量占比极低，总体情况可控。随着未来市场企稳、银行理财子公司投研能力的进一步增强，预计银行理财为客户创收仍将持续上升。</span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\"><span style=\"font-family:宋体\">银行业理财登记托管中心党委副书记、总裁成家军今日在中国财富管理</span>50人论坛2022资管峰会上指出，据统计，回撤幅度大于5%的理财产品全市场只有300多只，占回撤产品总数的2%，占理财市场存续产品总数不足1%，市场整体表现比较平稳。</span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\"><span style=\"font-family:宋体\">据财联社记者初步统计，理财子公司发行的产品收益率出现了回升。截至</span>4月24日止，银行理财子公司共发行了8680只银行理财产品，其中有1106只产品的净值低于“1”，破净率为12.74%，较月初的14.43%略有好转。</span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\"><span style=\"font-family:宋体\">一位银行理财人士对财联社记者表示，当前债券市场收益率有所好转，因此以固收资产为主的银行理财产品的收益情况也出现了好转。与此同时，银行理财子公司在此次产品大规模</span>“破净”之后，亦加大了对权益类资产的风险控制。</span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\"><span style=\"font-family:宋体\">银行理财净值化转型，是资管新规发展的重要方向。数据显示，截至</span>3月底，理财产品存续规模28.37万亿元，净值化比例94.15%。而随着资管新规过渡期的正式收官与理财公司的健康发展，理财公司市场份额占比稳步提高，占比达60.88%，较去年同期提高30.48个百分点。</span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\">“理财市场的独特作用正在日益显现。”成家军认为，对净值波动容忍度较低，是理财市场投资人的典型特点。要探索通过发行包括股权、股票在内的权益类投资产品，提升理财产品的长期收益水平。</span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\">他认为，理财公司实现高质量发展，需要围绕风险防控和业务拓展，强化公司治理与内部管理机制建设。在业务运行拓展、风险防控方面，要建立健全与母行的风险隔离机制。在系统运维、客户服务、渠道管理方面，要建立健全与母行的规范合作机制。目前监管部门正在抓紧研究制定加强理财公司内控机制建设的相关规定，目的就是要进一步提高内控管理水平，健全机制建设，完善内控措施，保证理财业务的合规开展。</span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\">光大理财总经理潘东表示，当前银行理财子公司应回答好如何打造体系化平台化的投研能力、如何打造客户导向的销售和服务能力、如何系统性的提升资管公司的产品创新和布局能力等三方面的问题，这是银行理财子公司核心的竞争能力。</span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\"><span style=\"font-family:宋体\">此外，数据显示，截至</span>3月底，持有理财产品的投资者数量（仅统计2018年10月1日之后发行的理财产品）达8688万个，较年初增长6.86%。其中，个人投资者8614万人，占比高达99.15%；机构投资者74万个，占比0.85%。</span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: right\"><span style=\"font-family:宋体\">（记者</span>&nbsp;<span style=\"font-family:宋体\">姜樊）</span></p><p><br/></p>');
INSERT INTO `news` VALUES ('15', '理财公司内部控制管理办法（征求意见稿）', '2022-05-06 07:29:32', '<p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\">为推动理财公司依法合规经营和持续稳健运行，按照诚实信用、勤勉尽责原则切实履行受托管理职责，中国银保监会制定《理财公司内部控制管理办法（征求意见稿）》（以下简称《办法》）。银保监会有关部门负责人就相关问题回答了记者提问。</span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\">一、制定《办法》的背景是什么？</span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\"><span style=\"font-family:宋体\">答：</span>2018年12月《商业银行理财子公司管理办法》（以下简称理财公司办法）发布实施以来，共29家理财公司获批筹建，其中25家获批开业。截至2022年3月末，银行及理财公司理财产品合计余额28.4万亿元。其中，理财公司产品余额17.3万亿元。理财公司作为具备独立法人资格的新型资管机构，有必要尽快构筑全面有效的内控管理制度。</span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\"><span style=\"font-family:宋体\">一是资管新规等法规均提出内部控制的原则性要求。制定《办法》是对《关于规范金融机构资产管理业务的指导意见》（以下简称资管新规）、《商业银行理财业务监督管理办法》（以下简称理财新规）、理财公司办法等监管制度的原则性要求的细化和补充，有利于推动理财公司建立健全统一规范的内控标准。二是充分发挥理财公司内控防线作用。理财公司处于</span>“洁净起步”的关键时期，亟需构建与自身业务规模、特点和风险状况相适应的内控合规管理体系，为依法合规和稳健运行提供坚实保障。三是持续强化风险隔离。理财公司还需进一步在人员、资金、投资管理、信息、系统等方面建好风险隔离墙，提高自身独立经营能力。</span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\">二、制定《办法》的原则和意义是什么？</span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\">答：制定《办法》主要遵循三项原则：一是坚持问题导向，针对理财公司内控管理问题提出具体要求，提高规则的可执行性和可操作性。二是坚持行业对标，充分借鉴国内外金融业实践，推动同类业务规则一致。三是坚持风险底线，强化理财公司审慎经营理念，切实增强防范化解各类风险隐患的能力，保障稳健可持续发展。</span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\">《办法》是理财公司更好履行受托管理职责的重要制度保障，是理财业务高质量发展的内在要求，是实现有效监管的重要途径和有力抓手。在理财公司转型发展的新时期、新阶段发布实施《办法》，有利于统一同类资管业务监管标准，增强理财公司法治观念和合规意识，建立健全内控合规管理体系，推动理财行业形成良好发展生态。</span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\">三、《办法》的总体结构是什么？</span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\"><span style=\"font-family:宋体\">答：《办法》共六章</span>41条。第一章“总则”，明确立法依据、适用范围、定义、总体要求、监督管理等。第二章“内部控制职责”，规定理财公司内部控制组织架构，董监高、内控职能部门、内审部门等职责分工和定位等。第三章“内部控制活动”，细化理财公司在内控制度、产品设计和存续期管理、投资和交易制度流程、重要岗位关键人员管理、关联交易管理及与母行风险隔离等方面的监管要求。第四章“内部控制保障”，明确理财公司在信息系统管理、网络和信息安全管理、会计制度、内控和绩效考评、内控培训等方面应遵循的监管要求。第五章“内部控制监督”，明确理财公司内部审计和年度报告义务，监管部门持续监管责任等。第六章为“附则”。<a style=\";padding: 0px;cursor: pointer\"></a></span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\"><span style=\"font-family:宋体\">四、</span><a style=\";padding: 0px;cursor: pointer\"></a><span style=\"font-family:宋体\">《办法》对强化理财公司受托管理职责有哪些规定？</span></span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\">答：《办法》要求理财公司对各项业务活动和管理活动制定全面、系统、规范的内控制度体系，并至少每年进行一次全面评估。一是强化产品设计和存续期管理。要求理财产品发行前严格履行内部审批程序，持续跟踪每只产品风险监测指标变化情况，开展压力测试并及时采取有效措施。二是完善投资和交易制度流程。要求按照最小权限原则合理划分投资权限，建立投资授权持续评价和反馈机制。明确不同类型资产投资审核标准、决策流程、风控措施和投后管理要求。健全交易全流程管理制度，有效识别和控制相关风险。三是加强重要岗位关键人员管理。实施岗位责任制度和不相容岗位分离措施，强调开展投资交易应当使用统一配置的通讯工具并进行监测留痕。四是强化与母行风险隔离。要求理财公司对每笔投资进行独立审批和投资决策。全面准确识别关联方，建立健全关联交易内部评估和审批机制。</span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\">五、《办法》在同类业务规则一致性上主要有哪些规定？</span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\">答：《办法》充分对标国内外资管行业良好监管实践，结合理财公司特点细化了相关要求。一是设立首席合规官。负责监督检查内部控制建设和执行情况，并可以直接向董事会和监管部门报告，更好发挥其监督制衡作用。二是建立人员信息登记和公示制度。实行证券投资全员登记制度，明确投资人员、交易人员名单，及时公示投资人员任职信息。三是加强交易监测、预警和反馈。实行公平交易、异常交易制度，前瞻性识别和防范风险。实行集中交易和交易记录制度，确保投资和交易相分离，以及交易信息可回溯、可检查。四是强化信息隔离。建立信息隔离和投资者信息使用管理制度，严禁违规查询和泄露信息。</span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\">六、《办法》对加强理财公司内外部监督有哪些规定？</span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\">答：《办法》坚持内部监督和外部监管相结合，共同推动理财公司完善内部控制长效机制。一是要求理财公司内控职能部门至少每年组织内控考评，考评结果纳入绩效考核指标体系。二是要求理财公司内审部门至少每年开展内控审计评估，发挥监督制衡作用。三是监管部门加强持续监管，逐步建立理财公司评价体系，提升监管有效性。</span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\">七、《办法》与现行有关制度规则的关系？</span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\">答：《办法》与资管新规、理财新规、理财公司办法等制度规则，共同构成理财公司内控管理的基本遵循。上述制度规则已有规定的，如销售管理、内外部审计等内容，《办法》与之充分衔接。对于目前仍通过内设部门开展理财业务的银行，其内控管理主要遵循《商业银行内部控制指引》；该指引未予明确的，参照《办法》执行。</span></p><p><br/></p>');
INSERT INTO `news` VALUES ('16', '人民日报：丰富养老金融产品供给', '2022-05-06 07:30:36', '<p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\"><span style=\"font-family:宋体\">今年</span>37岁的李娟在一家医药企业上班。最近，北京市成为养老理财产品试点城市，李娟马上去试点银行光大银行北京分行营业部购买了理财产品。“养老理财不是老年理财，不能等老了才开始谋划，还是要未雨绸缪，在收入高峰期多积累、多投资，做好资产管理。”李娟说，养老理财产品周期相对较长，收益也会稳定一些，特别是产品按政策实行专项费率优惠，感觉很安心。</span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\"><span style=\"font-family:宋体\">为了满足百姓多样化养老需求，</span>2021年9月，银保监会决定开展养老理财产品试点，工银理财在武汉和成都、建信理财和招银理财在深圳、光大理财在青岛开始试点发售理财产品。今年3月1日起，养老理财产品试点范围由“四地四机构”扩展为“十地十机构”。</span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\"><span style=\"font-family:宋体\">自第一批试点开始，机构积极开发产品，投资者购买踊跃。银行业理财登记托管中心数据显示，截至</span>2022年一季度末，4家试点机构共发售16只养老理财产品，超过16.5万投资者累计认购约420亿元，募集金额远超预期，首批产品中有多只产品多次上调计划募集规模。</span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\"><span style=\"font-family:宋体\">从已经发售的产品来看，试点期养老理财产品期限都相对较长，封闭式产品期限和每月定期开放式产品最短持有期限均为</span>5年。“这是为了引导投资者合理规划养老理财投资计划，使其树立长期投资、合理回报的投资理念。”银行业理财登记托管中心有关负责人表示，养老理财产品相对稳健，主要投向中低风险的固定收益类资产，监管部门要求发售机构通过多种方式健全风险管理机制。投资者能在中国理财网及时查询产品净值波动情况、风险状况和收益情况。试点期养老理财产品起购金额低至1元，认购费、销售服务费、管理费等总费率低于其它理财产品。</span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\"><span style=\"font-family:宋体\">哪些人购买了养老理财产品？银行业理财登记托管中心数据显示，试点期间，</span>50至60岁之间的投资者占比最高，达28%；40至50岁投资人占比达27%；30至40岁的投资者占比近20%。从持有金额看，七成以上的投资者持有金额小于30万元。</span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\"><span style=\"font-family:宋体\">国家金融与发展实验室副主任曾刚说，随着我国老龄化程度加深，亟须丰富养老金融产品供给，完善养老保障体系。百姓迫切需要将一定的个人资产转化为长期限、有养老属性、相对安全的养老金融产品，增强自身养老保障能力。目前，银行业理财登记托管中心和金融机构正在按照监管要求共同建设个人养老金融账户，未来每个人都可以通过该账户管理自己的养老金融产品。</span></span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\"><span style=\"font-family:宋体\">据介绍，目前养老理财试点机构都采取</span>“线上+线下”多渠道开展销售，10个试点地区的投资者可持个人身份证到机构销售网点购买，或通过网上银行、手机银行等途径购买养老理财产品。按规定，单一个人投资者购买的全部养老理财产品合计金额不超过300万元人民币。银行业理财登记托管中心已基于银行业理财登记信息系统和中央数据交换平台助力试点机构开展额度管理。</span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\"><span style=\"font-family:宋体\">光大理财相关负责人提醒投资者，养老规划要越早越好，要树立长期投资理念，理性、耐心地看待产品净值的短期波动，更加审慎地评估自身风险偏好和风险承受能力，结合养老理财产品的业绩比较基准、风险等级、分红赎回机制等，选择适合自己的产品。</span></span></p><p><br/></p>');
INSERT INTO `news` VALUES ('17', '中国银行业理财市场年度报告（2021年）', '2022-05-06 07:32:05', '<p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\">为全面反映2021年中国银行业理财市场情况，银行业理财登记托管中心组织编写了《中国银行业理财市场年度报告（2021年）》，回顾了资管新规发布以来我国银行业理财市场的改革与发展，</span><span style=\";padding: 0px\">全面总结2021年我国银行业理财市场情况，并对2022年银行业理财市场发展进行展望。</span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\">2021<span style=\"font-family:仿宋_GB2312\">年是我国“十四五”规划的开局之年，也是资管新规过渡期收官之年。在党中央的坚强领导、监管部门的政策引领以及市场机构的共同努力下，银行理财行业在总体平稳增长的基础上</span></span><span style=\";padding: 0px\"><span style=\"font-family:仿宋_GB2312\">，</span></span><span style=\";padding: 0px\">实现了回归本源、结构优化、提质增效的良好改革效果</span><span style=\";padding: 0px\"><span style=\"font-family:仿宋_GB2312\">。截至</span>2021<span style=\"font-family:仿宋_GB2312\">年底，</span></span><span style=\";padding: 0px\">银行理财市场</span><span style=\";padding: 0px\"><span style=\"font-family:仿宋_GB2312\">规模达到</span>29<span style=\"font-family:仿宋_GB2312\">万亿元，同比增长</span><span style=\"font-family:Times New Roman\">12.14%</span></span><span style=\";padding: 0px\"><span style=\"font-family:仿宋_GB2312\">；全年累计新发理财产品</span>4.</span><span style=\";padding: 0px\">76</span><span style=\";padding: 0px\">万只，募集资金</span><span style=\";padding: 0px\">122.19</span><span style=\";padding: 0px\">万亿元</span><span style=\";padding: 0px\">，</span><span style=\";padding: 0px\"><span style=\"font-family:仿宋_GB2312\">为投资者创造收益</span></span><span style=\";padding: 0px\"><span style=\"font-family:仿宋_GB2312\">近</span>1<span style=\"font-family:仿宋_GB2312\">万</span></span><span style=\";padding: 0px\"><span style=\"font-family:仿宋_GB2312\">亿元。</span></span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\">《年报》总结</span><span style=\";padding: 0px\">2021<span style=\"font-family:仿宋_GB2312\">年</span></span><span style=\";padding: 0px\">我</span><span style=\";padding: 0px\"><span style=\"font-family:仿宋_GB2312\">国银行业理财市场具有如下特点：</span></span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px;font-weight: bold\"><span style=\";padding: 0px\">一、</span><span style=\";padding: 0px\">监管工作效能显著提升，行业制度体系日臻完善</span></span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\">2018<span style=\"font-family:仿宋_GB2312\">年正式出台的资管新规拉开了资管领域改革的序幕</span></span><span style=\";padding: 0px\">，</span><span style=\";padding: 0px\"><span style=\"font-family:仿宋_GB2312\">监管部门持续推动同类资管产品统一标准</span></span><span style=\";padding: 0px\">，</span><span style=\";padding: 0px\"><span style=\"font-family:仿宋_GB2312\">建立健全产品发行</span></span><span style=\";padding: 0px\">、</span><span style=\";padding: 0px\"><span style=\"font-family:仿宋_GB2312\">销售管理</span></span><span style=\";padding: 0px\">、投资运作、风险控制等方面的制度规则</span><span style=\";padding: 0px\">，</span><span style=\";padding: 0px\"><span style=\"font-family:仿宋_GB2312\">有效保护投资者合法权益。</span>2</span><span style=\";padding: 0px\">021<span style=\"font-family:仿宋_GB2312\">年</span></span><span style=\";padding: 0px\">，监管部门</span><span style=\";padding: 0px\">先后发布《理财公司理财产品销售管理暂行办法》《关于规范现金管理类理财产品管理有关事项的通知》《理财公司理财产品流动性风险管理办法》等制度</span><span style=\";padding: 0px\">，持续</span><span style=\";padding: 0px\">加强理财业务监管体系建设</span><span style=\";padding: 0px\"><span style=\"font-family:仿宋_GB2312\">。同时稳妥开展</span>“养老理财试点”“跨境理财通”工作，丰富养老金融产品供给，拓宽居民个人跨境投资渠道。</span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px;font-weight: bold\"><span style=\";padding: 0px\">二、</span><span style=\";padding: 0px\">银行理财业务回归本源，存量整改任务基本完成</span></span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\">在资管新规确立的主动化、净值化的监管导向下，</span><span style=\";padding: 0px\">银行理财业务过渡期整改任务基本完成，整体符合预期。截至2</span><span style=\";padding: 0px\">021年底</span><span style=\";padding: 0px\">，</span><span style=\";padding: 0px\">保本理财产品规模已</span><span style=\";padding: 0px\">由</span><span style=\";padding: 0px\">资管新规发布时的</span><span style=\";padding: 0px\">4万亿元压降至零；净值型产品存续余额</span><span style=\";padding: 0px\">26.96</span><span style=\";padding: 0px\">万亿元，占比</span><span style=\";padding: 0px\">92.97</span><span style=\";padding: 0px\">%，较资管新规发布前增加2</span><span style=\";padding: 0px\">3.89</span><span style=\";padding: 0px\">万亿元；同业理财降至5</span><span style=\";padding: 0px\">41亿元</span><span style=\";padding: 0px\">，</span><span style=\";padding: 0px\">较资管新规发布前下降</span><span style=\";padding: 0px\">9</span><span style=\";padding: 0px\">7.52</span><span style=\";padding: 0px\">%；</span><span style=\";padding: 0px\">绝大部分银行如期完成理财存量整改</span><span style=\";padding: 0px\">计划，</span><span style=\";padding: 0px\">为银行理财业务健康发展奠定坚实基础</span><span style=\";padding: 0px\">。</span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px;font-weight: bold\">三、子公司制改革稳步推进，对外开放迈出崭新步伐</span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\">2</span><span style=\";padding: 0px\">018<span style=\"font-family:仿宋_GB2312\">年</span></span><span style=\";padding: 0px\">1</span><span style=\";padding: 0px\">2<span style=\"font-family:仿宋_GB2312\">月至今</span></span><span style=\";padding: 0px\">，</span><span style=\";padding: 0px\"><span style=\"font-family:仿宋_GB2312\">监管部门</span></span><span style=\";padding: 0px\"><span style=\"font-family:仿宋_GB2312\">坚持</span>“</span><span style=\";padding: 0px\"><span style=\"font-family:仿宋_GB2312\">成熟一家</span></span><span style=\";padding: 0px\">，</span><span style=\";padding: 0px\"><span style=\"font-family:仿宋_GB2312\">批准一家</span></span><span style=\";padding: 0px\">”</span><span style=\";padding: 0px\"><span style=\"font-family:仿宋_GB2312\">的原则</span></span><span style=\";padding: 0px\">，</span><span style=\";padding: 0px\"><span style=\"font-family:仿宋_GB2312\">已批准</span></span><span style=\";padding: 0px\">2</span><span style=\";padding: 0px\">9<span style=\"font-family:仿宋_GB2312\">家理财公司筹建</span></span><span style=\";padding: 0px\">，</span><span style=\";padding: 0px\"><span style=\"font-family:仿宋_GB2312\">其中</span></span><span style=\";padding: 0px\">2</span><span style=\";padding: 0px\">4<span style=\"font-family:仿宋_GB2312\">家获批开业</span></span><span style=\";padding: 0px\"><span style=\"font-family:仿宋_GB2312\">。金融业对外开放持续推进，截至目前已有</span>4<span style=\"font-family:仿宋_GB2312\">家外方控股的合资理财公司获批筹建，其中</span></span><span style=\";padding: 0px\">3</span><span style=\";padding: 0px\"><span style=\"font-family:仿宋_GB2312\">家已获批开业，广阔的市场空间正吸引越来越多的外资金融机构进入我国理财市场。截至</span>2</span><span style=\";padding: 0px\">021<span style=\"font-family:仿宋_GB2312\">年底</span></span><span style=\";padding: 0px\"><span style=\"font-family:仿宋_GB2312\">，</span>“</span><span style=\";padding: 0px\"><span style=\"font-family:仿宋_GB2312\">洁净起步</span></span><span style=\";padding: 0px\">”</span><span style=\";padding: 0px\"><span style=\"font-family:仿宋_GB2312\">的理财公司产品存续规模占全市场的比例近六成</span></span><span style=\";padding: 0px\">，</span><span style=\";padding: 0px\"><span style=\"font-family:仿宋_GB2312\">已发展成为理财市场</span></span><span style=\";padding: 0px\">重要的</span><span style=\";padding: 0px\"><span style=\"font-family:仿宋_GB2312\">机构类型</span></span><span style=\";padding: 0px\">。</span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px;font-weight: bold\">四、理财投资人数迅速增长，投资理财收益保持稳健</span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\">在资管行业打破刚兑的背景下，银行理财以其长期稳健的资金供给渠道、专业优质的资产管理能力、丰富多元的产品设计创新等优势，实现较为平稳的产品收益，推动银行理财投资者数量再创新高。截至2021年底，持有理财产品的投资者数量（注：</span><span style=\";padding: 0px\">仅</span><span style=\";padding: 0px\">统计</span><span style=\";padding: 0px\">2018</span><span style=\";padding: 0px\">年</span><span style=\";padding: 0px\">10</span><span style=\";padding: 0px\">月</span><span style=\";padding: 0px\">1</span><span style=\";padding: 0px\">日之后发行的理财产品，其中每月数据均为月末时点的数据。投资者数量为各类别下的投资者跨机构归集并剔重之后的数量</span><span style=\";padding: 0px\">）</span><span style=\";padding: 0px\">达8</span><span style=\";padding: 0px\">130</span><span style=\";padding: 0px\">万个，创历史新高，同比增长95.31%，</span><span style=\";padding: 0px\">其中</span><span style=\";padding: 0px\">个人投资者仍占绝对主力，数量占比高达</span><span style=\";padding: 0px\">99.23%。</span><span style=\";padding: 0px\">资管新规发布以来，理财产品已累计为投资者创造收益3.61万亿元，其中</span><span style=\";padding: 0px\">2</span><span style=\";padding: 0px\">021年创造收益近1万亿元。</span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px;font-weight: bold\">五、服务实体能力稳步提升，社会责任投资持续扩大</span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\">资管新规发布以来，银行理财行业持续提升资金配置能力、拓展投资渠道、缩短投资链条，更加精准高效支持实体经济，大力践行社会责任。截至2021年底，银行理财通过投资债券、非标准化债权、未上市股权等资产，支持实体经济资金规模约25万亿元，相当于同期社会融资规模存量的8%。</span><span style=\";padding: 0px\">2021年</span><span style=\";padding: 0px\">理财资金投向绿色债券规模超2200亿元，投向疫情防控、乡村振兴、扶贫等专项债券规模超1200亿元，为中小微企业发展提供资金支持超3万亿元，有效促进共同富裕目标实现。</span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px;font-weight: bold\">六、五大平台建设初见成效，高质高效服务理财市场</span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\">资管新规发布后，为助力理财市场的转型发展，银行业理财登记托管中心多措并举，着力建设完善五大服务平台，为银行理财市场提供高质高效的专业服务。</span><strong style=\";padding: 0px\">一是</strong><span style=\";padding: 0px\">银行理财信息集中登记平台，实现理财产品统一集中登记，满足监管部门全面、实时、动态、穿透管理要求；</span><strong style=\";padding: 0px\">二是</strong><span style=\";padding: 0px\">理财产品查询和信息披露平台，切实保护投资者合法权益；</span><strong style=\";padding: 0px\">三是</strong><span style=\";padding: 0px\">理财产品中央数据交换平台，共建理财行业统一数据交换标准；</span><strong style=\";padding: 0px\">四是</strong><span style=\";padding: 0px\">理财公司行业交流研讨平台，设立中国理财网</span><span style=\";padding: 0px\">·</span><span style=\";padding: 0px\">理财</span><span style=\";padding: 0px\">20</span><sup style=\";padding: 0px\"><span style=\";padding: 0px\">+</span></sup><span style=\";padding: 0px\">论坛，充分发挥理财智库作用；</span><strong style=\";padding: 0px\">五是</strong><span style=\";padding: 0px\">理财产品第三方托管平台，满足监管部门关于理财产品实质性独立托管要求。</span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\">2022<span style=\"font-family:仿宋_GB2312\">年，我国将继续科学统筹推进疫情防控和经济社会发展，坚持经济发展工作稳字当头、稳中求进，做好跨周期和逆周期调节有机结合，保持经济长期向好的总态势。在加快构建国内国际“双循环”新发展格局、深化金融供给侧结构性改革的大背景下，银行理财行业将立足新发展阶段，专注主业、信守托付、精益求精，以高质量发展朝着共同富裕目标稳步迈进。</span></span></p><p style=\"margin-top: 0px;margin-bottom: 0px;padding: 0px;border: 0px;font-family: 宋体, Arial, sans-serif;text-indent: 2em;color: rgb(50, 50, 50);font-size: 14px;white-space: normal;text-align: justify\"><span style=\";padding: 0px\">展望</span><span style=\";padding: 0px\">2</span><span style=\";padding: 0px\">022年</span><span style=\";padding: 0px\">，</span><span style=\";padding: 0px\">银行业理财登记托管中心将着力围绕以下三方面开展工作</span><span style=\";padding: 0px\">，</span><span style=\";padding: 0px\">为银行理财市场提供更加优质的服务</span><span style=\";padding: 0px\">。</span><strong style=\";padding: 0px\">一是</strong><span style=\";padding: 0px\">加大理财产品中央数据交换平台推广使用，推动更多理财公司和代销银行接入交换平台，同时做好系统运维管理，加快系统二期开发，不断完善系统功能。</span><strong style=\";padding: 0px\">二是</strong><span style=\";padding: 0px\">在现有基础上，养老理财产品试点已进一步扩大，理财登记中心将严格落实监管部门工作要求，扎实推动养老理财试点期工作。</span><strong style=\";padding: 0px\">三是</strong><span style=\";padding: 0px\">进一步做好理财信息披露平台建设</span><span style=\";padding: 0px\">，稳步推进信息披露行业标准制定工作，推动建立全行业集中统一信息披露渠道，提高理财产品信息透明度，切实保护投资者合法权益。</span></p><p><br/></p>');

-- ----------------------------
-- Table structure for tax
-- ----------------------------
DROP TABLE IF EXISTS `tax`;
CREATE TABLE `tax` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(20) DEFAULT NULL,
  `name` varchar(256) DEFAULT NULL,
  `tax` double(20,0) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `comment` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tax
-- ----------------------------
INSERT INTO `tax` VALUES ('1', '4', '税', '500', '2022-02-02 00:00:00', '税');
INSERT INTO `tax` VALUES ('2', '4', '个人税', '200', '2022-03-02 00:00:00', '个人税');
INSERT INTO `tax` VALUES ('3', '4', '奖金', '230', '2022-04-02 00:00:00', '个人税');
INSERT INTO `tax` VALUES ('4', '4', '工资', '180', '2022-05-02 00:00:00', '个人税');
INSERT INTO `tax` VALUES ('5', '4', '工资', '250', '2022-05-02 08:00:00', '个人税');
INSERT INTO `tax` VALUES ('6', '4', '意外收入', '100', '2022-05-02 08:00:00', '个人税');

-- ----------------------------
-- Table structure for transfer
-- ----------------------------
DROP TABLE IF EXISTS `transfer`;
CREATE TABLE `transfer` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `in_id` int(20) DEFAULT NULL,
  `out_id` int(20) DEFAULT NULL,
  `account` double(20,0) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of transfer
-- ----------------------------
INSERT INTO `transfer` VALUES ('2', '3', '2', '500', '2022-04-07 23:13:27', '工资到支付宝');
INSERT INTO `transfer` VALUES ('3', '2', '1', '10', '2022-05-02 00:00:00', '现金到工商银行');
INSERT INTO `transfer` VALUES ('4', '1', '14', '100', '2022-05-11 00:00:00', '银行卡到现金');

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(20) DEFAULT NULL,
  `name` varchar(256) DEFAULT NULL,
  `hope` double(20,0) DEFAULT NULL COMMENT '心愿单 目标金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES ('1', '4', '考试', '100');
INSERT INTO `type` VALUES ('2', '4', '打车', '200');
INSERT INTO `type` VALUES ('3', '4', '工资', '2000');
INSERT INTO `type` VALUES ('4', '4', '餐饮', '1000');
INSERT INTO `type` VALUES ('5', '4', '服饰', '500');
INSERT INTO `type` VALUES ('6', '4', '娱乐', '200');
INSERT INTO `type` VALUES ('7', '4', '晚餐', '100');
INSERT INTO `type` VALUES ('8', '23', '服饰', '100');

-- ----------------------------
-- Table structure for url
-- ----------------------------
DROP TABLE IF EXISTS `url`;
CREATE TABLE `url` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(256) DEFAULT NULL,
  `name` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of url
-- ----------------------------
INSERT INTO `url` VALUES ('1', 'index.html', '首页');
INSERT INTO `url` VALUES ('2', 'incomeBill.html', '个人账单');
INSERT INTO `url` VALUES ('3', 'incomePay.html', '个人支出');
INSERT INTO `url` VALUES ('4', 'incomeSave.html', '个人收入');
INSERT INTO `url` VALUES ('5', 'cardMana.html', '支付方式');
INSERT INTO `url` VALUES ('6', 'taxAdd.html', '个人税');
INSERT INTO `url` VALUES ('7', 'typeMana.html', '分类类型');
INSERT INTO `url` VALUES ('8', 'newsList.html', '新闻查看');
INSERT INTO `url` VALUES ('9', 'newsMana.html', '新闻管理');
INSERT INTO `url` VALUES ('10', 'url.html', '权限管理');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(256) DEFAULT NULL,
  `password` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('4', 'root', '$2a$10$2XqYPh4YwBAE.1kjvhAnUe7iES.7uQ7xb.1oEGQWn81QSgzAVBAyi');
INSERT INTO `user` VALUES ('5', 'admin', '$2a$10$gfHIUWSOE8WY5EzJ7U69ge51/TVn2KYIxGsBCXSMxL76RrI22qXjy');
INSERT INTO `user` VALUES ('6', 'xiaoming', '$2a$10$EDUl3qDN8/32Eu47eVp61.XrZZLnEt7/n7FxsDXFlshBt59JgyYOq');
INSERT INTO `user` VALUES ('11', '123', '$2a$10$Ksj0XqWTNSF.P6l1bsg6bOyUzsSsQqfytpPHeZHfEe/d.gwFHBW8O');
INSERT INTO `user` VALUES ('23', 'dqy', '$2a$10$C/c5jTbbvMiG51a7fXii4Ox34YdurKwPoUy9d2FE4pMIz/Vk2H4YW');
INSERT INTO `user` VALUES ('24', '张三', '$2a$10$LuTT/eYFIqzCH1XKwf/mBOpkDe/DSjuMWQQPzCsFDTFQhLchhi6bO');

-- ----------------------------
-- Table structure for user_url
-- ----------------------------
DROP TABLE IF EXISTS `user_url`;
CREATE TABLE `user_url` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(20) DEFAULT NULL,
  `url_id` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=169 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user_url
-- ----------------------------
INSERT INTO `user_url` VALUES ('13', '1', '2');
INSERT INTO `user_url` VALUES ('37', '2', '4');
INSERT INTO `user_url` VALUES ('38', '2', '3');
INSERT INTO `user_url` VALUES ('40', '5', '4');
INSERT INTO `user_url` VALUES ('44', '5', '2');
INSERT INTO `user_url` VALUES ('45', '5', '3');
INSERT INTO `user_url` VALUES ('46', '5', '5');
INSERT INTO `user_url` VALUES ('47', '5', '6');
INSERT INTO `user_url` VALUES ('48', '5', '7');
INSERT INTO `user_url` VALUES ('49', '5', '8');
INSERT INTO `user_url` VALUES ('57', '2', '2');
INSERT INTO `user_url` VALUES ('60', '2', '1');
INSERT INTO `user_url` VALUES ('62', '5', '1');
INSERT INTO `user_url` VALUES ('71', '6', '1');
INSERT INTO `user_url` VALUES ('72', '7', '1');
INSERT INTO `user_url` VALUES ('73', '2', '10');
INSERT INTO `user_url` VALUES ('77', '2', '11');
INSERT INTO `user_url` VALUES ('86', '4', '1');
INSERT INTO `user_url` VALUES ('87', '4', '2');
INSERT INTO `user_url` VALUES ('88', '4', '3');
INSERT INTO `user_url` VALUES ('89', '4', '4');
INSERT INTO `user_url` VALUES ('90', '4', '5');
INSERT INTO `user_url` VALUES ('91', '4', '6');
INSERT INTO `user_url` VALUES ('92', '4', '7');
INSERT INTO `user_url` VALUES ('93', '4', '8');
INSERT INTO `user_url` VALUES ('94', '4', '9');
INSERT INTO `user_url` VALUES ('95', '4', '10');
INSERT INTO `user_url` VALUES ('96', '4', '11');
INSERT INTO `user_url` VALUES ('97', '6', '2');
INSERT INTO `user_url` VALUES ('98', '6', '3');
INSERT INTO `user_url` VALUES ('99', '6', '4');
INSERT INTO `user_url` VALUES ('100', '6', '5');
INSERT INTO `user_url` VALUES ('101', '6', '6');
INSERT INTO `user_url` VALUES ('102', '6', '7');
INSERT INTO `user_url` VALUES ('103', '6', '8');
INSERT INTO `user_url` VALUES ('105', '11', '1');
INSERT INTO `user_url` VALUES ('106', '14', '1');
INSERT INTO `user_url` VALUES ('107', '15', '1');
INSERT INTO `user_url` VALUES ('108', '21', '1');
INSERT INTO `user_url` VALUES ('109', '22', '1');
INSERT INTO `user_url` VALUES ('110', '11', '2');
INSERT INTO `user_url` VALUES ('111', '14', '2');
INSERT INTO `user_url` VALUES ('112', '15', '2');
INSERT INTO `user_url` VALUES ('113', '21', '2');
INSERT INTO `user_url` VALUES ('114', '11', '3');
INSERT INTO `user_url` VALUES ('115', '14', '3');
INSERT INTO `user_url` VALUES ('116', '15', '3');
INSERT INTO `user_url` VALUES ('117', '21', '3');
INSERT INTO `user_url` VALUES ('118', '22', '2');
INSERT INTO `user_url` VALUES ('119', '22', '3');
INSERT INTO `user_url` VALUES ('120', '11', '4');
INSERT INTO `user_url` VALUES ('121', '14', '4');
INSERT INTO `user_url` VALUES ('122', '15', '4');
INSERT INTO `user_url` VALUES ('123', '21', '4');
INSERT INTO `user_url` VALUES ('124', '22', '4');
INSERT INTO `user_url` VALUES ('125', '11', '5');
INSERT INTO `user_url` VALUES ('126', '14', '5');
INSERT INTO `user_url` VALUES ('127', '15', '5');
INSERT INTO `user_url` VALUES ('128', '21', '5');
INSERT INTO `user_url` VALUES ('129', '22', '5');
INSERT INTO `user_url` VALUES ('130', '11', '6');
INSERT INTO `user_url` VALUES ('131', '14', '6');
INSERT INTO `user_url` VALUES ('132', '15', '6');
INSERT INTO `user_url` VALUES ('133', '21', '6');
INSERT INTO `user_url` VALUES ('134', '22', '6');
INSERT INTO `user_url` VALUES ('135', '11', '7');
INSERT INTO `user_url` VALUES ('136', '11', '8');
INSERT INTO `user_url` VALUES ('138', '14', '7');
INSERT INTO `user_url` VALUES ('139', '14', '8');
INSERT INTO `user_url` VALUES ('142', '15', '8');
INSERT INTO `user_url` VALUES ('143', '15', '7');
INSERT INTO `user_url` VALUES ('144', '21', '7');
INSERT INTO `user_url` VALUES ('145', '21', '8');
INSERT INTO `user_url` VALUES ('148', '22', '8');
INSERT INTO `user_url` VALUES ('149', '22', '7');
INSERT INTO `user_url` VALUES ('150', '23', '1');
INSERT INTO `user_url` VALUES ('151', '23', '2');
INSERT INTO `user_url` VALUES ('152', '23', '3');
INSERT INTO `user_url` VALUES ('153', '23', '4');
INSERT INTO `user_url` VALUES ('154', '23', '5');
INSERT INTO `user_url` VALUES ('155', '23', '6');
INSERT INTO `user_url` VALUES ('156', '23', '7');
INSERT INTO `user_url` VALUES ('157', '23', '8');
INSERT INTO `user_url` VALUES ('160', '24', '1');
INSERT INTO `user_url` VALUES ('161', '24', '2');
INSERT INTO `user_url` VALUES ('162', '24', '3');
INSERT INTO `user_url` VALUES ('163', '24', '4');
INSERT INTO `user_url` VALUES ('164', '24', '5');
INSERT INTO `user_url` VALUES ('165', '24', '6');
INSERT INTO `user_url` VALUES ('166', '24', '7');
INSERT INTO `user_url` VALUES ('167', '24', '8');
INSERT INTO `user_url` VALUES ('168', '5', '9');
