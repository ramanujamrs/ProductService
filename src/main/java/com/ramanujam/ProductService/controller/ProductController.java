package com.ramanujam.ProductService.controller;

import com.ramanujam.ProductService.model.ProductRequest;
import com.ramanujam.ProductService.model.ProductResponse;
import com.ramanujam.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    // Create the Business layer object
    @Autowired
    private ProductService productService;

    //Create the function to save product
    // Takes requestbody as parameter in form of object

    @PostMapping
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest) {

        //Call Service layer
        long productId = productService.addProduct(productRequest);
        return new ResponseEntity<>(productId, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") long productId) {
        ProductResponse productResponse
                = productService.getProductById(productId);

        return new ResponseEntity<>(productResponse,HttpStatus.OK);
    }

}
