package com.paj.electronics.test.service;

import com.paj.electronics.domain.*;
import com.paj.electronics.domain.product.Category;
import com.paj.electronics.domain.product.Product;
import com.paj.electronics.domain.user.Client;
import com.paj.electronics.service.order.OrderServiceImpl;
import com.paj.electronics.service.shop.report.ShopReportServiceImpl;
import com.paj.electronics.service.shop.ShopService;
import com.paj.electronics.service.shop.ShopServiceImpl;
import com.paj.electronics.test.ClientFixtures;
import com.paj.electronics.test.ProductFixtures;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShopReportServiceImplTest {
    private ShopReportServiceImpl shopReportService;
    private Product p1;
    private Product p2;
    private Client client;
    private Order order;

    @BeforeEach
    public void setup() {
        p1 = ProductFixtures.getLaptopProduct();
        p2 = ProductFixtures.getMobileProduct();
        Product p3 = ProductFixtures.getGraphicalCardProduct();

        Shop shop = new Shop();
        shop.addProducts(p1);
        shop.addProducts(p2);
        shop.addProducts(p3);

        client = ClientFixtures.getClient();
        shop.addClient(client);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addProductToCart(p1);
        shoppingCart.addProductToCart(p2);
        OrderServiceImpl orderService = new OrderServiceImpl();
        client.setCart(shoppingCart);
        ShopService shopService = new ShopServiceImpl(shop);
        order = orderService.createOrder(client, shoppingCart);
        shopReportService = new ShopReportServiceImpl(shop);
    }

    @Test
    public void clientOrderHistoryTest() {
        Map<Client, Set<Order>> expectedOrderHistory = Map.of(client, Set.of(order));
        assertEquals(expectedOrderHistory, shopReportService.clientOrderHistory());
    }

    @Test
    public void getClientsByCityTest() {
        Map<String, Set<Client>> expectedClientsByCity = Map.of("Bucharest", Set.of(client));
        assertEquals(expectedClientsByCity, shopReportService.getClientsByCity());
    }

    @Test
    public void getClientsByCountryTest() {
        Map<String, Set<Client>> expectedClientsByCountry = Map.of("Romania", Set.of(client));
        assertEquals(expectedClientsByCountry, shopReportService.getClientsByCountry());
    }

    @Test
    public void getTotalNumberOfBoughtProductsPerCategoryTest() {
        Map<Category, Integer> expectedResult = Map.of(Category.MOBILE, 1, Category.LAPTOP, 1);
        assertEquals(expectedResult, shopReportService.getTotalNumberOfBoughtProductsPerCategory());
    }

    @Test
    public void getTotalNumberOfBoughtProducts() {
        Map<Product, Integer> expectedResult = Map.of(p1, 1, p2, 1);
        assertEquals(expectedResult, shopReportService.getTotalNumberOfBoughtProducts());
    }

    @Test
    public void getNumberOfClientsTest() {
        assertEquals(1, shopReportService.getNumberOfClients());
    }

    @Test
    public void getNumberOfSuppliersTest() {
        assertEquals(0, shopReportService.getNumberOfSuppliers());
    }
}
