package com.bootcamp.demo.demo_sb_yahoo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class YahooFinanceManagerTest {
  @Test
  void testQuoteHKSymbol() {
    String result = new YahooFinanceManager().quote("0388.HK");
    assertEquals("123", result);
  }
}
