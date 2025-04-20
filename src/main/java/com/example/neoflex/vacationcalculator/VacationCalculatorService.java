package com.example.neoflex.vacationcalculator;

import com.example.neoflex.exceptions.InvalidInputException;
import org.springframework.stereotype.Service;

@Service
public class VacationCalculatorService {

    public double calculacteVacationPay(double averageSalary, int vacationDays) {
        if (averageSalary < 0 || averageSalary > 100_000_000) {
            throw new InvalidInputException("Average salary must be between 0 and 100.000.000");
        }
        if (vacationDays < 0 || vacationDays > 28) {
            throw new InvalidInputException("Vacation days must be between 0 and 28");
        }
        return averageSalary * vacationDays;
    }

}
