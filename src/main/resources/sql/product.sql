SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `batch_id` int(11) NOT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `company_id` int(11) DEFAULT NULL COMMENT '生产的公司编号',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
