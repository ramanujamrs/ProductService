package com.ramanujam.ProductService.service;

import com.ramanujam.ProductService.entity.Product;
import com.ramanujam.ProductService.exception.ProductServiceCustomException;
import com.ramanujam.ProductService.model.ProductRequest;
import com.ramanujam.ProductService.model.ProductResponse;
import com.ramanujam.ProductService.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService{
    //We will need the object of the repository here since service implementation will call JPA to interact with DB
    @Autowired
    private ProductRepository productRepository;
    @Override
    public long addProduct(ProductRequest productRequest) {
        log.info("In Add product API");

        //Create Product object from productRequest using Builder pattern
        Product product
                = Product.builder()
                .productName(productRequest.getName())
                .quantity(productRequest.getQuantity())
                .price(productRequest.getPrice())
                .build();

        //Now use this Product object to persist in the DB
        productRepository.save(product);
        log.info("Added product");
        return product.getProductId();
    }

    @Override
    public ProductResponse getProductById(long productId) {
        //Get the Product from repository
        Product product
                =productRepository.findById(productId)
                .orElseThrow(
                        ()-> new ProductServiceCustomException("Product not found","PRODUCT_NOT_FOUND"));
        //Convert the product to ProductResponse to get back to the controller
        ProductResponse productResponse
            = new ProductResponse();
        //Use Beanutils to copy product to productResponse object
        BeanUtils.copyProperties(product,productResponse);
        //Return productResponse back to controller
        return productResponse;
    }
}
