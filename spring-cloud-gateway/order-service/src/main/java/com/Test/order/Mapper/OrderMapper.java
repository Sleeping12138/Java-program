package com.Test.order.Mapper;

import com.Test.order.Model.OrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrderMapper {
    @Select("select * from order_detail where id = #{orderId}")
    OrderInfo orderSelectById(Integer orderId);
}
