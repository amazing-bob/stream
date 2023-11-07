package org.stream.designpattern.service;

import org.stream.designpattern.model.Price;

public class BasigPriceProcessor implements PriceProcessor {
    @Override
    public Price process(Price price) {
        return price;
    }
}
