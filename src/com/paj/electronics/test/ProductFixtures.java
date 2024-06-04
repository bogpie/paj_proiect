package com.paj.electronics.test;

import com.paj.electronics.domain.product.Category;
import com.paj.electronics.domain.product.Color;
import com.paj.electronics.domain.product.GraphicalCard;
import com.paj.electronics.domain.product.Laptop;
import com.paj.electronics.domain.product.Mobile;

public class ProductFixtures {
    private ProductFixtures() {
    }

    public static Laptop getLaptopProduct() {
        return Laptop.builder()
                .SKU("123")
                .category(Category.LAPTOP)
                .name("ASUS ROG Strix")
                .price(12000.0)
                .stockUnits(50)
                .color(Color.BLACK)
                .gSync(true)
                .recommendedForGaming(true)
                .RAM(32)
                .diagonal(15.6)
                .build();
    }

    public static Mobile getMobileProduct() {
        return Mobile.builder()
                .SKU("1235")
                .category(Category.MOBILE)
                .name("Samsung Galaxy S23 Ultra")
                .price(6449.50)
                .stockUnits(10)
                .color(Color.GREEN)
                .build();
    }

    public static GraphicalCard getGraphicalCardProduct() {
        return GraphicalCard.builder()
                .SKU("12345")
                .category(Category.GRAPHICAL_CARD)
                .name("NVIDIA GeForce RTX 3090")
                .price(20000.0)
                .stockUnits(5)
                .color(Color.BLACK)
                .chipsetSupplier("NVIDIA")
                .shaderUnits(10496)
                .cudaCores(12)
                .build();
    }
}
