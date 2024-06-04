package com.paj.electronics.service;

import com.paj.electronics.domain.*;

public interface OrderService {
  Order createOrder(Client client, ShoppingCart shoppingCart);
  void cancelOrder(Client client, Order order);
  void updateOrderStatus(Order order, OrderStatus orderStatus);
  void updateOrderBoughtProduct(Order order, Product product, Integer quantity);
  void removeProductFromOrder(Order order, Product product);
}