CREATE TABLE `product` (
    `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `category_id` INT(11) NOT NULL COMMENT '分类ID',
    `name` VARCHAR(100) NOT NULL COMMENT '商品名称',
    `subtitle` VARCHAR(200) DEFAULT NULL COMMENT '商品副标题',
    `main_image` VARCHAR(500) DEFAULT NULL COMMENT '商品主图',
    `sub_images` TEXT COMMENT '商品图片地址，json格式',
    `detail` TEXT COMMENT '商品详情',
    `price` DECIMAL(20,2) NOT NULL COMMENT '价格',
    `stock` INT(11) NOT NULL COMMENT '库存',
    `status` INT(6) DEFAULT '1' COMMENT '商品状态 1 下架 2 上架',
    `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
    `update_time` DATETIME DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT charset=utf8 COMMENT='商品表'