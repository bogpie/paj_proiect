package com.paj.electronics.service.shop;

import com.paj.electronics.domain.product.Category;
import com.paj.electronics.domain.product.Product;
import com.paj.electronics.domain.SortOrder;

import java.util.Set;
import java.util.SortedSet;
import java.util.function.Function;

public interface ShopService {
    Product findProductByName(String name);

    Set<Product> findProductsByCategory(Category category);

    Set<Product> findProductsByPrice(double lowPrice, double highPrice);


    /**
     * Concretly used as a sorted set of products with a specific order
     * based on a comparing function on the product
     */
    <U extends Comparable<? super U>> SortedSet<Product>
    sortProductByCriteria(
            SortOrder sortOrder,
            Function<Product, ? extends U> comparingFunction
    );
}
