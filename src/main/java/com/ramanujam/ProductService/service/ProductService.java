package com.ramanujam.ProductService.service;

import com.ramanujam.ProductService.model.ProductRequest;

public interface ProductService {
    long addProduct(ProductRequest productRequest);
}
