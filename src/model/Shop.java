package model;

import lombok.NoArgsConstructor;
import model.product.Product;
import model.user.Customer;
import model.user.Supplier;

import java.util.Set;

@NoArgsConstructor
public class Shop {
    private Set<Product> products;
    private Set<Customer> customers;
    private Set<Supplier> suppliers;
}
