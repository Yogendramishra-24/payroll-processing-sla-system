package com.company.payroll.controller;

import com.company.payroll.entity.Payroll;
import com.company.payroll.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payroll")
public class PayrollController {
    @Autowired
    private PayrollService payrollService;

    @PostMapping("/process/{employeeId}")
    public Payroll process(@PathVariable Long employeeId){
        return payrollService.processPayroll(employeeId);
    }
}
