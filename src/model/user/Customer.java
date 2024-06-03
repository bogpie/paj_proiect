package model.user;

import lombok.*;
import model.Address;
import model.Cart;
import model.Order;

import java.util.HashSet;
import java.util.Set;

@Builder
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)

public class Customer extends User {
    private Cart cart;
    private CustomerType customerType;
    private Set<Order> orders;

    public Customer(
            String name,
            String password,
            Address address
    ) {
        super(name, password, address);
        this.cart = new Cart();
        this.customerType = CustomerType.REGULAR;
        this.orders = new HashSet<>();
    }

    private void elevateCustomer() {
        this.customerType = CustomerType.PREMIUM;
    }

}
