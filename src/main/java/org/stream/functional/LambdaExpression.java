package org.stream.functional;

import org.stream.functional.util.Adder;
import org.stream.functional.util.TriFunction;

import java.util.function.BiFunction;
import java.util.function.Function;

public class LambdaExpression {
    public void testLambdaExpression() {
        Function<Integer, Integer> myAdder = new Adder();
        int result = myAdder.apply(5);
        System.out.println("result :: " + result);

        Function<Integer, Integer> myAdder2 = (Integer x) -> {
            return x + 10;
        };
        int result2 = myAdder2.apply(3);
        System.out.println("result2 :: " + result2);

        Function<Integer, Integer> myAdder3 = x -> x + 10;
        int result3 = myAdder3.apply(2);
        System.out.println("result3 :: " + result3);

        BiFunction<Integer, Integer, Integer> add = (Integer x, Integer y) -> {
            return x + y;
        };
        int resultAdd = add.apply(1,3);
        System.out.println("resultAdd :: " + resultAdd);

        BiFunction<Integer, Integer, Integer> add2 = (x, y) -> x + y;
        int resultAdd2 = add2.apply(2,5);
        System.out.println("resultAdd2 :: " + resultAdd2);

        TriFunction<Integer, Integer, Integer, Integer> add3 = (x, y, z) -> x + y +z;
        int resultAdd3 = add3.apply(3,4,5);
        System.out.println("resultAdd3 :: " + resultAdd3);

    }
}
