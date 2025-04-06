package com.Test.order.Service;

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

    public OrderInfo orderSelectById(Integer orderId){
        OrderInfo orderInfo = orderMapper.orderSelectById(orderId);

        String url = "http://product-service/product/"+orderInfo.getProductId();
        ProductInfo productInfo = restTemplate.getForObject(url, ProductInfo.class);
        orderInfo.setProductInfo(productInfo);

        return orderInfo;
    }
}
