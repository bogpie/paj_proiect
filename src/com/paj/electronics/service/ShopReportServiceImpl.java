package com.paj.electronics.service;

import com.paj.electronics.domain.*;
import lombok.AllArgsConstructor;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ShopReportServiceImpl implements ShopReportService {
  private final Shop shop;

  @Override
  public Map<Client, Set<Order>> clientOrderHistory() {
    return shop.getClients()
        .stream()
        .collect(Collectors.toMap(Function.identity(), Client::getOrderHistory));
  }

  @Override
  public Map<String, Set<Client>> getClientsByCity() {
    return shop.getClients()
        .stream()
        .collect(Collectors.groupingBy((client) -> client.getAddress().getCity(), Collectors.toSet()));
  }

  @Override
  public Map<String, Set<Client>> getClientsByCountry() {
    return shop.getClients()
        .stream()
        .collect(Collectors.groupingBy((client) -> client.getAddress().getCountry(), Collectors.toSet()));
  }

  @Override
  public Map<Category, Integer> getTotalNumberOfBoughtProductsPerCategory() {
    return shop.getClients()
        .stream()
        .map(Client::getOrderHistory)
        .flatMap(Collection::stream)
        .map(Order::getBoughtProducts)
        .flatMap(m -> m.entrySet().stream())
        .collect(Collectors.toMap(p -> p.getKey().getCategory(), Map.Entry::getValue, Integer::sum));
  }

  @Override
  public Map<Product, Integer> getTotalNumberOfBoughtProducts() {
    return shop.getClients()
        .stream()
        .map(Client::getOrderHistory)
        .flatMap(Collection::stream)
        .map(Order::getBoughtProducts)
        .flatMap(m -> m.entrySet().stream())
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Integer::sum));
  }

  @Override
  public Long getNumberOfClients() {
    return shop.getClients().stream().count();
  }

  @Override
  public Long getNumberOfSuppliers() {
    return shop.getSuppliers().stream().count();
  }
}
