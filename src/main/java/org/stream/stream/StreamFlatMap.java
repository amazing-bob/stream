package org.stream.stream;

import org.stream.stream.model.Order;
import org.stream.stream.model.OrderLine;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFlatMap {
    public void testStreamFlatMap() {
        String[][] cities = new String[][] {
                {"Seoul", "Busan"},
                {"San Francisco", "New York"},
                {"Madrid", "BArcelona"}
        };
        Stream<String[]> cityStream = Arrays.stream(cities);
        Stream<Stream<String>> cityStreamStream =  cityStream.map(x -> Arrays.stream(x));
        List<Stream<String>> cityStreamList = cityStreamStream.collect(Collectors.toList());

        Stream<String[]> cityStream2 = Arrays.stream(cities);
        Stream<String> flattenedCityStream = cityStream2.flatMap(x -> Arrays.stream(x));
        List<String> flattenedCityList = flattenedCityStream.collect(Collectors.toList());
        System.out.println(flattenedCityList);

        // TODO:
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        Order order1 = new Order()
                .setId(1001)
                .setOrderLines(Arrays.asList(
                        new OrderLine()
                                .setId(10001)
                                .setType(OrderLine.OrderLineType.PURCHASE)
                                .setAmount(BigDecimal.valueOf(5000)),
                        new OrderLine()
                                .setId(10002)
                                .setType(OrderLine.OrderLineType.PURCHASE)
                                .setAmount(BigDecimal.valueOf(4000))
                ))
                .setStatus(Order.OrderStatus.CREATED)
                .setCreateByUserId(101)
                .setCreateAt(now.minusHours(4));
        Order order2 = new Order()
                .setId(1002)
                .setOrderLines(Arrays.asList(
                        new OrderLine()
                                .setId(10003)
                                .setType(OrderLine.OrderLineType.PURCHASE)
                                .setAmount(BigDecimal.valueOf(2000)),
                        new OrderLine()
                                .setId(10004)
                                .setType(OrderLine.OrderLineType.PURCHASE)
                                .setAmount(BigDecimal.valueOf(-1000))
                ))
                .setCreateByUserId(103)
                .setCreateAt(now.minusHours(1));
        Order order3 = new Order()
                .setId(1003)
                .setOrderLines(Arrays.asList(
                        new OrderLine()
                                .setId(10005)
                                .setType(OrderLine.OrderLineType.PURCHASE)
                                .setAmount(BigDecimal.valueOf(2000))
                ))
                .setStatus(Order.OrderStatus.PROCESSED)
                .setCreateByUserId(102)
                .setCreateAt(now.minusHours(36));
        List<Order> orders = Arrays.asList(order1, order2, order3);
        List<OrderLine> mergedOrderLines = orders.stream()  // Stream<Order>
                .map(Order::getOrderLines)                  // Stream<List<OrderLine>>
                .flatMap(List::stream)                     // Stream<OrderLine>
                .collect(Collectors.toList());
        System.out.println(mergedOrderLines);
    }
}
