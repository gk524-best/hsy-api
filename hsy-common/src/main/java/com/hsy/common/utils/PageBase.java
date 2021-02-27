package com.hsy.common.utils;

import java.util.List;

/**
　* 分页信息
　* @author gk on 2021/2/27 下午11:08
　*/
public class PageBase<T> {

    private long total;

    private List<T> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
