package com.paj.electronics.service;

import com.paj.electronics.domain.Category;
import com.paj.electronics.domain.Client;
import com.paj.electronics.domain.Order;
import com.paj.electronics.domain.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

public interface ShopReportService {
  Map<Client, Set<Order>> clientOrderHistory();
  Map<String, Set<Client>> getClientsByCity();
  Map<String, Set<Client>> getClientsByCountry();
  Map<Category, Integer> getTotalNumberOfBoughtProductsPerCategory();
  Map<Product, Integer> getTotalNumberOfBoughtProducts();
  Long getNumberOfClients();
  Long getNumberOfSuppliers();
}
