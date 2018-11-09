-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.14 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 shopnet 的数据库结构
CREATE DATABASE IF NOT EXISTS `shopnet` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `shopnet`;


-- 导出  表 shopnet.px_address 结构
CREATE TABLE IF NOT EXISTS `px_address` (
  `address_id` varchar(100) NOT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `address_detail` varchar(200) DEFAULT NULL,
  `address_postalcode` varchar(10) DEFAULT NULL,
  `address_phone` varchar(14) DEFAULT NULL,
  `consignee` varchar(20) DEFAULT NULL,
  `is_default` int(11) DEFAULT NULL,
  PRIMARY KEY (`address_id`),
  KEY `FKA85CC8BD7EEEB312` (`user_id`),
  CONSTRAINT `FKA85CC8BD7EEEB312` FOREIGN KEY (`user_id`) REFERENCES `px_users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  shopnet.px_address 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `px_address` DISABLE KEYS */;
INSERT INTO `px_address` (`address_id`, `user_id`, `address_detail`, `address_postalcode`, `address_phone`, `consignee`, `is_default`) VALUES
	('2018110216394182783424', '2018110215571954862401', '上海,普陀,普陀,中江路388号', '200044', '18217727935', '宫台', 0),
	('2018110610584328403268', '2018110215571954862401', '江西,南昌,进贤,北京路123号', '200000', '13245645614', '大郎', 0),
	('2018110611261869578886', '2018110215571954862401', '上海,宝山,宝山,锦秋路1188号', '200444', '13612345600', '二郎', 1);
/*!40000 ALTER TABLE `px_address` ENABLE KEYS */;


-- 导出  表 shopnet.px_brand 结构
CREATE TABLE IF NOT EXISTS `px_brand` (
  `brand_id` varchar(100) NOT NULL,
  `brand_name` varchar(50) DEFAULT NULL,
  `brand_image` varchar(200) DEFAULT NULL,
  `brand_spell` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`brand_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  shopnet.px_brand 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `px_brand` DISABLE KEYS */;
INSERT INTO `px_brand` (`brand_id`, `brand_name`, `brand_image`, `brand_spell`) VALUES
	('400001', '耐克', '/images/goods/brands/naike.jpg', 'naike'),
	('400002', '李宁', '/images/goods/brands/lining.jpg', 'lining'),
	('400004', '阿迪达斯', '/images/goods/brands/adidas.jpg', 'adidasi'),
	('400005', '苹果', '/images/goods/brands/apple.jpg', 'apple'),
	('400006', '美的', '/images/goods/brands/meidi.jpg', 'meidi'),
	('400007', '格力', '/images/goods/brands/geli.jpg', 'geli'),
	('400008', '三只松鼠', '/images/goods/brands/sanzhisongshu.jpg', 'sanzhisongshu'),
	('400009', '百草味', '/images/goods/brands/baicaowei.jpg', 'baicaowei'),
	('400010', '三星', '/images/goods/brands/sanxing.jpg', 'sanxing'),
	('400011', '奔驰', '/images/goods/brands/benchi.jpg', 'benchi'),
	('400012', '宝马', '/images/goods/brands/baoma.jpg', 'baoma'),
	('400013', '华为', '/images/goods/brands/huawei.jpg', 'huawei'),
	('400014', '红富士', '/images/goods/brands/hongfushi.jpg', 'hongfushi');
/*!40000 ALTER TABLE `px_brand` ENABLE KEYS */;


-- 导出  表 shopnet.px_category 结构
CREATE TABLE IF NOT EXISTS `px_category` (
  `category_id` varchar(100) NOT NULL,
  `category_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  shopnet.px_category 的数据：~9 rows (大约)
/*!40000 ALTER TABLE `px_category` DISABLE KEYS */;
INSERT INTO `px_category` (`category_id`, `category_name`) VALUES
	('200001', '服饰'),
	('200002', '手机'),
	('200003', '家电'),
	('200004', '图书'),
	('200005', '零食'),
	('200007', '水果'),
	('200008', '建材'),
	('200009', '汽车');
/*!40000 ALTER TABLE `px_category` ENABLE KEYS */;


-- 导出  表 shopnet.px_collect 结构
CREATE TABLE IF NOT EXISTS `px_collect` (
  `collect_id` varchar(100) NOT NULL,
  `collect_time` varchar(20) DEFAULT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `goods_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`collect_id`),
  KEY `FK255C8DF37EEEB312` (`user_id`),
  KEY `FK255C8DF3148D8997` (`goods_id`),
  CONSTRAINT `FK255C8DF3148D8997` FOREIGN KEY (`goods_id`) REFERENCES `px_goodslisting` (`goods_id`),
  CONSTRAINT `FK255C8DF37EEEB312` FOREIGN KEY (`user_id`) REFERENCES `px_users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  shopnet.px_collect 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `px_collect` DISABLE KEYS */;
INSERT INTO `px_collect` (`collect_id`, `collect_time`, `user_id`, `goods_id`) VALUES
	('2018110514271748990850', '2018-11-05 02:27:17', '2018110215571954862401', '2018102615125463135465'),
	('2018110613124506998044', '2018-11-06 01:12:45', '2018110215571954862401', '2018102915302169570603');
/*!40000 ALTER TABLE `px_collect` ENABLE KEYS */;


-- 导出  表 shopnet.px_comment 结构
CREATE TABLE IF NOT EXISTS `px_comment` (
  `comment_id` varchar(100) NOT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `goods_id` varchar(100) DEFAULT NULL,
  `comment_time` varchar(20) DEFAULT NULL,
  `comment_content` varchar(1000) DEFAULT NULL,
  `comment_grade` int(11) DEFAULT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `FK256B1B287EEEB312` (`user_id`),
  KEY `FK256B1B28148D8997` (`goods_id`),
  CONSTRAINT `FK256B1B28148D8997` FOREIGN KEY (`goods_id`) REFERENCES `px_goodslisting` (`goods_id`),
  CONSTRAINT `FK256B1B287EEEB312` FOREIGN KEY (`user_id`) REFERENCES `px_users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  shopnet.px_comment 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `px_comment` DISABLE KEYS */;
INSERT INTO `px_comment` (`comment_id`, `user_id`, `goods_id`, `comment_time`, `comment_content`, `comment_grade`) VALUES
	('2018110514154385890912', '2018110215571954862401', '2018102615125463135465', '2018-11-05 14:15:43', '不错，穿着很舒服', 5),
	('2018110518234247148432', '2018110215571954862401', '2018102615125463135465', '2018-11-05 18:23:42', '质量差', 0);
/*!40000 ALTER TABLE `px_comment` ENABLE KEYS */;


-- 导出  表 shopnet.px_discountcoupon 结构
CREATE TABLE IF NOT EXISTS `px_discountcoupon` (
  `discountCoupon_id` varchar(100) NOT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `discountCoupon__name` varchar(100) DEFAULT NULL,
  `discountCoupon_time` varchar(50) DEFAULT NULL,
  `discountCoupon_validity` varchar(200) DEFAULT NULL,
  `discountCoupon_state` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`discountCoupon_id`),
  KEY `FK703227BE7EEEB312` (`user_id`),
  CONSTRAINT `FK703227BE7EEEB312` FOREIGN KEY (`user_id`) REFERENCES `px_users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  shopnet.px_discountcoupon 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `px_discountcoupon` DISABLE KEYS */;
INSERT INTO `px_discountcoupon` (`discountCoupon_id`, `user_id`, `discountCoupon__name`, `discountCoupon_time`, `discountCoupon_validity`, `discountCoupon_state`) VALUES
	('2018110514154385890915', '2018110215571954862401', '满199减30', '2018-11-05 14:15:43', '2018-11-11 14:15:43', 1),
	('2018110514154385890916', '2018110215571954862401', '满299减50', '2018-11-04 14:15:43', '2018-11-12 14:15:43', 0),
	('2018110514154385890917', '2018110215571954862401', '满599减100', '2018-11-03 14:15:43', '2018-11-02 0:0:0', 2);
/*!40000 ALTER TABLE `px_discountcoupon` ENABLE KEYS */;


-- 导出  表 shopnet.px_goodscolor 结构
CREATE TABLE IF NOT EXISTS `px_goodscolor` (
  `goodsColor_id` varchar(100) NOT NULL,
  `goods_id` varchar(100) DEFAULT NULL,
  `goods_color` varchar(50) DEFAULT NULL,
  `goods_image` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`goodsColor_id`),
  KEY `FK47257064148D8997` (`goods_id`),
  CONSTRAINT `FK47257064148D8997` FOREIGN KEY (`goods_id`) REFERENCES `px_goodslisting` (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  shopnet.px_goodscolor 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `px_goodscolor` DISABLE KEYS */;
INSERT INTO `px_goodscolor` (`goodsColor_id`, `goods_id`, `goods_color`, `goods_image`) VALUES
	('2018102613292991403615', '2018102613235684336731', '红色', '/images/goods/goods/O1CN01Q2eU0v1V6fpVrwZNv_!!0-item_pic.jpg_430x430q90.jpg'),
	('2018102615310142085070', '2018102615125463135465', '灰色', '/images/goods/goods/display_423374_1.jpg'),
	('2018102915322128713364', '2018102915302169570603', '玫瑰金', '/images/goods/goods/155235234987165454683270_x.jpg'),
	('2018110913365206223974', '2018110913134634962360', '宝石蓝', '/images/goods/goods/428_428_1539230426520mp.png');
/*!40000 ALTER TABLE `px_goodscolor` ENABLE KEYS */;


-- 导出  表 shopnet.px_goodslisting 结构
CREATE TABLE IF NOT EXISTS `px_goodslisting` (
  `goods_id` varchar(100) NOT NULL,
  `storage_id` varchar(100) DEFAULT NULL,
  `category_id` varchar(100) DEFAULT NULL,
  `style_id` varchar(100) DEFAULT NULL,
  `brand_id` varchar(100) DEFAULT NULL,
  `goods_name` varchar(100) DEFAULT NULL,
  `goods_grounding` varchar(20) DEFAULT NULL,
  `goods_marketNumber` int(11) DEFAULT NULL,
  `goods_exitNumber` int(11) DEFAULT NULL,
  `goods_market` varchar(20) DEFAULT NULL,
  `goods_image` varchar(200) DEFAULT NULL,
  `goods_isRecommend` int(11) DEFAULT NULL,
  `goods_weight` float DEFAULT NULL,
  `goods_marketPrice` float DEFAULT NULL,
  `goods_bid` float DEFAULT NULL,
  `goods_state` int(11) DEFAULT NULL,
  PRIMARY KEY (`goods_id`),
  KEY `FKE5CABF453F7C8C1F` (`category_id`),
  KEY `FKE5CABF4532D58015` (`storage_id`),
  KEY `FKE5CABF45FEADFF15` (`style_id`),
  KEY `FKE5CABF4585242755` (`brand_id`),
  CONSTRAINT `FKE5CABF4532D58015` FOREIGN KEY (`storage_id`) REFERENCES `px_storage` (`storage_id`),
  CONSTRAINT `FKE5CABF453F7C8C1F` FOREIGN KEY (`category_id`) REFERENCES `px_category` (`category_id`),
  CONSTRAINT `FKE5CABF4585242755` FOREIGN KEY (`brand_id`) REFERENCES `px_brand` (`brand_id`),
  CONSTRAINT `FKE5CABF45FEADFF15` FOREIGN KEY (`style_id`) REFERENCES `px_style` (`style_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  shopnet.px_goodslisting 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `px_goodslisting` DISABLE KEYS */;
INSERT INTO `px_goodslisting` (`goods_id`, `storage_id`, `category_id`, `style_id`, `brand_id`, `goods_name`, `goods_grounding`, `goods_marketNumber`, `goods_exitNumber`, `goods_market`, `goods_image`, `goods_isRecommend`, `goods_weight`, `goods_marketPrice`, `goods_bid`, `goods_state`) VALUES
	('2018102613235684336731', '200001', '200001', '300001', '400001', '耐克篮球鞋', '2018-10-03', 0, 35, '2018-10-01', '/images/goods/goods/O1CN01Q2eU0v1V6fpVrwZNv_!!0-item_pic.jpg_430x430q90.jpg', 1, 899, 1299, 566, 1),
	('2018102615125463135465', '200002', '200001', '300003', '400002', '李宁跑鞋', '2018-10-01', 0, 41, '2018-10-02', '/images/goods/goods/display_423374_1.jpg', 1, 699, 125, 123, 1),
	('2018102915302169570603', '200001', '200002', '300004', '400005', 'iphone x', '2018-10-03', 0, 99, '2018-10-01', '/images/goods/goods/155235234987165454683270_x.jpg', 0, 1024, 8888, 6666, 1),
	('2018110913134634962360', '200002', '200002', '300008', '400013', 'HUAWEI Mate 20', '2018-10-01', 0, 80, '2018-09-01', '/images/goods/goods/428_428_1539230426520mp.png', 1, 350, 3999, 3599, 1);
/*!40000 ALTER TABLE `px_goodslisting` ENABLE KEYS */;


-- 导出  表 shopnet.px_goodssize 结构
CREATE TABLE IF NOT EXISTS `px_goodssize` (
  `goodsSize_id` varchar(100) NOT NULL,
  `goodsColor_id` varchar(100) DEFAULT NULL,
  `goods_attr` varchar(200) DEFAULT NULL,
  `goods_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`goodsSize_id`),
  KEY `FK235AFAE0BEDB805F` (`goodsColor_id`),
  CONSTRAINT `FK235AFAE0BEDB805F` FOREIGN KEY (`goodsColor_id`) REFERENCES `px_goodscolor` (`goodsColor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  shopnet.px_goodssize 的数据：~5 rows (大约)
/*!40000 ALTER TABLE `px_goodssize` DISABLE KEYS */;
INSERT INTO `px_goodssize` (`goodsSize_id`, `goodsColor_id`, `goods_attr`, `goods_number`) VALUES
	('2018102613293522320459', '2018102613292991403615', '42码', 25),
	('2018102613293850958652', '2018102613292991403615', '40码', 10),
	('2018102615310118904597', '2018102615310142085070', '41码', 33),
	('2018102615310188173382', '2018102615310142085070', '43码', 8),
	('2018102915323038925606', '2018102915322128713364', '64G', 99),
	('2018110913365210255359', '2018110913365206223974', '64G', 20),
	('2018110913365255386167', '2018102915322128713364', '256G', 20),
	('2018110913365274941853', '2018102915322128713364', '128G', 20),
	('2018110913365299259885', '2018110913365206223974', '128G', 20);
/*!40000 ALTER TABLE `px_goodssize` ENABLE KEYS */;


-- 导出  表 shopnet.px_jinbrecord 结构
CREATE TABLE IF NOT EXISTS `px_jinbrecord` (
  `jinB_id` varchar(100) NOT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `jinB_time` varchar(100) DEFAULT NULL,
  `jinB_num` int(11) DEFAULT NULL,
  `jinB_style` varchar(100) DEFAULT NULL,
  `jinB_state` int(11) DEFAULT NULL,
  PRIMARY KEY (`jinB_id`),
  KEY `FK4C26E1C07EEEB312` (`user_id`),
  CONSTRAINT `FK4C26E1C07EEEB312` FOREIGN KEY (`user_id`) REFERENCES `px_users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  shopnet.px_jinbrecord 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `px_jinbrecord` DISABLE KEYS */;
INSERT INTO `px_jinbrecord` (`jinB_id`, `user_id`, `jinB_time`, `jinB_num`, `jinB_style`, `jinB_state`) VALUES
	('2018110216404545058488', '2018110215571954862401', '2018-11-02 16:40:45', 2, '购买商品时，获取了2个拍鞋币', 1),
	('2018110611420076472780', '2018110215571954862401', '2018-11-06 11:42:00', 2, '购买商品时，使用了2个拍鞋币', 0),
	('2018110611420099138276', '2018110215571954862401', '2018-11-06 11:42:00', 1, '购买商品时，获取了1个金币', 1),
	('2018110918094927721675', '2018110215571954862401', '2018-11-09 18:09:49', 39, '购买商品时，获取了39个金币', 1);
/*!40000 ALTER TABLE `px_jinbrecord` ENABLE KEYS */;


-- 导出  表 shopnet.px_notice 结构
CREATE TABLE IF NOT EXISTS `px_notice` (
  `notice_id` varchar(100) NOT NULL,
  `worker_id` varchar(100) DEFAULT NULL,
  `notice_content` varchar(255) DEFAULT NULL,
  `notice_title` varchar(100) DEFAULT NULL,
  `notice_time` varchar(20) DEFAULT NULL,
  `notice_type` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`notice_id`),
  KEY `FKF2F52CEFB34F815F` (`worker_id`),
  CONSTRAINT `FKF2F52CEFB34F815F` FOREIGN KEY (`worker_id`) REFERENCES `px_worker` (`worker_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  shopnet.px_notice 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `px_notice` DISABLE KEYS */;
INSERT INTO `px_notice` (`notice_id`, `worker_id`, `notice_content`, `notice_title`, `notice_time`, `notice_type`) VALUES
	('2018102410411272829855', 'admin', '<p>\r\n	11/6-11/12举行双十一大促销活动</p>\r\n', '双十一大促销', '2018-10-24 10:39:23', '2'),
	('2018102410435122485666', 'admin', '<p>\r\n	10/25-11/5举行双十一提前预定活动</p>\r\n', '双十一提前预定', '2018-10-24 10:42:42', '1');
/*!40000 ALTER TABLE `px_notice` ENABLE KEYS */;


-- 导出  表 shopnet.px_orderdetail 结构
CREATE TABLE IF NOT EXISTS `px_orderdetail` (
  `order_detail_id` varchar(100) NOT NULL,
  `order_id` varchar(100) DEFAULT NULL,
  `goods_id` varchar(100) DEFAULT NULL,
  `goods_number` int(11) DEFAULT NULL,
  `goods_color` varchar(255) DEFAULT NULL,
  `goods_attr` varchar(200) DEFAULT NULL,
  `order_detail_isCom` int(11) DEFAULT NULL,
  `is_accept` int(11) DEFAULT NULL,
  `accept_time` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`order_detail_id`),
  KEY `FKF6C00D68148D8997` (`goods_id`),
  KEY `FKF6C00D68D0F0BDF5` (`order_id`),
  CONSTRAINT `FKF6C00D68148D8997` FOREIGN KEY (`goods_id`) REFERENCES `px_goodslisting` (`goods_id`),
  CONSTRAINT `FKF6C00D68D0F0BDF5` FOREIGN KEY (`order_id`) REFERENCES `px_orders` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  shopnet.px_orderdetail 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `px_orderdetail` DISABLE KEYS */;
INSERT INTO `px_orderdetail` (`order_detail_id`, `order_id`, `goods_id`, `goods_number`, `goods_color`, `goods_attr`, `order_detail_isCom`, `is_accept`, `accept_time`) VALUES
	('2018110216404525740243', '2018110216404543365732', '2018102615125463135465', 1, '红色', NULL, 1, 1, '2018-11-05 18:23:24'),
	('2018110611420083944566', '2018110611420016302989', '2018102615125463135465', 1, '红色', NULL, 0, 0, NULL),
	('2018110918094999971667', '2018110918094993177753', '2018110913134634962360', 1, '宝石蓝', '64G', 0, 0, NULL);
/*!40000 ALTER TABLE `px_orderdetail` ENABLE KEYS */;


-- 导出  表 shopnet.px_orders 结构
CREATE TABLE IF NOT EXISTS `px_orders` (
  `order_id` varchar(100) NOT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `worker_id` varchar(100) DEFAULT NULL,
  `orderState_id` varchar(100) DEFAULT NULL,
  `order_phone` varchar(20) DEFAULT NULL,
  `order_address` varchar(100) DEFAULT NULL,
  `order_price` float DEFAULT NULL,
  `order_date` varchar(20) DEFAULT NULL,
  `order_consignee` varchar(255) DEFAULT NULL,
  `order_postalcode` varchar(10) DEFAULT NULL,
  `order_payment` varchar(20) DEFAULT NULL,
  `order_userRequire` varchar(200) DEFAULT NULL,
  `order_freight` float DEFAULT NULL,
  `order_send` varchar(20) DEFAULT NULL,
  `order_over` varchar(20) DEFAULT NULL,
  `jinB_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `FKF4CCF8FCD4C80C9F` (`orderState_id`),
  KEY `FKF4CCF8FC7EEEB312` (`user_id`),
  KEY `FKF4CCF8FCB34F815F` (`worker_id`),
  CONSTRAINT `FKF4CCF8FC7EEEB312` FOREIGN KEY (`user_id`) REFERENCES `px_users` (`user_id`),
  CONSTRAINT `FKF4CCF8FCB34F815F` FOREIGN KEY (`worker_id`) REFERENCES `px_worker` (`worker_id`),
  CONSTRAINT `FKF4CCF8FCD4C80C9F` FOREIGN KEY (`orderState_id`) REFERENCES `px_orderstate` (`orderState_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  shopnet.px_orders 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `px_orders` DISABLE KEYS */;
INSERT INTO `px_orders` (`order_id`, `user_id`, `worker_id`, `orderState_id`, `order_phone`, `order_address`, `order_price`, `order_date`, `order_consignee`, `order_postalcode`, `order_payment`, `order_userRequire`, `order_freight`, `order_send`, `order_over`, `jinB_num`) VALUES
	('2018110216404543365732', '2018110215571954862401', NULL, '500004', '18217727935', '上海,普陀,普陀,中江路388号', 259, '2018-11-02 16:40:45', '宫台', '200044', '0', '周六周天派送', 0, NULL, NULL, 0),
	('2018110611420016302989', '2018110215571954862401', NULL, '500002', '13612345600', '上海,宝山,宝山,锦秋路1188号', 135, '2018-11-06 11:42:00', '二郎', '200444', '2', '选填,可以告诉我们您对订单的特殊要求', 10, NULL, NULL, 0),
	('2018110918094993177753', '2018110215571954862401', NULL, '500003', '13612345600', '上海,宝山,宝山,锦秋路1188号', 3999, '2018-11-09 18:09:49', '二郎', '200444', '0', '选填,可以告诉我们您对订单的特殊要求', 0, NULL, NULL, 0);
/*!40000 ALTER TABLE `px_orders` ENABLE KEYS */;


-- 导出  表 shopnet.px_orderstate 结构
CREATE TABLE IF NOT EXISTS `px_orderstate` (
  `orderState_id` varchar(100) NOT NULL,
  `orderState_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`orderState_id`),
  KEY `FK63A6509AD4C80C9F` (`orderState_id`),
  CONSTRAINT `FK63A6509AD4C80C9F` FOREIGN KEY (`orderState_id`) REFERENCES `px_orderstate` (`orderState_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  shopnet.px_orderstate 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `px_orderstate` DISABLE KEYS */;
INSERT INTO `px_orderstate` (`orderState_id`, `orderState_name`) VALUES
	('500000', '所有'),
	('500001', '待发货'),
	('500002', '待收货'),
	('500003', '待付款'),
	('500004', '已收货'),
	('500005', '已取消'),
	('500006', '');
/*!40000 ALTER TABLE `px_orderstate` ENABLE KEYS */;


-- 导出  表 shopnet.px_position 结构
CREATE TABLE IF NOT EXISTS `px_position` (
  `position_id` varchar(100) NOT NULL,
  `position_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`position_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  shopnet.px_position 的数据：~5 rows (大约)
/*!40000 ALTER TABLE `px_position` DISABLE KEYS */;
INSERT INTO `px_position` (`position_id`, `position_name`) VALUES
	('000002', '仓库管理员'),
	('000003', '商品管理员'),
	('000004', '订单处理员'),
	('000005', '商品配送员'),
	('100001', '管理员');
/*!40000 ALTER TABLE `px_position` ENABLE KEYS */;


-- 导出  表 shopnet.px_secretsecurity 结构
CREATE TABLE IF NOT EXISTS `px_secretsecurity` (
  `secret_id` varchar(100) NOT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `asecret_question` varchar(100) DEFAULT NULL,
  `secret_answer` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`secret_id`),
  KEY `FKFF89A5077EEEB312` (`user_id`),
  CONSTRAINT `FKFF89A5077EEEB312` FOREIGN KEY (`user_id`) REFERENCES `px_users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  shopnet.px_secretsecurity 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `px_secretsecurity` DISABLE KEYS */;
INSERT INTO `px_secretsecurity` (`secret_id`, `user_id`, `asecret_question`, `secret_answer`) VALUES
	('2018110514115614164539', '2018110215571954862401', '您母亲的生日是？', '1229'),
	('2018110514115660488876', '2018110215571954862401', '您父亲的生日是？', '1101'),
	('2018110514115689603172', '2018110215571954862401', '您配偶的生日是？', '0926');
/*!40000 ALTER TABLE `px_secretsecurity` ENABLE KEYS */;


-- 导出  表 shopnet.px_shoppingcar 结构
CREATE TABLE IF NOT EXISTS `px_shoppingcar` (
  `car_id` varchar(100) NOT NULL,
  `goods_number` int(11) DEFAULT NULL,
  `goods_color` varchar(255) DEFAULT NULL,
  `goods_attr` varchar(200) DEFAULT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `goods_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`car_id`),
  KEY `FK3446D5B57EEEB312` (`user_id`),
  KEY `FK3446D5B5148D8997` (`goods_id`),
  CONSTRAINT `FK3446D5B5148D8997` FOREIGN KEY (`goods_id`) REFERENCES `px_goodslisting` (`goods_id`),
  CONSTRAINT `FK3446D5B57EEEB312` FOREIGN KEY (`user_id`) REFERENCES `px_users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  shopnet.px_shoppingcar 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `px_shoppingcar` DISABLE KEYS */;
INSERT INTO `px_shoppingcar` (`car_id`, `goods_number`, `goods_color`, `goods_attr`, `user_id`, `goods_id`) VALUES
	('2018110917182884717552', 1, '玫瑰金', '64G', '2018110215571954862401', '2018102915302169570603');
/*!40000 ALTER TABLE `px_shoppingcar` ENABLE KEYS */;


-- 导出  表 shopnet.px_storage 结构
CREATE TABLE IF NOT EXISTS `px_storage` (
  `storage_id` varchar(100) NOT NULL,
  `storage_name` varchar(50) DEFAULT NULL,
  `storage_address` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`storage_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  shopnet.px_storage 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `px_storage` DISABLE KEYS */;
INSERT INTO `px_storage` (`storage_id`, `storage_name`, `storage_address`) VALUES
	('200001', '北京', '长安街100号'),
	('200002', '上海', '南京路101号'),
	('200003', '广州', '白云路99号');
/*!40000 ALTER TABLE `px_storage` ENABLE KEYS */;


-- 导出  表 shopnet.px_style 结构
CREATE TABLE IF NOT EXISTS `px_style` (
  `style_id` varchar(100) NOT NULL,
  `style_name` varchar(100) DEFAULT NULL,
  `category_id` varchar(100) DEFAULT NULL,
  `brand_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`style_id`),
  KEY `FKE716E8BA3F7C8C1F` (`category_id`),
  KEY `FKE716E8BA85242755` (`brand_id`),
  CONSTRAINT `FKE716E8BA3F7C8C1F` FOREIGN KEY (`category_id`) REFERENCES `px_category` (`category_id`),
  CONSTRAINT `FKE716E8BA85242755` FOREIGN KEY (`brand_id`) REFERENCES `px_brand` (`brand_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  shopnet.px_style 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `px_style` DISABLE KEYS */;
INSERT INTO `px_style` (`style_id`, `style_name`, `category_id`, `brand_id`) VALUES
	('300001', '詹姆斯款', '200001', '400004'),
	('300002', '欧文款', '200001', '400001'),
	('300003', '李宁款', '200001', '400002'),
	('300004', 'iphone x', '200002', '400005'),
	('300005', 'iphone xr', '200002', '400005'),
	('300006', '宝马X5', '200009', '400012'),
	('300007', '奔驰GLA', '200009', '400011'),
	('300008', 'HUAWEI Mate 20', '200002', '400013'),
	('300009', '三星Note9', '200002', '400010'),
	('300010', '炭烧腰果', '200005', '400008'),
	('300011', '红富士1号', '200007', '400014');
/*!40000 ALTER TABLE `px_style` ENABLE KEYS */;


-- 导出  表 shopnet.px_users 结构
CREATE TABLE IF NOT EXISTS `px_users` (
  `user_id` varchar(100) NOT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `user_password` varchar(100) DEFAULT NULL,
  `user_email` varchar(50) DEFAULT NULL,
  `user_birthday` varchar(23) DEFAULT NULL,
  `user_sex` varchar(4) DEFAULT NULL,
  `user_realName` varchar(10) DEFAULT NULL,
  `user_address` varchar(100) DEFAULT NULL,
  `user_telephone` varchar(15) DEFAULT NULL,
  `is_active` int(11) DEFAULT NULL,
  `check_code` varchar(20) DEFAULT NULL,
  `email_date` varchar(50) DEFAULT NULL,
  `jinB` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  shopnet.px_users 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `px_users` DISABLE KEYS */;
INSERT INTO `px_users` (`user_id`, `user_name`, `user_password`, `user_email`, `user_birthday`, `user_sex`, `user_realName`, `user_address`, `user_telephone`, `is_active`, `check_code`, `email_date`, `jinB`) VALUES
	('2018102317475516927619', '章子怡', 'WOR/zQCSYS9s7wrMYddPgA==', '1024553405@qq.com', NULL, NULL, NULL, NULL, NULL, 1, '63740686', '2018-10-23 17:48:21', 0),
	('2018110215202170317418', 'happy123', 'ZIYFwRvblV4W5/68jbVBAw==', '123456@qq.com', NULL, NULL, NULL, NULL, NULL, 0, '69904476', '2018-11-02 15:20:59', 0),
	('2018110215571954862401', 'test', '4QrcOUm6Wau+VuBX8g+IPg==', '123@qq.com', '2005-11-01', '男', '大郎', '广东省,广州市,null,幸福大街100号', NULL, 0, '90863570', '2018-11-02 15:57:28', 40);
/*!40000 ALTER TABLE `px_users` ENABLE KEYS */;


-- 导出  表 shopnet.px_worker 结构
CREATE TABLE IF NOT EXISTS `px_worker` (
  `worker_id` varchar(100) NOT NULL,
  `position_id` varchar(100) DEFAULT NULL,
  `worker_name` varchar(20) DEFAULT NULL,
  `worker_IDCard` varchar(20) DEFAULT NULL,
  `worker_phone` varchar(15) DEFAULT NULL,
  `worker_address` varchar(100) DEFAULT NULL,
  `worker_password` varchar(20) DEFAULT NULL,
  `worker_image` varchar(200) DEFAULT NULL,
  `worker_birthday` varchar(20) DEFAULT NULL,
  `entry_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`worker_id`),
  KEY `FK24FE995532983F` (`position_id`),
  CONSTRAINT `FK24FE995532983F` FOREIGN KEY (`position_id`) REFERENCES `px_position` (`position_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  shopnet.px_worker 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `px_worker` DISABLE KEYS */;
INSERT INTO `px_worker` (`worker_id`, `position_id`, `worker_name`, `worker_IDCard`, `worker_phone`, `worker_address`, `worker_password`, `worker_image`, `worker_birthday`, `entry_time`) VALUES
	('18217727935', '000003', '大郎', '360124199001011123', NULL, NULL, '111111', NULL, '1995-09-07', '2018-10-08'),
	('admin', '100001', '宫台', '360124199001011122', '13612345600', '北京市长安街100号', '112233', '/images/photo/worker/标志制图.jpg', '1992-10-03', '2018-10-03');
/*!40000 ALTER TABLE `px_worker` ENABLE KEYS */;


-- 导出  表 shopnet.style_brand 结构
CREATE TABLE IF NOT EXISTS `style_brand` (
  `brand_id` varchar(100) NOT NULL,
  `style_id` varchar(100) NOT NULL,
  PRIMARY KEY (`brand_id`,`style_id`),
  KEY `FK1E70379FEADFF15` (`style_id`),
  KEY `FK1E7037985242755` (`brand_id`),
  CONSTRAINT `FK1E7037985242755` FOREIGN KEY (`brand_id`) REFERENCES `px_brand` (`brand_id`),
  CONSTRAINT `FK1E70379FEADFF15` FOREIGN KEY (`style_id`) REFERENCES `px_style` (`style_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  shopnet.style_brand 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `style_brand` DISABLE KEYS */;
/*!40000 ALTER TABLE `style_brand` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
