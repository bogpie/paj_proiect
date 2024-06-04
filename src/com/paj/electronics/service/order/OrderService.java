package com.paj.electronics.service.order;

import com.paj.electronics.domain.*;
import com.paj.electronics.domain.product.Product;
import com.paj.electronics.domain.user.Client;

public interface OrderService {
    Order createOrder(Client client, ShoppingCart shoppingCart);

    void cancelOrder(Client client, Order order);

    void updateOrderStatus(Order order, OrderStatus orderStatus);

    void updateOrderBoughtProduct(Order order, Product product, Integer quantity);

    void removeProductFromOrder(Order order, Product product);
}