package com.paj.electronics.domain;

import com.paj.electronics.domain.product.Product;
import com.paj.electronics.domain.user.Client;
import com.paj.electronics.domain.user.Supplier;
import lombok.AllArgsConstructor;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
public class Shop {
    private Set<Product> products;
    private Set<Client> clients;
    private Set<Supplier> suppliers;

    public Shop() {
        products = new HashSet<>();
        clients = new HashSet<>();
        suppliers = new HashSet<>();
    }

    public void addProducts(Product product) {
        products.add(product);
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public void addSupplier(Supplier supplier) {
        suppliers.add(supplier);
    }

    public Set<Client> getClients() {
        return Collections.unmodifiableSet(clients);
    }

    public Set<Product> getProducts() {
        return Collections.unmodifiableSet(products);
    }

    public Set<Supplier> getSuppliers() {
        return Collections.unmodifiableSet(suppliers);
    }
}
