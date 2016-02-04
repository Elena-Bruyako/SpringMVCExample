package com.bruyako.converter;

import com.bruyako.entity.Good;
import com.bruyako.model.GoodDto;

/**
 * Created by brunyatko on 03.02.16.
 */
public class EntityDtoConverter {

    private EntityDtoConverter() {
    }

    public static Good convert(GoodDto goodDto) {

        if (goodDto == null) {
            return null;
        }
        Good good = new Good();
        good.setGood_id(goodDto.getGood_id());
        good.setName(goodDto.getName());
        good.setPrice(goodDto.getPrice());
        return good;
    }

    public static GoodDto convert(Good good) {

        if (good == null) {
            return null;
        }

        GoodDto goodDto = new GoodDto();
        goodDto.setGood_id(good.getGood_id());
        goodDto.setName(good.getName());
        goodDto.setPrice(good.getPrice());

        return goodDto;
    }
}
