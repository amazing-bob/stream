package org.stream.methodreference;

import org.stream.methodreference.model.Car;
import org.stream.methodreference.model.Sedan;
import org.stream.methodreference.model.Van;
import org.stream.methodreference.model.Suv;
import org.stream.methodreference.model.User;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class MethodReference {

    public void practiceMethodReference() {
        // ClassName::staticMethodName => 클래스의 static method를 지정할 때
        int a = Integer.parseInt("15");
        Function<String, Integer> str2int = Integer::parseInt;
        System.out.println(str2int.apply("20"));

        // objectName::instanceMethodName => 선언된 객체의 instance method를 지정할 때
        String str = "hello";
        boolean b = str.equals("world");
        Predicate<String> equalsToHello = str::equals;
        System.out.println(equalsToHello.test("hello"));
        System.out.println(equalsToHello.test("world"));

        System.out.println(calculate(8, 2, (x , y) -> x + y));
        System.out.println(calculate(8, 2, MethodReference::multiply));
        MethodReference methodReference = new MethodReference();
        System.out.println(calculate(8, 2, methodReference::subtract));
        methodReference.myMethod();

        // ClassName::instanceMethodName => 객체의 instance method를 지정할 때
        Function<String, Integer> strLength = String::length;
        int length = strLength.apply("hello");
        System.out.println("strLength :: " + length);
        BiFunction<String, String, Boolean> isEqualsF = String::equals;
        System.out.println("isEquals - BiFunction :: " + isEqualsF.apply("tar", "jar"));
        System.out.println("isEquals - BiFunction :: " + isEqualsF.apply("jar", "jar"));
        BiPredicate<String, String> isEqualsP = String::equals;
        System.out.println("isEquals - BiPredicate :: " + isEqualsP.test("tar", "jar"));
        System.out.println("isEquals - BiPredicate :: " + isEqualsP.test("tar", "tar"));

        List<User> users = Arrays.asList(
                new User(1, "홍길동"),
                new User(2, "김상헌"),
                new User(3, "정진영"));
        printUserField(users, User::getName);

        // ClassName::new => 클래스의 constructor를 지정 할 때
        User user = new User(1, "Alice");
//        BiFunction<Integer, String, User> userCreator = (Integer id, String name) -> { return new User(id, name);};
        BiFunction<Integer, String, User> userCreator = User::new;
        User bob = userCreator.apply(2, "Bob");
        System.out.println(bob);

        Map<String, BiFunction<String, String, Car>> carTypeConstructorMap = new HashMap<>();
        carTypeConstructorMap.put("sedan", Sedan::new);
        carTypeConstructorMap.put("suv", Suv::new);
        carTypeConstructorMap.put("van", Van::new);
        String[][] inputs = new String[][] {
                { "sedan", "Sonata", "Hyundai"},
                { "van", "Sienna", "Toyota"},
                { "suv", "Sorento", "KIA"},
                { "sedan", "model s", "Tesla"}
        };

        List<Car> cars = new ArrayList<>();
        for ( int i = 0; i < inputs.length; i++ ){
            String[] input = inputs[i];
            String type = input[0];
            String name = input[1];
            String brand = input[2];

            cars.add(carTypeConstructorMap.get(type).apply(name, brand));
        }

        for ( Car car : cars) {
            car.drive();
        }



    }

    public int calculate(int x, int y, BiFunction<Integer, Integer, Integer> operator) {
        return operator.apply(x, y);
    }

    public static int multiply(int x, int y) {
        return x * y;
    }

    public int subtract (int x, int y ) {
        return x - y;
    }

    public void myMethod() {
        System.out.println(calculate(10, 3, this::subtract));
    }

    public static void printUserField(List<User> users, Function<User, Object> getter) {
        for (User user : users) {
            System.out.println(getter.apply(user));
        }
    }

}
