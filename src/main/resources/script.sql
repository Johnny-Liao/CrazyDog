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
  `id_num`           varchar(20)          NOT NULL COMMENT '身份证号',
  `tel`               int(11)              NOT NULL COMMENT '手机号',
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
  `nation`            varchar(20)             NOT NULL COMMENT '民族',
  `tel`               int(11)                 NOT NULL COMMENT '手机号',
  `email`             varchar(20)             NOT NULL COMMENT '邮箱',
  `phone`             INT(11)                 NULL COMMENT '电话号码',
  `education`         ENUM('博士', '硕士', '本科', '专科', '高中', '初中', '小学') CHARACTER SET utf8 NULL COMMENT '教育程度',
  `dep_id`            INT                     NOT NULL COMMENT '部门id',
  `unit_id`           INT                     NOT NULL COMMENT '单位id',
  #   `contract_id`       INT                     NOT NULL COMMENT '合同id',
  `birthday`          DATE,
  `zzmm`              enum('党员','团员','群众')  NOT NULL default '群众' COMMENT '政治面貌',
  `hyzk`              enum('未婚','已婚')   NOT NULL default '未婚' COMMENT '婚姻状况',
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
  `id`         INT            NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  `emp_code`   INT            NOT NULL,
  `name`        VARCHAR(20)   COMMENT '离职员工',
  `leave_date` DATE      COMMENT '离职日期',
  `leave_info` VARCHAR(20)   COMMENT '离职原因',
  `leave_comment`   VARCHAR(200)  COMMENT '备注',
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
INSERT INTO `user` (`id`, `name`, `password`) VALUES ('1', 'admin', '90b9aa7e25f80cf4f64e990b78a9fc5ebd6cecad', '管理员');

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