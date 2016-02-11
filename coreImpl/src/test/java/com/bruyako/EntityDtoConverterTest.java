package com.bruyako;

import com.bruyako.converter.EntityDtoConverter;
import com.bruyako.entity.Goods;
import com.bruyako.model.GoodsDto;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by brunyatko on 10.02.16.
 */
public class EntityDtoConverterTest {

    Goods goods1 = new Goods();
    Goods goods2 = new Goods();
    Goods goods3 = new Goods();

    GoodsDto goodsDto1 = new GoodsDto();
    GoodsDto goodsDto2 = new GoodsDto();
    GoodsDto goodsDto3 = new GoodsDto();

    @Before
    public void init() throws Exception {

        goods1 = initDao(7L, "Xiaomi", 150);
        goods2 = initDao(8L, "OneToOne", 200);
        goods3 = initDao(9L, "BlackBerry", 360);

        goodsDto1 = initDto(7L, "Xiaomi", 150);
        goodsDto2 = initDto(8L, "OneToOne", 200);
        goodsDto3 = initDto(9L, "BlackBerry", 360);
    }

    @Test
    public void testConvertToDao() throws Exception  {

        assertEquals(goods1, EntityDtoConverter.convert(goodsDto1));
        assertEquals(goodsDto1, EntityDtoConverter.convert(goods1));
    }

    @Test
    public void testConvertToDto() throws Exception  {

        assertEquals(goods2, EntityDtoConverter.convert(goodsDto2));
        assertEquals(goodsDto2, EntityDtoConverter.convert(goodsDto2));
    }

    private GoodsDto initDto(long id, String name, int price) {

        GoodsDto goodsDto = new GoodsDto();
        goodsDto.setGoodId(id);
        goodsDto.setName(name);
        goodsDto.setPrice(price);
        return goodsDto;
    }

    private Goods initDao(long id, String name, int price) {

        Goods goods = new Goods();
        goods.setGoodId(id);
        goods.setName(name);
        goods.setPrice(price);
        return goods;
    }
}
