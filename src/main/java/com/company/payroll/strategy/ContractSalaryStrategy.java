package com.company.payroll.strategy;

import com.company.payroll.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class ContractSalaryStrategy implements SalaryCalculationStrategy{
    @Override
    public double calculateSalary(Employee e) {

        return e.getSalary()*0.9;
    }
}
