package model.product;


import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode
public abstract class Product {
    private String id;
    private String name;
    private double price;
    private int stock;
    private String description;
    private Type type;
}
