package com.bruyako.converter;

import com.bruyako.entity.Goods;
import com.bruyako.model.GoodsDto;

/**
 * Created by brunyatko on 03.02.16.
 */
public final class EntityDtoConverter {

    private EntityDtoConverter() {
    }

    public static Goods convert(GoodsDto goodsDto) {

        if (goodsDto == null) {
            return null;
        }
        Goods goods = new Goods();
        goods.setGoodId(goodsDto.getGoodId());
        goods.setName(goodsDto.getName());
        goods.setPrice(goodsDto.getPrice());
        return goods;
    }

    public static GoodsDto convert(Goods goods) {

        if (goods == null) {
            return null;
        }

        GoodsDto goodsDto = new GoodsDto();
        goodsDto.setGoodId(goods.getGoodId());
        goodsDto.setName(goods.getName());
        goodsDto.setPrice(goods.getPrice());

        return goodsDto;
    }
}
