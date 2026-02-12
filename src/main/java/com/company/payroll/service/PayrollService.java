package com.company.payroll.service;

import com.company.payroll.Factory.SalaryStrategyFactory;
import com.company.payroll.Observer.PayrollObserver;
import com.company.payroll.entity.Employee;
import com.company.payroll.entity.Payroll;
import com.company.payroll.repository.EmployeeRepository;
import com.company.payroll.repository.PayrollRepository;
import com.company.payroll.strategy.SalaryCalculationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PayrollService {

    @Autowired
    private EmployeeRepository employeeRepo;

    @Autowired
    private PayrollRepository payrollRepo;

    @Autowired
    private SalaryStrategyFactory factory;

    @Autowired
    private List<PayrollObserver> observers;

    public Payroll processPayroll(Long employeeId) {

        Employee employee = employeeRepo.findById(employeeId).orElseThrow();

        SalaryCalculationStrategy strategy =
                factory.getStrategy(employee.getType());

        double amount = strategy.calculateSalary(employee);

        Payroll payroll = new Payroll();
        payroll.setEmployeeId(employeeId);
        payroll.setAmount(amount);
        payroll.setStatus("SUCCESS");
        payroll.setSlaDeadline(LocalDateTime.now().plusMinutes(30));

        payrollRepo.save(payroll);

        if(payroll.getStatus().equals("FAILED")){
            observers.forEach(o -> o.notify(payroll));
        }

        return payroll;
    }
}

