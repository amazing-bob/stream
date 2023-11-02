package org.stream.stream;

import org.stream.stream.model.Order;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDistinct {
    public void testStreamDistinct() {
        // TODO: distinct numbers
        List<Integer> numbers = Arrays.asList(3, -5, 4, -5, 2, 3);
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(distinctNumbers);

        // TODO: created a sorted list of unique CreateByUserIds from the orders
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        Order order1 = new Order()
                .setId(1001)
                .setStatus(Order.OrderStatus.CREATED)
                .setCreateByUserId(101)
                .setCreateAt(now.minusHours(4));
        Order order2 = new Order()
                .setId(1002)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreateByUserId(103)
                .setCreateAt(now.minusHours(1));
        Order order3 = new Order()
                .setId(1003)
                .setStatus(Order.OrderStatus.PROCESSED)
                .setCreateByUserId(102)
                .setCreateAt(now.minusHours(36));
        Order order4 = new Order()
                .setId(1004)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreateByUserId(104)
                .setCreateAt(now.minusMinutes(15));
        Order order5 = new Order()
                .setId(1005)
                .setStatus(Order.OrderStatus.IN_PROGRESS)
                .setCreateByUserId(101)
                .setCreateAt(now.minusHours(10));
        List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);
        List<Long> distinctOrdersByUserId = orders.stream()
                .map(Order::getCreateByUserId)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(distinctOrdersByUserId);
    }
}
