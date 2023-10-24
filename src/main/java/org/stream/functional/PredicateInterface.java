package org.stream.functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateInterface {


    public void practicePredicate() {
        Predicate<Integer> isPositive = x -> x > 0;
        System.out.println(isPositive.test(10));
        System.out.println(isPositive.test(-10));

        List<Integer> inputs = Arrays.asList(0, 1, -2, 3, 4, -5, 10, -10);
        System.out.println("Positive number: " + filter(inputs, isPositive));
        System.out.println("Non-positive number: " + filter(inputs, isPositive.negate()));
        System.out.println("Non-negative number: " + filter(inputs, isPositive.or(x-> x == 0)));
        System.out.println("Positive even number: " + filter(inputs, isPositive.and(x-> x % 2 == 0)));
    }

    public <T> List<T> filter(List<T> inputs, Predicate<T> condition) {
        List<T> output = new ArrayList<>();
        for ( T input : inputs ) {
            if (condition.test(input))
                output.add(input);
        }
        return output;
    }

}
