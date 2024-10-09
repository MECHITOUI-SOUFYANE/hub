package com.alten.service.api;

import com.alten.dto.ProductDto;

import java.util.List;

public interface ProductService {
    Long createProduct(ProductDto productDto);
    ProductDto updateProductIfExiste(Long productId , ProductDto productDto);
    void deleteProduct(Long productId);
    ProductDto findProductById(Long productId);
    List<ProductDto> findAllProduct();

    void evictionCache();
}
