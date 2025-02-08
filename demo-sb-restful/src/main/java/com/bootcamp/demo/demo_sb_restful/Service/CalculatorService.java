package com.bootcamp.demo.demo_sb_restful.Service;

import org.springframework.stereotype.Service;
import com.bootcamp.demo.demo_sb_restful.exception.BusinessException;
import com.bootcamp.demo.demo_sb_restful.model.Operation;

@Service
public class CalculatorService {

    // spring boot use Wrapper class
    public Integer operate(Operation operation, Integer x, Integer y) {
        int result = switch (operation) {
            case SUM -> sum (x, y);
            case SUBTRACT -> subtract (x, y);
            case MULTIPLY -> multiply (x, y);
            case DIVIDE -> divide (x, y);
        };
        // 想 test 下 throw exception 會唔會去到呢度
        System.out.println("operate(): result=" + result);
        return result;
    }

    private Integer sum(Integer x, Integer y) {
        return x + y;
      }
    
    private Integer subtract(Integer x, Integer y) {
        return x - y;
      }
    
      private Integer multiply(Integer x, Integer y) {
        return x * y;
      }    

      private Integer divide(Integer x, Integer y) {
            // 想 test 下 throw exception 會唔會去到呢度
            System.out.println("divide()");
            if (y == 0)
            throw new BusinessException(
                "CalculatorService.divide() / zero." + "x=" + x + ",y=" + y);
            return x / y;
      }
    



    // spring boot has GlobalExceptionHandle
    //if (y = 0)
    // throw new BusinessException ...
    // throw 唔同既 exception, 咁可以知道 where 有問題


}
