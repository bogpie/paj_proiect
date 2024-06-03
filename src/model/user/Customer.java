package model.user;

import lombok.*;
import model.Cart;
import model.Order;

import java.util.Set;

@Builder
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)

public class Customer extends User {
    private Cart cart;
    private CustomerType customerType;
    private Set<Order> orders;

}
