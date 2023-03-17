SET MODE MySQL;

CREATE TABLE `announcement` (
  `announcement_id` int(11) NOT NULL AUTO_INCREMENT,
  `stock_code` int(11) NOT NULL,
  `unique_name` varchar(255) DEFAULT NULL,
  `release_timestamp` timestamp NULL DEFAULT NULL,
  `announcement_title` varchar(255) DEFAULT NULL,
  `announcement_title_cn` varchar(255) DEFAULT NULL,
  `announcement_description` varchar(4000) DEFAULT NULL,
  `announcement_description_cn` varchar(4000) DEFAULT NULL,
  `announcement_type_code` varchar(255) DEFAULT NULL,
  `language_flag` varchar(255) DEFAULT 'C',
  `file_size` varchar(255) DEFAULT 'KB',
  `file_type` varchar(255) DEFAULT 'pdf',
  `url_path` varchar(255) DEFAULT '/listco/news/',
  `announcement_status` varchar(1) NOT NULL DEFAULT 'A',
  PRIMARY KEY (`announcement_id`,`stock_code`),
--  KEY `AnnouncementStockCode` (`stock_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `announcement_pending` (
  `announcement_id` int(11) NOT NULL,
  `stock_code` int(11) NOT NULL,
  `unique_name` varchar(255) DEFAULT NULL,
  `release_timestamp` timestamp NULL DEFAULT NULL,
  `announcement_title` varchar(255) DEFAULT NULL,
  `announcement_title_cn` varchar(255) DEFAULT NULL,
  `announcement_description` varchar(4000) DEFAULT NULL,
  `announcement_description_cn` varchar(4000) DEFAULT NULL,
  `announcement_type_code` varchar(255) DEFAULT NULL,
  `language_flag` varchar(255) DEFAULT 'C',
  `file_size` varchar(255) DEFAULT 'KB',
  `file_type` varchar(255) DEFAULT 'pdf',
  `url_path` varchar(255) DEFAULT '/listco/news/',
  `announcement_status` varchar(1) NOT NULL DEFAULT 'P',
  PRIMARY KEY (`announcement_id`,`stock_code`),
  KEY `AnnouncementStockCode` (`stock_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `announcement_type` (
  `announcement_type_code` varchar(255) NOT NULL,
  `announcement_type_name_en` varchar(255) DEFAULT NULL,
  `announcement_type_name_hk` varchar(255) DEFAULT NULL,
  `announcement_type_name_cn` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`announcement_type_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `business_classification` (
  `business_classification_id` int(11) NOT NULL AUTO_INCREMENT,
  `business_classification_en` varchar(255) DEFAULT NULL,
  `business_classification_hk` varchar(255) DEFAULT NULL,
  `business_classification_cn` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`business_classification_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `company` (
  `company_id` int(11) NOT NULL AUTO_INCREMENT,
  `stock_code` int(11) NOT NULL,
  `long_name_en` varchar(255) DEFAULT NULL,
  `long_name_hk` varchar(255) DEFAULT NULL,
  `long_name_cn` varchar(255) DEFAULT NULL,
  `short_name_en` varchar(255) DEFAULT NULL,
  `short_name_hk` varchar(255) DEFAULT NULL,
  `short_name_cn` varchar(255) DEFAULT NULL,
  `business_classification_id` int(11) DEFAULT NULL,
  `telephone_no` varchar(255) DEFAULT NULL,
  `fax` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `website` varchar(255) DEFAULT NULL,
  `activities_en` varchar(1000) DEFAULT NULL,
  `activities_hk` varchar(1000) DEFAULT NULL,
  `activities_cn` varchar(1000) DEFAULT NULL,
  `address_en` varchar(255) DEFAULT NULL,
  `address_hk` varchar(255) DEFAULT NULL,
  `address_cn` varchar(255) DEFAULT NULL,
  `incorporate_id` int(11) DEFAULT NULL,
  `par_value_currency` varchar(255) DEFAULT NULL,
  `par_value` varchar(255) DEFAULT NULL,
  `lot_size` int(11) DEFAULT NULL,
  `authorised_shares` bigint(20) DEFAULT NULL,
  `issued_shares` bigint(20) DEFAULT NULL,
  `market` varchar(255) DEFAULT NULL,
  `listing_date` TIMESTAMP DEFAULT NULL,
  `client_index` tinyint(4) DEFAULT '0',
  
  `trading_currency` VARCHAR(3) NULL,
  `registrar_en` VARCHAR(255) NULL,
  `registrar_hk` VARCHAR(255) NULL,
  `registrar_cn` VARCHAR(255) NULL,
  `financial_year_end_date` INT(11) NULL,
  `hkex_last_updated_date` INT(11) NULL,  
  `last_updated_timestamp` TIMESTAMP NULL,
  `company_status` varchar(1) NOT NULL DEFAULT 'A',  
  PRIMARY KEY (`company_id`,`stock_code`),
  KEY `CompanyBusClassID` (`business_classification_id`),
  KEY `CompanyIncorpID` (`incorporate_id`),
  KEY `CompanyStockCode` (`stock_code`)
) ENGINE=InnoDB AUTO_INCREMENT=8302 DEFAULT CHARSET=utf8;

CREATE TABLE `company_pending` (
  `company_id` int(11) NOT NULL,
  `stock_code` int(11) NOT NULL,
  `long_name_en` varchar(255) DEFAULT NULL,
  `long_name_hk` varchar(255) DEFAULT NULL,
  `long_name_cn` varchar(255) DEFAULT NULL,
  `short_name_en` varchar(255) DEFAULT NULL,
  `short_name_hk` varchar(255) DEFAULT NULL,
  `short_name_cn` varchar(255) DEFAULT NULL,
  `business_classification_id` int(11) DEFAULT NULL,
  `telephone_no` varchar(255) DEFAULT NULL,
  `fax` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `website` varchar(255) DEFAULT NULL,
  `activities_en` varchar(1000) DEFAULT NULL,
  `activities_hk` varchar(1000) DEFAULT NULL,
  `activities_cn` varchar(1000) DEFAULT NULL,
  `address_en` varchar(255) DEFAULT NULL,
  `address_hk` varchar(255) DEFAULT NULL,
  `address_cn` varchar(255) DEFAULT NULL,
  `incorporate_id` int(11) DEFAULT NULL,
  `par_value_currency` varchar(255) DEFAULT NULL,
  `par_value` varchar(255) DEFAULT NULL,
  `lot_size` int(11) DEFAULT NULL,
  `authorised_shares` bigint(20) DEFAULT NULL,
  `issued_shares` bigint(20) DEFAULT NULL,
  `market` varchar(255) DEFAULT NULL,
  `listing_date` TIMESTAMP DEFAULT NULL,
  `client_index` tinyint(4) DEFAULT '0',
  
  `trading_currency` VARCHAR(3) NULL,
  `registrar_en` VARCHAR(255) NULL,
  `registrar_hk` VARCHAR(255) NULL,
  `registrar_cn` VARCHAR(255) NULL,
  `financial_year_end_date` INT(11) NULL,
  `hkex_last_updated_date` INT(11) NULL,  
  `last_updated_timestamp` TIMESTAMP NULL,
  `pending_status`    char(1) NOT NULL DEFAULT 'P',
  `maker_id`          int(11) NOT NULL,
  `maker_timestamp`   TIMESTAMP NOT NULL,
  `checker_id`        int(11) NOT NULL,
  `checker_timestamp` TIMESTAMP NOT NULL,
  PRIMARY KEY (`company_id`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `incorporate` (
  `incorporate_id` int(11) NOT NULL AUTO_INCREMENT,
  `incorporate_name_en` varchar(255) DEFAULT NULL,
  `incorporate_name_hk` varchar(255) DEFAULT NULL,
  `incorporate_name_cn` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`incorporate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `manage_company` (
  `company_id` int(11) NOT NULL,
  `stock_code` int(11) NOT NULL,
  PRIMARY KEY (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_login_id` varchar(100) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `user_email` varchar(255) NOT NULL,
  `user_status` varchar(1) NOT NULL,
  `user_role` varchar(2) NOT NULL,
  `company_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `user_login_history` (
  `user_login_history_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `login_token` varchar(100) DEFAULT NULL,
  `ip_address` varchar(20) NOT NULL,
  `login_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `logout_timestamp` timestamp NULL DEFAULT NULL,
  `login_status` varchar(1) NOT NULL,
  PRIMARY KEY (`user_login_history_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user_passcode` (
  `user_id` int(11) NOT NULL,
  `passcode` varchar(1000) NOT NULL,
  `passcode_fail_count` int(11) NOT NULL,
  `passcode_change_next_login` varchar(1) NOT NULL,
  `passcode_change_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `enquiry` (
  `enquiry_id` int(11) NOT NULL AUTO_INCREMENT,
  `stock_code` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `company_name` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `detail` varchar(4000) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`enquiry_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user_get_passcode` (
  `user_id`  int(11) NOT NULL,
  `generated_token`  varchar(255) NOT NULL,
  `expiry_time`  timestamp NOT NULL,
  `user_get_passcode_status`  char(1) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
