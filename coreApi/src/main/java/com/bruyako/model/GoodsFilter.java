package com.bruyako.model;

import java.math.BigDecimal;

/**
 * Created by brunyatko on 04.02.16.
 */
public class GoodsFilter {

    private BigDecimal priceFrom;
    private BigDecimal priceTo;

    public BigDecimal getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(BigDecimal priceFrom) {
        this.priceFrom = priceFrom;
    }

    public BigDecimal getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(BigDecimal priceTo) {
        this.priceTo = priceTo;
    }

    @Override
    public String toString() {
        return "GoodsFilter{" +
                "priceFrom=" + priceFrom +
                ", priceTo=" + priceTo +
                '}';
    }
}
