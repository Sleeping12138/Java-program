package com.test.librarymanagementsystem.Model;

import lombok.Data;

@Data
public class PageRequest {
    // 当前页数
    private Integer currentPage = 1;
    // 一页展示的个数
    private Integer pageSize = 10;
}
