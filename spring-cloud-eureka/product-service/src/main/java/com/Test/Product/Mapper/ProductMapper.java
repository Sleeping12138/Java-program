package com.Test.Product.Mapper;

import com.Test.Product.Model.ProductInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ProductMapper {

    @Select("select * from product_detail where id = #{productId}")
    ProductInfo productSelectById(Integer productId);
}
