package model.product;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode(callSuper = true)
public class Computer extends Product {
    private final String processor;
    private final String graphicsCard;
    private final int ramSize;
    private final int storageSize;
}

