package org.stream.designpattern;

import org.stream.designpattern.model.User;
public class BuilderPattern {
    public void testBuilderPattern() {
//        User user = User.builder(1, "Alice")
//                .withEmailAddress("alice@gamil.com")
//                .withVerified(true)
//                .build();
//        System.out.println(user);
        User user = User.builder(1, "Alice")
                .with(builder -> {
                    builder.emailAddress = "alice@gmail.com";
                    builder.isVerified = true;
                }).build();
        System.out.println(user);
    }
}
