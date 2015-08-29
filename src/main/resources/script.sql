DROP DATABASE IF EXISTS crazydog;
CREATE DATABASE crazydog;
USE crazydog;

#建立服务单位表
CREATE TABLE `unit` (
  `id`        INT           NOT NULL AUTO_INCREMENT,
  `unit_code` VARCHAR(20)  NOT NULL COMMENT '单位编码',
  `unit_name` VARCHAR(30)  NOT NULL COMMENT '单位名称',
  PRIMARY KEY (`id`),
  UNIQUE INDEX (`unit_code`)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

#建立单位下的部门表
CREATE TABLE `department` (
  `id`        INT          NOT NULL AUTO_INCREMENT,
  `dept_name` VARCHAR(255) NOT NULL COMMENT '部门名称',
  `unit_id`   INT          NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`unit_id`) REFERENCES `unit` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

#系统用户表
CREATE TABLE `user` (
  `id`       INT                NOT NULL AUTO_INCREMENT,
  `name`     VARCHAR(255)       NOT NULL COMMENT '用户名',
  `password` VARCHAR(255)       NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
);

#建立简历表，记录投简历信息
CREATE TABLE `resume` (
  `id`                int                 NOT NULL auto_increment,
  `name`              varchar(20)         NOT NULL,
  `nation`            varchar(20)          NOT NULL COMMENT '民族',
  `gender`            enum('女','男')       NOT NULL default '男',
  `id_num`            VARCHAR(20)          NOT NULL COMMENT '身份证号',
  `tel`               BIGINT(11)              NOT NULL COMMENT '手机号',
  `email`             varchar(20)          NOT NULL COMMENT '邮箱',
  `birthday`          DATE,
  `zzmm`              enum('党员','团员','群众')  NOT NULL default '群众' COMMENT '政治面貌',
  `hyzk`              enum('未婚','已婚')   NOT NULL default '未婚' COMMENT '婚姻状况',
  `education`         enum('小学','初中','高中','专科','本科','硕士','博士') default '本科' COMMENT '最高学历',
  `work_time`         DATE            ,
  `jjsp`              enum('一般','中','高')COMMENT '计算机水平',
  `profession`        varchar(10)          COMMENT '专业',
  `zip_code`          int(6)               COMMENT '邮编',
  `home_town`         varchar(50)          COMMENT '籍贯',
  `foreign_lang`      varchar(50)          COMMENT '外语语种',
  `specialty`         varchar(30)          COMMENT '特长',
  `yysp`              varchar(20)          COMMENT '外语水平',
  `jndj`              int(1)               COMMENT '技能等级',
  `height`            double(6,0)          COMMENT '身高',
  `hukou`             enum('农村户口','城镇户口')  COMMENT '户口性质',
  `hukou_address`     varchar(50)          COMMENT '户口所在地',
  `home_phone`        int(11)              COMMENT '家庭电话',
  `address`           varchar(30)          COMMENT '通讯地址',
  `report_card`        enum('否','是')       COMMENT '是否具有报到证',

  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#简历教育信息
CREATE TABLE `resume_edu` (
  `id`         INT          NOT NULL PRIMARY KEY ,
  `resume_id`  INT          NOT NULL,
  `start_time` DATE         NOT NULL,
  `end_time`   DATE         NOT NULL,
  `school`     VARCHAR(20)  NOT NULL COMMENT '毕业学校',
  `discipline` VARCHAR(255) NOT NULL COMMENT '专业学科',
  FOREIGN KEY (`resume_id`) REFERENCES `resume` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

#简历家庭情况信息
CREATE TABLE `resume_family` (
  `id`           INT         NOT NULL PRIMARY KEY ,
  `resume_id`    INT         NOT NULL,
  `name`         VARCHAR(10) NOT NULL,
  `relationship` VARCHAR(10) NOT NULL,
  `department`   VARCHAR(30) NOT NULL COMMENT '就业单位',
  FOREIGN KEY (`resume_id`) REFERENCES `resume` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

#简历就业经历
CREATE TABLE `resume_jobs` (
  `id`          INT          NOT NULL PRIMARY KEY ,
  `resume_id`   INT          NOT NULL,
  `start_time`  DATE         NOT NULL,
  `end_time`    DATE         NOT NULL,
  `departmennt` VARCHAR(255) NOT NULL COMMENT '部门',
  `Post`        VARCHAR(255) NOT NULL COMMENT '职位',
  FOREIGN KEY (`resume_id`) REFERENCES `resume` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

#建立人事信息表
CREATE TABLE `employee` (
  `id`                INT                     NOT NULL AUTO_INCREMENT,
  `emp_code`          VARCHAR(255)            NOT NULL COMMENT '员工编码',
  `emp_name`          VARCHAR(255)            NOT NULL COMMENT '员工名',
  `gender`            ENUM('女', '男')        CHARACTER SET utf8 NOT NULL COMMENT '性别',
  `id_num`            VARCHAR(20)             NOT NULL COMMENT '身份证号',
  `nation`            VARCHAR(20)             NOT NULL COMMENT '民族',
  `tel`               BIGINT(11)                 NOT NULL COMMENT '手机号',
  `email`             varchar(20)             NOT NULL COMMENT '邮箱',
  `hyzk`              enum('未婚','已婚')      NOT NULL default '未婚' COMMENT '婚姻状况',
  `zzmm`              enum('党员','团员','群众')  NOT NULL default '群众' COMMENT '政治面貌',
  `phone`             INT(11)                 NULL COMMENT '电话号码',
  `education`         ENUM('博士', '硕士', '本科', '专科', '高中', '初中', '小学') CHARACTER SET utf8 NULL COMMENT '教育程度',
  `dep_id`            INT                     NOT NULL COMMENT '部门id',
  `unit_id`           INT                     NOT NULL COMMENT '单位id',
#   `contract_id`       INT                     NOT NULL COMMENT '合同id',
  `birthday`          DATE,
  `work_time`         DATE            ,
  `jjsp`              enum('一般','中','高')   COMMENT '计算机水平',
  `profession`        varchar(10)             COMMENT '专业',
  `zip_code`          int(6)                  COMMENT '邮编',
  `home_town`         varchar(50)             COMMENT '籍贯',
  `foreign_lang`      varchar(50)             COMMENT '外语语种',
  `specialty`         varchar(30)             COMMENT '特长',
  `yysp`              varchar(20)             COMMENT '外语水平',
  `jndj`              int(1)                  COMMENT '技能等级',
  `height`            double(6,0)             COMMENT '身高',
  `hukou`             enum('农村户口','城镇户口')  COMMENT '户口性质',
  `hukou_address`     varchar(50)             COMMENT '户口所在地',
  `home_phone`        int(11)                 COMMENT '家庭电话',
  `address`           varchar(30)             COMMENT '通讯地址',
  `report_card`       enum('否','是')          COMMENT '是否具有报到证',
  PRIMARY KEY (`id`),
  FOREIGN KEY (`dep_id`) REFERENCES `department` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`unit_id`) REFERENCES `unit` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
#   FOREIGN KEY (`contract_id`) REFERENCES `contract` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  UNIQUE INDEX (`emp_code`)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

#录取信息表
CREATE TABLE `hire_info` (
  `id`            INT                 NOT NULL,
  `resume_id`     INT                 NOT NULL COMMENT '简历id',
  `STATE`         ENUM('录取', '未录取', '等待审核') CHARACTER SET utf8 NOT NULL COMMENT '简历状态',
  `COMMENT`       VARCHAR(255)        NULL COMMENT '备注',
  `operate_time`  DATE                NOT NULL COMMENT '操作时间',
  `OPERATOR`      VARCHAR(10)         NOT NULL COMMENT '操作员',
  PRIMARY KEY (`id`),
  FOREIGN KEY (`resume_id`) REFERENCES `resume` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

#记录合同相关信息的表
CREATE TABLE `contract` (
  `id`             INT      NOT NULL AUTO_INCREMENT,
  `emp_id`         INT      NOT NULL COMMENT '合同相关人员',
  `contract_start` DATE NOT NULL COMMENT '合同开始日期',
  `contract_end`   DATE NOT NULL COMMENT '合同终止日期',
  PRIMARY KEY (`id`),
  FOREIGN KEY (`emp_id`) REFERENCES `employee` (`id`) ON DELETE NO ACTION  ON UPDATE NO ACTION
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

#离职信息记录表
CREATE TABLE `position_leave` (
  `id`              INT           NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  `emp_code`        INT           NOT NULL,
  `name`            VARCHAR(20)   COMMENT '离职员工',
  `leave_date`      DATE          COMMENT '离职日期',
  `leave_comment`   VARCHAR(200)  COMMENT '离职原因',
  FOREIGN KEY (`id`) REFERENCES `employee` (`id`) ON DELETE NO ACTION  ON UPDATE NO ACTION
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

#岗位更改信息记录表
CREATE TABLE `position_change` (
  `id`                  INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `emp_id`              INT          NOT NULL COMMENT '员工外键',
  `befor_unit_id`       INT          NOT NULL COMMENT '以前单位id',
  `befor_dept_id`       INT          NOT NULL COMMENT '以前部门id',
  `change_time`         DATE         NOT NULL COMMENT '调岗时间',
  `after_unit_id`       INT          NOT NULL COMMENT '之后单位id',
  `after_dept_id`       INT          NOT NULL COMMENT '之后部门id',
  `change_cause`        VARCHAR(100) NOT NULL COMMENT '更改原因',
  FOREIGN KEY (`emp_id`)        REFERENCES `employee` (`id`) ON DELETE NO ACTION  ON UPDATE NO ACTION,
  FOREIGN KEY (`befor_unit_id`) REFERENCES `unit` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  FOREIGN KEY (`befor_dept_id`) REFERENCES `department` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  FOREIGN KEY (`after_unit_id`) REFERENCES `unit` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  FOREIGN KEY (`after_dept_id`) REFERENCES `department` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

#添加管理员数据
INSERT INTO `user` (`id`, `name`, `password`) VALUES ('1', 'admin', '90b9aa7e25f80cf4f64e990b78a9fc5ebd6cecad');

#测试数据导入
INSERT INTO `unit` (`id`, `unit_code`, `unit_name`) VALUES (1, 'ZNH', '中南海');
INSERT INTO `unit` (`id`, `unit_code`, `unit_name`) VALUES (2, 'DZY', '党中央');
INSERT INTO `unit` (`id`, `unit_code`, `unit_name`) VALUES (3, 'NTM', '南天门');
INSERT INTO `unit` (`id`, `unit_code`, `unit_name`) VALUES (4, 'HHH', '红花会');
INSERT INTO `unit` (`id`, `unit_code`, `unit_name`) VALUES (5, 'ND', '农大');

INSERT INTO `department` (`id`, `dept_name`, `unit_id`) VALUES (1, '国防部', 1);
INSERT INTO `department` (`id`, `dept_name`, `unit_id`) VALUES (2, '外交部', 1);
INSERT INTO `department` (`id`, `dept_name`, `unit_id`) VALUES (3, '网络监管部', 1);
INSERT INTO `department` (`id`, `dept_name`, `unit_id`) VALUES (4, '食品安全部', 1);
INSERT INTO `department` (`id`, `dept_name`, `unit_id`) VALUES (5, '广电总局', 1);
INSERT INTO `department` (`id`, `dept_name`, `unit_id`) VALUES (6, '宣传部', 2);
INSERT INTO `department` (`id`, `dept_name`, `unit_id`) VALUES (7, '工商部', 2);
INSERT INTO `department` (`id`, `dept_name`, `unit_id`) VALUES (8, '纪律检查委员会', 2);
INSERT INTO `department` (`id`, `dept_name`, `unit_id`) VALUES (9, '政协', 2);
INSERT INTO `department` (`id`, `dept_name`, `unit_id`) VALUES (10, '中央政治常委会', 2);
INSERT INTO `department` (`id`, `dept_name`, `unit_id`) VALUES (11, '守门部', 3);
INSERT INTO `department` (`id`, `dept_name`, `unit_id`) VALUES (12, '监听部', 3);
INSERT INTO `department` (`id`, `dept_name`, `unit_id`) VALUES (13, '偷看部', 3);
INSERT INTO `department` (`id`, `dept_name`, `unit_id`) VALUES (14, '传达部', 3);
INSERT INTO `department` (`id`, `dept_name`, `unit_id`) VALUES (15, '场面部', 3);
INSERT INTO `department` (`id`, `dept_name`, `unit_id`) VALUES (16, '总舵', 4);
INSERT INTO `department` (`id`, `dept_name`, `unit_id`) VALUES (17, '北京分舵', 4);
INSERT INTO `department` (`id`, `dept_name`, `unit_id`) VALUES (18, '上海分舵', 4);
INSERT INTO `department` (`id`, `dept_name`, `unit_id`) VALUES (19, '南昌分舵', 4);
INSERT INTO `department` (`id`, `dept_name`, `unit_id`) VALUES (20, '美国分舵', 4);
INSERT INTO `department` (`id`, `dept_name`, `unit_id`) VALUES (21, '软件学院', 5);
INSERT INTO `department` (`id`, `dept_name`, `unit_id`) VALUES (22, '外语学院', 5);
INSERT INTO `department` (`id`, `dept_name`, `unit_id`) VALUES (23, '农学院', 5);
INSERT INTO `department` (`id`, `dept_name`, `unit_id`) VALUES (24, '艺术学院', 5);
INSERT INTO `department` (`id`, `dept_name`, `unit_id`) VALUES (25, '妓院', 5);

INSERT INTO `resume` VALUES ('1', '李二狗', '汉族', '男', '231723846247674664', '31232131231', '2312@sina.com', '1992-08-29', '团员', '未婚', '本科', '2012-08-29', '中', '软件开发', '232131', '北京市昌平区', '韩语', '善与人沟通，有缜密的思维', '高级', '2', '183', '城镇户口', '北京市昌平区', null, '北京市昌平区', '是');
INSERT INTO `resume` VALUES ('2', '张全蛋', '苗族', '男', '231722846237674264', '31432134231', 'wwer@sina.com', '1994-08-01', '党员', '未婚', '本科', '2012-08-21', '高', '软件开发', '236138', '深圳市宝安区', '英语', '理性思维强', '高级', '3', '183', '城镇户口', '北京市昌平区', null, '深圳市宝安区', '是');
INSERT INTO `resume` VALUES ('3', '王尼玛', '彝族', '男', '231345676237674264', '13432134231', 'w22@qq.com', '1991-08-01', '党员', '未婚', '本科', '2012-08-21', '高', '软件开发', '236211', '南昌市新建县', '英语', '善与人沟通', '高级', '2', '165', '城镇户口', '南昌市新建县', null, '南昌市新建县', '是');
INSERT INTO `resume` VALUES ('4', '张二愣', '汉族', '男', '231345672375474264', '13432567345', 'w22@169.com', '1995-07-23', '党员', '未婚', '本科', '2012-08-21', '中', '软件开发', '236561', '天津市东河区', '法语', '工作认真、一丝不苟', '高级', '2', '169', '城镇户口', '天津市东河区', null, '天津市东河区', '是');
INSERT INTO `resume` VALUES ('5', '诸葛流云', '傣族', '男', '231346672375489268', '13432566578', '1212dd@169.com', '1991-07-22', '党员', '未婚', '硕士', '2012-08-21', '高', '软件开发', '223344', '北京市怀柔区', '俄语、日语', '工作认真、态度严谨', '高级', '4', '177', '城镇户口', '北京市怀柔区', null, '北京市怀柔区', '是');
INSERT INTO `resume` VALUES ('6', '李飞', '汉族', '男', '231346672375423264', '13432587342', '121dd@163.com', '1989-03-18', '党员', '未婚', '专科', '2012-08-21', '高', '软件开发', '223342', '宜春市上高县', '俄语、日语', '工作认真、态度严谨', '高级', '4', '177', '城镇户口', '宜春市上高县', null, '宜春市上高县', '是');
INSERT INTO `resume` VALUES ('7', '爱迪生', '无', '男', '231346672323123456', '13432457823', 'sda@163.com', '1993-03-04', '党员', '未婚', '本科', '2012-08-21', '高', '软件开发', '223456', '北京市朝阳区', '俄语、日语', '工作认真、态度严谨', '高级', '4', '166', '城镇户口', '北京市朝阳区', null, '北京市朝阳区', '是');
INSERT INTO `resume` VALUES ('8', '灰太狼', '狼族', '男', '231346672325674563', '13432434523', '112asasd@163.com', '1993-03-04', '党员', '未婚', '本科', '2012-08-21', '高', '软件开发', '223456', '北京市大兴区', '俄语、日语', '工作认真、态度严谨', '高级', '4', '199', '城镇户口', '北京市大兴区', null, '北京市大兴区', '是');
INSERT INTO `resume` VALUES ('9', '刘翔', '汉族', '男', '231346672232131231', '1343231232', '112a@163.com', '1993-03-28', '党员', '未婚', '本科', '2012-08-21', '高', '软件开发', '223236', '内蒙古包头市', '英语', '工作认真、态度严谨', '高级', '4', '192', '城镇户口', '内蒙古包头市', null, '内蒙古包头市', '是');
INSERT INTO `resume` VALUES ('10', '阿三', '汉族', '男', '231346621323323212', '2123123212', 'qweyy@qq.com', '1993-03-16', '党员', '未婚', '本科', '2012-08-21', '高', '软件开发', '222132', '湖南省长沙市', '英语', '工作认真、态度严谨', '高级', '4', '175', '城镇户口', '湖南省长沙市', null, '湖南省长沙市', '是');

INSERT INTO `resume_edu` VALUES ('1', '1', '2012-01-28', '2016-06-01', '北京大学', '计算机科学');
INSERT INTO `resume_edu` VALUES ('2', '5', '2012-09-01', '2016-06-28', '清华大学', '软件开发');
INSERT INTO `resume_edu` VALUES ('3', '7', '2012-09-01', '2016-06-01', '哈尔滨工业大学', '计算机信息技术');
INSERT INTO `resume_edu` VALUES ('4', '8', '2012-09-01', '2016-06-01', '江西农业大学', '计算机网络');
INSERT INTO `resume_edu` VALUES ('5', '10', '2012-09-01', '2016-06-01', '南昌大学', '软件学院');

INSERT INTO `resume_family` VALUES ('1', '3', '张元丰', '父亲', '上海市动物保护协会');
INSERT INTO `resume_family` VALUES ('2', '4', '李飞翔', '舅舅', '南昌市新建县县政府');
INSERT INTO `resume_family` VALUES ('3', '6', '王二麻', '父亲', '江西省教育局');
INSERT INTO `resume_family` VALUES ('4', '8', '张翼飞', '父亲', '北京市朝阳区社保局');
INSERT INTO `resume_family` VALUES ('5', '9', '葛格', '母亲', '深圳市宝安区黑河工业区');

INSERT INTO `resume_jobs` VALUES ('1', '3', '2014-08-28', '2015-08-28', '软件开发部', '程序员');
INSERT INTO `resume_jobs` VALUES ('2', '6', '2013-06-28', '2014-06-01', '软件测试部', '测试员');
INSERT INTO `resume_jobs` VALUES ('3', '8', '2014-02-28', '2015-02-28', '软件开发部', '项目经理');
INSERT INTO `resume_jobs` VALUES ('4', '9', '2015-01-28', '2015-08-28', '软件开发部', '程序员');
INSERT INTO `resume_jobs` VALUES ('5', '10', '2014-10-28', '2015-05-28', '软件测试部', '测试员');

INSERT INTO `employee` VALUES ('1', '001', '李三狗', '男', '845734957394805709', '汉族', '12383247923', '37465943878@qq.com', '43646575', '本科', '3', '1', '1992-05-24', '党员', '未婚', '2012-08-29', '中', '软件开发', '330000', '江西', '英语', '善于撒谎', '3', '4', '178', '城镇户口', '江西南昌', '349754389', '江西省南昌', '是');
INSERT INTO `employee` VALUES ('2', '002', '草泥马', '男', '845734957345546566', '满族', '13435247657', '35794988656@sina.com', '14464565', '硕士', '5', '1', '1991-06-20', '党员', '已婚', '2013-08-09', '高', '软件开发', '330012', '北京', '汉语', '善于交流', '5', '2', '180', '城镇户口', '北京昌平', '349456563', '北京昌平', '是');
INSERT INTO `employee` VALUES ('3', '003', '傻逼', '女', '845734955645864968', '汉族', '12345983503', '32455943878@qq.com', '43646575', '本科', '6', '2', '1989-05-24', '党员', '已婚', '2014-08-03', '高', '软件测试', '330012', '北京', '英语', '善于解决bug', '4', '4', '172', '农村户口', '北京二环', '349754389', '北京', '是');
INSERT INTO `employee` VALUES ('4', '004', '傻狗', '男', '845734955645832748', '汉族', '18545690454', '32465874345@qq.com', '87453982', '高中', '8', '2', '1993-05-12', '群众', '未婚', '2015-01-03', '中', '软件开发', '330000', '南昌', '法语', '善于打架', '6', '2', '162', '城镇户口', '江西宜春', '238975385', '江西宜春', '否');
INSERT INTO `employee` VALUES ('5', '005', '李四', '男', '845734955643589345', '苗族', '12334893875', '93474303453@qq.com', '43475935', '本科', '13', '3', '1990-04-24', '团员', '已婚', '2013-09-08', '高', '金融管理', '330024', '上海', '日语', '善于制造bug', '5', '3', '175', '农村户口', '上海虹桥', '436720959', '上海', '是');
INSERT INTO `employee` VALUES ('6', '006', '张思', '女', '845734955645283476', '汉族', '18082352342', '34535344894@qq.com', '45345942', '博士', '15', '3', '1996-05-12', '党员', '未婚', '2012-06-02', '高', '软件开发', '330012', '北京', '英语', '喜欢BB', '3', '4', '173', '城镇户口', '北京', '345398635', '北京四环', '否');
INSERT INTO `employee` VALUES ('7', '007', '老王', '男', '845734954863498733', '汉族', '13453469736', '53463639663@qq.com', '34636894', '本科', '16', '4', '1992-02-20', '党员', '已婚', '2013-02-03', '中', 'Android开发', '330000', '江西', '汉语', '测试bug', '2', '6', '172', '农村户口', '江西九江', '349346543', '江西九江', '是');
INSERT INTO `employee` VALUES ('8', '008', '喜羊羊', '男', '845734934759354534', '羊族', '12364546435', '32455943878@qq.com', '43857395', '本科', '18', '4', '1994-05-20', '团员', '未婚', '2014-10-03', '高', 'PHP开发', '330000', '北京', '英语', '善于编程', '4', '5', '170', '城镇户口', '北京', '343538474', '北京', '是');
INSERT INTO `employee` VALUES ('9', '009', '鸣人', '男', '845745474746474968', '不详', '14647986486', '32455924253@qq.com', '32564365', '本科', '22', '5', '1988-06-22', '党员', '已婚', '2014-03-27', '高', '软件开发', '330000', '南昌', '英语', '制造螺旋丸', '6', '2', '169', '农村户口', '南昌', '349754665', '南昌', '是');
INSERT INTO `employee` VALUES ('10', '0010', '你猜', '男', '845745474746363463', '你猜', '143636345', '43634538589@qq.com', '35353232', '硕士', '23', '5', '1992-07-29', '群众', '未婚', '2012-08-23', '高', '软件开发', '330012', '北京', '英语', '你再猜', '2', '2', '120', '农村户口', '北京', '349456436', '山顶洞人', '是');

INSERT INTO `contract` VALUES ('1', '1', '2014-01-01', '2016-01-01');
INSERT INTO `contract` VALUES ('2', '2', '2015-08-11', '2017-08-11');
INSERT INTO `contract` VALUES ('3', '3', '2011-08-11', '2017-08-11');
INSERT INTO `contract` VALUES ('4', '4', '2013-08-11', '2015-08-11');
INSERT INTO `contract` VALUES ('5', '5', '2012-03-24', '2015-08-24');
INSERT INTO `contract` VALUES ('6', '6', '2015-08-28', '2019-08-28');
INSERT INTO `contract` VALUES ('7', '7', '2014-06-28', '2017-08-28');
INSERT INTO `contract` VALUES ('8', '8', '2013-08-28', '2017-08-28');
INSERT INTO `contract` VALUES ('9', '9', '2015-08-28', '2018-08-28');
INSERT INTO `contract` VALUES ('10', '10', '2014-01-01', '2016-01-28');

INSERT INTO `hire_info` VALUES ('1', '1', '录取', '专业知识扎实，', '2015-08-10', 'admin');
INSERT INTO `hire_info` VALUES ('2', '2', '录取', '诚实稳重', '2015-08-29', 'admin');
INSERT INTO `hire_info` VALUES ('3', '3', '等待审核', '还在考虑', '2015-08-29', 'admin');
INSERT INTO `hire_info` VALUES ('4', '4', '未录取', '专业技能还不是很专业，不够精', '2015-08-29', 'admin');
INSERT INTO `hire_info` VALUES ('5', '5', '等待审核', '还待考虑', '2015-08-29', 'admin');
INSERT INTO `hire_info` VALUES ('6', '6', '未录取', '长得丑长得矮', '2015-08-29', '黄某某');
INSERT INTO `hire_info` VALUES ('7', '7', '录取', '长得帅', '2015-08-29', 'admin');
INSERT INTO `hire_info` VALUES ('8', '8', '等待审核', '还在确定', '2015-08-29', 'admin');
INSERT INTO `hire_info` VALUES ('9', '9', '录取', '专业技术好', '2015-08-29', 'admin');
INSERT INTO `hire_info` VALUES ('10', '10', '录取', '善于沟通', '2015-08-29', 'admin');

INSERT INTO `position_change` VALUES ('1', '1', '1', '3', '2015-08-29', '2', '6', '不详');
INSERT INTO `position_change` VALUES ('2', '5', '3', '13', '2015-08-29', '2', '8', '领导一致决定');
INSERT INTO `position_change` VALUES ('3', '6', '3', '15', '2015-08-29', '4', '17', '略');

INSERT INTO `position_leave` VALUES ('2', '2', '草泥马', '2015-08-29', '工资低');
INSERT INTO `position_leave` VALUES ('4', '4', '傻狗', '2014-08-29', '不告诉你');
INSERT INTO `position_leave` VALUES ('7', '7', '老王', '2015-05-29', '你猜你猜你猜');
