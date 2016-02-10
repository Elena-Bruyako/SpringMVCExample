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

        goods1.setGoodId(7L);
        goods1.setName("Xiaomi");
        goods1.setPrice(150);

        goods2.setGoodId(8L);
        goods2.setName("OneToOne");
        goods2.setPrice(200);

        goods3.setGoodId(9L);
        goods3.setName("BlackBerry");
        goods3.setPrice(200);

        goodsDto1.setGoodId(7L);
        goodsDto1.setName("Xiaomi");
        goodsDto1.setPrice(150);

        goodsDto2.setGoodId(8L);
        goodsDto2.setName("OneToOne");
        goodsDto2.setPrice(200);

        goodsDto3.setGoodId(9L);
        goodsDto3.setName("BlackBerry");
        goodsDto3.setPrice(200);
    }

    @Test
    public void testConvert() throws Exception  {

        EntityDtoConverter converter = new EntityDtoConverter();

        assertEquals(goods1, converter.convert(goodsDto1));
        assertEquals(goods2, converter.convert(goodsDto2));
        assertEquals(goodsDto2, converter.convert(goods2));
        assertEquals(goodsDto1, converter.convert(goods1));
    }
}
