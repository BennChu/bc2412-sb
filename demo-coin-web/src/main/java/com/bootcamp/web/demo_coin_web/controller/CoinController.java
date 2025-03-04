package com.bootcamp.web.demo_coin_web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp.web.demo_coin_web.Service.CoinDataService;
import com.bootcamp.web.demo_coin_web.dto.CoinDataDto;
import com.bootcamp.web.demo_coin_web.model.CoinData;



@Controller
public class CoinController {
    @Autowired
    private CoinDataService coinDataService;

    // http://localhost:8081/coins
    @GetMapping(value = "/coins")
    public String displayExternalData(Model model) { // spring.framework.ui
        List<CoinData> coinDataList = coinDataService.fetchCoinData();
        model.addAttribute("coinList", coinDataList);
        return "coin"; // html file name Thymeleaf template name
    }

    // http://localhost:8081/coin-data
    @GetMapping(value = "/coin-data")
    public String displayCoinSnapData(Model model) { // spring.framework.ui
        List<CoinDataDto> coinSnapDataList = coinDataService.fetchCoinSnapData();
        model.addAttribute("coinSnapList", coinSnapDataList);
        return "coin-data"; // html file name Thymeleaf template name
    }
    
}
