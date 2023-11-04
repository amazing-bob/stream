package org.stream.practice;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LazyEvaluation {
    public void testLazyEvaluation() {
        if (returnTrue() || returnFalse()) {
            System.out.println("true");
        }

        System.out.println("------");

        if (or(returnTrue(), returnFalse())) {
            System.out.println("true");
        }

        System.out.println("------");

        if (lazyOr(() -> returnTrue(), () -> returnFalse())) {
            System.out.println("true");
        }

        Stream<Integer> integerStream =  Stream.of(3, -2, 5,-7, 10, -3, 12)
                .filter(x -> x > 0)
                .peek(x -> System.out.println("Peeking " + x))
                .filter(x -> x % 2 == 0);
        System.out.println("Before collect");
        List<Integer> integers = integerStream.collect(Collectors.toList());
        System.out.println("After collect: " + integers);


    }

    public static boolean or(boolean x, boolean y) {
        return x || y;
    }

    public static boolean lazyOr(Supplier<Boolean> x, Supplier<Boolean> y) {
        return x.get() || y.get();
    }

    public static boolean returnTrue() {
        System.out.println("Returning true");
        return true;
    }

    public static boolean returnFalse() {
        System.out.println("Returning false");
        return false;
    }
}
