package org.stream.optional;

import org.stream.optional.model.User;

import java.util.Optional;

public class OptionalTest {
    public void testOptional() {
        User user1 = new User()
                .setId(1001)
                .setName("Alice")
                .setVerified(false);
        User user2 = new User()
                .setId(1001)
                .setName("Alice")
                .setEmailAddress("alice@gail.com")
                .setVerified(false);

        System.out.println("Same? : " + userEquals(user2, user1));
//        System.out.println("Same? : " + userEquals(user1, user2)); // NullPointException


        String someEmail = "some@email.com";
        String nullEmail = null;

        Optional<String> maybeEmail1 = Optional.of(someEmail);
        Optional<String> maybeEmail2 = Optional.empty();
        Optional<String> maybeEmail3 = Optional.ofNullable(someEmail);
        Optional<String> maybeEmail4 = Optional.ofNullable(nullEmail);

        String email1 = maybeEmail1.get();
        System.out.println(email1);
        if (maybeEmail2.isPresent()) {
            System.out.println(maybeEmail2.get());
        }

        String defaultEmail = "default@email.com";
        String email3 = maybeEmail1.orElse(defaultEmail);
        System.out.println(email3);
        String email4 = maybeEmail2.orElseGet(() -> defaultEmail);
        System.out.println(email4);
//        String email5 = maybeEmail2.orElseThrow(() -> new RuntimeException("email not present"));


        Optional<User> maybeUser = Optional.ofNullable(maybeGetUser(true));
        maybeUser.ifPresent(user -> System.out.println(user));

        Optional<Integer> maybeId  = Optional.ofNullable(maybeGetUser(true))
                .map(user -> user.getId());
        maybeId.ifPresent(System.out::println);

        String userName = Optional.ofNullable(maybeGetUser(false))
                .map(User::getName)
                .map(name -> "The name is "+ name)
                .orElse("Name is Empty");
        System.out.println(userName);

        Optional<String> maybeEmail = Optional.ofNullable(maybeGetUser(true))
                .flatMap(User::getEmailAddress);
        maybeEmail.ifPresent(System.out::println);


    }

    public static boolean userEquals(User u1, User u2) {
        return u1.getId() == u2.getId()
                && u1.getName().equals(u2.getName())
                && u1.getEmailAddress().equals(u2.getEmailAddress())
                && u1.isVerified() == u2.isVerified();
    }

    public static User maybeGetUser(boolean returnUser) {
        if (returnUser) {
            return new User()
                    .setId(1001)
                    .setName("Alice")
                    .setEmailAddress("alice@gail.com")
                    .setVerified(false);
        }
        return null;
    }


}
