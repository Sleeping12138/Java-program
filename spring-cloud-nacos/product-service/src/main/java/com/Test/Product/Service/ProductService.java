package com.Test.Product.Service;

import com.Test.Product.Mapper.ProductMapper;
import com.Test.Product.Model.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductMapper productMapper;

    public ProductInfo productSelectById(Integer productId){
        return productMapper.productSelectById(productId);
    }
}
