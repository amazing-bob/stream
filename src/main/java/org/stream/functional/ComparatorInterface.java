package org.stream.functional;

import org.stream.functional.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorInterface {


    public void practiceComparator() {
        List<User> users = new ArrayList<>();
        users.add(new User(3, "Anon"));
        users.add(new User(1, "Can"));
        users.add(new User(2, "Buru"));
        System.out.println(users);

        Comparator<User> idComparator = (u1, u2) -> u1.getId() - u2.getId();
        Collections.sort(users, idComparator);
        System.out.println(users);

        Collections.sort(users, (u1, u2) -> u1.getName().compareTo(u2.getName()));
        System.out.println(users);
    }
}
