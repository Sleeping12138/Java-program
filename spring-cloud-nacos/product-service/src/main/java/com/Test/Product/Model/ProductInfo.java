package com.Test.Product.Model;

import lombok.Data;

import java.util.Date;

@Data
public class ProductInfo {
    private Integer id;
    private String productName;
    private Integer productPrice;
    private Integer state;
    private Date createTime;
    private Date updateTime;
}
