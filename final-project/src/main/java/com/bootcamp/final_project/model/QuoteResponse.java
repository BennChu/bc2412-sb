package com.bootcamp.final_project.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QuoteResponse {

     private String quoteResponse;
     private List<Result> result;

     @AllArgsConstructor
     @Getter
     public static class Result {
        private String language;
        private String region;
        private String quoteType;
        private String typeDisp;
        private String quoteSourceName;
        private Boolean triggerable;
        private String customPriceAlertConfidence;
        private String currency;
        private String shortName;
        private String LongName;
        private String marketState;
        private Boolean tradeable;
        private Boolean cryptoTradeable;
        private Double regularMarketChangePercent;
        private Double regularMarketPrice;
        private List<CorporationActions> corporateActions;
        private Long regularMarketTime;
        private String exchange;
        private String messageBoardId;
        private String exchangeTimezoneName;
        private String exchangeTimezoneShortName;
        private Long gmtOffSetMilliseconds;
        private String market;
        private boolean esgPopulated;
        private Integer priceHint;
        private Double regularMarketChange;
        private Double regularMarketDayHigh;
        private String regularMarketDayRange;
        private Double regularMarketDayLow;
        private Long regularMarketVolume;
        private Double regularMarketPreviousClose;
        private Double bid;
        private Double ask;
        private Integer bidSize;
        private Integer askSize;
        private String fullExchangeName;
        private String financialCurrency;
        private Double regularMarketOpen;
        private Long averageDailyVolume3Month;
        private Long averageDailyVolume10Day;
        private Double fiftyTwoWeekLowChange;
        private Double fiftyTwoWeekLowChangePercent;
        private String fiftyTwoWeekRange;
        private Double fiftyTwoWeekHighChange;
        private Double fiftyTwoWeekHighChangePercent;
        private Double fiftyTwoWeekLow;
        private Double fiftyTwoWeekHigh;
        private Double fiftyTwoWeekChangePercent;
        private Long earningsTimestamp;
        private Long earningsTimestampStart;
        private Long earningsTimestampEnd;
        private Long earningsCallTimestampStart;
        private Long earningsCallTimestampEnd;
        private boolean isEarningsDateEstimate;
        private Double trailingAnnualDividendRate;
        private Double trailingPE;
        private Double dividendRate;
        private Double trailingAnnualDividendYield;
        private Double dividendYield;
        private Double epsTrailingTwelveMonths;
        private Double epsForward;
        private Double epsCurrentYear;
        private Double priceEpsCurrentYear;
        private Long sharesOutstanding;
        private Double bookValue;
        private Double fiftyDayAverage;
        private Double fiftyDayAverageChange;
        private Double fiftyDayAverageChangePercent;
        private Double twoHundredDayAverage;
        private Double twoHundredDayAverageChange;
        private Double twoHundredDayAverageChangePercent;
        private Long marketCap;
        private Double forwardPE;
        private Double priceToBook;
        private Integer sourceInterval;
        private Integer exchangeDataDelayedBy;
        private String averageAnalystRating;
        private boolean hasPrePostMarketData;
        private Long firstTradeDateMilliseconds;
        private String symbol;

        @Getter
        @AllArgsConstructor
        public static class CorporationActions {
            private String header;
            private String message;
            private Meta meta;

            @Getter
            @AllArgsConstructor
            public static class Meta{
                private String eventType;
                private Long dateEpochMs;
                private String amount;
            }
        }
     }
}
