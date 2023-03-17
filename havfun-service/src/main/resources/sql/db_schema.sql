/* Schema for new system */

USE havfun_new;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_group` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '',
  `user_name` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '',
  `passcode` varchar(100) COLLATE utf8_bin NOT NULL DEFAULT '',
  `first_name` varchar(32) COLLATE utf8_bin NOT NULL DEFAULT '',
  `last_name` varchar(32) COLLATE utf8_bin NOT NULL DEFAULT '',
  `email` varchar(96) COLLATE utf8_bin NOT NULL DEFAULT '',
  `status` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '',
  `create_timestamp` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

DROP TABLE IF EXISTS `user_login_history`;

CREATE TABLE `user_login_history` (
  `user_login_history_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `login_token` varchar(255) COLLATE utf8_bin NOT NULL,
  `ip_address` varchar(40) COLLATE utf8_bin NOT NULL DEFAULT '',
  `login_timestamp` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `logout_timestamp` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `login_status` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`user_login_history_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


DROP TABLE IF EXISTS `social_sign_in`;

CREATE TABLE `social_sign_in` (
  `social_sign_in_id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `social_sign_in_provider` varchar(255) NOT NULL,
  `social_sign_in_identifier` varchar(255) NOT NULL,
  `register_timestamp` datetime NOT NULL,
  `last_visit_timestamp` datetime NOT NULL,
  PRIMARY KEY (`social_sign_in_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` int(11) NOT NULL,
  `first_name` varchar(32) COLLATE utf8_bin NOT NULL DEFAULT '',
  `last_name` varchar(32) COLLATE utf8_bin NOT NULL DEFAULT '',
  `address_1` varchar(128) COLLATE utf8_bin NOT NULL,
  `address_2` varchar(128) COLLATE utf8_bin NOT NULL,
  `city` varchar(128) COLLATE utf8_bin,
  `postcode` varchar(10) COLLATE utf8_bin,
  `country_id` int(11) NOT NULL DEFAULT '0',
  `zone_id` int(11) NOT NULL DEFAULT '0',
  `telephone` varchar(32) COLLATE utf8_bin NOT NULL,
  `billing_address` tinyint(1) NOT NULL DEFAULT '0',
  `shipping_address` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`address_id`),
  KEY `client_id` (`client_id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


DROP TABLE IF EXISTS `product_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_group` (
  `product_group_id` int(11) NOT NULL AUTO_INCREMENT,
  `name_en` varchar(255) COLLATE utf8_bin DEFAULT '',
  `image` BLOB NULL DEFAULT NULL, 
  `parent_id` int(11) NOT NULL DEFAULT '0',
  `status` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '',
  `create_timestamp` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `last_modified_timestamp` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`product_group_id`)
) ENGINE=MyISAM AUTO_INCREMENT=93 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country` (
  `country_id` int(11) NOT NULL AUTO_INCREMENT,
  `country_code`varchar(10) COLLATE utf8_bin NOT NULL,
  `name_en` varchar(128) COLLATE utf8_bin NOT NULL,
  `name_hk` varchar(128) COLLATE utf8_bin NOT NULL,
  `name_cn` varchar(128) COLLATE utf8_bin NOT NULL,
  `active` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`country_id`)
) ENGINE=MyISAM AUTO_INCREMENT=240 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `coupon_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coupon_history` (
  `coupon_history_id` int(11) NOT NULL AUTO_INCREMENT,
  `coupon_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `client_id` int(11) NOT NULL,
  `amount` decimal(15,4) NOT NULL,
  `create_timestamp` datetime NOT NULL,
  PRIMARY KEY (`coupon_history_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `coupon_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coupon_product` (
  `coupon_product_id` int(11) NOT NULL AUTO_INCREMENT,
  `coupon_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  PRIMARY KEY (`coupon_product_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


DROP TABLE IF EXISTS `coupon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coupon` (
  `coupon_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) COLLATE utf8_bin NOT NULL,
  `code` varchar(10) COLLATE utf8_bin NOT NULL,
  `type` char(1) COLLATE utf8_bin NOT NULL,
  `discount` decimal(15,4) NOT NULL,
  `logged` tinyint(1) NOT NULL,
  `shipping` tinyint(1) NOT NULL,
  `total` decimal(15,4) NOT NULL,
  `start_date` date NOT NULL DEFAULT '0000-00-00',
  `end_date` date NOT NULL DEFAULT '0000-00-00',
  `uses_total` int(11) NOT NULL,
  `uses_client` varchar(11) COLLATE utf8_bin NOT NULL,
  `status` tinyint(1) NOT NULL,
  `create_timestamp` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`coupon_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `currency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `currency` (
  `currency_id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(3) COLLATE utf8_bin NOT NULL DEFAULT '',
  `symbol_left` varchar(12) COLLATE utf8_bin NOT NULL,
  `symbol_right` varchar(12) COLLATE utf8_bin NOT NULL,
  `decimal_place` char(1) COLLATE utf8_bin NOT NULL,
  `last_modified_timestamp` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`currency_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `client_code`;

CREATE TABLE `client_code` (
  `client_code_id` int(11) NOT NULL,
  `client_id` int(11) NOT NULL,  
  `client_code` varchar(11) NOT NULL,
  `used` tinyint(1) NOT NULL,
  PRIMARY KEY (`client_code_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



DROP TABLE IF EXISTS `client_transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client_transaction` (
  `client_transaction_id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `description` text COLLATE utf8_bin NOT NULL,
  `amount` decimal(15,4) NOT NULL,
  `date_added` datetime NOT NULL,
  PRIMARY KEY (`client_transaction_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `client`;
 
CREATE TABLE `client` (
  `client_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(32) COLLATE utf8_bin NOT NULL DEFAULT '',
  `last_name` varchar(32) COLLATE utf8_bin NOT NULL DEFAULT '',
  `birth_date` int(11) NOT NULL,
  `gender` varchar(6) COLLATE utf8_bin DEFAULT '',
  `email` varchar(96) COLLATE utf8_bin NOT NULL DEFAULT '',
  `telephone` varchar(32) COLLATE utf8_bin DEFAULT '',
  `fax` varchar(32) COLLATE utf8_bin DEFAULT '',
  `referrer_client_id` int(11) DEFAULT '0',
  `store_id` int(11) DEFAULT '0',
  `passcode` varchar(100) COLLATE utf8_bin DEFAULT '',
  `newsletter` tinyint(1) DEFAULT '0',
  `client_group` varchar(6) COLLATE utf8_bin DEFAULT '0',
  `ip_address` varchar(40) COLLATE utf8_bin DEFAULT '',
  `status` varchar(6) COLLATE utf8_bin NOT NULL,
  `token` varchar(255) COLLATE utf8_bin DEFAULT '',
  `create_timestamp` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`client_id`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `client_login_history`;

CREATE TABLE `client_login_history` (
  `client_login_history_id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` int(11) NOT NULL,
  `login_token` varchar(255) COLLATE utf8_bin NOT NULL,
  `ip_address` varchar(40) COLLATE utf8_bin NOT NULL DEFAULT '',
  `login_timestamp` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `logout_timestamp` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `login_status` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`client_login_history_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


DROP TABLE IF EXISTS `geo_zone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `geo_zone` (
  `geo_zone_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) COLLATE utf8_bin NOT NULL DEFAULT '',
  `description` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `create_timestamp` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `last_modified_timestamp` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`geo_zone_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `order_option_value`;

CREATE TABLE `order_option_value` (
  `order_option_value_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_option_id` int(11) NOT NULL,
  `image` varchar(255) COLLATE utf8_bin NOT NULL,
  `sorting_order` int(3) NOT NULL,
  PRIMARY KEY (`order_option_value_id`)
) ENGINE=MyISAM AUTO_INCREMENT=50 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `order_option`;

CREATE TABLE `order_option` (
  `order_option_id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(32) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`order_option_id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;



DROP TABLE IF EXISTS `order_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_history` (
  `order_history_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `order_status` int(5) NOT NULL,
  `remark` text COLLATE utf8_bin NOT NULL,
  `create_timestamp` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`order_history_id`)
) ENGINE=MyISAM AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `order_option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_option` (
  `order_option_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `order_product_id` int(11) NOT NULL,
  `product_option_id` int(11) NOT NULL,
  `product_option_value_id` int(11) NOT NULL DEFAULT '0',
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `value` text COLLATE utf8_bin NOT NULL,
  `type` varchar(32) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`order_option_id`)
) ENGINE=MyISAM AUTO_INCREMENT=254 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `order_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_product` (
  `order_product_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `model` varchar(64) COLLATE utf8_bin NOT NULL,
  `quantity` int(4) NOT NULL,
  `price` decimal(15,4) NOT NULL DEFAULT '0.0000',
  `total` decimal(15,4) NOT NULL DEFAULT '0.0000',
  `tax` decimal(15,4) NOT NULL DEFAULT '0.0000',
  `reward` int(8) NOT NULL,
  PRIMARY KEY (`order_product_id`)
) ENGINE=MyISAM AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;



DROP TABLE IF EXISTS `client_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client_order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `invoice_no` varchar(255) COLLATE utf8_bin,
  `store_id` int(11) NOT NULL DEFAULT '0',
  `store_name` varchar(64) COLLATE utf8_bin,
  `store_url` varchar(255) COLLATE utf8_bin,
  `client_id` int(11) NOT NULL DEFAULT '0',
  `client_group` varchar(255) COLLATE utf8_bin,
  `first_name` varchar(32) COLLATE utf8_bin NOT NULL DEFAULT '',
  `last_name` varchar(32) COLLATE utf8_bin NOT NULL DEFAULT '',
  `email` varchar(96) COLLATE utf8_bin DEFAULT '',
  `telephone` varchar(32) COLLATE utf8_bin DEFAULT '',
  `fax` varchar(32) COLLATE utf8_bin DEFAULT '',
  
  `billing_first_name` varchar(32) COLLATE utf8_bin NOT NULL DEFAULT '',
  `billing_last_name` varchar(32) COLLATE utf8_bin NOT NULL DEFAULT '',
  `billing_address_1` varchar(128) COLLATE utf8_bin NOT NULL DEFAULT '',
  `billing_address_2` varchar(128) COLLATE utf8_bin NOT NULL DEFAULT '',
  `billing_city` varchar(128) COLLATE utf8_bin,
  `billing_postcode` varchar(10) COLLATE utf8_bin,
  `billing_country_id` int(11) NOT NULL DEFAULT '0',
  `billing_telephone` varchar(32) COLLATE utf8_bin NOT NULL DEFAULT '',
 
  `shipping_first_name` varchar(32) COLLATE utf8_bin NOT NULL DEFAULT '',
  `shipping_last_name` varchar(32) COLLATE utf8_bin NOT NULL DEFAULT '',
  `shipping_address_1` varchar(128) COLLATE utf8_bin NOT NULL DEFAULT '',
  `shipping_address_2` varchar(128) COLLATE utf8_bin NOT NULL DEFAULT '',
  `shipping_city` varchar(128) COLLATE utf8_bin,
  `shipping_postcode` varchar(10) COLLATE utf8_bin,
  `shipping_country_id` int(11) NOT NULL DEFAULT '0',
  `shipping_telephone` varchar(32) COLLATE utf8_bin NOT NULL DEFAULT '',  
  `shipping_method_id` varchar(128) COLLATE utf8_bin NOT NULL DEFAULT '',      
  `payment_method_id` varchar(128) COLLATE utf8_bin NOT NULL DEFAULT '',  
  `currency_id` int(11) NOT NULL DEFAULT '0',
  `currency_code` varchar(3) COLLATE utf8_bin NOT NULL DEFAULT '',
  `currency_value` decimal(15,8) NOT NULL DEFAULT '1.00000000',

  `remark` text COLLATE utf8_bin,
  `total` decimal(15,4) NOT NULL DEFAULT '0.0000',
  `status` varchar(8) COLLATE utf8_bin NOT NULL DEFAULT 'P',
  `create_timestamp` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `last_modified_timestamp` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`order_id`)
) ENGINE=MyISAM AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `product_discount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_discount` (
  `product_discount_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `client_group` varchar(6) COLLATE utf8_bin NOT NULL,
  `quantity` int(4) NOT NULL DEFAULT '0',
  `priority` int(5) NOT NULL DEFAULT '1',
  `price` decimal(15,4) NOT NULL DEFAULT '0.0000',
  `start_date` date NOT NULL DEFAULT '0000-00-00',
  `end_date` date NOT NULL DEFAULT '0000-00-00',
  PRIMARY KEY (`product_discount_id`),
  KEY `product_id` (`product_id`)
) ENGINE=MyISAM AUTO_INCREMENT=463 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `product_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_image` (
  `product_image_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `image` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sorting_order` int(3) NOT NULL DEFAULT '0',
  PRIMARY KEY (`product_image_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3140 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `product_attribute`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_attribute` (
  `product_attribute_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `attribute_key` varchar(100) NOT NULL,
  `name_en` varchar(100) NOT NULL DEFAULT '',
  `name_hk` varchar(100) NOT NULL DEFAULT '',
  `name_cn` varchar(100) NOT NULL DEFAULT '',
  `sort_order` int(3) NOT NULL,
  PRIMARY KEY (`product_attribute_id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `product_attribute_option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_attribute_option` (
  `option_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_attribute_id` int(11) NOT NULL,
  `value` varchar(100) NOT NULL DEFAULT '',
  `name` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`option_id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_group_id` int(11),
  `name_en` varchar(255) COLLATE utf8_bin, 
  `name_hk` varchar(255) COLLATE utf8_bin, 
  `name_cn` varchar(255) COLLATE utf8_bin, 
  `thumbnail_url` varchar(255) COLLATE utf8_bin, 
  `designer_client_id` int(11) NOT NULL,
  `model` varchar(64) COLLATE utf8_bin NOT NULL,
  `stock` int(4) NOT NULL DEFAULT '0',
  `manufacturer_id` int(11) NOT NULL,
  `price` decimal(15,4) NOT NULL DEFAULT '0.0000',
  `available_date` int(8) NOT NULL,
  `weight` decimal(15,8) DEFAULT '0.00000000',
  `length` decimal(15,8) DEFAULT '0.00000000',
  `width` decimal(15,8) DEFAULT '0.00000000',
  `height` decimal(15,8) DEFAULT '0.00000000',
  `sorting_order` int(11) DEFAULT '0',
  `stock_status` varchar(6) COLLATE utf8_bin NOT NULL, 
  `product_status` varchar(6) COLLATE utf8_bin NOT NULL,
  `create_timestamp` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `last_modified_timestamp` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`product_id`)
) ENGINE=MyISAM AUTO_INCREMENT=111 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `referrer_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `referrer_log` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` int(11) NOT NULL,
  `referrer_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `total` decimal(10,2) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `currency_id` int(11) NOT NULL,
  `create_timestamp` datetime NOT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=MyISAM AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;



DROP TABLE IF EXISTS `zone_to_geo_zone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zone_to_geo_zone` (
  `zone_to_geo_zone_id` int(11) NOT NULL AUTO_INCREMENT,
  `country_id` int(11) NOT NULL,
  `zone_id` int(11) NOT NULL DEFAULT '0',
  `geo_zone_id` int(11) NOT NULL,
  `create_timestamp` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `last_modified_timestamp` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`zone_to_geo_zone_id`)
) ENGINE=MyISAM AUTO_INCREMENT=66 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `zone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zone` (
  `zone_id` int(11) NOT NULL AUTO_INCREMENT,
  `country_id` int(11) NOT NULL,
  `name` varchar(128) COLLATE utf8_bin NOT NULL,
  `code` varchar(32) COLLATE utf8_bin NOT NULL DEFAULT '',
  `active` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`zone_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3970 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `customize_product_base`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customize_product_base` (
  `base_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  PRIMARY KEY (`base_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3970 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `customize_product_base_view`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customize_product_base_view` (
  `view_id` int(11) NOT NULL AUTO_INCREMENT,
  `base_id` int(11) NOT NULL,
  `title` varchar(128) COLLATE utf8_bin NOT NULL,
  `bound_width` int(11) NOT NULL DEFAULT '0',
  `bound_height` int(11) NOT NULL DEFAULT '0',
  `z` int(11) NOT NULL DEFAULT '0',
  `scale` decimal(10,4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`view_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3970 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `customize_product_border_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customize_product_border_item` (
  `border_id` int(11) NOT NULL AUTO_INCREMENT,
  `view_id` int(11) NOT NULL,
  `item_key` varchar(128) COLLATE utf8_bin,
  `item_type` varchar(128) COLLATE utf8_bin, 
  `title` varchar(128) COLLATE utf8_bin,  
  `default_option` tinyint(1) NOT NULL DEFAULT '1',
  `cost` decimal(10,4) NOT NULL DEFAULT '0',
  `x` int(11) NOT NULL DEFAULT '0',
  `y` int(11) NOT NULL DEFAULT '0',
  `width` int(11) NOT NULL DEFAULT '0',
  `height` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`border_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3970 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `customize_product_color_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customize_product_color_item` (
  `color_id` int(11) NOT NULL AUTO_INCREMENT,
  `base_id` int(11) NOT NULL,
  `file_type` varchar(128) COLLATE utf8_bin,
  `image_url` varchar(128) COLLATE utf8_bin, 
  `parent_image` varchar(128) COLLATE utf8_bin,  
  PRIMARY KEY (`color_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3970 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `courier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `courier` (
  `courier_id` int(11) NOT NULL AUTO_INCREMENT,  
  `forwarder_id` int(11) NOT NULL,
  `country_code`varchar(10) COLLATE utf8_bin NOT NULL,
  `from_weight` decimal(10,4)  COLLATE utf8_bin,
  `to_weight` decimal(10,4)  COLLATE utf8_bin,
  `base_weight`decimal(10,4)  COLLATE utf8_bin, 
  `base_cost` decimal(10,4)  COLLATE utf8_bin, 
  `weight_per_tier` decimal(10,4)  COLLATE utf8_bin,  
  `charge_per_tier` decimal(10,4)  COLLATE utf8_bin,  
  `service_charge_percentage` decimal(10,4)  COLLATE utf8_bin,  
  `fuel_charge_percentage` decimal(10,4)  COLLATE utf8_bin,  
  PRIMARY KEY (`courier_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3970 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `forwarder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `forwarder` (
  `forwarder_id` int(11) NOT NULL AUTO_INCREMENT,
  `name_en` varchar(128) COLLATE utf8_bin,
  `name_hk` varchar(128) COLLATE utf8_bin,
  `name_cn` varchar(128) COLLATE utf8_bin, 
  PRIMARY KEY (`forwarder_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3970 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `material_group`;

CREATE TABLE `material_group` (
  `material_group_id` int(11) NOT NULL AUTO_INCREMENT,
  `name_en` varchar(255) COLLATE utf8_bin DEFAULT '',
  `name_hk` varchar(255) COLLATE utf8_bin DEFAULT '',  
  `name_cn` varchar(128) COLLATE utf8_bin DEFAULT '',  
  `image` BLOB NULL DEFAULT NULL, 
  `parent_id` int(11) NOT NULL DEFAULT '0',
  `active` tinyint(1) NOT NULL DEFAULT '1',  
  `create_timestamp` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `last_modified_timestamp` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`material_group_id`)
) ENGINE=MyISAM AUTO_INCREMENT=93 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

DROP TABLE IF EXISTS `material`;

CREATE TABLE `material` (
  `material_id` int(11) NOT NULL AUTO_INCREMENT,  
  `image` BLOB NULL DEFAULT NULL, 
  `material_group_id` int(11) NOT NULL DEFAULT '0',
  `material_index` int(11) NOT NULL DEFAULT '0',
  `active` tinyint(1) NOT NULL DEFAULT '1',  
  `create_timestamp` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`material_id`)
) ENGINE=MyISAM AUTO_INCREMENT=93 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

DROP TABLE IF EXISTS `client_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client_product` (
  `client_product_id` int(11) NOT NULL AUTO_INCREMENT,
  `design_client_id` int(11),
  `product_status` varchar(6) COLLATE utf8_bin NOT NULL,
  `create_timestamp` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `last_modified_timestamp` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`client_product_id`)
) ENGINE=MyISAM AUTO_INCREMENT=111 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

