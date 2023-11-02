package org.stream.advenced;

import org.stream.advenced.model.User;
import org.stream.stream.model.Order;
import org.stream.stream.model.OrderLine;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Reduce {
    public void testReduce() {
        List<Integer> numbers = Arrays.asList(1, 4, -2, -4, 6);
        int sum = numbers.stream()
                .reduce((x, y) -> x +y)
                .get();
        System.out.println(sum);

        int min = numbers.stream()
                .reduce((x, y) -> (x < y) ? x : y)
                .get();
        System.out.println(min);

        int product = numbers.stream()
                .reduce(1, (x, y) -> x * y);
        System.out.println(product);

        List<String> numberStrList = Arrays.asList("2", "4", "5", "3");
        int sumOfNumberStrList = numberStrList.stream()
                .map(Integer::parseInt)
                .reduce(0, (x ,y) -> x + y);
        System.out.println(sumOfNumberStrList);

        int sumOfNumberStrList2 = numberStrList.stream()
                .reduce(0, (number, str) -> number + Integer.parseInt(str), (num1, num2) -> num1 + num2);
        System.out.println(sumOfNumberStrList2);

        User user1 = new User()
                .setId(101)
                .setName("Alice")
                .setVerified(true)
                .setEmailAddress("alice@gmail.com")
                .setFriendUserIds(Arrays.asList(201, 202, 203, 204));
        User user2 = new User()
                .setId(102)
                .setName("Bob")
                .setVerified(false)
                .setEmailAddress("bob@gmail.com")
                .setFriendUserIds(Arrays.asList(204, 205, 206));
        User user3 = new User()
                .setId(104)
                .setName("Charlie")
                .setVerified(false)
                .setEmailAddress("charlie@gmail.com")
                .setFriendUserIds(Arrays.asList(204, 205, 207));
        User user4 = new User()
                .setId(104)
                .setName("David")
                .setVerified(false)
                .setEmailAddress("david@gmail.com")
                .setFriendUserIds(Arrays.asList(203, 208, 209));
        List<User> users = Arrays.asList(user1, user2, user3, user4);
        int sumOfNumberOfFriends = users.stream()
                .map(User::getFriendUserIds)
                .map(List::size)
                .reduce(0, (x, y) -> x + y);
        System.out.println(sumOfNumberOfFriends);

        Order order1 = new Order()
                .setId(1001)
                .setAmount(BigDecimal.valueOf(2000))
                .setStatus(Order.OrderStatus.CREATED)
                .setOrderLines(Arrays.asList(
                        new OrderLine()
                                .setAmount(BigDecimal.valueOf(1000)),
                        new OrderLine()
                                .setAmount(BigDecimal.valueOf(2000))
                ));
        Order order2 = new Order()
                .setId(1002)
                .setAmount(BigDecimal.valueOf(4000))
                .setStatus(Order.OrderStatus.ERROR)
                .setOrderLines(Arrays.asList(
                        new OrderLine()
                                .setAmount(BigDecimal.valueOf(2000)),
                        new OrderLine()
                                .setAmount(BigDecimal.valueOf(3000))
                ));
        Order order3 = new Order()
                .setId(1003)
                .setAmount(BigDecimal.valueOf(3000))
                .setStatus(Order.OrderStatus.PROCESSED)
                .setOrderLines(Arrays.asList(
                        new OrderLine()
                                .setAmount(BigDecimal.valueOf(1000)),
                        new OrderLine()
                                .setAmount(BigDecimal.valueOf(3000))
                ));
        List<Order> orders = Arrays.asList(order1, order2, order3);
        // TODO: find the sum of amounts
        BigDecimal sumOfAmounts = orders.stream()
                .map(Order::getOrderLines) // Stream<List<OrderLine>>
                .flatMap(List::stream)  // Stream<OrderLine>
                .map(OrderLine::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(sumOfAmounts);

    }
}
