package com.Test.order.Service;

import com.Test.Api.ProductApi;
import com.Test.order.Mapper.OrderMapper;
import com.Test.order.Model.OrderInfo;
import com.Test.order.Model.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ProductApi productApi;

//    public OrderInfo orderSelectById(Integer orderId){
//        OrderInfo orderInfo = orderMapper.orderSelectById(orderId);
//        ProductInfo productInfo = productApi.getProductInfo(orderInfo.getProductId());
//        orderInfo.setProductInfo(productInfo);
//
//        return orderInfo;
//    }
}
