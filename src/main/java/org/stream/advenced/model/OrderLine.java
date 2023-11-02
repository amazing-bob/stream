package org.stream.advenced.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@Accessors(chain = true)
public class OrderLine {
    private long id;
    private OrderLineType type;
    private long productId;
    private int quantity;
    private BigDecimal amount;

    public enum OrderLineType {
        PURCHASE,
        DISCOUNT
    }

}
