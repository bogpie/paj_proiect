package model;

import lombok.Builder;
import lombok.Data;
import model.product.Product;

import java.util.Date;
import java.util.Map;

@Builder
@Data
public class Order {
    private int id;
    private Date orderDate;
    private double totalCost;
    private Status status;
    private Map<Product, Integer> contents;
}
