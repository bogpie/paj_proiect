package com.paj.electronics.test;

import com.paj.electronics.domain.Category;
import com.paj.electronics.domain.Color;
import com.paj.electronics.domain.Laptop;
import com.paj.electronics.domain.Mobile;

public class ProductFixtures {
  private ProductFixtures() {}

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
}
