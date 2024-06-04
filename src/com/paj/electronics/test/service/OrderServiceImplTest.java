package com.paj.electronics.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.paj.electronics.domain.Order;
import com.paj.electronics.domain.OrderStatus;
import com.paj.electronics.domain.ShoppingCart;
import com.paj.electronics.domain.product.Product;
import com.paj.electronics.domain.user.Client;
import com.paj.electronics.service.order.OrderServiceImpl;
import com.paj.electronics.test.ClientFixtures;
import com.paj.electronics.test.ProductFixtures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;


public class OrderServiceImplTest {

  private final OrderServiceImpl orderService = new OrderServiceImpl();
  private ShoppingCart shoppingCart;
  private Product p1;
  private Product p2;
  private Map<Product, Integer> boughtProducts;
  private Client client;

  @BeforeEach
  public void setUp() {
    client = ClientFixtures.getClient();
    shoppingCart = client.getCart();
    p1 = ProductFixtures.getLaptopProduct();
    p2 = ProductFixtures.getMobileProduct();

    client.addProductToShoppingCart(p1);
    client.addProductToShoppingCart(p2);
    boughtProducts = Map.of(p1, 1, p2, 1);
  }

  @Test
  public void createOrderTest() {
    Order order = orderService.createOrder(client, shoppingCart);
    assertEquals(order.getTotalCost(), 18449.50);
    assertTrue(order.getBoughtProducts().equals(boughtProducts));
  }

  @Test
  public void cancelOrderTest() {
    Order order = orderService.createOrder(client, shoppingCart);
    assertEquals(order.getTotalCost(), 18449.50);
    assertTrue(order.getBoughtProducts().equals(boughtProducts));
    assertEquals(p1.getStockUnits(), 49);
    assertEquals(p2.getStockUnits(), 9);

    orderService.cancelOrder(client, order);
    assertEquals(p1.getStockUnits(), 50);
    assertEquals(p2.getStockUnits(), 10);
  }

  @Test
  public void updateOrderStatusTest() {
    Order order = orderService.createOrder(client, shoppingCart);
    orderService.updateOrderStatus(order, OrderStatus.DELIVERED);
    assertEquals(OrderStatus.DELIVERED, order.getOrderStatus(), "Order status is wrong");
  }

  @Test
  public void updateOrderBoughtProductTest() {
    Order order = orderService.createOrder(client, shoppingCart);
    orderService.updateOrderBoughtProduct(order, p1, 3);
    assertEquals(order.getBoughtProducts().get(p1), 3, "Order has not updated");
    assertEquals(42449.5, order.getTotalCost(), "Total cost is wrong");
  }

  @Test
  public void removeProductFromOrderTest() {
    Order order = orderService.createOrder(client, shoppingCart);
    orderService.removeProductFromOrder(order, p1);
    assertEquals(order.getBoughtProducts().size(), 1, "Product has not been removed");
    assertEquals(18449.5, order.getTotalCost(), "Total cost is wrong");
  }
}
