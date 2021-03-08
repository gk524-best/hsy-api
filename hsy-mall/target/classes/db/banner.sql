CREATE TABLE `banner` (
    `id` INT NOT NULL AUTO_INCREMENT COMMENT "自增ID",
    `name` VARCHAR(50) NOT NULL COMMENT "banner名称",
    `url` VARCHAR(255) NOT NULL COMMENT "banner链接",
    `img_url` VARCHAR(255) NOT NULL COMMENT "banner图片",
    `sort` INT NOT NULL COMMENT "排序值越大越靠前",
    `create_time` DATETIME  NOT NULL COMMENT "创建时间",
    `update_time` DATETIME NOT NULL COMMENT "更新时间",
    PRIMARY KEY(`id`)

) ENGINE=INNODB DEFAULT charset=utf8 COMMENT="首页banner";