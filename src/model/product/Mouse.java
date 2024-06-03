package model.product;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.awt.*;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class Mouse extends Product {
    private final String connectionType;
    private final int dpi;
    private final boolean isWireless;
    private Color color;
}
