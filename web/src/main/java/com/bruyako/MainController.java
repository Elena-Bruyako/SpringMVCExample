package com.bruyako;

import com.bruyako.model.GoodsDto;
import com.bruyako.model.GoodsFilter;
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

    @RequestMapping(value = "/addNewGoods", method = RequestMethod.POST)
    public @ResponseBody List<GoodsDto> addNewGoods(@RequestBody GoodsDto goodsDto) {

        service.create(goodsDto);

        return service.getAll();
    }

    @RequestMapping(value = "/delete/{good_id}",  method = RequestMethod.GET)
    public String deleteGoods(@PathVariable("good_id") int good_id, Model model) {

        service.delete(good_id);
        model.addAttribute("allGoods", service.getAll());

        return "redirect:/market";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public @ResponseBody List<GoodsDto> update(@RequestBody GoodsDto goodsDto){

        service.update(goodsDto);

        return service.getAll();
    }

}
