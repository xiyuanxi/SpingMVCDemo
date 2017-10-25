CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` smallint(6) NOT NULL COMMENT '0:测试帐号 1:正式帐号',
  `submit_name` varchar(15) NOT NULL COMMENT '分配给用户的提交transaction的帐号代码',
  `submit_password` varchar(32) NOT NULL COMMENT '分配给用户的提交transaction的帐号密码',
  `login_name` varchar(15) NOT NULL COMMENT '分配给用户的在网站上查询数据的用户名',
  `login_password` varchar(32) NOT NULL COMMENT '分配给用户的在网站上查询数据的密码',
  `display_company_name` varchar(45) DEFAULT NULL,
  `display_user_name` varchar(45) DEFAULT NULL,
  `insert_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `device` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `bb_guid` varchar(45) NOT NULL,
  `fonts_code` varchar(32) DEFAULT NULL,
  `insert_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=232 DEFAULT CHARSET=utf8;

CREATE TABLE `trans_device` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `transaction_id` int(20) NOT NULL,
  `device_type` varchar(20) DEFAULT NULL,
  `browser_language` varchar(8) DEFAULT NULL,
  `browser_type` varchar(20) DEFAULT NULL,
  `browser_version` varchar(45) DEFAULT NULL,
  `flash_enabled` tinyint(1) DEFAULT NULL,
  `flash_version` varchar(20) DEFAULT NULL,
  `flash_storage_enabled` tinyint(1) DEFAULT NULL,
  `operation_system` varchar(20) DEFAULT NULL,
  `screen_resolution` varchar(12) DEFAULT NULL,
  `time_zone` varchar(10) DEFAULT NULL,
  `insert_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

CREATE TABLE `trans_location` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `transaction_id` int(20) NOT NULL,
  `ip` varchar(16) DEFAULT NULL,
  `country_id` varchar(2) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `isp` varchar(30) DEFAULT NULL,
  `insert_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

CREATE TABLE `transaction` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `account_id` int(10) NOT NULL,
  `device_id` int(16) NOT NULL,
  `check_name` varchar(20) NOT NULL,
  `result` smallint(6) DEFAULT NULL COMMENT '0: Allowed 1: Review 2: Denied',
  `rule_set_id` int(11) DEFAULT NULL,
  `rule_check_result` varchar(45) DEFAULT NULL,
  `fns_code` varchar(32) DEFAULT NULL,
  `is_new_device` tinyint(1) NOT NULL DEFAULT '0',
  `insert_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;

CREATE TABLE `user_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(40) NOT NULL,
  `user_fullname` varchar(45) NOT NULL,
  `password` varchar(32) NOT NULL,
  `age` int(4) NOT NULL,
  `address` varchar(45) NOT NULL,
  `insert_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
