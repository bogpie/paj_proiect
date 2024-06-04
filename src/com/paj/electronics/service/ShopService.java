package com.paj.electronics.service;

import com.paj.electronics.domain.Category;
import com.paj.electronics.domain.Product;
import com.paj.electronics.domain.SortOrder;

import java.util.Set;
import java.util.SortedSet;
import java.util.function.Function;

public interface ShopService {
  Product findProductByName(String name);
  Set<Product> findProductsByCategory(Category category);
  Set<Product> findProductsByPrice(double lowPrice, double highPrice);
  <U extends Comparable<? super U>> SortedSet<Product> sortProductByCriteria(SortOrder sortOrder, Function<Product, ? extends U> comparingFunction);
}
