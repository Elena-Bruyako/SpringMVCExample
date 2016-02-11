package com.bruyako;

import com.bruyako.converter.EntityDtoConverter;
import com.bruyako.entity.Goods;
import com.bruyako.impl.GoodsDaoImpl;
import com.bruyako.impl.MarketServiceImpl;
import com.bruyako.model.GoodsDto;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import java.util.List;
import java.util.Objects;

/**
 * Created by brunyatko on 04.02.16.
 */
public class MarketServiceTest {

    GoodsDaoImpl goodsDao = mock(GoodsDaoImpl.class);
    MarketServiceImpl service = new MarketServiceImpl();

    GoodsDto goodsDto1 = new GoodsDto();
    GoodsDto goodsDto2 = new GoodsDto();
    GoodsDto goodsDto3 = new GoodsDto();

    @Before
    public void init() throws Exception {

        service.setDao(goodsDao);
        goodsDto1 = initDto(7L, "Xiaomi", 150);
        goodsDto2 = initDto(8L, "OneToOne", 200);
        goodsDto3 = initDto(9L, "BlackBerry", 360);
    }

    @Test
    public void testGetAllGoods() throws Exception {

        List<Goods> goodsList = new ArrayList<>();

        goodsList.add(EntityDtoConverter.convert(goodsDto1));
        goodsList.add(EntityDtoConverter.convert(goodsDto2));
        goodsList.add(EntityDtoConverter.convert(goodsDto3));

        when(goodsDao.getAll()).thenReturn(goodsList);

        List<GoodsDto> result = service.getAll();

        verify(goodsDao, times(1)).getAll();

        int counter = result.size();
        assertEquals(3, counter);
    }

    @Test
    public void testGetByFilter() throws Exception {

        int priceFrom = 200;
        int priceTo = 400;
        String name = "a";
        List<Goods> goodsList = new ArrayList<>();
        goodsList.add(EntityDtoConverter.convert(goodsDto3));
        when(goodsDao.getByFilter(priceFrom, priceTo, name)).thenReturn(goodsList);

        List<GoodsDto> result = service.getByFilter(priceFrom, priceTo, name);
        verify(goodsDao, times(1)).getByFilter(priceFrom, priceTo, name);
        int counter = result.size();
        assertEquals(1, counter);
    }

    @Test
    public void testCreate() throws Exception {

        service.create(goodsDto1);
        verify(goodsDao, times(1)).create(EntityDtoConverter.convert(goodsDto1));
    }

    @Test
    public void testDeleteById() throws Exception {

        long id = 7L;
        service.deleteById(id);
        verify(goodsDao, times(1)).deleteById(id);
    }

    @Test
    public void testUpdate() throws Exception {

        service.update(goodsDto1);
        verify(goodsDao, times(1)).update(EntityDtoConverter.convert(goodsDto1));
    }

    private GoodsDto initDto(long id, String name, int price) {

        GoodsDto goodsDto = new GoodsDto();
        goodsDto.setGoodId(id);
        goodsDto.setName(name);
        goodsDto.setPrice(price);
        return goodsDto;
    }

}
