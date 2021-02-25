package com.hsy.mall.entry;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.hsy.common.utils.ValidationGroup;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * TODO
 *
 * @author DELL
 * @date 2021/2/2517:15
 */
public class Banner {
    @TableId(type = IdType.AUTO)
    @NotBlank(message = "id不能为空", groups = ValidationGroup.Update.class)
    private Integer id;

    @NotBlank(message = "banner名称不能为空")
    private String Name;

    @NotBlank(message = "banner链接不能为空")
    private String url;

    @NotBlank(message = "banner图片地址不能为空")
    private String imgUrl;

    private Integer sort;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", url='" + url + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", sort=" + sort +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
