package org.stream.designpattern;

import org.stream.designpattern.model.Price;
import org.stream.designpattern.service.BasigPriceProcessor;
import org.stream.designpattern.service.DiscountPriceProcessor;
import org.stream.designpattern.service.PriceProcessor;
import org.stream.designpattern.service.TaxPriceProcessor;

public class DecoratorPattern {
    public void testDecoratorPattern() {
        Price unprocessPrice = new Price("Original Price");

        PriceProcessor basigPriceProcessor = new BasigPriceProcessor();
        PriceProcessor discountPriceProcessor = new DiscountPriceProcessor();
        PriceProcessor taxPriceProcessor = new TaxPriceProcessor();

        PriceProcessor decoratedPriceProcessor = basigPriceProcessor
                .andThen(discountPriceProcessor)
                .andThen(taxPriceProcessor);
        Price processedPrice = decoratedPriceProcessor.process(unprocessPrice);
        System.out.println(processedPrice.getPrice());

        PriceProcessor decoratedPriceProcessor2 = basigPriceProcessor
                .andThen(taxPriceProcessor)
                .andThen(price -> new Price(price.getPrice() + ", then apply another procedure"));
        Price processedPrice2 = decoratedPriceProcessor2.process(unprocessPrice);
        System.out.println(processedPrice2.getPrice());
    }
}
