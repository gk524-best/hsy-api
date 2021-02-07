package com.hsy.manager.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

/**
 * TODO
 *
 * @author zhangbingbing
 * @date 2021/1/31 上午12:09
 */
public class User {
    
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String  username;
    private String  password;
    private Date    createTime;
    private Date    updateTime;
}
