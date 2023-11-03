package org.stream.advenced;

import org.stream.advenced.model.Order;
import org.stream.advenced.model.OrderLine;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupingBy {
    public void testGroupingBy() {
        List<Integer> numbers = Arrays.asList(13, 2, 101, 202, 204, 402, 2132, 203, 203);
        Map<Integer, List<Integer>> unitDigitMap = numbers.stream()
                .collect(Collectors.groupingBy(number -> number % 10));
        System.out.println(unitDigitMap);

        Map<Integer, Set<Integer>> unitDigitSet = numbers.stream()
                .collect(Collectors.groupingBy(number -> number % 10, Collectors.toSet()));
        System.out.println(unitDigitSet);

        Map<Integer, List<String>> unitDigitStrMap = numbers.stream()
                .collect(Collectors.groupingBy(number -> number % 10,
                        Collectors.mapping(number -> "unit digit is " + number, Collectors.toList())));
        System.out.println(unitDigitStrMap);
        System.out.println(unitDigitStrMap.get(3));

        Order order1 = new Order()
                .setId(1001)
                .setAmount(BigDecimal.valueOf(3000))
                .setStatus(Order.OrderStatus.CREATED)
                .setOrderLines(Arrays.asList(
                        new OrderLine()
                                .setAmount(BigDecimal.valueOf(1000)),
                        new OrderLine()
                                .setAmount(BigDecimal.valueOf(2000))
                ));
        Order order2 = new Order()
                .setId(1002)
                .setAmount(BigDecimal.valueOf(5000))
                .setStatus(Order.OrderStatus.ERROR)
                .setOrderLines(Arrays.asList(
                        new OrderLine()
                                .setAmount(BigDecimal.valueOf(2000)),
                        new OrderLine()
                                .setAmount(BigDecimal.valueOf(3000))
                ));
        Order order3 = new Order()
                .setId(1003)
                .setAmount(BigDecimal.valueOf(4000))
                .setStatus(Order.OrderStatus.PROCESSED)
                .setOrderLines(Arrays.asList(
                        new OrderLine()
                                .setAmount(BigDecimal.valueOf(1000)),
                        new OrderLine()
                                .setAmount(BigDecimal.valueOf(3000))
                ));
        Order order4 = new Order()
                .setId(1004)
                .setAmount(BigDecimal.valueOf(7000))
                .setStatus(Order.OrderStatus.PROCESSED)
                .setOrderLines(Arrays.asList(
                        new OrderLine()
                                .setAmount(BigDecimal.valueOf(3000)),
                        new OrderLine()
                                .setAmount(BigDecimal.valueOf(4000))
                ));
        List<Order> orders = Arrays.asList(order1, order2, order3, order4);

        // TODO: creat a map from order status to the list of corresponding orders
        Map<Order.OrderStatus, List<Order>> orderStatusToOrderList = orders.stream()
                .collect(Collectors.groupingBy(Order::getStatus));
        System.out.println(orderStatusToOrderList);
        System.out.println(orderStatusToOrderList.get(Order.OrderStatus.PROCESSED));

        Map<Order.OrderStatus, BigDecimal> orderStatusToSumOfAmountMap = orders.stream()
                .collect(Collectors.groupingBy(Order::getStatus,
                        Collectors.mapping(Order::getAmount,
                                Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))));
        System.out.println(orderStatusToSumOfAmountMap);
    }
}
