package org.stream;

import org.stream.functional.ConsumerInterface;
import org.stream.functional.PredicateInterface;
import org.stream.functional.SupplierInterface;
import org.stream.functional.LambdaExpression;

public class Main {
    public static void main(String[] args) {
        System.out.println("---------- Lambda Expression Start -----------");
        LambdaExpression lambdaExpression = new LambdaExpression();
        lambdaExpression.practiceLambdaExpression();
        System.out.println("---------- Lambda Expression End -----------");

        System.out.println("---------- Supplier Interface Start -----------");
        SupplierInterface supplierInterface = new SupplierInterface();
        supplierInterface.practiceSupplier();
        System.out.println("---------- Supplier Interface End -----------");

        System.out.println("---------- Consumer Interface Start -----------");
        ConsumerInterface consumerInterface = new ConsumerInterface();
        consumerInterface.practiceConsumer();
        System.out.println("---------- Consumer Interface End -----------");

        System.out.println("---------- Predicate Interface Start -----------");
        PredicateInterface predicateInterface = new PredicateInterface();
        predicateInterface.practicePredicate();
        System.out.println("---------- Predicate Interface End -----------");

    }
}