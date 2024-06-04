package com.paj.electronics.domain.user;

import com.paj.electronics.domain.Order;
import com.paj.electronics.domain.product.Product;
import com.paj.electronics.domain.ShoppingCart;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
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

    @Override
    public String toString() {
        return "Client " + "\"" + this.getName() + "\"" + " with " + clientType + " type";
    }
}
