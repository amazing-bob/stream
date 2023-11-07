package org.stream.designpattern;

import org.stream.designpattern.model.User;
import org.stream.designpattern.service.EmailProvider;
import org.stream.designpattern.service.EmailSender;
import org.stream.designpattern.service.MakeMoreFriendsEmailProvider;
import org.stream.designpattern.service.VerifyYourEmailAddressEmailProvider;

import java.util.Arrays;
import java.util.List;

public class StategyPattern {
    public void testStategyPattern() {
        User user1 = User.builder(1, "Alice")
                .with(builder -> {
                    builder.emailAddress = "alice@gmail.com";
                    builder.isVerified = false;
                    builder.friendUserIds = Arrays.asList(201, 202, 203, 204, 205, 209, 211);
                }).build();
        User user2 = User.builder(2, "Bob")
                .with(builder -> {
                    builder.emailAddress = "bob@gmail.com";
                    builder.isVerified = true;
                    builder.friendUserIds = Arrays.asList(201, 209, 210);
                }).build();
        User user3 = User.builder(3, "Charlie")
                .with(builder -> {
                    builder.emailAddress = "charlie@gmail.com";
                    builder.isVerified = true;
                    builder.friendUserIds = Arrays.asList(201, 202, 203, 204, 205, 208, 214);
                }).build();
        List<User> users = Arrays.asList(user1, user2, user3);

        EmailSender emailSender = new EmailSender();
        EmailProvider verifyYourEmailAddressEmailProvider = new VerifyYourEmailAddressEmailProvider();
        EmailProvider makeMoreFriendsEmailProvider = new MakeMoreFriendsEmailProvider();

        emailSender.setEmailProvider(verifyYourEmailAddressEmailProvider);
        users.stream()
                .filter(user -> !user.isVerified())
                .forEach(emailSender::sendEmail);
        emailSender.setEmailProvider(makeMoreFriendsEmailProvider);
        users.stream()
                .filter(User::isVerified)
                .filter(user -> user.getFriendUserIds().size() <= 5)
                .forEach(emailSender::sendEmail);

        emailSender.setEmailProvider(user -> "'Play With Friends' email for " + user.getName());
        users.stream()
                .filter(User::isVerified)
                .filter(user -> user.getFriendUserIds().size() <= 5)
                .forEach(emailSender::sendEmail);
    }
}
