package com.paj.electronics.domain;

import com.paj.electronics.domain.product.Product;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class Item {
    private Product product;
    private int quantity;
}
