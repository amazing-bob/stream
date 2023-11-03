package org.stream.advenced;

import org.stream.advenced.model.User;
import org.stream.advenced.service.EmailService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStream {
    public void testParallelStream() {
        User user1 = new User()
                .setId(101)
                .setName("Alice")
                .setVerified(true)
                .setEmailAddress("alice@gmail.com")
                .setFriendUserIds(Arrays.asList(201, 202, 203, 204));
        User user2 = new User()
                .setId(102)
                .setName("Bob")
                .setVerified(true)
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
        User user5 = new User()
                .setId(105)
                .setName("Evan")
                .setVerified(true)
                .setEmailAddress("evam@gmail.com")
                .setFriendUserIds(Arrays.asList(203, 208, 209,301, 303));
        User user6 = new User()
                .setId(106)
                .setName("Frank")
                .setVerified(false)
                .setEmailAddress("david@gmail.com")
                .setFriendUserIds(Arrays.asList(203, 208, 101,303, 305));
        User user7 = new User()
                .setId(107)
                .setName("Greg")
                .setVerified(false)
                .setEmailAddress("david@gmail.com")
                .setFriendUserIds(Arrays.asList(203, 208, 209, 204));
        List<User> users = new ArrayList();
        users.addAll(Arrays.asList(user1, user2, user3, user4, user5, user6, user7));
//        IntStream.range(0, 99).forEach(i -> {
//                users.add(new User()
//                    .setId(900 + i)
//                    .setName("X-man-" + i)
//                    .setVerified(false)
//                    .setEmailAddress("x-man-"+ i +"@gmail.com")
//                    .setFriendUserIds(Arrays.asList(901, 902, 903, 904)));
//        });
        long startTime = System.currentTimeMillis();
        users.stream()
                .filter(user -> !user.isVerified())
                .forEach(EmailService::sendVerifyYourEmailEmail);
        long endTime = System.currentTimeMillis();
        System.out.println("Sequential: " + (endTime - startTime) + "ms");

        long startTime2 = System.currentTimeMillis();
        users.stream().parallel()
                .filter(user -> !user.isVerified())
                .forEach(EmailService::sendVerifyYourEmailEmail);
        long endTime2 = System.currentTimeMillis();
        System.out.println("Parallel: " + (endTime2 - startTime2) + "ms");

        List<User> processedUser = users.parallelStream()
                .map(user -> {
                    System.out.println("Capitalize user name for user "  + user.getId());
                    user.setName(user.getName().toUpperCase());
                    return user;
                })
                .map(user -> {
                    System.out.println("Set 'isVerified' to true for user");
                    user.setVerified(true);
                    return user;
                })
                .collect(Collectors.toList());
        System.out.println(processedUser);


    }
}
