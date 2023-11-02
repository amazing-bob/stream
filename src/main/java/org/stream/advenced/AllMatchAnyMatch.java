package org.stream.advenced;

import org.stream.advenced.model.User;
import org.stream.stream.model.Order;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class AllMatchAnyMatch {
    public void testAllMatchAnyMatch() {
        List<Integer> numbers = Arrays.asList(3, -1, 2, 4, 7, 9);
        boolean allPositive = numbers.stream()
                .allMatch(num -> num > 0);
        System.out.println("Are all numbers positive: " + allPositive);
        boolean anyNegative = numbers.stream()
                .anyMatch(num -> num < 0);
        System.out.println("Are any numbers negative: " + anyNegative);

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

        boolean areAllUserVerified = users.stream()
                .allMatch(User::isVerified);
        System.out.println("Are all user verified: " + areAllUserVerified);

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

        // TODO: check if any of orders is in ERROR status
        boolean isAnyOrdersWithError = orders.stream()
                .anyMatch(order -> order.getStatus() == Order.OrderStatus.ERROR);
        System.out.println(isAnyOrdersWithError);
    }
}
