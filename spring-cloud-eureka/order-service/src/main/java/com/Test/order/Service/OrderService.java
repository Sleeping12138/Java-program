package com.Test.order.Service;

import com.Test.order.Mapper.OrderMapper;
import com.Test.order.Model.OrderInfo;
import com.Test.order.Model.ProductInfo;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Slf4j
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    // 计数器
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private List<ServiceInstance> instances;

    @PostConstruct
    public void init() {
        instances = discoveryClient.getInstances("product-service");
    }

    public OrderInfo orderSelectById(Integer orderId) {
        OrderInfo orderInfo = orderMapper.orderSelectById(orderId);

        int index = atomicInteger.getAndIncrement() % instances.size();
        String uri = instances.get(index).getUri().toString();

        String url = uri + "/product/" + orderInfo.getProductId();
        ProductInfo productInfo = restTemplate.getForObject(url, ProductInfo.class);
        log.info("url:" + url);
        orderInfo.setProductInfo(productInfo);

        return orderInfo;
    }
}
