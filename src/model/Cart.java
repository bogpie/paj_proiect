package model;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {
    private List<Item> items;

    public Cart() {
        items = new ArrayList<>();
    }
}
