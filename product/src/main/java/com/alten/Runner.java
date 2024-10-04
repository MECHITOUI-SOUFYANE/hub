package com.alten;

import com.alten.dto.ProductDto;
import com.alten.entity.Product;
import com.alten.enums.InventoryStatus;
import com.alten.service.api.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Runner {

    public static void main(String[] args) {
        SpringApplication.run(Runner.class,args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ProductService productService){
        return args -> getListProducts().forEach(productService::createProduct);
    }

    private List<ProductDto> getListProducts(){
        return List.of(
                ProductDto.builder()
                        .id(1L)
                        .code("P001")
                        .name("Smartphone X")
                        .description("Latest 5G smartphone with high-resolution camera")
                        .image("smartphoneX.jpg")
                        .category("Electronics")
                        .price(new BigDecimal("999.99"))
                        .quantity(100)
                        .internalReference("REF001")
                        .shellId(1001L)
                        .inventoryStatus(InventoryStatus.IN_STOCK)
                        .rating(4.8)
                        .createdAt(new Date())
                        .updatedAt(new Date())
                        .build(),

                ProductDto.builder()
                        .id(2L)
                        .code("P002")
                        .name("Wireless Earbuds")
                        .description("Noise-cancelling wireless earbuds with long battery life")
                        .image("earbuds.jpg")
                        .category("Electronics")
                        .price(new BigDecimal("199.99"))
                        .quantity(200)
                        .internalReference("REF002")
                        .shellId(1002L)
                        .inventoryStatus(InventoryStatus.IN_STOCK)
                        .rating(4.5)
                        .createdAt(new Date())
                        .updatedAt(new Date())
                        .build(),

                ProductDto.builder()
                        .id(3L)
                        .code("P003")
                        .name("Gaming Laptop")
                        .description("High-performance laptop with dedicated graphics card")
                        .image("gamingLaptop.jpg")
                        .category("Computers")
                        .price(new BigDecimal("1499.99"))
                        .quantity(50)
                        .internalReference("REF003")
                        .shellId(1003L)
                        .inventoryStatus(InventoryStatus.IN_STOCK)
                        .rating(4.7)
                        .createdAt(new Date())
                        .updatedAt(new Date())
                        .build(),

                ProductDto.builder()
                        .id(4L)
                        .code("P004")
                        .name("Smartwatch Pro")
                        .description("Advanced fitness tracking smartwatch with GPS")
                        .image("smartwatchPro.jpg")
                        .category("Wearables")
                        .price(new BigDecimal("299.99"))
                        .quantity(150)
                        .internalReference("REF004")
                        .shellId(1004L)
                        .inventoryStatus(InventoryStatus.IN_STOCK)
                        .rating(4.4)
                        .createdAt(new Date())
                        .updatedAt(new Date())
                        .build(),

                ProductDto.builder()
                        .id(5L)
                        .code("P005")
                        .name("Electric Toothbrush")
                        .description("Rechargeable electric toothbrush with multiple cleaning modes")
                        .image("toothbrush.jpg")
                        .category("Personal Care")
                        .price(new BigDecimal("49.99"))
                        .quantity(300)
                        .internalReference("REF005")
                        .shellId(1005L)
                        .inventoryStatus(InventoryStatus.IN_STOCK)
                        .rating(4.2)
                        .createdAt(new Date())
                        .updatedAt(new Date())
                        .build(),

                ProductDto.builder()
                        .id(6L)
                        .code("P006")
                        .name("4K Ultra HD TV")
                        .description("Large-screen TV with 4K resolution and HDR support")
                        .image("4ktv.jpg")
                        .category("Home Entertainment")
                        .price(new BigDecimal("799.99"))
                        .quantity(80)
                        .internalReference("REF006")
                        .shellId(1006L)
                        .inventoryStatus(InventoryStatus.IN_STOCK)
                        .rating(4.6)
                        .createdAt(new Date())
                        .updatedAt(new Date())
                        .build(),

                ProductDto.builder()
                        .id(7L)
                        .code("P007")
                        .name("Bluetooth Speaker")
                        .description("Portable Bluetooth speaker with deep bass")
                        .image("speaker.jpg")
                        .category("Audio")
                        .price(new BigDecimal("99.99"))
                        .quantity(500)
                        .internalReference("REF007")
                        .shellId(1007L)
                        .inventoryStatus(InventoryStatus.IN_STOCK)
                        .rating(4.3)
                        .createdAt(new Date())
                        .updatedAt(new Date())
                        .build(),

                ProductDto.builder()
                        .id(8L)
                        .code("P008")
                        .name("Fitness Tracker")
                        .description("Waterproof fitness tracker with heart rate monitoring")
                        .image("fitnessTracker.jpg")
                        .category("Wearables")
                        .price(new BigDecimal("79.99"))
                        .quantity(250)
                        .internalReference("REF008")
                        .shellId(1008L)
                        .inventoryStatus(InventoryStatus.IN_STOCK)
                        .rating(4.1)
                        .createdAt(new Date())
                        .updatedAt(new Date())
                        .build(),

                ProductDto.builder()
                        .id(9L)
                        .code("P009")
                        .name("Coffee Maker")
                        .description("Automatic coffee maker with built-in grinder")
                        .image("coffeeMaker.jpg")
                        .category("Kitchen Appliances")
                        .price(new BigDecimal("149.99"))
                        .quantity(120)
                        .internalReference("REF009")
                        .shellId(1009L)
                        .inventoryStatus(InventoryStatus.IN_STOCK)
                        .rating(4.5)
                        .createdAt(new Date())
                        .updatedAt(new Date())
                        .build(),

                ProductDto.builder()
                        .id(10L)
                        .code("P010")
                        .name("Air Fryer")
                        .description("Oil-free air fryer with digital controls")
                        .image("airFryer.jpg")
                        .category("Kitchen Appliances")
                        .price(new BigDecimal("129.99"))
                        .quantity(90)
                        .internalReference("REF010")
                        .shellId(1010L)
                        .inventoryStatus(InventoryStatus.IN_STOCK)
                        .rating(4.6)
                        .createdAt(new Date())
                        .updatedAt(new Date())
                        .build()
        );
    }
}
