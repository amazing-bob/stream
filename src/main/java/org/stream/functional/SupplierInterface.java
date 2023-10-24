package org.stream.functional;

import java.util.function.Supplier;

public class SupplierInterface {
    public void practiceSupplier() {
        Supplier<String> myStringSupplier = () -> "Hello World";
        System.out.println(myStringSupplier.get());

        Supplier<Double> myRandomDoubleSupplier = () -> Math.random();
        System.out.println(myRandomDoubleSupplier.get());
        System.out.println(myRandomDoubleSupplier.get());
        System.out.println(myRandomDoubleSupplier.get());
        printRandomDoubles(myRandomDoubleSupplier, 3);

    };

    public void printRandomDoubles (Supplier<Double> randomSupplier, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(randomSupplier.get());
        }
    }

}
