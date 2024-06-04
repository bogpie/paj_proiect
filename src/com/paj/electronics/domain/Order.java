package com.paj.electronics.domain;

import lombok.*;

import java.util.Date;
import java.util.Map;

@EqualsAndHashCode
@Builder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Order {
  private int id;
  private Date orderDate;
  private double totalCost;
  private OrderStatus orderStatus;
  private Map<Product, Integer> boughtProducts;
}
