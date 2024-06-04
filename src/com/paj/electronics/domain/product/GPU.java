package com.paj.electronics.domain.product;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class GPU extends Product {
    private String chipsetSupplier;
    private boolean supportsSLI;
    private int cudaCores;
    private int shaderUnits;
}
