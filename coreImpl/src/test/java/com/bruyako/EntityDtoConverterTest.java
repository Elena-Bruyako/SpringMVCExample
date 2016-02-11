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

    Goods goods = new Goods();
    GoodsDto goodsDto = new GoodsDto();

    @Before
    public void init() throws Exception {

        goods = initDao(7L, "Xiaomi", 150);
        goodsDto = initDto(7L, "Xiaomi", 150);
    }

    @Test
    public void testConvertToDao() throws Exception  {
        assertEquals(goods, EntityDtoConverter.convert(goodsDto));
    }

    @Test
    public void testConvertToDto() throws Exception  {
        assertEquals(goodsDto, EntityDtoConverter.convert(goods));
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
