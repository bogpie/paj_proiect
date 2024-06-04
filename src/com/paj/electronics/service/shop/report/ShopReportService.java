package com.paj.electronics.service.shop.report;

import com.paj.electronics.domain.product.Category;
import com.paj.electronics.domain.user.Client;
import com.paj.electronics.domain.Order;
import com.paj.electronics.domain.product.Product;

import java.util.Map;
import java.util.Set;

public interface ShopReportService {
    Map<Client, Set<Order>> clientOrderHistory();

    Map<String, Set<Client>> getClientsByCity();

    Map<String, Set<Client>> getClientsByCountry();

    Map<Category, Integer> getTotalNumberOfBoughtProductsPerCategory();

    Map<Product, Integer> getTotalNumberOfBoughtProducts();

    Long getNumberOfClients();

    Long getNumberOfSuppliers();
}
