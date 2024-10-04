package com.alten.dto;

import com.alten.enums.InventoryStatus;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private Long id;
    @NonNull
    private String code;
    @NonNull
    private String name;
    private String description;
    @NonNull
    private String image;
    @NonNull
    private String category;
    @NonNull
    private BigDecimal price;
    @NonNull
    private Integer quantity;
    private String internalReference;
    private Long shellId;
    private InventoryStatus inventoryStatus;
    private Double rating;
    @NonNull
    private Date createdAt;
    @NonNull
    private Date updatedAt;
}
