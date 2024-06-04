package com.paj.electronics.domain.product;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@ToString
@EqualsAndHashCode(exclude = "stockUnits")
public abstract class Product {
    private String id;
    private Category category;
    private String name;
    private double price;
    private int stockUnits;
    private Color color;
}
