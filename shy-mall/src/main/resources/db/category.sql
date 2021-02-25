CREATE TABLE `category` (
	`id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
	`category_name` VARCHAR(60) NOT NULL COMMENT '类型名称',
	`p_id` INT(11) DEFAULT NULL COMMENT '父级ID',
	`category_logo` VARCHAR(128) DEFAULT NULL COMMENT '类型logo',
	`description` VARCHAR(255) DEFAULT NULL COMMENT '描述',
    `category_level` TINYINT DEFAULT NULL COMMENT '类型等级',
	`sort` SMALLINT DEFAULT NULL COMMENT '同等级排序, 值越大越靠前',
	`create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
	`update_time` DATETIME DEFAULT NULL COMMENT '更新时间',
	PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT charset=utf8 COMMENT="商品分类";