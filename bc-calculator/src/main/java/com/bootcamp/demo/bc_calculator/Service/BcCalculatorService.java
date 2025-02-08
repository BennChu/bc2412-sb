package com.bootcamp.demo.bc_calculator.Service;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;
import com.bootcamp.demo.bc_calculator.Exception.BusinessException;

@Service
public class BcCalculatorService {

    private Double x;
    private Double y;

    public void checkOperation(String operation) {
        if (!(operation.equals(Operation.SUM.getValue()) || operation.equals(Operation.SUBTRACT.getValue())
                                    || operation.equals(Operation.MULTIPLY.getValue())
                                    || operation.equals(Operation.DIVIDE.getValue()))) {
            throw new BusinessException("Invilid operation");
        }
   }       

   public void checkParam(String x1, String y1) {
        Double.parseDouble(x1);
        Double.parseDouble(y1);
   }

   public Double operate(String x1, String y1, String operation) {
        x = Double.parseDouble(x1);
        y = Double.parseDouble(y1);
    
        switch (operation) {
            case "SUM" -> sum(x, y);
            case "SUBTRACT" -> subtract(x, y);
            case "MULTIPLY" -> mulitply(x, y);
            case "DIVIDE" -> divide(x, y);
        };
        return 0.0;
   }

   public Double sum(Double x, Double y) {
        return BigDecimal.valueOf(x).add(BigDecimal.valueOf(y)).doubleValue();
   }

   public Double subtract(Double x, Double y) {
        return BigDecimal.valueOf(x).subtract(BigDecimal.valueOf(y)).doubleValue();
   }

   public Double mulitply(Double x, Double y) {
        return BigDecimal.valueOf(x).multiply(BigDecimal.valueOf(y)).doubleValue();
   }

   public Double divide(Double x, Double y) {
        return BigDecimal.valueOf(x).divide(BigDecimal.valueOf(y)).doubleValue();
   }
}
