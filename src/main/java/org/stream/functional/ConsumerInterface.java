package org.stream.functional;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerInterface {
    public void practiceConsumer() {
        Consumer<String> myStringCnosumer = str -> System.out.println(str);
//        myStringCnosumer.accept("hello");
        myStringCnosumer.accept("world");


        List<Integer> integerInputs = Arrays.asList(4, 2, 3);
        Consumer<Integer> myIntegerProcessor = x ->
                System.out.println("Processing integer " + x);
        process(integerInputs, myIntegerProcessor);
        Consumer<Integer> myDifferentIntegerProcessor = x ->
                System.out.println("Processing integer in different way " + x);
        process(integerInputs, myDifferentIntegerProcessor);
        Consumer<Double> myDoubleProcessor = x ->
                System.out.println("Processing double in different way " + x);
        List<Double> doubleInputs = Arrays.asList(1.1, 1.2, 1.3);
        process(doubleInputs, myDoubleProcessor);

        BiConsumer<Integer, Double> myIdxDoubleProcessor =
                (index, input) ->
                        System.out.println("Processing " + input + " at index " + index);
        List<Double> inputs = Arrays.asList(1.1, 1.2, 1.3);
        process(inputs, myIdxDoubleProcessor);
    };

    public <T> void process(List<T> inputs, Consumer<T> processor) {
        for (T input : inputs) {
            processor.accept(input);
        }
    }

    public <T> void process(List<T> inputs, BiConsumer<Integer, T> processor) {
        for ( int i = 0; i < inputs.size(); i++ ){
            processor.accept(i, inputs.get(i));
        }
    }

}
