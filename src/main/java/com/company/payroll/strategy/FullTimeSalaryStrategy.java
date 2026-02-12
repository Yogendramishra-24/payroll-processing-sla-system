package com.company.payroll.strategy;

import com.company.payroll.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class FullTimeSalaryStrategy implements SalaryCalculationStrategy{
    @Override
    public double calculateSalary(Employee e) {

        return e.getSalary();
    }
}
