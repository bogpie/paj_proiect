package com.paj.electronics.test.service;

import com.paj.electronics.domain.Category;
import com.paj.electronics.domain.Product;
import com.paj.electronics.domain.Shop;
import com.paj.electronics.domain.SortOrder;
import com.paj.electronics.service.ShopService;
import com.paj.electronics.service.ShopServiceImpl;
import com.paj.electronics.test.ProductFixtures;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;

import static org.junit.jupiter.api.Assertions.*;

public class ShopServiceImplTest {
  private Product p1, p2;
  private ShopService shopService;

  @BeforeEach
  public void setUp() {
    p1 = ProductFixtures.getLaptopProduct();
    p2 = ProductFixtures.getMobileProduct();
    Shop shop = new Shop();
    shop.addProducts(p1);
    shop.addProducts(p2);
    shopService = new ShopServiceImpl(shop);
  }

  @Test
  public void findProductByName() {
    Product searchedProduct = shopService.findProductByName("ASUS ROG Strix");
    assertEquals("ASUS ROG Strix", searchedProduct.getName());
  }

  @Test
  public void findProductByName_NotFound() {
    Product searchedProduct = shopService.findProductByName("ASUS ROG Strixx");
    assertNull(searchedProduct);
  }

  @Test
  public void findProductsByCategoryTest() {
    Set<Product> productSet = shopService.findProductsByCategory(Category.MOBILE);
    assertEquals(1, productSet.size());
    assertTrue(productSet.contains(p2));
  }

  @Test
  public void findProductsByPriceTest() {
    Set<Product> productSet = shopService.findProductsByPrice(10000.00, 13000.0);
    assertEquals(1, productSet.size());
    assertTrue(productSet.contains(p1));
  }

  @Test
  public void sortProductByCriteria_ColorDescending() {
    SortedSet<Product> sortedSet = shopService.sortProductByCriteria(SortOrder.DESCENDING, Product::getColor);
    assertEquals(List.of(p2, p1), new ArrayList<>(sortedSet));
  }

  @Test
  public void sortProductByCriteria_ColorAscending() {
    SortedSet<Product> sortedSet = shopService.sortProductByCriteria(SortOrder.ASCENDING, Product::getColor);
    assertEquals(List.of(p1, p2), new ArrayList<>(sortedSet));
  }

  @Test
  public void sortProductByCriteria_PriceAscending() {
    SortedSet<Product> sortedSet = shopService.sortProductByCriteria(SortOrder.ASCENDING, Product::getPrice);
    assertEquals(List.of(p2, p1), new ArrayList<>(sortedSet));
  }

  @Test
  public void sortProductByCriteria_PriceDescending() {
    SortedSet<Product> sortedSet = shopService.sortProductByCriteria(SortOrder.DESCENDING, Product::getPrice);
    assertEquals(List.of(p1, p2), new ArrayList<>(sortedSet));
  }
}
