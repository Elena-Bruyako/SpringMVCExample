package com.bruyako;

import com.bruyako.converter.EntityDtoConverter;
import com.bruyako.entity.Goods;
import com.bruyako.impl.GoodsDaoImpl;
import com.bruyako.impl.MarketServiceImpl;
import com.bruyako.model.GoodsDto;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
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

    GoodsDto goodsDto1;
    GoodsDto goodsDto2;
    GoodsDto goodsDto3;

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

    @Test
    public void testGetByFilterAllParams() throws Exception {

        List<Goods> goodsFilterList = new ArrayList<Goods>();
        goodsFilterList.add(initDao(7L, "Xiaomi", 200));
        goodsFilterList.add(initDao(8L, "OneToOne", 300));
        when(goodsDao.getByFilter(200, 300, "o")).thenReturn(goodsFilterList);

        List<GoodsDto> filterResult = service.getByFilter(200, 300, "o");
        isSameContent(goodsFilterList, filterResult);
    }

    @Test
    public void testGetByFilterMinPrice() throws Exception {

        List<Goods> goodsFilterList = new ArrayList<Goods>();
        goodsFilterList.add(initDao(7L, "Xiaomi", 200));
        when(goodsDao.getByFilter(200, 0, null)).thenReturn(goodsFilterList);

        List<GoodsDto> filterResult = service.getByFilter(200, 0, null);
        isSameContent(goodsFilterList, filterResult);
    }

    @Test
    public void testGetByFilterMaxPrice() throws Exception {

        List<Goods> goodsFilterList = new ArrayList<Goods>();
        goodsFilterList.add(initDao(7L, "Xiaomi", 200));
        when(goodsDao.getByFilter(0, 200, null)).thenReturn(goodsFilterList);

        List<GoodsDto> filterResult = service.getByFilter(0, 200, null);
        isSameContent(goodsFilterList, filterResult);
    }

    @Test
    public void testGetByFilterName() throws Exception {

        List<Goods> goodsFilterList = new ArrayList<Goods>();
        goodsFilterList.add(initDao(7L, "Xiaomi", 200));
        when(goodsDao.getByFilter(0, 0, "Xi")).thenReturn(goodsFilterList);

        List<GoodsDto> filterResult = service.getByFilter(0, 0, "Xi");
        isSameContent(goodsFilterList, filterResult);
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

    private void isSameContent(List<Goods> goodsDao,  List<GoodsDto> goodsDto){
        assertTrue(goodsDao.size() == goodsDto.size());

        for(int i = 0; i < goodsDao.size(); i++){
            assertEquals(goodsDto.get(i).getGoodId(), goodsDao.get(i).getGoodId());
            assertEquals(goodsDto.get(i).getName(), goodsDao.get(i).getName());
            assertEquals(goodsDto.get(i).getPrice(), goodsDao.get(i).getPrice());
        }
    }
}
