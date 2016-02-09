package com.bruyako.model;


/**
 * Created by brunyatko on 04.02.16.
 */
public class GoodsFilterDto {

    private int priceFrom;
    private int priceTo;
    private String name;

    public int getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(int priceFrom) {
        this.priceFrom = priceFrom;
    }

    public int getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(int priceTo) {
        this.priceTo = priceTo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "GoodsFilter{" +
                "priceFrom=" + priceFrom +
                ", priceTo=" + priceTo +
                '}';
    }
}
