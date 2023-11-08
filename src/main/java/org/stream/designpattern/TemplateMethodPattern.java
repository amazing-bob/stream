package org.stream.designpattern;

import org.stream.designpattern.model.User;
import org.stream.designpattern.service.InternalUserService;
import org.stream.designpattern.service.UserService;
import org.stream.designpattern.service.UserServiceInFunctionalWay;

import java.util.Arrays;

public class TemplateMethodPattern {
    public void testTemplateMethodPattern() {
        User alice = User.builder(1, "Alice")
                .with(builder -> {
                    builder.emailAddress = "alice@gmail.com";
                    builder.isVerified = false;
                    builder.friendUserIds = Arrays.asList(201, 202, 203, 204, 205, 209, 211);
                }).build();
        User bob = User.builder(2, "Bob")
                .with(builder -> {
                    builder.emailAddress = "bob@gmail.com";
                    builder.isVerified = true;
                    builder.friendUserIds = Arrays.asList(201, 209, 210);
                }).build();
        UserService userService = new UserService();
        InternalUserService internalUserService = new InternalUserService();
        userService.createUser(alice);
        internalUserService.createUser(alice);
        userService.createUser(bob);
        internalUserService.createUser(bob);

        System.out.println("--- functional way ---");
        UserServiceInFunctionalWay userServiceInFunctionalWay = new UserServiceInFunctionalWay(
                user -> {
                    System.out.println("Validating user " + user.getName());
                    return user.getName() != null && user.getEmailAddress().isPresent();
                },
                user -> {
                    System.out.println("Writing user " + user.getName() + " to DB");
                }
        );
        userServiceInFunctionalWay.createUser(alice);
    }
}
