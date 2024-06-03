package model;

import lombok.Builder;
import lombok.Data;
import model.product.Product;

@Builder
@Data
public class Item {
    private Product product;
    private int quantity;

}
