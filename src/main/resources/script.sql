DROP DATABASE IF EXISTS CrazyDog;
CREATE DATABASE CrazyDog;
USE CrazyDog;

#建立服务单位表
CREATE TABLE `unit` (
  `id`        INT           NOT NULL AUTO_INCREMENT,
  `unit_code` VARCHAR(20)  NOT NULL COMMENT '单位编码',
  `unit_name` VARCHAR(30)  NOT NULL COMMENT '单位名称',
  PRIMARY KEY (`id`),
  UNIQUE INDEX (`unit_code`)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

#建立单位附属的部门表
CREATE TABLE `department` (
  `id`        INT          NOT NULL AUTO_INCREMENT,
  `dept_name` VARCHAR(255) NOT NULL COMMENT '部门名称',
  `unit_id`   INT          NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`unit_id`) REFERENCES `unit` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

#建立简历表，记录投简历信息
CREATE TABLE `resume` (
  `id`                int                 NOT NULL auto_increment,
  `name`              varchar(20)         NOT NULL,
  `birthday`          datetime,
  `nation`            varchar(20)         NOT NULL COMMENT '民族',
  `gender`            enum('女','男')      default '男',
  `zzmm`              enum('党员','团员')   default '党员' COMMENT '政治面貌',
  `hyzk`              enum('未婚','已婚')   default '未婚' COMMENT '婚姻状况',
  `education`         enum('小学','初中','高中','专科','本科','硕士','博士') default '本科' COMMENT '最高学历',
  `work_time`         datetime            ,
  `jjsp`              enum('一般','中','高')COMMENT '计算机水平',
  `profession`        varchar(10)          COMMENT '专业',
  `zip_code`          int(6)               COMMENT '邮编',
  `home_town`         varchar(50)          COMMENT '籍贯',
  `foreign_lang`      varchar(50)          COMMENT '外语语种',
  `specialty`         varchar(30)          COMMENT '特长',
  `yysp`              varchar(20)         COMMENT '外语水平',
  `jndj`              int(1)               COMMENT '技能等级',
  `height`            double(6,0)          COMMENT '身高',
  `tel`               int(11)              NOT NULL COMMENT '手机号',
  `id_card`           varchar(20)          NOT NULL COMMENT '身份证号',
  `hukou`             enum('农村户口','城镇户口')  COMMENT '户口性质',
  `hukou_address`     varchar(50)          COMMENT '户口所在地',
  `home_phone`        int(11)              COMMENT '家庭电话',
  `address`           varchar(30)          COMMENT '通讯地址',
  `report_card`        enum('否','是')       COMMENT '是否具有报到证',
  `email`             varchar(20)          NOT NULL COMMENT '邮箱',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#建立人事信息表
CREATE TABLE `employee` (
  `id`        INT                NOT NULL AUTO_INCREMENT,
  `emp_code`  VARCHAR(255)       NOT NULL COMMENT '员工编码',
  `emp_name`  VARCHAR(255)       NOT NULL COMMENT '员工名',
  `gender`    ENUM('女', '男')   CHARACTER SET utf8 NOT NULL COMMENT '性别',
  `id_num`    VARCHAR(20)        NOT NULL COMMENT '身份证号',
  `tel`       INT(11)            NULL COMMENT '电话号码',
  `education` ENUM('博士', '硕士', '本科', '专科', '高中', '初中', '小学') CHARACTER SET utf8 NULL COMMENT '教育程度',
  `dep_id`    INT                NOT NULL COMMENT '部门id',
  `unit_id`   INT                NOT NULL COMMENT '单位id',
  `resume_id` INT                NOT NULL COMMENT '简历id',
  PRIMARY KEY (`id`),
  FOREIGN KEY (`dep_id`) REFERENCES `department` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`unit_id`) REFERENCES `unit` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`resume_id`) REFERENCES `resume` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  UNIQUE INDEX (`emp_code`)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

#录取信息表
CREATE TABLE `hire` (
  `id`            INT                NOT NULL,
  `resume_id`     INT                NOT NULL COMMENT '简历id',
  `STATE`         ENUM('通过', '三审', '二审', '一审', '简历审核') CHARACTER SET utf8 NOT NULL COMMENT '简历状态',
  `decline_cause` VARCHAR(255)       NULL COMMENT '取消录取原因',
  `COMMENT`       VARCHAR(255)       NULL COMMENT '备注',
  `operate_time`  DATETIME           NOT NULL COMMENT '操作时间',
  `OPERATOR`      VARCHAR(10)         NOT NULL COMMENT '操作员',
  PRIMARY KEY (`id`),
  FOREIGN KEY (`resume_id`) REFERENCES `resume` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

#职位信息表
CREATE TABLE `position` (
  `id`        INT            NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  `emp_code`    INT            NOT NULL,
  `join_date`  DATETIME      NOT NULL COMMENT '入职日期',
  `leave_date` DATETIME      COMMENT '离职日期',
  `leave_info` VARCHAR(20)   COMMENT '离职原因',
  `leave_comment`   VARCHAR(200)  COMMENT '备注',
  FOREIGN KEY (`id`) REFERENCES `employee` (`id`) ON DELETE NO ACTION  ON UPDATE NO ACTION
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

#记录合同相关信息的表
CREATE TABLE `contract` (
  `id`             INT      NOT NULL AUTO_INCREMENT,
  `emp_id`         INT      NOT NULL COMMENT '合同相关人员',
  `contract_start` DATETIME NOT NULL COMMENT '合同开始日期',
  `contract_end`   DATETIME NOT NULL COMMENT '合同终止日期',
  `length`         INT      NOT NULL DEFAULT 1 COMMENT '合同持续时间',
  PRIMARY KEY (`id`),
  FOREIGN KEY (`emp_id`) REFERENCES `employee` (`id`) ON DELETE NO ACTION  ON UPDATE NO ACTION
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

#记录合同更改信息
CREATE TABLE `contract_change` (
  `id`           INT          NOT NULL AUTO_INCREMENT,
  `contract_id`  INT          NULL COMMENT '合同id',
  `unit_id`      INT          NULL COMMENT '单位id',
  `dept_id`      INT          NULL COMMENT '部门id',
  `position`     VARCHAR(20) NOT NULL COMMENT '职位',
  `change_cause` VARCHAR(100) NOT NULL COMMENT '更改原因',
  `renew_time`   INT          NOT NULL COMMENT '续约时间',
  `comment`      VARCHAR(255) NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  FOREIGN KEY (`contract_id`) REFERENCES `contract` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  FOREIGN KEY (`unit_id`) REFERENCES `unit` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  FOREIGN KEY (`dept_id`) REFERENCES `department` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

#简历教育信息
CREATE TABLE `resume_edu` (
  `id`         INT          NOT NULL PRIMARY KEY ,
  `resume_id`  INT          NOT NULL,
  `start_time` DATETIME     NOT NULL,
  `end_time`   DATETIME     NOT NULL,
  `school`     VARCHAR(20)  NOT NULL COMMENT '毕业学校',
  `discipline` VARCHAR(255) NOT NULL COMMENT '专业学科',
  FOREIGN KEY (`resume_id`) REFERENCES `resume` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

#简历家庭情况信息
CREATE TABLE `resume_family` (
  `id`           INT         NOT NULL PRIMARY KEY ,
  `resume_id`  INT          NOT NULL,
  `name`         VARCHAR(10) NOT NULL,
  `relationship` VARCHAR(10) NOT NULL,
  `department`   VARCHAR(30) NOT NULL COMMENT '就业单位',
  FOREIGN KEY (`resume_id`) REFERENCES `resume` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

#简历就业经历
CREATE TABLE `resume_jobs` (
  `id`          INT          NOT NULL PRIMARY KEY ,
  `resume_id`   INT          NOT NULL,
  `start_time`  DATETIME     NOT NULL,
  `end_time`    DATETIME     NOT NULL,
  `departmennt` VARCHAR(255) NOT NULL COMMENT '部门',
  `Post`        VARCHAR(255) NOT NULL COMMENT '职位',
  FOREIGN KEY (`resume_id`) REFERENCES `resume` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

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

INSERT INTO `resume` VALUES (1, '张三', '1995-6-24 00:00:00', '汉', '男', '党员', '未婚', '本科', '2015-8-24 00:00:00', '高', '软件开发', 330000, '北京', '英语', '打球', '中级', 2, 178, 1387743345, '34785634573485834598', '城镇户口', '北京', 834753984, '北京沙河', '是', '3475834893@qq.com');
INSERT INTO `resume` VALUES (2, '李四', '1998-5-12 00:00:00', '汉', '男', '团员', '未婚', '博士', '2014-6-24 09:55:44', '高', '软件测试', 330000, '江西', '英语', '唱歌', '高级', 5, 175, 837538450, '23764358656973426584', '城镇户口', '南昌', 347568345, '江西南昌', '是', '43543896@qq.com');
INSERT INTO `resume` VALUES (3, '张思', '1996-4-24 00:00:00', '汉', '女', '党员', '未婚', '本科', '2014-9-24 10:00:17', '中', '软件开发', 330045, '上海', '英语', '跑步', '中级', 3, 165, 345634958, '476894568798456', '农村户口', '上海', 349645748, '上海虹桥', '是', '3485739847@qq.com');
INSERT INTO `resume` VALUES (4, '王鑫', '1994-5-25 00:00:00', '汉', '男', '党员', '未婚', '本科', '2015-8-11 10:04:18', '一般', '电子商务', 330258, '天津', '法语', '运动', '中级', 4, 167, 943867894, '4378657648957487947X', '城镇户口', '天津', 346856469, '天津', '是', '4876458987@qq.com');
INSERT INTO `resume` VALUES (5, '皇朝', '1992-11-23 00:00:00', '汉', '男', '党员', '已婚', '硕士', '2012-7-1 10:07:31', '高', '软件开发', 330036, '江西', '日语', '下棋', '高级', 5, 172, 843673846, '64856450847409784957', '农村户口', '南昌', 607486745, '南昌昌北区', '是', '439658675487@qq.com');
INSERT INTO `resume` VALUES (6, '傻逼', '1992-11-23 00:00:00', '汉', '男', '党员', '已婚', '硕士', '2012-7-1 10:07:31', '高', '软件开发', 330036, '江西', '英语', '打架', '高级', 5, 174, 34867584, '64856450847409784957', '城镇户口', '南昌', 607485645, '南昌经开区', '是', '4333458675487@qq.com');
INSERT INTO `resume` VALUES (7, '李飞', '1994-8-24 09:41:56', '汉族', '男', '党员', '未婚', '小学', '2015-8-24 06:38:11', '中', '计算机专业', 342300, '北京市，昌平区', '法语', '节约水', '中级', 1, 180, 1527782314, '360123121234563789', '城镇户口', '江西省赣州市章贡区', 83232423, '北京市昌平区沙河镇', '是', '21321412@sina.com');
INSERT INTO `resume` VALUES (8, '张三丰', '1995-8-24 09:47:13', '哈萨克族', '男', '党员', '未婚', '本科', '2012-6-24 09:48:37', '高', '软件开发', 338900, '天津市，河西区', '俄语', 'java开发', '高级', 2, 176, 1323456324, '324563789234567234', '城镇户口', '江西省南昌市青山湖区', 43452345, '天津市河西区', '是', 'qwe1123@qq.com');
INSERT INTO `resume` VALUES (9, '葛三炮', '1985-8-5 09:55:34', '苗族', '男', '党员', '未婚', '博士', '2009-5-1 09:56:23', '高', '计算机专业', 321343, '深圳市，宝安区', '英语，法语，俄语，日语', '计算机科技研发', '高级', 1, 189, 1782314563, '38792173823421987X', '城镇户口', '深圳市，宝安区', 44352345, '深圳市，宝安区', '是', '67adsad@169.comm');
INSERT INTO `resume` VALUES (10, '李二狗', '2003-8-19 10:00:33', '蒙古族', '男', '党员', '未婚', '本科', '2011-5-10 01:36:00', '中', '软件开发', 312314, '内蒙古自治区，包头市', '英语', '良好的计算机功底，钻研精神', '中级', 1, 169, 123123, '873923456787324567', '农村户口', '内蒙古自治区，包头市', 21113231, '内蒙古自治区，包头市', '是', 'qwe12@163.com');
INSERT INTO `resume` VALUES (11, '赵日天', '2007-8-12 10:06:41', '汉族', '男', '党员', '未婚', '硕士', '2014-7-27 10:07:04', '高', '软件开发', 132132, '江苏省南京市栖霞区', '英语', '善于交流', '高级', 3, 173, 312312, '382345267823452345', '城镇户口', '江苏省南京市栖霞区', 13123136, '江苏省南京市栖霞区', '是', 'qweqwrg@sina.com');

INSERT INTO `employee` VALUES (1, 'JT_01', '张三', '男', '34785634573485834598', 1387743345, '本科', 12, 3, 1);
INSERT INTO `employee` VALUES (2, 'CD_01', '李四', '男', '23764358656973426584', 837538450, '博士', 14, 3, 2);
INSERT INTO `employee` VALUES (3, 'SF_01', '张思', '女', '476894568798456', 345634958, '本科', 18, 4, 3);
INSERT INTO `employee` VALUES (4, 'SF_02', '王鑫', '男', '4378657648957487947X', 943867894, '本科', 18, 4, 4);
INSERT INTO `employee` VALUES (5, 'RJ_01', '皇朝', '男', '64856450847409784957', 843673846, '硕士', 21, 5, 5);
INSERT INTO `employee` VALUES (6, 'NX_01', '傻逼', '男', '64856450847409784957', 34867584, '硕士', 23, 5, 6);
INSERT INTO `employee` VALUES (7, 'WLJG_1', '李飞', '男', '34785634573485834598', 1387743345, '小学', 3, 1, 7);
INSERT INTO `employee` VALUES (8, 'WJ_1', '张三丰', '男', '324563789234567234', 1323456324, '博士', 2, 1, 8);
INSERT INTO `employee` VALUES (9, 'SPAN_3', '葛三炮', '男', '38792173823421987X', 1782314563, '本科', 4, 1, 9);
INSERT INTO `employee` VALUES (10, 'XC_1', '李二狗', '男', '873923456787324567', 123123, '本科', 6, 2, 10);
INSERT INTO `employee` VALUES (11, 'JLJCWYH_2', '赵日天', '男', '382345267823452345', 312312, '硕士', 8, 2, 11);