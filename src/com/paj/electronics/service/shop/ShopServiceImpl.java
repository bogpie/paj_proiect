package com.paj.electronics.service.shop;

import com.paj.electronics.domain.product.Category;
import com.paj.electronics.domain.product.Product;
import com.paj.electronics.domain.Shop;
import com.paj.electronics.domain.SortOrder;
import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ShopServiceImpl implements ShopService {
    private final Shop shop;

    @Override
    public Product findProductByName(String name) {
        return shop.getProducts()
                .stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Set<Product> findProductsByCategory(Category category) {
        return shop.getProducts()
                .stream()
                .filter(p -> p.getCategory().equals(category))
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public Set<Product> findProductsByPrice(double lowPrice, double highPrice) {
        return shop.getProducts()
                .stream()
                .filter(p -> (p.getPrice() >= lowPrice) && (p.getPrice() <= highPrice))
                .collect(Collectors.toUnmodifiableSet());
    }

    public <U extends Comparable<? super U>> SortedSet<Product> sortProductByCriteria(SortOrder sortOrder, Function<Product, ? extends U> comparingFunction) {
        return shop.getProducts()
                .stream()
                .collect(Collectors.toCollection(() -> new TreeSet<>(
                        compareBasedOnSortOrder(sortOrder, comparingFunction)))
                );
    }

    /**
     * Compares products based on the given sort order and comparing function.
     * By default, the sort order is ascending.
     *
     * @param <U>       the type of the comparable
     * @param sortOrder the sort order
     * @param f         the comparing function
     * @return the comparator
     */
    private <U extends Comparable<? super U>> Comparator<Product> compareBasedOnSortOrder(
            SortOrder sortOrder, Function<Product, ? extends U> f
    ) {
        if (null == sortOrder || SortOrder.ASCENDING.equals(sortOrder)) {
            return Comparator.comparing(f);
        }

        return Comparator.comparing(f).reversed();
    }
}
