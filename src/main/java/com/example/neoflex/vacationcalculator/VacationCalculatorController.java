package com.example.neoflex.vacationcalculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("calculacte")
public class VacationCalculatorController {

    VacationCalculatorService vcs;

    public VacationCalculatorController(VacationCalculatorService vcs) {
        this.vcs = vcs;
    }

    @GetMapping
    public double calculateVacationPay(@RequestParam double salary, @RequestParam int days) {
        return vcs.calculacteVacationPay(salary, days);
    }

}
