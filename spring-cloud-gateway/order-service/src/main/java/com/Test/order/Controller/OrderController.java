package com.Test.order.Controller;

import com.Test.Api.ProductApi;
import com.Test.Model.ProductInfo;
import com.Test.order.Model.OrderInfo;
import com.Test.order.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductApi productApi;

//    @RequestMapping("/{orderId}")
//    public OrderInfo getOrderById(@PathVariable("orderId") Integer orderId){
//        return orderService.orderSelectById(orderId);
//    }

    @RequestMapping("/o1")
    public Integer p1(Integer number) {
        return productApi.p1(number);
    }

    @RequestMapping("/o2")
    public String p2(Integer number, String str) {
        return productApi.p2(number, str);
    }

    @RequestMapping("/o3")
    public String p3() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setId(100);
        productInfo.setProductName("卫衣");
        return productApi.p3(productInfo);
    }

    @RequestMapping("/o4")
    public String p4(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setId(100);
        productInfo.setProductName("卫衣");
        return productApi.p3(productInfo);
    }
}
