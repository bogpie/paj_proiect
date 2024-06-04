package com.paj.electronics.domain;

import com.paj.electronics.domain.user.Client;

public interface OrderPlacedListener {
    void onOrderPlaced(Client client, Order order);
}
