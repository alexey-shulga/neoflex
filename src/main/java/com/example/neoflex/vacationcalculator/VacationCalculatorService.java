package com.example.neoflex.vacationcalculator;

import com.example.neoflex.exceptions.InvalidInputException;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

/**
 * Сервис для рассчета отпускных
 */
@Service
public class VacationCalculatorService {

    private final double COEFFICIENT = 29.3;
    private final int MAX_AVERAGE_SALARY = 100_000_000;
    private final int MAX_VACATION_DAYS = 28;

    /**
     * Возвращает количество отпускных в зависимости от средней зарплаты за 12 месяцев и количества дней отпуска
     * @param averageSalary средняя зарплата за 12 месяцев (средняя месячная зарплата за последний год)
     * @param vacationDays количество дней отпуска
     * @return
     */
    public double calculacteVacationPay(@NonNull double averageSalary, @NonNull int vacationDays) {
        if (averageSalary < 0 || averageSalary > MAX_AVERAGE_SALARY) {
            throw new InvalidInputException("Average salary must be between 0 and 100.000.000");
        }
        if (vacationDays < 0 || vacationDays > MAX_VACATION_DAYS) {
            throw new InvalidInputException("Vacation days must be between 0 and 28");
        }
        return getVacationPay(averageSalary, vacationDays);
    }

    /**
     * Получение отпускных
     * @param salary средняя зарплата за 12 месяцев
     * @param days количество дней отпуска
     * @return
     */
    private double getVacationPay(double salary, int days) {
        double result = getAverageDaySalary(salary) * days;
        result = Math.round(result * 100.0) / 100.0;
        return result;
    }

    /**
     * Получение среднедневной зарплаты
     * @param salary средняя зарплата
     * @return
     */
    private double getAverageDaySalary(double salary) {
        return salary / COEFFICIENT;
    }

}
