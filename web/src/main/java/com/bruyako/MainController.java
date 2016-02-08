package com.bruyako;

import com.bruyako.model.GoodsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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

    @ResponseBody
    @RequestMapping(value = "/addNewGoods", method = RequestMethod.POST)
    public String addNewGoods(@RequestBody GoodsDto goodsDto) {

        service.create(goodsDto);

        return "market";
    }

}
