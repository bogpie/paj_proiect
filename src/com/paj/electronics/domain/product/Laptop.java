package com.paj.electronics.domain.product;

import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Laptop extends Product {
    private boolean gSync;
    private boolean recommendedForGaming;
    private int ramSize;
    private double diagonal;
}
