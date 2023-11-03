package org.stream.advenced;

import org.stream.advenced.model.User;
import org.stream.stream.model.Order;
import org.stream.stream.model.OrderLine;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToMap {
    public void testToMap() {
        Map<Integer, String> numberMap =  Stream.of(3, 5, -4, -2, 4, 6)
                .collect(Collectors. toMap(x -> x, x -> "Number is " + x));
        System.out.println(numberMap.get(3));

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
                .setId(103)
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
        Map<Integer, User> userIdToUserMap = users.stream()
                .collect(Collectors.toMap(User::getId, Function.identity()));
        System.out.println(userIdToUserMap);
        System.out.println(userIdToUserMap.get(103));

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

        // TODO: Create a map from order id to order status.
        Map<Long, Order.OrderStatus> orderIdToOrderStatus = orders.stream()
                .collect(Collectors.toMap(Order::getId, Order::getStatus));
        System.out.println(orderIdToOrderStatus);
        System.out.println(orderIdToOrderStatus.get(1001L));



    }
}
