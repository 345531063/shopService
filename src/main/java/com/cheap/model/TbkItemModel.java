package com.cheap.model;

import lombok.Data;

@Data
public class TbkItemModel {

    public String q;

    public Boolean isTmall = false;

    public  Boolean isOverseas = false;

    public Long platform = 2L;

    public  Long  pageNo = 1L;

    public  Long pageSize = 20L;

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public Boolean getTmall() {
        return isTmall;
    }

    public void setTmall(Boolean tmall) {
        isTmall = tmall;
    }

    public Boolean getOverseas() {
        return isOverseas;
    }

    public void setOverseas(Boolean overseas) {
        isOverseas = overseas;
    }

    public Long getPlatform() {
        return platform;
    }

    public void setPlatform(Long platform) {
        this.platform = platform;
    }

    public Long getPageNo() {
        return pageNo;
    }

    public void setPageNo(Long pageNo) {
        this.pageNo = pageNo;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }
}
