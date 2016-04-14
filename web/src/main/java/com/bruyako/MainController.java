package com.bruyako;

import com.bruyako.model.GoodsDto;
import com.bruyako.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by brunyatko on 04.02.16.
 */

@Controller
public class MainController {

    @Autowired
    private MarketService service;

    @RequestMapping(value = "/market", method = RequestMethod.GET)
    public String getMarket(Model model) {

        model.addAttribute("allGoods", service.getAll());
        return "market";
    }

    @RequestMapping(value = "/getByFilter", method = RequestMethod.GET)
    public String getByFilter(@RequestParam("selectPriceFrom") int priceFrom, @RequestParam("selectPriceTo") int priceTo, @RequestParam("selectByName") String name, Model model) {

        List<GoodsDto> filterResult = service.getByFilter(priceFrom, priceTo, name);
        model.addAttribute("allGoods", filterResult);
        return "goodsList";
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getByFilter(Model model) {

        model.addAttribute("allGoods", service.getAll());
        return "goodsList";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addNewGoods(@RequestBody GoodsDto goodsDto, Model model) {

        service.create(goodsDto);
        model.addAttribute("allGoods", service.getAll());
        return "goodsList";
    }

    @RequestMapping(value = "/delete",  method = RequestMethod.POST)
    public String deleteGoods(@RequestBody GoodsDto goodsDto, Model model) {

        service.deleteById(goodsDto.getGoodId());
        model.addAttribute("allGoods", service.getAll());
        return "goodsList";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody GoodsDto goodsDto, Model model) {

        service.update(goodsDto);
        model.addAttribute("allGoods", service.getAll());
        return "goodsList";
    }
}
