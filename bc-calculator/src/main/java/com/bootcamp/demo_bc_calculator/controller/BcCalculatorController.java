package com.bootcamp.demo_bc_calculator.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo_bc_calculator.service.BcCalculatorService;


@RestController //RestController = Controller + ResponseBody
public class BcCalculatorController {

    @Autowired
    private BcCalculatorService bcCalculatorService;

    // if i use @RequestParam is the same
    // http://localhost:8082/operation?operation=SUM&x=1&y=2
    // @GetMapping(value = "/operation")
    // public Double createCalculation(@RequestParam String operation, 
    //                                 @RequestParam String x, 
    //                                 @RequestParam String y)


    // http://localhost:8082/operation/SUM?x=1&y=2
    // this is pathVariable {SUM}
    @GetMapping(value = "/operation/{operation}")
    public Double createCalculation(@PathVariable String operation, 
                                    @RequestParam String x, 
                                    @RequestParam String y) {

            this.bcCalculatorService.validateOperation(operation);
            this.bcCalculatorService.validateParam(x, y);

            return this.bcCalculatorService.operate(operation, x , y);
    }

    
}
