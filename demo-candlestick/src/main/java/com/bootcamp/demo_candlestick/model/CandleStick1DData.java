package com.bootcamp.demo_candlestick.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CandleStick1DData {
    private Long time;
    private Integer open;
    private Integer high;
    private Integer low;
    private Integer close;
    
}
