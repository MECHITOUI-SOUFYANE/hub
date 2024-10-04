package com.alten.mapper;

import com.alten.dto.ProductDto;
import com.alten.entity.Product;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.InheritMaps;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

import java.util.List;

@Mapper(
        withIoC = IoC.SPRING,
        withIgnoreMissing = IgnoreMissing.ALL
)
public interface ProductMapper {
    Product mapToEntity(ProductDto productDto);
    ProductDto mapToDto(Product product);
    @InheritMaps(method = "mapToDto")
    List<ProductDto> mapToListDto(List<Product> products);

    Product cloneProduct(ProductDto productDto , Product product);
}
