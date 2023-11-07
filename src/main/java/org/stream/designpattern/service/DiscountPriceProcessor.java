package org.stream.designpattern.service;

import org.stream.designpattern.model.Price;

public class DiscountPriceProcessor implements PriceProcessor {
    @Override
    public Price process(Price price) {
        return new Price(price.getPrice() + ", this applied discount");
    }
}
