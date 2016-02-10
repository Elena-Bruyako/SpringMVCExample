package com.bruyako.entity;

import javax.persistence.*;

/**
 * Created by brunyatko on 03.02.16.
 */
@Entity
@Table(name = "Goods")
public class Goods {

    @Id
    @Column(name = "Good_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int goodId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Price")
    private int price;

    public Goods() {
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Goods)) return false;

        Goods goods = (Goods) o;

        if (price != goods.price) return false;
        if (name != null ? !name.equals(goods.name) : goods.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + price;
        return result;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodId=" + goodId +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
