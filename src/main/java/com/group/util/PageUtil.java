package com.group.util;

import java.util.List;

public class PageUtil<T> {
    private int totalCount;
    private int pageSize;
    private int item;
    private int pageNo;
    private int maxPage;
    private List<T> tList;

    public PageUtil() {
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getItem() {
        return (pageNo-1)*pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getMaxPage() {
        return (int) Math.ceil((double)totalCount/(double)pageSize);
    }


    public List<T> gettList() {
        return tList;
    }

    public void settList(List<T> tList) {
        this.tList = tList;
    }

    @Override
    public String toString() {
        return "PageUtil{" +
                "totalCount=" + totalCount +
                ", pageSize=" + pageSize +
                ", item=" + item +
                ", pageNo=" + pageNo +
                ", maxPage=" + maxPage +
                ", tList=" + tList +
                '}';
    }
}
