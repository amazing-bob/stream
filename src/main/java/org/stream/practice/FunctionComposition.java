package org.stream.practice;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import org.stream.practice.model.Order;
import org.stream.practice.model.OrderLine;
import org.stream.practice.priceprocessor.OrderLIneAggregationPriceProcessor;
import org.stream.practice.priceprocessor.TaxPriceProcessor;

public class FunctionComposition {
    public void testFunctionComposition() {
        Function<Integer, Integer> multiplyByTwo = x -> 2 * x;
        Function<Integer, Integer> addTen =  x -> x +10;

        Function<Integer, Integer> composedFunction = multiplyByTwo.andThen(addTen);
        int composedResult = composedFunction.apply(3);
        System.out.println(composedResult);

        Function<Integer, Integer> composedFunction2 = multiplyByTwo.compose(addTen);
        int composedResult2 = composedFunction2.apply(3);
        System.out.println(composedResult2);

        Order unprocessedOrder = new Order()
                .setId(1001L)
                .setOrderLines(Arrays.asList(
                        new OrderLine(). setAmount(BigDecimal.valueOf(1000)),
                        new OrderLine(). setAmount(BigDecimal.valueOf(2000))
                ));

        List<Function<Order, Order>> priceProcessors = getPriceProcessors(unprocessedOrder);

        Function<Order, Order> mergedPriceProcessors = priceProcessors.stream()
//                .reduce(Function.identity(), (priceProcessor1, priceProcessor2) -> priceProcessor1.andThen(priceProcessor2));
                .reduce(Function.identity(), Function::andThen);
        Order processedOrder = mergedPriceProcessors.apply(unprocessedOrder);
        System.out.println(processedOrder);

    }

    public List<Function<Order, Order>> getPriceProcessors(Order order) {
        return Arrays.asList(new OrderLIneAggregationPriceProcessor(),
                new TaxPriceProcessor(new BigDecimal("9.375")));
    }
}
