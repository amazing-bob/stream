package org.stream.advenced;

import org.stream.advenced.model.User;
import org.stream.advenced.service.EmailService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ForEach {
    public void testForEach() {
        List<Integer> numbers = Arrays.asList(3, 5, 6, -7, 9);
//        numbers.stream().forEach(number -> System.out.println("The number is " + number));
        numbers.forEach(number -> System.out.println("The number is " + number));

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
        List<User> users = Arrays.asList(user1, user2, user3, user4);

        EmailService emailService = new EmailService();
//        users.forEach(user -> {
//            if (!user.isVerified()) {
//                emailService.sendVerifyYourEmailEmail(user);
//            }
//        });
        users.stream()
                .filter(user -> !user.isVerified())
//                .forEach(user -> emailService.sendVerifyYourEmailEmail(user));
                .forEach(EmailService::sendVerifyYourEmailEmail);

        for (int i = 0; i < users.size(); i++ ) {
            User user = users.get(i);
            System.out.println("Do an operation on user " + user.getName() + " at index " + i);
        }
        IntStream.range(0, users.size()).forEach(i -> {
            User user = users.get(i);
            System.out.println("Do an operation on user " + user.getName() + " at index " + i);
        });


    }
}
