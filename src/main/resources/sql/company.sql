DROP TABLE IF EXISTS `company`;
CREATE TABLE `company`(
    `company_id` int(11) NOT NULL AUTO_INCREMENT,
    `company_name` varchar(255) DEFAULT NULL
    PRIMARY KEY (`company_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;