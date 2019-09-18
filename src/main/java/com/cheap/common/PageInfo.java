package com.cheap.common;

import com.github.pagehelper.Page;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class PageInfo {

    // 当前页
    private int pageNum;

    // 每页条数
    private int pageSize;

    // 当前页开始行
    private  int startRow;

    // 当前页结束页
    private  int endRow;

    // 总条数
    private long total;

    // 总页数
    private int pages;

    /**
     * 包装Page对象
     *
     * @param list
     */
    public PageInfo(List list) {
        com.github.pagehelper.PageInfo pageInfo = new com.github.pagehelper.PageInfo<>(list);
        this.pageNum = pageInfo.getPageNum();
        this.pageSize = pageInfo.getPageSize();
        this.startRow = pageInfo.getStartRow();
        this.endRow = pageInfo.getEndRow();
        this.total = pageInfo.getTotal();
        this.pages = pageInfo.getPages();
    }

    /**
     * 包装Page对象,其中的total由参数传入
     *
     * @param list
     */
    public PageInfo(List list, Long total) {
        com.github.pagehelper.PageInfo pageInfo = new com.github.pagehelper.PageInfo<>(list);
        this.pageNum = pageInfo.getPageNum();
        this.pageSize = pageInfo.getPageSize();
        this.startRow = pageInfo.getStartRow();
        this.endRow = pageInfo.getEndRow();
        this.total = total;
        this.pages = pageInfo.getPages();
    }

}
