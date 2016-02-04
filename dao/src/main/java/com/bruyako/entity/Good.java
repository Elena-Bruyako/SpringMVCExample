package com.bruyako.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by brunyatko on 03.02.16.
 */
@Entity
@Table(name = "Good")
public class Good {

    @Id
    @Column(name = "Good_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int good_id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Price")
    private BigDecimal price;

    public Good() {
    }

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
        if (!(o instanceof Good)) return false;

        Good good = (Good) o;

        if (good_id != good.good_id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return good_id;
    }

    @Override
    public String toString() {
        return "Good{" +
                "good_id=" + good_id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
