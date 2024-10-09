package com.alten.controller.api;

import com.alten.dto.ProductDto;
import com.alten.service.api.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag( name = "product.api.service")
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(@Qualifier(value = "productProxyServiceImpl") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @Operation( summary = "product.list", description = "product.list.notes")
    public ResponseEntity<List<ProductDto>> getAllProduct(){
        return ResponseEntity.ok(productService.findAllProduct());
    }

    @GetMapping("/{id}")
    @Operation( summary = "find.product.service", description = "find.product.service.notes")
    public ResponseEntity<ProductDto> findProductById(@PathVariable("id") Long id){
        return ResponseEntity.ok(productService.findProductById(id));
    }

    @DeleteMapping("/{id}")
    @Operation( summary = "delete.product.service", description = "delete.product.service.notes")
    public ResponseEntity<Void> deleteProductById(@PathVariable("id") Long id){
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    @Operation( summary = "create.product.service", description = "create.product.service.notes")
    public ResponseEntity<Long> createProduct(@Valid @RequestBody ProductDto product){
        return new ResponseEntity<>(productService.createProduct(product) , HttpStatus.CREATED);
    }


    @PatchMapping("/{id}")
    @Operation( summary = "update.product.service", description = "update.product.service.notes")
    public ResponseEntity<ProductDto> updateProduct(
            @PathVariable("id") Long id,
            @RequestBody ProductDto productDto){
        return new ResponseEntity<>(productService.updateProductIfExiste(id,productDto),HttpStatus.ACCEPTED);
    }

}
