package com.Test.Product.Controller;

import com.Test.Product.Model.ProductInfo;
import com.Test.Product.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/{productId}")
    public ProductInfo getProductById(@PathVariable("productId") Integer productId) {
        return productService.productSelectById(productId);
    }

    @RequestMapping("/p1")
    public Integer p1(Integer number) {
        return number;
    }

    @RequestMapping("/p2")
    public String p2(Integer number, String str) {
        return str + "-----" + number;
    }

    @RequestMapping("/p3")
    public String p3(ProductInfo productInfo){
        return productInfo.toString();
    }

    @RequestMapping("/p4")
    public String p4(@RequestBody ProductInfo productInfo){
        return productInfo.toString();
    }
}
