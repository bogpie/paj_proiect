package com.paj.electronics.domain.product;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class GraphicalCard extends Product {
    private String chipsetSupplier;
    private boolean SLISupport;
    private int cudaCores;
    private int shaderUnits;
}
