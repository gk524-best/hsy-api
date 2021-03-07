package com.hsy.mall.entry.vo;

/**
 * TODO
 *
 * @author gk on 2021/3/7 19:00
 */
public class CategoryVo {
    private Integer id;

    private String  name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CategoryVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
