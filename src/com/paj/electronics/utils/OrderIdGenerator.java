package com.paj.electronics.utils;

public class OrderIdGenerator {
  private static int id;

  private OrderIdGenerator() {}

  public static int getId() {
    return id++;
  }
}
