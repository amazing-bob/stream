package org.stream.advenced;

import org.stream.advenced.model.User;
import org.stream.advenced.service.EmailService;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitioningBy {
    public void testPartitioningBy() {
        List<Integer> numbers = Arrays.asList(13, 2, 101, 202, 204, 402, 2132, 203, 203);
        Map<Boolean, List<Integer>> numberPartitions = numbers.stream()
                .collect(Collectors.partitioningBy(number -> number % 2 == 0));
        System.out.println(numberPartitions);
        System.out.println("Even number: " + numberPartitions.get(true));
        System.out.println("Odd number: " + numberPartitions.get(false));

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
                .setFriendUserIds(Arrays.asList(204, 205, 206, 207, 209, 210, 211));
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

        Map<Boolean, List<User>> userPartitions = users.stream()
                .collect(Collectors.partitioningBy(user -> user.getFriendUserIds().size() > 5));
        System.out.println(userPartitions);
        EmailService emailService = new EmailService();
        for (User user : userPartitions.get(true)) {
            emailService.sendPlayWithFriendsEmail(user);
        }
        for (User user : userPartitions.get(false)) {
            emailService.sendMakeMoreFriendsEmail(user);
        }
    }
}
