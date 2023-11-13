package com.ramanujam.ProductService.repository;

import com.ramanujam.ProductService.entity.Product;
import io.micrometer.observation.annotation.Observed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Observed
public interface ProductRepository extends JpaRepository<Product,Long> {
}
