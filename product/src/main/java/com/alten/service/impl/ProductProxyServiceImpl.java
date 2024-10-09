package com.alten.service.impl;

import com.alten.dto.ProductDto;
import com.alten.service.api.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class ProductProxyServiceImpl implements ProductService {

    private final ProductService productServiceImpl;

    public ProductProxyServiceImpl(@Qualifier( value = "productServiceImpl") ProductService productServiceImpl) {
        this.productServiceImpl = productServiceImpl;
    }

    @Override
    public Long createProduct(ProductDto productDto) {
        Long productId = this.productServiceImpl.createProduct(productDto);
        this.evictionCache();
        return productId;
    }

    @Override
    public ProductDto updateProductIfExiste(Long productId, ProductDto productDto) {
        ProductDto result = this.productServiceImpl.updateProductIfExiste(productId, productDto);
        this.evictionCache();
        return result;
    }

    @Override
    public void deleteProduct(Long productId) {
        this.productServiceImpl.deleteProduct(productId);
    }

    @Override
    public ProductDto findProductById(Long productId) {
        return this.productServiceImpl.findProductById(productId);
    }

    @Override
    public List<ProductDto> findAllProduct() {
        return this.productServiceImpl.findAllProduct();
    }

    @Override
    public void evictionCache() {
        this.productServiceImpl.evictionCache();
    }
}
