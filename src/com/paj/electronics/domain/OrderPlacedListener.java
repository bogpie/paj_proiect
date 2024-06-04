package com.paj.electronics.domain;

public interface OrderPlacedListener {
  void onOrderPlaced(Client client, Order order);
}
