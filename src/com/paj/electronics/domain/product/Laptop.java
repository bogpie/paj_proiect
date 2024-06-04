package com.paj.electronics.domain.product;

import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
public class Laptop extends Product {
    private boolean gSync;
    private boolean recommendedForGaming;
    private int RAM;
    private double diagonal;
}
