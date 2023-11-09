package com.ramanujam.ProductService.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductRequest {
    @NotNull(message="Name cannot be null")
    @Size(min=5, max=30)
    private String name;

    @NotNull(message="Price cannot be null")
    private long price;

    @NotNull(message="Quantity cannot be null")
    @Min(1)
    private long quantity;
}
