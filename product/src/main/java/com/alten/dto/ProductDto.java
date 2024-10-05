package com.alten.dto;

import com.alten.enums.InventoryStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "product.dto.description")
public class ProductDto implements Serializable {

    @Schema(description = "product.id")
    private Long id;
    @NotNull
    @Schema(description = "product.code", requiredMode = Schema.RequiredMode.REQUIRED)
    private String code;
    @NotNull
    @Schema(description = "product.name", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;
    @Schema(description = "product.description")
    private String description;
    @NotNull
    @Schema(description = "product.image", requiredMode = Schema.RequiredMode.REQUIRED)
    private String image;
    @NotNull
    @Schema(description = "product.category", requiredMode = Schema.RequiredMode.REQUIRED)
    private String category;
    @NotNull
    @Schema(description = "product.price", requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal price;
    @NotNull
    @Schema(description = "product.quantity", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer quantity;
    @Schema(description = "product.internalReference")
    private String internalReference;
    @Schema(description = "product.shellId")
    private Long shellId;
    @Schema(description = "product.inventoryStatus", requiredMode = Schema.RequiredMode.REQUIRED)
    private InventoryStatus inventoryStatus;
    @Schema(description = "product.rating")
    private Double rating;
    @Schema(description = "product.createdAt")
    private Date createdAt;
    @Schema(description = "product.updatedAt")
    private Date updatedAt;
}
