package org.stream;

import org.stream.advenced.*;
import org.stream.functional.*;
import org.stream.methodreference.MethodReference;
import org.stream.optional.OptionalTest;
import org.stream.practice.FunctionComposition;
import org.stream.practice.LazyEvaluation;
import org.stream.practice.ScopeClosureCurry;
import org.stream.stream.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("---------- Lambda Expression Start -----------");
        LambdaExpression lambdaExpression = new LambdaExpression();
        lambdaExpression.testLambdaExpression();
        System.out.println("---------- Lambda Expression End -----------");

        System.out.println("---------- Supplier Interface Start -----------");
        SupplierInterface supplierInterface = new SupplierInterface();
        supplierInterface.testSupplier();
        System.out.println("---------- Supplier Interface End -----------");

        System.out.println("---------- Consumer Interface Start -----------");
        ConsumerInterface consumerInterface = new ConsumerInterface();
        consumerInterface.testConsumer();
        System.out.println("---------- Consumer Interface End -----------");

        System.out.println("---------- Predicate Interface Start -----------");
        PredicateInterface predicateInterface = new PredicateInterface();
        predicateInterface.testPredicate();
        System.out.println("---------- Predicate Interface End -----------");

        System.out.println("---------- Comparator Interface Start -----------");
        ComparatorInterface comparatorInterface = new ComparatorInterface();
        comparatorInterface.testComparator();
        System.out.println("---------- Comparator Interface End -----------");

        System.out.println("---------- Method Reference Start -----------");
        MethodReference methodReference = new MethodReference();
        methodReference.testMethodReference();
        System.out.println("---------- Method Reference End -----------");

        System.out.println("---------- Stream Start -----------");
        StreamInterface streamInterface = new StreamInterface();
        streamInterface.testStream();
        System.out.println("---------- Stream End -----------");

        System.out.println("---------- StreamFilter Start -----------");
        StreamFilter streamFilter = new StreamFilter();
        streamFilter.testStreamFilter();
        System.out.println("---------- StreamFilter End -----------");

        System.out.println("---------- StreamMap Start -----------");
        StreamMap streamMap = new StreamMap();
        streamMap.testStreamMap();
        System.out.println("---------- StreamMap End -----------");

        System.out.println("---------- StreamIntermediateOperation Start -----------");
        StreamIntermediateOperation treamIntermediateOperation = new StreamIntermediateOperation();
        treamIntermediateOperation.testStreamIntermediateOperation();
        System.out.println("---------- StreamIntermediateOperation End -----------");

        System.out.println("---------- StreamSorted Start -----------");
        StreamSorted streamSorted = new StreamSorted();
        streamSorted.testStreamSorted();
        System.out.println("---------- StreamSorted End -----------");

        System.out.println("---------- StreamDistinct Start -----------");
        StreamDistinct streamDistinct = new StreamDistinct();
        streamDistinct.testStreamDistinct();
        System.out.println("---------- StreamDistinct End -----------");

        System.out.println("---------- StreamFlatMap Start -----------");
        StreamFlatMap streamFlatMap = new StreamFlatMap();
        streamFlatMap.testStreamFlatMap();
        System.out.println("---------- StreamFlatMap End -----------");

        System.out.println("---------- OptionalTest Start -----------");
        OptionalTest optionalTest = new OptionalTest();
        optionalTest.testOptional();
        System.out.println("---------- OptionalTest End -----------");

        System.out.println("---------- MaxMinCount Start -----------");
        MaxMinCount maxMinCount = new MaxMinCount();
        maxMinCount.testMaxMinCount();
        System.out.println("---------- MaxMinCount End -----------");

        System.out.println("---------- AllMatchAnyMatch Start -----------");
        AllMatchAnyMatch allMatchAnyMatch = new AllMatchAnyMatch();
        allMatchAnyMatch.testAllMatchAnyMatch();
        System.out.println("---------- AllMatchAnyMatch End -----------");

        System.out.println("---------- FindFirstFindAny Start -----------");
        FindFirstFindAny findFirstFindAny = new FindFirstFindAny();
        findFirstFindAny.testFindFirstFindAny();
        System.out.println("---------- FindFirstFindAny End -----------");

        System.out.println("---------- Reduce Start -----------");
        Reduce reduce = new Reduce();
        reduce.testReduce();
        System.out.println("---------- Reduce End -----------");

        System.out.println("---------- Collectors Start -----------");
        CollectorsTest collectorsTest = new CollectorsTest();
        collectorsTest.testCollectors();
        System.out.println("---------- Collectors End -----------");

        System.out.println("---------- ToMap Start -----------");
        ToMap toMap = new ToMap();
        toMap.testToMap();
        System.out.println("---------- ToMap End -----------");

        System.out.println("---------- GroupingBy Start -----------");
        GroupingBy groupingBy = new GroupingBy();
        groupingBy.testGroupingBy();
        System.out.println("---------- GroupingBy End -----------");

        System.out.println("---------- PartitioningBy Start -----------");
        PartitioningBy partitioningBy = new PartitioningBy();
        partitioningBy.testPartitioningBy();
        System.out.println("---------- PartitioningBy End -----------");

        System.out.println("---------- ForEach Start -----------");
        ForEach forEach = new ForEach();
        forEach.testForEach();
        System.out.println("---------- ForEach End -----------");

        System.out.println("---------- ParallelStream Start -----------");
        ParallelStream parallelStream = new ParallelStream();
        parallelStream.testParallelStream();
        System.out.println("---------- ParallelStream End -----------");

        System.out.println("---------- ScopeClosureCurry Start -----------");
        ScopeClosureCurry scopeClosureCurry = new ScopeClosureCurry();
        scopeClosureCurry.testScopeClosureCurry();
        System.out.println("---------- ScopeClosureCurry End -----------");

        System.out.println("---------- LazyEvaluation Start -----------");
        LazyEvaluation lazyEvaluation = new LazyEvaluation();
        lazyEvaluation.testLazyEvaluation();
        System.out.println("---------- LazyEvaluation End -----------");

        System.out.println("---------- FunctionComposition Start -----------");
        FunctionComposition functionComposition = new FunctionComposition();
        functionComposition.testFunctionComposition();
        System.out.println("---------- FunctionComposition End -----------");
    }
}