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

    @Before
    public void init() throws Exception {

        service.setDao(goodsDao);

        goodsDto1.setGoodId(7);
        goodsDto1.setName("Xiaomi");
        goodsDto1.setPrice(150);

        goodsDto2.setGoodId(8);
        goodsDto2.setName("OneToOne");
        goodsDto2.setPrice(200);

        goodsDto3.setGoodId(9);
        goodsDto3.setName("BlackBerry");
        goodsDto3.setPrice(200);
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

        int counter = 0;
        for (GoodsDto goodsDto : result) {
            counter++;
        }
        assertEquals(3, counter);
    }

    @Test
    public void testCreate() throws Exception {

        service.create(goodsDto1);
        verify(goodsDao, times(1)).create(EntityDtoConverter.convert(goodsDto1));
    }

    @Test
    public void testDeleteById() throws Exception {

        service.deleteById(1);
        verify(goodsDao, times(1)).deleteById(1);
    }

    @Test
    public void testUpdate() throws Exception {

        service.update(goodsDto1);
        verify(goodsDao, times(1)).update(EntityDtoConverter.convert(goodsDto1));
    }
}
