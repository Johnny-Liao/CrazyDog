CREATE DATABASE IF NOT EXISTS CrazyDog;
USE CrazyDog;

#建立服务单位表
CREATE TABLE `unit` (
  `id`        INT       NOT NULL AUTO_INCREMENT,
  `unit_code` VARCHAR(255)  NOT NULL COMMENT '单位编码',
  `unit_name` VARCHAR(255)  NOT NULL COMMENT '单位名称',
  PRIMARY KEY (`id`)
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
  `emp_id`    INT            NOT NULL,
  `join_date`  DATETIME      NOT NULL COMMENT '入职日期',
  `leave_date` DATETIME      COMMENT '离职日期',
  `leave_info` VARCHAR(20)   COMMENT '离职原因',
  `leave_comment`   VARCHAR(200)  COMMENT '备注',
  FOREIGN KEY (`emp_id`) REFERENCES `employee` (`id`) ON DELETE NO ACTION  ON UPDATE NO ACTION
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