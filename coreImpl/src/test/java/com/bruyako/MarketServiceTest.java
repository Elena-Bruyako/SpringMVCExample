package com.bruyako;

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

    GoodsDaoImpl goodsDaoImpl;
    MarketServiceImpl service;

    GoodsDto goodsDtoOne = new GoodsDto();
    GoodsDto goodsDtoTwo = new GoodsDto();
    GoodsDto goodsDtoThree = new GoodsDto();

    @Before
    public void init() throws Exception {

        goodsDaoImpl = mock(GoodsDaoImpl.class);
        service = new MarketServiceImpl();
        service.setDao(goodsDaoImpl);

        goodsDtoOne.setGood_id(7);
        goodsDtoOne.setName("Xiaomi");
        goodsDtoOne.setPrice(150);

        goodsDtoTwo.setGood_id(8);
        goodsDtoTwo.setName("OneToOne");
        goodsDtoTwo.setPrice(200);

        goodsDtoThree.setGood_id(9);
        goodsDtoThree.setName("BlackBerry");
        goodsDtoThree.setPrice(200);
    }

    @Test
    public void testGetAllGoods() throws Exception {

        List<GoodsDto> goodsList = new ArrayList<>();

        goodsList.add(goodsDtoOne);
        goodsList.add(goodsDtoTwo);
        goodsList.add(goodsDtoThree);

        when(goodsDaoImpl.getAll()).thenReturn(goodsList);

        List<GoodsDto> result = service.getAll();

        verify(goodsDaoImpl, times(1)).getAll();

        int counter = 0;
        for (GoodsDto goodsDto : result) {
            counter++;
        }
        assertEquals(3, counter);
    }

    @Test
    public void testCreate() throws Exception {

        service.create(goodsDtoOne);
        verify(goodsDaoImpl, times(1)).create(goodsDtoOne);
    }

    @Test
    public void testDelete() throws Exception {

        service.delete(1);
        verify(goodsDaoImpl, times(1)).delete(1);
    }

    @Test
    public void testUpdate() throws Exception {

        service.update(goodsDtoOne);
        verify(goodsDaoImpl, times(1)).update(goodsDtoOne);
    }

}
