package org.stream;

import org.stream.functional.*;
import org.stream.methodreference.MethodReference;
import org.stream.stream.StreamFilter;
import org.stream.stream.StreamInterface;
import org.stream.stream.StreamIntermediateOperation;
import org.stream.stream.StreamMap;

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

        System.out.println("---------- Comparator Interface Start -----------");
        ComparatorInterface comparatorInterface = new ComparatorInterface();
        comparatorInterface.practiceComparator();
        System.out.println("---------- Comparator Interface End -----------");

        System.out.println("---------- Method Reference Start -----------");
        MethodReference methodReference = new MethodReference();
        methodReference.practiceMethodReference();
        System.out.println("---------- Method Reference End -----------");

        System.out.println("---------- Stream Start -----------");
        StreamInterface streamInterface = new StreamInterface();
        streamInterface.practiceStream();
        System.out.println("---------- Stream End -----------");

        System.out.println("---------- StreamFilter Start -----------");
        StreamFilter streamFilter = new StreamFilter();
        streamFilter.practiceStreamFilter();
        System.out.println("---------- StreamFilter End -----------");

        System.out.println("---------- StreamMap Start -----------");
        StreamMap streamMap = new StreamMap();
        streamMap.practiceStreamMap();
        System.out.println("---------- StreamMap End -----------");

        System.out.println("---------- StreamIntermediateOperation Start -----------");
        StreamIntermediateOperation treamIntermediateOperation = new StreamIntermediateOperation();
        treamIntermediateOperation.practiceStreamIntermediateOperation();
        System.out.println("---------- StreamIntermediateOperation End -----------");
    }
}