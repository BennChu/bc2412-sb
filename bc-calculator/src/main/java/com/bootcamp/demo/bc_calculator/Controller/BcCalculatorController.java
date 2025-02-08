package com.bootcamp.demo.bc_calculator.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import com.bootcamp.demo.Service.BcCalculatorService;
//import com.bootcamp.demo.Service.Operation;
import com.bootcamp.demo.bc_calculator.Service.BcCalculatorService;


@RestController
public class BcCalculatorController {

    @Autowired
    private BcCalculatorService bcCalculatorService;

    // http://localhost:8082/operation/SUM?x=1&y=2
    @GetMapping(value = "/operation/{operation}")
    public Double createCalculation(@PathVariable String operation, 
                                    @RequestParam String x, 
                                    @RequestParam String y) {

            this.bcCalculatorService.checkOperation(operation);
            this.bcCalculatorService.checkParam(x, y);

            return this.bcCalculatorService.operate(operation, x , y);
    }

    
}
