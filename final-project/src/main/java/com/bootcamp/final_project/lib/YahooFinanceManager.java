package com.bootcamp.final_project.lib;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bootcamp.final_project.model.QuoteResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class YahooFinanceManager {

    // @Autowired
    // private QuoteResponse quoteResponse;

    @Autowired
    RestTemplate restTemplate;



    // public YahooFinanceManager(Integer stockCode) {
    //     this.quoteResponse = getQuoteResponse(stockCode);

    // }


    public String getKey(HttpServletRequest request, HttpServletResponse response) {
        
        Cookie[] cookies = request.getCookies(); // Get all cookies from the request
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                    // Clear the cookie by setting maxAge to 0
                    cookie.setMaxAge(0); // Expires immediately
                    cookie.setPath("/"); // Must match the original path to delete it
                    response.addCookie(cookie); // Send the expired cookie to the browser
            }

        }
        
        
        String url = "https://query1.finance.yahoo.com/v1/test/getcrumb";
        String key = this.restTemplate.getForObject(url, String.class);
        System.out.println("getKey=" + key);
        return key;
    }


    public QuoteResponse getQuoteResponse(Integer stockCode, HttpServletRequest request, HttpServletResponse response) {

        String newStockCode = String.format("%04d", stockCode) + ".HK";

        String key = this.getKey(request, response);
        System.out.println("key=" + key);
        // https://query1.finance.yahoo.com/v7/finance/quote?symbols=0005.HK&crumb=sHTu417bXDW
        // 0005 is stock code
        // key "sHTu417bXDW"
        String quoteUrl = UriComponentsBuilder.newInstance()
                            .scheme("https")
                            .host("query1.finance.yahoo.com")
                            .path("/v7/finance/quote")
                            .queryParam("symbols", newStockCode) // ?symbols=0005.HK
                            .queryParam("crumb", key) // &crumb=sHTu417bXDW
                            .build()
                            .toUriString();

        return this.restTemplate.getForObject(quoteUrl, QuoteResponse.class);
    }


    @GetMapping("/quote/{stockCode}")
    public QuoteResponse getQuote(@PathVariable Integer stockCode, HttpServletRequest request, HttpServletResponse response) {
        return getQuoteResponse(stockCode, request, response);
    }

    
}
