package com.paj.electronics.domain;

import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(callSuper = true, exclude = {"clientType", "cart", "orderHistory"})
public class Client extends User {
  private ClientType clientType;
  private ShoppingCart cart;
  private Set<Order> orderHistory;

  public Client() {
    orderHistory = new HashSet<>();
  }

  public Client(String username, String password, Address address) {
    orderHistory = new HashSet<>();
    cart = new ShoppingCart();
    clientType = ClientType.NORMAL;
    super.setAddress(address);
    super.setName(username);
    super.setPassword(password);
  }

  public Client(String username, String password, Address address,
                ClientType clientType, ShoppingCart cart) {
    orderHistory = new HashSet<>();
    super.setAddress(address);
    super.setName(username);
    super.setPassword(password);
    this.clientType = clientType;
    this.cart = cart;
  }

  public void addProductToShoppingCart(Product product) {
    cart.addProductToCart(product);
  }
}
