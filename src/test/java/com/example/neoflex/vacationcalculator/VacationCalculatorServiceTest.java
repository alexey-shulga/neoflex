package com.example.neoflex.vacationcalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.neoflex.exceptions.InvalidInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class VacationCalculatorServiceTest {

    private VacationCalculatorService vcs;

    @BeforeEach
    public void setUp() {
        vcs = new VacationCalculatorService();
    }

    @Test
    public void testOk() {
        double salary = 100_000;
        int days = 28;
        double exp = 95563.14;
        assertEquals(exp, vcs.calculacteVacationPay(salary, days));
    }

    @Test
    public void invalidSalary() {
        double salary = -1000;
        int days = 14;
        assertThrows(InvalidInputException.class, () -> {
            vcs.calculacteVacationPay(salary, days);
        });
    }

    @Test
    public void invalidDays() {
        double salary = 100_000;
        int days = -1;
        assertThrows(InvalidInputException.class, () -> {
            vcs.calculacteVacationPay(salary, days);
        });
    }

}
