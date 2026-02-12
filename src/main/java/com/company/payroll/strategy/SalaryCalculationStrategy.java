package com.company.payroll.strategy;

import com.company.payroll.entity.Employee;

public interface SalaryCalculationStrategy {
    double calculateSalary(Employee employee);
}
