package com.bruyako;

import com.bruyako.converter.EntityDtoConverter;
import com.bruyako.entity.Goods;
import com.bruyako.model.GoodsDto;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by brunyatko on 10.02.16.
 */
public class EntityDtoConverterTest {

    private static final long id = 7L;
    private static final String name = "Xiaomi";
    private static final int price = 150;

    @Test
    public void testConvertToDao() throws Exception  {

        GoodsDto goodsDto = new GoodsDto();
        goodsDto.setGoodId(id);
        goodsDto.setName(name);
        goodsDto.setPrice(price);

        Goods goods = EntityDtoConverter.convert(goodsDto);

        assertEquals(goodsDto.getGoodId(), goods.getGoodId());
        assertEquals(goodsDto.getName(), goods.getName());
        assertEquals(goodsDto.getPrice(), goods.getPrice());
    }

    @Test
    public void testConvertToDto() throws Exception  {

        Goods goods = new Goods();
        goods.setGoodId(id);
        goods.setName(name);
        goods.setPrice(price);

        GoodsDto goodsDto = EntityDtoConverter.convert(goods);

        assertEquals(goodsDto.getGoodId(), goods.getGoodId());
        assertEquals(goodsDto.getName(), goods.getName());
        assertEquals(goodsDto.getPrice(), goods.getPrice());
    }
}
