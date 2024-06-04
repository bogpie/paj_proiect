package com.paj.electronics.test.domain;

import com.paj.electronics.domain.*;
import com.paj.electronics.domain.product.Product;
import com.paj.electronics.exceptions.InsufficientStockUnitsException;
import com.paj.electronics.test.ProductFixtures;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {
    private ShoppingCart shoppingCart;
    private Product p1;

    @BeforeEach
    public void setUp() {
        shoppingCart = new ShoppingCart();
        p1 = ProductFixtures.getLaptopProduct();
        Product p2 = ProductFixtures.getMobileProduct();

        shoppingCart.addProductToCart(p1);
        shoppingCart.addProductToCart(p2);
    }

    @Test
    public void getTotalCostTest() {
        assertEquals(18449.50, shoppingCart.getTotalCost(), "Total costs is not computed correctly.");
    }

    @Test
    public void removeProductFromCartTest() {
        // when
        shoppingCart.removeProductFromCart(p1);
        // then
        assertFalse(shoppingCart.containsProduct(p1), "Shopping cart should not contain this product.");
        assertEquals(6449.50, shoppingCart.getTotalCost(), "Total costs is not computed correctly.");
    }

    @Test
    public void updateProductQuantityTest() throws InsufficientStockUnitsException {
        // when
        shoppingCart.updateProductQuantity(p1, 2);
        // then
        assertEquals(2, shoppingCart.getProductQuantity(p1), "Product quantity is different.");
        assertEquals(30449.50, shoppingCart.getTotalCost());
    }

    @Test
    public void updateProductQuantityTestInsufficientStockUnitsTest() {
        Exception exception = assertThrows(InsufficientStockUnitsException.class, () -> shoppingCart.updateProductQuantity(p1, 100));
        assertEquals("Insufficient units of ASUS ROG Strix in stock.\nAvailable units: 50", exception.getMessage(), "Exceptions don't match");
    }
}
