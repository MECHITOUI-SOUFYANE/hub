package com.alten.service.impl;

import com.alten.configuration.CustomKeyGenerator;
import com.alten.configuration.LocalResolverConfiguration;
import com.alten.dao.AbstractDao;
import com.alten.dao.ProductRepository;
import com.alten.dto.ProductDto;
import com.alten.entity.Product;
import com.alten.exception.ProductException;
import com.alten.exception.ProductNotFoundException;
import com.alten.mapper.ProductMapper;
import com.alten.service.api.ProductService;
import com.alten.utils.UtilsHelper;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final AbstractDao<Product> abstractDao;
    private static final String CACHE_NAME = "products";

    @Override
    @Transactional
    public Long createProduct(ProductDto productDto) {
        Product product = productMapper.mapToEntity(productDto);
        return Optional.of(productRepository.save(product))
                .map(Product::getId)
                .orElseThrow(() -> new ProductException(LocalResolverConfiguration.getMessage("product.creation.exception", productDto.getName())));
    }

    @Override
    @CachePut(cacheNames = CACHE_NAME, key = "#p0")
    @Transactional
    public ProductDto updateProductIfExiste(Long productId, ProductDto productDto) {
        return productRepository.findById(productId)
                .map(product -> UtilsHelper.mergeValues(productDto, product))
                .map(abstractDao::update)
                .map(productMapper::mapToDto)
                .orElseThrow(ProductNotFoundException::new);
    }

    @Override
    @CacheEvict( cacheNames = CACHE_NAME , key = "#p0")
    @Transactional
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    @Cacheable(cacheNames = CACHE_NAME,  key = "#p0", unless = "#result == null")
    @Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true)
    public ProductDto findProductById(Long productId) {
        return productRepository.findById(productId)
                .map(productMapper::mapToDto)
                .orElseThrow(ProductNotFoundException::new);
    }

    @Override
    @Cacheable(cacheNames = CACHE_NAME,  keyGenerator = CustomKeyGenerator.KEY_GENERATOR_NAME)
    @Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true)
    public List<ProductDto> findAllProduct() {
        // Anti-pattern
        return productRepository.findAll()
                .stream()
                .map(productMapper::mapToDto)
                .toList();
    }

    @Override
    @CacheEvict( cacheNames = CACHE_NAME , allEntries = true)
    public void evictionCache() {
    }
}
