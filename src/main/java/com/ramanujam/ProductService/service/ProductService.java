package com.ramanujam.ProductService.service;

import com.ramanujam.ProductService.model.ProductRequest;
import com.ramanujam.ProductService.model.ProductResponse;

public interface ProductService {
    long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(long productId);
}
