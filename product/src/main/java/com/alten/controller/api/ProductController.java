package com.alten.controller.api;

import com.alten.dto.ProductDto;
import com.alten.entity.Product;
import com.alten.service.api.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProduct(){
        return ResponseEntity.ok(productService.findAllProduct());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> findProductById(@PathVariable("id") Long id){
        return ResponseEntity.ok(productService.findProductById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity.HeadersBuilder<?> deleteProductById(Long id){
        productService.deleteProduct(id);
        return ResponseEntity.noContent();
    }

    @PostMapping
    public ResponseEntity<Long> createProduct(@RequestBody ProductDto product){
        return new ResponseEntity<>(productService.createProduct(product) , HttpStatus.CREATED);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(
            @PathVariable("id") Long id,
            @RequestBody ProductDto productDto){
        return new ResponseEntity<>(productService.updateProductIfExiste(id,productDto),HttpStatus.ACCEPTED);
    }

}
