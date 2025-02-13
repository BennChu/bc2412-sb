package com.bootcamp.demo_bc_calculator.service;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;
import com.bootcamp.demo_bc_calculator.codewave.BusinessException;
import com.bootcamp.demo_bc_calculator.codewave.SysCode;
import com.bootcamp.demo_bc_calculator.exception.OperationException;
import com.bootcamp.demo_bc_calculator.model.Operation;

@Service
public class BcCalculatorService {

    private Double x;
    private Double y;

    public void validateOperation(String operation) {
        if (!(operation.equals(Operation.SUM.getValue())                        //
                    || operation.equals(Operation.SUBTRACT.getValue())          //
                    || operation.equals(Operation.MULTIPLY.getValue())          //
                    || operation.equals(Operation.DIVIDE.getValue()))) {        //
            OperationException.of(SysCode.INVILID_OPERATOR);
        }
   }       

   public void validateParam(String x1, String y1) {
        Double.parseDouble(x1);
        Double.parseDouble(y1);
   }

   public Double operate(String x1, String y1, String operation) {
        x = Double.parseDouble(x1);
        y = Double.parseDouble(y1);
    
        Double result = switch (operation) {
                         case "SUM" -> sum(x, y);
                         case "SUBTRACT" -> subtract(x, y);
                         case "MULTIPLY" -> mulitply(x, y);
                         case "DIVIDE" -> divide(x, y);
                         default -> throw new IllegalStateException();
        };
        return result;
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
