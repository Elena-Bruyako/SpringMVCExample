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

/**
 * Created by brunyatko on 04.02.16.
 */
public class MarketServiceTest {

    GoodsDaoImpl goodsDao = mock(GoodsDaoImpl.class);
    MarketServiceImpl service = new MarketServiceImpl();

    GoodsDto goodsDto1 = new GoodsDto();
    GoodsDto goodsDto2 = new GoodsDto();
    GoodsDto goodsDto3 = new GoodsDto();

    public int priceFrom;
    public int priceTo;
    public String name;

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
        assertEquals(3, result.size());
    }

    @Test
    public void testGetByFilter() throws Exception {

        List<GoodsDto> list1 = new ArrayList<>();
        list1.add(goodsDto1);
        list1.add(goodsDto2);
        list1.add(goodsDto3);

        List<GoodsDto> list2 = new ArrayList<>();
        list2.add(goodsDto2);
        list2.add(goodsDto3);

        List<GoodsDto> list3 = new ArrayList<>();
        list3.add(goodsDto2);
        list3.add(goodsDto3);

        List<GoodsDto> list4 = new ArrayList<>();
        list4.add(goodsDto1);
        list4.add(goodsDto3);

        List<GoodsDto> list5 = new ArrayList<>();
        list5.add(goodsDto1);

        List<GoodsDto> list6 = new ArrayList<>();
        list6.add(goodsDto2);

        List<GoodsDto> list7 = new ArrayList<>();
        list7.add(goodsDto3);

        assertEquals(list1, service.getByFilter(100, 500, null));
        assertEquals(list2, service.getByFilter(0, 200, null));
        assertEquals(list3, service.getByFilter(priceFrom, priceTo, name));
        assertEquals(list4, service.getByFilter(priceFrom, priceTo, name));
        assertEquals(list4, service.getByFilter(priceFrom, priceTo, name));
        assertEquals(list5, service.getByFilter(priceFrom, priceTo, name));
        assertEquals(list6, service.getByFilter(priceFrom, priceTo, name));
        assertEquals(list7, service.getByFilter(priceFrom, priceTo, name));
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
