package org.stream.practice;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ScopeClosureCurry {
    public void testScopeClosureCurry() {
        Supplier<String> supplier = getStringSupplier();
        System.out.println(supplier.get());

        BiFunction<Integer, Integer, Integer> add = (x ,y) -> x + y;
        Function<Integer, Function<Integer, Integer>> curriedAdd = (x -> y -> x + y);
        System.out.println(add.apply(2, 3));
        System.out.println(curriedAdd.apply(2).apply(3));

        Function<Integer,Integer> addThree = curriedAdd.apply(3);
        int result = addThree.apply(4);
        System.out.println(result);

    }

    public static Supplier<String> getStringSupplier() {
        String hello= "hello";
        Supplier<String> supplier = () -> {
            String world = "world";
            return hello + world;
        };
        return supplier;
    }
}
