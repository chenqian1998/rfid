DROP TABLE IF EXISTS 'orders';
CREATE TABLE 'orders'(
    'order_id' int(11) NOT NULL AUTO_INCREMENT,
    'product_id' int(11) DEFAULT NULL,
    'create_date' datetime DEFAULT NULL COMMENT '此条记录写入的时间',
    'company_id' int(11) DEFAULT NULL,
    'status' int(2) COMMENT '生产:0, 发送:1, 接受2':
    PRIMARY KEY ('order_id')
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;