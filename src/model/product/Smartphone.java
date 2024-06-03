package model.product;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.awt.*;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class Smartphone extends Product {
    private final String brand;
    private final String model;
    private final double displaySize;
    private final boolean is5G;
    private final Color caseColor;
}
