package com.paj.electronics.domain;

import com.paj.electronics.domain.product.Product;
import com.paj.electronics.exceptions.InsufficientStockUnitsException;
import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class ShoppingCart {
    @Getter
    private final List<Item> items = new ArrayList<>();
    private final Map<Product, Item> productCartItemMap = new HashMap<>();

    public double getTotalCost() {
        return items
                .stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
    }

    public void addProductToCart(Product product) {
        Item item = new Item(product, 1);
        items.add(item);
        productCartItemMap.put(product, item);
    }

    public void updateProductQuantity(Product product, int newQuantity) throws InsufficientStockUnitsException {
        if (newQuantity > product.getStockUnits()) {
            throw new InsufficientStockUnitsException(
                String.format("Insufficient units of %s in stock.%nAvailable units: %d",
                    product.getName(),
                    product.getStockUnits())
            );
        }

        productCartItemMap.get(product).setQuantity(newQuantity);
    }

    public void removeProductFromCart(Product product) {
        items.remove(productCartItemMap.get(product));
        productCartItemMap.remove(product);
    }

    public void clearShoppingCart() {
        items.clear();
        productCartItemMap.clear();
    }

    public int getProductQuantity(Product product) {
        return productCartItemMap.get(product).getQuantity();
    }

    public boolean containsProduct(Product product) {
        return productCartItemMap.containsKey(product);
    }
}
