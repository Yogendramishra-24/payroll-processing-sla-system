package com.company.payroll.Factory;

import com.company.payroll.strategy.ContractSalaryStrategy;
import com.company.payroll.strategy.FullTimeSalaryStrategy;
import com.company.payroll.strategy.SalaryCalculationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SalaryStrategyFactory {
    @Autowired
    private FullTimeSalaryStrategy fullTime;
    @Autowired
    private ContractSalaryStrategy contract;
    public SalaryCalculationStrategy getStrategy(String type) {
    if(type.equals("FULL_TIME")) return fullTime;
    return contract;
    }
}
