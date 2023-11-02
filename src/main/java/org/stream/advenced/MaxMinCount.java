package org.stream.advenced;

import org.stream.advenced.model.User;
import org.stream.stream.model.Order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class MaxMinCount {
    public void testMaxMinCount() {
        Optional<Integer> max = Stream.of(5, 3, 6, 2, 1)
//                .max((x, y) -> x - y);
                .max(Integer::compareTo);
        System.out.println(max.get());

        User user1 = new User()
                .setId(101)
                .setName("Alice")
                .setVerified(true)
                .setEmailAddress("alice@gmail.com");
        User user2 = new User()
                .setId(102)
                .setName("Bob")
                .setVerified(false)
                .setEmailAddress("bob@gmail.com");
        User user3 = new User()
                .setId(104)
                .setName("Charlie")
                .setVerified(false)
                .setEmailAddress("charlie@gmail.com");
        User user4 = new User()
                .setId(104)
                .setName("David")
                .setVerified(false)
                .setEmailAddress("david@gmail.com");
        List<User> users = Arrays.asList(user1, user2, user3, user4);
        User firstUser = users.stream()
                .min((u1, u2) -> u1.getName().compareTo(u2.getName()))
                .get();
        System.out.println(firstUser);

        long positiveInteger = Stream.of(1, -4, -3, 5, 6)
                .filter(x -> x > 0)
                .count();
        System.out.println("Positive integers: " + positiveInteger);

        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        user1.setCreatedAt(now.minusDays(2));
        user2.setCreatedAt(now.minusHours(10));
        user3.setCreatedAt(now.minusHours(1));
        user4.setCreatedAt(now.minusHours(27));

        long count = users.stream()
                .filter(user -> user.getCreatedAt().isAfter(now.minusDays(1)))
                .filter(user -> !user.isVerified())
                .count();
        System.out.println(count);

        Order order1 = new Order()
                .setId(1001)
                .setAmount(BigDecimal.valueOf(2000))
                .setStatus(Order.OrderStatus.CREATED);
        Order order2 = new Order()
                .setId(1002)
                .setAmount(BigDecimal.valueOf(4000))
                .setStatus(Order.OrderStatus.ERROR);
        Order order3 = new Order()
                .setId(1003)
                .setAmount(BigDecimal.valueOf(3000))
                .setStatus(Order.OrderStatus.PROCESSED);
        Order order4 = new Order()
                .setId(1004)
                .setAmount(BigDecimal.valueOf(7000))
                .setStatus(Order.OrderStatus.ERROR);
        Order order5 = new Order()
                .setId(1005)
                .setAmount(BigDecimal.valueOf(8000))
                .setStatus(Order.OrderStatus.IN_PROGRESS);
        List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);

        // TODO: find order with highest amount in ERROR status
        Order erroredOrderWithMaxAmount =  orders.stream()
                .filter(order -> order.getStatus().equals(Order.OrderStatus.ERROR))
                .max((o1, o2) -> o1.getAmount().compareTo(o2.getAmount()))
                .get();
        System.out.println(erroredOrderWithMaxAmount);

        BigDecimal maxErroredAmount = orders.stream()
                .filter(order -> order.getStatus() == Order.OrderStatus.ERROR)
                .map(Order::getAmount)
                .max(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);
        System.out.println(maxErroredAmount);

    }
}
