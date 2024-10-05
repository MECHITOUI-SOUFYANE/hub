package com.alten.entity;

import com.alten.enums.InventoryStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString()
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "image", length = 50)
    private String image;

    @Column(name = "category", nullable = false, length = 50)
    private String category;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "internal_reference", nullable = false)
    private String internalReference;

    @Column(name = "shell_id", nullable = false)
    private Long shellId;

    @Enumerated(EnumType.STRING)
    @Column(name = "inventory_status", nullable = false)
    private InventoryStatus inventoryStatus;

    @Column(name = "rating")
    private Double rating;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    @PrePersist
    public void prePersiste(){
        this.createdAt = new Date();
    }

    @PreUpdate
    public void preUpdate(){
        this.updatedAt = new Date();
    }

}
