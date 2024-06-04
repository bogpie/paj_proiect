package com.paj.electronics.service.order;

import com.paj.electronics.domain.*;
import com.paj.electronics.domain.product.Product;
import com.paj.electronics.domain.user.Client;
import com.paj.electronics.domain.user.Supplier;
import com.paj.electronics.domain.user.User;
import com.paj.electronics.email.Email;
import com.paj.electronics.email.EmailService;
import com.paj.electronics.exceptions.EmailServiceException;
import com.paj.electronics.utils.OrderIdGenerator;
import lombok.Getter;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {
    private final OrderPlacedListener orderPlacedListener;
    @Getter
    private EmailService nullableEmailService = null;
    @Getter
    private int emailedClients;
    private static final User shopNoReply = new Supplier("Shop-no-reply", "shop-no-reply", null);

    public OrderServiceImpl() {
        nullableEmailService = new EmailService();

        orderPlacedListener = (client, order) -> {
            System.out.println("Notification email for client " + client.getName() + " to be sent");

            Optional<EmailService> optionalEmailService = Optional.ofNullable(nullableEmailService);
            optionalEmailService.orElseThrow(
                            () -> new EmailServiceException("Email service is not running")
                    )
                    .sendNotificationEmail(Email.builder()
                            .emailTitle("Confirmation for your order")
                            .body("Order: " + order)
                            .from(shopNoReply)
                            .to(List.of(client))
                            .build());

            emailedClients++;
        };
    }

    public Order createOrder(Client client, ShoppingCart shoppingCart) {
        Order order = Order.builder()
                .id(OrderIdGenerator.getId())
                .totalCost(shoppingCart.getTotalCost())
                .orderStatus(OrderStatus.CREATED)
                .orderDate(Date.from(Instant.now()))
                .boughtProducts(shoppingCart.getItems()
                        .stream()
                        .collect(Collectors.toMap(Item::getProduct, Item::getQuantity))
                )
                .build();

        client.getOrderHistory().add(order);
        shoppingCart.getItems().forEach(
                item -> item.getProduct().setStockUnits(item.getProduct().getStockUnits() - item.getQuantity())
        );
        shoppingCart.clearShoppingCart();
        notify(client, order);
        return order;
    }

    public void cancelOrder(Client client, Order order) {
        order.setOrderStatus(OrderStatus.CANCELLED);
        order.getBoughtProducts().forEach((key, value) -> key.setStockUnits(key.getStockUnits() + value));
        client.getOrderHistory().remove(order);
        client.getOrderHistory().add(order);
    }

    public void updateOrderStatus(Order order, OrderStatus orderStatus) {
        order.setOrderStatus(orderStatus);
    }

    public void updateOrderBoughtProduct(Order order, Product product, Integer quantity) {
        order.getBoughtProducts().put(product, quantity);
        order.setTotalCost(
                order.getBoughtProducts().entrySet()
                        .stream()
                        .mapToDouble(k -> k.getKey().getPrice() * k.getValue())
                        .sum()
        );
    }

    public void removeProductFromOrder(Order order, Product product) {
        order.getBoughtProducts().remove(product);
    }

    private void notify(Client client, Order order) {
        orderPlacedListener.onOrderPlaced(client, order);
    }
}
