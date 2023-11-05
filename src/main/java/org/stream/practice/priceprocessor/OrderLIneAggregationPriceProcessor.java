package org.stream.practice.priceprocessor;

import org.stream.practice.model.Order;
import org.stream.practice.model.OrderLine;

import java.math.BigDecimal;
import java.util.function.Function;

public class OrderLIneAggregationPriceProcessor implements Function<Order, Order> {


    @Override
    public Order apply(Order order) {
        return order.setAmount(order.getOrderLines().stream()
                .map(OrderLine::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add));
    }
}
