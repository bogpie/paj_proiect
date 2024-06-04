package com.paj.electronics.domain;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Supplier extends User {
  public Supplier(String username, String password, Address address) {
    super.setAddress(address);
    super.setName(username);
    super.setPassword(password);
  }

  public void addProductToShop(Product product, Shop shop) {}
}
