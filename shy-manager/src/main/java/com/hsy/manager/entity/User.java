package com.hsy.manager.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 *
 * @Author gk
 * @Date Created in 2021/1/31 10:32
 * @Return
 */
public class User {

    @TableId(type=IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户名")
    private String  username;

    @ApiModelProperty(value = "密码")
    private String  password;

    @ApiModelProperty(value = "创建时间")
    private Date    createTime;

    @ApiModelProperty(value = "更新时间")
    private Date    updateTime;
}
