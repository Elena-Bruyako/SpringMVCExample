package com.bruyako.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by brunyatko on 03.02.16.
 */
public class GoodsDto implements Serializable {

    private int good_id;
    private String name;
    private BigDecimal price;

    public int getGood_id() {
        return good_id;
    }

    public void setGood_id(int good_id) {
        this.good_id = good_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GoodsDto)) return false;

        GoodsDto goodsDto = (GoodsDto) o;

        if (!name.equals(goodsDto.name)) return false;
        if (!price.equals(goodsDto.price)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + price.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
