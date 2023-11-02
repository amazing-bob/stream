package org.stream.stream;

import org.stream.stream.model.Order;
import org.stream.stream.model.User;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamIntermediateOperation {
    public void testStreamIntermediateOperation() {
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
        List<User> users = Arrays.asList(user1, user2, user3);

        //TODO: Unverified User Email List
        List<String> emails = new ArrayList<>();
        for (User user : users) {
            if (!user.isVerified()) {
                emails.add(user.getEmailAddress());
            }
        }
        System.out.println(emails);

        //TODO: Unverified User Email List.
        List<String> unverifiedEmailList = users.stream()
                .filter(user -> !user.isVerified())
                .map(User::getEmailAddress)
                .collect(Collectors.toList());
        System.out.println(unverifiedEmailList);


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

        // TODO: Find ordes in Error status, and extract createByUserIds as a list.
        List<Long> userList = orders.stream()
                .filter(order -> order.getStatus() == Order.OrderStatus.ERROR)
                .map(Order::getCreateByUserId)
                .collect(Collectors.toList());
        System.out.println(userList);

        //TODO: Find orders in ERROR status and within 24 hours.
        List<Order> recentErrorOrderList = orders.stream()
                .filter(order -> order.getStatus() == Order.OrderStatus.ERROR)
                .filter(order -> order.getCreateAt().isAfter(now.minusHours(24)))
                .collect(Collectors.toList());
        System.out.println(recentErrorOrderList);
    }
}
